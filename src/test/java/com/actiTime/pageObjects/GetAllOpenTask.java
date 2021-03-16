package com.actiTime.pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class GetAllOpenTask {

	final static Logger log = Logger.getLogger(GetAllOpenTask.class);
	private static final String elementXpath = null;
	ReadDataConfiguration read = new ReadDataConfiguration();
	public WebDriver driver;

	public GetAllOpenTask(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@class='content tasks']")
	@CacheLookup
	WebElement openTaskHeaderBTN;

	@FindBy(xpath = "//input[@class='controlBorder']")
	@CacheLookup
	WebElement enterTaskNameByFilter;

	@FindBy(xpath = "//input[@id='tasksFilterSubmitButton']")
	@CacheLookup
	WebElement clickOnFilterTaskBTN;

	@FindBy(xpath = "//a[@class='listtblcolheader' and text()='Task']")
	@CacheLookup
	WebElement getTaskListTableColumn;


	public void clickOnOpenTaskBtn() {
		log.debug("Click on Open task");
		openTaskHeaderBTN.click();
		log.debug("User clicked on open task");
	}

	public void enterTaskNameInFilter() {
		log.debug("Entering the Task name :" + read.getTaskName());
		enterTaskNameByFilter.sendKeys(read.getTaskName());
		log.debug(enterTaskNameByFilter.getText() + "Entered task name");
	}

	public void clickFilterTaskBTN() {
		log.debug(clickOnFilterTaskBTN.getText() + "Action filter");
		clickOnFilterTaskBTN.click();
		log.debug("Clicked on Filter task button");
	}

	public String taskListWebTable() {

		// //*[@id='taskNameCell42' and @class='listtblcell']

		String beforeXpath = "//*[@id='taskNameCell";
		log.debug("Before Xpath :" + beforeXpath);

		String afterXapth = " and @class='listtblcell']";
		log.debug("After Xapth :" + afterXapth);

		for (int i = 0; i <= 100; i++) {
			int numberTaskXpath = i;
			String taskRelativeXpath = beforeXpath + numberTaskXpath + afterXapth;
			log.info("Task realtive Xpath :" + taskRelativeXpath);
		}
		String taskRelativeXpath = null;
		String taskRelativeXpath1 = taskRelativeXpath;
		log.debug("loop discontinued...");
		return taskRelativeXpath1;
	}

//	public WebElement setstringToXpath() {
//		WebElement taskListWebTable = null;
//		WebElement elementXpath = taskListWebTable;
//		log.debug("Web Element Task :"+GetAllOpenTask.elementXpath);
//		return elementXpath;
	}

//	@FindBy(xpath = )
//	@CacheLookup
//	WebElement taskDataFromTable;

//	public void fetchTaskColumn() {
//		String taskcreated = taskDataFromTable.getText();
//		log.debug("TASK :" + taskcreated);
//	}
