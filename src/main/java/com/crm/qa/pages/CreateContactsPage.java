package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CreateContactsPage extends TestBase{

	public CreateContactsPage() throws IOException {
		PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;

	@FindBy(name="middle_name")
	WebElement middlename;

	@FindBy(name="last_name")
	WebElement lastname;

	@FindBy(xpath="//div[@name='company']/input")
	WebElement company;

	@FindBy(xpath="//div[@class='item']/button[2]")
	WebElement saveBtn;
	
	public void addContact(String fname, String mname, String lname, String comp ) throws InterruptedException
	{
		firstname.sendKeys(fname);
		middlename.sendKeys(mname);
		lastname.sendKeys(lname);
		company.sendKeys(comp);
		Thread.sleep(5000);
		saveBtn.click();
		Thread.sleep(5000);
		driver.navigate().back();
	}
}
