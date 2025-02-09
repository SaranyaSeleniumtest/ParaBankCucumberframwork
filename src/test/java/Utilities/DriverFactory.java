package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static WebDriver getTdriver() {
        return tdriver.get();
    }

    public static void setTdriver(WebDriver driver) {
        tdriver.set(driver);
    }


    public  WebDriver InitateBrowser(){

        String browser=PropertiesUtils.getproperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();

        }
        setTdriver(driver);
        return getTdriver();
    }

//    public WebDriver SetDriver(){




}
