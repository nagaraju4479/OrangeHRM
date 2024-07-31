package elementUtils;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.BiDiSessionStatus;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.support.ui.Select;

public class Verify {

	// Element visibility

	private static boolean bStatus;

	public static boolean verifyElementVisible(WebDriver driver, By locator) {

		try {
			WebElement element = driver.findElement(locator);
			return element.isDisplayed();

		} catch (NoSuchElementException e) {
			System.out.println("Locator " + locator + " is not visible");
			return false;

		}

	}

	 // Verify if a button is visible
    public static boolean verifyButtonVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }

    // Verify if a text field is visible
    public static boolean verifyTextFieldVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }

    // Verify if a dropdown is visible
    public static boolean verifyDropdownVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }

    // Verify if a checkbox is visible
    public static boolean verifyCheckboxVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }

    // Verify if an image is visible
    public static boolean verifyImageVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }

    // Verify if a toggle button is visible
    public static boolean verifyToggleButtonVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }

    // Verify if a table is visible
    public static boolean verifyTableVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }

    // Verify if a window with a specific title is present
    public static boolean verifyWindowPresent(WebDriver driver, String windowTitle) {
        try {
        	
            return driver.getTitle().contains(windowTitle);
        } catch (Exception e) {
            System.err.println("Window with title " + windowTitle + " is not present: " + e.getMessage());
        }
        return false;
    }

    // Verify if an alert is present
    public static boolean verifyAlertPresent(WebDriver driver) {
        try {
           Alert alert = driver.switchTo().alert();
            return alert != null;
        } catch (NoAlertPresentException e) {
            System.err.println("Alert is not present: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        return false;
    }

    // Verify if a calendar is visible
    public static boolean verifyCalendarVisible(WebDriver driver, By locator) {
        return verifyElementVisible(driver, locator);
    }
}
	
	


	// Toggle button enable or disabled

	