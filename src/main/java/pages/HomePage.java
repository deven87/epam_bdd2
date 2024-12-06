package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import browserdriver.BrowserDriver;

/**
 * HomePage page class extends BasePage
 */
public class HomePage extends BasePage {

	BrowserDriver browserDriver;

	public HomePage(BrowserDriver browserDriver) {
		System.out.println("HomePage constructor");
		this.browserDriver = browserDriver;
		PageFactory.initElements(browserDriver.getDriver(), this);
	}

	@FindBy(id = "react-burger-menu-btn")
	private WebElement hamburgerMenu;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutLink;

	public boolean isMenuDisplayed() {
		return hamburgerMenu.isDisplayed();
	}

	public LoginPage clickLogoutLink() {
		logoutLink.click();
		return new LoginPage(browserDriver);
	}

	public void clickHamburgerMenu() {
		hamburgerMenu.click();
	}
}
