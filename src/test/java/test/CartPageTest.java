package test;

import org.testng.Assert;
import org.testng.annotations.Test;

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
		productPage.addToCart();
		productPage.clickCartIcon();
		int actualItemCountinCart = cartPage.countOfItemsInCart();
		System.out.println("Acutal count:"+ actualItemCountinCart);
		cartPage.removeItem();
		int expectedItemCountinCart = cartPage.countOfItemsInCart();
		System.out.println("Expected count:"+expectedItemCountinCart);
		Assert.assertEquals(actualItemCountinCart - 1, expectedItemCountinCart);
		
		
	}

}
