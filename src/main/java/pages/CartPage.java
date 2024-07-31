package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By checkoutBtn =By.id("checkout");
	private By removeBtn =By.id("remove-sauce-labs-backpack");
	private By continueShoppingBtn =By.id("continue-shopping");
	private By yourCartText =By.xpath("//span[text()='Your Cart']");
	
	
}
