package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class RegistrationPage  extends TestBase{
	
	//Page Factory : OR
	//Sign Up form
	@FindBy(xpath="//div[@class='login mobile_login']/a[2]")
	WebElement signupButton;
	
	@FindBy(xpath="//a[@href='#signup']")
	WebElement popupTitle;
	
	@FindBy(id="name")
	WebElement username;
	
	@FindBy(id="register-email")
	WebElement email;
	
	@FindBy(id="register-pwd")
	WebElement password;
	
	@FindBy(id="register-pwd-confirm")
	WebElement confirmpassword;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//button[text()=' Create Account ']")
	WebElement createaccount;
	
	@FindBy(xpath="//div[text()='A verification link has been sent to your email address.']")
	WebElement signupmessage;
	
	@FindBy(xpath="//strong[@id='name-error']")
	WebElement usernamevalidation;
	
	@FindBy(xpath="//strong[@id='password-error']")
	WebElement passwordvalidation;
	
	@FindBy(xpath="//strong[@id='email-error']")
	WebElement emailvalidation;
	
	@FindBy(xpath="//strong[@id='password_confirmation-error']")
	WebElement confirmpasswordvalidation;
	
	@FindBy(xpath="//strong[@id='agree-error']")
	WebElement checkboxvalidation;
	
	
	
	
	
	
	
	
	//initializing the page objects
	
     public RegistrationPage()
     {
    	 PageFactory.initElements(driver, this);
     }
     
     //Actions :
     
     //verify the Sign Up pop up
     public String verifyPopTitle() throws InterruptedException  {
    	 
    	 Thread.sleep(5000);
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 Thread.sleep(5000);
    	 return popupTitle.getText();
    	 
     }
     
     //Fill the SignUp Form
     public  void fillSignUpForm() throws InterruptedException
     {
    	 Thread.sleep(5000);
    	 WebElement signupButton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 username.sendKeys("Kunal Kashyap");
    	 email.sendKeys("kunal.kashyap@saffrontech.net");
    	 password.sendKeys("Kunal@123");
    	 confirmpassword.sendKeys("Kunal@123");
    	 agree.click();
    	 //createaccount.click();
    	 WebElement createaccount=driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
     }
     //verify the signup successful message
     public String getSignUpMessage()
     {
    	 return signupmessage.getText();
     }
     
     
     public boolean userNameValidation()
     {
    	 
    	 String username=usernamevalidation.getText();
    	 if(username.contains("required"))
    	 {
    		
    		return true;
    		  }
    	 else {
    		 return false;
    	 }
    	 
    	
    	 
    	
    	 
    	 
     }
     
     public void clickOnEmptyForm()
     {
    	 WebElement signupButton =driver.findElement(By.xpath("//div[@class='login mobile_login']/a[2]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", signupButton);
    	 
    	 
    	 WebElement createaccount =driver.findElement(By.xpath("//button[text()=' Create Account ']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", createaccount);
     }
     
       
    	 
    	  
    			   
       }
    
     
	

	


