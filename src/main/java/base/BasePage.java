package base;

import org.openqa.selenium.WebDriver;

/**
 * parent class for all pages write common methods for all pages
 */
public class BasePage {

	public BasePage() {
		System.out.println("BasePage Constructor");
	}
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
}
