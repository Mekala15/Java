package Steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenPage {
	public static WebDriver driver;
	@Given("Open the Chrome")
	public void open_the_chrome() {
		String driverPath = System.getProperty("user.dir") +"\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	@When("Enter the URL")
	public void enter_the_url() {
		driver.get("https://www.yatra.com/.");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	@And("Navigate to Link")
	public void navigate_to_link() {
		driver.findElement(By.partialLinkText("Offers")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	@And("Page is Displayed")
	public void page_is_displayed() {
	  String expectedResult ="Domestic Flights Offers | Deals on Domestic Flight Booking | Yatra.com";
	  String actualResult = (driver.getTitle());
	 try {
			Assert.assertTrue((expectedResult.equals(actualResult)) ? true : false);
			System.out.println("Pass");
			} catch (AssertionError e) 
			{
			System.out.println(e);
			System.out.println("Fail");
			}
	  //driver.quit();
		}
	@And("Check the Title")
	public void check_the_title() {
	  String expectedResult ="Great Offers & Amazing Deals";
	  String actualResult = driver.findElement(By.xpath("//*[@id=\"collapsibleSection\"]/section[1]/div[1]/div/div/h2")).getText();
	 try {
			Assert.assertTrue((expectedResult.equals(actualResult)) ? true : false);
			System.out.println("Pass Title");
			} catch (AssertionError e) 
			{
			System.out.println(e);
			System.out.println("Fail Title");
			}
	 //driver.quit();
	}
	@And("Navigate to Link1")
	public void navigate_to_link1() {
		driver.findElement(By.partialLinkText("Holidays")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	@Then("Retrive the Elements")
	public void retrive_the_elements() {
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
			System.out.println(e);
		}
	}
	//driver.quit();
	}
