package elementUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait {

	
	
	 public static boolean waitForElementPresence(WebDriver driver, By locator, Duration timeOut) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, timeOut);
	            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	            return Verify.verifyElementVisible(driver, locator);
	        } catch (TimeoutException e) {
	            System.err.println("Locator " + locator + " is not found within the timeout period.");
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	        return false;
	    }

	    // Wait for a button to be 
	    public static boolean waitForButtonToBeClickable(WebDriver driver, By locator, Duration timeOut) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, timeOut);
	            wait.until(ExpectedConditions.elementToBeClickable(locator));
	            return Verify.verifyElementVisible(driver, locator);
	        } catch (TimeoutException e) {
	            System.err.println("Button " + locator + " is not clickable within the timeout period.");
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	        return false;
	    }

	    // Wait for a text field to be present and visible
	    public static boolean waitForTextFieldPresence(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

	    // Wait for a dropdown to be present and visible
	    public static boolean waitForDropdownPresence(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

	    // Wait for a checkbox to be present and visible
	    public static boolean waitForCheckboxPresence(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

	    // Wait for an image to be present and visible
	    public static boolean waitForImagePresence(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

	    // Wait for a toggle button to be present and visible
	    public static boolean waitForToggleButtonPresence(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

	    // Wait for a table to be present and visible
	    public static boolean waitForTablePresence(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

	    public static boolean waitForWindowPresense(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

	    // Wait for an alert to be present
	    public static boolean waitForAlertPresence(WebDriver driver, Duration waitTime) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver,waitTime);
	            wait.until(ExpectedConditions.alertIsPresent());
	            return true;
	        } catch (TimeoutException e) {
	            System.err.println("Alert is not found within the timeout period.");
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	        }
	        return false;
	    }

	    // Wait for a calendar to be present and visible
	    public static boolean waitForCalendarPresence(WebDriver driver, By locator, Duration timeOut) {
	        return waitForElementPresence(driver, locator, timeOut);
	    }

}