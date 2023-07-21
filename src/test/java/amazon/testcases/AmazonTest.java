package amazon.testcases;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import amazon_project.pages.Basepage;
import amazon_project.pages.RegionSelectPage;
import amazon_project.pages.homepage;
import amazon_project.pages.loginIdPage;
import amazon_project.pages.loginPasswordPage;
import amazon_project.utilities.ReadingPropertiesFile;


public class AmazonTest extends Basepage {
	
	 
	@Test 
	public void login() throws Exception {
		driver.get(ReadingPropertiesFile.getProperty("main_url"));
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		test.log(LogStatus.INFO,"HomePage TitleCorrect");
		//System.out.println("HomePage title correct");
		Thread.sleep(5000);
		driver.findElement(homepage.signin_btn).click();
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In"); 
		test.log(LogStatus.INFO,"LoginPage title correct");
		//System.out.println("LoginPage title correct");
		driver.findElement(loginIdPage.email_txt).sendKeys(ReadingPropertiesFile.getProperty("Email"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(loginIdPage.continue_btn).click();
		Assert.assertEquals(driver.getTitle(), "Amazon Sign In");
		test.log(LogStatus.INFO,"PasswordPage title correct");
		//System.out.println("PasswordPage title correct");
		driver.findElement(loginPasswordPage.password_txt).sendKeys(ReadingPropertiesFile.getProperty("Password"));
		driver.findElement(loginPasswordPage.signIn_btn).click();
		Thread.sleep(5000);
	} 
	
	@Test (priority = 1)
	public void region_change() throws Exception {
		//driver.findElement(homepage.searchbar_txt).sendKeys(ReadingPropertiesFile.getProperty("Search_for"));
		//driver.findElement(homepage.region_change_btn).click();
		// Locating the Main Menu (Parent element)
		//Hovering to change region
		WebElement country_region = driver.findElement(RegionSelectPage.region_change_hover);
		System.out.println("Search result page title correct");
		Actions actions = new Actions(driver);
		actions.moveToElement(country_region).build().perform();
	
		//To store current window handle
		driver.getWindowHandle();
		
		//To change the region
		driver.findElement(RegionSelectPage.region_change_btn).click();
		driver.findElement(RegionSelectPage.regionSelect_btn).click();
		driver.findElement(RegionSelectPage.regionChoice_btn).click();
		driver.findElement(RegionSelectPage.regionSave_btn).click();
		
		
		 
		//Assert.assertEquals(driver.getTitle(),"Amazon.com : iphone12");
		//System.out.println("Search result page title correct");
		
	}
		        
}
