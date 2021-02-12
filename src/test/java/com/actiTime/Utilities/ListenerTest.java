package com.actiTime.Utilities;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.actiTime.test.Baseclass;

import io.qameta.allure.Attachment;

public class ListenerTest extends Baseclass implements ITestListener {

	public static Logger log = Logger.getLogger(ListenerTest.class);

	public void onTestStart(ITestResult result) {
		log.debug("Test started :" + result.getInstanceName().toString());
		log.info("Calling Listener Test class");

	}

	public void onTestSuccess(ITestResult result) {
		log.debug("On test success :" + result.getMethod().getMethodName());
		log.info("Test success");
	}
@Attachment
	public void onTestFailure(ITestResult result) {
		log.debug("Failure to load " + result.getMethod());
		takeScreebshot(result.getMethod().getMethodName());
		log.debug("***** Error" + result.getTestName().toString() + "********test  failed *******");

	}

	public void onTestSkipped(ITestResult result) {

		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
