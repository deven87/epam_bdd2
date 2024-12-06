package hooks;

import browserdriver.BrowserDriver;
import container.PageContext;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {

	private static PageContext context;
	private static BrowserDriver driver;

	/**
	 * run before all scenarios, as we are using single browser session and not
	 * implementing parallel
	 *
	 * @throws Exception
	 */
	@BeforeAll
	public static void setUp() throws Exception {
		context = new PageContext();
		driver = new BrowserDriver();
		driver.setDriver("chrome");
		context.set("BrowserDriver", driver);
	}

	/**
	 * run after all scenarios
	 */
	@AfterAll
	public static void tearDown() {
		driver.quitDriver();
		context.remove();
	}
}
