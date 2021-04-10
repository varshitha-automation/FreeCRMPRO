package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.CreateContactsPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CreateContactsTest extends TestBase{
	//String sheetname="contacts";

	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	LoginPage loginpage;
	DetailsPage detailspage;
	CreateContactsPage createcontactspage;

	public CreateContactsTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		intialization();
		loginpage = new LoginPage();
		detailspage = new DetailsPage();
    	homepage = new HomePage();
		contactpage	=new ContactPage();
		createcontactspage = new CreateContactsPage();
		testutil = new TestUtil();
		detailspage = loginpage.Login();
		homepage =detailspage.mainLogin();
		testutil.action();
		contactpage=homepage.Contact();
		Thread.sleep(9000);
		createcontactspage=contactpage.CreateContact();
	}
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		TestUtil testutil = new TestUtil();
		Object[][] d=testutil.excelData("contacts");
		return d;
	}
	@Test(priority=1, dataProvider="getData")
	
	public void addingContact(String vfname,String vmname, String vlname,String vcomp) throws InterruptedException
	{
		
		createcontactspage.addContact(vfname, vmname, vlname, vcomp);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
