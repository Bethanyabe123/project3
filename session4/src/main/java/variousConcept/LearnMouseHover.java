package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {
	WebDriver driver;
	@ Before 
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@ Test 
	public void testMouseHover() {
		By computerAccField = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/button/span");
		By monitorsField = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/ul/li[5]/button");
		By viewAllMonitorsField = By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/ul/li[5]/ul/li[3]/a");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(computerAccField)).build().perform();
		action.moveToElement(driver.findElement(monitorsField)).build().perform();
		driver.findElement(viewAllMonitorsField).click();
		
		
		
	}
	 
	

}
