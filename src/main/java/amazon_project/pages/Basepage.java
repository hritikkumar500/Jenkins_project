package amazon_project.pages;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import amazon_project.utilities.ExtentManager;
import amazon_project.utilities.ScreenShots;

public class Basepage {
	
	public static WebDriver driver;
	public static ChromeOptions option;
	public static ExtentReports extent;
	public static ExtentTest test;	
		

	@BeforeSuite
	public void setup() throws InterruptedException { 
		
		//To run Tests in headless mode uncomment the below lines
//			option = new ChromeOptions();
//			option.setHeadless(true);   //Add text "option" within [driver= new ChromeDriver(option)]    	 		 
		 
		
		//To open chrome driver		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		 
		//To maximize chrome driver 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);	 			
		extent = ExtentManager.getInstance("reports//Extent_report.html");		
	}	
//	@BeforeTest	
//	public void nevigateToURL() {
//	driver.get(ReadingPropertiesFile.getProperty("main_url"));
//	} 
	
	@BeforeMethod
	public void startTest(Method method) {
		test= extent.startTest(method.getName());		
	}
	
	@AfterMethod 
	public void status(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.SUCCESS)
			test.log(LogStatus.PASS, "Test case got passed");
		else if (result.getStatus()==ITestResult.FAILURE) {
			ScreenShots.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, "Test case got failed");
		}
		extent.flush();		
	} 
	
	@AfterSuite
	public void closeURL() {
		driver.quit();
	}

}