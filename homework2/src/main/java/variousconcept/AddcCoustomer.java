package variousconcept;



import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddcCoustomer {
	WebDriver driver;
	By userNameField = By.xpath("//input[@id=\"username\"]");
	By passwordField = By.xpath("//input[@id=\"password\"]");
	By signInButtonElement = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By customersField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
	By addcustomerField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
	By addcontactField = By.xpath(("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5"));
	By fullnameField = By.xpath(("//*[@id=\"account\"]"));
	By companyDropDownField = By.xpath(("//*[@id=\"cid\"]"));
	By emailField = By.xpath("//*[@id=\"email\"]");
	By phoneField = By.xpath(("//*[@id=\"phone\"]"));
	By addressField = By.xpath(("//*[@id=\"address\"]"));
	By cityField = By.xpath("//*[@id=\"city\"]");
	By stateregionField = By.xpath(("//*[@id=\"state\"]"));
	By zippostaField = By.xpath(("//*[@id=\"zip\"]"));
	By countryField = By.xpath(("//*[@id=\"select2-country-container\"]"));
	By saveField = By.xpath("//*[@id=\"submit\"]");
	By listcustomersField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
	
	 @ Before  
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@ Test 
	public void Login() throws InterruptedException {
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc123");
		driver.findElement(signInButtonElement).click();
		driver.findElement(customersField).click();
		driver.findElement(addcustomerField).click();
		String actualpageTitle = driver.getTitle();
		Assert.assertEquals("add customer page not found", "Contacts - iBilling", actualpageTitle);
		//Assert.assertEquals("add customer page contact page not found", " Contacts ", driver.findElement(addcontactField).getText());
		//Assert.assertEquals("add customer page add  contact field not found", "Add Contact",driver.findElement(addcontactField).getText());
		
		driver.findElement(fullnameField).sendKeys("willson john");
		Select selectcompany = new Select(driver.findElement(companyDropDownField));
		selectcompany.selectByVisibleText("Apple");
		driver.findElement(emailField).sendKeys("abcd123@yahoo.com");
		driver.findElement(phoneField).sendKeys("972-564-0098");
		driver.findElement(addressField).sendKeys("1243 debora ln plano tx 75469");
		driver.findElement(cityField).sendKeys("plano");
		driver.findElement(stateregionField).sendKeys("tx");
		driver.findElement(zippostaField).sendKeys("75469");
		//Select selectCountry = new Select(driver.findElement(countryField));
		//selectCountry.selectByVisibleText("Angola");
		driver.findElement(saveField).click();
		Thread.sleep(6000);
		driver.findElement(listcustomersField).click();
		
    }
	//@ After
	// public void tearDown() throws InterruptedException {
		//Thread.sleep(3000);
		//driver.close();
		//driver.quit();
	//}
}
	
   
    	
   
    

