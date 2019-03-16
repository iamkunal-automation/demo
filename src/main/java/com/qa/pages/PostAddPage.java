package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class PostAddPage extends TestBase {
	
	Utils util=new Utils();
	
	// OR : for Login
	@FindBy(id="email")
	WebElement loginemail;
	@FindBy(id="password")
	WebElement loginpassword; 
	@FindBy(xpath="//div[@class='after_login']")
	WebElement afterlogin;
	
	//OR : for Add to cart
	
	@FindBy(xpath="//select[@id='category_id']")
	WebElement categories;
	
	@FindBy(xpath="//select[@id='sub_category_id']")
	WebElement subcategories;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-custom']//button")
	WebElement tinycrossbutton;
	
	
	//for initializing  web elements
	public PostAddPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Actions :
	
	 public boolean loginfunctionality() throws InterruptedException
     {
		 
    	 util.myWait(2000);
    	 WebElement loginbutton=driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginbutton);
    	 util.myWait(2000);
    	 loginemail.sendKeys("kunal.kashyap@saffrontech.net");
    	 util.myWait(2000);
    	 loginpassword.sendKeys("Kunal@123");
    	 util.myWait(2000);
    	 
    	 WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='login']"));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginsubmit);
    	 util.myWait(5000);
    	 
    	 //return new HomePage();
    	 Boolean verifyuser=afterlogin.isDisplayed();
    	 return verifyuser;
    	 
    	 
     }
	
	public boolean FillAddDetails() throws InterruptedException
	{
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
   	 categories.click();
   	 util.selectValueFromDropdown(categories, 1);
   	 util.myWait(10000);
   	// subcategories.click();
   	 //util.selectValueFromDropdown(subcategories, 0);
   	// util.myWait(10000);
   	 title.sendKeys("Lamborgini");
   	 description.sendKeys("My First Ad.");
   	 util.myWait(10000);
   	JavascriptExecutor js = (JavascriptExecutor) driver;
   	js.executeScript("window.scrollBy(0,1000)");
   	 //country.click();
   	 //util.selectValueFromDropdown(country, 0);
   	 util.myWait(10000);
   	 city.sendKeys("Fremont");
   	 util.myWait(3000);
   	 WebElement Createad=driver.findElement(By.xpath("//a[@id='saveform']"));
	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", Createad);
   	 boolean verifyadpost=tinycrossbutton.isEnabled();
   	 return verifyadpost;
   	 
	}
	
	public void clickonPostAd()
	{
		WebElement addpostbutton=driver.findElement(By.xpath("//div[@class='post_add']/a"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addpostbutton);
	}
	
	public void loginUnderPostAdd() throws InterruptedException
	{
		loginemail.sendKeys("kunal.kashyap@saffrontech.net");
   	 util.myWait(2000);
   	 loginpassword.sendKeys("Kunal@123");
   	 util.myWait(2000);
   	 
   	 WebElement loginsubmit=driver.findElement(By.xpath("//input[@id='login']"));
   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginsubmit);
	}
	
	

}
