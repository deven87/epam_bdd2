package steps;

import org.assertj.core.api.Assertions;

import browserdriver.BrowserDriver;
import container.PageContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

/**
 * LoginPageSteps step defintion file for login page
 */
public class LoginPageSteps {
	PageContext context;
	BrowserDriver browserDriver;
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageSteps(PageContext context)
	{
		this.context = context;
		this.browserDriver = (BrowserDriver) context.get("BrowserDriver");
		this.loginPage = (LoginPage) context.get("LoginPage");
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		loginPage = new LoginPage(browserDriver);
		loginPage.openLoginUrl();
	}

	@When("I enter {string} and {string}")
	public void i_enter_and(String userName, String password) {
		System.out.println(password);
		loginPage.enterUserName(userName).enterPassword(password);
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		homePage = loginPage.clickLoginButton();
		context.set("HomePage", homePage);
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		Assertions.assertThat(homePage.isMenuDisplayed()).as("Hamburger visibility on home page").isEqualTo(true);
	}
}
