package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjects.MenuPage;
import pageObjects.ShopPage;
import utils.BaseTest;

public class DropDownTest extends BaseTest{
	
	@Test(priority=1, groups = "ProductFunctionality")
	public void selectByValueTest() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		ShopPage shop = new ShopPage(driver);
		shop.filterByValue("rating");
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/?orderby=rating");
		
		assertEquals(shop.getCurrentSelectedOption(), "Sort by average rating");
		
	}
	
	@Test(priority = 2, groups = "ProductFunctionality")
	public void selectByVisibleTextTest() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		ShopPage shop = new ShopPage(driver);
		shop.filterByVisibleText("Sort by popularity");
		assertEquals(shop.getCurrentSelectedOption(), "Sort by popularity");
	}

	@Test(priority=3)
	public void selecyByIndexTest() {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		ShopPage shop = new ShopPage(driver);
		shop.filterByIndex(3);
		assertEquals(shop.getCurrentSelectedOption(), "Sort by latest");
		
	}
	
	@Test(priority=4)
	public void example() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		//incarc in memorie un webelement pe sesiunea curenta de browser (session id)
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='orderby']"));
		
		//primeste webelementul si se foloseste de el
		Select select = new Select(dropdown);
		
		//se foloseste de webelement(dropdown) pentru a selecta o optiune
		select.selectByIndex(2);
		
		//in momentul in care face selectia din dropdown, aplicatia (browserul) face refresh
		//in momentul in care face refresh, selenium citeste alt session id
		Thread.sleep(3000);
		
		//el identifica elementul pe un alt session id, decat cel curent si arunca staleElementException
		select.selectByValue("rating");
		
		
	}
}
