package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Units extends WebActions {

	By btnExport = By.xpath("//button[contains(.,'Export')]");
	By btnShowUnitManager = By.xpath("//span[contains(.,'Show Unit Manager')]");
	By btnCollapseAll = By.xpath("//span[contains(.,'Collapse all')]");
	By btnDelete = By.xpath("(//i[@class='icon icon-bin'])[1]");
	By btnCreate = By.xpath("(//i[@class='icon icon-plus2'])[2]");
	public static String UnitName = "Executives";
	
	public Units(WebDriver _driver) {
		super(_driver);
		
	}

	
	public boolean isButtonExportDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnExport).isDisplayed()==true)
			   flag = true;
			
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	public void clickOnUnitName(String _UnitName) throws InterruptedException
	{
		waitForElementPresent(10, By.xpath("//a[contains(.,'"+_UnitName+"')]"));
		driver.findElement(By.xpath("//a[contains(.,'"+_UnitName+"')]")).click();
	}
	
	public boolean isButtonDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnDelete).isDisplayed()==true)
			   flag = true;
			
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	public boolean isButtonCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCreate).isDisplayed()==true)
			   flag = true;
			
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	public boolean isButtonShowUnitManagerDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnShowUnitManager).isDisplayed()==true)
			   flag = true;
			
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	public boolean isButtonCollapseAllDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCollapseAll).isDisplayed()==true)
			   flag = true;
			
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	

	
}
