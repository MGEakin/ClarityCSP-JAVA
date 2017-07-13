package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.HoldsPage;
import pom.LoginPage;
import pom.MenuSubMenuPage;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_071a_holds_list {
	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	HoldsPage holds;
	String holdsId;


	@Given("^I navigate to the Holds Page$")
	public void i_navigate_to_the_Holds_Page() throws InterruptedException  {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		//Thread.sleep(3000);
		//BrowserInteractions.click(menu.getHolds());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getHolds());
	}

	

	@Then("^I am on the Holds List page$")
	public void i_am_on_the_Holds_List_page() throws InterruptedException {
		menu = new MenuSubMenuPage(driver);
		holds=new HoldsPage(driver);
		//Thread.sleep(5000);
		//BrowserInteractions.click(menu.getHolds());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getHolds());
		Thread.sleep(5000);
		Assert.assertTrue("navigate to Hold page failed",BrowserInteractions.isDisplayed(holds.getPageTile()));
	}

	
	@When("^I click the Holds - Search button$")
	public void i_click_the_Holds_Search_button() throws Throwable {
		holds=new HoldsPage(driver);
		BrowserInteractions.click(holds.getHoldsSearch());
	}
	

	@Then("^I am on the Holds Search page$")
	public void i_am_on_the_Holds_Search_page() throws Throwable{
		holds=new HoldsPage(driver);
	   Assert.assertTrue("Search page failed", BrowserInteractions.isDisplayed(holds.getHoldsId()));
	   //Thread.sleep(3000);
	   //BrowserInteractions.click(holds.getCancelButton());
	   BrowserInteractions.clickWhenElementVisible(driver, holds.getCancelButton());
	}
	
	@When("^I click the Hold - Add button$")
	public void i_click_the_Hold_Add_button() throws Throwable {
		//Thread.sleep(5000);
		holds=new HoldsPage(driver);
	   // BrowserInteractions.click(holds.getAddHoldsButton());
		 BrowserInteractions.clickWhenElementVisible(driver, holds.getAddHoldsButton());
	}
	

	@Then("^I am on the Add Hold page$")
	public void i_am_on_the_Add_Hold_page() throws InterruptedException  {
		
		Thread.sleep(5000);
	    Assert.assertTrue("Add holds page navigation failed", BrowserInteractions.isDisplayed(holds.getEffectiveDate()));
	    //BrowserInteractions.click(holds.getCancelButton());
	    BrowserInteractions.clickWhenElementVisible(driver, holds.getCancelButton());
	}
	
	@Given("^the holds status display list will contain$")
	public void the_holds_status_display_list_will_contain(DataTable dataTable) throws InterruptedException  {
		List<String> statusList=dataTable.asList(String.class);
		Thread.sleep(5000);
		holds=new HoldsPage(driver);
		List<String> statusListUI=holds.getHoldStatusDisplayList(holds.getHoldStatusDisplay());
		Assert.assertEquals(statusList, statusListUI);
		
	}
	@Then("^the default Holds status selection is \"([^\"]*)\"$")
	public void the_default_Holds_status_selection_is(String displayDropdownVal) throws Throwable {
		holds=new HoldsPage(driver);
		Select dropdown= new Select(holds.getHoldStatusDisplay());
		Assert.assertEquals(displayDropdownVal, dropdown.getFirstSelectedOption().getText());
	}

	
	
	@When("^I select \"([^\"]*)\" in the Holds List Status select list$")
	   public void i_select_in_the_Holds_List_Status_select_list(String displayValue) throws Throwable {
		      holds=new HoldsPage(driver);
		      try{
		    	  if(BrowserInteractions.isDisplayed(holds.getRemovecurrentid())){
		    		  BrowserInteractions.click(holds.getRemovecurrentid());
		    	  }
		      } catch (Exception e) {
			} 
			  Select dropdown= new Select(holds.getHoldStatusDisplay());
			  dropdown.selectByVisibleText(displayValue);
			  Thread.sleep(5000);
	   }

	@Then("^the following holds row content will be correct$")
	public void the_following_holds_row_content_will_be_correct(DataTable dataTable) throws Throwable {
	   List<List<String>> data=dataTable.raw();
	   Thread.sleep(3000);
	   holds=new HoldsPage(driver);
	   Assert.assertEquals("Holds ID mismatch", data.get(1).get(0),(holds.getHoldsListId().getText()));
	   Assert.assertTrue("", data.get(1).get(1).split(" ")[0].trim().equals(holds.getCriteriaC1().getText()));
	   Assert.assertTrue("", data.get(1).get(1).split(" ")[1].trim().equals(holds.getCriteriaC2().getText()));
	   Assert.assertTrue("", data.get(1).get(1).split(" ")[2].trim().equals(holds.getCriteriaC3().getText()));
	   HoldsPage holdsPage=setHoldsPage(data.get(1).get(0));
	   Assert.assertEquals("", data.get(1).get(2),(holdsPage.getListEffectiveDate().getText()));
	   Assert.assertEquals("", data.get(1).get(3),(holdsPage.getListExpirationDate().getText()));
	   Assert.assertEquals("", data.get(1).get(4),(holdsPage.getListAuthor().getText()));
	   Assert.assertEquals("", data.get(1).get(5),(holds.getListHeldOrders().getText()));
	   Assert.assertEquals("", data.get(1).get(6),(holdsPage.getListStatus().getText()));
	   Assert.assertEquals("", data.get(1).get(7),(holds.getListHoldReason().getText()));
	   Assert.assertEquals("", data.get(1).get(8),(holdsPage.getListResolutionReason().getText()));
	}



   public HoldsPage setHoldsPage(String holdsId){
	   HoldsPage holdsPage =new HoldsPage(driver);
	   holdsPage.setListEffectiveDate(driver.findElement(By.xpath(".//*[@id='file_"+holdsId+"_0_effectiveDate']")));
	   holdsPage.setListExpirationDate(driver.findElement(By.xpath(".//*[@id='file_"+holdsId+"_0_expirationDate']")));
	   holdsPage.setListAuthor(driver.findElement(By.xpath(".//*[@id='file_"+holdsId+"_0_creator']")));
	   holdsPage.setListStatus(driver.findElement(By.xpath(".//*[@id='file_"+holdsId+"_0_strStatus']")));
	   holdsPage.setListResolutionReason(driver.findElement(By.xpath(".//*[@id='file_"+holdsId+"_0_resolutionReason']")));
	   
	   return holdsPage;
	   
   }
   
   

	@When("^I search Holds by HOLDS ID with a value of \"([^\"]*)\"$")
	public void i_search_Holds_by_HOLD_ID_with_a_value_of(String holdsId) throws InterruptedException  {
		this.holdsId = holdsId;
		Thread.sleep(3000);
		holds=new HoldsPage(driver);
		BrowserInteractions.click(holds.getHoldsSearch());
		Thread.sleep(2000);
		BrowserInteractions.click(holds.getHoldsId());
		holds.getHoldIdSearchField().sendKeys(holdsId);
		BrowserInteractions.click(holds.getSearchButton());
	}

	@Then("^I see the text \"([^\"]*)\" on the screen$")
	public void i_see_the_text_on_the_screen(String arg1)  throws Throwable{
		holds=new HoldsPage(driver);
	    Assert.assertTrue("bread cums successful", holds.getRemovecurrentid().isDisplayed());
	    Thread.sleep(2000);
	    BrowserInteractions.click(holds.getRemovecurrentid());
	}

	
	@Then("^the Holds List table will have the correct column <column_name> headers$")
	public void the_Holds_List_table_will_have_the_correct_column_column_name_headers(DataTable dataTable) throws Throwable {
		List<String> headerList=dataTable.asList(String.class);
		WebElement row = driver.findElement(By.xpath(".//*[@id='prodholds']/thead/tr"));
		List<WebElement> columns = row.findElements(By.tagName("th"));
		List<String> headerListUI=new ArrayList<String>();
		for (int cnum = 0; cnum < columns.size(); cnum++)
		{
			headerListUI.add(columns.get(cnum).getText());
		}
		Assert.assertEquals(headerList, headerListUI);
	}
	@When("^I select the Holds ID of the first record displayed$")
	public void i_select_the_Holds_ID_of_the_first_record_displayed() throws Throwable {
		holds=new HoldsPage(driver);
		BrowserInteractions.click(holds.getHoldsIDLink());
	}

	@Then("^I am on the Hold Details page$")
	public void i_am_on_the_Hold_Details_page() throws Throwable {
		Thread.sleep(2000);
		holds=new HoldsPage(driver);
		BrowserInteractions.isDisplayed(holds.getHoldsDetailsTitle());
		driver.navigate().back();
		Thread.sleep(2000);
	}

	@When("^I select the Details option from the Gears dropdown$")
	public void i_select_the_Details_option_from_the_Gears_dropdown() throws Throwable {
		holds=new HoldsPage(driver);
		BrowserInteractions.click(holds.getHoldsListGearsDropdown());
		Thread.sleep(2000);
		System.out.println("file_"+holdsId+"_undefined_action_details");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("file_"+holdsId+"_undefined_action_details")));
		BrowserInteractions.click(driver.findElement(By.id("file_"+holdsId+"_undefined_action_details"))); 
	}
}
