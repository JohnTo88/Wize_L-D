package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_UpdateCustomField extends WebActions {

	By btnSave = By.xpath("//button[contains(.,'Save')]");
    By btnClose = By.xpath("//button[contains(.,'Close')]");
    
	public Form_UpdateCustomField(WebDriver _driver) {
		super(_driver);

	}

	public boolean isButtonSaveDisplayed() {
		boolean flag = false;

		try {
			if (driver.findElement(btnSave).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	public void clickButtonSave() {
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickButtonClose() {
		waitForElementClickable(10, btnClose);
		clickByJavaScript(btnClose);
	}

}
