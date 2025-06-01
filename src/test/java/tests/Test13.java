package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;

public class Test13 extends base{

	HomePage home;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}
	
	@Test
	public void test13() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println(home.getHeaderListItemsCount());
		zoomOutBrowser(driver);
		home.verifyHeaderMenuItemUrl();
	}	
}
