package pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="html/body/app-root/div[2]/ng-component/div/div/p[4]/span")
	WebElement glyphiconPlay;
	@FindBy(id="loginbtn")
    WebElement loginBtn;
	
	public WebElement getGlyphiconPlay() {
		return glyphiconPlay;
	}
	public void setGlyphiconPlay(WebElement glyphiconPlay) {
		this.glyphiconPlay = glyphiconPlay;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}
	
	

}
