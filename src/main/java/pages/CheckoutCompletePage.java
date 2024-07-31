package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
private By checkoutCompleteText =By.xpath("//span[text()='Checkout: Complete!'] ");
private By backHomeBtn=By.id("back-to-products");
}
