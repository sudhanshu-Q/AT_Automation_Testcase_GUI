package com.actiTime.Utilities;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.actiTime.test.Baseclass;

public class ListenerTest extends Baseclass implements ITestListener {

	public static Logger log = Logger.getLogger(ListenerTest.class);

	public void onTestStart(ITestResult result) {
		log.debug("Test started :" + result.getInstanceName().toString());
		log.info("Calling Listener Test class");

	}

	public void onTestSuccess(ITestResult result) {
		log.debug("On test success :" + result.getTestName());
		log.info("Test success");
	}

	public void onTestFailure(ITestResult result) {
		log.debug("Failure to load " + result.getMethod());
		// System.out.println("***** Error "+result.getName()+" test has failed *****");
		takeScreebshot(result.getMethod().getMethodName());
		log.debug("***** Error" + result.getTestName().toString() + "********test  failed *******");
		// // ITestContext context = result.getTestContext();
		// //WebDriver driver = (WebDriver)context.getAttribute("driver");
		// try {
		// takeScreenShot(driver);
		// }
		// catch (IOException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		//
		// // public void takeScreenShot(String methodName, WebDriver driver) throws
		// IOException
		// // {
		// // System.out.println("Taking Screenshot");
		// // TakesScreenshot screenshottingDriver = (TakesScreenshot)driver;
		// // File scrFile = screenshottingDriver.getScreenshotAs(OutputType.FILE);
		// // //The below method will save the screen shot in d drive with test method
		// name
		// // FileUtils.copyFile(scrFile, new File("./Screenshots/"+methodName+".png"));
		// // System.out.println("***Placed screen shot in "+filePath+" ***");
		//
		// // Along with driver pass element also in takeScreenshot() method.
		// //Screenshot screenshot = new AShot().takeScreenshot(driver);
		// public void takeScreenShot(WebDriver driver) throws IOException
		// {
		//
		// Screenshot screenshot = new
		// AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		// ImageIO.write(screenshot.getImage(), "jpg", new File("./Drivers/"));

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
