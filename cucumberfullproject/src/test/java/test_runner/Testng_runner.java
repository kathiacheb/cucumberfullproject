package test_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		
		features = {"D:\\eclipse workspaces\\cucumberfullproject\\features\\yourstore.feature"},
		glue = {"step_definitions","utilities"},
		plugin = {
				"pretty",
				"html:D:\\eclipse workspaces\\cucumberfullproject\\target\\htmlReport.html", 
				"json:D:\\eclipse workspaces\\cucumberfullproject\\target\\jsonReport.json"
		},
		monochrome=false,
		dryRun =false,
		tags =  "@yourstore"
		)





public class Testng_runner extends AbstractTestNGCucumberTests{

}
