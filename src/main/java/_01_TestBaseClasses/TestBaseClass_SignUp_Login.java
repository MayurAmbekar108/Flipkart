package _01_TestBaseClasses;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import _02_GlobalUtils.TakeScreenShot;
//import _02_GlobalUtils.TakeScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.*;

public class TestBaseClass_SignUp_Login implements ITestListener {
	protected WebDriver driver;
	protected static ExtentReports extent;
	public static ExtentTest extentTest;
	public static Logger log = LogManager.getLogger(TestBaseClass_SignUp_Login.class.getName());
	public static Properties prop = new Properties();
	public static FileReader fr;

	@Parameters("browser")
	@BeforeMethod
	public void browserlaunch(@Optional("chrome") String browser) throws IOException, InterruptedException {
		fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
		prop.load(fr);
		String browser1 = prop.getProperty("browser");
		String flipkart_Login_URL = prop.getProperty("Flipkart_Login_URL");

		if (browser1.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched");
		}

		else if (browser1.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
			driver = new FirefoxDriver(options);
		}

//		else if (browser1.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			log.info("Firefox browser launched");
//		}

		else if (browser1.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("Edge browser launched");
		}

		else {
			log.error("browser not launched");
		}

		driver.get(flipkart_Login_URL);
		System.out.println(flipkart_Login_URL);
		log.info("Landed on url " + flipkart_Login_URL);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		log.info("Browser launched and maximized");
		Thread.sleep(5000);

	}

//	@BeforeTest
//	public void setExtent() throws IOException {
//		fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
//		prop.load(fr);
//		String browser1 = prop.getProperty("browser");
//		//String runOnUr = prop.getProperty("URL");
//
//		extent = new ExtentReports(
//				"C:\\Users\\ASZ\\eclipse-workspace\\Z.flipkart\\Extent_report\\Extent_report.html", true);
//		
////		fr = new FileReader(System.getProperty("user.dir") + "Extent_report\\Extent_report.html");
////		prop.load(fr);
//		extent.addSystemInfo("Host name ", "FaceBook");
//		extent.addSystemInfo("User name ", "Ganesh/Mayur");
//		extent.addSystemInfo("Envirnment ", "QA");
//		extent.addSystemInfo("Browser ", browser1);
//		//extent.addSystemInfo("URL ", runOnUr);
//	}
	
	@BeforeTest
	public void setExtent() throws IOException {
	    fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
	    prop.load(fr);
	    String browser1 = prop.getProperty("browser");

	    // Define the directory for the extent report
	    String reportDirectory = System.getProperty("user.dir") + "\\Extent_report";
	    // Define the full path for the extent report file
	    String reportFilePath = reportDirectory + "\\Extent_report.html";

	    // Initialize ExtentReports with the directory path
	    extent = new ExtentReports(reportFilePath, true);

	    extent.addSystemInfo("Host name ", "FaceBook");
	    extent.addSystemInfo("User name ", "Ganesh/Mayur");
	    extent.addSystemInfo("Envirnment ", "QA");
	    extent.addSystemInfo("Browser ", browser1);
	}

	@AfterMethod
	public void browserclose(ITestResult results) throws IOException, InterruptedException, AWTException {
		if (results.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, results.getName() + " Test case Failed");// to add name in extent report
			extentTest.log(LogStatus.FAIL, "Test case failed is " + results.getThrowable());// to add error/exception in
			extentTest.log(LogStatus.FAIL, "Test case failed with status as " + results.getStatus());
			extentTest.log(LogStatus.FAIL, "Test case failed withing Millis " + results.getEndMillis());
			extentTest.log(LogStatus.FAIL, "Assertion error: " + results.getThrowable().getMessage());
			extentTest.log(LogStatus.FAIL, "Assertion error: " + results.getSkipCausedBy());
			String screenshotPath = TakeScreenShot.captureSceenShot1(driver, results.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add ss in extent report

		} else if (results.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test case skipped is " + results.getName());

		} else if (results.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, results.getName() + " Test case passed ");
			extentTest.log(LogStatus.PASS, "Test case passed with status as " + results.getStatus());
			extentTest.log(LogStatus.PASS, "Test case passed withing Millis " + results.getEndMillis());
			String screenshotPath = TakeScreenShot.captureSceenShot1(driver, results.getName());
			extentTest.log(LogStatus.PASS, extentTest.addScreenCapture(screenshotPath));
		}
		Thread.sleep(3000);
		extent.endTest(extentTest);
		Thread.sleep(3000);

		driver.quit();
		log.info("Browser closed");
	}

	@AfterTest
	public void teardown() {
		if (extent != null) {
			extent.flush();
			extent.close();
		}
	}
}
