package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.json.JsonObject;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pom.FilesPage;
import pom.MenuSubMenuPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

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
	
	@Then("^the Files result count will be as expected$")
	public void the_Files_result_count_will_be_as_expected() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String filesRequestParameters = "{\"language\":\"ENGLISH\",\"fileSearchCriteria\":{\"groupDescriptor\":{\"dbName\":\""+properties.getProperty("dbName")+"\",\"groupName\":\""+properties.getProperty("groupName")+"\"},\"startPage\":1,\"pageSize\":20}}";
		String filesResponse = APICall.getResponse(APIURL+"/jobprocessing/getFiles?token="+token, filesRequestParameters);
		JsonObject object = APIUtils.getJSONObjectFromResponse(filesResponse, "processedFileInfoResults");
		String APIRowCount = APIUtils.getValueFromResponse(object.toString(), "count", "int");
		
		FilesPage filesPage = new FilesPage(driver);
		String UIRowCount = filesPage.getResultCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
	}
	
}
