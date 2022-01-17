package test.java.ExtentReport.ExtentReportDemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.flipkart;

import com.aventstack.extentreports.Status;

import main.java.report.Utility.ExtentTestManager;

@Test
public class Test1_PASS {
	String driverPath = "C:\\chromedriver.exe";
	WebDriver driver;
	flipkart objPage=new flipkart(driver);	
	
	@BeforeSuite
	public void setup() {
	
			System.setProperty("webdriver.chrome.driver", "F:\\WS\\test\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
			ExtentTestManager.getTest().log(Status.INFO, "Chrome Browser launched successfully");
	}
	
	@BeforeClass
	public void browser_setup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ExtentTestManager.getTest().log(Status.INFO, "Browser Launched successfully");
	}

	@BeforeTest
	public void launch_webpage() {
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		objPage.clickOnClose();
		objPage.veryHeader();		
		ExtentTestManager.getTest().log(Status.INFO, "Flipkart Launched successfully");
		
	}
	@Test (priority = 0)
	public void Mobile_Selection()
	{
		objPage.mobileselection();
		ExtentTestManager.getTest().log(Status.INFO, "Mobile searched successfully");
		objPage.selectram();
		ExtentTestManager.getTest().log(Status.INFO, "RAM selected successfully");
	}
	
	@Test (priority = 1)
	public void Validate_Mobile_Selection()
	{
		objPage.Validatemobileselection();
		ExtentTestManager.getTest().log(Status.INFO, "Mobile Validated successfully");	
	}
	
	@Test (priority = 2)
	public void closeram() {
		objPage.closeram();
		ExtentTestManager.getTest().log(Status.INFO, "RAM selection is removed successfully");
	}
	
	@AfterClass
	public void closeBrowser()
	{
			driver.quit();
	}
}
