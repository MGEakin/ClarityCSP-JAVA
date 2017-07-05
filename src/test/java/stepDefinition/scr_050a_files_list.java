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
import utils.BrowserFactory;
import utils.BrowserInteractions;

public class scr_050a_files_list {
	
	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	
	@Given("^I navigate to the Files Page$")
	public void i_navigate_to_the_Files_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuFiles());
	}
	@Then("^the Files List table will have the correct column <column_name> headers$")
	public void the_Files_List_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
		List<String> headerList=dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='files']/thead/tr"); 
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
