package Steps;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Cs6Extent {
	public static ExtentHtmlReporter reporter=new ExtentHtmlReporter("./ExtentReports/rep1.html");
	public static ExtentReports extent=new ExtentReports();
	public static WebDriver driver;
	static String expectedResult;
	static String actualResult;
	
	@BeforeTest
	public static void OpenBrowser()
	{
		System.out.println("Open");
		extent.attachReporter(reporter);
		ExtentTest logger1=extent.createTest("OpenBrowser");
		logger1.log(Status.INFO, "Opening the browser");
		try
		{
			String driverPath = System.getProperty("user.dir") +"\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			logger1.log(Status.PASS, "Opening passed");
		}
		catch(Exception e)
		{
			logger1.log(Status.FAIL, "Opening failed");
		}
		extent.flush();
	}
	@Test(priority=1)
	public static void navigation() throws IOException
	{
		String screenshot;
		System.out.println("Nav");
		extent.attachReporter(reporter);
		ExtentTest logger2=extent.createTest("Navigating");
		logger2.log(Status.INFO, "Navigating the browser");
		try
		{
			expectedResult="Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com";
			driver.get("https://www.yatra.com/.");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.findElement(By.partialLinkText("Offers")).click();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			actualResult=driver.getTitle();
			Assert.assertTrue((actualResult.equals(expectedResult))?true:false);
			System.out.println("Title verified");
			//logger2.addScreenCaptureFromPath("C:\\Users\\HP\\Pictures\\Screenshots.png");
			logger2.log(Status.PASS, "Title verified");
		}
		catch(AssertionError ae)
		{
			logger2.log(Status.FAIL, "Title verification failed");
			//String screenshotPath = OpenSteps.getScreenshot(driver, "C:\\Users\\sansk\\OneDrive\\Desktop\\Me.png");
			logger2.addScreenCaptureFromPath("C:\\Users\\HP\\Pictures\\Screenshots.png");
			//String fail=logger2.addScreenCaptureFromPath("C:\\Users\\sansk\\OneDrive\\Desktop\\Me.png");
			//logger2.log(Status.FAIL, logger2.addScreenCaptureFromPath("C:\\Users\\sansk\\OneDrive\\Pictures\\Camera Roll\\WIN_20210319_17_39_16_ProWIN_20210319_17_39_16_Pro"));
			/*screenshot=capture.screen();
			logger2.addScreenCaptureFromPath(screenshot);*/
		}
		extent.flush();
	}
	@AfterMethod
	public static void banner() throws IOException
	{
		System.out.println("Banner");
		extent.attachReporter(reporter);
		ExtentTest logger3=extent.createTest("Banner Title");
		logger3.log(Status.INFO, "Getting banner Title");
		try {
	    expectedResult ="Great Offers & Amazing Deals";
		actualResult = driver.findElement(By.xpath("//*[@id=\"collapsibleSection\"]/section[1]/div[1]/div/div/h2")).getText();
		Assert.assertTrue((actualResult.equals(expectedResult))?true:false);
		System.out.println("Title1 also verified");
		logger3.log(Status.PASS, "Title1 also verified");
		}
		catch(Exception e)
		{
			logger3.log(Status.FAIL, "Title1 verification failed");
			logger3.addScreenCaptureFromPath("C:\\Users\\HP\\Pictures\\Screenshots.png");
			
		}
		extent.flush();
	}
	@Test(priority=2)
	public static void nav() throws IOException
	{
		System.out.println("Holidays");
		extent.attachReporter(reporter);
		ExtentTest logger4=extent.createTest("Holidays");
		logger4.log(Status.INFO, "Navigating the browser to holidays");
		try {
			driver.findElement(By.partialLinkText("Holidays")).click();
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			logger4.log(Status.FAIL, "Navigation passed");
		}
		catch(Exception e)
		{
			logger4.log(Status.FAIL, "Navig failed");
		}
		extent.flush();
	}
	@AfterMethod
	public static void list() throws IOException
	{
		System.out.println("TravelPackages");
		extent.attachReporter(reporter);
		ExtentTest logger5=extent.createTest("List of values");
		logger5.log(Status.INFO, "Retrive values");
		List<WebElement> packages = driver.findElements(By.className("offerMainTitle"));
		try
		{
	    for(int i=0;i<5;i++)
	    {
	    	WebElement p=packages.get(i);
	        System.out.println(p.getText());  
	    }
		}
		catch (Exception e) {
			logger5.log(Status.FAIL, "Retrive failed");
		}
		extent.flush();
	}
	@AfterTest
	public static void closeBrowser()
	{
		System.out.println("Close");
		extent.attachReporter(reporter);
		ExtentTest logger6=extent.createTest("Closing");
		logger6.log(Status.INFO, "Closing the browser");
		try
		{
			driver.close();
			logger6.log(Status.PASS, "Closing passed");
		}
		catch(Exception e)
		{
			logger6.log(Status.FAIL, "Closing failed");
		}
		extent.flush();
	}


}
