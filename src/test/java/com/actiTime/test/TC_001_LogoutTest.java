package com.actiTime.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.util.log.Log;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;
import com.actiTime.pageObjects.LoginPage;
import com.actiTime.pageObjects.LogoutUser;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TC_001_LogoutTest extends Baseclass{
	
	final static Logger log=Logger.getLogger(TC_001_LogoutTest.class);
	ReadDataConfiguration readLogin=new ReadDataConfiguration();
	TC_001_LoginPageTest loginTest=new TC_001_LoginPageTest();

	@Test(description="Logout the user")
	@Description("Logout test")
	@Epic("AT:001")
	@Feature("Feature: Logout feature")
	@Story("Logout Test:001")
	@Step("Verify logout test")
	@Severity(SeverityLevel.BLOCKER)
	public void logoutTest()
	{
		loginTest.loginTest();
		log.debug("Login test completed suucessfully");
		LogoutUser logout=new LogoutUser(driver);
		log.debug("initiating driver for logout test");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.debug("IMPLICIT WAIT");
	//	String beforeClickLogoutBtnTitle=driver.getTitle();
		log.info("Logout of user is initiating");
		logout.clickLogoutBTN();
		log.debug("Logout test completed successfully");
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		String afterClickLogoutBtnTitle=driver.getTitle();
//		SoftAssert asserttitle=new SoftAssert();
//		asserttitle.assertEquals(beforeClickLogoutBtnTitle, afterClickLogoutBtnTitle,"User is logged out ");
//		asserttitle.assertAll();
//		log.info(driver.getTitle());
		
	}
	

}
