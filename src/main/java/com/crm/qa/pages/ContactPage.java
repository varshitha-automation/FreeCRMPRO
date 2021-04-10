package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement ContactTitle;
	
	public void checkBoxTick(String name)
	{
		
	    WebElement e = driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/div/input"));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
        
	}
	
	@FindBy(xpath="//span/div[2]")
	WebElement CheckBox;
	
	@FindBy(xpath="//button[@class='ui button']")
	WebElement CancelButton;
	
	@FindBy(xpath="//button[@class='ui linkedin button']/i[@class='download icon']")
	WebElement ExportBtn;
	
	@FindBy(xpath="//button[@class='ui primary button']")
	WebElement OKBtn;
	
	@FindBy(xpath="//div[@class='content']/p")
	WebElement TextCapture;
	
	@FindBy(xpath="//a/button[@class='ui linkedin button']")
	WebElement createContactBtn;
	
	public boolean checkContactTitle()
	{
		return ContactTitle.isDisplayed();
	}
	
	public void checkBoxTicked()
	{
		CheckBox.click();
	}
	
	public void CancelFrame()
	{
		CancelButton.click();
	}
	
	public void Export()
	{
		ExportBtn.click();
	}
	
	public void OKExport()
	{
		OKBtn.click();
	}
	
	public CreateContactsPage CreateContact() throws IOException
	{
		createContactBtn.click();
		return new CreateContactsPage();
	}
	

}
