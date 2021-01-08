package com.framework.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.framework.qa.base.TestBase;
import com.framework.qa.pages.ChainsCataloguePage;
import com.framework.qa.pages.HomePage;
import com.framework.qa.pages.LoginPage;
import com.framework.qa.pages.ReviewPage;
import com.framework.qa.util.TestUtil;

public class ReviewPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	ChainsCataloguePage chaincataloguePage;
	ReviewPage reviewPage;

	String sheetName = "OrderDeatils";

	public ReviewPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		chaincataloguePage = new ChainsCataloguePage();
		homePage = new HomePage();
		chaincataloguePage = homePage.clickOnChainsLink();
		reviewPage = new ReviewPage();
		reviewPage = chaincataloguePage.AddToCart();
	}

	@Test()
	public void OrderWithBlankData() {
		reviewPage.ConfirmOrderWithBlankData();
	}

	@Test()
	public void RemoveTest() {
		chaincataloguePage = reviewPage.RemovelnkClick();
	}

	@DataProvider
	public Object[][] getTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getTestData")
	public void AddtoCart(String Name, String Email, String Address1, String Strcountry, String strState,
			String strCity) {

		reviewPage.ConfirmSubmit(Name, Email, Address1, Strcountry, strState, strCity);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}