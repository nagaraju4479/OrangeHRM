package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import elementUtils.CommonUtils;

public class ExtentReportUtils {
	
	private static ExtentReports extent;
    private static ExtentTest test;
    
    public static void initReport() {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html"+CommonUtils.getCurrentDateTime());
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Automation Test Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void addScreenshot(String path) {
        test.addScreenCaptureFromPath(path);
    }

    public static void flushReport() {
        extent.flush();
    }

}
