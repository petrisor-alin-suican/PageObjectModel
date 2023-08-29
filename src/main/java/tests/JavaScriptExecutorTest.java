package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JavaScriptExecutorTest extends BaseTest {
	
	@Test
	public void example1() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//driver.get("http://emag.ro");
		//driver.navigate().to("http://emag.ro");
		jse.executeScript("window.location='http://emag.ro'");
		
		
		//driver.navigate().back();
		jse.executeScript("window.history.go(-1)");
		
		//driver.navigate().forward();
		jse.executeScript("window.history.forward(-1)");
		
		//Refresh browser
		//1
		driver.navigate().refresh();
		//2
		jse.executeScript("window.history.go(0)");
		//3
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5);
		//4
		driver.get(driver.getCurrentUrl());

		
	}
	
	
	@Test
	public void example2() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		
		
	}

}
