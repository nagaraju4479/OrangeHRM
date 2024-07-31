package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
private By finishBtn =By.id("finish");
private By cancelBtn =By.id("cancel");
private By CheckOutOverviewText =By.xpath("//span[text()='Checkout: Overview'] ");
}
