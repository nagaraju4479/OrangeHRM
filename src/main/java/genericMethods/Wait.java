package genericMethods;

import java.time.Duration;

import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Script;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import freemarker.core.ReturnInstruction.Return;
import net.bytebuddy.asm.Advice.Local;
import pages.HomePage;


public class Wait {
	
	private static boolean bStatus;
	private WebDriverWait wait;
	
	public static boolean waitForElementPresence(WebDriver driver,By locator,Duration timeOut)
	{
		try {
						
			 new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));	
				
			bStatus = Verify.verifyElementVisible(driver, locator);
			if(bStatus)
			{
				return true;
			}
			
		} catch (NoSuchElementException e) {
			Messages.errorMsg = e.getMessage();
			System.out.println("Locator "+locator+" is not found due to :"+Messages.errorMsg);
			
		}
		return false;
	}
	
	
	public static boolean waitForCheckbox(WebDriver driver,By locator, Duration waitTime) {
		
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.presenceOfElementLocated(locator));
		bStatus = Verify.verifyCheckboxChecked(driver, locator);
		
		if(!bStatus)
		{
			try {
				
				return true;
				
			} catch (Exception e) {
				System.out.println("Exception is occured when checkbox is checked "+e);
				return false;
			}
			
			
		}
		return false;
		
		
	}
	
	
	
	public static void waitForPageLoad(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.waitTime);
				
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                } catch (Exception e) {
                    return false;
                }
            }
        };
        wait.until(pageLoadCondition);
	}
	
	
}
