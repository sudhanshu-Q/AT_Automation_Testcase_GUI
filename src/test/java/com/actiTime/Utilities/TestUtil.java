package com.actiTime.Utilities;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

import com.actiTime.test.Baseclass;


public class TestUtil extends Baseclass
{
//	public  WebDriver driver;
//	ReadDataConfiguration read=new ReadDataConfiguration();
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;

	
public String createNewCustomerExcel() throws FileNotFoundException
{
	
	String filepath= ("./ActiTime_Automation\\src\\test\\java\\com\\actiTime\\Utilities\\createNewCustomerData.xlsx");
	File file= new File(filepath);
	FileOutputStream writeCustomerdetail=new FileOutputStream(file);
	HSSFWorkbook wb=new HSSFWorkbook();
	
        //create the blank workbook
//	Workbook wb= new Workbook();
//        //create the blank excel sheet
//	Sheet sh= (Sheet) wb.createSheet("data");
//	//define the position in the excel sheet where write operation needs to perform
//        Row rw= ((org.apache.poi.ss.usermodel.Sheet) sh).createRow(4);
//	Cell cl=(Cell) rw.createCell(1);
//        //define input type
//	((org.apache.poi.ss.usermodel.Cell) cl).setCellType(CellType.STRING);
//        //define the data value
//	((org.apache.poi.ss.usermodel.Cell) cl).setCellValue("Webkul Software");
//        //write the workbook
//	wb.write(fos);
	
	return null;
}
	
	
	}
	