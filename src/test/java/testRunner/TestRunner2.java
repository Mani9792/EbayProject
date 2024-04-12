package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features"},
		glue = {"steps"},
		tags = "@login",
		plugin = {"pretty","json:target/json-report/cucumber.json"},  //Report Generation
		dryRun = false    // just the dry run to find any feature without any step definitions no actual execution	   
		//name = {"logo"}
		)
public class TestRunner2 {

}
