package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_UpdateRightToWork extends WebActions {

	
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	
	public Form_UpdateRightToWork(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isButtonSaveDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnSave);
			if (driver.findElement(btnSave).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isButtonCancelDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnCancel);
			if (driver.findElement(btnCancel).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	
	public void clickButtonCancel()
	{
		waitForElementClickable(10, btnCancel);
		clickByJavaScript(btnCancel);
	}
	public void clickButtonSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	

}
