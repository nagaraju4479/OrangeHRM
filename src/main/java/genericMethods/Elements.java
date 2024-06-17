package genericMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Elements {
	
	private static boolean bStatus;
	
	public static boolean doClick(WebDriver driver,By locator)
	{
		bStatus = Wait.waitForElementPresence(driver, locator, Duration.ofSeconds(60));
		
		try {
			if(bStatus)
			{
				driver.findElement(locator).click();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
	return false;
	}
	
	public static boolean doSendKeys(WebDriver driver,By locator, String inputValue)
	{
		bStatus = Wait.waitForElementPresence(driver, locator, Duration.ofSeconds(60));
		try {
			
			if(bStatus)
			{
				driver.findElement(locator).sendKeys(inputValue);
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}

}
