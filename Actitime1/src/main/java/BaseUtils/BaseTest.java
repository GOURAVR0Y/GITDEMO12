package BaseUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

ExtentReports extent;
ExtentHtmlReporter htmlReporter;
public static ExtentTest test;
WebDriver driver;

@BeforeSuite
public void setUp() {
	htmlReporter =new ExtentHtmlReporter("extent.html");
	extent= new ExtentReports();
	extent.attachReporter(htmlReporter);
}

@BeforeTest
public void beforeTest() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}

@Test
public void testActitime() {
	try {
		test=extent.createTest("BaseTest", "testActitime");
	driver.get("https://demo.actitime.com/login.do");
	test.info("navigate to specified url");
	driver.findElement(By.id("username")).sendKeys("admin");
    test.info("user successfully write username");
	driver.findElement(By.name("pwd")).sendKeys("manager");
    test.info("user successfully write password");
	driver.findElement(By.xpath("//div[contains(.,'Login ')]")).click();
	Thread.sleep(4000);
	test.pass(MarkupHelper.createLabel("user sucessfully login", ExtentColor.GREEN));
	}catch (Exception e) {
		test.fail(MarkupHelper.createLabel("failed to login", ExtentColor.RED));
	}
	
	
}
@AfterTest
public void afterTest() {
	driver.quit();
	extent.flush();
}
}
