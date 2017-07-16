package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleOrdersPage {

	WebDriver driver;
	public SampleOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "resultsCount")
	WebElement resultsCount;
	
	@FindBy(id="addressBookButton")
	WebElement addressBookButton;
	
	@FindBy(id="sampleorders_sort_123")
	WebElement sampleordersSort;
	
	public WebElement getResultsCount() {
	return resultsCount;
	}

	public void setResultsCount(WebElement resultsCount) {
		this.resultsCount = resultsCount;
	}

	public WebElement getAddressBookButton() {
		return addressBookButton;
	}

	public void setAddressBookButton(WebElement addressBookButton) {
		this.addressBookButton = addressBookButton;
	}

	public WebElement getSampleordersSort() {
		return sampleordersSort;
	}

	public void setSampleordersSort(WebElement sampleordersSort) {
		this.sampleordersSort = sampleordersSort;
	}

	
}
