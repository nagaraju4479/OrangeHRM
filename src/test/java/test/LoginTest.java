package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.AddHasCasting;
import org.testng.annotations.Test;

import genericMethods.Constants;
import pages.LoginPage;

public class LoginTest extends BaseTest{
		
//	@Test
//	public void loginTest()
//	{
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"),Constants.waitTime);
//	}
	
	@Test
	public void checkBoxTest() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.checkboxCheck(Constants.waitTime);
		
	Thread.sleep(5000);
	loginPage.uncheckCheckBox(Constants.waitTime);
		
	
	}
	
	
}
