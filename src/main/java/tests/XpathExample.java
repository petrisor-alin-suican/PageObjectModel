package tests;

import org.openqa.selenium.By;
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
	}
}
