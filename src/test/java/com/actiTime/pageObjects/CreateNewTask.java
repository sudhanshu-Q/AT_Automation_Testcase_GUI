package com.actiTime.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.test.Baseclass;

public class CreateNewTask {
	final static Logger log = Logger.getLogger(CreateNewTask.class);
	ReadDataConfiguration read = new ReadDataConfiguration();
	public WebDriver driver;

	public CreateNewTask(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Elements of create new task page
	@FindBy(xpath = "//*[@href='javascript: openAddNewTasksPopup();'][text()='Create new tasks']")
	@CacheLookup
	WebElement createNewTaskLink;

	@FindBy(xpath = "//*[@name='customerId']")
	@CacheLookup
	WebElement createnewTaskDropdown;

	@FindBy(xpath = "//*[@name='customerName']")
	@CacheLookup
	WebElement enterCustomerName;

	@FindBy(xpath = "//*[@name='projectName']")
	@CacheLookup
	WebElement enterProjectName;

	@FindBy(xpath = "//*[@name='task[0].name']")
	@CacheLookup
	WebElement enterTaskName;

	@FindBy(xpath = "//*[@type='button' and @value='Create Tasks']")
	@CacheLookup
	WebElement clickCreateTaskButton;

	public void clickCreateNewTaskLink() {
		log.info("Click create new task :" + driver.getTitle());
		createNewTaskLink.click();
		log.debug("Performed action create new task :" + driver.getCurrentUrl());
	}

	public void selectCreateNewTaskDropDown() {
		log.info("New task dropdown :" + driver.getTitle());
		// It will return the parent window name as a String
		String parent = driver.getWindowHandle();
		log.debug("window handling :" + driver.getCurrentUrl());
		log.debug("current title :" + driver.getTitle());
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				driver.getTitle();
				// clicking on dropdown
				// createnewTaskDropdown.click();
				log.debug("selecting new customer in dropdown");
				Select createDropDown = new Select(createnewTaskDropdown);
				log.info("customer selected successfully :" + createDropDown.getOptions());
				createDropDown.selectByIndex(1);
			
			}
			// }
			// //switch to the parent window
			// driver.switchTo().window(parent);
			// createnewTaskDropdown.click();
			// driver.getTitle();
		}

	}

	public void customerNameEnter() {
		Baseclass b = new Baseclass();
		log.info("Customer name :");
		String customerNamegenerated = b.generateRandomCustomerName();
		log.warn("Generating random cutomer name" + driver.getClass());
		enterCustomerName.sendKeys(customerNamegenerated);
		log.debug("Entered customer name :" + driver.getTitle());
		log.debug("random generated customer name :" + customerNamegenerated);
	}

	public void projectNameEnter() {
		log.debug("enter the project name :" + read.getProjectName());
		enterProjectName.sendKeys(read.getProjectName());
		log.info("project name entered :" + driver.getTitle());
	}

	public void taskNameEnter() {
		log.debug("Task name entered :" + read.getTaskName());
		enterTaskName.sendKeys(read.getTaskName());
		log.info("task name created successfully");
	}

	public void taskButtonClick() {
		clickCreateTaskButton.click();
		log.info("clicked on task button");
	}

}
