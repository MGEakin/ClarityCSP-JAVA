package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoldsPage {
	WebDriver driver;
	public HoldsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="container-fluid>prodholds>h3")
	WebElement pageTitle;
	@FindBy(id="available_id")
	WebElement holdsId;
	@FindBy(xpath="html/body/app-root/div[3]/prodholds/div[1]/a[2]")
	WebElement addHoldsButton;
	@FindBy(id="files_search")
	WebElement holdsSearch;
	@FindBy(id="cancelButton")
	WebElement cancelButton;
	@FindBy(id="effectiveDate")
	WebElement effectiveDate;
	@FindBy(id="holdStatusDisplay")
	WebElement holdStatusDisplay;
	
	@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[1]")
	WebElement holdsListId;
	
	@FindBy(className = "resultsCount")
	WebElement resultsCount;
	
	@FindBy(xpath=".//*[@id='c1']")
	WebElement criteriaC1;
	 
	@FindBy(xpath=".//*[@id='c2']")
	WebElement criteriaC2;
	
	
	@FindBy(xpath=".//*[@id='c3']")
	WebElement criteriaC3;
	
	
	@FindBy(xpath=".//*[@id='file_1_0_effectiveDate']")
	WebElement listEffectiveDate;
	

	@FindBy(xpath=".//*[@id='file_1_0_expirationDate']")
	WebElement listExpirationDate;

	
	@FindBy(xpath=".//*[@id='file_1_0_creator']")
	WebElement listAuthor;
	
	
	@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[6]")
	WebElement listHeldOrders;
	

	@FindBy(xpath=".//*[@id='file_1_0_strStatus']")
	WebElement listStatus;
	
	
	@FindBy(xpath=".//*[@id='prodholds']/tbody/tr[1]/td[8]")
	WebElement listHoldReason;
	
	
	@FindBy(xpath=".//*[@id='file_1_0_resolutionReason']")
	WebElement listResolutionReason;
	
	@FindBy(id="remove_current_id")
	WebElement holdBreadCrumId;
	
	@FindBy(id="id")
	WebElement holdIdSearchField;
	
	@FindBy(id="remove_current_id")
	WebElement removecurrentid;
	
	@FindBy(id="searchButton")
	WebElement searchButton;
	
	@FindBy(id="file_1_0_filterID")
	WebElement holdsIDLink;
	
	@FindBy(xpath="html/body/app-root/div[3]/holddetails/h3")
	WebElement holdsDetailsTitle;
	
	@FindBy(xpath=".//*[@id='prodholds']/tbody/tr/td[10]/table-actions/div/popover/div")
	
	WebElement holdsListGearsDropdown;
	
	@FindBy(id="file_12114_undefined_action_details")
	WebElement detailsOptionInGreasDropdown;
	
	@FindBy(id="expirationDate")
	WebElement expirationDate;
	
	@FindBy(id="saveButton")
	WebElement saveButton;
	
	
	
	public WebElement getHoldsSearch() {
		return holdsSearch;
	}

	public void setHoldsSearch(WebElement holdsSearch) {
		this.holdsSearch = holdsSearch;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(WebElement pageTitle) {
		this.pageTitle = pageTitle;
	}

	public WebElement getHoldsId() {
		return holdsId;
	}

	public void setHoldsId(WebElement holdsId) {
		this.holdsId = holdsId;
	}

	public WebElement getPageTile() {
		return pageTitle;
	}

	public void setPageTile(WebElement pageTile) {
		this.pageTitle = pageTile;
		
	}
	public WebElement getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(WebElement cancelButton) {
		this.cancelButton = cancelButton;
	}

	public WebElement getAddHoldsButton() {
		return addHoldsButton;
	}

	public void setAddHoldsButton(WebElement addHoldsButton) {
		this.addHoldsButton = addHoldsButton;
	}

	public WebElement getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(WebElement effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	

	public WebElement getHoldStatusDisplay() {
		return holdStatusDisplay;
	}

	public void setHoldStatusDisplay(WebElement holdStatusDisplay) {
		this.holdStatusDisplay = holdStatusDisplay;
	}


	public List<String> getHoldStatusDisplayList(WebElement element){
		
		List<String> dropDown=new ArrayList<String>();
		List<WebElement> options = element.findElements(By.tagName("option"));
		for (WebElement option : options) {
			dropDown.add(option.getText().trim());
		}
		return dropDown;
	}

	public WebElement getHoldsListId() {
		return holdsListId;
	}

	public void setHoldsListId(WebElement holdsListId) {
		this.holdsListId = holdsListId;
	}

	public WebElement getCriteriaC1() {
		return criteriaC1;
	}

	public void setCriteriaC1(WebElement criteriaC1) {
		this.criteriaC1 = criteriaC1;
	}

	public WebElement getCriteriaC2() {
		return criteriaC2;
	}

	public void setCriteriaC2(WebElement criteriaC2) {
		this.criteriaC2 = criteriaC2;
	}

	public WebElement getCriteriaC3() {
		return criteriaC3;
	}

	public void setCriteriaC3(WebElement criteriaC3) {
		this.criteriaC3 = criteriaC3;
	}

	public WebElement getListEffectiveDate() {
		return listEffectiveDate;
	}

	public void setListEffectiveDate(WebElement listEffectiveDate) {
		this.listEffectiveDate = listEffectiveDate;
	}

	public WebElement getListExpirationDate() {
		return listExpirationDate;
	}

	public void setListExpirationDate(WebElement listExpirationDate) {
		this.listExpirationDate = listExpirationDate;
	}

	public WebElement getListAuthor() {
		return listAuthor;
	}

	public void setListAuthor(WebElement listAuthor) {
		this.listAuthor = listAuthor;
	}

	public WebElement getListHeldOrders() {
		return listHeldOrders;
	}

	public void setListHeldOrders(WebElement listHeldOrders) {
		this.listHeldOrders = listHeldOrders;
	}

	public WebElement getListStatus() {
		return listStatus;
	}

	public void setListStatus(WebElement listStatus) {
		this.listStatus = listStatus;
	}

	public WebElement getListHoldReason() {
		return listHoldReason;
	}

	public void setListHoldReason(WebElement listHoldReason) {
		this.listHoldReason = listHoldReason;
	}

	public WebElement getListResolutionReason() {
		return listResolutionReason;
	}

	public void setListResolutionReason(WebElement listResolutionReason) {
		this.listResolutionReason = listResolutionReason;
	}

	public WebElement getHoldBreadCrumId() {
		return holdBreadCrumId;
	}

	public void setHoldBreadCrumId(WebElement holdBreadCrumId) {
		this.holdBreadCrumId = holdBreadCrumId;
	}

	public WebElement getHoldIdSearchField() {
		return holdIdSearchField;
	}

	public void setHoldIdSearchField(WebElement holdIdSearchField) {
		this.holdIdSearchField = holdIdSearchField;
	}

	public WebElement getRemovecurrentid() {
		return removecurrentid;
	}

	public void setRemovecurrentid(WebElement removecurrentid) {
		this.removecurrentid = removecurrentid;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}

	public WebElement getHoldsIDLink() {
		return holdsIDLink;
	}

	public void setHoldsIDLink(WebElement holdsIDLink) {
		this.holdsIDLink = holdsIDLink;
	}

	public WebElement getHoldsDetailsTitle() {
		return holdsDetailsTitle;
	}

	public void setHoldsDetailsTitle(WebElement holdsDetailsTitle) {
		this.holdsDetailsTitle = holdsDetailsTitle;
	}

	public WebElement getHoldsListGearsDropdown() {
		return holdsListGearsDropdown;
	}

	public void setHoldsListGearsDropdown(WebElement holdsListGearsDropdown) {
		this.holdsListGearsDropdown = holdsListGearsDropdown;
	}

	public WebElement getDetailsOptionInGreasDropdown() {
		return detailsOptionInGreasDropdown;
	}

	public void setDetailsOptionInGreasDropdown(WebElement detailsOptionInGreasDropdown) {
		this.detailsOptionInGreasDropdown = detailsOptionInGreasDropdown;
	}
	
	public WebElement getResultsCount() {
		return resultsCount;
	}

	public void setResultsCount(WebElement resultsCount) {
		this.resultsCount = resultsCount;
	}

	public WebElement getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(WebElement expirationDate) {
		this.expirationDate = expirationDate;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}
	
}
