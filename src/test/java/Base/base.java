package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import utilities.CommonOperation;

public class base extends CommonOperation {

	public static WebDriver driver;
	ExtentTest test;
	@BeforeTest
	public void setup() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/utilities/config.properties");
		prop.load(fis);
				
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("baseUrl"));
		Thread.sleep(10000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "/Screenshots/" + testCaseName + "_" + getCurrentDateTime()
				+ ".png";
		FileUtils.copyFile(source, new File(destPath));
		return destPath;
	}
	public static String getCurrentDateTime() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
	}

}
