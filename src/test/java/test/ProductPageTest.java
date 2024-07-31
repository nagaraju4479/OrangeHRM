package test;

import java.security.PublicKey;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reports.ExtentReportUtils;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductPage;
@Listeners(TestListener.class)
public class ProductPageTest extends BaseTest{
	
	@Test
	public void addProductToCart() {
		LoginPage loginPage = new LoginPage(driver);
		ProductPage productPage = new ProductPage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		
		productPage.addToCart();
		try {
	        Assert.assertEquals(productPage.getRemovebtnText(driver), properties.getProperty("removeButtonText"));
	        System.out.println(productPage.getRemovebtnText(driver));
	        ExtentReportUtils.logPass("The product is added successfully");
	    } catch (AssertionError e) {
	    	Assert.fail("Remove button text did not match: " + properties.getProperty("removeButtonText"));
	        ExtentReportUtils.logFail("Unable to add product "+e.getMessage());
	        throw e;
	    }
	}
	@Test(enabled = false)
	public void addProductSauceLabsBackPack() {
		LoginPage loginPage = new LoginPage(driver);
		ProductPage productPage = new ProductPage(driver);
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		productPage.clickSauceLabsLink();
		try {
	        Assert.assertEquals(productDetailsPage.getbackToProductText(driver), properties.getProperty("backToProductText"));
	       System.out.println(productDetailsPage.getbackToProductText(driver));
	        ExtentReportUtils.logPass("The product is added successfully");
	    } catch (AssertionError e) {
	    	Assert.fail("Back to product text did not match: " + properties.getProperty("backToProductText"));
	        ExtentReportUtils.logFail("Unable to add product "+e.getMessage());
	        throw e;
	    }
	}
		

		
	
		
		
	

}
