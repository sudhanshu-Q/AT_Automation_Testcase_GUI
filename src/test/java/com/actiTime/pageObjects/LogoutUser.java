package com.actiTime.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LogoutUser {

	final static Logger log = Logger.getLogger(LogoutUser.class);
	static WebDriver driver;

	public LogoutUser(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='logout']")
	@CacheLookup
	WebElement logoutBTN;

	public void clickLogoutBTN() {

		log.debug("Click on Logout button");
		String beforeClickLogoutBtnTitle = driver.getTitle();
		logoutBTN.click();
		log.debug("Clicked on logout button");
		String afterClickLogoutBtnTitle = driver.getTitle();
		log.debug("capturing logout title");
		log.info(driver.getTitle());
	}

}
