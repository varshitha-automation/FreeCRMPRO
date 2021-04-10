package com.crm.qa.util;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xpath.axes.WalkerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	
	public TestUtil() throws IOException {
		super();
	}

	public static String ExcelLocation="C:\\Users\\VARSHITHA\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 8000;
	static Workbook book;
	static Sheet sheet;
	
	 
	
	public void action()
	{
		WebElement move = driver.findElement(By.id("main-nav"));
		Actions act = new Actions(driver);
		act.moveToElement(move).build().perform();
		
	}
	
	public static String send="what";
	
	public void switchToFrame()
	{
		driver.switchTo().frame("rufous-sandbox");
	}
	
	public Object[][] excelData(String sheetname)
	{
		FileInputStream fs=null;
		try {
			fs = new FileInputStream(ExcelLocation);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		book = WorkbookFactory.create(fs);
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i<sheet.getLastRowNum();i++)
		{
			for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	public String TakeScreenShot(String filename) throws IOException
	{
		//take screenshot and store it in file
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
		    File file = ((TakesScreenshot)augmentedDriver).
		                        getScreenshotAs(OutputType.FILE);
		    String destination = "C:\\Users\\VARSHITHA\\eclipse-workspace\\FreeCrmTest\\Screenshot\\"+filename+".png";
		//copy the screenshot to desidered location
		FileUtils.copyFile(file, new File(destination));
		
		return destination;
	}
	
	public static ExtentReports report()
	{
		
		String path=System.getProperty("user.dir")+"\\ExtentReport\\result.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation tool");
		reporter.config().setDocumentTitle("Automation");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Varshitha");
		return extent;
	}
	
	public static void jsClickOnElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", ele);
	}
	
	public static void jsScrollTillElementVisible(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	
	public static void jsScrollTillEnd(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void jsBorder(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
	}
	
	
	
	
	

}
	
