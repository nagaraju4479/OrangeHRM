package driverUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
	
	

	public static WebDriver initializeDriver(String browserName) {
		WebDriver driver;
		
		

		switch (browserName.toLowerCase()) {
		case "chrome":

			driver = new ChromeDriver();
			break;
		case "firefox":

			driver = new FirefoxDriver();
			break;
		case "edge":

			driver = new EdgeDriver();
			break;
		case "safari":

			driver = new SafariDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}

		driver.manage().window().maximize();
		return driver;
	}

}
