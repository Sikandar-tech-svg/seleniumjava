package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonOperation;

public class SearchResultsPage extends CommonOperation {

	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Locators

//	@FindBy(xpath = "//*[@data-cel-widget=\"search_result_1\"]/descendant::span[12]")
	@FindBy(xpath = "(//*[contains(@data-cel-widget,'search_result_2')]/descendant::span[3])[1]")
	WebElement lbl_searchResult1;

	@FindBy(xpath = "//*[@data-cel-widget='search_result_2']/descendant::a[2]")
	WebElement anc_searchResult1;
	
	@FindBy(xpath = "//*[@role='listitem']/descendant::a/h2")
	List<WebElement> lbl_ProductList;
	
	@FindBy(xpath = "//*[text()='Limited time deal'][@class=\"a-badge-text\"]")
	List<WebElement> lbl_LimitedTimeDealList;
	
	@FindBy(xpath = "//*[text()='Limited time deal'][@class=\"a-badge-text\"]/ancestor::div[6]/div[1]/a/h2")
	List<WebElement> lbl_ProductNameLimitedTimeDeal;
	
	@FindBy(xpath = "//*[@role='listitem']/descendant::a[@aria-label=\"4.3 out of 5 stars, rating details\"]")
	List<WebElement> btn_Rating4_3OutOf5;
	
	@FindBy(xpath = "//*[@role='listitem']/descendant::a[@aria-label=\"4.4 out of 5 stars, rating details\"]")
	List<WebElement> btn_Rating4_4OutOf5;
	
	@FindBy(xpath = "//*[@role='listitem']/descendant::a[@aria-label=\"4.5 out of 5 stars, rating details\"]")
	List<WebElement> btn_Rating4_5OutOf5;
	
//	Action Methods
	public String openProductDetails() {
		waitForVisibilityOfElement(driver, lbl_searchResult1);
		String productname = lbl_searchResult1.getText();
		click(driver, anc_searchResult1);
		return productname;
	}
	
	public void openProductDetailsUsingIndex(int index) {
		click(driver, lbl_ProductList.get(index));
	}
	
	public String getLimitedTimeDealProductName() {
		scrollToElement(driver, lbl_LimitedTimeDealList.get(0));
		return lbl_ProductNameLimitedTimeDeal.get(0).getText();	
	}
	
	public int getProductListCount() {
		return lbl_ProductList.size();
	}
	
	public int getIndividualRatingCount() {
		System.out.println("4.3 Rating Count is: " + btn_Rating4_3OutOf5.size());
		System.out.println("4.4 Rating Count is: " + btn_Rating4_4OutOf5.size());
		System.out.println("4.5 Rating Count is: " + btn_Rating4_5OutOf5.size());
		
//		int four_Three = btn_Rating4_3OutOf5.size();
//		int four_Four = btn_Rating4_4OutOf5.size();
//		int four_Five = btn_Rating4_5OutOf5.size();
		
//		int total = four_Three + four_Four + four_Five;
		
		return btn_Rating4_3OutOf5.size() + btn_Rating4_4OutOf5.size() + btn_Rating4_5OutOf5.size();
		
	}
}
