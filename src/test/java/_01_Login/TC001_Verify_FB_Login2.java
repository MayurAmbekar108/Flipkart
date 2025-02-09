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

public class TC001_Verify_FB_Login2 extends TestBaseClass_SignUp_Login{
	@Test
	public void verifyEditRoleOnAssigneeListPage() throws InterruptedException, IOException {
		extentTest = extent.startTest(" FB Login ");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		_01_LoginPage login = new _01_LoginPage(driver);

		// Enter Email
		try {
			login.sendEmail();;
			log.info(" Email entered");
		} catch (NoSuchElementException e) {
			log.error(" Email not entered");
			throw new AssertionError(e);
		}

		// Enter Password
		try {
			login.sendPassword();
			log.info(" Password entered");
		} catch (NoSuchElementException e) {
			log.error(" Password not entered");
			throw new AssertionError(e);
		}

		// Click on log in facebook
		try {
			login.clickOnLogIn();
			log.info(" Clicked on login button");
		} catch (NoSuchElementException e) {
			log.error(" Not clicked on login");
			throw new AssertionError(e);
		}
		
		{
			try {
				String expectedurl = "https://www.facebook.com/?sk=welcome";
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
