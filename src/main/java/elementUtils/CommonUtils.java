package elementUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
	
	public static int getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
	
	public static LocalDate getCurrentDate() {
		LocalDate date = LocalDate.now();
		return date;
	}

	

	public static int getCurrentDay() {

		LocalDate date = LocalDate.now();
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
		 return date.format(formatter);
		
	}


	public static int getFutureDay() {
		LocalDate date = LocalDate.now().plusDays(Constants.TWO_WEEKS);
		return date.getDayOfMonth();
	}
	public static String getFutureMonthYear() {
		LocalDate date = LocalDate.now().plusDays(Constants.TWO_WEEKS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");

	return date.format(formatter);
		
	}
	public static String getCurrentDateTime()
	{
		
		 String dateName = new SimpleDateFormat("yyyy-MMMM-dd_hhmmss").format(new Date());
		 return dateName;
		 
		 
	}
	
	
}
