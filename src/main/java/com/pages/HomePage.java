package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.data_resource.DataSource;
import com.waithelper.WaitHelper;

import base_test.TestBase;
import loggerHelper.LoggerHelper;

public class HomePage {
	Logger log = LoggerHelper.getLogger(TestBase.class);
	public WebDriver driver;
	
	WaitHelper waitHelper;
	
	//html/body/div[9]/div[1]/div[2]/div/div[1]/a/img
	@FindBy(xpath="html/body/div[9]/div[1]/div[2]/div/div[1]/a/img")
	WebElement logo;
	@FindBy(xpath="html/body/div[9]/div[2]/div/div[1]/div[1]/ul/li[1]/a")
	WebElement cottonSaree;
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(logo, DataSource.getExplicitWait());
		
	}
	
	public void clickOnCottonSareeElement(){
		log.info("clicking on cottonSaree element.");		
		cottonSaree.click();
		
	}
	
	public TangailCottonSaree navigateToTangailCottonSaree(){
		clickOnCottonSareeElement();				
		return new TangailCottonSaree(driver);		
	}

}
