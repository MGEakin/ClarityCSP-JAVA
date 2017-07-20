package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	@Given("^I click the \"([^\"]*)\" button$")
	public void i_click_the_button(String arg1) throws Throwable {
	   
		adminContacts = new AdminContactsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver,adminContacts.getContactButton());
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




}
