package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_UnitDetail extends WebActions {

	By btnQuickSave = By.xpath("//button[contains(.,'Quick Save')]");
	By menuStep4 = By.xpath("//a[contains(.,'Step 4')]");

	By btnSave = By.xpath("//button[@ng-click='submit()']");
	By btnCancel = By.xpath("(//button[contains(.,'Cancel')])[4]");

	public Form_UnitDetail(WebDriver _driver) {
		super(_driver);

	}

	public boolean isQuickSaveDispalyed() {
		boolean flag = false;

		try {
			waitForElementClickable(15, btnQuickSave);
			if (driver.findElement(btnQuickSave).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}

	public boolean isButtonSaveDisplayed() {
		boolean flag = false;

		try {
			waitForElementClickable(15, btnSave);
			if (driver.findElement(btnSave).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}
	
	public boolean isButtonCancelDisplayed() {
		boolean flag = false;

		try {
			waitForElementClickable(15, btnCancel);
			if (driver.findElement(btnCancel).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}
	
	public boolean isMenuStep4Displayed() {
		boolean flag = false;

		try {
			waitForElementClickable(15, menuStep4);
			if (driver.findElement(menuStep4).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}

	public void clickMenuStep4() {
		clickByJavaScript(menuStep4);
	}

	public void clickButtonSave() {
		clickByJavaScript(btnSave);
	}

	public void clickButtonCancel() {
		clickByJavaScript(btnCancel);
	}

}
