package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true, plugin = { "pretty",
		"html:target/Myreport.html" }, features = "Features\\AddAccount.feature", glue = {
				"stepDefinition" }, dryRun = false, monochrome = true)
public class Runner {

}
