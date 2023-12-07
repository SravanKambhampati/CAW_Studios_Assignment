package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",glue={"stepDefinitionsFile"},
		monochrome = true,
		plugin = {"pretty"},
		tags= {"@testCase"}
)
public class FeatureRunner {

}
