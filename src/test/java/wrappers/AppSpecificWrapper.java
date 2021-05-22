package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.DataInputProvider;

public class AppSpecificWrapper extends GenericWrappers{
	
	public String dataSheetName;
	
	@BeforeSuite
	public void bs() {
		startResult();
	}
	
	
	@BeforeClass
	public void bc() {
		startTestModule(testCaseName, testDescription);
	}
	
	@Parameters({"deviceName", "udid", "chromeDriverPort", "mjpegServerPort", "systemPort" })
	@BeforeMethod
	public void bm(String deviceName, String udid, String chromeDriverPort, String mjpegServerPort, String systemPort) {
		startTestCase(testNodes);
		launchAndroidAppInParallel(deviceName, udid, "com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "", chromeDriverPort, mjpegServerPort, systemPort, "");
		//launchAndroidApp("emulator-5554", "com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "", "");
		switchWebview();
	}
	
	@AfterMethod
	public void am() {
		closeApp();
	}
	
	
	@AfterSuite
	public void as() {
		endResult();
	}

	@DataProvider(name = "fetchData", indices = 4)
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);
	}
	
}
