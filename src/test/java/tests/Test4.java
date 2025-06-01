package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.base;
import pageObjects.HomePage;

public class Test4 extends base {
	
	public HomePage home;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}

	@Test
	public void test4() throws InterruptedException {
		
		home.enterPincode("400001");
		
//		String pincode = home.verifyPincode();
//		Assert.assertTrue(pincode.contains("400001"), "Pincode didn't match");
		
		Assert.assertTrue(home.verifyPincode().contains("400001"), "Pincode didn't match");
		
		home.enterPincode("400005");
		Assert.assertTrue(home.verifyPincode().contains("400005"), "Pincode didn't match");
		
		home.enterPincode("400010");
		Assert.assertTrue(home.verifyPincode().contains("400010"), "Pincode didn't match");
	}
}
