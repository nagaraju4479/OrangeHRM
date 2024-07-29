package elementUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Elements {

	private static boolean bStatus;

	public static boolean doClick(WebDriver driver, By locator) {
		bStatus = Wait.waitForButtonToBeClickable(driver, locator, Constants.maxWaitTime);
		if (bStatus) {
			driver.findElement(locator).click();
			return true;
		} else {
			System.out.println("Locator " + locator + " was not available for click");
			return false;
		}
	}

	public static boolean jsDoClick(WebDriver driver, By locator) {
		bStatus = Wait.waitForElementPresence(driver, locator, Constants.maxWaitTime);
		if (bStatus) {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", getWebElement(driver, locator));
			return true;
		} else {
			System.err.println("Locator " + locator + " was not available for click");
			return false;
		}
	}

	public static boolean doSendKeys(WebDriver driver, By locator, String inputText) {
		bStatus = Wait.waitForElementPresence(driver, locator, Constants.maxWaitTime);
		if (bStatus) {
			driver.findElement(locator).sendKeys(inputText);
			
			return true;
		} else {
			System.err.println("Text field " + locator + " was not present.");
			return false;
		}
	}

	public static boolean jsSendKeys(WebDriver driver,By locator, String inputText) {
		bStatus = Wait.waitForElementPresence(driver, locator, Constants.minWaitTime);
		if (bStatus) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].value = arguments[1];", getWebElement(driver, locator),inputText);
			return true;
			
		}
		else {
			System.err.println("Text field " + locator + " was not present.");
			return false;
		}
		
	}

	public static WebElement getWebElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		return element;

	}

	

	public static boolean turnOnToggle(WebDriver driver, By locator) {
		Wait.waitForToggleButtonPresence(driver, locator, Constants.maxWaitTime);
		bStatus = driver.findElement(locator).isEnabled();
		if (!bStatus) {
			doClick(driver, locator);
			return true;
		} else {
			return false;
		}

	}

	public static boolean turnOffToggle(WebDriver driver, By locator) {
		Wait.waitForToggleButtonPresence(driver, locator, Constants.maxWaitTime);
		bStatus = driver.findElement(locator).isEnabled();
		if (bStatus) {
			doClick(driver, locator);
			return true;
		} else {
			return false;
		}

	}
	
	public static String getText(WebDriver driver , By locator)
	{
		Wait.waitForToggleButtonPresence(driver, locator, Constants.maxWaitTime);
	 return	driver.findElement(locator).getText();
		
	}

}
