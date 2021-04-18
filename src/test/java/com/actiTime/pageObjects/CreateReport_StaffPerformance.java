package com.actiTime.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateReport_StaffPerformance {

	final static Logger log=Logger.getLogger(CreateReport_StaffPerformance.class);

	public WebDriver driver;
	public CreateReport_StaffPerformance(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath= "//a[@href='/reports/reports.do']")
	@CacheLookup
	WebElement createReportBtn;

	@FindBy(xpath= "//*[@id='ext-gen15']")
	@CacheLookup
	WebElement selectDropdownStaffPerf;

	@FindBy (xpath ="//a[@class='x-menu-item' and  @id='ext-gen34']")
	@CacheLookup
	WebElement selectStaffPerformance;


	public void clickOnReportIMGHomepage()
	{
		log.debug("Click on report button in homepage : "+createReportBtn.getText());
		createReportBtn.click();
	}
	public void selectStaffPerformanceDropDown()
	{
		log.debug("click on dropdown in create report");
		selectDropdownStaffPerf.click();
		log.debug("select staff performance ");
		selectStaffPerformance.click();
		log.debug("Staff performance selected");
	}


}
