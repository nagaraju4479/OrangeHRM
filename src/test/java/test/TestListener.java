package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Reports.ExtentReportUtils;
import elementUtils.ScreenShotUtils;

public class TestListener implements ITestListener {
	 private WebDriver driver;

	    @Override
	    public void onStart(ITestContext context) {
	        ExtentReportUtils.initReport();
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        ExtentReportUtils.flushReport();
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentReportUtils.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        ExtentReportUtils.logPass(result.getMethod().getMethodName() + " passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	 WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
	         
	         // Ensure the driver is not null
	         if (driver != null) {
	             // Take a screenshot and get the file path
	             String screenshotPath = ScreenShotUtils.takeScreenshot(driver, result.getMethod().getMethodName());
	             
	             // Log the failure in Extent Reports
	             ExtentReportUtils.logFail(result.getMethod().getMethodName() + " failed");
	             
	             // Attach the screenshot to the Extent Report
	             ExtentReportUtils.addScreenshot(screenshotPath);
	         } else {
	             System.out.println("WebDriver instance is null. Cannot take screenshot.");
	         }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        ExtentReportUtils.logInfo(result.getMethod().getMethodName() + " skipped");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Not implemented
	    }

}
