package com.framework.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.framework.qa.base.TestBase;
import com.framework.qa.pages.ChainsCataloguePage;
import com.framework.qa.pages.HomePage;
import com.framework.qa.pages.LoginPage;
import com.framework.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ChainsCataloguePage chainsCatalogue;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		// contactsPage = new ContactsPage();
		// loginPage = new LoginPage();
		chainsCatalogue=new ChainsCataloguePage();
		homePage = new HomePage();
		
	}

	@Test
	public void verifyCompanyTitle() {
		String homePageTitle = homePage.verifyCompanyTitle();
		System.out.println("The Company Name is : " + homePageTitle);
		Assert.assertEquals(homePageTitle, "X Fashions", "Home page title not matched");
	}

	@Test
	public void verifyCompanyTitlevisibility() {
		Assert.assertTrue(homePage.verifyCompantName());
	}

	@Test
	public void getCatalogCount() {
		homePage.verifyCount();
	}

	@Test
	public void getDetails() throws InterruptedException {
		homePage.getCatalogueDetails();
	}
	
	@Test
	public void ChainsClick() throws InterruptedException {
		chainsCatalogue=homePage.clickOnChainsLink();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
