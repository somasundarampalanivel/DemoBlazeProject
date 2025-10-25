package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;


public class LoginPage extends Base_Class implements LoginPageInterfaceElements {
	@FindBy(id= login_id)
	private WebElement login;
	
	@FindBy(css = userid_css)
	private WebElement username;
	
	@FindBy(css = password_css)
	private WebElement password;
	
	@FindBy(xpath = signin_xpath)
	private WebElement signin;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void validLoginPage() throws InterruptedException, IOException {
		elementClick(login);
		
		wait(10);
		
		passInput(username, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
		
		passInput(password, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		
		elementClick(signin);
		
		Thread.sleep(3000);
		
		takeScreenshot("Login.png");
		
	}

}
