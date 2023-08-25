package utils;

import pageObjects.ContactPage;
import pageObjects.EventsPage;
import pageObjects.GenericEventPage;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ShopPage;

public class BasePage extends SeleniumWrappers {

	
	public ContactPage contact = new ContactPage(driver);
	public MenuPage menu = new MenuPage(driver);
	public ShopPage shop = new ShopPage(driver);
	public LoginPage login = new LoginPage(driver);
	public EventsPage events = new EventsPage(driver);
	public GenericEventPage genericEvent = new GenericEventPage(driver);
	
}
