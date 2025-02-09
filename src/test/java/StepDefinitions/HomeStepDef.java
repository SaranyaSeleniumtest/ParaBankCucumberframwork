package StepDefinitions;

import PagesUtils.HomePage;
import PagesUtils.LoginPage;
import Utilities.DriverFactory;
import Utilities.ExcelHandler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Map;

public class HomeStepDef {
    public LoginPage lp;
    public HomePage nav;
    Map<String, String> hm;
    ExcelHandler excel;
    String sheetname;

    public HomeStepDef() {
        this.sheetname="Home";
    }




    @Then("User able to see all Navigation links")
    public void User_able_to_see_all_Navigation_links(DataTable dataTable) {
        nav = new HomePage(DriverFactory.getTdriver());
        Assert.assertEquals(nav.validationnavigation_options(),dataTable.asList());

    }


}
