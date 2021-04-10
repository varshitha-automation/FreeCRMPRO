package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.CreateContactsPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{
	
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	LoginPage loginpage;
	DetailsPage detailspage;
	CreateContactsPage createcontactspage;

	public ContactPageTest() throws IOException {
		super();
}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		intialization();
		loginpage = new LoginPage()
;		homepage = new HomePage();
		testutil = new TestUtil();
		detailspage = new DetailsPage();
		contactpage	=new ContactPage(); 
		detailspage = loginpage.Login();
		homepage =detailspage.mainLogin();
		contactpage=homepage.Contact();
	}
	
	@Test(priority=1)
	public void ContactTitleTest()
	{
		boolean n = contactpage.checkContactTitle();
		Assert.assertTrue(n);
	}
	
	@Test(priority=2)
	public void contactTick()
	{
		contactpage.checkBoxTick("gfdgh ghg hgg");
	}
	
	@Test(priority=3)
	public void actionTick()
	{
		contactpage.checkBoxTicked();
	}
	
	
	
	@Test(priority=4)
	
	public void exportTest()
	{
		contactpage.Export();
	}
	
	@Test(priority=5)
	public void ExportOk()
	{
		contactpage.Export();
		contactpage.OKExport();
	}
	
	@Test(priority=6)
	public void NewContact() throws IOException
	{
		createcontactspage=contactpage.CreateContact();
	}
	
@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
