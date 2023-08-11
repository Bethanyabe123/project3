package homework1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewAccount {
        WebDriver driver;
	
	@Before 
        public void init () {
	    
        System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=accounts/add/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
  }
	@Test
	public void Findelement () throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		// link text formula
		//driver.findElement(By.xpath("//span[text()='Bank & Cash']")).click();
		//driver.findElement(By.xpath("//a[text()='New Account']")).click();
		//new account using location paths
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Debit Account");
		driver.findElement(By.xpath("//input [ @ id ='description']")).sendKeys("creat new account");
		driver.findElement(By.xpath("//input [@ id='balance']")).sendKeys("50,000");
		driver.findElement(By.xpath("//input [ @ id = 'account_number']")).sendKeys("465738345");
		driver .findElement(By.xpath("//input [ @ id = 'contact_person']")).sendKeys("king david");
		driver.findElement(By.xpath("//input [ @ id = 'contact_phone']")).sendKeys("469-765-0011");
		driver.findElement(By.xpath("//input [ @ id = 'ib_url']")).sendKeys("https://wwww.bank of absenya");
	}
	//@After
		public void tearDown() {
			driver.close();
			driver.quit();
		}

}
