package com.waithelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import loggerHelper.LoggerHelper;

public class WaitHelper {
	
	
	private static Logger log = LoggerHelper.getLogger(WaitHelper.class);
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitHelper(WebDriver driver){
		super();
		this.driver = driver;
	}
	
	public void waitForElement(WebElement element, long time){
		log.info("waiting for element to present....");
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is present...");
				
	}

}
