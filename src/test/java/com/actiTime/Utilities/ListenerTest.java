package com.actiTime.Utilities;

import java.io.IOException;

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
//@Attachment
//	public void onTestFailure(ITestResult result) {
//		log.debug("Failure to load " + result.getMethod());
//		try {
//			takeScreebshot(result.getMethod().getMethodName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		log.debug("***** Error" + result.getTestName().toString() + "********test  failed *******");
//
//	}

	public void onTestSkipped(ITestResult result) {

		log.info("Skipped testcase :"+result.SKIP);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		log.info("Percentage of success :"+result.SUCCESS_PERCENTAGE_FAILURE);

	}

	public void onStart(ITestContext context) {
	
		log.info("On start of test"+context.getAllTestMethods());

	}

	public void onFinish(ITestContext context) {

		log.info("Tests are on finish :"+context.getOutputDirectory());

	}

	//@Override
	public void onTestFailure(ITestResult result) {
		
		log.info("Failure tests are :"+result.FAILURE);
		log.debug("Failure to load :" + result.getMethod());
		// System.out.println("***** Error "+result.getName()+" test has failed *****");
		try {
			takeScreebshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);
		}
		log.debug("***** Error" + "********test  failed *******");

}
}
