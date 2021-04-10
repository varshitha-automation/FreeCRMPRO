package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	DetailsPage detailspage;
	
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		intialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void TitleTest()
	{
		String title=loginpage.validateTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}
	@Test(priority=2)
	public void Logotest()
	{
		boolean b=loginpage.CrmLogo();
		Assert.assertTrue(b);
	}
	@Test(priority=3)
	public void LoginTest() throws IOException
	{
		 detailspage= loginpage.Login();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
