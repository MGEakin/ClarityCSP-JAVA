package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminContactsPage {

	WebDriver driver;
	public  AdminContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(id="addContactButton")
		WebElement ContactButton;
		
		@FindBy(id="adminRouteButton")
		WebElement helloLink;
		
		@FindBy(className="resultsCount")
		WebElement resultsCount;
		
		@FindBy(id="contactEmail")
		WebElement contactEmail;
		
				
		@FindBy(className="landing-holds")
		WebElement contacts;
		
		@FindBy(id="contactEmail_error_0")
		WebElement contactEmailError;
		
		@FindBy(id="contactPhone")
		WebElement contactPhone;
		
		@FindBy(id="contactPhone_error_0")
		WebElement contactPhoneError0;
		
		@FindBy(id="contactPhone_error_1")
		WebElement contactPhoneError1;
		
		public WebElement getContactButton() {
			return ContactButton;
		}

		public void setContactButton(WebElement contactButton) {
			ContactButton = contactButton;
		}

		public WebElement getHelloLink() {
			return helloLink;
		}

		public void setHelloLink(WebElement helloLink) {
			this.helloLink = helloLink;
		}

		public WebElement getResultsCount() {
			return resultsCount;
		}

		public void setResultsCount(WebElement resultsCount) {
			this.resultsCount = resultsCount;
		}

		public WebElement getContactEmail() {
			return contactEmail;
		}

		public void setContactEmail(WebElement contactEmail) {
			this.contactEmail = contactEmail;
		}

		public WebElement getContacts() {
			return contacts;
		}

		public void setContacts(WebElement contacts) {
			this.contacts = contacts;
		}

		public WebElement getContactEmailError() {
			return contactEmailError;
		}

		public void setContactEmailError(WebElement contactEmailError) {
			this.contactEmailError = contactEmailError;
		}

		public WebElement getContactPhone() {
			return contactPhone;
		}
		
		

		public WebElement getContactPhoneError0() {
			return contactPhoneError0;
		}

		public void setContactPhoneError0(WebElement contactPhoneError0) {
			this.contactPhoneError0 = contactPhoneError0;
		}

		public WebElement getContactPhoneError1() {
			return contactPhoneError1;
		}

		public void setContactPhoneError1(WebElement contactPhoneError1) {
			this.contactPhoneError1 = contactPhoneError1;
		}

		public void setContactPhone(WebElement contactPhone) {
			this.contactPhone = contactPhone;
		}
		
}

