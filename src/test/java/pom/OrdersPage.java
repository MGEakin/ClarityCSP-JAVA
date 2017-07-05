package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="processed_date_pulldown")
	WebElement processedDatePulldown;
	
	@FindBy(id = "searchButton")
	WebElement searchButton;
	
	public WebElement getProcessedDatePulldown() {
		return processedDatePulldown;
	}

	public void setProcessedDatePulldown(WebElement processedDatePulldown) {
		this.processedDatePulldown = processedDatePulldown;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}



	
	
}
