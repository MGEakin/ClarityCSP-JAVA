package stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pom.MenuSubMenuPage;
import pom.SampleOrdersPage;
import utils.BrowserFactory;
import utils.BrowserInteractions;

public class scr_098a_sample_order_list {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	SampleOrdersPage sampleorders;
	
	@Given("^I navigate to the Sample Orders Page$")
	public void i_navigate_to_the_Sample_Orders_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		//Thread.sleep(10000);
		BrowserInteractions.clickWhenElementVisible(driver,menu.getSubMenuSampleOrders());
//	    BrowserInteractions.click(menu.getSubMenuSampleOrders());
//	    Thread.sleep(5000);
	    sampleorders =new SampleOrdersPage(driver);
	}

	@Then("^the Sample Orders List table will have the correct column <column_name> headers$")
	public void the_Sample_Orders_List_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
	   
		// Thread.sleep(50000);
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='prodholds']/thead/tr"); 
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
