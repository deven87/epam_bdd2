package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import browserdriver.BrowserDriver;
import constants.Constants;

/**
 * LoginPage page class extends BasePage
 */
public class LoginPage extends BasePage {

	BrowserDriver browserDriver;

	public LoginPage(BrowserDriver browserDriver) {
		System.out.println("LoginPage Constructor");
		this.browserDriver = browserDriver;
		PageFactory.initElements(this.browserDriver.getDriver(), this);
	}

	@FindBy(id = "user-name")
	private WebElement userNameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	public LoginPage enterUserName(String userName) {
		userNameField.sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public HomePage clickLoginButton() {
		loginButton.click();
		return new HomePage(browserDriver);
	}

	public void openLoginUrl() {
		super.openUrl(browserDriver.getDriver(), Constants.LOGIN_PAGE);
	}

	public boolean isLoginPage() {
		return browserDriver.getDriver().getCurrentUrl().equalsIgnoreCase(Constants.LOGIN_PAGE);
	}

}
