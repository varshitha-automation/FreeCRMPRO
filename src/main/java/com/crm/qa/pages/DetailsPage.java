package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class DetailsPage extends TestBase{
	

	public DetailsPage() throws IOException {
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(name="emailhg")
	WebElement name;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	public HomePage mainLogin() throws IOException
	{
		name.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		login.click();
		
		return new HomePage();
		
	}
	public void border()
	{
		TestUtil.jsBorder(driver, name);
	}

}
