package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorsPage {

	WebDriver driver;
	public  ErrorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[4]")
	WebElement errorLink;
	
	@FindBy(className="resultsCount")
	WebElement resultsCount;
	
	@FindBy(className="csr_button")
	WebElement viewReportButton;
	
	@FindBy(css=".container-fluid>errors>h3")
	WebElement errorsTitle;
		
	public WebElement getErrorLink() {
		return errorLink;
	}

	public void setErrorLink(WebElement errorLink) {
		this.errorLink = errorLink;
	}

	public WebElement getResultsCount() {
		return resultsCount;
	}

	public void setResultsCount(WebElement resultsCount) {
		this.resultsCount = resultsCount;
	}

	public WebElement getViewReportButton() {
		return viewReportButton;
	}

	public void setViewReportButton(WebElement viewReportButton) {
		this.viewReportButton = viewReportButton;
	}

	public WebElement getErrorsTitle() {
		return errorsTitle;
	}

	public void setErrorsTitle(WebElement errorsTitle) {
		this.errorsTitle = errorsTitle;
	}

	}

