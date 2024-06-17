package genericMethods;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
	
	private static boolean bStatus;
	
	
	public static boolean verifyElementVisible(WebDriver driver,By locator)
	{
		try {
			bStatus = driver.findElement(locator).isDisplayed();
			return true;
			
		} catch (Exception e) {
			System.out.println("Locator"+locator+" is not displayed");
		}
		return false;
	}

}
