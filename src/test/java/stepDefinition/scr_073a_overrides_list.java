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
import pom.OverridesPage;
import utils.BrowserFactory;
import utils.BrowserInteractions;

public class scr_073a_overrides_list {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	OverridesPage overrides;	
	
	@Given("^I navigate to the Overrides Page$")
	public void i_navigate_to_the_Overrides_Page() throws Throwable {
	   
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		//Thread.sleep(5000);
	    //BrowserInteractions.click(menu.getSubMenuOverrides());
	    //Thread.sleep(5000);
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuOverrides());
		overrides =new OverridesPage(driver);
	}
	
	@Then("^the Overrides List table will have the correct column <coloum_name> headers$")
	public void the_Overrides_List_table_will_have_the_correct_column_coloum_name_headers(DataTable dataTable) throws Throwable {
	  
		//Thread.sleep(5000);
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='overrides']/thead/tr");
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


