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

public class TangailCottonSaree {
	Logger log = LoggerHelper.getLogger(TestBase.class);
	private WebDriver driver;
	private Cart cart;
	WaitHelper waitHelper;
	
	
	@FindBy(xpath="html/body/div[9]/div[4]/div[6]/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/div[2]/div[3]/div[4]/div/button")
	WebElement buyNow;
	@FindBy(xpath="html/body/div[13]/div[2]/div[3]/div/input")
	//html/body/div[14]/div[2]/div[3]/div/input
	WebElement addToCart;
	public TangailCottonSaree(WebDriver driver){
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(buyNow, DataSource.getExplicitWait());
	}
	
	public void clickOnBuyNowElement(){
		log.info("clicking on buyNow element.");
		buyNow.click();		
	}
	
	public void clickOnAddToCartElement(){
		log.info("clicking on addToCart element.");
		addToCart.click();
		
	}
	
	public Cart clickOnBuyNow(){
		clickOnBuyNowElement();
		clickOnAddToCartElement();	
		return new Cart(driver);
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
