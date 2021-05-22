package pages;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import wrappers.AppSpecificWrapper;

public class HomePage extends AppSpecificWrapper{
	
//	public HomePage(AppiumDriver<WebElement> driver, ExtentTest test) {
//		this.driver = driver;
//		this.test = test;
//	}

	@Then("home related page open")
	public HomePage fetchParName() {
		if(verifyText(getWebElement("xpath", "//label[text()=' PARTICIPANT NAME ']/preceding-sibling::label"), "Gopi"))
			reportStep("The Element Gopi verified Successfully", "PASS");
		else
			reportStep("The Element not returns the text", "FAIL");
		return this;
	}




}
