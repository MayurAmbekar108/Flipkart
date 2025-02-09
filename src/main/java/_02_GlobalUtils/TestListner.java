package _02_GlobalUtils;

import org.apache.logging.log4j.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import _01_TestBaseClasses.TestBaseClass_SignUp_Login;


public class TestListner implements ITestListener {

	private static Logger log = LogManager.getLogger(TestBaseClass_SignUp_Login.class.getName());

	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);
		log.info("Test case start");

	}

	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);
		log.info("Test case suceed");

	}

	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		log.error("Test case Faild");

	}

	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
		log.info("Test case skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		log.info("Test case failed within success percentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
		log.info("Test case failed with timeout");

	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
		log.info("Before alll the Test case ");
	}

	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
		log.info("After all the Test case ");
	}

}
