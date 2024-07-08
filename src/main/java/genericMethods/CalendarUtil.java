package genericMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarUtil {

	public static Boolean bstatus;
	public static int date;

	public static LocalDate getCurrentDate() {
		LocalDate date = LocalDate.now();
		return date;
	}

	public static String getFutureMonthYear() {
		LocalDate date = LocalDate.now().plusDays(Constants.TWO_WEEKS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");

		String formattedDate = date.format(formatter);
		return formattedDate;
	}

	public static int getCurrentDay() {

		LocalDate date = LocalDate.now();
		return date.getDayOfMonth();

	}

	public static int getFutureDay() {
		LocalDate date = LocalDate.now().plusDays(Constants.TWO_WEEKS);
		return date.getDayOfMonth();
	}

	public static int getCurrentMonth() {
		LocalDate date = LocalDate.now();
		return date.getMonthValue();
	}

	public static int getCurrentYear() {
		LocalDate date = LocalDate.now();
		return date.getYear();
	}

	public static String getCurrentMonthYear() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM YYYY");
		String currentMonthYear = date.format(formatter);
		return currentMonthYear;
	}

	public static String getCalHeaderText(WebDriver driver, By headerLocator) {
		String headerText = driver.findElement(headerLocator).getText();
		return headerText;
	}

	public static boolean selectCurrentDate(WebDriver driver, By calLocator, By dateLocator) {

		if (Wait.waitForCalendarPresence(driver, calLocator, Constants.maxWaitTime)) {
			Elements.doClick(driver, calLocator);

			if (Wait.waitForCalendarPresence(driver, dateLocator, Constants.maxWaitTime)) {

				Elements.doClick(driver, dateLocator);
				return true;

			}
		} else {
			System.err.println("Calendar widget not found");
			return false;
		}
		return false;

	}

	public static boolean selectFutureDate(WebDriver driver, By calLocator, By calHeader, By nextLocator,
			By dateLocator) {

		Wait.waitForElementPresence(driver, calLocator, Constants.maxWaitTime);
		Elements.doClick(driver, calLocator);
		String currentMonthYear = Elements.getText(driver, calHeader);
		if (currentMonthYear.equals(getFutureMonthYear())) {

			Elements.doClick(driver, dateLocator);
			return true;
		} else {
			Elements.doClick(driver, nextLocator);
			Elements.doClick(driver, dateLocator);
			return true;
		}
		
	}
	

}
