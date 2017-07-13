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
	
	@FindBy(id="membername")
	WebElement memberName;
	
	@FindBy(id="userid")
	WebElement userId;
	
	@FindBy(id="dbgroupname")
	WebElement dbGroupName;
	
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
	public WebElement getMemberName() {
		return memberName;
	}
	public void setMemberName(WebElement memberName) {
		this.memberName = memberName;
	}
	public WebElement getUserId() {
		return userId;
	}
	public void setUserId(WebElement userId) {
		this.userId = userId;
	}
	public WebElement getDbGroupName() {
		return dbGroupName;
	}
	public void setDbGroupName(WebElement dbGroupName) {
		this.dbGroupName = dbGroupName;
	}
	
}
