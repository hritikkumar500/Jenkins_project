package amazon.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import amazon_project.pages.AddToCartPage;
import amazon_project.pages.Basepage;
import amazon_project.pages.searchbarpage;

public class AddToCartTest extends Basepage {
	
	@Test(priority = 1)
	public void addtocart() { 
		Assert.assertEquals(searchbarpage.search_option_btn, AddToCartPage.searchresult_txt);
		System.out.println("Search result is correct");
		driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle); 
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.findElement(AddToCartPage.addToCart_btn).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(AddToCartPage.cart_btn).click();
		
		
	}

	

}
