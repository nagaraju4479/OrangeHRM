package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	private final By firstNameFld = By.id("customer.firstName");
	private final By lastNameFld = By.id("customer.lastName");
	private final By addressFld = By.id("customer.address.street");
	private final By cityFld = By.id("customer.address.city");
	private final By stateFld = By.id("customer.address.state");
	private final By zipCodeFld = By.id("customer.address.zipCode");
	private final By phoneNumberFld = By.id("customer.phoneNumber");
	private final By ssnFld = By.id("customer.ssn");
	private final By userNameFld = By.id("customer.username");
	private final By passwordFld = By.id("customer.password");
	private final By confirmPwdFld = By.id("repeatedPassword");
	private final By registerBtn = By.xpath("//input[@value='Register']");
	
	
	public LoginPage userRegistration(String firstName,String lastName,String address, String city,
			String state,String zipCode,String phoneNumber,String ssn,String userName,String password,
			String confirmPwd)
	{
		Elements.doSendKeys(driver, firstNameFld, firstName);
		Elements.doSendKeys(driver, lastNameFld, lastName);
		Elements.doSendKeys(driver, addressFld, address);
		Elements.doSendKeys(driver, cityFld, city);
		Elements.doSendKeys(driver, stateFld, state);
		Elements.doSendKeys(driver, zipCodeFld, zipCode);
		Elements.doSendKeys(driver, phoneNumberFld, phoneNumber);
		Elements.doSendKeys(driver, ssnFld, ssn);
		Elements.doSendKeys(driver,userNameFld,userName);
		Elements.doSendKeys(driver,passwordFld,password);
		Elements.doSendKeys(driver,confirmPwdFld,confirmPwd);
		Elements.jsDoClick(driver,registerBtn);
		return new LoginPage(driver);
		
	}
	
	public void loginToAPpliction(String username,String password)
	{
		
	}
	

}
