package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class EmployeeReport extends WebActions
{
	public EmployeeReport(WebDriver _driver) {
		super(_driver);
	}
	
	By btnExport = By.xpath("//button[@ng-click='downloadReport()']");
	
	public void clickBtnExport()
	{
		waitForElementClickable(5, btnExport);
		clickByJavaScript(btnExport);
	}
	
	public boolean isBtnExportDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnExport).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
