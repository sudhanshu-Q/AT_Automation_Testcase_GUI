package com.actiTime.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.actiTime.Utilities.ReadDataConfiguration;

public class LoginTestDemo {
	
	ReadDataConfiguration read=new ReadDataConfiguration();
	static WebDriver driver;
	
	@Test(priority=1)
	public void setup() throws MalformedURLException
	{
		String nodeUrl="http://192.168.225.242:4444/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("Chrome");
		cap.setPlatform(Platform.WIN10);
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new RemoteWebDriver(new URL(nodeUrl),cap);
	}
	
	@Test(priority=2)
	public void logintestDemooo()
	{
		driver.get(read.getUrl());
	}
	
	

}
