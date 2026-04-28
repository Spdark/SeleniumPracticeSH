package Pages;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Utils;


public class Login {
	WebDriver driver;
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']/i")
	WebElement LoginButton;
	

	
	@FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
	WebElement InValidateLogined;
	
	
	@FindBy(xpath = "//i[normalize-space()='Logout']")
	WebElement LogoutButton;
	
	Utils u = new Utils();
	
	
	
	public Login(WebDriver driver){
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--incognito");
		options.addArguments("--disable-features=PasswordLeakDetection");

		this.driver = new ChromeDriver(options);
		
		
		PageFactory.initElements(this.driver, this);
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
 
	
	public void getDriver() {
		driver.get("https://the-internet.herokuapp.com/login");
	}

	public void enterCredentials(String username, String password) throws InterruptedException {
		
		List<WebElement> ValidateLogined;
		//System.out.println(u.getLastRowLen());
		
		// TODO Auto-generated method stub
		for (int i = 1; i <= u.getLastRowLen(); i++) {
			Username.clear();
			Password.clear();
			
			Username.sendKeys(u.getCellData(i, username));
			Password.sendKeys(u.getCellData(i, password));
			
			
			LoginButton.click();
			
			ValidateLogined = driver.findElements(By.xpath("//h4[normalize-space()='Welcome to the Secure Area. When you are done click logout below.']"));
			if (ValidateLogined.size() > 0) {
				LogoutButton.click();
			} else {
				InValidateLogined.isDisplayed();
			}
		}
	}



	public void quitBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
		
	}

}
