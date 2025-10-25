package com.runner;
import java.io.IOException;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class TestRunner extends Base_Class{
	public static void main(String [] args) throws InterruptedException, IOException {
		launchBrowser(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		launchUrl(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
		PageObjectManager.getPageObjectManager().getLoginPage().validLoginPage();
		PageObjectManager.getPageObjectManager().getSearchProduct().validLaptopClick();
		PageObjectManager.getPageObjectManager().getAddressProduct().validOrderClick();
	}
}
