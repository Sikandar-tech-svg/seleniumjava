package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;

public class Test1_2_3 extends base {
	boolean flag = false;

	@Test
	public void test1() {

		driver.getCurrentUrl();

		if (driver.getCurrentUrl().contains("amazon.in")) 
			flag = true;
		 else 
			flag = false;
		
		Assert.assertTrue(flag, "Test is failed");

	}

	@Test
	public void test2() {

		driver.getTitle();
		if (driver.getCurrentUrl().contains("amazon.in")) 
			flag = true;
		 else 
			flag = false;
		
		Assert.assertTrue(flag, "Title didn't match");

	}

	@Test
	public void test3() throws InterruptedException {
		
		HomePage home;
		home = new HomePage (driver);
		
		home.navigateToCart();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		
		Assert.assertTrue(driver.getTitle().contains("Shopping Cart"), "Title didn't match");
		
	}
	
	
	
	
	
	
	
	
}