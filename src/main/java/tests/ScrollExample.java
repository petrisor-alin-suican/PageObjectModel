package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ScrollExample extends BaseTest {
	
	
    @Test
	public void scrollExample() {
		
    	//JS executor scroll
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	jse.executeScript("window.scrollBy(0, 1000)");
    	
    	//action class scroll
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1000).perform();
	}
	
}
