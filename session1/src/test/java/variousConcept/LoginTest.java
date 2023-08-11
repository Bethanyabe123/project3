package variousConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	 launchBrowser();
	 loginTest();
	 tearDown();
	 
	 //launchBrowser();
	// negLogin Test();
	// tearDown();
	 
	// set system property
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\hilly\\Selenium-Feb2023\\crm\\driver\\chromedriver.exe");
		        driver = new ChromeDriver();
				//delete cookies: to load the application quicker
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				// to get the website.
				driver.get("https://www.techfios.com/billing/?ng=admin/");
				//to get user name
				driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
				// to insert passwaord.
				driver.findElement(By.id("password")).sendKeys("abc123");
				//click sighn in button
				driver.findElement(By.name("login")).click();
				Thread.sleep(2000);
				
				// close the browser
				 driver.close();
		 
}
		public static void launchBrowser() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\hilly\\Selenium-Feb2023\\crm\\driver\\chromedriver.exe");
	        driver = new ChromeDriver();
			//delete cookies: to load the application quicker
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			// to get the website.
			driver.get("https://www.techfios.com/billing/?ng=admin/");
		}
		
		public static void loginTest() throws InterruptedException {
				//to get user name
				driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
				// to insert passwaord.
				driver.findElement(By.id("password")).sendKeys("abc123");
				//click sighn in button
				driver.findElement(By.name("login")).click();
				Thread.sleep(2000);
			}
	    public static void tearDown() {// close the browser
			 driver.close();
	    	
				}
					
		}
