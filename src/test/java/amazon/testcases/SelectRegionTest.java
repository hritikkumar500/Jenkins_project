package amazon.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import amazon_project.pages.Basepage;
import amazon_project.pages.RegionSelectPage;

public class SelectRegionTest extends Basepage {
	
	@Test
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
