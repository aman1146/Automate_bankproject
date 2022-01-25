package com.bank.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;   // create driver object [local driver]
	
	public Loginpage(WebDriver rdriver)  //  create the constructor [remote driver]  and make this as public because we will be using this in test cases which are in different packages
	{
		ldriver=rdriver; // initiate the driver
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(name="uid")
	WebElement username;  // any name given from our side
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setUserName(String uname)
	{
		
		username.sendKeys(uname);
		
	}
	
	public void setpwdName(String pwdname)
	{
		
		pwd.sendKeys(pwdname);
		
	}
	
	public void clickLogin()
	{
		
		login.click();
		
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	
}
