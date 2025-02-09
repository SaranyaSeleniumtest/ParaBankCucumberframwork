package PagesUtils;

import Utilities.DriverFactory;
import Utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPage extends ElementUtils {

    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    private By lnk_Register= By.linkText("Register");
    private By txt_firstname= By.id("customer.firstName");
    private By txt_lastname= By.id("customer.lastName");
    private By txt_address= By.id("customer.address.street");
    private By txt_city= By.id("customer.address.city");
    private By txt_state= By.id("customer.address.state");
    private By txt_zipcode= By.id("customer.address.zipCode");
    private By txt_phone= By.id("customer.phoneNumber");
    private By txt_SSN= By.id("customer.ssn");
    private By txt_user= By.id("customer.username");
    private By txt_password= By.id("customer.password");
    private By txt_confirmpassword= By.id("repeatedPassword");
    private By btn_Register= By.xpath("//*[@value='Register']");
    private By error_Userexistsalready= By.id("customer.username.errors");


    public void click_Register() {
        clickElement(DriverFactory.getTdriver().findElement(lnk_Register),"RegisterLink");

    }

    public HomePage click_Register_Button() {
        clickElement(DriverFactory.getTdriver().findElement(btn_Register),"RegisterButton");
        return new HomePage(DriverFactory.getTdriver());
    }


    public String geterror_Userexistsalready() {
       return gettext(DriverFactory.getTdriver().findElement(error_Userexistsalready),"User-alreadyExists");

    }

    public void EnterRegisterUser(Map<String,String> testdata){
        enterval(DriverFactory.getTdriver().findElement(txt_firstname),testdata.get("FirstName"),"FirstName");
        enterval(DriverFactory.getTdriver().findElement(txt_lastname),testdata.get("LastName"),"LastName");
        enterval(DriverFactory.getTdriver().findElement(txt_address),testdata.get("Address"),"Address");
        enterval(DriverFactory.getTdriver().findElement(txt_city),testdata.get("City"),"City");
        enterval(DriverFactory.getTdriver().findElement(txt_state),testdata.get("State"),"State");
        enterval(DriverFactory.getTdriver().findElement(txt_zipcode),testdata.get("ZipCode"),"ZipCode");
        enterval(DriverFactory.getTdriver().findElement(txt_phone),testdata.get("PhoneNumber"),"PhoneNumber");
        enterval(DriverFactory.getTdriver().findElement(txt_SSN),testdata.get("SSN"),"SSN");

    }

    public void EnterUserCredentials(Map<String,String> testdata){
       enterval(DriverFactory.getTdriver().findElement(txt_user),testdata.get("User"),"User");
       enterval(DriverFactory.getTdriver().findElement(txt_password),testdata.get("Password"),"Password");
       enterval(DriverFactory.getTdriver().findElement(txt_confirmpassword),testdata.get("ConfirmPassword"),"ConfirmPassword");

    }



}


