package Utilities;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.Scenario;

public class ElementUtils  {
//	WebDriver driver;
	WebDriverWait wait;

	public void Assertion(String Expected,String Actual) {
		try {
			if(Expected.equalsIgnoreCase(Actual)) {
				System.out.println("pass");
			}else {

				System.out.println("fail");
			}
		}	catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}

	}


	public WebElement Webdriverwait_clickable(WebElement element) {
		WebElement ele=null;
		try {
			wait= new WebDriverWait(DriverFactory.getTdriver(), Duration.ofSeconds(30));
			ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			Assert.fail();
		}
		return ele;
	}


	public WebElement Webdriverwait_visible(WebElement element) {
		WebElement ele=null;
		try {
			wait= new WebDriverWait(DriverFactory.getTdriver(), Duration.ofSeconds(30));
			ele = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			Assert.fail();
		}
		return ele;
	}
	public void enterval(WebElement element,String value, String fieldname) {
		try {
			element.clear();
			element.sendKeys(value);
			//add extent report for success

			ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, fieldname+": "+value);
//			ExtentFactory.getinstance().getextent().log(Status.PASS,"The value: "+"<b>"+value+ "</b>"+ " is entered in the field "+ fieldname);
		}catch(Exception e) {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,"Value: "+value+" is NOT entered in to field "+fieldname +" due to exception" + e.getMessage());
//			ExtentCucumberAdapter.addTestStepLog("Value: "+value+" is NOT entered in to field "+fieldname +" due to exception" + e.getMessage());
			//add extent report for failure
//			ExtentFactory.getinstance().getextent().log(Status.FAIL,"The value: "+"<b>"+value+"</b>"+" is not entered in to field: "+fieldname+ "due to exception "+e.getMessage());
			Assert.fail();
		}
	}


	public void clickElement(WebElement element, String fieldname) {
		try {
			element.click();
			//add extent report for success
//			ExtentFactory.getinstance().getextent().log(Status.PASS, "<b>"+fieldname+"</b>"+ " is clicked successfully");
		}catch(Exception e) {
			//add extent report for failure
//			ExtentFactory.getinstance().getextent().log(Status.FAIL, fieldname+ " not clicked due to exception: "+e.getMessage());
			Assert.fail();
		}
	}



	public boolean isdisplayed(WebElement ele) {
		boolean elefound = false;
		try {
			ele.isDisplayed();
			elefound=true;
			return elefound;

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return elefound;
	}
	public String gettext(WebElement element,String fieldname) {
		WebElement ele=Webdriverwait_visible(element);
		return ele.getText();
	}
	
	public String getpagetitle() {
		return DriverFactory.getTdriver().getTitle();
	}

	public void select_visibletext(WebElement element,String cond) {
		WebElement ele= Webdriverwait_visible(element);
		try {
			Select sel=new Select(ele);
			sel.selectByVisibleText(cond);
		}catch(Throwable e) {
			e.printStackTrace();
			Assert.fail();

		}
	}


	public String handle_alerts(String condition) {
		try {
		Alert alert = DriverFactory.getTdriver().switchTo().alert();
		switch (condition) {
		case "getmessage_Accept":

			String alertmsg=alert.getText();
			alert.accept();
			return alertmsg;
			
		case "OnlyAccept":
			alert.accept();
			break;
		case "Dismiss":
			alert.dismiss();
			break;
		}
		}catch(Exception e) {
//			ExtentFactory.getinstance().getextent().log(Status.FAIL,"Unable to perform action in alerts due to exception "+e.getMessage());
			Assert.fail();
		}
		return null;
	}

	public void screenshot(Scenario scenario) {
//		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) DriverFactory.getTdriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

//		}
	}
	
	public void handlewindows() {

	}

	public void scrollby(int x,int y) {

	}

	public void scrollby(WebElement element) {

	}

}
