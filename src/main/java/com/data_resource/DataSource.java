package com.data_resource;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import util.ResourceHelper;


public class DataSource {
//	static ResourceHelper resourceHelper = new ResourceHelper();
	private static Logger log= Logger.getLogger(DataSource.class);
	public static Properties OR;
	
	private static String browserType;
	

	private String userName;
	private String password;
	private String url;	
	long implicitWait;
	long explicitWait;
	long pageLoadTime;
	
	
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the browserType
	 */
	public static String getBrowserType() {
		return browserType;
	}
	public String getUserName() {
//		return OR.getProperty("userName");
		return userName;
	}
	public String getPassword() {
//		return OR.getProperty("password");
		return password;
	}
	public String getUrl() {
//		return OR.getProperty("url");
		return url;
	}
	public static long getImplicitWait() {
		return Integer.parseInt(OR.getProperty("implicitWait"));
	}
	public static long getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitWait"));
	}
	public static long getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageLoadTime"));
	}
	
	static{
		log.info("Loding config.properties....");
		OR = new Properties();
		File file = new File(ResourceHelper.getResourcePath("\\conFig\\config.properties"));
		FileInputStream fileInputStream;
		
		try {			
			fileInputStream = new FileInputStream(file);
			OR.load(fileInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Loading config.properties done.");
	}

}
