package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import elementUtils.Elements;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

		// TODO Auto-generated constructor stub
	}
	// Locators
//	@FindBy(name="username") private WebElement userNameFld;
//	@FindBy(name="password") private WebElement passwordFld;
//	@FindBy(xpath = "//button[@type='submit']") private WebElement submitBtn;

	By userNameFld = By.id("user-name");
	By passwordFld = By.id("password");
	By loginBtn = By.id("login-button");
	By techNewsLink = By.xpath("//a[@href='https://www.hyrtutorials.com/search/label/TechNews']");
	By gmailLink = By.xpath("//a[@aria-label=\"Gmail \"]");
	By checkBox = By.id("englishchbx");
	By dropdownText = By.id("course");
	By confirmationAlert = By.id(("confirmBox"));
	By openWindowBtn = By.id("newWindowBtn");
	By firstDateField = By.xpath("//input[@id='first_date_picker']");
	By seconDateFiled = By.id("second_date_picker");
	By calendarHeader = By.className("ui-datepicker-title");
	public By searchField = By.xpath("//input[@id=\"firstName\"]");
	By nextBtn = By.xpath("//a[@title=\"Next\"]");
	
	
	By tableHeaderBy = By.className("ds-table-sm");
	
	//By calendarDay =  By.xpath("//a[text()="+CalendarUtil.getCurrentDay()+"]");
	//By futureDay =  By.xpath("//a[text()="+CalendarUtil.getFutureDay()+"]");
	// Methods
	public ProductPage login(String userName, String password) {
		Elements.doSendKeys(driver, userNameFld, userName);
		Elements.doSendKeys(driver, passwordFld, password);
		Elements.doClick(driver, loginBtn);		
		return new ProductPage(driver);


	}

}
