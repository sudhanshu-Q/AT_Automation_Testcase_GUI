package com.actiTime.test;

import java.io.File;
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

	static WebDriver driver;
	ReadDataConfiguration readconfig = new ReadDataConfiguration();

	// public WebDriver;
	// @Parameters("browser")
	@BeforeClass
	// Accessing different browser
	// public void setUp(String br)
	public void setUp() {
		// if (br.equals("Chrome"))
		// {
		// ChromeDriver driver;
		//WebDriverManager.chromedriver().setup();
//		
		ChromeOptions chromeOptions= new ChromeOptions();
	chromeOptions.setBinary("C:\\Users\\Shudhanshu\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("Webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		//  "./Drivers/chromedriver.exe"
		driver = new ChromeDriver(chromeOptions);
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
		// }
		// else if(br.equals("Firefox"))
		// {
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver=new FirefoxDriver();
		// System.out.println("get url");
		// System.out.println(readconfig.getUrl());
		// driver.get(readconfig.getUrl());
		// System.out.println(readconfig.getUrl());
		// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		// }
	}

	public void takeScreebshot(String testName) {
		log.info("Taking Screenshot");
		try {
			log.debug("Taking screenshot " + driver.getTitle());

			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			log.debug("preparing Screenshot for :" + testName.toString());
			File destFile = new File("./Screenshots/testfail" + testName + ".png");
			FileUtils.copyFile(file, destFile);
			log.debug("Screenshot taken :" + testName.toString());
			log.info("File source for screenshot captured: " + destFile.getName());

			// System.out.println("Driver taking screenshot");
			// File source = screenshots.;
			// System.out.println(source);
			// System.out.println("Taking screenshot for failed Test case");
			// // String filePath="D:\\GitLocalRepo\\ActiTime_Automation\\Screenshots\\";
			// String filePath = "./Screenshots/testfail:";
			// System.out.println("Screenhots taken");
			// new File(filePath);
			// System.out.println("Test case faile in: " + testName);
			// FileUtils.copyFile(source, new File("./Screenshots/testfail:" + testName +
			// ".png"));
			// System.out.println("Screenshots moved to screenshot folder");

		} catch (Exception e) {
			log.error("Screenshot not taken :" + e.getMessage());
		}

	}

	@AfterClass
	public void shutDown() {
		log.debug("Execution completed :");
		driver.quit();
		log.info("Quit browser :" + driver.getClass());

	}

	public String generateRandomCustomerName() {
		log.debug("Random string generated :" + Baseclass.class);
		String cusName = RandomStringUtils.randomAlphabetic(15);
		log.info("Generated alphabet ");
		return cusName;
	}

}
