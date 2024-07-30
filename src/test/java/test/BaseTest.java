package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import driverUtils.DriverManager;

public class BaseTest {

	protected WebDriver driver;
	protected Properties properties;
	private String filePath = "./src/test/resources/config.properties";
	static ExtentSparkReporter extentSparkReporter;
	static ExtentReports extentReport;

	@BeforeClass
	public void extentReportSetup() {
		extentSparkReporter = new ExtentSparkReporter("extentReport.html");
		extentSparkReporter.config().setDocumentTitle("Automation Report");
		extentSparkReporter.config().setReportName("Functional Testing");

		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
	}

	@BeforeMethod
	public void startDriver(ITestContext context) throws FileNotFoundException, InterruptedException {

		properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(filePath);
		try {
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = DriverManager.initializeDriver(properties.getProperty("browser"));
		driver.get(properties.getProperty("baseUrl"));
		Thread.sleep(5000);
		 context.setAttribute("driver", driver);
	}

	@AfterMethod
	public void quitDriver() {
	//	driver.quit();
	}

	@AfterClass
	public void flushExtendReports() {
		extentReport.flush();
	}

}
