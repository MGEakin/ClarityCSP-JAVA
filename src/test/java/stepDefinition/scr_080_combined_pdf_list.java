package stepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.json.JsonArray;
import javax.json.JsonObject;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.CombinedPDFsPage;
import pom.LoginPage;
import pom.MenuSubMenuPage;
import utils.APICall;
import utils.APIUtils;
import utils.BrowserFactory;
import utils.BrowserInteractions;
import utils.PropertiesLoad;

public class scr_080_combined_pdf_list {
	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	CombinedPDFsPage CombinedPDFs;

	@Given("^I log into the Clarity Service Portal$")
	public void i_log_into_the_Clarity_Service_Portal() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		driver.get(properties.getProperty("centric_url"));
		LoginPage login = new LoginPage(driver);
		BrowserInteractions.waitUntilElementIsVisible(driver, login.getMemberName());
		login.getMemberName().sendKeys(properties.getProperty("memberName"));
		login.getUserId().sendKeys(properties.getProperty("userId"));
		login.getDbGroupName().sendKeys(properties.getProperty("dbGroupName"));
		BrowserInteractions.click(login.getLoginBtn());
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.waitUntilElementIsVisible(driver, menu.getHomeMenu());
		Assert.assertTrue("Login Failed", BrowserInteractions.isDisplayed(menu.getHomeMenu()));
	}

	@Given("^I navigate to the Combined PDFs Page$")
	public void i_navigate_to_the_Combined_PDFs_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());
	}
	
	@Then("^the Combined PDFs List table will have the correct column <column_name> headers$")
	public void the_Combined_PDFs_List_table_will_have_the_correct_column_column_name_headers(DataTable dataTable)
			throws Throwable {
		Thread.sleep(3000);
		List<String> headerList = dataTable.asList(String.class);
		By rowXpath = By.xpath(".//*[@id='prodholds']/thead/tr");
		BrowserInteractions.waitForHeaderLoad(driver, rowXpath, headerList.get(0));
		WebElement row = driver.findElement(rowXpath);
		List<WebElement> columns = row.findElements(By.tagName("th"));
		List<String> headerListUI = new ArrayList<String>();
		for (int cnum = 0; cnum < columns.size(); cnum++) {
			headerListUI.add(columns.get(cnum).getText());
		}
		Assert.assertEquals(headerList, headerListUI);
	}
	
	@Then("^the Combined PDFs result count will be as expected$")
	public void the_Combined_PDFs_result_count_will_be_as_expected() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String combinedPdFsRequestParameters = "{\"language\":\"ENGLISH\",\"groupDescriptor\":{\"dbName\":\""
				+ properties.getProperty("dbName") + "\",\"groupName\":\"" + properties.getProperty("groupName")
				+ "\"},\"combinedPDFSearchRequest\":{\"startPage\":1,\"pageSize\":20,\"days\":3000}}";
		String combinedPDFsResponse = APICall.getResponse(APIURL + "/combinedpdf/getCombinedPDFs?token=" + token,
				combinedPdFsRequestParameters);
		String APIRowCount = APIUtils.getValueFromResponse(combinedPDFsResponse, "rowsFound", "int");
		CombinedPDFsPage combinedPDFsPage = new CombinedPDFsPage(driver);
		String UIRowCount = combinedPDFsPage.getResultCount().getText().split("of")[1].trim();
		Assert.assertTrue("API count " + APIRowCount + " not matched UI count" + UIRowCount,
				StringUtils.equals(APIRowCount, UIRowCount));
	}

	@Then("^I am on the page Combined PDFs List page$")
	public void i_am_on_the_page_Combined_PDFs_List_page() throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("You are not on combilned PDFs list page",
				BrowserInteractions.isDisplayed(CombinedPDFs.getPageFirstElement()));
	}
	
	@When("^I click the \"([^\"]*)\" button$")
	public void i_click_the_button(String arg1) throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver, CombinedPDFs.getRefreshButton());
	}

	@Then("^I am on the Combined PDFs List page$")
	public void i_am_on_the_Combined_PDFs_List_page() throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("You are not on combilned PDFs list page",
				BrowserInteractions.isDisplayed(CombinedPDFs.getPageFirstElement()));
	}

	@When("^I click the Add Request \"([^\"]*)\" button$")
	public void i_click_the_Add_Request_button(String arg1) throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver, CombinedPDFs.getAddRequestButton());
	}

	@Then("^I am on the Request a Combined PDF page$")
	public void i_am_on_the_Request_a_Combined_PDF_page() throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("You are not on request a combilned PDFs list page",
				BrowserInteractions.isDisplayed(CombinedPDFs.getRequestPageFirstElement()));
	}

	@Given("^the combined_pdf_list page count display list will contain$")
	public void the_combined_pdf_list_page_count_display_list_will_contain(DataTable dataTable) throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		Thread.sleep(5000);
		List<String> dropdownList = dataTable.asList(String.class);
		List<String> dropdownListUI = BrowserInteractions.getDropDownList(CombinedPDFs.getPageCount());
		Assert.assertEquals("The values in the page count dropdown are not correct", dropdownList, dropdownListUI);
	}

	@Then("^the default page in combined_PDfs selection is \"([^\"]*)\"$")
	public void the_default_page_in_combined_PDfs_selection_is(String displayCount) throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		Thread.sleep(3000);
		Select dropdown = new Select(CombinedPDFs.getPageCount());
		Assert.assertEquals("Default page count is not 20", displayCount, dropdown.getFirstSelectedOption().getText());
	}

	@When("^I select \"([^\"]*)\" in the Pagination - CombinedPDFs select list$")
	public void i_select_in_the_Pagination_CombinedPDFs_select_list(String pageCount) throws Throwable {
		CombinedPDFs = new CombinedPDFsPage(driver);
		Select dropdown = new Select(CombinedPDFs.getPageCount());
		dropdown.selectByVisibleText(pageCount);
	}

	@Then("^the CombinedPDFs result count will be as expected$")
	public void the_CombinedPDFs_result_count_will_be_as_expected() throws Throwable {
		CombinedPDFs = new CombinedPDFsPage(driver);
		Thread.sleep(3000);
		String totalRecordCounts = CombinedPDFs.getResultCount().getText().split("of")[1].trim();
		String pageResults = CombinedPDFs.getResultCount().getText().split("to")[1].trim().split("of")[0].trim();
		int totalRecordCount = Integer.parseInt(totalRecordCounts);
		int pageResult = Integer.parseInt(pageResults);
		Select dropdown = new Select(CombinedPDFs.getPageCount());
		int pageCount = Integer.valueOf(dropdown.getFirstSelectedOption().getText());
		if (totalRecordCount > pageCount) {
			Assert.assertTrue("Result count is as expected", pageResult==pageCount);
		} else {
			Assert.assertTrue("Result count is not as expected", pageResult <= pageCount);
		}
	}
	
	@When("^I select the page count as \"([^\"]*)\" in the Pagination - CombinedPDFs select list$")
	public void i_select_the_page_count_as_in_the_Pagination_CombinedPDFs_select_list(String pageCount) throws Throwable {
		CombinedPDFs = new CombinedPDFsPage(driver);
		Select dropdown = new Select(CombinedPDFs.getPageCount());
		dropdown.selectByVisibleText(pageCount);
	}

	@Then("^the CombinedPDFs result count in API will be as expected$")
	public void the_CombinedPDFs_result_count_in_API_will_be_as_expected() throws Throwable {
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String APIURL = properties.getProperty("api.url");
		String token = APIUtils.getToken();
		String pageCountStr =  new Select(CombinedPDFs.getPageCount()).getFirstSelectedOption().getText();
		int pageCount = Integer.parseInt(pageCountStr);
		String combinedPdFsRequestParameters = "{\"language\":\"ENGLISH\",\"groupDescriptor\":{\"dbName\":\""
				+ properties.getProperty("dbName") + "\",\"groupName\":\"" + properties.getProperty("groupName")
				+ "\"},\"combinedPDFSearchRequest\":{\"startPage\":1,\"pageSize\":"+pageCountStr+",\"days\":3000}}";
		String combinedPDFsResponse = APICall.getResponse(APIURL + "/combinedpdf/getCombinedPDFs?token=" + token,
				combinedPdFsRequestParameters);
		String totalRecordCountStr = APIUtils.getValueFromResponse(combinedPDFsResponse, "rowsFound", "int");
		int totalRecordCount = Integer.parseInt(totalRecordCountStr);
		
		JsonObject response = APIUtils.getJSONObjectFromResponse(combinedPDFsResponse, "combinedPDFEntriesResults");
		JsonArray array = response.getJsonArray("combinedPDFEntry");
		if (totalRecordCount > pageCount) {
			Assert.assertTrue("I selected page count as "+pageCount+" but in API rows count is "+array.size(), array.size()==pageCount);
		} else {
			Assert.assertTrue("I selected page count as "+pageCount+" but in API rows count is "+array.size(), array.size() <= pageCount);
		}
		
	}

}
