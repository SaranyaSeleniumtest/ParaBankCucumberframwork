package Hooks;


import Utilities.DriverFactory;
import Utilities.PropertiesUtils;
import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks  {

    @Before
    public void Before() {
        //add code to pick from browserfactory
        DriverFactory browserFactory = new DriverFactory();
        WebDriver driver = browserFactory.InitateBrowser();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(PropertiesUtils.getproperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

    }

    @BeforeStep
    public void BeforeStep(Scenario scenario) {
        System.out.println(scenario.getName());
    }

    @AfterStep
    public void Afterstep(Scenario scenario){
        if(scenario.isFailed()){
            System.out.println(scenario.getName()+ " failed");
        }

    }


    @After
    public void After() {

              DriverFactory.getTdriver().quit();
    }

}
