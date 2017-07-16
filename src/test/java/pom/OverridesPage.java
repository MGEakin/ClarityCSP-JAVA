package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverridesPage {
	
	WebDriver driver;
	public OverridesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "resultsCount")
	WebElement resultsCount;
	
	@FindBy(id = "overrideTypeDisplay")
	WebElement overrideTypeDisplay;
	public WebElement getResultsCount() {
		return resultsCount;
	}

	public void setResultsCount(WebElement resultsCount) {
		this.resultsCount = resultsCount;
	}

	public WebElement getOverrideTypeDisplay() {
		return overrideTypeDisplay;
	}

	public void setOverrideTypeDisplay(WebElement overrideTypeDisplay) {
		this.overrideTypeDisplay = overrideTypeDisplay;
	}


}
