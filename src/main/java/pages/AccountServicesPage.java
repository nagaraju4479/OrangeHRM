package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class AccountServicesPage extends BasePage {

	public AccountServicesPage(WebDriver driver) {
		super(driver);
	}
	
//	private final By accountServicesText =By.xpath("//h1[text()='Welcome Surya']");
//	String	actualText =driver.findElement(accountServicesText).getText();
	private final By transferFundLink=By.xpath("//a[normalize-space()='Transfer Funds']");
	
	 private final By billPayLink =By.xpath("//a[normalize-space()='Bill Pay']");
		
	
 
	
	public TransferFundsPage transferFund() {
		
		 Elements.jsDoClick(driver,transferFundLink);
		 return new TransferFundsPage(driver);
	}
	
	public PayBillPage billPay() {
		Elements.doClick(driver, billPayLink);
		return new PayBillPage(driver);
	}
	

}
