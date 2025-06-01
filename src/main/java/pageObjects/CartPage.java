package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonOperation;

public class CartPage extends CommonOperation {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Locators
//	@FindBy(xpath = "//*[@class='sc-item-product-title-cont']/descendant::span[4]")
//	@FindBy(xpath = "//*[@role='listitem']/descendant::h4/span/descendant::span[2]")
	@FindBy(xpath = "//*[@class='a-link-normal sc-product-link sc-product-title aok-block']")
	WebElement lbl_CartProductName;

	@FindBy(xpath = "//*[@role='listitem']/descendant::h4/span/descendant::span[2]")
	public WebElement lbl_ProductAddedToCart;
	
	@FindBy(xpath = "//*[@role='listitem']/descendant::h4/span/descendant::span[2]")
	public List <WebElement> lbl_ProductAddedToCartList;

//	Action Methods
	public String getProductLabelFromCart() {
		String productname = lbl_ProductAddedToCart.getText();
		String filteredname = productname.substring(0, productname.length() - 5);
		return filteredname;
	}
	public int getCartProductsCount() {
		return lbl_ProductAddedToCartList.size();
		
	}
}
