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

public class Cart {
		Logger log = LoggerHelper.getLogger(TestBase.class);
		private WebDriver driver;
		WaitHelper waitHelper;
			
			
			@FindBy(xpath="html/body/div[9]/div[4]/div[5]/div/div/div[1]/h1")
			public WebElement shoppingCartLogo;
			public Cart(WebDriver driver){
				this.setDriver(driver);
				PageFactory.initElements(driver, this);
				waitHelper = new WaitHelper(driver);
				waitHelper.waitForElement(shoppingCartLogo, DataSource.getExplicitWait());
			}
			public WebDriver getDriver() {
				return driver;
			}
			public void setDriver(WebDriver driver) {
				this.driver = driver;
			}

}
