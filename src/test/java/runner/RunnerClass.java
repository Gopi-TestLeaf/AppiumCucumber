package runner;


import org.testng.annotations.BeforeTest;

import io.cucumber.testng.CucumberOptions;
import wrappers.AppSpecificWrapper;

@CucumberOptions(features = "src/test/resources/features",
				glue = {"pages"},
				monochrome = true,
				publish = true)
public class RunnerClass extends AppSpecificWrapper{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001_Login";
		testDescription = "Login in LeafOrg App";
		testNodes = "TC001";
		authors = "Gopinath Jayakumar";
		category = "Smoke";
	}
	
	
}
