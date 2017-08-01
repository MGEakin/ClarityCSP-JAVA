package stepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.AdminContactsPage;
import pom.MenuSubMenuPage;
import utils.BrowserFactory;
import utils.BrowserInteractions;

public class scr_088_edit_and_create_contacts {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu; 
	AdminContactsPage adminContacts;
	
	@Given("^I navigate to the Manage Contacts Page$")
	public void i_navigate_to_the_Manage_Contacts_Page() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.click(adminContacts.getHelloLink());
		Thread.sleep(2000);
		driver.findElement(By.linkText("Contacts")).click();	
	}

	@When("^I enter \"([^\"]*)\" in the Contact Email field$")
	public void i_enter_in_the_Contact_Email_field(String contactEmail) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(2000);
		adminContacts.getContactEmail().sendKeys(contactEmail);
		driver.findElement(By.tagName("body")).click();
	}

	@Then("^I see the text \"([^\"]*)\" in the Contact Email Error field$")
	public void i_see_the_text_in_the_Contact_Email_Error_field(String contactEmailError) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertEquals("Contact Email Error mismatch", contactEmailError, adminContacts.getContactEmailError().getText());
	}

	@When("^I enter \"([^\"]*)\" in the Contact Phone field$")
	public void i_enter_in_the_Contact_Phone_field(String  contactPhone) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		adminContacts.getContactPhone().sendKeys(contactPhone);
		driver.findElement(By.tagName("body")).click();
	}

	@Then("^I see the text \"([^\"]*)\" in the Contact Phone Error (\\d+) field$")
	public void i_see_the_text_in_the_Contact_Phone_Error_field(String error, int number) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		if(number == 1){
		Assert.assertEquals("Contact Email Error mismatch", error, adminContacts.getContactPhoneError0().getText());
		} else{
		Assert.assertEquals("Contact Email Error mismatch", error, adminContacts.getContactPhoneError1().getText());
		}
	}

	@Given("^I click the Add Contact button$")
	public void i_click_the_Add_Contact_button() throws Throwable {
		Thread.sleep(5000);
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.click(adminContacts.getContactsAddButton());
	}
	
	@Given("^I click on the contacts element \"([^\"]*)\" button$")
	public void i_click_on_the_contacts_element_button(String arg1) throws Throwable {
		Thread.sleep(2000);
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver,adminContacts.getCancelButton());
		Thread.sleep(2000);
		BrowserInteractions.click(adminContacts.getContactsAddButton());
	}

	@Then("^I am on the page Edit and Create Contacts page$")
	public void i_am_on_the_page_Edit_and_Create_Contacts_page() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("Edit and Create Contacts Page Loading failed",BrowserInteractions.isDisplayed(adminContacts.getEditPageFirstElement()));
	}

	@Then("^I see this text \"([^\"]*)\" on the screen$")
	public void i_see_this_text_on_the_screen(String text) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertEquals("Text mismatch", text, adminContacts.getScreenText().getText());
		BrowserInteractions.clickWhenElementVisible(driver,adminContacts.getCancelButton());
		Thread.sleep(2000);
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		driver.findElement(By.linkText("ADD CONTACT")).click();
	}

	@Then("^I am on  Edit and Create Contacts page$")
	public void i_am_on_Edit_and_Create_Contacts_page() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("Contacts List Page Loading failed",BrowserInteractions.isDisplayed(adminContacts.getEditPageFirstElement()));
	}

	@Given("^Create Contact - Save button is disabled$")
	public void create_Contact_Save_button_is_disabled() throws Throwable {
		Thread.sleep(3000);
		adminContacts = new AdminContactsPage(driver);
		Assert.assertTrue("Save button is enabled", adminContacts.getSaveButton().getAttribute("class").contains("disabledButton"));
	}

	@When("^I enter the name as \"([^\"]*)\" in the Contact Name field$")
	public void i_enter_the_name_as_in_the_Contact_Name_field(String contactName) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(2000);
		adminContacts.getEditPageContactName().sendKeys(contactName);
	}

	@When("^I enter the email id as \"([^\"]*)\" in the Contact Email field$")
	public void i_enter_the_email_id_as_in_the_Contact_Email_field(String contactEmail) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(2000);
		adminContacts.getEditPageContactEmail().sendKeys(contactEmail);
	}

	@When("^I enter the contact number as \"([^\"]*)\" in the Contact Phone field$")
	public void i_enter_the_contact_number_as_in_the_Contact_Phone_field(String contactPhone) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(2000);
		adminContacts.getEditPageContactPhone().sendKeys(contactPhone);
	}

	@When("^I select the company name as \"([^\"]*)\" in the Contact Company select list$")
	public void i_select_the_company_name_as_in_the_Contact_Company_select_list(String companyName) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Select dropdown = new Select(adminContacts.getEditPageContactCompany());
		dropdown.selectByVisibleText(companyName);	
	}

	@When("^I select role as \"([^\"]*)\" in the Support Role select list$")
	public void i_select_role_as_in_the_Support_Role_select_list(String supportRole) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Select dropdown = new Select(adminContacts.getEditPageSupportRole());
		dropdown.selectByVisibleText(supportRole);		
	}

	@When("^I select the value as \"([^\"]*)\" in the Display Contact on Home Page select list$")
	public void i_select_the_value_as_in_the_Display_Contact_on_Home_Page_select_list(String displayContact) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Select dropdown = new Select(adminContacts.getEditPageDisplayContact());
		dropdown.selectByVisibleText(displayContact);
	}
	
	@And("^I click the Create Contact save button$")
	public void i_click_the_Create_Contact_save_button() throws Throwable {
		Thread.sleep(3000);
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.click(adminContacts.getSaveButton());
		Thread.sleep(3000);
		BrowserInteractions.click(adminContacts.getOkButton());
	}
	
	@When("^Create Contact - Save button is enabled$")
	public void create_Contact_Save_button_is_enabled() throws Throwable {
		Thread.sleep(3000);
		adminContacts = new AdminContactsPage(driver);
		Assert.assertFalse("Save button is enabled", adminContacts.getSaveButton().getAttribute("class").contains("disabledButton"));
		BrowserInteractions.clickWhenElementVisible(driver,adminContacts.getCancelButton());
	}
	
	@When("^I click on the Create Contact - Cancel element button$")
	public void i_click_on_the_Create_Contact_Cancel_element_button() throws Throwable {
		Thread.sleep(3000);
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver,adminContacts.getCancelButton());
	}

	@Given("^I enter \"([^\"]*)\" in the Contact Name field$")
	public void i_enter_in_the_Contact_Name_field(String contactName) throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(2000);
		adminContacts.getEditPageContactName().sendKeys(contactName);
	}

	@Then("^I am on Manage Contacts List page$")
	public void i_am_on_Manage_Contacts_List_page() throws Throwable {
		adminContacts = new AdminContactsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("Contacts List Page Loading failed",BrowserInteractions.isDisplayed(adminContacts.getPageFirstElement()));
	}

	@Then("^I sort the Manage Contacts table by the CONTACT NAME column$")
	public void i_sort_the_Manage_Contacts_table_by_the_CONTACT_NAME_column() throws Throwable {
		Thread.sleep(3000);
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.click(adminContacts.getSortButton());
	}

	@Then("^the following Manage Contacts row content in this scenario will be correct$")
	public void the_following_Manage_Contacts_row_content_in_this_scenario_will_be_correct(DataTable dataTable) throws Throwable {
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
}