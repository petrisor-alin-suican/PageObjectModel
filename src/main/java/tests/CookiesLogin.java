package tests;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MenuPage;
import utils.BaseTest;

public class CookiesLogin extends BaseTest {
	
	Set<Cookie> cookies;
	
	
	@Parameters({"user", "pass"})
	@Test(description = "positiveScenario")
	public void validLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		LoginPage login = new LoginPage(driver);
		login.loginInApp("TestUser", "12345@67890");
		
		assertTrue(login.loginMsgIsDisplayed(login.loginSuccessMsg));
		cookies = driver.manage().getCookies();
		
			}
	
	@Test(priority = 2)
	public void cookiesLogin() throws InterruptedException {
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.loginLink);
		
		for(Cookie cookie : cookies) {
			
			driver.manage().addCookie(cookie);
			
			menu.navigateTo(menu.shopLink);
			Thread.sleep(4000);
		}
	}

}
