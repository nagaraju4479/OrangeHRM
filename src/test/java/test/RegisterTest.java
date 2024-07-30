package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AccountServicesPage;
import pages.LoginPage;
import pages.PayBillPage;
import pages.RegisterPage;
import pages.TransferFundsPage;

@Listeners(TestListener.class)
public class RegisterTest extends BaseTest {

	
	  @Test public void registerTest() {
	  
	  RegisterPage registerPage = new RegisterPage(driver);
	  
	  registerPage.userRegistration(properties.getProperty("firstName"),
	  properties.getProperty("lastName"), properties.getProperty("address"),
	  properties.getProperty("city"), properties.getProperty("state"),
	  properties.getProperty("zipCode"), properties.getProperty("phone"),
	  properties.getProperty("SSN"), properties.getProperty("usuername"),
	  properties.getProperty("password"), properties.getProperty("confirm"));
	  
	  }
	 

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(properties.getProperty("usuername"), properties.getProperty("password"));

	}

	@Test
	public void transferFund() {
		LoginPage loginPage = new LoginPage(driver);
		AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
		TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
		loginPage.loginToApplication(properties.getProperty("usuername"), properties.getProperty("password"));
		accountServicesPage.transferFund();
		transferFundsPage.enterAmount(properties.getProperty("amount"));
	}

	@Test
	public void billPay() {
		LoginPage loginPage = new LoginPage(driver);
		AccountServicesPage accountServicesPage = new AccountServicesPage(driver);
		PayBillPage payBillPage = new PayBillPage(driver);
		loginPage.loginToApplication(properties.getProperty("usuername"), properties.getProperty("password"));
		accountServicesPage.billPay();
		payBillPage.payBill(properties.getProperty("payeeName"), properties.getProperty("payeeAddress"),
				properties.getProperty("payeeCity"), properties.getProperty("payeeState"),
				properties.getProperty("payeeZipCode"), properties.getProperty("payeePhone"),
				properties.getProperty("payyeAccount"), properties.getProperty("payyeVerifyAccount"),
				properties.getProperty("payeeAmount"));

	}

}
