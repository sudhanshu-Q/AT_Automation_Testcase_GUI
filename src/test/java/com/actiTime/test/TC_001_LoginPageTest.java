package com.actiTime.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;
import com.actiTime.pageObjects.LoginPage;

public class TC_001_LoginPageTest extends Baseclass
{
	final static Logger log=Logger.getLogger(TC_001_LoginPageTest.class);
	ReadDataConfiguration readLogin=new ReadDataConfiguration();
	@Test()
	public void loginTest()
	{
		log.debug("Login Test execution: "+driver.getClass());
		LoginPage initLogin=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		String TitlePrelogin=driver.getTitle();
		log.info("Title of page :"+TitlePrelogin);

		SoftAssert titleVerify=new SoftAssert();
		titleVerify.assertEquals(TitlePrelogin,"actiTIME - Login");

		log.debug("Enter the username");
		log.info(readconfig.getUsername().toString());
		initLogin.setUserName();
		log.info("Enter the password ");
		initLogin.setPassword();
		log.debug("Click on SignIn Button");
		initLogin.clickSignInBTN();
		log.info("Clicked on SignIn Button "+driver.getTitle());
		log.info("wait load");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		String preLogTitle=readconfig.preLoginTitle();
		log.debug("Tilte of page :"+preLogTitle);
		String postLogTitle=readconfig.postLoginTitle();
		log.debug("Title of page :"+postLogTitle);
		
try {
	Thread.sleep(8000);
	log.info("getting current title");
	String curTitle=driver.getTitle();
	log.debug("current title :"+driver.getTitle());

	if (curTitle.equals(postLogTitle))
	{
		SoftAssert postloginTitle1=new SoftAssert();
		postloginTitle1.assertEquals(curTitle, postLogTitle, "Post login Title verified :"+driver.getTitle());
		log.info(driver.getCurrentUrl()+"***Logged in state***");
		postloginTitle1.assertAll();
	}
	else
	{
		String curTitle2=driver.getTitle();
		System.out.println(curTitle2);
		SoftAssert preloginTitle2=new SoftAssert();
		preloginTitle2.assertEquals(curTitle, preLogTitle, "Title not verified :"+driver.getTitle());
		log.error("Login Failure :"+driver.getTitle()+" :Password is wrong");
		preloginTitle2.assertAll();
}
}
catch (InterruptedException e)
{
	log.error(e.getMessage());
	e.printStackTrace();
}
		titleVerify.assertAll();
		log.info("Login test completed :"+driver.getTitle());

	}
}
