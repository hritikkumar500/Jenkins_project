package amazon.testcases;

import org.testng.annotations.Test;
import amazon_project.pages.Basepage;
import amazon_project.pages.searchbarpage;
import amazon_project.utilities.ReadingPropertiesFile;

public class SearchTest extends Basepage {
	
	@Test 
	public void searchbar() throws Exception {
		
	//TO switch to new window opened	
	for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle); 
		}
	
	//To perform action on new window
	driver.findElement(searchbarpage.searchbar_txt).sendKeys(ReadingPropertiesFile.getProperty("Search_for"));
	driver.findElement(searchbarpage.search_btn).click();
	driver.findElement(searchbarpage.search_option_btn).click();	 
}
}
