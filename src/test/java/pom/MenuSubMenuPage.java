 package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuSubMenuPage {
	WebDriver driver;
	public MenuSubMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="menu_production")
	WebElement production;
	@FindBy(id="sub-menu-holds")
	WebElement holds;
	@FindBy(id="menu_home")
	WebElement HomeMenu;
	
	@FindBy(id="sub-menu-pdfs")
	WebElement subMenuPdfs;
	
	@FindBy(id="sub-menu-files")
	WebElement subMenuFiles;
	
	@FindBy(id="sub-menu-overrides")
	WebElement subMenuOverrides;

	@FindBy(id="sub-menu-orders")
	WebElement subMenuOrders;
	
	@FindBy(id="sub-menu-sampleorders")
	WebElement subMenuSampleOrders;
	
	
	public WebElement getSubMenuSampleOrders() {
		return subMenuSampleOrders;
	}

	public void setSubMenuSampleOrders(WebElement subMenuSampleOrders) {
		this.subMenuSampleOrders = subMenuSampleOrders;
	}

	public WebElement getHomeMenu() {
		return HomeMenu;
	}

	public WebElement getSubMenuOrders() {
		return subMenuOrders;
	}

	public void setSubMenuOrders(WebElement subMenuOrders) {
		this.subMenuOrders = subMenuOrders;
	}

	public void setHomeMenu(WebElement homeMenu) {
		HomeMenu = homeMenu;
	}

	public WebElement getHolds() {
		return holds;
	}

	public void setHolds(WebElement holds) {
		this.holds = holds;
	}

	public WebElement getProduction() {
		return production;
	}

	public void setProduction(WebElement production) {
		this.production = production;
	}

	public WebElement getSubMenuPdfs() {
		return subMenuPdfs;
	}

	public void setSubMenuPdfs(WebElement subMenuPdfs) {
		this.subMenuPdfs = subMenuPdfs;
	}

	public WebElement getSubMenuFiles() {
		return subMenuFiles;
	}

	public void setSubMenuFiles(WebElement subMenuFiles) {
		this.subMenuFiles = subMenuFiles;
	}

	public WebElement getSubMenuOverrides() {
		return subMenuOverrides;
	}

	public void setSubMenuOverrides(WebElement subMenuOverrides) {
		this.subMenuOverrides = subMenuOverrides;
	}
	
	

}
