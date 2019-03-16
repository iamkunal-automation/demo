package com.qa.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.utility.Utils;

public class HomePage extends TestBase {
	
	
	
	
	LoginPage login=new LoginPage();
	PostAddPage addpage=new PostAddPage();
	Utils util=new Utils();
     
	
	//OR :
	
	@FindBy(xpath="//li[@class='category_menu']//a[text()=' Categories ']")
	WebElement categoriesbutton;
	
	@FindBy (xpath="//select[@id='select_country']")
	WebElement countrybutton;
	
	@FindBy(xpath="//div[@class='user_img']")
	WebElement userimage;
	
	@FindBy(xpath="//div[@class='myaccount']//ul//li[1]")
	WebElement currentads;
	
	@FindBy(xpath="//tbody//tr[1]//td[8]//a")
    WebElement editActions;	
	
	@FindBy(xpath="//input[@id='title']")
    WebElement updateTitle;	
	
	@FindBy(xpath="//input[@type='submit'  and @class='btn btn-primary createbtn']")
	WebElement updatebutton;
	
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement tinycross;
	
	@FindBy(xpath="//div[@class='myaccount']//ul//li[5]")
	WebElement sentEnquiries;
	
	@FindBy(xpath="//tbody//tr//td[1]/a")
	WebElement addName;
	
	@FindBy(xpath="//input[@id='enq-subject']")
	WebElement enquirySubject;
	
	@FindBy(xpath="//textarea[@id='enq-desc']")
	WebElement enquiryComment;
	
	@FindBy(xpath="//input[@class='btn btn-primary createbtn enq-btn']")
	WebElement enquirySendButton;
	
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement enquirytinycrossbutton;
	
	
	@FindBy(xpath="//div[@class='myaccount']//ul//li[7]")
	WebElement accountMenu;
	
	@FindBy(xpath="//a[@href='http://beta.weeklypaper.org/US/userprofile/447/edit']")
	WebElement editButton;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city; 
	
	@FindBy(xpath="//input[@id='zip']")
	WebElement zipcode;
	
	@FindBy(xpath="//input[@class='btn btn-primary updatebtn']")
	WebElement updateButton;
	
	@FindBy(xpath="//button[@type='button' and @class='close']")
	WebElement tinycrossaccountUpdate;
	
	@FindBy(xpath="//input[@name='email' and @class='subscriber-email']")
	WebElement subscriberemailtextbox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement subscribeButton;
	

	@FindBy(xpath="//input[@type='checkbox' and @class='accept']")
	WebElement checkbox;
	
	
	@FindBy(xpath="//p[text()='This Email already exists']")
	WebElement alreadyexisttext;
	
	@FindBy(xpath="//p[text()='You have successfully subscribed for our Newsletter']")
	WebElement successemailtext;
	
	
	@FindBy(xpath="//a[text()=' Art / Books / Collectables / Music ']")
	WebElement categoryName;
	
	@FindBy(xpath="//div[@class='list_description_image']")
	WebElement productlink;
	
	@FindBy(xpath="//div[@class='sharebtn']")
	WebElement shareButton;
	
	@FindBy(xpath="//title[@id='at-svg-facebook-1']")
	WebElement fbButton;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement fbemail;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement fbpass;
	
	@FindBy(xpath="//input[@id='u_0_0']")
	WebElement fblogin;
	
	@FindBy(xpath="//span[@id='u_0_1w']")
	WebElement postbutton;
	
	@FindBy(xpath="//button[@type='button' and @class='share-close']")
	WebElement closeButton;
	
	@FindBy(xpath="//div[@class='myaccount']//ul//li[9]")
	WebElement logoutbutton;
	
