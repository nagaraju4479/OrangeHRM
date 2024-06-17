package genericMethods;

import java.time.Duration;
import java.util.DoubleSummaryStatistics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Elements {
	
	private static boolean bStatus;
	
	public static boolean doClick(WebDriver driver,By locator)
	{
		bStatus = Wait.waitForElementPresence(driver, locator,Constants.maxWaitTime );
		
		if(bStatus) {
			try {
				
				driver.findElement(locator).click();
				return true;
				
			} catch (Exception e) {
				
				Messages.errorMsg = e.getMessage();				
				System.out.println("Unable to click on"+locator+" due to "+Messages.errorMsg);
								
			}
		}
		return false;
	}
	
	public static boolean doSendKeys(WebDriver driver,By locator, String inputValue,Duration waitTime)
	{
		bStatus = Wait.waitForElementPresence(driver, locator,waitTime);
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
	
	public static boolean checkCheckbox(WebDriver driver, By locator)
	{
		bStatus = Wait.waitForCheckbox(driver, locator, Constants.maxWaitTime);
		
		if(bStatus)
		{
			try {
				doClick(driver, locator);
				return true;
			} catch (Exception e) {
				Messages.errorMsg = e.getMessage();
				System.out.println("Unable checking the checkbox due to: "+Messages.errorMsg);
			}
			
		}
		
		return false;
	}

	
	public static boolean uncheckCheckbox(WebDriver driver, By locator)
	{
		bStatus = checkCheckbox(driver, locator);		
		
		if(!bStatus)
		{
			try {
				doClick(driver, locator);
				return true;
			} catch (Exception e) {
				Messages.errorMsg = e.getMessage();
				System.out.println("unchecking the checkbox due to :"+Messages.errorMsg);
			}
			
		}
		
		return false;
	}
}
