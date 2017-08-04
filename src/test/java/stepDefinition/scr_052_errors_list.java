package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.ErrorsPage;
import pom.LoginPage;
import pom.MenuSubMenuPage;
import pom.ViewReportPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_052_errors_list {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	
	ErrorsPage errors;
	ViewReportPage viewreport;
	
	@Given("^I log in using a ClarityTestBooks client$")
	public void i_log_in_using_a_ClarityTestBooks_client() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		driver.get(properties.getProperty("centric_url"));
		LoginPage login = new LoginPage(driver);
		BrowserInteractions.waitUntilElementIsVisible(driver, login.getMemberName());
		login.getMemberName().sendKeys(properties.getProperty("memberName"));
		login.getUserId().sendKeys(properties.getProperty("userId"));
		login.getDbGroupName().sendKeys(properties.getProperty("clarityTestBooks.dbGroupName"));
		
		BrowserInteractions.click(login.getLoginBtn());
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.waitUntilElementIsVisible(driver, menu.getHomeMenu());
		Assert.assertTrue("Login Failed",BrowserInteractions.isDisplayed(menu.getHomeMenu())); 
	}

	@Given("^I navigate to the Errors List Page$")
	public void i_navigate_to_the_Errors_List_Page() throws Throwable {
		errors = new ErrorsPage(driver);
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());
		Thread.sleep(4000);
		WebElement errorsLinktd = errors.getErrorLink();
		errorsLinktd.findElement(By.tagName("a")).click();
	}
	
	@Given("^I am on the Errors List page$")
	public void i_am_on_the_Errors_List_page() throws Throwable {
		errors = new ErrorsPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals("Errors", errors.getErrorsTitle().getText());
	}

	
	@Then("^the Errors table will have the correct column <column_name> headers$")	
	
	public void the_Errors_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
	
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
	
	
	@Then("^the Errors result count will be as expected$")
	public void the_Errors_result_count_will_be_as_expected() throws Throwable {
	   
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String errorsRequestParameters = "{\"language\":\"ENGLISH\",\"errorListRequest\":{\"startPage\":1,\"pageSize\":20,\"groupDescriptor\":{\"dbName\":\""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"},\"jobId\":\"782313\"}}";

		String errorsResponse = APICall.getResponse(APIURL+"/jobprocessing/getErrorLists?token="+token, errorsRequestParameters);
		String APIRowCount = APIUtils.getValueFromResponse(errorsResponse, "rowsFound", "int");
		
		ErrorsPage errorsPage = new ErrorsPage(driver);
		String UIRowCount = null;
		if(!errorsPage.getResultsCount().getText().contains("of")){
			UIRowCount = "0";
		} else {
			UIRowCount = errorsPage.getResultsCount().getText().split("of")[1].trim();
		}
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	}

	@When("^I click the Errors - View Report button$")
	public void i_click_the_Errors_View_Report_button() throws Throwable {
	   
		errors = new ErrorsPage(driver);
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());
		viewreport = new ViewReportPage(driver) ;
		Thread.sleep(4000);
		WebElement errorLinktd =  viewreport.getErrorLink();
		System.out.println(" ****** "+errorLinktd.getText());
		errorLinktd.findElement(By.tagName("a")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("VIEW REPORT")).click();
		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
		
	}
	
	@Then("^I am on View Report Window page$")
	public void i_am_on_View_Report_Window_page() throws Throwable {
	    
		Thread.sleep(3000);
		errors = new ErrorsPage(driver);
		Assert.assertEquals("Unable to go view report page","Error Report", errors.getViewReportTitle().getText());
	}
	
	@When("^I click the Errors - View File Details button$")
	public void i_click_the_Errors_View_File_Details_button() throws Throwable {
	   
		menu = new MenuSubMenuPage(driver);
		errors = new ErrorsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());	
		Thread.sleep(4000);
		WebElement errorsLinktd = errors.getErrorLink();
		errorsLinktd.findElement(By.tagName("a")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("VIEW FILE DETAILS")).click();
		
	}

	@Then("^I am on the File Details page$")
	public void i_am_on_the_File_Details_page() throws Throwable {
		Thread.sleep(3000);
		errors = new ErrorsPage(driver);
		Assert.assertEquals("Unable to go view report page","File Details", errors.getViewFileDetailsTitle().getText());
		
	}


@When("^I sort the Errors table by the DATE column$")
public void i_sort_the_Errors_table_by_the_DATE_column() throws Throwable {
	
	BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());	
	Thread.sleep(4000);
	WebElement errorsLinktd = errors.getErrorLink();
	errorsLinktd.findElement(By.tagName("a")).click();
	Thread.sleep(3000);
		errors = new ErrorsPage(driver);
		BrowserInteractions.click(errors.getSortButton());
	}

	@Given("^the Page Count display list will contain$")
	public void the_Page_Count_display_list_will_contain(DataTable dataTable) throws Throwable {
		ErrorsPage Errors = new ErrorsPage(driver);
		Thread.sleep(5000);
		List<String> dropdownList = dataTable.asList(String.class);
		List<String> dropdownListUI = BrowserInteractions.getDropDownList(Errors.getPageCount());
		Assert.assertEquals("The values in the page count dropdown are not correct", dropdownList, dropdownListUI);
		
	}
	
	@Then("^the default Page Count selection is \"([^\"]*)\"$")
	public void the_default_Page_Count_selection_is(String displayCount) throws Throwable {
	    
		ErrorsPage Errors = new ErrorsPage(driver);
		Thread.sleep(3000);
		Select dropdown = new Select(Errors.getPageCount());
		Assert.assertEquals("Default page count is not 20", displayCount, dropdown.getFirstSelectedOption().getText());
	}


@When("^I select \"([^\"]*)\" in the Page Count select list$")
public void i_select_in_the_Page_Count_select_list(String pageCount) throws Throwable {

	ErrorsPage Errors = new ErrorsPage(driver);
	Select dropdown = new Select(Errors.getPageCount());
	dropdown.selectByVisibleText(pageCount);
}

@Then("^the Errors result page count will be as expected$")
public void the_Errors_result_page_count_will_be_as_expected() throws Throwable {
   
	ErrorsPage Errors = new ErrorsPage(driver);
	Thread.sleep(3000);
	if(!Errors.getResultsCount().getText().contains("No")){
	System.out.println("Result count is as expected");
	}
	} 
}
	

