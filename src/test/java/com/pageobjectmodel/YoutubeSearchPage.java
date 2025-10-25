package com.pageobjectmodel;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.Base_Class;
import com.interfaceelements.SearchPageInterface;
import com.pageobjectmanager.PageObjectManager;

public class YoutubeSearchPage extends Base_Class implements SearchPageInterface {
	@FindBy(xpath = search_xpath)
	private WebElement search;

	@FindBy(xpath = searchButton_xpath)
	private WebElement searchButton;

	public YoutubeSearchPage() {
		PageFactory.initElements(driver, this);
	}
	public void validSearchclick() throws IOException, InterruptedException {
		wait(10);
		passInput(search, PageObjectManager.getPageObjectManager().getReadExcelData().getParticularData(1,2));
		wait(10);
		
		elementClick(searchButton);
		Thread.sleep(3000);
		takeScreenshot("YouTube.png");
		Thread.sleep(6000);
		browserTerminate();
	}

}


