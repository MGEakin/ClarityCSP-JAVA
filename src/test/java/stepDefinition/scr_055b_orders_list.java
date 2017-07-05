package stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pom.MenuSubMenuPage;
import pom.OrdersPage;
import utils.BrowserFactory;
import utils.BrowserInteractions;

public class scr_055b_orders_list {
	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	OrdersPage orders;
	@Given("^I navigate to the Orders List Page$")
	public void i_navigate_to_the_Orders_List_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		//Thread.sleep(5000);
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuOrders());
	   // BrowserInteractions.click(menu.getSubMenuOrders());
	   // Thread.sleep(5000);
	    orders =new OrdersPage(driver);
	    BrowserInteractions.waitUntilElementIsVisible(driver, orders.getProcessedDatePulldown());
	    Select dropdown= new Select(orders.getProcessedDatePulldown());
		dropdown.selectByVisibleText("Current Month");
		BrowserInteractions.click(orders.getSearchButton());
				}

	@Then("^the Orders List table will have the correct column <column_name> headers$")
	public void the_Orders_List_table_will_have_the_correct_column_column_name_headers(DataTable processedDate) throws Throwable {
		List<String> headerList=processedDate.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='orders']/thead/tr"); 
		BrowserInteractions.waitForHeaderLoad(driver, rowXpath, headerList.get(0));
		
		WebElement row = driver.findElement(rowXpath);
		List<WebElement> columns = row.findElements(By.tagName("th"));
		List<String> headerListUI=new ArrayList<String>();
		for (int cnum = 0; cnum < columns.size(); cnum++)
		{
			headerListUI.add(columns.get(cnum).getText());
		}
		Assert.assertEquals(headerList, headerListUI);
	}
}
