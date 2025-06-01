package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchResultsPage;

public class Test7 extends base {

	HomePage home;
	SearchResultsPage search;
	ProductPage product;
	CartPage cart;

	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
		search = new SearchResultsPage(driver);
		product = new ProductPage(driver);
		cart = new CartPage(driver);
	}

	@Test
	public void test7() throws InterruptedException {
		home.search("Mobile Phones");
		search.openProductDetailsUsingIndex(2);
		String parenthandle = driver.getWindowHandle();
		switchToChildWindow(driver);
		product.addToCart();
		switchToParentWindow(driver, parenthandle);

		search.openProductDetailsUsingIndex(3);
		switchToChildWindow(driver);
		product.addToCart();
		switchToParentWindow(driver, parenthandle);

		home.navigateToCart();
		Assert.assertEquals(cart.getCartProductsCount(), 2);

	}
}
