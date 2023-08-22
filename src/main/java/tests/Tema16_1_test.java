package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.ContactPage;
import pageObjects.MenuPage;
import utils.BaseTest;

public class Tema16_1_test extends BaseTest {
	
	
	@Test
	public void sendTheMessage() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.contactsLink);
		
		ContactPage contact = new ContactPage(driver);
		contact.sendMessage("Alin Suican", "alin.alin@gmail.ro", "this is a test");
		
		assertTrue(contact.confirmationMsgIsDisplayed(contact.confirmationMessage));
		
	}

}
