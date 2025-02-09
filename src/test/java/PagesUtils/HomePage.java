package PagesUtils;

import Utilities.DriverFactory;
import Utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends ElementUtils {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By navigation= By.xpath("//h2[text()='Account Services']/following-sibling::ul//li");
    private By msg_welcome=By.xpath("//h1");

    public String getwelcomemessage() {
         return   gettext(DriverFactory.getTdriver().findElement(msg_welcome),"Welcome Message");
    }

    public List<String> validationnavigation_options(){
        List<WebElement> opts = DriverFactory.getTdriver().findElements(navigation);
        List<String> navigationlinks= new ArrayList<String>();
        for (WebElement opt : opts) {
            navigationlinks.add(opt.getText());
            System.out.println(opt.getText());
        }
        return navigationlinks;
    }
}
