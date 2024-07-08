package genericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alert {

	private static boolean bStatus;

	public static Boolean acceptAlert(WebDriver driver, By locator) {

		bStatus = Wait.waitForAlertPresence(driver, Constants.maxWaitTime);
		if (bStatus) {
			
			driver.switchTo().alert().accept();
			return true;
		}
		return false;

	}

	public static Boolean dismissAlert(WebDriver driver, By locator) {

		bStatus = Wait.waitForAlertPresence(driver, Constants.maxWaitTime);
		if (bStatus) {

			driver.switchTo().alert().dismiss();
			return true;
		}
		return false;

	}

	public static String getAlertMessage(WebDriver driver, By locator) {

		bStatus = Wait.waitForAlertPresence(driver, Constants.maxWaitTime);
		if (bStatus) {

			String alertMessageText = driver.switchTo().alert().getText();
			return alertMessageText;
		}
		return null;

	}

}
