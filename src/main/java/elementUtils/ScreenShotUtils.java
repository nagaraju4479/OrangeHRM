package elementUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {

	public static String takeScreenshot(WebDriver driver, String screenshotName) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance is null");
		}

		String destination = "./screenshots/" + screenshotName + ".png";
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
}
