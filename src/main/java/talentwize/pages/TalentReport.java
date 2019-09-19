package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TalentReport extends WebActions
{
	public TalentReport(WebDriver _driver) {
		super(_driver);
	}

	By btnView = By.xpath("//button[contains(.,'View')]");
	By btnExport = By.xpath("//a[contains(.,'Export')]");
	
	public void clickBtnView()
	{
		waitForElementClickable(5, btnView);
		clickByJavaScript(btnView);
	}
	
	public boolean isBtnViewDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnView).isDisplayed() == true)
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
			if (driver.findElement(btnExport).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
