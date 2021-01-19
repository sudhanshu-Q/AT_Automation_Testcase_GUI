package com.actiTime.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.actiTime.Utilities.TestUtil;
import com.actiTime.pageObjects.CreateNewTask;
import com.actiTime.pageObjects.LoginPage;

public class TC_002_CreateNewTask extends Baseclass
{
	final static Logger logger=Logger.getLogger(TC_002_CreateNewTask.class);
	@Test()
	public void createNewTask() throws InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		logger.debug("Access url :"+driver.getCurrentUrl());
		lp.setUserName();
		logger.debug("Set user name :"+driver.getTitle());
		lp.setPassword();
		logger.debug("Set password :"+driver.getTitle());
		lp.clickSignInBTN();
		logger.info("user is signing in :"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Create new customer
		
		CreateNewTask createTask=new CreateNewTask(driver);
		logger.debug("new window open :"+driver.getTitle());
		logger.debug("Accessed url :"+driver.getCurrentUrl());
		createTask.clickCreateNewTaskLink();
		logger.debug("action to create new task lin :"+driver.getTitle());
		//Filling create new customer form
		createTask.selectCreateNewTaskDropDown();
		logger.debug("select create new task."+driver.getTitle());
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
