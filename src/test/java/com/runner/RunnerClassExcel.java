package com.runner;

import java.io.IOException;
import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;


public class RunnerClassExcel extends Base_Class {
	public static void main(String[] args ) throws InterruptedException, IOException {
		launchBrowser(PageObjectManager.getPageObjectManager().getReadExcelData().getParticularData(1,0));
		launchUrl(PageObjectManager.getPageObjectManager().getReadExcelData().getParticularData(1,1));
		PageObjectManager.getPageObjectManager().getYoutubeSearchPage().validSearchclick();
	}
}
