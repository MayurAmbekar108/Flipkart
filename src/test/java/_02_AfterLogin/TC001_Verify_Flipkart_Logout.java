package _02_AfterLogin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import _01_TestBaseClasses.TestBaseClass_SignUp_Login;
import _03_POM_Classes._01_LoginPage;
import _03_POM_Classes._02_Flipkart_Homepage;

public class TC001_Verify_Flipkart_Logout extends TestBaseClass_SignUp_Login {
	@Test
	public void verifyFlipkartLoginSuccess() throws InterruptedException, IOException {
		extentTest = extent.startTest(" Flipkart Logout ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		_01_LoginPage login = new _01_LoginPage(driver);
		_02_Flipkart_Homepage homepage = new _02_Flipkart_Homepage(driver);

		Actions actions = new Actions(driver);
		// Enter Email or phone number manually
		try {
			login.sendEmail();
			log.info(" Email entered");
			System.out.println("Email entered");

		} catch (NoSuchElementException e) {
			log.error(" Email not entered");
			System.out.println("Email not entered");

			throw new AssertionError(e);
		}

		// Click on Request OTP button
		try {
			login.clickOnRequestOtp();
			log.info(" Clicked on Request OTP button");
			System.out.println(" Clicked on Request OTP button");

		} catch (NoSuchElementException e) {
			log.error(" Not clicked on Request OTP button");
			System.out.println("Not Clicked on Request OTP button");
			throw new AssertionError(e);
		}
		// Click on Verify button
		try {
			Thread.sleep(10000);
			login.clickOnVerifyButton();
			log.info(" Clicked on Verify button");
			System.out.println("Clicked on Verify button");
		} catch (NoSuchElementException e) {
			log.error(" Not clicked on Verify button");
			System.out.println("Not clicked on Verify button");
			throw new AssertionError(e);
		}

		// Hover on Profile on homepage
		try {
			Thread.sleep(5000);
			homepage.hoverOverProfileAndClick(actions);
			log.info(" Hover on profile");
			System.out.println("Hover on profile");
		} catch (NoSuchElementException e) {
			log.error(" Not Hover on Profile");
			System.out.println("Not Hover on profile");

			throw new AssertionError(e);
		}

		// Click on Logout button
		try {

			homepage.clickOnlogout();
			log.info(" Click on logout");
			System.out.println("Click on logout");
		} catch (NoSuchElementException e) {
			log.error(" Not Click on logout");
			System.out.println("Not Click on logout");

			throw new AssertionError(e);
		}

		// assertion for Logout
		try {
			Thread.sleep(5000);
			String expectedurl = "https://www.flipkart.com/?redirectFrom=logout";
			wait.until(ExpectedConditions.urlToBe(expectedurl));
			String actualurl = driver.getCurrentUrl();
			log.info("URL is: " + actualurl);
			extentTest.log(LogStatus.INFO, "URL is: " + actualurl);
			System.out.println("URL is: " + actualurl);
			Assert.assertEquals(actualurl, expectedurl);
			extentTest.log(LogStatus.PASS, " User land on FB Logout page");

		} catch (NoSuchElementException e) {
			log.error("URL is not matching, TC failed");
			extentTest.log(LogStatus.FAIL, "URL is not matching, TC failed");
			System.out.println("URL is not matching, TC failed");
		}

		extent.endTest(extentTest);
	}
}
