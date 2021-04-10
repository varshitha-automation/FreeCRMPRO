package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.Listener.listen;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
@Listeners(listen.class)
public class HomePageTest extends TestBase{
	
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	LoginPage loginpage;
	DetailsPage detailspage;

	public HomePageTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException
	{
		intialization();
		loginpage = new LoginPage();
   	homepage = new HomePage();
        testutil = new TestUtil();
		detailspage = new DetailsPage();
		detailspage = loginpage.Login();
		homepage =detailspage.mainLogin();
	}
	@Test(priority=1)
	public void CheckUsername()
	{
		String name = homepage.userNameCheck();
		Assert.assertEquals(name, "varshitha m", "not found what expected");
	}
	
	@Test(priority=2)
	public void updateClick() throws InterruptedException
	{
		Thread.sleep(9000);
		homepage.click();
	}
	
	@Test(priority=3)
	public void SearchText()
	{
		homepage.Search();
	}
	
	@Test(priority=4)
	public void ContactBtn() throws IOException
	{
		testutil.action();
		contactpage = homepage.Contact();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
