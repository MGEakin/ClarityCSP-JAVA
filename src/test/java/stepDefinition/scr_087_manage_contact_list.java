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
import pom.AdminContactsPage;
import pom.MenuSubMenuPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_087_manage_contact_list {


	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	
	
	AdminContactsPage adminContacts;
	
	@Given("^I navigate to the manage contacts Page$")
	public void i_navigate_to_the_manage_contacts_Page() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.click(adminContacts.getHelloLink());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();
	}
	
	
	
	@Then("^the Manage Contacts table will have the correct column <column_name> headers$")
	public void the_Manage_Contacts_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='contacts']/thead/tr"); 
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

	@Then("^the Manage Contacts result count will be as expected$")
	public void the_Manage_Contacts_result_count_will_be_as_expected() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String adminContactsRequestParameters = "{\"language\":\"ENGLISH\",\"contactsSearchCriteria\":{\"claritySystemID\":\"claritytestcards\",\"groupDescriptor\":{\"dbName\":\""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"},\"startPage\":1,\"pageSize\":20}}";
		String adminContactsResponse = APICall.getResponse(APIURL+"/ancillary/getContacts?token="+token, adminContactsRequestParameters);
		JsonObject object = APIUtils.getJSONObjectFromResponse(adminContactsResponse, "contactsResults");
		String APIRowCount = APIUtils.getValueFromResponse(object.toString(), "count", "int");
		
		AdminContactsPage adminContactsPage = new AdminContactsPage(driver);
		String UIRowCount = adminContactsPage.getResultsCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	   
	}
	
}


