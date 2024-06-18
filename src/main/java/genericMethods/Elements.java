package genericMethods;

import java.time.Duration;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.apache.logging.log4j.core.impl.ReusableLogEventFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


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
	
	public static WebElement getWebElement(WebDriver driver, By locator)
	{
		bStatus = Verify.verifyElementVisible(driver, locator);
		
		if(bStatus)
		{
			WebElement element =  driver.findElement(locator);
			return element;
			
		}
		Messages.errorMsg = locator+" is not visible and not used";
		System.out.println(Messages.errorMsg);
		return null;
		
			
	}
	
	public static List<WebElement> getWebElements(WebDriver driver , By locator) {
		
		bStatus = Verify.verifyElementVisible(driver, locator);
		if(bStatus)
		{
			List<WebElement>  listElements= driver.findElements(locator);
			return listElements;
		}
		Messages.errorMsg = locator+" is not visible and not used";
		System.out.println(Messages.errorMsg);	
		
		return null;
		
	}
	
	public static Boolean selectDropdownByVisibleText(WebDriver driver, By locator , String sText)
	{
		bStatus = Wait.waitForElementPresent(driver, locator);
		if(bStatus)
		{
		try {
			
			Select dropdown = new Select(Elements.getWebElement(driver, locator));
			dropdown.selectByVisibleText(sText);
			return true;
			
		} catch (Exception e) {
			Messages.errorMsg = "Exception occured while selecting the text :"+e.getMessage();
			System.out.println(Messages.errorMsg);
		}
		
		}
		return false;
		
		
	}
	
}
