package com.actiTime.pageObjects;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.actiTime.Utilities.ReadDataConfiguration;
import com.actiTime.Utilities.TestUtil;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class GetAllOpenTask<WebElements> {

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

	@FindBy(xpath="//form[@id='tasksListForm']")
	@CacheLookup
	WebElement navigateToFormTable;

	@FindBy(xpath="//a[@class='listtblcolheader'][@href='javascript:sortList(1);']")
	@CacheLookup
	WebElement customerColumnData;

	////*[@class='listtblcell'][@id='taskNameCell48']

	//	@FindBy(xpath="//*[@class='listtblcell'][@id='taskNameCell48']")
	//	@CacheLookup
	//	WebElement customerDataList;

	@FindBy(xpath="//th[@class='listtblcolheader']")
	@CacheLookup
	WebElement tableHeader;


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

	public void readTableHeader()
	{
		
		FileOutputStream out = null;
		HSSFWorkbook workbook=new HSSFWorkbook();
		try {
			out = new FileOutputStream("D:\\AT_channel\\ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\Test.xls");
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			log.error("ERROR :"+e2);
		}
		java.util.List<WebElement> headercount=driver.findElements(By.xpath("//th[@class='listtblcolheader']"));
		int i=headercount.size();
		log.debug("Table Headers :"+i);
		String customerColumn=driver.findElement(By.xpath("//a[@class='listtblcolheader' and @href='javascript:sortList(1);']")).getText();
		String projectColumn=driver.findElement(By.xpath("//a[@class='listtblcolheader' and @href='javascript:sortList(3);']")).getText();
		String taskColumn=driver.findElement(By.xpath("//a[@class='listtblcolheader' and @href='javascript:sortList(2);']")).getText();
		String deadlineColumn=driver.findElement(By.xpath("//a[@class='listtblcolheader' and @href='javascript:sortList(7);']")).getText();
		String taskTrackingColumn=driver.findElement(By.xpath("//a[@class='listtblcolheader' and @href='javascript:sortList(4);']")).getText();
		String spentTimeColumn=driver.findElement(By.xpath("//th[contains(text(),'Spent')]")).getText();
		WebElement elementsAll=driver.findElement(By.xpath("//td[@class='listtblcell']/self::td[@class='listtblcell']"));
		java.util.List<WebElement> countAll=elementsAll.findElements(By.xpath("//td[@class='listtblcell']/self::td[@class='listtblcell']"));
		log.debug("ROW size :"+countAll.size());
		for (WebElement elemet:countAll)
		{
			int j=countAll.size();
			if (j/6==0)
				log.info("Cutomer name is :"+countAll.indexOf(countAll));

		}
		log.debug("ROWS :"+countAll.toString());

		for(int j=1;j<=i;j++)
		{
			if(j==1)
			{
				try {
					out = new FileOutputStream("D:\\AT_channel\\ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\Test.xls");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					log.error("ERROR :"+j+e2);
				}
				log.info("Table header :"+j+":"+customerColumn);
				HSSFSheet sheet=workbook.createSheet(customerColumn);
				String sheetName=sheet.getSheetName();
				log.debug("Created Sheet :"+sheetName);
				HSSFRow createRow=sheet.createRow(j);
				log.debug("Creating sheet name:"+sheetName);
				createRow.createCell(0).setCellValue(elementsAll.getText());
				log.debug("Creating rows for "+elementsAll.toString());
				HSSFRow createRowCustomerHeader=sheet.createRow(0);
				createRowCustomerHeader.createCell(0).setCellValue(customerColumn.toString());
				log.debug("Customer header created in excel :"+customerColumn.toString());
				//creating a row object
				try {
					workbook.write(out);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					log.error("ERROR:"+e1);
				}

				try {
					workbook.write(out);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("ERRRO " +e);
				}

			}
			if(j==2) {
				try {
					out = new FileOutputStream("D:\\AT_channel\\ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\Test.xls");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					log.error("ERROR :"+j+e2);
				}
				log.info("Table header :"+j+":"+projectColumn);
				HSSFSheet sheet=workbook.createSheet(projectColumn);
				String sheetName=sheet.getSheetName();
				log.info("Sheet Name :"+sheetName);
				log.debug("Created Sheet :"+sheetName);
				HSSFRow createRow=sheet.createRow(j);
				log.debug("Creating sheet name:"+projectColumn);
				createRow.createCell(0).setCellValue(elementsAll.getText());
				log.debug("Creating rows for "+elementsAll.toString());
				HSSFRow createRowCustomerHeader=sheet.createRow(0);
				createRowCustomerHeader.createCell(0).setCellValue(projectColumn.toString());
				log.debug("Project header created in excel :"+projectColumn.toString());
				try {
					workbook.write(out);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("ERROR while creating Project name sheet :"+e);
				}
			}

			if(j==3) {
				try {
					out = new FileOutputStream("D:\\AT_channel\\ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\Test.xls");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					log.error("ERROR :"+j+e2);
				}
				log.info("Table header :"+j+":"+taskColumn);;
				HSSFSheet sheet=workbook.createSheet(taskColumn);
				String sheetName=sheet.getSheetName();
				log.info("Sheet Name :"+sheetName);
				log.debug("Created Sheet :"+sheetName);
				HSSFRow createRow=sheet.createRow(j);
				log.debug("Creating sheet name:"+taskColumn);
				createRow.createCell(0).setCellValue(elementsAll.getText());
				log.debug("Creating rows for "+elementsAll.toString());
				HSSFRow createRowCustomerHeader=sheet.createRow(0);
				createRowCustomerHeader.createCell(0).setCellValue(taskColumn.toString());
				log.debug("Project header created in excel :"+taskColumn.toString());
				try {
					workbook.write(out);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("ERROR while creating Task name :"+taskColumn);
				}
			}
				
			if(j==4)
			{
				try {
					out = new FileOutputStream("D:\\AT_channel\\ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\Test.xls");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					log.error("ERROR :"+j+e2);
				}
				log.info("Table header :"+j+":"+deadlineColumn);
				log.info("Table header :"+j+":"+deadlineColumn);;
				HSSFSheet sheet=workbook.createSheet(deadlineColumn);
				String sheetName=sheet.getSheetName();
				log.info("Sheet Name :"+sheetName);
				log.debug("Created Sheet :"+sheetName);
				HSSFRow createRow=sheet.createRow(j);
				log.debug("Creating sheet name:"+deadlineColumn);
				createRow.createCell(0).setCellValue(elementsAll.getText());
				log.debug("Creating rows for "+elementsAll.toString());
				HSSFRow createRowCustomerHeader=sheet.createRow(0);
				createRowCustomerHeader.createCell(0).setCellValue(deadlineColumn.toString());
				log.debug("Project header created in excel :"+deadlineColumn.toString());
				try {
					workbook.write(out);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("ERROR while creating Task name :"+deadlineColumn);
				}
			}
				
			if(j==5)
			{
				try {
					out = new FileOutputStream("D:\\AT_channel\\ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\Test.xls");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					log.error("ERROR :"+j+e2);
				}
				log.info("Table header :"+j+":"+taskTrackingColumn.trim());
				log.info("Table header :"+j+":"+taskTrackingColumn);
				HSSFSheet sheet=workbook.createSheet(taskTrackingColumn);
				String sheetName=sheet.getSheetName();
				log.info("Sheet Name :"+sheetName);
				log.debug("Created Sheet :"+sheetName);
				HSSFRow createRow=sheet.createRow(j);
				log.debug("Creating sheet name:"+taskTrackingColumn);
				createRow.createCell(0).setCellValue(elementsAll.getText());
				log.debug("Creating rows for "+elementsAll.toString());
				HSSFRow createRowCustomerHeader=sheet.createRow(0);
				createRowCustomerHeader.createCell(0).setCellValue(taskTrackingColumn.toString());
				log.debug("Project header created in excel :"+taskTrackingColumn.toString());
				try {
					workbook.write(out);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("ERROR while creating Task name :"+taskTrackingColumn);
				}
			}
				
			if(j==6)
			{
				try {
					out = new FileOutputStream("D:\\AT_channel\\ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\Test.xls");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					log.error("ERROR :"+j+e2);
				}
				log.info("Table header :"+j+":"+spentTimeColumn);
				log.info("Table header :"+j+":"+spentTimeColumn.trim());
				HSSFSheet sheet=workbook.createSheet(spentTimeColumn);
				String sheetName=sheet.getSheetName();
				log.info("Sheet Name :"+sheetName);
				log.debug("Created Sheet :"+sheetName);
				HSSFRow createRow=sheet.createRow(j);
				log.debug("Creating sheet name:"+spentTimeColumn);
				createRow.createCell(0).setCellValue(elementsAll.getText());
				log.debug("Creating rows for "+elementsAll.toString());
				HSSFRow createRowCustomerHeader=sheet.createRow(0);
				createRowCustomerHeader.createCell(0).setCellValue(spentTimeColumn.toString());
				log.debug("Project header created in excel :"+spentTimeColumn.toString());
				try {
					workbook.write(out);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("ERROR while creating Task name :"+spentTimeColumn);
				}
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					log.error("ERROR :" +e);
				}
				
			}
		
		}
	
	}
}

