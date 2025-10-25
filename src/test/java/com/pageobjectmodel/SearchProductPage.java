package com.pageobjectmodel;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.Base_Class;
import com.interfaceelements.SearchProductAndAddToCardInterfaceElements;

public class SearchProductPage extends Base_Class implements SearchProductAndAddToCardInterfaceElements{

	@FindBy(xpath = laptop_xpath)
	private WebElement laptop;
	
	@FindBy(xpath = sony_xpath)
	private WebElement sony;
	
	@FindBy(xpath = addToCard_xpath)
	private WebElement addToCard;
	
	@FindBy(xpath = card_xpath)
	private WebElement card;
	
	@FindBy(xpath = placeOrder_xpath)
	private WebElement placeOrder;
	
	public SearchProductPage() {
		PageFactory.initElements(driver, this);
	}
	public void validLaptopClick() throws InterruptedException, IOException {
		wait(10);
		elementClick(laptop);
		elementClick(sony);
		wait(10);
		elementClick(addToCard);
		Thread.sleep(3000);
		alert("getText", "null");
		alert("accept", "null");
		elementClick(card);
		Thread.sleep(3000);
		takeScreenshot("AddToCard.png");
		elementClick(placeOrder);
		
	}
}
