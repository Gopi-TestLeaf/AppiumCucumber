package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import wrappers.AppSpecificWrapper;

public class LoginPage extends AppSpecificWrapper{
	
	
//	public LoginPage(AppiumDriver<WebElement> driver, ExtentTest test) {
//		this.driver = driver;
//		this.test = test;
//	}
//	
	public LoginPage enterEmailAddress(String email) {
		if(enterValue(getWebElement("xpath", "//input[@placeholder='Email']"), email))
			reportStep("Email address "+email+ "entered Successfully", "PASS");
		else
			reportStep("Email address entry fails", "FAIL");
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		if(enterValue(getWebElement("xpath", "//input[@placeholder='Password']"), password))
			reportStep("Password "+password+ "entered Successfully", "PASS");
		else
			reportStep("Password entry fails", "FAIL");
		return this;
	}
	
	@When("the user clicked login which is designed under the password test field")
	public HomePage clickLogin() {
		if(click(getWebElement("xpath", "//span[text()='Login']"))) {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reportStep("Login button clicked successfully", "PASS");
		}
		else
			reportStep("Login button couldn't click", "FAIL");
		return new HomePage(/*driver, test*/);
	}
	
	@Given("the user enter valied credential emial as {} and password as {}")
	public void enterValidCredential(String email, String pwd) {
		enterEmailAddress(email);
		enterPassword(pwd);
	}

}
