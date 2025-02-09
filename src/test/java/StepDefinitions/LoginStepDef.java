package StepDefinitions;

import PagesUtils.LoginPage;
import Utilities.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginStepDef  {
//    WebDriver driver;
    public LoginPage lp;


    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
       lp= new LoginPage(DriverFactory.getTdriver());
        System.out.println("User navigates to login page");
    }


    @When("User enters username and password")
    public void user_enters_username_and_password() {
    lp.enterUsername("tomvasu");
    lp.enterPassword("testing");
    }


    @When("clicks on login button")
    public void clicks_on_login_button() {
    lp.clickLogin();
    }


    @Then("User navigates to Homepage")
    public void user_navigates_to_homepage() {
        Assert.assertEquals(DriverFactory.getTdriver().getTitle(),"ParaBank | Accounts Overview");
    }



    @When("User enters {string} and {string}")
    public void userEntersAnd(String user, String pass) {
        lp.enterUsername(user);
        lp.enterPassword(pass);
    }
}
