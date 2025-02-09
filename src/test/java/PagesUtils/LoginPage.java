package PagesUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    By txtUsername=By.name("username");
    By txtPassword=By.name("password");
    By btnLogin=By.xpath("//*[@value='Log In']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;

    }

    public void enterUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

}
