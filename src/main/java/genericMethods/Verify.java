package genericMethods;

import java.util.List;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.BiDiSessionStatus;
import org.openqa.selenium.support.ui.Select;

public class Verify {

	// Element visibility

	private static boolean bStatus;

	public static boolean verifyElementVisible(WebDriver driver, By locator) {
		bStatus = driver.findElement(locator).isDisplayed();
		
		if(bStatus)
		{
			return true;
		}
		
		Messages.errorMsg = locator+" Not visible";
		System.out.println(Messages.errorMsg);
		return false;
		
		
		
	}

	public static boolean verifyTextVisible(WebDriver driver, String sText) {
		bStatus = driver.getPageSource().contains(sText);
		if (bStatus) {

			try {
				return true;
			} catch (Exception e) {
				Messages.errorMsg = e.getMessage();
				System.out.println(sText + " is not available in page source" + Messages.errorMsg);

			}
			return false;
		}
		return false;
	}

	public static boolean verifyTextVisible(WebDriver driver, By locator, String sText) {

		bStatus = verifyElementVisible(driver, locator);
		if (!bStatus) {
			System.out.println("Element " + locator + " is not found");
			return false;
		}

		bStatus = driver.findElement(locator).getText().contains(sText);
		if (bStatus) {
			try {

				return true;

			} catch (Exception e) {

				Messages.errorMsg = e.getMessage();
				System.out.println(locator + " Text is not equals to: " + sText);
				return false;
			}

		}
		return false;

	}

	// CheckBox

	public static boolean verifyCheckboxChecked(WebDriver driver, By locator) {
		bStatus = verifyElementVisible(driver, locator);
		if (!bStatus) {
			System.out.println("Check box has not be checked because " + Messages.errorMsg);
			return false;
		}

		bStatus = driver.findElement(locator).isSelected();

		if (bStatus) {
			try {

				return true;

			} catch (Exception e) {

				System.out.println(locator + " is not checked");
				return false;

			}
		}

		return false;

	}
	
	//Toggle button enable or disabled
	
	public static boolean isEnabled(WebDriver driver,By locator) {
		
		bStatus=verifyElementVisible(driver, locator);
		if(!bStatus)
		{
			Messages.errorMsg = locator+" is not visiable";
			return false;
		}
		
		bStatus = driver.findElement(locator).isEnabled();
		if(bStatus)
		{
			return true;
		}
		Messages.errorMsg = "Element is not enabled";
		return false;
	}
	
	
	//Dropdowns
	
	public static Boolean  verifyElementPresent(WebDriver driver , By locator , String sText) {
		
		
		Select select = new Select(Elements.getWebElement(driver, locator));
		List<WebElement> list = select.getOptions();
		
		for (WebElement webElement : list) {
			
			if(webElement.getText().equals(sText))
			{
				return true;
			}			
			
		}
		Messages.errorMsg = sText+"Is not present in "+locator;
		System.out.println(Messages.errorMsg);
		return false;
	}
	
	

}
