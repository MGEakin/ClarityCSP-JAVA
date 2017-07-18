package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembersPage {

	WebDriver driver;
	public MembersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="resultsCount")
	WebElement resultsCount;
	
	@FindBy(id="searchButton2")
	WebElement searchButton2;
	
	@FindBy(id="State")
	WebElement State;
	
	@FindBy(id="GroupID")
	WebElement GroupID;
	
	@FindBy(xpath="html/body/app-root/div[3]/members/div/div")
	WebElement groupIDText;
	
	public WebElement getResultsCount() {
		return resultsCount;
	}

	public void setResultsCount(WebElement resultsCount) {
		this.resultsCount = resultsCount;
	}

	public WebElement getSearchButton2() {
		return searchButton2;
	}

	public void setSearchButton2(WebElement searchButton2) {
		this.searchButton2 = searchButton2;
	}

	public WebElement getState() {
		return State;
	}

	public void setState(WebElement state) {
		State = state;
	}

	public WebElement getGroupID() {
		return GroupID;
	}

	public void setGroupID(WebElement groupID) {
		GroupID = groupID;
	}

	public WebElement getGroupIDText() {
		return groupIDText;
	}

	public void setGroupIDText(WebElement groupIDText) {
		this.groupIDText = groupIDText;
	}

	
}
