package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By dashBoardText = By.xpath("//h6[text()='Dashboard']");
	
	public String getDashboradText()
	{
		return Elements.getText(driver, dashBoardText);
	}

}
