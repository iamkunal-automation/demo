package com.qa.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class Utils extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	
	public void myWait(long time) throws InterruptedException
	{
		Thread.sleep(time);
	}
	
	public void selectValueFromDropdown(WebElement categories,int index)
	{
		Select select=new Select(categories);
		select.selectByIndex(index);
		
	}
	
	
	
}
