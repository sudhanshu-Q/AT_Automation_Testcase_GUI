package com.actiTime.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;
import com.actiTime.pageObjects.CreateReport_StaffPerformance;
import com.actiTime.pageObjects.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class TC_005_CreateReport_StaffPerformance extends Baseclass{

	public static Logger log = Logger.getLogger(TC_005_CreateReport_StaffPerformance .class);
	ReadDataConfiguration read = new ReadDataConfiguration();
	
	@Test
	@Description("Create Report for Staff preformance")
	@Epic("AT:005")
	@Feature("Feature: Create Report ")
	@Story("Create Report for staff performance : 005")
	@Step("TO create report for staff performance")
	
	public void createReport_Staff_performance() {
		
		TC_001_LoginPageTest loginTestUser=new TC_001_LoginPageTest();
		loginTestUser.loginTest();

		//Create REPORT for STAFF Performance
		
		log.debug("lOGIN TEST SUCCESSFUL");
		CreateReport_StaffPerformance cReportStaff=new CreateReport_StaffPerformance(driver);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		log.debug("Driver controls passed to current url :"+driver.getCurrentUrl());
		cReportStaff.clickOnReportIMGHomepage();
		log.info("User clicked on Report: "+driver.manage().getCookies());
		cReportStaff.selectStaffPerformanceDropDown();
		log.debug("Selected staff performance ");
	}
}
