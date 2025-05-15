package stepsDef;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/Login.feature", 
		glue = { "stepsDef" }, 
		plugin = { "pretty","html:target/cucumber-reports.html", 
				"json:target/cucumber.json" },
		tags = "@RunAll")

public class TestRunner {

}
