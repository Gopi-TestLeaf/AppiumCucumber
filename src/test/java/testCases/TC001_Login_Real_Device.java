package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.AppSpecificWrapper;

public class TC001_Login_Real_Device extends AppSpecificWrapper{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001_Login";
		testDescription = "Login in LeafOrg App";
		testNodes = "TC001";
		authors = "Gopinath Jayakumar";
		category = "Smoke";
		dataSheetName = "TC001";
	}
	
	
	@Test(dataProvider = "fetchData")
	public void login(String email, String pwd) {
		new LoginPage()
		.enterEmailAddress(email)
		.enterPassword(pwd)
		.clickLogin()
		.fetchParName();
	}
}
