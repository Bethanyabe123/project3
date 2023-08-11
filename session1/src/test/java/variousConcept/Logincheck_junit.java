package variousConcept;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logincheck_junit {
	
	 WebDriver driver;
	
	@Before
		public  void launchBrowser() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\hilly\\Selenium-Feb2023\\crm\\driver\\chromedriver.exe");
	        driver = new ChromeDriver();
			//delete cookies: to load the application quicker
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			// to get the website.
			driver.get("https://www.techfios.com/billing/?ng=admin/");
		}
		// invoke first launchBrowser.
		@Test
		
		public void loginTest() throws InterruptedException {
				//to get user name
				driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
				//to insert passwaord.
				driver.findElement(By.id("password")).sendKeys("abc123");
				//click sighn in button
				driver.findElement(By.name("login")).click();
				Thread.sleep(2000);
			}
		@Test
		public void neglogin() throws InterruptedException {
			 //to get user name
			driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			// to insert passwaord.
			driver.findElement(By.id("password")).sendKeys("abc1234");
			//click sighn in button
			driver.findElement(By.name("login")).click();
			Thread.sleep(2000);
		}
		@After
	    public  void tearDown() {
			// close the browser
		   driver.close();
		}
}
