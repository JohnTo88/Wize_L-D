package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddDomain extends WebActions {

	By btnAdd = By.xpath("//button[@ng-click='ok()']");
	By txtDomain = By.xpath("//input[contains(@ng-model,'domain.domainName')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");

	public Form_AddDomain(WebDriver _driver) {
		super(_driver);

	}

	public void fillDomain(String _nameOfDomain) {
		waitForElementClickable(10, txtDomain);
		goTextOn(txtDomain, _nameOfDomain);
	}

	public void clickButtonAdd() {
		clickByJavaScript(btnAdd);
	}

	public void clickButtonCancel() {
		clickByJavaScript(btnCancel);
	}

	public boolean isButtonCancelDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(btnCancel).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

}
