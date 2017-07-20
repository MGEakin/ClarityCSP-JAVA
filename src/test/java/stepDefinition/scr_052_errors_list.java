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
import pom.ErrorsPage;
import pom.LoginPage;
import pom.MenuSubMenuPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_052_errors_list {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	
	ErrorsPage errors;
	
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

	}

	

