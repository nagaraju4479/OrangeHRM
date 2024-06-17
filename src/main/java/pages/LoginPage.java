package pages;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericMethods.Elements;
import genericMethods.Wait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Locators
//	@FindBy(name="username") private WebElement userNameFld;
//	@FindBy(name="password") private WebElement passwordFld;
//	@FindBy(xpath = "//button[@type='submit']") private WebElement submitBtn;
	


	By userNameFld = By.name("username");
	By passwordFld = By.name("password");
	By loginBtn = By.cssSelector("button[type='submit']");
	
	
	//Methods
	public HomePage login(String userName, String password)
	{
		Elements.doSendKeys(driver, userNameFld, userName);
		Elements.doSendKeys(driver, passwordFld, password);
		Elements.doClick(driver, loginBtn);
		return new HomePage(driver);
		
	}

}
