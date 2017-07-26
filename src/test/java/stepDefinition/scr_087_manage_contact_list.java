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
	public void the_Manage_Contacts_table_will_have_the_correct_column_column_name_headers(DataTable dataTable)
			throws Throwable {
		List<String> headerList = dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='contacts']/thead/tr");
		BrowserInteractions.waitForHeaderLoad(driver, rowXpath, headerList.get(0));
		WebElement row = driver.findElement(rowXpath);
		List<WebElement> columns = row.findElements(By.tagName("th"));
		List<String> headerListUI = new ArrayList<String>();
		for (int cnum = 0; cnum < columns.size(); cnum++) {
			headerListUI.add(columns.get(cnum).getText());
		}
		Assert.assertEquals(headerList, headerListUI);
	}

	@Then("^the Manage Contacts result count will be as expected$")
	public void the_Manage_Contacts_result_count_will_be_as_expected() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String adminContactsRequestParameters = "{\"language\":\"ENGLISH\",\"contactsSearchCriteria\":{\"claritySystemID\":\"claritytestcards\",\"groupDescriptor\":{\"dbName\":\""
				+ properties.getProperty("dbName") + "\",\"groupName\":\"" + properties.getProperty("groupName")
				+ "\"},\"startPage\":1,\"pageSize\":20}}";
		String adminContactsResponse = APICall.getResponse(APIURL + "/ancillary/getContacts?token=" + token,
				adminContactsRequestParameters);
		JsonObject object = APIUtils.getJSONObjectFromResponse(adminContactsResponse, "contactsResults");
		String APIRowCount = APIUtils.getValueFromResponse(object.toString(), "count", "int");
		AdminContactsPage adminContactsPage = new AdminContactsPage(driver);
		String UIRowCount = adminContactsPage.getResultsCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count " + APIRowCount + " not matched UI count" + UIRowCount,
				StringUtils.equals(APIRowCount, UIRowCount));

	}

	@Then("^I am on the Manage Contacts List page$")
	public void i_am_on_the_Manage_Contacts_List_page() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("Contacts List Page Loading failed",
				BrowserInteractions.isDisplayed(adminContacts.getPageFirstElement()));

	}

	@Then("^I see the text \"([^\"]*)\" on the Manage Conatcts screen$")
	public void i_see_the_text_on_the_Manage_Conatcts_screen(String text) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertEquals("Text mismatch", text, adminContacts.getCompareText().getText());
	}

	@Then("^the following Manage Contacts row content will be correct$")
	public void the_following_Manage_Contacts_row_content_will_be_correct(DataTable dataTable) throws Throwable {
		List<List<String>> data = dataTable.raw();
		Thread.sleep(3000);
		adminContacts = new AdminContactsPage(driver);
		Assert.assertEquals("Data mismatch in Support Role", data.get(1).get(0).trim(), (adminContacts.getSupportRole().getText().trim()));
		Assert.assertEquals("Data mismatch in Contact Company", data.get(1).get(1).trim(), (adminContacts.getContactCompany().getText().trim()));
		Assert.assertEquals("Data mismatch in Contact Name", data.get(1).get(2).trim(), (adminContacts.getContactName().getText().trim()));
		Assert.assertEquals("Data mismatch in Contact EmailId", data.get(1).get(3).trim(), (adminContacts.getContactEmailId().getText().trim()));
		Assert.assertEquals("Data mismatch in Contact PhoneNo", data.get(1).get(4).trim(), (adminContacts.getContactPhoneNo().getText().trim()));
		Assert.assertEquals("Data mismatch in Home Display", data.get(1).get(5).trim(), (adminContacts.getHomeDisplay().getText().trim()));
		Assert.assertEquals("Data mismatch in Actions Elements", data.get(1).get(6).replaceAll("\\s",""), (adminContacts.getActionsElements().getText().replaceAll("\\r|\\n|\\s", "")));
			
	}

	@When("^I select the Manage Contact - Edit action$")
	public void i_select_the_Manage_Contact_Edit_action() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.click(adminContacts.getEditContact());
	}

	@Then("^I am on the Edit and Create Contacts page$")
	public void i_am_on_the_Edit_and_Create_Contacts_page() throws Throwable {

		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("Contacts List Page Loading failed",
				BrowserInteractions.isDisplayed(adminContacts.getEditPageFirstElement()));

	}

	 @Then("^the following Edit and Create Contacts row content will be correct$")
	 public void the_following_Edit_and_Create_Contacts_row_content_will_be_correct(DataTable dataTable) throws Throwable {
	 List<List<String>> data = dataTable.raw();
	 adminContacts = new AdminContactsPage(driver);
	 Thread.sleep(5000);
	 Assert.assertEquals("Contact Name mistmatch",data.get(1).get(0),adminContacts.getEditPageContactName().getAttribute("value"));
	 Assert.assertEquals("Contact Name mistmatch",data.get(1).get(1),adminContacts.getEditPageContactEmail().getAttribute("value"));
	 Assert.assertEquals("Contact Name mistmatch",data.get(1).get(2),adminContacts.getEditPageContactPhone().getAttribute("value"));
	 Assert.assertEquals("Contact Name mistmatch",data.get(1).get(3),adminContacts.getEditPageContactCompany().getAttribute("value"));
	 Assert.assertEquals("Contact Name mistmatch",data.get(1).get(4),adminContacts.getEditPageSupportRole().getAttribute("value"));
	 Assert.assertEquals("Contact Name mistmatch",data.get(1).get(5),adminContacts.getEditPageDisplayContact().getAttribute("value"));
	 Assert.assertEquals("Contact Name mistmatch",data.get(1).get(6),adminContacts.getEditPageNewSupportRoleName().getAttribute("value"));
	 
	 }

	@When("^I select the Manage Contact - Delete action$")
	public void i_select_the_Manage_Contact_Delete_action() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.click(adminContacts.getEditPageCancelButton());
		// BrowserInteractions.clickWhenElementVisible(driver,
		// adminContacts.getEditPageCancelButton());
		BrowserInteractions.clickWhenElementVisible(driver, adminContacts.getDeleteButton());
	}

	@Then("^I see the text \"([^\"]*)\" on screen$")
	public void i_see_the_text_on_screen(String msg) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Assert.assertEquals("Delete contact Page Loading failed", msg,
				adminContacts.getDeletePageFirstElement().getText());
	}

	@When("^I click on the \"([^\"]*)\" button$")
	public void i_click_on_the_button(String arg1) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver, adminContacts.getDeleteButton());
		BrowserInteractions.click(adminContacts.getCancelButton());
	}

	@Then("^I do not see the text \"([^\"]*)\" on the screen$")
	public void i_do_not_see_the_text_on_the_screen(String arg1) throws Throwable {

		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("I am not on manage contact page list",
				BrowserInteractions.isDisplayed(adminContacts.getPageFirstElement()));

	}

	@Given("^the Manage Contacts list page count display list will contain$")
	public void the_Manage_Contacts_list_page_count_display_list_will_contain(DataTable dataTable) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		List<String> dropdownList = dataTable.asList(String.class);
		List<String> dropdownListUI = BrowserInteractions.getDropDownList(adminContacts.getContactsPageCount());
		Assert.assertEquals("The values in the page count dropdown are not correct", dropdownList, dropdownListUI);
	}

	@Then("^the default page selection is \"([^\"]*)\"$")
	public void the_default_page_selection_is(String displayCount) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Select dropdown = new Select(adminContacts.getContactsPageCount());
		Assert.assertEquals("Default page count is not 20", displayCount, dropdown.getFirstSelectedOption().getText());
	}
}