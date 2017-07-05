package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	static WebDriver driver;

	public static synchronized WebDriver getWebDriver() {
		try{
		Properties properties = PropertiesLoad.loadFromFile("config.properties");
		String browserName = properties.getProperty("browserName");
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.geckodriver.path")); 
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			if(driver == null){
			driver = new FirefoxDriver(capabilities);
			}
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
			if(driver == null){
			driver = new ChromeDriver();
			}
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", properties.getProperty("IE.driver.path"));
			if(driver == null){
			driver = new InternetExplorerDriver();
			}
		}
		driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
}