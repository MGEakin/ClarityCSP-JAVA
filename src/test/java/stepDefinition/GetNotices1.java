package stepDefinition;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import test.DriverFactory;
public class GetNotices1 extends DriverFactory{
	String baseurl ="http://52.86.63.89:8080/csr_home_client_template/login";
	
	@Given("^I am at the login page$")
	public void i_am_at_the_login_page() throws Throwable {
		driver.get(baseurl);
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}

	@When("^I enter by \"(.*?)\"$")
	public void i_enter_by(String MEMBER_NAME) throws Throwable {
		driver.findElement(By.id("membername")).sendKeys(MEMBER_NAME);	   
		
	}
	

	@When("^I provide by \"(.*?)\"$")
	public void i_provide_by(String USER_ID) throws Throwable {
		driver.findElement(By.id("userid")).sendKeys(USER_ID);
	}
	
	@When("^I give by \"(.*?)\"$")
	public void i_give_by(String GROUPNAME) throws Throwable {
	    driver.findElement(By.id("dbgroupname")).sendKeys(GROUPNAME);
	    
	   
	}
	
	@When("^Click on Submit \"(.*?)\"$")
	public void click_on_Submit(String Submit) throws Throwable {
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(3000);	
	}
	
	@Then("^I should be on Homepage$")
	public void i_should_be_on_Homepage() throws Throwable {
	driver.findElement(By.id("menu_home")).click();
	Thread.sleep(3000);
	}
	
	@When("^I click on Hello \"(.*?)\"$")
	public void i_click_on_Hello(String arg1) throws Throwable {
		driver.findElement(By.id("nav_salutation")).click();
		Thread.sleep(3000);
	}
	
	@Then("^I will reach admin page$")
	public void i_will_reach_admin_page() throws Throwable {
		//String bodyText = driver.findElement(By.xpath("html/body/app-root/div[3]/admin-landing/h3")).getText();
		//Assert.assertTrue("Text not found!", bodyText.isEmpty());
	}
	
	@When("^I Click on the \"(.*?)\"$")
	public void i_Click_on_the(String arg1) throws Throwable {
		driver.findElement(By.id("landing-files")).click();
	}
	
	@Then("^I should be Message Notice Page$")
	public void i_should_be_Message_Notice_Page() throws Throwable {
	    
	}
	
	@Then("^I see Main Title \"(.*?)\"$")
	public void i_see_Main_Title(String Manage_Notice_Messages) throws Throwable {
	    Thread.sleep(3000);
	}
	
	@When("^Display filter has Value_Array_to_check$")
	public void display_filter_has_Value_Array_to_check() throws Throwable {
		 WebElement mySelectElement = driver.findElement(By.id("database"));
			System.out.println(mySelectElement.getText());
		
	}
	
	@When("^Results shows \"(.*?)\"$")
	public void results_shows(String Result_string_to_check) throws Throwable {
		WebElement mySelectElement = driver.findElement(By.id("database"));
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByValue(Result_string_to_check);
	}
	
	
	@When("^Table has columns$")
	public void table_has_columns() throws Throwable {
driver.findElement(By.id("123")).getText();
driver.findElement(By.id("notices_sort_123")).click();
driver.findElement(By.id("430")).getText();
Thread.sleep(1000);
driver.findElement(By.id("notices_sort_430")).click();
driver.findElement(By.id("789")).getText();
Thread.sleep(1000);
driver.findElement(By.id("notices_sort_789")).click();
driver.findElement(By.id("889")).getText();
Thread.sleep(1000);
driver.findElement(By.id("notices_sort_889")).click();
driver.findElement(By.id("765")).getText();
Thread.sleep(3000);
	}

	@When("^Items per page shows \"(.*?)\"$")
	public void items_per_page_shows(String value ) throws Throwable {
WebElement displaycountfile = driver.findElement(By.id("displayCount_file"));
Select drop = new Select(displaycountfile);
System.out.println(displaycountfile.getText());
drop.selectByValue(value);
Thread.sleep(2000);
	
	}

	@When("^I see buttons \"(.*?)\" and \"(.*?)\"$")
	public void i_see_buttons_and(String button1, String button2) throws Throwable {
	    driver.findElement(By.id(button1)).click();
	    Thread.sleep(3000);

	    driver.findElement(By.id(button2)).click();
	}
	
	
	
	
	
	//@Then("^I will navigate to Notice page$")
	//public void i_will_navigate_to_Notice_page() throws Throwable {
		//driver.findElement(By.id("nav_salutation")).click();
	    //driver.findElement(By.id("landing-files")).click();
	    //Thread.sleep(3000);
	//}

	//@When("^I Filter by \"(.*?)\"$")
//	public void i_Filter_by(String All) throws Throwable {
	//	WebElement mySelectElement = driver.findElement(By.id("database"));
		//Select dropdown= new Select(mySelectElement);
		//System.out.println(mySelectElement.getText());
		   // dropdown.selectByValue(All);
		    //List<WebElement> options = mySelectElement.findElements(By.tagName("All"));
	        //for (WebElement option : options) {
	          //  if("All".equals(option.getText())){
	            //    System.out.println("Its All");
		
	//}
	  //      }
	//}
	//@Then("^I see correct Result$")
	//public void i_see_correct_Result() throws Throwable {
		//Thread.sleep(3000);
		//WebElement mySelectElement2 = driver.findElement(By.id("displayCount_file"));
		//Select dropdown= new Select(mySelectElement2);
		//dropdown.selectByValue("50");
		//Thread.sleep(3000);
		
		
		
		  
	        
	          
	              //("database"));
		    //Count the Values
		    
		
	//}

	}
	
