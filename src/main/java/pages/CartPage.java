package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elementUtils.Elements;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By checkoutBtn =By.id("checkout");
	private By backPackRemoveBtn =By.id("remove-sauce-labs-backpack");
	private By continueShoppingBtn =By.id("continue-shopping");
	private By yourCartText =By.xpath("//span[text()='Your Cart']");
	private By itemsInCart = By.xpath("//div[@class='cart_item']");
	
	private By cartIconButton =By.xpath("//a[@class='shopping_cart_link']");
	
	public String getcartIconButtonText() {
		return Elements.getText(driver, cartIconButton);
	}
	
	public String getYourCartText() {
		return Elements.getText(driver, yourCartText);
	}
	
	public int countOfItemsInCart()
	{
		 List<WebElement> elementsInCart =  driver.findElements(itemsInCart);
		 return elementsInCart.size();
		 
	}
	
	public void removeItem() {
		Elements.doClick(driver, backPackRemoveBtn);
	}
	
	
}
