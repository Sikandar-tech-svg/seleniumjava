package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonOperation;

public class HomePage extends CommonOperation{

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
// WebElements
	
	@FindBy(id = "nav-cart")
	WebElement btn_Cart;

	@FindBy(id = "glow-ingress-block")
	WebElement btn_Location;
	
	@FindBy(id = "GLUXZipUpdateInput")
	WebElement txt_Pincode;
	
	@FindBy(xpath = "//*[@aria-labelledby='GLUXZipUpdate-announce']")
	WebElement btn_Apply;
	
	@FindBy(id = "glow-ingress-line2")
	WebElement lbl_Pincode;
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement btn_HelloSignIn;
	
	@FindBy(id = "nav-flyout-ya-signin")
	WebElement btn_SignIn;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement txt_Search;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement btn_Search;
	
	@FindBy(id = "nav-search-dropdown-card")
	WebElement dd_SearchOptions;
	
	@FindBy(id = "searchDropdownBox")
	WebElement dd_SearchDropdown;
	
	@FindBy(id = "icp-touch-link-language")
	WebElement btn_Language;
	
	@FindBy(xpath = "//*[@value='hi_IN']/following-sibling::i") 
	WebElement btn_Hindi;
	
	@FindBy(xpath = "//*[@value='en_IN']/following-sibling::i") 
	WebElement btn_English;
	
	@FindBy(xpath = "//*[@aria-labelledby=\"icp-save-button-announce\"]") 
	WebElement btn_SaveChanges;
	
	@FindBy(xpath = "//*[@class=\"navFooterDescItem\"]/a")
	List<WebElement> anc_footerlinks;
	
	@FindBy(className = "a-star-medium-4")
//	@FindBy(xpath = "//*[@class=\"a-icon a-icon-star-medium a-star-medium-4\"]")
	WebElement btn_FourStarsAndUp;
	
	@FindBy(xpath = "//*[@class=\"nav-li\"]/div/a")
	List<WebElement> header_ListItems;
	
// Action Methods
	public void navigateToCart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btn_Cart));
		waitForVisibilityOfElement(driver, btn_Cart);
		click(driver, btn_Cart);
		Thread.sleep(2000);
		driver.navigate().refresh();
		logger.info("** ---- Clicked on the Cart button");
	}
	
	public void enterPincode(String Pincode) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(btn_Location));
//		waitForVisibilityOfElement(driver, btn_Location);
		click(driver, btn_Location);
		logger.info("** ---- Clicked on the Location button");
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(txt_Pincode));
//		waitForVisibilityOfElement(driver, txt_Pincode);
//		txt_Pincode.clear();
//		txt_Pincode.sendKeys(Pincode);
		sendKeys (driver, txt_Pincode, Pincode);
		logger.info("** ---- Entered Pincode");
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(btn_Apply));
//		waitForVisibilityOfElement(driver, btn_Apply);
//		btn_Apply.click();
		click (driver, btn_Apply);
		logger.info("** ---- Clicked on the Apply button");
	}
	
	public String verifyPincode() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(btn_Location));
//		waitForVisibilityOfElement(driver, lbl_Pincode);
//		String pin = lbl_Pincode.getText();
//		return pin;
//		return lbl_Pincode.getText();
		Thread.sleep(2000);
		return getText(driver, lbl_Pincode);
	}
		public void navigateToSignInScreen() {
			logger.info("** ---- Hovering on the Hello Sign In");
			hoverOnElement(driver, btn_HelloSignIn);
			logger.info("** ---- Clicking on the Sign In Button");
			click (driver, btn_SignIn);
		}
	
		public void search(String productname) {
			sendKeys(driver, txt_Search, productname);
			click(driver, btn_Search);
			logger.info("** ---- Searching for - " + productname);
		}
		
		public int getDropdownOptionsCount() {
			click(driver, dd_SearchOptions);
			Select select = new Select(dd_SearchDropdown);
			return select.getOptions().size();
		}
		
		public String getOptionValueUsingIndex (int index) {
			Select select = new Select(dd_SearchDropdown);
			return select.getOptions().get(index).getText();
		}
		
		public void selectUsingVisibleText(String option) {
			Select select = new Select(dd_SearchDropdown);
			select.selectByVisibleText(option);
		}
		
		public void changeLanguage(String language) {
			scrollToBottom(driver);
			
			click(driver, btn_Language);
			
			if (language.equals("Hindi"))
				click(driver, btn_Hindi);
			else if (language.equals("English"))
				click(driver, btn_English);
			
			click(driver, btn_SaveChanges);
		}
		
		public void openFooterLinks() {
			scrollToBottom(driver);
			
			for(int i = 0; i <= anc_footerlinks.size() -1; i++) {
				String link = anc_footerlinks.get(i).getAttribute("href");
				click(driver, anc_footerlinks.get(i));
				if(driver.getCurrentUrl().equals(link))
					System.out.println(link + "Matches");
				else
					System.out.println(link + "Did not Match");
				driver.navigate().back();
			}
		}
		
		public void setRatingFourStarsAndUp() {
			click(driver, btn_FourStarsAndUp);
		}
		
		public int getHeaderListItemsCount() {
			return header_ListItems.size();
		}
		
		public void verifyHeaderMenuItemUrl() throws InterruptedException {
			
			for (int i = 2; i <= header_ListItems.size() - 1; i++) {
				String link = header_ListItems.get(i).getAttribute("href");
				click(driver, header_ListItems.get(i));
				Thread.sleep(2000);
				if (driver.getCurrentUrl().contains(link))
					System.out.println(header_ListItems.get(i).getText() + " + HREF and URL matches");
				else
					System.out.println(header_ListItems.get(i).getText() + " + HREF and URL did not match");
				driver.navigate().back();
				Thread.sleep(2000);
				
			}
		}
		
	}