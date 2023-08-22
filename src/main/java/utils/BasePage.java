package utils;

import pageObjects.ContactPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ShopPage;

public class BasePage extends BaseTest {

	
	public ContactPage contact = new ContactPage(driver);
	public MenuPage menu = new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);
	public LoginPage login = new LoginPage(driver);
	
}
