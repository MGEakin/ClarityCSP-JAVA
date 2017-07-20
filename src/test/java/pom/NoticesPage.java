package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoticesPage {

	WebDriver driver;
	public  NoticesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
			
	}
	@FindBy(id="adminRouteButton")
	WebElement helloLink;
	
	@FindBy(className="resultsCount")
	WebElement resultsCount;
	
	@FindBy(id="landing-files")
	WebElement noticeMessages;
	
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

	public WebElement getNoticeMessages() {
		return noticeMessages;
	}

	public void setNoticeMessages(WebElement noticeMessages) {
		this.noticeMessages = noticeMessages;
	}
	
	
	
}
