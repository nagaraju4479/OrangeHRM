package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
public WebDriver initilizeDriver() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}

}
