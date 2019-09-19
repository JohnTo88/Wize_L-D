package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditContractType extends WebActions {

	public Form_EditContractType(WebDriver _driver) {
		super(_driver);

	}

	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");

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
		waitForElementClickable(3, btnCancel);
		clickByJavaScript(btnCancel);
	}
	public void clickButtonSave() {
		waitForElementClickable(3, btnSave);
		clickByJavaScript(btnSave);
	}


}
