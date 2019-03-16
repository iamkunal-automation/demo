package com.qa.testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.PostAddPage;

public class PostAddTest extends TestBase {
	Logger log = Logger.getLogger(PostAddTest.class);

	PostAddPage postadd;
	
	
	
	public PostAddTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		postadd=new PostAddPage();
	}
	
	@Test(priority=1)
	public void postAddTest() throws InterruptedException
	{
		//log.info("posting the ad.");
		postadd.clickonPostAd();
		postadd.loginUnderPostAdd();
		Thread.sleep(5000);
		postadd.clickonPostAd();
		//log.info("filling ad. details");
		postadd.FillAddDetails();
		//log.info("ad. posted successfully");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
