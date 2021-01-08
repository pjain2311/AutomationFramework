package com.framework.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.qa.base.TestBase;

public class ChainsCataloguePage extends TestBase{
	
	@FindBy(xpath = "//div[contains(text(),'On sale')]")
	WebElement OnsaleLink;
	
	@FindBy(xpath="//div[@class='discount-badge ']/span[\" + i + \"]")
	public List<WebElement> EarringsDetails;

	@FindBy(xpath="(//span[contains(text(),'ADD TO CART')])[1]")
	public WebElement addToCart;
	
	@FindBy(xpath="//div[@class='order-price']")
	public WebElement orderpriceText;
	
	@FindBy(xpath = "//div[@class='order-bar ']")
	public WebElement viewbasket;
	
	@FindBy(xpath = "//div[@class='name-input']/input")
	WebElement username;

	@FindBy(xpath = "//div[@class='send-button-phone']/img")
	WebElement usernameSent;

	@FindBy(xpath = "//div[@class='phone-input']/input")
	WebElement phonenumbertext;

	@FindBy(xpath = "//div[@class='send-button-phone']/img")
	WebElement phonenumberSent;
	
	// Initializing the Page Objects:
		public ChainsCataloguePage() {
			PageFactory.initElements(driver, this);
		}

		public void verifyclickOnFilter() {
			
			OnsaleLink.click();
			if (EarringsDetails.size() > 0) {
				for (int i = 0; i < EarringsDetails.size(); i++) {
					String Title=EarringsDetails.get(i).getText();
					System.out.println("The title of catalogue is : "+Title);
				}
			}
		}
		
		public ReviewPage AddToCart() throws InterruptedException
		{
			OnsaleLink.click();
			username.sendKeys("Pooja Babel");
			usernameSent.click();
			phonenumbertext.sendKeys("9158525334");
			phonenumberSent.click();
			Thread.sleep(5000);
			addToCart.click();
			String orderPrice=orderpriceText.toString();
			System.out.println("The Cost of the Selected Product is : "+orderPrice);
			viewbasket.click();
			
			return new ReviewPage();
		}
		
}
