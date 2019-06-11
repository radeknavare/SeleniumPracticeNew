package com.seleniumpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TableHandling {
	
	WebDriver chromeDriver;
	
	@BeforeTest(groups="table")
	public void initialize()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\navarked\\Desktop\\chromedriver_win32\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
	}

	@Test(groups="table")
	public void getTableContents()
	{
		chromeDriver.get("http://demo.guru99.com/test/web-table-element.php");
		chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> tableCols = chromeDriver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println(tableCols.size());
		List<WebElement> tableRows = chromeDriver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println(tableRows.size());
		double getValue,max=0;
		for(int i=1; i<=tableRows.size(); i++)
		{
			getValue = Double.parseDouble(chromeDriver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td[4]")).getText());
			if(max<getValue)
			{
				max = getValue;
			}			
		}
		System.out.println(max);
		
		
	}
}
