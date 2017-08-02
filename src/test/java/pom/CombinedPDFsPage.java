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
		
		@FindBy(id="jobId")
		WebElement jobId;
		
		@FindBy(id="saveButton")
		WebElement saveButton;
		
		@FindBy(id="ok_button")
		WebElement okButton;
		
		@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[1]")
		WebElement requestDate;
		
		@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[2]")
		WebElement description;
		
		@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[3]")
		WebElement author;
		
		@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[4]")
		WebElement status;
		
		@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[5]")
		WebElement results;
		
		@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[6]")
		WebElement actions;
		
		@FindBy(id="printId")
		WebElement printID;
		
		@FindBy(id="groupId")
		WebElement groupID;
		
		@FindBy(id="planId")
		WebElement planID;
		
		@FindBy(xpath="html/body/app-root/div[3]/addpdfrequest/div[2]/edit-component/div/div[1]/form/div[3]/div/date-range/div/div")
		WebElement processedDate;
		
		@FindBy(id="processedDate_pulldown")
		WebElement processedDateDropdown;
		
		@FindBy(id="processedDate_from_date")
		WebElement processedDateFromDate;
		
		@FindBy(id="processedDate_to_date")
		WebElement processedDateToDate;
		
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

		public WebElement getJobId() {
			return jobId;
		}

		public void setJobId(WebElement jobId) {
			this.jobId = jobId;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}

		public void setSaveButton(WebElement saveButton) {
			this.saveButton = saveButton;
		}

		public WebElement getOkButton() {
			return okButton;
		}

		public void setOkButton(WebElement okButton) {
			this.okButton = okButton;
		}

		public WebElement getRequestDate() {
			return requestDate;
		}

		public void setRequestDate(WebElement requestDate) {
			this.requestDate = requestDate;
		}

		public WebElement getDescription() {
			return description;
		}

		public void setDescription(WebElement description) {
			this.description = description;
		}

		public WebElement getAuthor() {
			return author;
		}

		public void setAuthor(WebElement author) {
			this.author = author;
		}

		public WebElement getStatus() {
			return status;
		}

		public void setStatus(WebElement status) {
			this.status = status;
		}

		public WebElement getResults() {
			return results;
		}

		public void setResults(WebElement results) {
			this.results = results;
		}

		public WebElement getActions() {
			return actions;
		}

		public void setActions(WebElement actions) {
			this.actions = actions;
		}

		public WebElement getPrintID() {
			return printID;
		}

		public void setPrintID(WebElement printID) {
			this.printID = printID;
		}

		public WebElement getProcessedDateDropdown() {
			return processedDateDropdown;
		}

		public void setProcessedDateDropdown(WebElement processedDateDropdown) {
			this.processedDateDropdown = processedDateDropdown;
		}

		public WebElement getGroupID() {
			return groupID;
		}

		public void setGroupID(WebElement groupID) {
			this.groupID = groupID;
		}

		public WebElement getPlanID() {
			return planID;
		}

		public void setPlanID(WebElement planID) {
			this.planID = planID;
		}

		public WebElement getProcessedDateFromDate() {
			return processedDateFromDate;
		}

		public void setProcessedDateFromDate(WebElement processedDateFromDate) {
			this.processedDateFromDate = processedDateFromDate;
		}

		public WebElement getProcessedDateToDate() {
			return processedDateToDate;
		}

		public void setProcessedDateToDate(WebElement processedDateToDate) {
			this.processedDateToDate = processedDateToDate;
		}

		public WebElement getProcessedDate() {
			return processedDate;
		}

		public void setProcessedDate(WebElement processedDate) {
			this.processedDate = processedDate;
		}
}
