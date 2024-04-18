package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class Commons {
	
	public static WebDriver driver;
     String ud= System.getProperty("user.dir");
     public Logger log= LogManager.getLogger(Commons.class);

     public ExtentReports extent = new ExtentReports();
	 public  ExtentSparkReporter spark = new ExtentSparkReporter("Results/jenkins_extentReport.html");
	 public ExtentTest test;


public  void browser(String browsername, String url) throws InterruptedException {

if(browsername.equalsIgnoreCase("chrome")) {

	WebDriverManager.chromedriver().setup();
	log.info("launched browser");

driver= new ChromeDriver();
driver.get(url);
driver.manage().window().maximize();
log.info("maximize window");
Thread.sleep(2000);
}

else if (browsername.equalsIgnoreCase("edge")) {


	WebDriverManager.edgedriver().setup();
	log.info("launch edge browser");

	driver= new EdgeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	log.info("maximize window");
	Thread.sleep(2000);
}
}


public void waitfortitle(String pagetitle) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofHours(1));
	wait.until(ExpectedConditions.titleContains(pagetitle));
}
public void waitforclickible(WebElement element) {
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofHours(1));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public void implicitywait(WebDriver driver){
	WebDriverWait waits= new WebDriverWait(driver, Duration.ofSeconds(30));
}
public void Verifypagetitle(String expectedtitle) {
	String actualpagetitle= driver.getTitle();
	Assert.assertEquals(actualpagetitle, expectedtitle, "pagetitle verified");
	log.info("******pagetitle verified*****");
	
}

public void configreport() {
	extent.attachReporter(spark);
	extent.setSystemInfo("machine", "pc");
	extent.setSystemInfo("Os", "windows");   //operationnal system
	extent.setSystemInfo("browser", "chrome");
	extent.setSystemInfo("username", "kathia");
	
	//look change
	spark.config().setTheme(Theme.DARK); //to change the backround
	spark.config().setDocumentTitle("kathia's report"); // to change the name of the report
}

public void screenshot(String foldername) {
	
	File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationpath= new File(ud+"\\pictures\\"+foldername+"\\"+System.currentTimeMillis()+"home.jpg");
	try {
		FileHandler.copy(ss, destinationpath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public String Captureforss (String foldername) {
	
	File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destinationpath= new File(ud+"\\pictures\\"+foldername+"\\"+System.currentTimeMillis()+"home.jpg");
	try {
		FileHandler.copy(ss, destinationpath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//we need to return the absolute part first 
	String absolutepath = destinationpath.getAbsolutePath();
	//we have to return it since we have a return method
	return absolutepath;
}


public void teardown() {
	driver.close();

}
}
