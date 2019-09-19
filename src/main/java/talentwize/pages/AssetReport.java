package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AssetReport extends WebActions {

	By dataTable = By.xpath("//h1[contains(.,'Asset Report')]");
	By btnExport = By.xpath("//button[contains(.,'Export')]");
	
	public AssetReport(WebDriver _driver) 
	{
		super(_driver);	
	}
	
	public boolean isDataTableDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementClickable(5, dataTable);
			if (driver.findElement(dataTable).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isBtnExportDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementClickable(5, btnExport);
			if (driver.findElement(btnExport).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	
	public void clickBtnExport()
	{
		waitForElementClickable(5, btnExport);
		clickByJavaScript(btnExport);
	}
	
}
