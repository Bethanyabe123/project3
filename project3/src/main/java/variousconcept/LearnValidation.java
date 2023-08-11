package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnValidation {
	WebDriver driver;
	@Before
	public void init() {
		 System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.get("https://www.techfios.com/billing/?ng=admin/");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
   }
	@Test
	public void loginTest() {
		//type name = value
		//Element list
		// storing in WebElement
		WebElement userNameElement  = driver.findElement(By.xpath("//input[@id=\"username\"]"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		WebElement signinButtonElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		// Storing in by class
		By userNameField = By.xpath("//input[@id=\"username\"]");
		By passwordField = By.xpath("//input[@id=\"password\"]");
		By signInButtonElement = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DashboardHeaderField = By.xpath(("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		
		
				
		
		
		
		//driver.findElement(By.xpath("//input[@id=\\\"username\\\"]")).clear();
		//driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("demo@techfios.com");
		
		userNameElement.clear();
		//userNameElement.sendKeys("demo@techfios.com");
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc123");
		driver.findElement(signInButtonElement).click();
		
		WebElement dashboardHeaderElement = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		Assert.assertTrue("Dashbard  page not available", dashboardHeaderElement.isDisplayed());
		
	
		
		
	}
	
	
	
	

}
