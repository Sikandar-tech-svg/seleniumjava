package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;

public class Test8 extends base{

	HomePage home;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}
	
	@Test
	public void test8() {
		System.out.println(home.getDropdownOptionsCount());
		System.out.println(home.getOptionValueUsingIndex(3));
		home.selectUsingVisibleText("Electronics");
		home.search("Laptop");
		Assert.assertTrue(driver.getTitle().contains("Laptop"));
	}
	
}
