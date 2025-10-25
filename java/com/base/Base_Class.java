package com.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;



public abstract class Base_Class {


	// BrowserName
	public static WebDriver driver;

	protected static WebDriver launchBrowser(String browserName) {

		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if(browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if(browserName.equalsIgnoreCase("firefox")) {

			}
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl(String url) {

		try {
			driver.get(url);
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE BROWSER URL LAUNCH");
		}
		return driver;
	}

	// Close

	protected static void browserTerminate () {
		try {
			driver.close();
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE BROWSER CLOSE THE WINDOW");
		}
	}

	//  Quit

	protected static void  browserTermination() {
		try {
			driver.quit();
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE BROWSER QUIT THE WINDOW");

		}

	}

	// SendKeys

	protected static void passInput(WebElement element, String value) {
		try {
			element.sendKeys(value);
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE VALUE PASSING");
		}
	}

	// Click

	protected static void elementClick(WebElement element) {
		try {
			element.click();
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE CLICK ELEMENT");
		}
	}

	// Waits

	protected static void wait (int value) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE WAITING");
		}
	}

	// Windows Handles
	protected static void windowHandles(int num) {

		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE WINDOWS HANDLING");
		}
	}

	// Get Title

	protected static void getTitle () {
		try {
			driver.getTitle();
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE GET TITLE METHOD");

		}
	} 

	// Get Url

	protected static void getUrl () {
		try {
			driver.getCurrentUrl();
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE NAVIGATE REFRESH GET CURRENT URL METHOD");
		}
	} 
	// Get Text & Get Attribute Method

	protected static void getAttribute (WebElement element, String value, String text, String values) {
		try {
			if(value.equalsIgnoreCase("gettext")) {
				text= element.getText();
				System.out.println("Text :"+text);
			}
			else if(value.equalsIgnoreCase("getattribute")) {
				text= element.getAttribute("Attribute :"+values);
				System.out.println(text);
			}

		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE GET ATTRIBUTE");}}

	// Navigate To
	
	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE NAVIGATE TO");
		}
	}
	// Navigate Back
	protected static void navigateBack() {
		try {
			driver.navigate().back();
		}catch (Exception e){
			Assert.fail("ERROR:OCCUR DURING THE NAVIGATE BACK");
		}
	}
	// Navigate Forward
	protected static void navigateForward() {
		try {
			driver.navigate().forward();
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE NAVIGATE FORWARD");
		}
	}
	// Navigate Refresh
	protected static void navigateRefresh() {
		try {
			driver.navigate().refresh();
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE NAVIGATE REFRESH");

		}
	}

	// Selected
	protected static void selectoptions(WebElement element, String value, String type) {
		try {
			Select select = new Select(element);
			if(type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);}
			else if(type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));}
			if(type.contentEquals("value")) {
				select.selectByValue(value);
			}
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE NAVIGATE REFRESH ");
		}}

	
	// Get Option
	protected static void getOptions(WebElement element)  {
		try {
			Select select = new Select(element);
			List<WebElement> allOptions = select.getOptions();
			for(WebElement option :allOptions) {
				System.out.println("List of options :"+option.getText());
			}
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE GETOPTIONS");

		}}
	// Drag &  Drop
	protected static void dragAndDrop(WebElement element,WebElement elements)  {
		try {
			Actions act = new Actions(driver);
			act.dragAndDrop(element, elements).perform();

		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE DRAG AND DROP");
		}
	}

	// Actions
	protected static void mouseOverActions(String value, WebElement element) {

		try {
			Actions act = new Actions(driver);
			if(value.equalsIgnoreCase("mouseover")) {
				act.moveToElement(element).perform();
			} else if(value.equalsIgnoreCase("doubleclick")) {
				act.doubleClick(element).perform();
			} else if(value.equalsIgnoreCase("rightclick")) {
				act.contextClick(element).perform();
			}
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE MOUSE OVER ACTION");
		}

	}
	// Robots
	protected static void keyBroadHandle(String actions, Robot robot) {

		try {
			if(actions.equalsIgnoreCase("down")) {
				robot.keyPress(KeyEvent.VK_DOWN);
			} else if(actions.equalsIgnoreCase("up")) {
				robot.keyPress(KeyEvent.VK_UP);
			} else if(actions.equalsIgnoreCase("enter")) {
				robot.keyPress(KeyEvent.VK_ENTER);
			}
		}catch (Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE KEYBROAD HANDLING");
		}

	}

	// TakeScreenshot
	protected static void takeScreenshot(String path) throws IOException  {
		try{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\Test\\eclipse-workspace\\Maven_Project\\Picture\\"+path);
			FileHandler.copy(src, dest);
		}catch(Exception e) {
			Assert.fail("ERROR:OCCUR DURING THE TAKESCREEN SHOT");

		}
	}
	// Alert 
		protected static void alert(String action,String value) {

			try {
				Alert alert = driver.switchTo().alert();

				switch (action.toLowerCase()) {
				case "accept":
					alert.accept();
					break;

				case "dismiss":
					alert.dismiss();
					break;

				case "gettext":
					System.out.println("Alert : " + alert.getText());
					break;
				default:
					System.out.println("Invalid alert  action: "+ action);
				}
			}catch (Exception e) {
				Assert.fail("ERROR:OCCUR DURING INVALID ALERT");
				}
		}
}








