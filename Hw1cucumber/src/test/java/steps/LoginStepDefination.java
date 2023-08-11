package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefination extends TestBase {
	
	LoginPage loginpage;
	
	@Given ("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		initDriver();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		
	}
	@When ("User enters username as {string}")
	public  void user_enters_username_as(String username) {
		loginpage = PageFactory.initElements( driver, LoginPage.class);
		loginpage.enterUserName(username);
		
	}
	@When("User enter passward as {string}")
	public void user_enter_passward_as(String password) {
		loginpage.enterPassword(password);
	}

	@When("User click on sign in button")
	public void user_click_on_sign_in_button() {
		loginpage.clickSignInButton();
	}

	@Then("User land on dashboard page")
	public void user_land_on_dashboard_page() {
		String excpectedTitle = "Dashboard- iBilling";
		String acttualTitle = loginpage.getPageTitle();
		Assert.assertEquals(excpectedTitle,acttualTitle );
	
		
	    
	}

}
