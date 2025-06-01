package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class Test12 extends base {

	HomePage home;
	SearchResultsPage search;
	
	@BeforeClass
	public void preTest () {
		home = new HomePage(driver);
		search = new SearchResultsPage(driver);
	}
	
	@Test
	public void test12 () throws InterruptedException {
		Thread.sleep(5000);	
		home.search("iphone");
		home.setRatingFourStarsAndUp();
		Thread.sleep(1000);	
		System.out.println("Count of all elements is: " + search.getProductListCount());
		search.getIndividualRatingCount();
		Assert.assertEquals(search.getProductListCount(), search.getIndividualRatingCount());
	
	}
}
