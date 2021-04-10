package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.Listener.listen;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
@Listeners(listen.class)

public class DetailsPageTest extends TestBase{
	
	DetailsPage detailspage;
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;

	public DetailsPageTest() throws IOException {
		super();
		
	}
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeMethod
	
	public void setup() throws IOException {
		intialization();
		log.info("successfully initialized");
		detailspage = new DetailsPage();
		loginpage = new LoginPage();
		testutil = new TestUtil();
	}
	
	//@Test
    public void login() throws IOException
    {
		detailspage = loginpage.Login();
		homepage = detailspage.mainLogin();
		log.info("successfully logged in");
		log.info("waiting for log to see");
    }
	
	@Test
	public void putBorder() throws IOException
	{
		detailspage = loginpage.Login();
		detailspage.border();
		testutil.TakeScreenShot("element");
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		/*if(result.getStatus() == ITestResult.FAILURE)
		{
			testutil.TakeScreenShot(result.getMethod().getMethodName());
		}*/
		driver.quit();
	}

}
