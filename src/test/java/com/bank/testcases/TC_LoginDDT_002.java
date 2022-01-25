package com.bank.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.pageobject.Loginpage;
import com.bank.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
   public void loginDDT(String user, String pwd) // method
	{  
	   Loginpage lp= new Loginpage(driver);  // calling page object class  and accessing their method
	   lp.setUserName(user);
	   logger.info("username provided");
	   lp.setpwdName(pwd);
	   logger.info("pwd provided");
	   lp.clickLogin();
	   
	   if(isAlertPresent()==true)
	   {
		   driver.switchTo().alert().accept();  // close alert
		   driver.switchTo().defaultContent();
		   Assert.assertTrue(false);
		   logger.warn("login failed");
	   }
	   else {
		   Assert.assertTrue(true);
		   logger.info("login [passed");
		   lp.clickLogout();
		   driver.switchTo().alert().accept(); //close logout alert
		   driver.switchTo().defaultContent();
	   }
   }
	
	public boolean isAlertPresent() // userdefined method to check alert is present or not
	{
		try {
			driver.switchTo().alert();
			return true;
			}
		catch(Exception e)
		{
			return false;
		}
	}
	
	//creating 2 d array[ define this first]
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException  // data provider method
	{
		
		String path= System.getProperty("user.dir")+ "/src/test/java/com/bank/testdata/testdata.xlsx";  // location of test data file
		int rownum=  XLUtils.getRowCount(path, "sheet1");// calling getRowCount method from XLUtils class
		//getRowCount static method h to call by class name.method name 
		int colcount= XLUtils.getCellCount(path, "sheet1", 1);// 1 is rownum
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++) // rows
		{
			
			for(int j=0; j<colcount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "sheet1", i, j);  // 1 0
				
			}
			
		}
		return logindata;
		
		
	}
}
