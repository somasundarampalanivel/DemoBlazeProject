package com.pageobjectmodel;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.Base_Class;
import com.interfaceelements.AddressPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;


public class AddressPage extends Base_Class implements AddressPageInterfaceElements{
	
	@FindBy(xpath = name_xpath)
	private WebElement name;
	
	@FindBy(xpath = country_xpath)
	private WebElement country;
	
	@FindBy(xpath = city_xpath)
	private WebElement city;
	
	@FindBy(xpath = creditCard_xpath)
	private WebElement creditCard;
	
	@FindBy(xpath = month_xpath)
	private WebElement month;
	
	@FindBy(xpath = year_xpath)
	private WebElement year;

	@FindBy(xpath = purchase_xpath)
	private WebElement purchase;
	
	@FindBy(xpath = confirm_xpath)
	private WebElement confirm;
	
	@FindBy(xpath = logOut_xpath)
	private WebElement logOut;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validOrderClick() throws InterruptedException, IOException {
		wait(10);
		passInput(name, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("name"));
		passInput(country, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("country"));
		passInput(city, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("city"));
		passInput(creditCard, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("card"));
		passInput(month, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("month"));
		passInput(year, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("year"));
		elementClick(purchase);
		
	
		Thread.sleep(3000);
		takeScreenshot("OrderPlaced.png");
		elementClick(confirm);
		Thread.sleep(3000);
		elementClick(logOut);
		takeScreenshot("LogOut.png");
		
			
	}
}
