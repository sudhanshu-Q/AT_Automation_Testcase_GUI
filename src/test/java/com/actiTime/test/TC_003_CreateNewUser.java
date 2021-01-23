package com.actiTime.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;
import com.actiTime.pageObjects.CreateNewUser;
import com.actiTime.pageObjects.LoginPage;

public class TC_003_CreateNewUser extends Baseclass {

	public static Logger log=Logger.getLogger(TC_003_CreateNewUser.class);
	ReadDataConfiguration read=new ReadDataConfiguration();


	@Test
	public void createUserTest() {
		LoginPage lp = new LoginPage(driver);
		log.debug("Access url :" + driver.getCurrentUrl());
		lp.setUserName();
		log.debug("Set user name :" + driver.getTitle());
		lp.setPassword();
		log.debug("Set password :" + driver.getTitle());
		lp.clickSignInBTN();
		log.info("user is signing in :" + driver.getTitle());
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Create new user
		CreateNewUser newUser=new CreateNewUser(driver);
		log.debug("Create user initiate :"+driver.getTitle());
		newUser.clicknewUserLNK();
		log.debug("Clicked on new user link :"+driver.getTitle());
		newUser.clickOnNewUserBTN();
		log.debug("Clicked on new user button :"+driver.getTitle());
		newUser.enterUserName();
		log.debug("User name entered successfully :"+driver.getTitle());
		newUser.enterPassword();
		log.debug("password entered..");
		newUser.enterpasswordRetype();
		log.debug("Retype password.. ");
		newUser.enterFirstName();
		log.debug("Enter first name initiate..");
		newUser.enterLastname();
		log.debug("Last name entered ..");
		newUser.enterEmailAdress();
		newUser.enterFax();
		log.debug("Fax entered ..");
		newUser.clickSubmitBtnCreateNewUser();
		log.debug("Submit the create new user form :"+driver.getTitle());
	}

}
