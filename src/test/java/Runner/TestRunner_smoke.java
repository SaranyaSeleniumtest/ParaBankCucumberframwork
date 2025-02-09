package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/java/Features"},
        dryRun = !true,
//        tags=("not @TC003-Register"),
//        tags = ("@Login or @Register"),
        tags = ("@Register"),
        glue = {"StepDefinitions","Hooks"},
        plugin = {"pretty","html:target/CucumberReports/CucumberReport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)
public class TestRunner_smoke extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
