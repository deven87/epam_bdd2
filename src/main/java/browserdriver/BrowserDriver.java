package browserdriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * BrowserDriver browser driver related task
 */
public class BrowserDriver {

	public BrowserDriver() {
		System.out.println("BrowserDriver Constructor");
	}

	private static WebDriver driver;

	/**
	 * setDriver set the WebDrive as per provided browser name if null
	 *
	 * @param browser browser name
	 */
	public void setDriver(String browser) {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * quitDriver if not null, close all windows for the driver session set the
	 * driver to null
	 */
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	// thread local implementation
	/*
	 * private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	 *
	 * public static void setDriver(String browser) throws Exception { if
	 * (driver.get() == null) { switch (browser.toLowerCase()) { case "chrome":
	 * driver.set(new ChromeDriver()); break; case "firefox": driver.set(new
	 * FirefoxDriver()); break; default: throw new
	 * Exception("Please select correct browser - chrome or firefox are supported");
	 * } } }
	 *
	 * public WebDriver getDriver() { System.out.println(Thread.currentThread());
	 * return driver.get(); }
	 *
	 * public static void quitDriver() { if (driver.get() != null) {
	 * driver.get().quit(); } }
	 */

}
