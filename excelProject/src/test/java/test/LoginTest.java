package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	@Test
	public void validUserShouldBeAbleLogin() {
		driver = BrowserFactory.init();
	}
	

}
