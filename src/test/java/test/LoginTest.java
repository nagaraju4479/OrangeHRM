package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reports.ExtentReportUtils;

import pages.LoginPage;
import pages.ProductPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);

		ProductPage productPage = new ProductPage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		try {
			Assert.assertEquals(productPage.getProductPageName(driver), properties.getProperty("productPageName"));
			ExtentReportUtils.logPass("Login successful and navigated to product page");
		} catch (AssertionError e) {
			Assert.fail("Product page  text did not match: " + properties.getProperty("productPageName"));
			ExtentReportUtils.logFail("Unable to login " + e.getMessage());
			throw e; // Re-throw the assertion error to ensure the test fails
		}

	}

	

}
