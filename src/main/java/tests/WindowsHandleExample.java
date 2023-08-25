package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class WindowsHandleExample extends BaseTest {
	
	
	@Test
	public void windowHandleTest() {
		
		//app.menu.navigateTo(app.menu.eventsLink);
		//app.events.ClickOnEvent(app.events.festivalOfOldFilmsLink);
		
		app.click(app.menu.eventsLink);
		app.click(app.events.festivalOfOldFilmsLink);
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 800).perform();
		
		System.out.print("Current window :" + driver.getWindowHandle());
		
		app.genericEvent.clickMap();
		
		System.out.print("Current window 2:" + driver.getWindowHandle());
		
		System.out.println("All windows :" + driver.getWindowHandles());
		
		List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(browserTabs.get(1));
		
		System.out.print("Current window after switch :" + driver.getWindowHandle());
		
		driver.close();
		driver.switchTo().window(browserTabs.get(0));
		
		System.out.print("Current window after tab close :" + driver.getWindowHandle());
		
		
	}

}
