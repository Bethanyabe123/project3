package session5;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandel {
	WebDriver driver;
	@ Before 
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
    @Test
    
     public void testWindoHandle() throws InterruptedException {
    	
    	//String title1 = driver.getTitle();
    	//System.out.println(title1);
    	//driver.getTitle();
    	//String wh1 = driver.getWindowHandle();
    	//System.out.println(wh1);
    	driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("selenium");
    	driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
    	
    	//Thread.sleep(2000);
    	//String title2 = driver.getTitle();
    	//System.out.println(title2);
    	//driver.getTitle();
    	//String wh2= driver.getWindowHandle();
    	//System.out.println(wh2);
    	
    	driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
    	//Set<String >handles = driver.getTitle();
    	//System.out.println(handles);
    	//driver.getTitle();
    	//String wh3= driver.getWindowHandle();
    	//System.out.println(wh3);
    	 Set<String> handles = driver.getWindowHandles();
    	 System.out.println(handles);
    	
    	 for(String i : handles) {
    	 System.out.println(i);
    	 driver.switchTo().window(i);
    	}
    	String title3 = driver.getTitle();
    	System.out.println(title3);
    	
    }
     }
