package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAleartPopup {
	WebDriver driver;
	@ Before 
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	 public void testAleart() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]")).click();
		Thread.sleep(2000);
		String alerMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	    System.out.println("alertMsg");
		
		
		
		 
	 }

}
