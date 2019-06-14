package com.seleniumpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataAccess {

	@Test
	public void getData() throws FileNotFoundException, IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:\\Users\\navarked\\Documents\\SeleniumPracticeNew\\SeleniumPractice\\src\\test\\java\\com\\resources\\TestData.xlsx"));
		for(int i=0; i<wb.getNumberOfSheets();i++)
		{
			XSSFSheet sheet = wb.getSheetAt(i);
			XSSFRow getRow = sheet.getRow(0);
			System.out.println("Number of columns : "+getRow.getLastCellNum());
			System.out.println("Number of rows : "+sheet.getLastRowNum());
			
			Iterator<Row> rows = sheet.iterator();
			
			do
			{
				Row row =rows.next();
				Iterator<Cell> c = row.cellIterator();
				while(c.hasNext())
				{
					Cell value = c.next();
					System.out.println(value.getStringCellValue());
				}
			
			}while(rows.hasNext());
		}
		wb.close();
	}
}
