package com.seleniumpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataAccess {

	@Test
	public void getData() throws FileNotFoundException, IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\navarked\\Documents\\SeleniumPracticeNew\\SeleniumPractice\\src\\test\\java\\com\\resources\\TestData.xlsx"));
		XSSFSheet sheet = wb.getSheet("Sheet 1");
		System.out.println(sheet.getFirstHeader());
	}
}
