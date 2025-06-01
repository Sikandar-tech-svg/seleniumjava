package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;

public class Test9 extends base {
	
	HomePage home;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
			
	}

	@Test
	public void test9() throws InterruptedException {
		
		home.changeLanguage("Hindi");
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("language=hi_IN"));
				
		home.changeLanguage("English");
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("language=en_IN"));
		
	}
	
}
