package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;

public class Test5 extends base{
	HomePage home;
	
	@BeforeClass
	public void preTest () {
		home = new HomePage(driver);
	}
	
	@Test	
	public void test5() {
		home.navigateToSignInScreen();
		Assert.assertFalse(driver.getCurrentUrl().contains("signin"), "Sign in page doesnt exist");
		
	}
}
