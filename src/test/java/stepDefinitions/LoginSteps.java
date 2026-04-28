package stepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	Login login = new Login(driver);

	@Given("User Navigates to URL")
	public void navigate_to_url() {
		
		login.getDriver();
	}
	
	@When("User enters {string} and {string} and click on login and validate successful and unsuccessful")
	public void enterUsernamePassword(String username,String password) throws InterruptedException {
		login.enterCredentials(username,password);
	}
	
	@Then("User logged out")
	public void loggedOut() {
		login.quitBrowser();
	}
	
}
