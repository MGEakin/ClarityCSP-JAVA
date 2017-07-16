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
import cucumber.api.java.en.When;
import pom.MenuSubMenuPage;
import pom.SampleOrdersPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_098a_sample_order_list {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	SampleOrdersPage sampleOrdersPage;
	
	@Given("^I navigate to the Sample Orders Page$")
	public void i_navigate_to_the_Sample_Orders_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		//Thread.sleep(10000);
		BrowserInteractions.clickWhenElementVisible(driver,menu.getSubMenuSampleOrders());
//	    BrowserInteractions.click(menu.getSubMenuSampleOrders());
//	    Thread.sleep(5000);
		sampleOrdersPage =new SampleOrdersPage(driver);
	}

	@Then("^the Sample Orders List table will have the correct column <column_name> headers$")
	public void the_Sample_Orders_List_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
	   
		// Thread.sleep(50000);
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='sampleorders']/thead/tr"); 
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

	@Then("^the Address Books result count will be as expected$")
	public void the_Address_Books_result_count_will_be_as_expected() throws Throwable {
		sampleOrdersPage =new SampleOrdersPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver,sampleOrdersPage.getAddressBookButton());
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		
		String sampleOrdersRequestParameters = "{\"language\":\"ENGLISH\",\"groupDescriptor\":{\"dbName\":\""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"},\"addressBookSearchCriteria\":{\"startPage\":1,\"pageSize\":20,\"claritySystemID\":\"claritytestbooks\",\"sortDescriptionGUI\":{\"sortField\":{\"attribute\":\"NAME\",\"value\":\"shortname\"},\"sortOrder\":\"ASC\"}}}";
		
		String sampleOrdersResponse = APICall.getResponse(APIURL+"/sampleorder/getAddressBooks?token="+token, sampleOrdersRequestParameters);
		String APIRowCount = APIUtils.getValueFromResponse(sampleOrdersResponse, "rowsFound", "int");
		
		SampleOrdersPage sampleOrdersPage = new SampleOrdersPage(driver);
		String UIRowCount = sampleOrdersPage.getResultsCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count "+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	   
	}
	
	@Then("^the Address Books List table will have the correct column <column_name> headers$")
	public void the_Address_Books_List_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='address']/thead/tr"); 
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
	
	@When("^I sort the Sample Orders table by the SAMPLE ORDER NAME column$")
	public void i_sort_the_Sample_Orders_table_by_the_SAMPLE_ORDER_NAME_column() throws Throwable {
		sampleOrdersPage = new SampleOrdersPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver, sampleOrdersPage.getSampleordersSort());
		}
	
	@Then("^the Sample Orders result count will be as expected$")
	public void the_Sample_Orders_result_count_will_be_as_expected() throws Throwable {
	Properties properties = PropertiesLoad.loadFromFile("config.properties");
	String APIURL = properties.getProperty("api.url");
	String token = APIUtils.getToken();
	
	String sampleOrdersSortRequestParameters = "{\"language\":\"ENGLISH\",\"groupDescriptor\":{\"dbName\":\""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"},\"sampleOrderSearchCriteria\":{\"startPage\":1,\"pageSize\":20,\"claritySystemID\":\"claritytestbooks\",\"sortDescriptionGUI\":{\"sortField\":{\"attribute\":\"SAMPLE ORDER NAME\",\"value\":\"shortname\"},\"sortOrder\":\"asc\"}}}";
		
	
	String sampleOrdersSortResponse = APICall.getResponse(APIURL+"/sampleorder/getSampleOrders?token="+token, sampleOrdersSortRequestParameters);
	String APIRowCount = APIUtils.getValueFromResponse(sampleOrdersSortResponse, "rowsFound", "int");
	sampleOrdersPage = new SampleOrdersPage(driver);
	String UIRowCount = sampleOrdersPage.getResultsCount().getText().split("of")[1].trim();
	Assert.assertTrue("API count "+APIRowCount+" not matched UI count "+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	}


}

