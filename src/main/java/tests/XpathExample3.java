package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample3 extends BaseTest {
	
	@Test
	public void xpathExample3() {
		
		driver.findElement(By.linkText("BOOKS")).click();
		
		//--> //span[bdi='$14.99']  
		//--> //bdi[contains(text(), '14.99')]
		
		
		//select and go back one level and down on specific sibling
		// -> //bdi[contains(text(), '14.99')]/../../following-sibling::a
		
		
		// atunci cand vreau ultimul element dar nu pot sa ma bazez pe index atunci folosim last()   --> (//h2[@class='woocommerce-loop-product__title'])[last()]
		//                                                                                           -->(//h2[@class='woocommerce-loop-product__title'])[last()-1] penultimul
		
		// similar cu index --> (//h2[@class='woocommerce-loop-product__title'])[lposition()=16]
	}

}
