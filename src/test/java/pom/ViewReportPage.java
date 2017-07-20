package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewReportPage {

	WebDriver driver;
	public  ViewReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(className="resultsCount")
	WebElement resultsCount;
	
	@FindBy(css=".container-fluid>errorreport>h3")
	WebElement viewReportTitle;
	
	@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[4]")
	WebElement errorLink;
	
	@FindBy(className="csr_button")
	WebElement viewReportButton;
	
	public WebElement getResultsCount() {
		return resultsCount;
	}

	public void setResultsCount(WebElement resultsCount) {
		this.resultsCount = resultsCount;
	}

	public WebElement getViewReportTitle() {
		return viewReportTitle;
	}

	public void setViewReportTitle(WebElement viewReportTitle) {
		this.viewReportTitle = viewReportTitle;
	}

	public WebElement getErrorLink() {
		return errorLink;
	}

	public void setErrorLink(WebElement errorLink) {
		this.errorLink = errorLink;
	}

	public WebElement getViewReportButton() {
		return viewReportButton;
	}

	public void setViewReportButton(WebElement viewReportButton) {
		this.viewReportButton = viewReportButton;
	}
	
}
