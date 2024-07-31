package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By productPageName = By.xpath("//span[text()='Products']");
	private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
	private By removeBtn = By.id("remove-sauce-labs-backpack");
	private By sauceLabsLink = By.id("item_4_title_link");
	private By cartLink=By.xpath("//a[@class=\"shopping_cart_link\"] ");

	public String getProductPageName(WebDriver driver) {
		return Elements.getText(driver, productPageName);

	}
	public ProductPage addToCart() {
		Elements.jsDoClick(driver, addToCartBtn);
		return this;
	}

	public void clickSauceLabsLink() {
		Elements.doClick(driver, sauceLabsLink);
	}

	public String getRemovebtnText(WebDriver driver) {
		return Elements.getText(driver, removeBtn);
	}
	
	public CartPage clickCartIcon() {
		Elements.doClick(driver, cartLink);
		return new CartPage(driver);
	}

}
