package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CombinedPDFsPage {

	WebDriver driver;
	public  CombinedPDFsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
		@FindBy(className="resultsCount")
		WebElement resultCount;
		
		
		public WebElement getResultCount() {
			return resultCount;
		}

		public void setResultCount(WebElement resultCount) {
			this.resultCount = resultCount;
		}
		
		
	
	
}
