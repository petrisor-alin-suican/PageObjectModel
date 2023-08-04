package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
	
	public WebDriver driver;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;

		}
	
	public By orderDropDown = By.xpath("//select[@class='orderby']");
	
	public void filterByValue(String value) {
		WebElement element = driver.findElement(orderDropDown);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	
	
	public String getCurrentSelectedOption() {
		WebElement element = driver.findElement(orderDropDown);
		Select dropdown = new Select(element);
		return dropdown.getFirstSelectedOption().getText();
		
	}
	
	public void filterByVisibleText(String value) {
		WebElement element = driver.findElement(orderDropDown);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}
	

	public void filterByIndex(String value) {
		WebElement element = driver.findElement(orderDropDown);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(3);
	}
}