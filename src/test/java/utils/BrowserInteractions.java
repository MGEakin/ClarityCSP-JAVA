package utils;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserInteractions {
	static WebDriver driver;
	public BrowserInteractions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public static void click(WebElement element){
		element.click();
	}
	public static boolean isDisplayed(WebElement element){
		if(element == null)
			return false;
		else
		return element.isDisplayed();
	}

	
	public static void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		element = wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	public static void clickWhenElementVisible(WebDriver driver, WebElement element) {
		waitUntilElementIsVisible(driver, element);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", element); 
		jse.executeScript("arguments[0].click();", element);
	}
	
	
	
	public static void waitForHeaderLoad(WebDriver driver, By locator, String headerName) {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.withTimeout(60, TimeUnit.SECONDS);
				wait.pollingEvery(5, TimeUnit.SECONDS);
				wait.ignoring(NoSuchElementException.class);
				wait.until(ExpectedConditions.elementSelectionStateToBe(locator, false));
				wait.until(ExpectedConditions.textToBePresentInElement(locator, headerName));
	}
	   

}
