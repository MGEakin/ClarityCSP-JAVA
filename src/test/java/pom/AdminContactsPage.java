package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminContactsPage {

	WebDriver driver;
	public  AdminContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(id="addContactButton")
		WebElement contactButton;
		
		@FindBy(id="adminRouteButton")
		WebElement helloLink;
		
		@FindBy(className="resultsCount")
		WebElement resultsCount;
		
		@FindBy(id="contactEmail")
		WebElement contactEmail;
		
				
		@FindBy(className="landing-holds")
		WebElement contacts;
		
		@FindBy(id="contactEmail_error_0")
		WebElement contactEmailError;
		
		@FindBy(id="contactPhone")
		WebElement contactPhone;
		
		@FindBy(id="contactPhone_error_0")
		WebElement contactPhoneError0;
		
		@FindBy(id="contactPhone_error_1")
		WebElement contactPhoneError1;
		
		@FindBy(xpath="html/body/app-root/div[3]/contacts/h3")
		WebElement pageFirstElement;
		
		@FindBy(xpath="html/body/app-root/div[3]/contacts/div[1]")
		WebElement compareText; 
		
		@FindBy(xpath=".//*[@id='contacts']/thead/tr/th[1]/div")
		WebElement column1;
		
		@FindBy(xpath=".//*[@id='contacts']/thead/tr/th[2]/div")
		WebElement column2;
		
		@FindBy(xpath=".//*[@id='contacts']/thead/tr/th[3]/div")
		WebElement column3;
		 
		@FindBy(xpath=".//*[@id='contacts']/thead/tr/th[4]/div")
		WebElement column4;
		
		@FindBy(xpath=".//*[@id='contacts']/thead/tr/th[5]/div")
		WebElement column5;
		
		@FindBy(xpath=".//*[@id='contacts']/thead/tr/th[6]/div")
		WebElement column6;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[1]")
		WebElement supportRole;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[2]")
		WebElement contactCompany;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[3]")
		WebElement contactName;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[4]")
		WebElement contactEmailId;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[5]")
		WebElement contactPhoneNo;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[6]")
		WebElement homeDisplay;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[7]/table-actions/div/div[1]/div/div/a")
		WebElement editContact;
		
		@FindBy(id="contact_88_undefined_action_editContact")
		WebElement sortedEditButton;
		
		@FindBy(xpath="html/body/app-root/div[3]/contact-details/h3")
		WebElement editPageFirstElement;
		
		@FindBy(id="contactName")  
		WebElement editPageContactName;
		
		@FindBy(id="contactEmail")
		WebElement editPageContactEmail;
		
		@FindBy(id="contactPhone")
		WebElement editPageContactPhone;
		
		@FindBy(id="clientDisplayName")
		WebElement editPageContactCompany;
		
		@FindBy(id="supportRole")
		WebElement editPageSupportRole;
		
		@FindBy(id="displayOption")
		WebElement editPageDisplayContact;
		
		@FindBy(id="RoleName")
		WebElement editPageNewSupportRoleName;
		
		@FindBy(id="saveButton")
		WebElement editPageSaveButton;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[7]/table-actions/div/div[2]/div/div/a")
		WebElement deleteButton;
		
		@FindBy(css=".deletePopup>h3")
		WebElement deletePageFirstElement;
		
		@FindBy(xpath=".//*[@id='cancelButton']")
		WebElement cancelButton;
		
		@FindBy(id="cancelButton")
		WebElement editPageCancelButton;
		
		@FindBy(xpath=".//*[@id='addContactButton'][1]")
		WebElement addContactButton;
		
		@FindBy(xpath=".//*[@id='addContactButton']")
		WebElement manageContactsCancelButton;
		
		@FindBy(xpath="html/body/app-root/div[3]/admin-landing/h3")
		WebElement adminPageFirstTitle;
		
		@FindBy(xpath=".//*[@id='displayCount_contact']")
		WebElement contactsPageCount;
		
		@FindBy(xpath="html/body/app-root/div[3]/contacts/dynamic-table/div/div[1]")
		WebElement pageCountResultCount;
		
		@FindBy(xpath=".//*[@id='contacts']/tbody/tr[1]/td[7]/table-actions/div")
		WebElement actionsElements;
		
		@FindBy(id="displayCount_contact")
		WebElement displayCountContact;
		
		@FindBy(id="pager_next_page")
		WebElement paginationForwardArrow;
		
		@FindBy(className="resultsCount")
		WebElement secondPageResultCount;
		
		@FindBy(xpath=".//*[@id='pager_prev_page']")
		WebElement paginationBackwardArrow;
		
		@FindBy(xpath=".//*[@id='pager_goto_page_2']")
		WebElement pageNo2;
		
		@FindBy(xpath=".//*[@id='addContactButton'][2]")
		WebElement contactsCancelButton;
		
		@FindBy(xpath=".//*[@id='addContactButton'][1]")
		WebElement contactsAddButton;
		
		@FindBy(xpath="html/body/app-root/div[3]/contact-details/div[1]")
		WebElement screenText;
		
		@FindBy(xpath=".//*[@id='saveButton']")
		WebElement saveButton;
		
		@FindBy(id="ok_button")
		WebElement okButton;
		
		@FindBy(id="contacts_sort_1003")
		WebElement sortButton;
		
		@FindBy(xpath=".//*[@id='pager_goto_page_1']")
		WebElement highlightButton;
		
		@FindBy(xpath=".//*[@id='pager_goto_page_2']")
		WebElement highlightButtonPage2;
		 
			
		public WebElement getContactButton() {
			return contactButton;
		}

		public void setContactButton(WebElement contactButton) {
			this.contactButton = contactButton;
		}

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

		public WebElement getContactEmail() {
			return contactEmail;
		}

		public void setContactEmail(WebElement contactEmail) {
			this.contactEmail = contactEmail;
		}

		public WebElement getContacts() {
			return contacts;
		}

		public void setContacts(WebElement contacts) {
			this.contacts = contacts;
		}

		public WebElement getContactEmailError() {
			return contactEmailError;
		}

		public void setContactEmailError(WebElement contactEmailError) {
			this.contactEmailError = contactEmailError;
		}

		public WebElement getContactPhone() {
			return contactPhone;
		}
		
		public WebElement getContactPhoneError0() {
			return contactPhoneError0;
		}

		public void setContactPhoneError0(WebElement contactPhoneError0) {
			this.contactPhoneError0 = contactPhoneError0;
		}

		public WebElement getContactPhoneError1() {
			return contactPhoneError1;
		}

		public void setContactPhoneError1(WebElement contactPhoneError1) {
			this.contactPhoneError1 = contactPhoneError1;
		}

		public void setContactPhone(WebElement contactPhone) {
			this.contactPhone = contactPhone;
		}

		public WebElement getPageFirstElement() {
			return pageFirstElement;
		}

		public void setPageFirstElement(WebElement pageFirstElement) {
			this.pageFirstElement = pageFirstElement;
		}

		public WebElement getCompareText() {
			return compareText;
		}

		public void setCompareText(WebElement compareText) {
			this.compareText = compareText;
		}

		public WebElement getColumn1() {
			return column1;
		}

		public void setColumn1(WebElement column1) {
			this.column1 = column1;
		}

		public WebElement getColumn2() {
			return column2;
		}

		public void setColumn2(WebElement column2) {
			this.column2 = column2;
		}

		public WebElement getColumn3() {
			return column3;
		}

		public void setColumn3(WebElement column3) {
			this.column3 = column3;
		}

		public WebElement getColumn4() {
			return column4;
		}

		public void setColumn4(WebElement column4) {
			this.column4 = column4;
		}

		public WebElement getColumn5() {
			return column5;
		}

		public void setColumn5(WebElement column5) {
			this.column5 = column5;
		}

		public WebElement getColumn6() {
			return column6;
		}

		public void setColumn6(WebElement column6) {
			this.column6 = column6;
		}

		public WebElement getSupportRole() {
			return supportRole;
		}

		public void setSupportRole(WebElement supportRole) {
			this.supportRole = supportRole;
		}

		public WebElement getContactCompany() {
			return contactCompany;
		}

		public void setContactCompany(WebElement contactCompany) {
			this.contactCompany = contactCompany;
		}

		public WebElement getContactName() {
			return contactName;
		}

		public void setContactName(WebElement contactName) {
			this.contactName = contactName;
		}

		public WebElement getContactEmailId() {
			return contactEmailId;
		}

		public void setContactEmailId(WebElement contactEmailId) {
			this.contactEmailId = contactEmailId;
		}

		public WebElement getContactPhoneNo() {
			return contactPhoneNo;
		}

		public void setContactPhoneNo(WebElement contactPhoneNo) {
			this.contactPhoneNo = contactPhoneNo;
		}

		public WebElement getHomeDisplay() {
			return homeDisplay;
		}

		public void setHomeDisplay(WebElement homeDisplay) {
			this.homeDisplay = homeDisplay;
		}

		public WebElement getEditContact() {
			return editContact;
		}

		public void setEditContact(WebElement editContact) {
			this.editContact = editContact;
		}

		public WebElement getEditPageFirstElement() {
			return editPageFirstElement;
		}

		public void setEditPageFirstElement(WebElement editPageFirstElement) {
			this.editPageFirstElement = editPageFirstElement;
		}

		public WebElement getEditPageContactName() {
			return editPageContactName;
		}

		public void setEditPageContactName(WebElement editPageContactName) {
			this.editPageContactName = editPageContactName;
		}

		public WebElement getEditPageContactEmail() {
			return editPageContactEmail;
		}

		public void setEditPageContactEmail(WebElement editPageContactEmail) {
			this.editPageContactEmail = editPageContactEmail;
		}

		public WebElement getEditPageContactPhone() {
			return editPageContactPhone;
		}

		public void setEditPageContactPhone(WebElement editPageContactPhone) {
			this.editPageContactPhone = editPageContactPhone;
		}

		public WebElement getEditPageContactCompany() {
			return editPageContactCompany;
		}

		public void setEditPageContactCompany(WebElement editPageContactCompany) {
			this.editPageContactCompany = editPageContactCompany;
		}

		public WebElement getEditPageSupportRole() {
			return editPageSupportRole;
		}

		public void setEditPageSupportRole(WebElement editPageSupportRole) {
			this.editPageSupportRole = editPageSupportRole;
		}

		public WebElement getEditPageDisplayContact() {
			return editPageDisplayContact;
		}

		public void setEditPageDisplayContact(WebElement editPageDisplayContact) {
			this.editPageDisplayContact = editPageDisplayContact;
		}

		public WebElement getEditPageNewSupportRoleName() {
			return editPageNewSupportRoleName;
		}

		public void setEditPageNewSupportRoleName(WebElement editPageNewSupportRoleName) {
			this.editPageNewSupportRoleName = editPageNewSupportRoleName;
		}

		public WebElement getEditPageSaveButton() {
			return editPageSaveButton;
		}

		public void setEditPageSaveButton(WebElement editPageSaveButton) {
			this.editPageSaveButton = editPageSaveButton;
		}

		public WebElement getDeleteButton() {
			return deleteButton;
		}

		public void setDeleteButton(WebElement deleteButton) {
			this.deleteButton = deleteButton;
		}

		public WebElement getDeletePageFirstElement() {
			return deletePageFirstElement;
		}

		public void setDeletePageFirstElement(WebElement deletePageFirstElement) {
			this.deletePageFirstElement = deletePageFirstElement;
		}


		public WebElement getCancelButton() {
			return cancelButton;
		}

		public void setCancelButton(WebElement cancelButton) {
			this.cancelButton = cancelButton;
		}

		public WebElement getEditPageCancelButton() {
			return editPageCancelButton;
		}

		public void setEditPageCancelButton(WebElement editPageCancelButton) {
			this.editPageCancelButton = editPageCancelButton;
		}

		public WebElement getManageContactsCancelButton() {
			return manageContactsCancelButton;
		}

		public void setManageContactsCancelButton(WebElement manageContactsCancelButton) {
			this.manageContactsCancelButton = manageContactsCancelButton;
		}

		public WebElement getAdminPageFirstTitle() {
			return adminPageFirstTitle;
		}

		public void setAdminPageFirstTitle(WebElement adminPageFirstTitle) {
			this.adminPageFirstTitle = adminPageFirstTitle;
		}

		public WebElement getContactsPageCount() {
			return contactsPageCount;
		}

		public void setContactsPageCount(WebElement contactsPageCount) {
			this.contactsPageCount = contactsPageCount;
		}
		

		public WebElement getPageCountResultCount() {
			return pageCountResultCount;
		}

		public void setPageCountResultCount(WebElement pageCountResultCount) {
			this.pageCountResultCount = pageCountResultCount;
		}

		public WebElement getActionsElements() {
			return actionsElements;
		}

		public void setActionsElements(WebElement actionsElements) {
			this.actionsElements = actionsElements;
		}

		public WebElement getDisplayCountContact() {
			return displayCountContact;
		}


		public void setDisplayCountContact(WebElement displayCountContact) {
			this.displayCountContact = displayCountContact;
		}

		public WebElement getPaginationForwardArrow() {
			return paginationForwardArrow;
		}

		public void setPaginationForwardArrow(WebElement paginationForwardArrow) {
			this.paginationForwardArrow = paginationForwardArrow;
		}

		public WebElement getSecondPageResultCount() {
			return secondPageResultCount;
		}

		public void setSecondPageResultCount(WebElement secondPageResultCount) {
			this.secondPageResultCount = secondPageResultCount;
		}

		public WebElement getPaginationBackwardArrow() {
			return paginationBackwardArrow;
		}

		public void setPaginationBackwardArrow(WebElement paginationBackwardArrow) {
			this.paginationBackwardArrow = paginationBackwardArrow;
		}

		public WebElement getPageNo2() {
			return pageNo2;
		}

		public void setPageNo2(WebElement pageNo2) {
			this.pageNo2 = pageNo2;
		}

		public WebElement getContactsCancelButton() {
			return contactsCancelButton;
		}

		public void setContactsCancelButton(WebElement contactsCancelButton) {
			this.contactsCancelButton = contactsCancelButton;
		}

		public WebElement getContactsAddButton() {
			return contactsAddButton;
		}

		public void setContactsAddButton(WebElement contactsAddButton) {
			this.contactsAddButton = contactsAddButton;
		}

		public WebElement getScreenText() {
			return screenText;
		}

		public void setScreenText(WebElement screenText) {
			this.screenText = screenText;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}

		public void setSaveButton(WebElement saveButton) {
			this.saveButton = saveButton;
		}

		public WebElement getSortButton() {
			return sortButton;
		}

		public void setSortButton(WebElement sortButton) {
			this.sortButton = sortButton;
		}

		public WebElement getOkButton() {
			return okButton;
		}

		public void setOkButton(WebElement okButton) {
			this.okButton = okButton;
		}

		public WebElement getSortedEditButton() {
			return sortedEditButton;
		}

		public void setSortedEditButton(WebElement sortedEditButton) {
			this.sortedEditButton = sortedEditButton;
		}

		public WebElement getHighlightButton() {
			return highlightButton;
		}

		public void setHighlightButton(WebElement highlightButton) {
			this.highlightButton = highlightButton;
		}

		public WebElement getHighlightButtonPage2() {
			return highlightButtonPage2;
		}

		public void setHighlightButtonPage2(WebElement highlightButtonPage2) {
			this.highlightButtonPage2 = highlightButtonPage2;
		}

		public WebElement getAddContactButton() {
			return addContactButton;
		}

		public void setAddContactButton(WebElement addContactButton) {
			this.addContactButton = addContactButton;
		}
}

