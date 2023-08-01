package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

	
	@Test(description = "positiveScenario")
	public void validLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login = new LoginPage(driver);
		login.loginInApp("TestUser", "12345@67890");
		
		assertTrue(login.loginMsgIsDisplayed(login.loginSuccessMsg));
		
			}
	
	@Test(description = "negativeScenario")
	public void invalidUsernameLoginTest() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login = new LoginPage(driver);
		login.loginInApp("TestUser123", "12345@67890");
		
		assertTrue(login.loginMsgIsDisplayed(login.loginErrorMsg));
		//Thread.sleep(4000);
		login.closePopUp();
	}
	
	
	@Test(description = "negativeScenario")
	public void invalidPasswordLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login = new LoginPage(driver);
		login.loginInApp("TestUser", "12345@6");
		
		assertTrue(login.loginMsgIsDisplayed(login.loginErrorMsg));
		
		login.closePopUp();
	}
}
