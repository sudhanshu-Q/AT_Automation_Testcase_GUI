package com.actiTime.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass

{
	final static Logger log = Logger.getLogger(Baseclass.class);

	//static WebDriver driver;                                           //without Webdrivermanager
	static WebDriver driver;
	ReadDataConfiguration readconfig = new ReadDataConfiguration();

	@Parameters("browser")                                             //without Webdrivermanager
	@BeforeClass
	public void setUp(String br) {                                     //without Webdrivermanager
		//public void setUp() {                                     
		if (br.equals("Chrome")) {                                     //without Webdrivermanager

			WebDriverManager.chromedriver().setup();
			//	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");//without Webdrivermanager
			driver = new ChromeDriver();                              //without Webdrivermanager
		}
		else if (br.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		// ChromeOptions chromeOptions= new ChromeOptions();
		// chromeOptions.setBinary("C:\\Users\\Shudhanshu\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		// System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		// "./Drivers/chromedriver.exe"
		log.debug("Launching Browser :" + driver.getClass());
		log.info(driver.getClass());
		log.debug(readconfig.getUrl());
		driver.get(readconfig.getUrl());
		driver.manage().window().maximize();
		log.info("Maximizing window size :" + driver.manage().window().getSize());
		log.info("Url accessed :" + driver.getCurrentUrl());
		log.debug("Url accessed");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//} else if (br.equals("Firefox")) {                               //without Webdrivermanager
		//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe"); //without Webdrivermanager

		log.debug("Launching Browser :" + driver.getClass());
		log.info(driver.getClass());
		log.debug(readconfig.getUrl());
		driver.get(readconfig.getUrl());
		driver.manage().window().maximize();
		log.info("Maximizing window size :" + driver.manage().window().getSize());
		log.info("Url accessed :" + driver.getCurrentUrl());
		log.debug("Url accessed");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	//}

	public void takeScreebshot(String testName) throws IOException {
		log.info("Taking Screenshot");
		// try {
		log.debug("Taking screenshot " + driver.getTitle());
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		log.info("File location for capturing screenshots : " + file);
		log.debug("Preparing Screenshot for :" + testName.toString());
		File destFile = new File("./Screenshots/testName" + testName + ".png");
		log.info("Loctiopn of Screenshot captured: " + destFile);
		FileUtils.copyFile(file, destFile);
		log.debug("Screenshot taken :" + testName.toString());
		log.info("File source for screenshot captured: " + destFile.getName());

	}

	@AfterClass
	public void shutDown() {
		log.debug("Execution completed :");
		//driver.close();
		log.info("Quit browser :");

	}

	public String generateRandomCustomerName() {
		log.debug("Random string generated :" + Baseclass.class);
		String cusName = RandomStringUtils.randomAlphabetic(15);
		log.info("Generated alphabet ");
		return cusName;
	}

}
