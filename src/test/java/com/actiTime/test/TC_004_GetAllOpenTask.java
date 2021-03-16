package com.actiTime.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;
import com.actiTime.pageObjects.GetAllOpenTask;
import com.actiTime.pageObjects.LoginPage;
import com.google.j2objc.annotations.Property;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TC_004_GetAllOpenTask extends Baseclass {

	public static Logger log = Logger.getLogger(TC_004_GetAllOpenTask.class);
	ReadDataConfiguration read = new ReadDataConfiguration();
	

	@Test
	@Description("Get list oof all open Task")
	@Epic("AT:004")
	@Feature("Feature: Task ")
	@Story("Get all task list:004")
	@Step("To display all task created")
	@Severity(SeverityLevel.MINOR)
	public void getAllTaskCreated() {
		LoginPage lp = new LoginPage(driver);
		log.debug("Access url :" + driver.getCurrentUrl());
		lp.setUserName();
		log.debug("Set user name :" + driver.getTitle());
		lp.setPassword();
		log.debug("Set password :" + driver.getTitle());
		lp.clickSignInBTN();
		log.info("user is signing in :" + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Get all Task
		GetAllOpenTask gettask = new GetAllOpenTask(driver);
		log.debug("Accessing open task link");
		gettask.clickOnOpenTaskBtn();
		log.debug("Clicked on open task button");
		gettask.enterTaskNameInFilter();
		log.debug("Enter the task name");
		gettask.clickFilterTaskBTN();
		log.debug("Filetring the task");
//	log.info(gettask.taskListWebTable().toString());
//	log.info("getting xpath for table column");
//	log.info(gettask.setstringToXpath());
//	log.info("taking xpath");

		
		//Need to complete Web table
	}
}
