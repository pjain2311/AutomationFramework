package com.framework.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.framework.qa.base.TestBase;
import com.framework.qa.util.TestUtil;

public class ReviewPage extends TestBase {
	

	// div[@class='discounted-price']/span[@class='final-price']

	@FindBy(xpath="//div[@class='confirm-button']/span")
	public WebElement ConfirmOrderbtn;
	
	@FindBy(xpath="//div[@class='invalid-text'][\" + i + \"]")
	public List<WebElement> invalidText;
	
	@FindBy(xpath="//div[contains(text(),'Remove')]")
	public WebElement Removelink;
	
	@FindBy(xpath = "//input[@autocomplete='name']")
	public WebElement txtName;
	
	@FindBy(xpath = "//input[@autocomplete='email']")
	public WebElement txtEmail;
	
	@FindBy(xpath="//input[@autocomplete='shipping address-line1']")
	public WebElement txtaddress1;
	
	@FindBy(xpath="//input[@placeholder='Please enter your country']")
	public WebElement txtcountry;
	
	@FindBy(xpath="//input[@placeholder='State']")
	public WebElement txtState;
	
	@FindBy(xpath="//input[@placeholder='City']")
	public WebElement txtCIty;
	
	@FindBy(xpath = "//input[@autocomplete='new-password']")
	public WebElement enterCountry;
	
	@FindBy(xpath="//div[@class='country-item country-item-India ']/div")
	public WebElement Country;
	
	@FindBy(xpath = "//div[@class='country-item country-item-Maharashtra ']/div")
	public WebElement State;
	
	@FindBy(xpath="//div[@class='country-item country-item-Mumbai ']/div")
	public WebElement City;
	
	// Initializing the Page Objects:
	public ReviewPage() {
		PageFactory.initElements(driver, this);
	}

	public void ConfirmOrderWithBlankData()  {
		
		ConfirmOrderbtn.click();
		if (invalidText.size() > 0) {
			for (int i = 0; i < invalidText.size(); i++) {
				String Errormsg=invalidText.get(i).getText();
				System.out.println("The Error dispalyed is : "+Errormsg);
			}
		}
		
	}
	
	public ChainsCataloguePage RemovelnkClick(){
		Removelink.click();
		return new ChainsCataloguePage();
	}
	
	public void ConfirmSubmit(String Name, String Email, String Address1, String Strcountry, String strState, String strCity){
		txtName.sendKeys(Name);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		txtEmail.sendKeys(Email);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		txtaddress1.sendKeys(Address1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		txtcountry.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		enterCountry.sendKeys(Strcountry);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Country.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		txtState.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		enterCountry.sendKeys(strState);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		State.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		txtCIty.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		enterCountry.sendKeys(strCity);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		City.click();
		
		
		
	}
}
