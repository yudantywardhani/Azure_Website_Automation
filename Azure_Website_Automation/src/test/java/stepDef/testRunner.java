package stepDef;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/practiceForm.feature", glue={"stepDef"},
monochrome = true, plugin = {"pretty","json:target/JSONReports/report.json"})

public class testRunner {

}
