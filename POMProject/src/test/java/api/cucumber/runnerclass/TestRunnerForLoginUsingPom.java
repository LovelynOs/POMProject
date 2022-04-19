package api.cucumber.runnerclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/api/cucumber/features/LoginDemo.feature"},
        glue = {"api.cucumber.stepDefinition"},
        plugin = {"pretty", "html:target/HtmlReport"}
        //plugin = {"pretty", "json:target/report.json"}
        //plugin = {"json:target/cucumber.json"}
        //plugin = {"pretty", "junit:target/report.xml"}
       //tags = {"@smoke @regression"}
        )
public class TestRunnerForLoginUsingPom {

}
