package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver,this); //Initializing the objects
	}

	//Page Factory - Object Repository
	

	@FindBy(xpath="//span[text()='Log In']")
	   WebElement LoginFirstPage;
	
	

	@FindBy(xpath="//span[text()=' sign up']")
	   WebElement signUp;
	
	@FindBy(xpath="//div[@class='rd-navbar-panel']/div/a")
	WebElement title;
   
    public String validateTitle()
     {
    	 return driver.getTitle();
     }
     
     public boolean CrmLogo()
     {
    	 return title.isDisplayed();
     }
      
     public DetailsPage Login() throws IOException
     {
    	 LoginFirstPage.click();
    	 return new DetailsPage(); 
     }
     
}
     
    		 
