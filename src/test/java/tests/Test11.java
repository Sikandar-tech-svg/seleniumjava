package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;

public class Test11 extends base {

	HomePage home;

	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}

	@Test
	public void test11() {
		home.openFooterLinks();
	}
}
