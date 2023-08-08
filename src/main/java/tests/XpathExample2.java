package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample2 extends BaseTest {
	
	
	@Test
	public void xpathExampleTest() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//<a href="#popup_login" class="popup_link popup_login_link icon-user inited" title="">Login</a>
		
	    //-->	//a[contains(@class, 'popup_login_link')]  
     	//-->	//a[contains(text(), 'Login')]
		//-->   //a[contains(@class, 'popup_login_link')]/parent::li[@class='menu_user_login']    --> ne folosim de parinte 
		//-->   //li/a[contains(@class, 'popup_login_link')]  --> ne folosim de parinte
		
		WebElement loginPopUp = driver.findElement(By.xpath("//a[contains(@class, 'popup_login_link')]/parent::li[@class='menu_user_login']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:5px solid red')", loginPopUp);
		loginPopUp.click();
		
		//--> //ul[@id='menu_user']//input[@name='log']  -->varianta simpla
		//--> //ul[@id='menu_user']/descendant::input[@name='log']  --> caut un descendent al lui ul
		//--> //ul[@id='menu_user']/descendant::form[contains(@class, 'login_form')]/child::div[contains(@class, 'login_field')]/child::input[@name='log']
		
		// cu descendant sar de la un element cat de mult pot in jos
		// cu child pot spune ca are un direct child si de la nodul curent plec cu child mai jos si cobor pe unul din element imediat de sub
		// cand mai multe elemente sunt implicate in definitia unui locator, el e mai instabil
		// 
		
		WebElement userField = driver.findElement(By.xpath("//ul[@id='menu_user']/descendant::form[contains(@class, 'login_form')]/child::div[contains(@class, 'login_field')]/child::input[@name='log']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:5px solid red')", userField);
		userField.sendKeys("TestUser");
		
		//--> //ul[@id='menu_user']/descendant::form[contains(@class, 'login_form')]/child::div[contains(@class, 'password_field')]/child::input[@name='pwd']
		//--> //ul[@id='menu_user']/descendant::input[@name='pwd']
		//--> //ul//input[@name='pwd']
		
		WebElement passwordField = driver.findElement(By.xpath("//ul[@id='menu_user']/descendant::input[@name='pwd']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:5px solid red')", passwordField);
		passwordField.sendKeys("12345@67890");
		
		//--> //ul//div[contains(@class, 'login_field')]/following-sibling::div[contains(@class, 'remember_field')]/input
		WebElement rememberMe = driver.findElement(By.xpath("//ul//div[contains(@class, 'login_field')]/following-sibling::div[contains(@class, 'remember_field')]/input"));
		rememberMe.click();
		//rememberMe.isSelected();   //--> metoda isSelected() se aplica doar pe elemente de tip checkbox / radio button   //adica are atribut type="checkbox"
		
		
		
		//preceding (traverseaza domul in sus, fara relatie de rudenie)
		//following (traverseaza domul in jos, fara relatie de rudenie)
		//--> //div[@class='top_panel_middle']/preceding::input[@class='submit_button']
		WebElement submitButton = driver.findElement(By.xpath("//div[@class='top_panel_middle']/preceding::input[@class='submit_button']"));
		submitButton.click();
	
	
	}

}
