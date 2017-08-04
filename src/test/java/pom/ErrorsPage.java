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
	
	@FindBy(xpath="html/body/app-root/div[3]/errors/div[1]/a[2]")
	WebElement viewFileDetailsButton;
	
	@FindBy(xpath="html/body/app-root/div[3]/errorreport/h3")
	WebElement ViewReportTitle;
	
	@FindBy(id="errors_sort_48")
	WebElement sortButton;
		
	@FindBy(id="displayCount_file")
	WebElement pageCount;
	
	@FindBy(xpath="html/body/app-root/div[3]/file-details/h3")
	WebElement viewFileDetailsTitle;
	
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

	public WebElement getViewFileDetailsButton() {
		return viewFileDetailsButton;
	}

	public void setViewFileDetailsButton(WebElement viewFileDetailsButton) {
		this.viewFileDetailsButton = viewFileDetailsButton;
	}

	public WebElement getViewReportTitle() {
		return ViewReportTitle;
	}

	public void setViewReportTitle(WebElement viewReportTitle) {
		ViewReportTitle = viewReportTitle;
	}

	public WebElement getSortButton() {
		return sortButton;
	}

	public void setSortButton(WebElement sortButton) {
		this.sortButton = sortButton;
	}

	public WebElement getPageCount() {
		return pageCount;
	}

	public void setPageCount(WebElement pageCount) {
		this.pageCount = pageCount;
	}

	public WebElement getViewFileDetailsTitle() {
		return viewFileDetailsTitle;
	}

	public void setViewFileDetailsTitle(WebElement viewFileDetailsTitle) {
		this.viewFileDetailsTitle = viewFileDetailsTitle;
	}
}

