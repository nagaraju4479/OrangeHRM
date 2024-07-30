package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class TransferFundsPage extends BasePage{

	public TransferFundsPage(WebDriver driver) {
		super(driver);
		
	}
	
	private final By amountFld= By.id("amount");
	private final By transferBtn =By.xpath("//input[@value='Transfer']");
	
	public void enterAmount(String amount) {
		Elements.doSendKeys(driver, amountFld, amount);
		Elements.doClick(driver, transferBtn);
		
	}

}
