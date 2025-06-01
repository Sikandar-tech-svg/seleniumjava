package utilities;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonOperation {
	
public static final Logger logger = Logger.getLogger(CommonOperation.class.getName());	

public void waitForVisibilityOfElement(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitForVisibilityOfElements (WebDriver driver, List<WebElement> elements) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfAllElements(elements));
}

public void click(WebDriver driver, WebElement element) {
	waitForVisibilityOfElement(driver, element);
	element.click();
}
	
public void sendKeys (WebDriver driver, WebElement element, String value) {
	waitForVisibilityOfElement(driver, element);
	element.clear();
	element.sendKeys(value);
}

public String getText (WebDriver driver, WebElement element) {
	waitForVisibilityOfElement(driver, element);
	return element.getText();
}

public void hoverOnElement(WebDriver driver, WebElement element) {
	waitForVisibilityOfElement(driver, element);
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
}

public String getParentHandle(WebDriver driver) {
	return driver.getWindowHandle();
}

public void switchToChildWindow(WebDriver driver) {
	String parenthandle = driver.getWindowHandle();
	Set<String> windowhandles = driver.getWindowHandles();
	for(String handle : windowhandles) {
		if(!handle.matches(parenthandle))
			driver.switchTo().window(handle);
	}
}

public void switchToParentWindow(WebDriver driver, String windowHandle) {
	driver.switchTo().window(windowHandle);
}

public void scrollToBottom(WebDriver driver) {
	Actions action = new Actions(driver);
	action.sendKeys(Keys.END);
//	action.scrollToElement(null);
	
}

public void scrollToElement(WebDriver driver, WebElement element) {
	Actions action = new Actions(driver);
	action.scrollToElement(element);

}

public void zoomOutBrowser(WebDriver driver) throws InterruptedException {
	JavascriptExecutor je = (JavascriptExecutor) driver;
	je.executeScript("document.body.style.zoom= '40%'");
	Thread.sleep(5000);
//	je.executeScript("window.scrillBy(0,200)","");

	}
}

