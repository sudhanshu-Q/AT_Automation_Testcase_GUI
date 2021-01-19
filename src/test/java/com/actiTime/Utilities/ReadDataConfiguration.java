package com.actiTime.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataConfiguration
{
	Properties readProperties;

	public ReadDataConfiguration()
	{
		File sourceProperties= new File("./Configuration/DataConfiguration.properties");
		try
		{
			FileInputStream fis=new FileInputStream(sourceProperties);
			readProperties=new Properties();
			readProperties.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("Exception is:" +e.getMessage());
		}
	}
	public String getUrl()
	{
		String url=readProperties.getProperty("Url");
		return url;
	}
	public String preLoginTitle()
	{
		String prelog=readProperties.getProperty("preloginTitle");
		return prelog;
	}
	public String postLoginTitle()
	{
		String postLog=readProperties.getProperty("postloginTitle");
		return postLog;
	}
	public String getUsername()
	{
		String usernm=readProperties.getProperty("Username");
		return usernm;
	}
	public String getPassword()
	{
		String pass=readProperties.getProperty("Password");
		return pass;
	}
	public String getChromePath()
	{
		String chromepath=readProperties.getProperty("Chromepath");
		return chromepath;
	}
	public String getBrowsername()
	{
		String brName=readProperties.getProperty("BrowserName");
		return brName;
	}
	public String getFirefoxPath() 
	{
		String firefoxpath=readProperties.getProperty("Firefoxpath");
		return firefoxpath;
	}

	public String getProjectName() 
	{
		String proName=readProperties.getProperty("project");
		return proName;
	}
	public String getTaskName() 
	{
		String taskName=readProperties.getProperty("task");
		return taskName;
	}

}

