package pages;

import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericMethods.Elements;
import genericMethods.Verify;
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
	
	By checkBox = By.id("englishchbx");
	
	
	//Methods
	public HomePage login(String userName, String password, Duration waitTime)
	{
		Elements.doSendKeys(driver, userNameFld, userName,waitTime);
		Elements.doSendKeys(driver, passwordFld, password,waitTime);
		Elements.doClick(driver, loginBtn);
		return new HomePage(driver);
		
	}
	
	public LoginPage checkboxCheck(Duration waitTime)
	{
		Elements.checkCheckbox(driver, checkBox);
		//Wait.waitForCheckboxChecked(driver, checkBox,waitTime);
		return this;
	}
	
	public LoginPage uncheckCheckBox(Duration waitTime)
	{
		Elements.uncheckCheckbox(driver, checkBox);
		return this;
		
	}

}
