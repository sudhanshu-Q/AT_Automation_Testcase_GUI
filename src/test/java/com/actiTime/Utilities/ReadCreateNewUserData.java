package com.actiTime.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

public class ReadCreateNewUserData {

	final static Logger log = Logger.getLogger(ReadCreateNewUserData.class);
	Properties readPropertiesUser;

	public ReadCreateNewUserData() {
		File sourceProperties = new File("./Configuration/UserData.properties");
		try {
			log.debug("Getting new user data from source :"+sourceProperties);
			FileInputStream fis = new FileInputStream(sourceProperties);
			readPropertiesUser = new Properties();
			readPropertiesUser.load(fis);
		} catch (Exception e) {
			log.error("Access denied for new user data :"+e.getMessage());
		}
	}
		public String firstName()
		{
			String fisrtNameuser=readPropertiesUser.getProperty("FirstName");
			return fisrtNameuser;
		}
		public String getpassword()
		{
			String passwordUser=readPropertiesUser.getProperty("password");
			return passwordUser;
		}
		public String getRetypepassword()
		{
			String passwordretypeUser=readPropertiesUser.getProperty("password");
			return passwordretypeUser;
		}
		public String getlastnameUser()
		{
			String lastName=readPropertiesUser.getProperty("LastName");
			return lastName;
		}
		public String getfax()
		{
			String fax=readPropertiesUser.getProperty("fax");
			return fax;
		}
		public String getPhoneNumber()
		{
			String phoneNumber=readPropertiesUser.getProperty("Phone");
			return phoneNumber;
		}
		public String getMiddleInitial()
		{
			String middleInitial=readPropertiesUser.getProperty("MiddleInitial");
			return middleInitial;
		}
		public String getMobileNumber()
		{
			String mobnumber=readPropertiesUser.getProperty("Mobile");
			return mobnumber;
		}
		public String getEmailAddress()
		{
			String emailAddress=readPropertiesUser.getProperty("EmailAdress");
			return emailAddress;
		}
		public String getOtherContact()
		{
			String otherContact=readPropertiesUser.getProperty("otherContact");
			return otherContact; 
		}
		public String generateRandomNewUserName() {
			//	log.debug("Random string generated :" + Baseclass.class);
				String newUserName = RandomStringUtils.randomAlphabetic(6);
				//log.info("Generated alphabet ");
				return newUserName;
			}
	}


