package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnotations {

	public static WebDriver driver;
	
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class");
	}

	@AfterClass(description = "This is after class")
	public void afterClass() {
		System.out.println("This is after Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test");
	}
	
	@Test(priority = 1, dependsOnMethods = "test3")
	public void test1() {
		System.out.println("This is test 1");
	}

	@Test(priority = 2, description = "This is test 3")
	public void test3() {
		System.out.println("This is test 3");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is Before Suite");
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("This is After Suite");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is After Test");
	}

	
}
