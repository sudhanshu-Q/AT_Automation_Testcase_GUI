package com.actiTime.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.ReadDataConfiguration;

public class CreateNewUser {
	final static Logger log = Logger.getLogger(CreateNewTask.class);
	ReadDataConfiguration read = new ReadDataConfiguration();
	public WebDriver driver;

	public CreateNewUser(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
}
