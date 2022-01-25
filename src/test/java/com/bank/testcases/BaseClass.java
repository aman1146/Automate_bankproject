package com.bank.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bank.utilities.ReadConfig;

public class BaseClass {
	
	
	ReadConfig readconfig= new  ReadConfig();
// creating object of read config file to  call its methods
	public String baseurl= readconfig.getAppUrl();
	public String username= readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; // declare outside because we have to use this in several methods
	
	
	@Parameters("browser1") // to  run test case on desired browser, chrome, firefox
	@BeforeClass   // first this method will execute and then any other method will execute
	public void setup(String br)  //  pre-requist defined for the test
	{
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("BankProject");  // name of project
		PropertyConfigurator.configure("Log4j.properties");  // calling log4j properties file
		
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());  // "System.getProperty"--it will look for project  directory, we can use this instead of "C:\Users\hp\OneDrive\Desktop\aman Automation Notes\Eclipse programs created\BankProject\drivers\chromedriver.exe"
			// we can fetch the address of chromdriver by right click on chromedriver under driver folder--> properties--> copy address
			// again change this System.getProperty("user.dir")+"\\drivers\\chromedriver.exe"-- to readconfig.getChromePath()-- to get it directly from readconfig file 
			driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());  // "System.getProperty"--it will look for project  directory, we can use this instead of "C:\Users\hp\OneDrive\Desktop\aman Automation Notes\Eclipse programs created\BankProject\drivers\chromedriver.exe"
			// we can fetch the address of chromdriver by right click on chromedriver under driver folder--> properties--> copy address
			// again change this System.getProperty("user.dir")+"\\drivers\\chromedriver.exe"-- to readconfig.getChromePath()-- to get it directly from readconfig file 
			driver=new FirefoxDriver();
		}
		driver.get(baseurl);
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	// ss code
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		 File source= ts.getScreenshotAs(OutputType.FILE);
		 File target= new File(System.getProperty("user.dir")+"/screenshots/" +tname+ ".png");
		 FileUtils.copyFile(source, target);
		 System.out.println("ss taken");
		 
		
	}
	
}
