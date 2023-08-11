package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	WebDriver driver;
	public void DashbordPage(WebDriver driver) {
		this.driver =driver;
	}
	@FindBy(how = How.XPATH,using = "//h2[contains(text(),'Dashboard')]")WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")WebElement ADD_CUSTOMER_MENU_ELEMENT;
	
	    
	    public void validateDashboardPage(String expectedText) {
	    	validateElement(DASHBOARD_HEADER_ELEMENT.getText(), expectedText, "Dashbard page not found");
	    }
	    
	    public void clickCustomerButton() throws InterruptedException {
	    	Thread.sleep(2000);
	    	CUSTOMER_MENU_ELEMENT.click();
	    }
	    
	    public void clickAddCustomerButton() throws InterruptedException {
	    	Thread.sleep(2000);
	    	ADD_CUSTOMER_MENU_ELEMENT.click();
	    }
		
		
	
	}
	
	
	


