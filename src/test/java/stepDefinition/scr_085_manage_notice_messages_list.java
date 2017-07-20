package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pom.MenuSubMenuPage;
import pom.NoticesPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_085_manage_notice_messages_list {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	NoticesPage notices;
	
		@Given("^I navigate to the Notices Page$")
		public void i_navigate_to_the_Notices_Page() throws Throwable {
			notices = new NoticesPage(driver);
			BrowserInteractions.click(notices.getHelloLink());
			BrowserInteractions.clickWhenElementVisible(driver, notices.getNoticeMessages());
			
		}
		
		
		@Then("^the Notices table will have the correct column <column_name> headers$")
		public void the_Notices_table_will_have_the_correct_column_headers(DataTable dataTable) throws Throwable {	
			List<String> headerList=dataTable.asList(String.class);
			By rowXpath = By.xpath(".//*[@id='notices']/thead/tr"); 
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
				    
	@Then("^the Notices result count will be as expected$")
		public void the_Notices_result_count_will_be_as_expected() throws Throwable {
		    
			Properties properties = PropertiesLoad.loadFromFile("config.properties");
			String APIURL = properties.getProperty("api.url");
			String token = APIUtils.getToken();
			String noticesRequestParameters = "{\"language\":\"ENGLISH\",\"noticesSearchRequest\":{\"startPage\":1,\"pageSize\":20,\"claritySystemID\":\"claritytestcards\",\"groupDescriptor\":{\"dbName\":\"claritytestcards\",\"groupName\":\"TestCardsOperation\"},\"clientname\":\"All\"}}";
			String noticesResponse = APICall.getResponse(APIURL+"/ancillary/getNotices?token="+token, noticesRequestParameters);
			String APIRowCount = APIUtils.getValueFromResponse(noticesResponse, "rowsFound", "int");
			
			NoticesPage noticesPage = new NoticesPage(driver);
			String UIRowCount = noticesPage.getResultsCount().getText().split("of")[1].trim();
			
			Assert.assertTrue("API count "+APIRowCount+" not matched UI count"+UIRowCount, StringUtils.equals(APIRowCount, UIRowCount));
		}

}
				
				
			

			

