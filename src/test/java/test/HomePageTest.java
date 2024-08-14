package test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reports.ExtentReportUtils;
import pages.HomePage;

@Listeners(TestListener.class)

public class HomePageTest extends BaseTest{
@Test
public void addrow() {
	HomePage homePage = new HomePage(driver);
	int actuaRowCountinTable =homePage.countOfRowsInTable();
	System.out.println("Acutal count:"+ actuaRowCountinTable);
	homePage.addRow();
	int expectedRowCountinTable =homePage.countOfRowsInTable();
	System.out.println("Expected count:"+ expectedRowCountinTable);
	try {
		Assert.assertEquals(actuaRowCountinTable + 1, expectedRowCountinTable);
		ExtentReportUtils.logPass("Row added successful to table");
	} catch (AssertionError e) {
		Assert.fail(" did not match: " + expectedRowCountinTable);
		ExtentReportUtils.logFail("Unable to add row " + e.getMessage());
		throw e; 
	}
	}
@Test
public void removeRow() {
	HomePage homePage = new HomePage(driver);
	int actuaRowCountinTable =homePage.countOfRowsInTable();
	System.out.println("Acutal count:"+ actuaRowCountinTable);
	homePage.addRow();
	int expectedRowCountinTable =homePage.countOfRowsInTable();
	System.out.println("Expected count:"+ expectedRowCountinTable);
	try {
		Assert.assertEquals(actuaRowCountinTable + 1, expectedRowCountinTable);
		ExtentReportUtils.logPass("Row added successful to table");
	} catch (AssertionError e) {
		Assert.fail(" did not match: " + expectedRowCountinTable);
		ExtentReportUtils.logFail("Unable to add row " + e.getMessage());
		throw e; 
	}
	int countAfterAddingRow =homePage.countOfRowsInTable();
	System.out.println("Count after add new Row :"+ countAfterAddingRow);
	homePage.removeRow();
	int countAfterRemoveRow =homePage.countOfRowsInTable();
	System.out.println("Count after Remove new Row :"+ countAfterRemoveRow);
	try {
		Assert.assertEquals(countAfterAddingRow + 1, countAfterRemoveRow);
		ExtentReportUtils.logPass("Row removed successfully from the table");
	} catch (AssertionError e) {
		Assert.fail(" did not match: " + countAfterRemoveRow);
		ExtentReportUtils.logFail("Unable to remove row from the table " + e.getMessage());
		throw e; 
	}
	}
@Test
public void addColumn() {
	HomePage homePage = new HomePage(driver);
	int actuaColumnCountinTable =homePage.countOfColumnsInTable();
	System.out.println("Acutal count:"+ actuaColumnCountinTable);
	homePage.addColumn();
	int expectedColumnCountinTable =homePage.countOfColumnsInTable();
	System.out.println("Expected count:"+ expectedColumnCountinTable);
	try {
		Assert.assertEquals(actuaColumnCountinTable + 1, expectedColumnCountinTable);
		ExtentReportUtils.logPass("Columns added successful to the table");
	} catch (AssertionError e) {
		Assert.fail(" did not column add: " + expectedColumnCountinTable);
		ExtentReportUtils.logFail("Unable to add columnn " + e.getMessage());
		throw e; 
	}
	
}
}
