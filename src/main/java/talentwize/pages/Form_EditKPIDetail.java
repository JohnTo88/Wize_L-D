package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditKPIDetail extends WebActions {

	public Form_EditKPIDetail(WebDriver _driver) {
		super(_driver);

	}

	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By btnEdit=By.xpath("//button[@ng-click='edit()']");
	By btnClose=By.xpath("//button[contains(.,'Close')]");
	By msgUpdateKPIDetail=By.xpath("//span[@class='message-content'][contains(.,'Update kpis successfully!')]");
	
	public boolean isBtnEditDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(5, btnEdit);
			if (driver.findElement(btnEdit).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean ismsgUpdateKPIDetailDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(5, msgUpdateKPIDetail);
			if (driver.findElement(msgUpdateKPIDetail).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	public boolean isButtonSaveDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnCancel);
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
			if (driver.findElement(btnCancel).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	public void clickButtonCancel() {
		waitForElementClickable(5, btnCancel);
		clickByJavaScript(btnCancel);
	}
	public void clickButtonSave() {
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	public void clickButtonEdit() {
		waitForElementClickable(5, btnEdit);
		clickByJavaScript(btnEdit);
	}
	public void clickButtonClose() {
		waitForElementClickable(5, btnClose);
		clickByJavaScript(btnClose);
	}
	public void UpdateKPIDetail()
	{
		clickButtonEdit();
		clickButtonSave();
	}
}
