package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.AddHasCasting;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest{
		
	@Test
	public void loginTest()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
	}

}