	@FindBy(xpath="//div[@class='login mobile_login']/a[1]")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@href='#signup']")
	WebElement loginToSignUp;
	
	@FindBy(xpath="//button[@id='submitForm']")
	WebElement createAccountbutton;
	
	@FindBy(xpath="//div[@class='login mobile_login']/a[1]")
	WebElement loginlink;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions : 
	public int countCategoryList()
	{
		WebElement categoriesbutton=driver.findElement(By.xpath("//li[@class='category_menu']//a[text()=' Categories ']"));
   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", categoriesbutton);
   	  List<WebElement> categories=driver.findElements(By.xpath("//div[@class='cat_list']"));
   	 int size= categories.size();
   	  return size;
   	  
	}
	
	public int countNumberOfCountry()
	{
		//countrybutton.click();
		Select select=new Select(driver.findElement(By.xpath("//select[@id='select_country']")));
		List<WebElement> options=select.getOptions();
		int numberofCountry=options.size();
		return numberofCountry;
	}
	
	public void selectspecificmenu()
	{
		List<WebElement> mylist=driver.findElements(By.xpath("//div[@class='myaccount']//ul//li//a"));
		
		for(int i=0;i<mylist.size();i++)
		{
			String mymenu=mylist.get(i).getText();
			if(mymenu=="Current Ads")
			{
				mylist.get(i).click();
			}
		}
	}
	
	public void updateAds() throws InterruptedException
	{
		
		String title="My Test Ads.";
		addpage.clickonPostAd();
		addpage.loginUnderPostAdd();
		userimage.click();
		Thread.sleep(5000);
		currentads.click();
		Thread.sleep(5000);
		editActions.click();
		Thread.sleep(5000);
		updateTitle.clear();
	    updateTitle.sendKeys(title);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   	js.executeScript("window.scrollBy(0,1000)");
		updatebutton.click();
		if(tinycross.isEnabled())
		{
			System.out.println("profile updated successfully");
		}
		else
		{
			System.out.println("profile did not updated successfully");
		}
		
		
			}
	
	
	public void sendEnquiry() throws InterruptedException
	{
		addpage.clickonPostAd();
		addpage.loginUnderPostAdd();
		userimage.click();
		Thread.sleep(5000);
		sentEnquiries.click();
		Thread.sleep(5000);
		addName.click();
		Thread.sleep(5000);
		enquirySubject.sendKeys("My Test Enquiry");
		enquiryComment.sendKeys("My Test Comment");
		enquirySendButton.click();
		
		if(enquirytinycrossbutton.isEnabled())
		{
			System.out.println("Enquiry sent successfully");
		}
		
		else
		{
			System.out.println("enquiry did not send successfully");
		}
		
	}
	
	public void updateAccountInfo() throws InterruptedException
	{
		addpage.clickonPostAd();
		addpage.loginUnderPostAdd();
		userimage.click();
		Thread.sleep(5000);
		accountMenu.click();
		Thread.sleep(5000);
		editButton.click();
		Thread.sleep(5000);
		city.sendKeys("New Delhi");
		zipcode.sendKeys("110030");
		updatebutton.click();
		if(tinycrossaccountUpdate.isEnabled())
		{
			System.out.println("account info. updated successfully");
		}
		
		else
		{
			System.out.println("account info did not updated successfully");
		}
	}
	
	public String subscribeEmail()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   	js.executeScript("window.scrollBy(0,1000)");
	   	subscriberemailtextbox.sendKeys("kunal@gmail.com");
	   	checkbox.click();
	   	subscribeButton.click();
	   	String message=successemailtext.getText();
	   	return message;
	   	
	}
	
	public String subscribeAlreadyexistemail()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	   	js.executeScript("window.scrollBy(0,1000)");
	   	subscriberemailtextbox.sendKeys("kunaljhamca@gmail.com");
	   	checkbox.click();
	   	subscribeButton.click();
	   	String message=alreadyexisttext.getText();
	   	return message;
	}
	
	
	public void shareAd() throws InterruptedException
	{
		
	   	categoryName.click();
	   	productlink.click();
	   	shareButton.click();
	   	Thread.sleep(10000);
	   	WebElement fbButton =driver.findElement(By.xpath("//title[@id='at-svg-facebook-1']"));
   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", fbButton);
	   	Thread.sleep(5000);
	   	
	   	
	   	String MainWindow=driver.getWindowHandle();		
		
        // To handle all new opened window.				
            Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                   driver.findElement(By.xpath("//input[@id='email']")).sendKeys("saffrontech2@gmail.com");
                   driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("saffron@123");
                   driver.findElement(By.xpath("//input[@id='u_0_0']")).click();
                   postbutton.click();
                   driver.switchTo().window(MainWindow);
                   if(closeButton.isEnabled())
                   {
                	   System.out.println("share on facebook successfully");
                   }
                   else
                   {
                	   System.out.println("not shared successfully");
                   }
                   
	   
	   	Thread.sleep(5000);
		
	}
        }
	}
	
	public boolean logout() throws InterruptedException
	{
		login.loginfunctionality();
		userimage.click();
		logoutbutton.click();
		if(loginbutton.isEnabled())
		{
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void switchToSignUp() throws InterruptedException
	{
		WebElement loginlink =driver.findElement(By.xpath("//div[@class='login mobile_login']/a[1]"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginlink);
	   	 Thread.sleep(5000);
	   	 
	   	WebElement loginToSignUp =driver.findElement(By.xpath("//a[@href='#signup']"));
	   	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginToSignUp);
	   	 
	}
	
	public boolean verifySignUpPOpUp()
	{
		if(createAccountbutton.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

	
	
	
	

