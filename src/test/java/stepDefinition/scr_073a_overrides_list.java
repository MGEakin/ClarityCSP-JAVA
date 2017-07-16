package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pom.MenuSubMenuPage;
import pom.OverridesPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_073a_overrides_list {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	OverridesPage overridesPage;	
	
	@Given("^I navigate to the Overrides Page$")
	public void i_navigate_to_the_Overrides_Page() throws Throwable {
	   
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		//Thread.sleep(5000);
	    //BrowserInteractions.click(menu.getSubMenuOverrides());
	    //Thread.sleep(5000);
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuOverrides());
		overridesPage =new OverridesPage(driver);
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
	
	@Given("^I select \"([^\"]*)\" in the Overrides Type select list$")
	public void i_select_in_the_Overrides_Type_select_list(String displayValue) throws Throwable {
	   overridesPage =new OverridesPage(driver);
	   Select selectBox= new Select(overridesPage.getOverrideTypeDisplay());
	   selectBox.selectByVisibleText(displayValue);
	}

	@Then("^the Overrides result count will be as expected$")
	public void the_Overrides_result_count_will_be_as_expected() throws Throwable {
	    Thread.sleep(3000);
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
			
		String overridesRequestParameters = "";
		overridesPage =new OverridesPage(driver);
		Select selectBox= new Select(overridesPage.getOverrideTypeDisplay());
		String selectedValue = selectBox.getFirstSelectedOption().getText();
		if(selectedValue.equalsIgnoreCase("All")){
			overridesRequestParameters = "{\"language\": \"ENGLISH\",\"overrideSummarySearchCriteria\": {\"startPage\":1,\"pageSize\":20,\"groupDescriptor\" : {\"dbName\": \""+properties.getProperty("dbName")+"\",\"groupName\": \""+properties.getProperty("groupName")+"\"}}}";
		}else if(selectedValue.equalsIgnoreCase("Mine")){
			overridesRequestParameters = "{\"language\": \"ENGLISH\",\"overrideSummarySearchCriteria\": {\"startPage\":1,\"pageSize\":20,\"groupDescriptor\" : {\"dbName\": \""+properties.getProperty("dbName")+"\",\"groupName\": \""+properties.getProperty("groupName")+"\"},\"user\":\""+properties.getProperty("userId")+"\"}}";
		} 		
		else{
			overridesRequestParameters = "{\"language\": \"ENGLISH\",\"overrideSummarySearchCriteria\": {\"startPage\":1,\"pageSize\":20,\"groupDescriptor\" : {\"dbName\": \""+properties.getProperty("dbName")+"\",\"groupName\": \""+properties.getProperty("groupName")+"\"},\"status\":\"U\"}}";
		}
		
		String overridesResponse = APICall.getResponse(APIURL+"/overrides/getOverrides?token="+token, overridesRequestParameters);
		String APIRowCount = APIUtils.getValueFromResponse(overridesResponse, "rowsFound", "int");
		
		OverridesPage overridesPage = new OverridesPage(driver);
		String UIRowCount = overridesPage.getResultsCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count "+UIRowCount+" for selected "+selectedValue, StringUtils.equals(APIRowCount, UIRowCount));
	}
		
	}


