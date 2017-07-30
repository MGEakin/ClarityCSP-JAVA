package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CombinedPDFsPage {

	WebDriver driver;
	public  CombinedPDFsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(className="resultsCount")
		WebElement resultCount;
		
		@FindBy(xpath="html/body/app-root/div[3]/combinedpdf/h3")
		WebElement pageFirstElement;
		
		@FindBy(id="combinedpdf_refresh")
		WebElement refreshButton;
		
		@FindBy(className="csr_button")
		WebElement addRequestButton;
		
		@FindBy(xpath="html/body/app-root/div[3]/addpdfrequest/h3")
		WebElement requestPageFirstElement;
		
		@FindBy(id="cancelButton")
		WebElement cancelButton;
		
		@FindBy(id="displayCount_file")
		WebElement pageCount;
		
		public WebElement getResultCount() {
		return resultCount;
		}

		public void setResultCount(WebElement resultCount) {
			this.resultCount = resultCount;
		}

		public WebElement getPageFirstElement() {
			return pageFirstElement;
		}

		public void setPageFirstElement(WebElement pageFirstElement) {
			this.pageFirstElement = pageFirstElement;
		}

		public WebElement getRefreshButton() {
			return refreshButton;
		}

		public void setRefreshButton(WebElement refreshButton) {
			this.refreshButton = refreshButton;
		}

		public WebElement getAddRequestButton() {
			return addRequestButton;
		}

		public void setAddRequestButton(WebElement addRequestButton) {
			this.addRequestButton = addRequestButton;
		}

		public WebElement getRequestPageFirstElement() {
			return requestPageFirstElement;
		}

		public void setRequestPageFirstElement(WebElement requestPageFirstElement) {
			this.requestPageFirstElement = requestPageFirstElement;
		}

		public WebElement getCancelButton() {
			return cancelButton;
		}

		public void setCancelButton(WebElement cancelButton) {
			this.cancelButton = cancelButton;
		}

		public WebElement getPageCount() {
			return pageCount;
		}

		public void setPageCount(WebElement pageCount) {
			this.pageCount = pageCount;
		}
}
