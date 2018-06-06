package com;


import org.testng.annotations.*;
import com.pages.*;

import base_test.TestBase;

public class SmokeTest extends TestBase {
	HomePage hp;
	TangailCottonSaree tangailCottonSaree;
	Cart cart;
	
	
	
	@BeforeClass
	public void beforeClass(){//DataSource.OR.getProperty("url")
		getApplicationURL(getData("url"));
		hp = new HomePage(driver);		
	}
	
	
	
	
	@Test
	public void cartTest(){		
		tangailCottonSaree = hp.navigateToTangailCottonSaree();
//		cart = tangailCottonSaree.clickOnBuyNow();		
	}
}
