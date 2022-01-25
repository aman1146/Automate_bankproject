package com.bank.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.bank.pageobject.Loginpage;

import jdk.internal.org.jline.utils.Log;
import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{  // inherting the base class
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		logger.info("URL open successfully");
		Loginpage lp=new Loginpage(driver);  // now with using this object we can call methods from loginpage class[PO package]--> parent class kabject bna diya
		//Thread.sleep(5000);-- declare implicit wait in base class
		lp.setUserName(username);
		logger.info("name shows successfully");
		lp.setpwdName(password);
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
		}
		
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
		
	}

}
