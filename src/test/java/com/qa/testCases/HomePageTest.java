package com.qa.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	Logger log = Logger.getLogger(HomePageTest.class);

	HomePage homepage;
	LoginPage login;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homepage=new HomePage();
		login=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void countcategoryTest()
	{
		//log.info("counting the category");
		int actual=homepage.countCategoryList();
		int expected=14;
		Assert.assertEquals(actual, expected,"Number of categories does not matched");
		//log.info("successfully count and matched the category list");

		
	}
	
	@Test(priority=2)
	public void countnumberofCountryTest()
	{
		//log.info("counting number of country from dropdown");
		int actual=homepage.countNumberOfCountry();
		int expected=247;
		Assert.assertEquals(actual, expected,"country list not matched");
		//log.info("number of country in dropdown matched");
	}
	
	@Test(priority=3)
	public void updateAdTest() throws InterruptedException
	{
		//log.info("updating the ads.");
		homepage.updateAds();
		//log.info("ads. updated successfully");
	}
	
	@Test(priority=4)
	public void sendEnquiryTest() throws InterruptedException
	{
		//log.info("sending the enquiry");
		homepage.sendEnquiry();
		//log.info("enquiry sent successfully");
	}
	
	@Test(priority=5)
	public void accountUpdateTest() throws InterruptedException
	{
		//log.info("updating the account information");
		homepage.updateAccountInfo();
		//log.info("account information updated");
	}
	
	@Test(priority=6)
	public void newEmailSubscriptionTest()
	{
		//log.info("verifying the email subscription with new email id.");
		String actualvalidation=homepage.subscribeEmail();
		String expectedvalidation="You have successfully subscribed for our Newsletter";
		Assert.assertEquals(actualvalidation, expectedvalidation,"message not matched");
       // log.info("successfully subscribed newsletter");
        }
	
	@Test(priority=7)
	public void existingEmailSubscriptionTest()
	{
		//log.info("verifying the email subscription with already existing email id");
		String actualvalidation=homepage.subscribeAlreadyexistemail();
		String expectedvalidation="This Email already exists";
		Assert.assertEquals(actualvalidation, expectedvalidation,"message not matched");
        //log.info("already existing email scenario working");
        }
	
	@Test(priority=8)
	public void shareAdTest() throws InterruptedException
	{
		
	//log.info("sharing the ad");	
	homepage.shareAd();
	//log.info("ad. shared successfully");
		
	}
	
	@Test(priority=9)
	public void logoutTest() throws InterruptedException
	{
		//log.info("Logging out from user panel");
		 Boolean logoutstatus=homepage.logout();
		 Boolean expectedstatus=true;
		 Assert.assertEquals(logoutstatus, expectedstatus);
        // log.info("logged out successfully");		 
	}
	
	@Test(priority=10)
	public void loginToSignUpSwitchTest() throws InterruptedException
	{
		//log.info("switching from login to sign up pop up");
		homepage.switchToSignUp();
		boolean actualButtonEnabled=homepage.verifySignUpPOpUp();
		boolean expectedButtonEnabled=true;
		Assert.assertEquals(actualButtonEnabled, expectedButtonEnabled);
        //log.info("switched to SignUp pop up successfully");
        }
	
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}

}
