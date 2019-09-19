package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditKPIList extends WebActions {

	public Form_EditKPIList(WebDriver _driver) {
		super(_driver);

	}

	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By btnClose= By.xpath("//button[contains(.,'Close')]");

	public boolean isbtnSaveDisplayed() {
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
	
	public boolean isButtonCloseDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnClose);
			if (driver.findElement(btnClose).isDisplayed() == true)
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
		waitForElementClickable(10, btnCancel);
		clickByJavaScript(btnCancel);
	}
	public void clickButtonSave() {
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	public void clickButtonClose() {
		waitForElementClickable(3, btnClose);
		clickByJavaScript(btnClose);
	}

}
