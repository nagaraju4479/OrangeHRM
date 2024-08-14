package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Reports.ExtentReportUtils;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

public class CartPageTest extends BaseTest {
	
	@Test
	public void removeItemFromCart()
	{
		LoginPage loginPage = new LoginPage(driver);
		ProductPage productPage = new ProductPage(driver);
		CartPage cartPage = new CartPage(driver);
		loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
		try {
			Assert.assertEquals(productPage.getProductPageName(driver), properties.getProperty("productPageName"));
			ExtentReportUtils.logPass("Login successful and navigated to product page");
		} catch (AssertionError e) {
			Assert.fail("Product page  text did not match: " + properties.getProperty("productPageName"));
			ExtentReportUtils.logFail("Unable to login " + e.getMessage());
			throw e;
		}
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
		productPage.clickCartIcon();
		try {
			Assert.assertEquals(cartPage.getYourCartText(),properties.getProperty("yourCartText"));
			 ExtentReportUtils.logPass("The product is added successfully");
		}catch (AssertionError e) {
			Assert.fail("Your cart text did not match: " + properties.getProperty("removeButtonText"));
	        ExtentReportUtils.logFail("Unable to add product "+e.getMessage());
	        throw e;
		}
		
		int actualItemCountinCart = cartPage.countOfItemsInCart();
		System.out.println("Acutal count:"+ actualItemCountinCart);
		cartPage.removeItem();
		int expectedItemCountinCart = cartPage.countOfItemsInCart();
		System.out.println("Expected count:"+expectedItemCountinCart);
		Assert.assertEquals(actualItemCountinCart - 1, expectedItemCountinCart);
		
		
	}

}
