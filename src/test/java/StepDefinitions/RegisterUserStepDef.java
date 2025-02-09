package StepDefinitions;

import PagesUtils.HomePage;
import PagesUtils.RegisterPage;
import Utilities.DriverFactory;
import Utilities.ExcelHandler;
import Utilities.PropertiesUtils;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.Map;

public class RegisterUserStepDef {
    RegisterPage register;
    HomePage home;
    Map<String, String> hm;
    ExcelHandler excel;
    String sheetname;


    public RegisterUserStepDef() {
        this.sheetname="Register";
    }

    @When("User clicks on Register link")
    public void user_clicks_on_register_link() {
        register= new RegisterPage(DriverFactory.getTdriver());
        register.click_Register();
        ExtentCucumberAdapter.addTestStepLog("Registered user is clicked");
    }

    @When("User enters FirstName, LastName,Address,City,State,ZipCode,Phone,SSN")
    public void user_enters_first_name_last_name_address_city_state_zip_code_phone_ssn() {

         hm = excel.getexceldata(sheetname,"TC003-Register",PropertiesUtils.getproperty("testdataloc"));
         register.EnterRegisterUser(hm);
         ExtentCucumberAdapter.addTestStepLog("User enters first name and last name and address");
    }

    @When("User enters UserName,Password,ConfirmPassword")
    public void user_enters_user_name_password_confirm_password() {
        register.EnterUserCredentials(hm);
        ExtentCucumberAdapter.addTestStepLog("User entered Username and Password");

    }

    @When("Clicks on Register")
    public void clicks_on_register() {
        register.click_Register_Button();
    }

    @Then("User should be able to succesfully register an account")
    public void user_should_be_able_to_succesfully_register_an_account() {
        home=new HomePage(DriverFactory.getTdriver());
        Assert.assertEquals(home.getwelcomemessage(),"Welcome TomPatrick");
        ExtentCucumberAdapter.addTestStepLog("Welcome TomPatrick messsage is displayed");
    }



    @When("User enters same UserName,Password,ConfirmPassword")
    public void user_enters_same_user_name_password_confirm_password() {

        register.EnterUserCredentials( excel.getexceldata(sheetname,"TC004-SameUserRegister",PropertiesUtils.getproperty("testdataloc")));
    }
    @Then("User should not be allowed to registered with same User")
    public void user_should_not_be_allowed_to_registered_with_same_user() {
        Assert.assertEquals(register.geterror_Userexistsalready(),"This username already exists.","Proper error message not displayed");
    }


}
