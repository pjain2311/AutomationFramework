package com.framework.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.qa.base.TestBase;
import com.framework.qa.pages.ChainsCataloguePage;
import com.framework.qa.pages.HomePage;
import com.framework.qa.pages.LoginPage;
import com.framework.qa.util.TestUtil;

public class ChainsCatalogueTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ChainsCataloguePage chaincataloguePage;
	String sheetName = "contacts";

	public ChainsCatalogueTest(){
			super();
			
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		chaincataloguePage=new ChainsCataloguePage();
		homePage=new HomePage();
		chaincataloguePage=homePage.clickOnChainsLink();
	}

	@Test()
	public void validateFilter() {
		chaincataloguePage.verifyclickOnFilter();
	}

	@Test()
	public void ViewBasket() throws InterruptedException {
		chaincataloguePage.AddToCart();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
