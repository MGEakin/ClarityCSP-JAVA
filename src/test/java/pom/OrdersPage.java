package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="processed_date_pulldown")
	WebElement processedDatePulldown;
	
	@FindBy(xpath=".//*[@id='orders']/thead/tr")
	WebElement ordersListId;
	
	@FindBy(xpath="html/body/app-root/div[3]/members/dynamic-table/div/div[1]")
	WebElement membersResultCount;
	
	@FindBy(xpath=".//*[@id='ordersDiv']/dynamic-table/div/div[1]")
	WebElement ordersResultCount;
	
	@FindBy(xpath="html/body/app-root/div[3]/members/div/div")
	WebElement GroupID;
	
	
	@FindBy(id="State")
	WebElement State;
	

	@FindBy(id="searchButton1")
	WebElement searchButton1;
	
	
	
	public WebElement getGroupID() {
		return GroupID;
	}

	public void setGroupID(WebElement groupID) {
		GroupID = groupID;
	}

	public WebElement getOrdersResultCount() {
		return ordersResultCount;
	}

	public void setOrdersResultCount(WebElement ordersResultCount) {
		this.ordersResultCount = ordersResultCount;
	}

	public WebElement getMembersResultCount() {
		return membersResultCount;
	}

	public void setMembersResultCount(WebElement membersResultCount) {
		this.membersResultCount = membersResultCount;
	}

	public WebElement getOrdersListId() {
		return ordersListId;
	}

	public void setOrdersListId(WebElement ordersListId) {
		this.ordersListId = ordersListId;
	}

	public WebElement getProcessedDatePulldown() {
		return processedDatePulldown;
	}

	public void setProcessedDatePulldown(WebElement processedDatePulldown) {
		this.processedDatePulldown = processedDatePulldown;
	}

	public WebElement getSearchButton1() {
		return searchButton1;
	}

	public void setSearchButton1(WebElement searchButton1) {
		this.searchButton1 = searchButton1;
	}

	public WebElement getState() {
		return State;
	}

	public void setState(WebElement state) {
		State = state;
	}
}
