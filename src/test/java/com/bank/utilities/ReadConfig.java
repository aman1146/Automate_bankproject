package com.bank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {   // for read every value in config.prop file we have to create methods
	
	Properties pro;  // create object of properties with this object we will call the data of properties file
	
	public ReadConfig()  // constructor
	{
		File src= new File("./configuration/config.properties"); // location of config.properties
		try {
			FileInputStream fis= new FileInputStream(src);
			// FileInputStream used if we want to read the data we need to open this in read mode
			pro= new Properties();
			pro.load(fis);  // load will completely load the file at runtime
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is" +e.getMessage());
			
		}
		
	}
	
	public String  getAppUrl()
	{
		String url= pro.getProperty("baseurl");
		return url;
		
	}
	
	public String  getUsername()
	{
		String username= pro.getProperty("username");
		return username;
		
	}
	
	public String  getPassword()
	{
		String password= pro.getProperty("password");
		return password;
		
	}
	
	public String  getChromePath()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
		
	}
	
	public String  getFirefoxPath()
	{
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
		
	}
	
	
	

	
	
}
