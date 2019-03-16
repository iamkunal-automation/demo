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
import com.qa.pages.RegistrationPage;

public class SignUpPageTest extends TestBase {
	Logger log = Logger.getLogger(SignUpPageTest.class);

	
	RegistrationPage registration;
	
	public SignUpPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		registration=new RegistrationPage();
	}

	@Test(priority=1)
	public void SignUpPopUpTest() throws InterruptedException
	{
		//log.info("Verifying the signUp  pop up  title");
		String actual=registration.verifyPopTitle();
		String expected="Sign Up";
		Assert.assertEquals(actual, expected);
		System.out.println("Sign Up Pop Up verified");
				
	}
	@Test(priority=2)
	public void SignUpFormTest() throws InterruptedException
	{
		//log.info("filling the sign up form");
		registration.fillSignUpForm();
		String actualstring=registration.getSignUpMessage();
		String expectedexpectedstring="A verification link has been sent to your email address.";
		Assert.assertEquals(actualstring, expectedexpectedstring,"message not matched");
        //log.info("sign up operation verified successfully");
		}
	
	@Test(priority=3)
	public void usernameValidationTest() throws InterruptedException
	{
		//log.info("verifying user name validation");
		registration.clickOnEmptyForm();
		Thread.sleep(5000);
		Boolean validation_status=registration.userNameValidation();
		Boolean expectedvalidation=true;
		Assert.assertEquals(validation_status, expectedvalidation);
        //log.info("user name validation verified successfully");	
}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
