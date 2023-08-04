package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest{

	@Test(priority = 1)
	public void xpathExample() {
		
	    //  <li class="menu_user_login">    
		//  li[class='menu_user_login']   css selector
		
		//  //li[@class = 'menu_user_login']   xpath
		
		driver.findElement(By.xpath("//li[@class='menu_user_login']")).click();
		
		//OR
		driver.findElement(By.xpath("//input[@id='log' or @name='log']")).sendKeys("TestUser");
		
		//AND
		//driver.findElement(By.xpath("//input[@id='log' and @name='log']")).sendKeys("TestUser");
		driver.findElement(By.xpath("//input[@id='password' and @name='pwd']")).sendKeys("12345@67890");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}
	
	@Test(priority = 2)
	public void xpathExample2() {
		driver.findElement(By.xpath("//span[@class='user_name']")).click();
		
		//<a href="https://keybooks.ro/wp-admin/profile.php" class="icon icon-cog">Settings</a>     xpath citeste textul Settings care se afla dupa <>     cssSele citeste doar ce se afla intre <>
		
		// text() citeste textul dintre tagurile html pe elementul de mai sus, citeste settings
		driver.findElement(By.xpath("//a[text() = 'Settings']")).click();       //a[contains(text(),'Settings')]
		
		
		// <a href="https://keybooks.ro/account/orders/">recent orders</a>
		// xpath //a[contains(text(), 'orders')]  --> e de ajuns text partial
		// xpath -->  //a[text()='recent orders']  --> trebuie tot textul dintre taguri
		
		driver.findElement(By.xpath("//a[contains(text(), 'orde')]")).click();
		
		// ////th[contains(@class, 'woocommerce-orders-table__header')]
		//   th[class*='woocommerce-orders-table__header']
		// //th[contains(@class, 'woocommerce-orders-table')]/span[contains(text(), 'Order')]
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement orderTableHeader = driver.findElement(By.xpath("//th[contains(@class, 'woocommerce-orders-table')]/span[contains(text(), 'Order')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", orderTableHeader);
		
		// pe baza de index aleg elementul (//th[contains(@class, 'woocommerce-orders-table')]/span)[3]
		
		WebElement statusTableHeader = driver.findElement(By.xpath("(//th[contains(@class, 'woocommerce-orders-table')]/span)[3]")); 
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", statusTableHeader);
		
		WebElement order1721 = driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(), '1721')]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:blue; border:5px solid red')", order1721);
		
		// //td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(), '1721'))]
		
		WebElement orders = driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(), '1721'))]"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:red; border:5px solid red')", orders);

	}
}
