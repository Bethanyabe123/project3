package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	public AddCustomerpage(WebDriver driver) {
		this.driver =driver;
	}
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"account\"]")WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"cid\"]")WebElement COMPANY_DPDWN_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"phone\"]")WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"address\"]")WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"city\"]")WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"state\"]")WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"zip\"]")WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"country\"]/option[4]")WebElement COUNTRY_DRWN_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"submit\"]")WebElement SUBMIT_BUTTON_ELEMENT;
	
	
	public void validateAddCustomerPage(String expectedText){
		
		
		validateElement( ADD_CUSTOMER_HEADER_ELEMENT.getText(), expectedText, "Add Coustomer page is not available");
		
	}
	
	public void insertFullName(String fullName) {
		FULL_NAME_ELEMENT.sendKeys(fullName + randomNumGenerator(999));
		
	}
	public void selectCompanyName(String company) {
		SelectFromDropdown(COMPANY_DPDWN_ELEMENT, company);
		}
	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(randomNumGenerator(999)+ email);
		
	}
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + randomNumGenerator(9999));
		
	}
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
		
	}
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
		
	}
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
		
	}
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
		
	}
	public void selectCountery(String visibleText) {
		SelectFromDropdown(COUNTRY_DRWN_ELEMENT, visibleText);
		
	}
	public void clickOnSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
	}

}
