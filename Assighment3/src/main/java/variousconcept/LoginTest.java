package variousconcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver; 
	String url;
	String browser = null;
	@BeforeSuite
	public void readConfig() {
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
		    browser = prop.getProperty("browser");
			
		    System.out.println("browser used:" + browser);
		    url = prop.getProperty("url");
	        }
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//login element
	By userNameField = By.xpath("//input[@id=\"username\"]");
	By passwordField = By.xpath("//input[@id=\"password\"]");
	By signInButtonElement = By.xpath("/html/body/div/div/div/form/div[3]/button");
	//dashbord page
	By DashboardHeaderField = By.xpath(("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
	By customersField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/a/span[1]"));
	By addcustomerField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
	By addcontactField = By.xpath(("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5"));
	// add contact page
	By fullnameField = By.xpath(("//*[@id=\"account\"]"));
	By companyDropDownField = By.xpath(("//*[@id=\"cid\"]"));
	By emailField = By.xpath("//*[@id=\"email\"]");
	By phoneField = By.xpath(("//*[@id=\"phone\"]"));
	By addressField = By.xpath(("//*[@id=\"address\"]"));
	By cityField = By.xpath("//*[@id=\"city\"]");
	By stateregionField = By.xpath(("//*[@id=\"state\"]"));
	By zippostaField = By.xpath(("//*[@id=\"zip\"]"));
	By countryField = By.xpath(("//*[@id=\"country\"]"));
	By tagsField = By.xpath(("//*[@id=\"rform\"]/div[1]/div[1]/div[10]/div/span/span[1]/span/ul"));
	By saveField = By.xpath("//*[@id=\"submit\"]");
	By listcustomersField = By.xpath(("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
	//test data
	String USER_NAME = "demo@techfios.com";
	String PASSWORD = "abc123";
	String DASHBOAR_HEADER_TEXT = "Dashboard";
	String DASHOARDHEADERSTRING = "Dashboard page not found";
	String ADDCUSTOMER_HEADER_TEXT = "Add contact";
	String FULL_NAME = "Selenium 2023";
	String COMPANY = "Techfios";
	String EMAIL = "abcd123@yahoo.com";
	String PHONE ="972-564-0098";
	String ADDRESS = "1243 debora ln plano ";
	String CITY = "plano";
	String STATE = "tx";
	String ZIP = "75469";
	String COUNTRY = "Albania";
	String TAGS = "TX5676";
	
	@BeforeMethod
	public void init() {
		if(browser == "chrome") {
		 System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		 
	 }else {
		 System.setProperty("webdriver.edge.driver", "driver\\msedgedriver2.exe");
		 driver = new EdgeDriver(); 
    	}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
 }
	@Test(priority = 1)
		public void Login() {
		driver.findElement(userNameField).sendKeys(USER_NAME);	
		driver.findElement(passwordField).sendKeys(PASSWORD);
		driver.findElement(signInButtonElement).click();
		Assert.assertEquals(driver.findElement(DashboardHeaderField).getText(), DASHBOAR_HEADER_TEXT , "Dashboard page not found");
		
		}
	@Test (priority = 2)
		public void addCustomer() throws InterruptedException {
		Thread.sleep(2000);
			Login();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(addcustomerField));
			waitForElement(driver, 5,addcustomerField);
			
			
		    driver.findElement(customersField).click();
			driver.findElement(addcustomerField).click();
			
			//Assert.assertEquals(driver.findElement(addcustomerHeaderField).getText(),"AddCustomer_Header_Text","Add customer page is not available");
			
			Random rnd = new Random();
		     int generatedNum = rnd.nextInt(999);
		     System.out.println("========"+ generatedNum);
		     
		     driver.findElement(fullnameField).sendKeys(FULL_NAME + generatedNum);
		     
			//randomNumGenerator(999);
			
			Select sel =new Select(driver.findElement(companyDropDownField));
			sel.selectByVisibleText(COMPANY);
			driver.findElement(emailField).sendKeys(randomNumGenerator(9999) + EMAIL);
			driver.findElement(phoneField).sendKeys(PHONE + randomNumGenerator(99));
			driver.findElement(addressField).sendKeys(randomNumGenerator(9999) + ADDRESS);
		    driver.findElement(cityField).sendKeys(CITY + randomNumGenerator(99));
			driver.findElement(stateregionField).sendKeys(randomNumGenerator(9999) + STATE);
			driver.findElement(zippostaField).sendKeys(randomNumGenerator(9999) + ZIP);
			driver.findElement(countryField).sendKeys(randomNumGenerator(9999) + COUNTRY);
			//driver.findElement( tagsField).sendKeys( TAGS + randomNumGenerator(99));
			
			SelectFromDropdown(driver.findElement(countryField),COUNTRY);
		  
			 driver.findElement(saveField).click();
			 Thread.sleep(6000);
			 driver.findElement(listcustomersField).click();
			
			 }
		
		private void waitForElement(WebDriver driver, int waitTime, By elementToBeLocated) {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLocated));
		
	}
		private void SelectFromDropdown(WebElement element, String visibleText) {
			Select Sel = new Select( element);
			Sel.selectByValue(visibleText);
			
		}
		private int randomNumGenerator(int bound) {
			Random rnd = new Random();
			int generatedNum = rnd.nextInt(bound);
			return generatedNum;
			
		}
		//@AfterMethod
		public void  tearDown() {
			driver.close();
			driver.quit();
			
		}
		

}
