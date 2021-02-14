package com.actiTime.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.actiTime.Utilities.TestUtil;
import com.actiTime.pageObjects.CreateNewTask;
import com.actiTime.pageObjects.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TC_002_CreateNewTask extends Baseclass {
	final static Logger logger = Logger.getLogger(TC_002_CreateNewTask.class);

	@Test()
	@Description("Create new Task test")
	@Epic("AT:002")
	@Feature("Feature: Create new Task functionality")
	@Story("Create new Task:002")
	@Step("Verify Create New Task test")
	@Severity(SeverityLevel.CRITICAL)
	public void createNewTask() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		logger.debug("Access url :" + driver.getCurrentUrl());
		lp.setUserName();
		logger.debug("Set user name :" + driver.getTitle());
		lp.setPassword();
		logger.debug("Set password :" + driver.getTitle());
		lp.clickSignInBTN();
		logger.info("user is signing in :" + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// Create new customer

		CreateNewTask createTask = new CreateNewTask(driver);
		logger.debug("new window open :" + driver.getTitle());
		logger.debug("Accessed url :" + driver.getCurrentUrl());
		createTask.clickCreateNewTaskLink();
		logger.debug("Action to create new task link :" + driver.getTitle());
		// Filling create new customer form
		createTask.selectCreateNewTaskDropDown();
		logger.debug("Select create new task." + driver.getTitle());
		createTask.customerNameEnter();
		logger.debug("Customer name ");
		createTask.projectNameEnter();
		logger.debug("enter project name");
		createTask.taskNameEnter();
		logger.debug("enter task name");
		createTask.taskButtonClick();
		logger.debug("Task button action performed");
		logger.info("New task created successfully");
	}
}
