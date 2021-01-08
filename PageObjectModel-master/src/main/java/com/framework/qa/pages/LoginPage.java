package com.framework.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//div[@class='name-input']/input")
	WebElement username;

	@FindBy(xpath = "//div[@class='send-button-phone']/img")
	WebElement usernameSent;

	@FindBy(xpath = "//div[@class='phone-input']/input")
	WebElement phonenumbertext;

	@FindBy(xpath = "//div[@class='send-button-phone']/img")
	WebElement phonenumberSent;

	// Initializing the Page Objects:
	public LoginPage() {
			PageFactory.initElements(driver, this);
		}

	public HomePage login(String un, String mob) {
		username.sendKeys(un);
		usernameSent.click();
		phonenumbertext.sendKeys(mob);
		phonenumberSent.click();

		return new HomePage();
	}

}
