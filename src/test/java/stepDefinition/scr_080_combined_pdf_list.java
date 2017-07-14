package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pom.CombinedPDFsPage;
import pom.LoginPage;
import pom.MenuSubMenuPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_080_combined_pdf_list {
	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	
	@Given("^I log into the Clarity Service Portal$")
	public void i_log_into_the_Clarity_Service_Portal() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		driver.get(properties.getProperty("centric_url"));
		LoginPage login = new LoginPage(driver);
		BrowserInteractions.waitUntilElementIsVisible(driver, login.getMemberName());
		login.getMemberName().sendKeys(properties.getProperty("memberName"));
		login.getUserId().sendKeys(properties.getProperty("userId"));
		login.getDbGroupName().sendKeys(properties.getProperty("dbGroupName"));
		
		BrowserInteractions.click(login.getLoginBtn());
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.waitUntilElementIsVisible(driver, menu.getHomeMenu());
		Assert.assertTrue("Login Failed",BrowserInteractions.isDisplayed(menu.getHomeMenu()));

	}

	@Given("^I navigate to the Combined PDFs Page$")
	public void i_navigate_to_the_Combined_PDFs_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());
		
	}
	
	@Then("^the Combined PDFs List table will have the correct column <column_name> headers$")
	public void the_Combined_PDFs_List_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='prodholds']/thead/tr"); 
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

	@Then("^the Combined PDFs result count will be as expected$")
	public void the_Combined_PDFs_result_count_will_be_as_expected() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String combinedPdFsRequestParameters = "{\"language\":\"ENGLISH\",\"groupDescriptor\":{\"dbName\":\""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"},\"combinedPDFSearchRequest\":{\"startPage\":1,\"pageSize\":20,\"days\":3000}}";
		String combinedPDFsResponse = APICall.getResponse(APIURL+"/combinedpdf/getCombinedPDFs?token="+token, combinedPdFsRequestParameters);
		String APIRowCount = APIUtils.getValueFromResponse(combinedPDFsResponse, "rowsFound", "int");
		
		CombinedPDFsPage combinedPDFsPage = new CombinedPDFsPage(driver);
		String UIRowCount = combinedPDFsPage.getResultCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	   
	}
	
	
}
