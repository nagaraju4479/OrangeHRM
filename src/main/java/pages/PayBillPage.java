package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class PayBillPage extends BasePage{

	public PayBillPage(WebDriver driver) {
		super(driver);
	}
 private final By payeeNameFld =By.name("payee.name");
 private final By addressFldBy=By.name("payee.address.street");
 private final By cityFld = By.xpath("//input[@name='payee.address.city']");
 private final By stateFld =By.xpath("//input[@name='payee.address.state']");
 private final By zipCodeFld=By.xpath("//input[@name='payee.address.zipCode']");
 private final By phoneFld =By.cssSelector("input[id='23946e3e-0e29-4a55-9b27-8718ee32aea0']");
 private final By accountFld =By.xpath("//input[@name='payee.accountNumber']");
 private final By verifyAccountFld=By.xpath("//input[@name='verifyAccount']");
 private final By amountFld =By.xpath("//input[@name='amount']");
 private final By sendPaymentFld =By.xpath("//tbody/tr[14]/td[2]");
 
 public void payBill(String payeeName,String address,String city,String state,String zipCode,String phoneNo,String account,
		 String verifyAccount,String amount) {
	 Elements.doSendKeys(driver, payeeNameFld, payeeName);
	 Elements.doSendKeys(driver,addressFldBy, address);
	 Elements.doSendKeys(driver, cityFld, city);
	 Elements.jsSendKeys(driver, stateFld, state);
	 Elements.doSendKeys(driver, zipCodeFld, zipCode);
	 Elements.jsSendKeys(driver, phoneFld, phoneNo);
	 Elements.doSendKeys(driver, accountFld, account);
	 Elements.doSendKeys(driver, verifyAccountFld, verifyAccount);
	 Elements.doSendKeys(driver, amountFld, amount);
	 Elements.doClick(driver, sendPaymentFld);

 }

}
