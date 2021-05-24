package Steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", 
glue= {"Steps"},
monochrome=true)
//format = {"pretty","html:target"}
//plugin = {"pretty","junit:target/JUnitReports/report.xml"}
//plugin = {"pretty","json:target/JSONReports/report.json"}
public class TestRunner {

}
