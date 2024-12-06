package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Test Runner file
 */
@CucumberOptions(features = "src/test/resources/features", glue = { "steps", "hooks" }, tags = "@login", plugin = {
		"pretty", "html:target/cucumberreport.html",
"json:target/cucumberreport.json" }, dryRun = false, monochrome = false)
public class LoginPageTestRunner extends AbstractTestNGCucumberTests {
}
