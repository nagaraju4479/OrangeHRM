package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//input[@value='Log In']");
	
	public AccountServicesPage loginToApplication(String uName,String pwd)
	{
		Elements.doSendKeys(driver, userName, uName);
		Elements.doSendKeys(driver, password, pwd);
		Elements.doClick(driver, loginBtn);
		return new AccountServicesPage(driver);
	
	}

}
