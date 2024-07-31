package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private By addToCartBtn=By.id("add-to-cart");
	private By backToProductText =By.id("back-to-products");
	private By pdRemoveBtn=By.xpath("//button[text()='Remove']");
	
	public String getbackToProductText(WebDriver driver) {
		 return Elements.getText(driver, backToProductText);
	}
	
	public ProductDetailsPage addProductToCart() {
		Elements.doClick(driver, addToCartBtn);
		return this;
	}
	
	public String getpdRemoveBtnText(WebDriver driver) {
	return	Elements.getText(driver, pdRemoveBtn);
	}
	

}
