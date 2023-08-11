package variousconcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {
	@Test
	 WebDriver driver;
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}
