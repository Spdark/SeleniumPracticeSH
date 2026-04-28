package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

import com.aventstack.extentreports.*;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "html:target/cucumber-reports/report.html",
        "json:target/cucumber-reports/report.json"
    },
    monochrome = true,
    dryRun = false,
    tags = "@login"
 )
public class TestRunner {
}