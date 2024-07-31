package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reports.ExtentReportUtils;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductPage;
@Listeners(TestListener.class)
public class ProductDetailsTest extends BaseTest{
	
	@Test
	public void addProductSauceLabsBackPack() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		ProductPage productPage = new ProductPage(driver);
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		try {
	        Assert.assertEquals(productPage.getProductPageName(driver), properties.getProperty("productPageName"));
	        ExtentReportUtils.logInfo("Login successful and navigated to product page");
	    } catch (AssertionError e) {
	    	Assert.fail("Product page  text did not match: " + properties.getProperty("productPageName"));
	        ExtentReportUtils.logFail("Unable to login "+e.getMessage());
	        throw e; // Re-throw the assertion error to ensure the test fails
	    }
		
		productPage.clickSauceLabsLink();
		try {
	        Assert.assertEquals(productDetailsPage.getbackToProductText(driver), properties.getProperty("backToProductText"));
	        ExtentReportUtils.logInfo("The uesr should be navigated to productDetailspage");
	    } catch (AssertionError e) {
	    	Assert.fail("Back to product text did not match: " + properties.getProperty("backToProductText"));
	        ExtentReportUtils.logFail("Unable to click link "+e.getMessage());
	        throw e;
	    }
		productDetailsPage.addProductToCart();
		Thread.sleep(5000);
		try {
	        Assert.assertEquals(productDetailsPage.getpdRemoveBtnText(driver), properties.getProperty("pdRemoveBtnText"));
	        ExtentReportUtils.logInfo("The product added successfully");
	    } catch (AssertionError e) {
	    	Assert.fail("Remove button text did not match: " + properties.getProperty("pdRemoveBtnText"));
	        ExtentReportUtils.logFail("Unable to add product "+e.getMessage());
	        throw e;
	    }
		

}
}
