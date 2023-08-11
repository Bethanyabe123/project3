package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnDropdown {
	WebDriver driver;
	
	By userNameField = By.xpath("//input[@id=\"username\"]");
	By passwordField = By.xpath("//input[@id=\"password\"]");
	By signInButtonElement = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DashboardHeaderField = By.xpath(("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
	By customerMenuField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
	By addcustomerMenuField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
	By addcustomerHeaderField = By.xpath(("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5"));
	By fullnameField = By.xpath(("//*[@id=\"account\"]"));
	By companyDropdownField = By.xpath(("//select[@id='cid']"));
	
	

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
		driver.findElement(signInButtonElement).click();
		
		// validation technique
		//Assert.assertTrue("Dashboard page not found! ", driver.findElement(DashboardHeaderField).isDisplayed());
       // element web
		//ert.assertEquals("Dashboard page not found! ", "Dashboard", dashboarHeaderText );
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DashboardHeaderField));
	
		driver.findElement(customerMenuField).click();
		driver.findElement(addcustomerMenuField).click();
		driver.findElement(fullnameField).sendKeys("selenium");
		
		Select sel = new Select(driver.findElement(companyDropdownField));
		//sel.selectByVisibleText("Techfios");
		sel.selectByValue("1");
		// get all value
		// assigment figer out
		//  sel.getOptions();
		Assert.assertEquals("Add customer pages not found","Add Contact", driver.findElement(addcustomerHeaderField).getText());
		
		
		
		
	// title
		//String pageTitle = driver.getTitle();
		//System.out.println("===========" + pageTitle);
		//Assert.assertEquals("Dashboard page not found!", "Dashboard- iBilling", pageTitle );
		
		
	}
	
	//@After
	   public void tearDown() {
		   driver.close();
		   driver.quit();
	   }

}
