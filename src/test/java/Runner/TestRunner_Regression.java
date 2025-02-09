package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/java/Features/RegisterUser.feature"},
        dryRun = !true,
//        tags=("not @TC003-Register"),
        tags = ("@TC003-Register"),
        glue = {"StepDefinitions","Hooks"},
        plugin = {"pretty","html:target/CucumberReports/CucumberReport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)
public class TestRunner_Regression extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
