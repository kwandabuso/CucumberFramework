package Engine;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
              //  "html:target/cucumber-reports/cucumber.html",
              //  "json:target/cucumber-reports/cucumber.json"
        }//,
       // features = {"src/test/java/MobileAutomation/Features"},
        //glue = {"MobileAutomation/MobileStepDefinations"}
)

public class TestRunnerMobileTests extends AbstractTestNGCucumberTests {
}