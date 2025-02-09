package _01_Login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import _01_TestBaseClasses.TestBaseClass_SignUp_Login;
import _03_POM_Classes._01_LoginPage;

public class TC001_Verify_Flipkart_Login extends TestBaseClass_SignUp_Login{
	@Test
	public void verifyFlipkartLoginSuccess() throws InterruptedException, IOException {
		extentTest = extent.startTest(" Flipkart Login ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		_01_LoginPage login = new _01_LoginPage(driver);

		// Enter Email or phone number manually
		try {
			login.sendEmail();;
			log.info(" Email entered");
			Thread.sleep(10000);
		} catch (NoSuchElementException e) {
			log.error(" Email not entered");
			throw new AssertionError(e);
		}
		
		// Click on Request OTP button
		try {
			login.clickOnRequestOtp();
			log.info(" Clicked on Request OTP button");
		} catch (NoSuchElementException e) {
			log.error(" Not clicked on Request OTP button");
			throw new AssertionError(e);
		}

		// Enter Otp manually and click on submit button
		try {
			Thread.sleep(15000);
			login.sendOtpNumbers();
			log.info(" Otp entered");
		} catch (NoSuchElementException e) {
			log.error(" Otp not entered");
			throw new AssertionError(e);
		}

		// Click on Verify button
		try {
			login.clickOnVerifyButton();
			log.info(" Clicked on Verify button");
		} catch (NoSuchElementException e) {
			log.error(" Not clicked on Verify button");
			throw new AssertionError(e);
		}
		
		{
			try {
				Thread.sleep(5000);
				String expectedurl = "https://www.flipkart.com/";
				wait.until(ExpectedConditions.urlToBe(expectedurl));			
				String actualurl = driver.getCurrentUrl();
				log.info("URL is: " + actualurl);
				extentTest.log(LogStatus.INFO, "URL is: " + actualurl);
				System.out.println("URL is: " + actualurl);
				Assert.assertEquals(actualurl, expectedurl);
				extentTest.log(LogStatus.PASS, " User land on FB homepage");

			} catch (NoSuchElementException e) {
				log.error("URL is not matching, TC failed");
				extentTest.log(LogStatus.FAIL, "URL is not matching, TC failed");
				System.out.println("URL is not matching, TC failed");
			}
		}
	
		extent.endTest(extentTest);
	}
}
