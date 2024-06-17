package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driverFactory.*;

public class BaseTest {
	
	protected WebDriver driver;
	protected Properties  properties;
	private String filePath = "./src/test/resources/config.properties";
	
	@BeforeMethod
	public void startDriver() throws FileNotFoundException, InterruptedException
	{
		driver = new DriverManager().initilizeDriver();
		
		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(filePath);
		try {
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(properties.getProperty("baseUrl"));
		Thread.sleep(10000);
		
	}
	
	@AfterMethod
	public void quitDriver()
	{
		//driver.quit();
	}

}
