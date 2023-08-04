package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	
	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//MenuPage menu = new MenuPage(driver);
	
	//locatori
	//driver.findEelement(By.cssSelector (..."))
	
	public By contactsLink = By.linkText("CONTACTS");
	//WebElement driver.findElement(By.cssSelector("li[class='menu_user_login']");
	public By loginLink = By.cssSelector("li[class='menu_user_login']");
	public By shopLink = By.linkText("BOOKS");
	
	//metode specifice
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	//MenuPage menu = new MenuPage(driver);
	//menu.navigateTo(menu.loginLink);
	//menu.navigateTo(menu.contactsLink);

}
