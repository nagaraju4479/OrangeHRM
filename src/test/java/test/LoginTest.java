package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reports.ExtentReportUtils;
import pages.HomePage;
import pages.LoginPage;


@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));		
		try {
	        Assert.assertEquals(homePage.getDashboradText(), "Dashboard");
	        ExtentReportUtils.logPass("Login successful and navigated to Dashboard");
	    } catch (AssertionError e) {
	        ExtentReportUtils.logFail("Dashboard text did not match: " + e.getMessage());
	        throw e; // Re-throw the assertion error to ensure the test fails
	    }
		
	}
	
	@Test
	public void loginTest123() {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));		
		try {
	        Assert.assertEquals(homePage.getDashboradText(), "Dashboard123");
	        ExtentReportUtils.logPass("Login successful and navigated to Dashboard");
	    } catch (AssertionError e) {
	        ExtentReportUtils.logFail("Dashboard text did not match: " + e.getMessage());
	        throw e; // Re-throw the assertion error to ensure the test fails
	    }
		
	}
	
	

}
