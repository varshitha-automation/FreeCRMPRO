package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver,this); 
	}

	@FindBy(xpath="//a[text()='j h hh']/parent::span/parent::div/following-sibling::div/a")
	WebElement updateClick;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsClick;	
	
	@FindBy(xpath="//span[text()='varshitha m']")
	WebElement Username;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement SearchBtn;
	
	public String userNameCheck()
	{
		 return Username.getText();
	}
	
	public void click()
	{
		 updateClick.click();
	}
	
	public void Search()
	{
		SearchBtn.sendKeys(prop.getProperty("send") + Keys.ENTER);
	}
	
	public ContactPage Contact() throws IOException
	{
		contactsClick.click();
		return new ContactPage();
	}

}
