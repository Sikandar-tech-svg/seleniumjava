package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.base;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class Test10 extends base {
	
	HomePage home;
	SearchResultsPage search;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
		search = new SearchResultsPage(driver);
	}
	
	@Test
	public void test10() {
		home.search("mobile phones");
		System.out.println(search.getLimitedTimeDealProductName());
	}
}
