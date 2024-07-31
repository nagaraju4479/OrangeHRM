package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutAddressPage extends BasePage{

	public CheckOutAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By firstNameFld=By.id("first-name");
	private By lastNameFld =By.id("last-name");
	private By postalCodeFld=By.id("postal-code");
	private By cancelBtn =By.id("cancel");
	private By continueFld =By.id("continue");
	private By checkoutInformationText=By.xpath("//span[text()='Checkout: Your Information'] ");
	

}
