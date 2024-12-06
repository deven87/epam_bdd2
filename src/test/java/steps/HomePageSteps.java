package steps;

import org.assertj.core.api.Assertions;

import browserdriver.BrowserDriver;
import constants.Constants;
import container.PageContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

/**
 * HomePageSteps step defintion file for home page
 */
public class HomePageSteps {

	PageContext context;
	BrowserDriver browserDriver;
	HomePage homePage;
	LoginPage loginPage;

	public HomePageSteps(PageContext context) {
		this.context = context;
		this.browserDriver = (BrowserDriver) context.get("BrowserDriver");
		this.homePage = (HomePage) context.get("HomePage");
	}

	@Given("I am on the home page")
	public void i_am_on_the_home_page() {
		Assertions.assertThat(homePage.getUrl(browserDriver.getDriver())).as(" home page url ")
		.isEqualTo(Constants.HOME_PAGE);
	}

	@When("I click on logout")
	public void i_click_on_logout() {
		homePage.clickHamburgerMenu();
		loginPage = homePage.clickLogoutLink();
		context.set("LoginPage", loginPage);
	}

	@Then("Login page is displayed")
	public void login_page_is_displayed() {
		Assertions.assertThat(loginPage.isLoginPage()).as("Login page").isEqualTo(true);
	}

}
