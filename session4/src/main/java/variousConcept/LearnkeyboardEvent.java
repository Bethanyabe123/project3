package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnkeyboardEvent {
WebDriver driver;
	
	By userNameField = By.xpath("//input[@id=\"username\"]");
	By passwordField = By.xpath("//input[@id=\"password\"]");
	By signInButtonElement = By.xpath("/html/body/div/div/div/form/div[3]/button");
	
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
	public void login() throws InterruptedException {
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc123");
	 //   driver.findElement(signInButtonElement).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		
		
		
		
	}
}

