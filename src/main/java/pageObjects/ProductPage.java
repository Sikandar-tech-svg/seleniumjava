package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonOperation;

public class ProductPage extends CommonOperation {

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
//	Locators
	@FindBy(xpath = "(//*[@id='add-to-cart-button'])[2]")
	WebElement btn_AddToCart;
	

//	Action Methods
	public void addToCart() {
		click(driver, btn_AddToCart);
	}
	
}
