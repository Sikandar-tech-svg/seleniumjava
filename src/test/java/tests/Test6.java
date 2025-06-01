
package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.base;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchResultsPage;

public class Test6 extends base{
	
	HomePage home;
	SearchResultsPage searchresults;
	ProductPage product;
	CartPage cart;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
		searchresults = new SearchResultsPage(driver);
		product = new ProductPage(driver);
		cart = new CartPage(driver);
	}
	
	@Test
	public void test6() throws InterruptedException {
		home.search("Samsung Galaxy S24 FE 5G AI Smartphone");
		String productname = searchresults.openProductDetails();
		logger.info("** 1---- " + productname);
		String parentWindow = getParentHandle(driver);
		switchToChildWindow(driver);
		product.addToCart();
		switchToParentWindow(driver, parentWindow);
		home.navigateToCart();
		logger.info("** 2---- " + cart.getProductLabelFromCart());
		Assert.assertTrue(productname.contains(cart.getProductLabelFromCart()));
		
	}
}

