package com.pageobjectmanager;
import com.pageobjectmodel.AddressPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchProductPage;
import com.pageobjectmodel.YoutubeSearchPage;
import com.utility.FileReaderManager;
import com.utility.ReadExcelData;
public class PageObjectManager {
	private LoginPage loginPage;
	private FileReaderManager fileReader;
	private static PageObjectManager pageObjectManager;
	private SearchProductPage searchProduct;
	private AddressPage orderedProduct;
	private ReadExcelData readExcelData;
	private YoutubeSearchPage youtubeSearchPage;

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}return loginPage;

	}
	public FileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new FileReaderManager();
		}return fileReader;

	}
	public static PageObjectManager getPageObjectManager() {
		if (pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();
		}return pageObjectManager;
	}
	public SearchProductPage getSearchProduct() {
		if (searchProduct == null) {
			searchProduct = new SearchProductPage();
		}return searchProduct;
	}
	public AddressPage getAddressProduct() {
		if (orderedProduct == null) {
			orderedProduct = new AddressPage();
		}return orderedProduct;
	}
	public ReadExcelData getReadExcelData() {
		if (readExcelData == null) {
			readExcelData = new ReadExcelData();
		}return readExcelData;
	}
	
	public YoutubeSearchPage getYoutubeSearchPage() {
		if (youtubeSearchPage == null) {
			youtubeSearchPage = new YoutubeSearchPage();
		}return youtubeSearchPage;
		
	}
}
	


