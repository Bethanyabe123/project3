package variousconcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocation {
	 WebDriver driver;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://objectspy.space/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void testLocation() {
		driver.findElement(By.name("firstname")).sendKeys("selenium");
		driver.findElement(By.id("sex-1")).click();
		//upload file using sendkeys method as long as the tag is input
		//anything else use robot
		//driver.findelement 
		// link text
		driver.findElement(By.linkText("OS-API Product FrontEnd")).click();
		driver.navigate().back();//go back to the pervious page
		//driver.findElement(By.partialLinkText("TF-API")).click();
		//ccs locater
		//driver.findElement(By.cssSelector("input#tool-2")).click();
		//driver.findElement(By.cssSelector("input[value='Automation Tester']")).click();
		// xpath
		//driver.findElement(By.xpath('html/body/div/div[2]/[2]/from/dive[10]/input')).sendKeys("is fun");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("is fun");
		driver.findElement(By.xpath("//input[@name='lastname' and@type='text']")).sendKeys("is not fun");
		//driver.findElement(By.xpath("//strong[text()='Link Test : Page Change']")).click();
		driver.findElement(By.xpath("//strong[contains(text(),'Link Test : New Page')]")).click();
	}
	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
