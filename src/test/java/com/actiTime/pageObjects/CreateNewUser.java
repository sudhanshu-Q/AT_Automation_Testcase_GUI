package com.actiTime.pageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.ReadCreateNewUserData;
import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;

public class CreateNewUser {

	final static Logger log = Logger.getLogger(CreateNewTask.class);

	ReadDataConfiguration read = new ReadDataConfiguration();
	ReadCreateNewUserData readUser = new ReadCreateNewUserData();

	public WebDriver driver;

	public CreateNewUser(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='/administration/userlist.do']")
	@CacheLookup
	WebElement createNewUserLink;

	@FindBy(xpath = "//input[@type='button' and @value='Create New User']")
	@CacheLookup
	WebElement createNewUserButton;

	@FindBy(xpath = "//input[@type='text' and @name='username']")
	@CacheLookup
	WebElement enterNewUserNameTB;

	@FindBy(xpath = "//input[@type='password' and @name='passwordText']")
	@CacheLookup
	WebElement enterPasswordTB;

	@FindBy(xpath = "//input[@type='password' and @name='passwordTextRetype']")
	@CacheLookup
	WebElement enterRetypePasswordTB;

	@FindBy(xpath = "//input[@type='text' and @name='firstName']")
	@CacheLookup
	WebElement enterFirstNameTB;

	@FindBy(xpath = "//input[@type='text' and @name='lastName']")
	@CacheLookup
	WebElement enterLastNameTB;

	@FindBy(xpath = "//input[@type='text' and @name='phone']")
	@CacheLookup
	WebElement enterPhoneNumberTB;

	@FindBy(xpath = "//input[@type='text' and @name='fax']")
	@CacheLookup
	WebElement enterFaxTB;

	@FindBy(xpath = "//input[@type='text' and @name='mobile']")
	@CacheLookup
	WebElement enterMobileTB;

	@FindBy(xpath = "//input[@type='text' and @name='middleName']")
	@CacheLookup
	WebElement enterMiddleInitialTB;

	@FindBy(xpath = "//input[@type='text' and @name='email']")
	@CacheLookup
	WebElement enterEmailAddressTB;

	@FindBy(xpath = "//input[@type='text' and @name='otherContact']")
	@CacheLookup
	WebElement enterOtherContactTB;

	@FindBy(xpath = "//input[@type='submit' and @value='   Create User   ']")
	@CacheLookup
	WebElement clickCreateNewUserButtonSubmit;

	public void clicknewUserLNK() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		log.info("Click create new User Link :" + driver.getTitle());
		createNewUserLink.click();
		log.debug("Performed action create new task :" + driver.getCurrentUrl());
	}

	public void clickOnNewUserBTN() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		log.info("Click create new User button :" + createNewUserButton.isDisplayed());
		createNewUserButton.click();
	}

	public void enterUserName() {
		log.debug("Enter the user Name :" + driver.getTitle());
		enterNewUserNameTB.click();
		log.debug("Please enter the user :" + enterNewUserNameTB.getText());
		String userNameGenerate = readUser.generateRandomNewUserName();
		enterNewUserNameTB.sendKeys(userNameGenerate);
		log.info("generated user name : " + userNameGenerate);
	}

	public void enterPassword() {
		log.debug("Enter the password for create a user :" + enterPasswordTB.isDisplayed());
		enterPasswordTB.click();
		enterPasswordTB.sendKeys(readUser.getpassword());
		log.info("password entered successfullt :" + driver.getTitle());

	}

	public void enterpasswordRetype() {
		log.debug("Retype password : " + enterRetypePasswordTB.isDisplayed());
		enterRetypePasswordTB.click();
		enterRetypePasswordTB.sendKeys(readUser.getpassword());
		log.info("password entered : " + readUser.getpassword().length());
	}

	public void enterFirstName() {
		log.debug("Enter first name :" + readUser.firstName().toUpperCase());
		enterFirstNameTB.click();
		enterFirstNameTB.sendKeys(readUser.firstName());
		log.info("First name entered successfully :" + "Tota charcters :" + readUser.firstName().length());
	}

	public void enterLastname() {
		log.debug("Enter Last name : " + readUser.getlastnameUser().toUpperCase());
		enterLastNameTB.click();
		enterLastNameTB.sendKeys(readUser.getlastnameUser());
		log.info("Last name entered successfully : " + "Total characters :" + readUser.getlastnameUser().length());
	}

	public void enterEmailAdress() {
		log.debug("Enter email id : " + readUser.getEmailAddress().toString());
		enterEmailAddressTB.click();
		enterEmailAddressTB.sendKeys(readUser.getEmailAddress());
		log.info("Email id :" + readUser.getEmailAddress().length());
	}

	public void enterFax() {
		log.debug("Enter the Fax :" + readUser.getfax().toString());
		enterFaxTB.click();
		enterFaxTB.sendKeys(readUser.getfax());
		log.info("Fax enter successfully :" + enterFaxTB.isDisplayed());
	}

	public void clickSubmitBtnCreateNewUser() {
		log.debug("Click on Create new user submit button :" + clickCreateNewUserButtonSubmit.isDisplayed());
		clickCreateNewUserButtonSubmit.click();
		log.info("Submitting the form :" + driver.getTitle());
	}

}
