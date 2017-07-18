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
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.MembersPage;
import pom.MenuSubMenuPage;
import pom.OrdersPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_055b_orders_list {
	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	OrdersPage orders;
	MembersPage members;
	String groupID;
	@Given("^I navigate to the Orders List Page$")
	public void i_navigate_to_the_Orders_List_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		//Thread.sleep(5000);
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuOrders());
	    // Thread.sleep(5000);
	    orders =new OrdersPage(driver);
	    BrowserInteractions.waitUntilElementIsVisible(driver, orders.getState());
		Select dropdown = new Select(orders.getState());
		dropdown.selectByVisibleText("AK");
		BrowserInteractions.click(orders.getSearchButton1());
	    
	}

	@Then("^the Orders List table will have the correct column <column_name> headers$")
	public void the_Orders_List_table_will_have_the_correct_column_column_name_headers(DataTable state) throws Throwable {
		List<String> headerList=state.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='orders']/thead/tr"); 
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
	

	@Then("^the Members table will have the correct column <coloum_name> headers$")
	public void the_Members_table_will_have_the_correct_column_coloum_name_headers(DataTable state)	throws Throwable {
		driver.navigate().back();
		members =new MembersPage(driver);
		BrowserInteractions.waitUntilElementIsVisible(driver, members.getState());
		Select dropdown = new Select(members.getState());
		dropdown.selectByVisibleText("AK");
		BrowserInteractions.click(members.getSearchButton2());
		Thread.sleep(5000);
		List<String> headerList = state.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='orders']/thead/tr");
		BrowserInteractions.waitForHeaderLoad(driver, rowXpath, headerList.get(0));

		WebElement row = driver.findElement(rowXpath);
		List<WebElement> columns = row.findElements(By.tagName("th"));
		List<String> headerListUI = new ArrayList<String>();
		for (int cnum = 0; cnum < columns.size(); cnum++) {
			headerListUI.add(columns.get(cnum).getText());
		}
		Assert.assertEquals(headerList, headerListUI);
		
	}

	
	@Then("^the Members result count will be as expected$")
	public void the_Members_result_count_will_be_as_expected() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		
		String membersRequestParameters = "{\"language\":\"ENGLISH\",\"startPage\":1,\"pageSize\":20,\"resultFilters\":[{\"attribute\":16,\"value\":\"AK\"}],\"sortDescriptions\":[]}";
		String membersResponse = APICall.getResponse(APIURL+"/customerservice/getMembers?token="+token, membersRequestParameters);
		JsonObject object = APIUtils.getJSONObjectFromResponse(membersResponse, "memberSearchResults");
		String APIRowCount = APIUtils.getValueFromResponse(object.toString(), "count", "int");
		
		MembersPage membersPage = new MembersPage(driver);
		String UIRowCount = membersPage.getResultsCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	}

	@When("^I search Members Form by GROUPID with a value of \"([^\"]*)\"$")
	public void i_search_Members_Form_by_GROUPID_with_a_value_of(String groupID) throws Throwable {
     	driver.navigate().back();
     	Thread.sleep(3000);
		members =new MembersPage(driver);
		this.groupID = groupID;
		members.getGroupID().sendKeys(groupID);
		BrowserInteractions.click(members.getSearchButton2());
	}
	
	@Then("^I see the \"([^\"]*)\" text on the screen$")
	public void i_see_the_text_on_the_screen(String groupID) throws Throwable {
		members =new MembersPage(driver);
		Thread.sleep(5000);
		Assert.assertEquals("GroupID mismatch", groupID, members.getGroupIDText().getText());
	}


	@Then("^the Members row content will match the API results$")
	public void the_Members_row_content_will_match_the_API_results() throws Throwable {
		Thread.sleep(3000);
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
			
		String membersRequestParameters = "{\"language\":\"ENGLISH\",\"startPage\":1,\"pageSize\":20,\"resultFilters\":[{\"attribute\":18,\"value\":\""+groupID+"\"}],\"sortDescriptions\":[]}";
		String membersResponse = APICall.getResponse(APIURL+"/customerservice/getMembers?token="+token, membersRequestParameters);
		JsonObject object = APIUtils.getJSONObjectFromResponse(membersResponse, "memberSearchResults");
		String APIRowCount = APIUtils.getValueFromResponse(object.toString(), "count", "int");
		
		
		MembersPage membersPage = new MembersPage(driver);
		String UIRowCount = membersPage.getResultsCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	}
	
}
