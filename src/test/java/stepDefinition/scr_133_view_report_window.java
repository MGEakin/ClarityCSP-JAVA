package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.json.JsonObject;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pom.ErrorsPage;
import pom.MenuSubMenuPage;
import pom.ViewReportPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_133_view_report_window {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu; 
	
	ErrorsPage errors;
	
	ViewReportPage viewReport;
	
	@Given("^I navigate to the View Report Window Page$")
	public void i_navigate_to_the_View_Report_Window_Page() throws Throwable {
	
		errors = new ErrorsPage(driver);
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());
		viewReport = new ViewReportPage(driver) ;
		Thread.sleep(4000);
		WebElement errorLinktd =  viewReport.getErrorLink();
		System.out.println(" ****** "+errorLinktd.getText());
		errorLinktd.findElement(By.tagName("a")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("VIEW REPORT")).click();
		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
		//BrowserInteractions.clickWhenElementVisible(driver,viewReport.getViewReportButton());
		
	}

	@Given("^I am on the View Report Window page$")
	public void i_am_on_the_View_Report_Window_page() throws Throwable {
		Thread.sleep(3000);
		viewReport = new ViewReportPage(driver);
		Assert.assertEquals("Unable to go view report page","Error Report", viewReport.getViewReportTitle().getText());
	}

	@Then("^the Error Report table will have the correct column <column_name> headers$")
	public void the_Error_Report_table_will_have_the_correct_column_headers(DataTable dataTable) throws Throwable {
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='errors']/thead/tr"); 
		BrowserInteractions.waitForHeaderLoad(driver, rowXpath, headerList.get(0));
		
		WebElement row = driver.findElement(rowXpath);
		List<WebElement> columns = row.findElements(By.tagName("th"));
		List<String> headerListUI=new ArrayList<String>();
		for (int cnum = 0; cnum < columns.size(); cnum++)
		{
			headerListUI.add(columns.get(cnum).getText());
		}
		Assert.assertEquals(headerList, headerListUI);
	}

	
	@Then("^the View Report Window result count will be as expected$")
	public void the_View_Report_Window_result_count_will_be_as_expected() throws Throwable {
	    
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String viewReportRequestParameters = "{\"language\":\"ENGLISH\",\"groupDescriptor\":{\"dbName\":\""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"},\"reportSearchCriteria\":{\"startPage\":1,\"pageSize\":20,\"reportParameters\":[{\"attribute\":\"REPORT_NAME\",\"value\":\"ERROR_RPT\"},{\"attribute\":\"JobId\",\"value\":\"782874\"}],\"sortDescription\":{\"sortField\":{\"attribute\":\"JobId\",\"value\":\"JobId\"},\"sortOrder\":\"asc\"}}}";
		
		
		String viewReportResponse = APICall.getResponse(APIURL+"/reports/runReport?token="+token, viewReportRequestParameters);
		JsonObject object = APIUtils.getJSONObjectFromResponse(viewReportResponse, "reportResults");
		String APIRowCount = APIUtils.getValueFromResponse(object.toString(), "totalRecords", "int");
		
		
		ViewReportPage viewReportPage = new ViewReportPage(driver);
		String UIRowCount = null;
		if(!viewReportPage.getResultsCount().getText().contains("of")){
			UIRowCount = "0";
		} else {
			UIRowCount = viewReportPage.getResultsCount().getText().split("of")[1].trim();
		}
		
		System.out.println(APIRowCount);
		System.out.println(UIRowCount);
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	}

	
}
