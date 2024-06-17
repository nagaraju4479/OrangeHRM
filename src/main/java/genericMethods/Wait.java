package genericMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait {
	
	private static boolean bStatus;
	
	public static boolean waitForElementPresence(WebDriver driver,By locator,Duration timeOut)
	{
		try {
						
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
				
			bStatus = Verify.verifyElementVisible(driver, locator);
			if(bStatus)
			{
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Locator "+locator+" is not found");
			
		}
		return false;
	}
	
	
	
	
	
}
