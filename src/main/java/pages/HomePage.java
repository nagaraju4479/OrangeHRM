package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import elementUtils.Elements;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	private By table =By.xpath("//table[@id='dynamicTable']");
	private By countOfRows =By.xpath(".//tbody/tr");
	private By countOfColumns=By.xpath(".//td");
	private By addColumnBtn =By.id("addColumnBtn");
	private By removeColumnBtn =By.id("removeColumnBtn");
	private By addRowBtn=By.id("addRowBtn");
	private By reomveRowBtn =By.id("removeRowBtn");
	
	public HomePage getTableDetails() {
		Elements.getText(driver, table);
		return this;
	}
	
	public void addRow() {
		Elements.doClick(driver, addRowBtn);
	}
	
	public void removeRow() {
		Elements.doClick(driver, reomveRowBtn);
	}
	
	public int countOfRowsInTable() {
		List<WebElement> rowsInTable =driver.findElements(countOfRows);
	return	rowsInTable.size();
	}
	
	public void addColumn() {
		Elements.doClick(driver, addColumnBtn);
	}
	
	public int countOfColumnsInTable() {
		List<WebElement> columnsInTable =driver.findElements(countOfColumns);
		return	columnsInTable.size();
	}
	

}
