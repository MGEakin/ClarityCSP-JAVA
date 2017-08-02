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
import cucumber.api.java.en.When;
import pom.CombinedPDFsPage;
import pom.MenuSubMenuPage;
import utils.BrowserFactory;
import utils.BrowserInteractions;

public class scr_081_request_combined_pdf_form {

	static WebDriver driver = BrowserFactory.getWebDriver();
	MenuSubMenuPage menu;
	CombinedPDFsPage CombinedPDFs;
	String jobID,printID,groupID,planID;
	
	@Given("^I navigate to Combined PDFs Page$")
	public void i_navigate_to_Combined_PDFs_Page() throws Throwable {
		menu = new MenuSubMenuPage(driver);
		BrowserInteractions.click(menu.getProduction());
		BrowserInteractions.clickWhenElementVisible(driver, menu.getSubMenuPdfs());
	}

	@Given("^I click the Combined PDF - Add Request button$")
	public void i_click_the_Combined_PDF_Add_Request_button() throws Throwable {
	  
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver, CombinedPDFs.getAddRequestButton());
	}

	@Given("^I am on Request a Combined PDF page$")
	public void i_am_on_Request_a_Combined_PDF_page() throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		Thread.sleep(5000);
		Assert.assertTrue("You are not on request a combilned PDFs list page",
				BrowserInteractions.isDisplayed(CombinedPDFs.getRequestPageFirstElement()));
	}

	@When("^I enter \"([^\"]*)\" in the Combined PDF - JOB ID field$")
	public void i_enter_in_the_Combined_PDF_JOB_ID_field(String jobID) throws Throwable {

     	Thread.sleep(3000);
    	CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		this.jobID = jobID;
		CombinedPDFs.getJobId().sendKeys(jobID);
		
	}
		
	@When("^I click the Request Combined PDF - SUBMIT button$")
	public void i_click_the_Request_Combined_PDF_SUBMIT_button() throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		BrowserInteractions.clickWhenElementVisible(driver,CombinedPDFs.getSaveButton());
		BrowserInteractions.clickWhenElementVisible(driver,CombinedPDFs.getOkButton());
	}

	@Then("^the following Combined PDFs row content will be correct$")
	public void the_following_Combined_PDFs_row_content_will_be_correct(DataTable dataTable) throws Throwable {
		CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		List<List<String>> data = dataTable.raw();
		By rowXpath = By.xpath(".//*[@id='prodholds']/tbody/tr[1]"); 
		Thread.sleep(5000);
		WebElement row = driver.findElement(rowXpath);
		List<WebElement> columns = row.findElements(By.tagName("td"));
		for (int cnum = 0; cnum < columns.size(); cnum++)
		{
			Assert.assertEquals("Data mismatch", data.get(1).get(cnum).replaceAll("\\s", ""),
					(columns.get(cnum).getText().replaceAll("\\r|\\n|\\s", "")));
			
		}
		BrowserInteractions.clickWhenElementVisible(driver, CombinedPDFs.getAddRequestButton());
	}

	@When("^I enter \"([^\"]*)\" in the Combined PDF - PRINT ID field$")
	public void i_enter_in_the_Combined_PDF_PRINT_ID_field(String printID) throws Throwable {
		Thread.sleep(3000);
    	CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
    	this.printID = printID;
		CombinedPDFs.getPrintID().sendKeys(printID);
	}

	@When("^I enter \"([^\"]*)\" in the Combined PDF - PROCESSED DATE field$")
	public void i_enter_in_the_Combined_PDF_PROCESSED_DATE_field(String processedDate) throws Throwable {
		
		 CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
		 Thread.sleep(3000);
		 Select dropdown= new Select(CombinedPDFs.getProcessedDateDropdown());
		 dropdown.selectByVisibleText(processedDate.split(",")[0].trim());
		 CombinedPDFs.getProcessedDateFromDate().sendKeys(processedDate.split(",")[1].trim());
		 CombinedPDFs.getProcessedDateToDate().sendKeys(processedDate.split(",")[2].trim());
		 Thread.sleep(5000);
	}	
	
	@When("^I enter \"([^\"]*)\" in the Combined PDF - GROUP ID field$")
	public void i_enter_in_the_Combined_PDF_GROUP_ID_field(String groupID) throws Throwable {
		Thread.sleep(3000);
    	CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
    	this.groupID = groupID;
		CombinedPDFs.getGroupID().sendKeys(groupID);
		
	}
	
	@When("^I enter \"([^\"]*)\" in the Combined PDF - PLAN ID field$")
	public void i_enter_in_the_Combined_PDF_PLAN_ID_field(String planID) throws Throwable {
		Thread.sleep(3000);
    	CombinedPDFsPage CombinedPDFs = new CombinedPDFsPage(driver);
    	this.planID = planID;
		CombinedPDFs.getPlanID().sendKeys(planID);
		
	}
}
