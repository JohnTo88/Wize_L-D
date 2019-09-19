package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddProjectCapacity extends WebActions {
	By txtMinimunMonth = By.xpath("//input[contains(@ng-model,'config.tenureCap')]");
	By txtQuanlity = By.xpath("//input[contains(@name,'quantity')]");
	By chkProjectRole=By.xpath("//span[contains(.,'Select Role...')]");
	By firstProjectRole=By.xpath("(//div[contains(@ng-bind-html,'position.name')])[1]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By btnAddConfig=By.xpath("//button[contains(.,'Add config')]");

	
	public Form_AddProjectCapacity(WebDriver _driver) {
		super(_driver);
	}
	public void fillMinimunMonth(String _minimumMonth) {
		waitForElementClickable(10, txtMinimunMonth);
		clickByJavaScript(txtMinimunMonth);
		goTextOn(txtMinimunMonth, _minimumMonth);
	}
	public void fillQuanlity(String _quanlity) {
		waitForElementClickable(10, txtQuanlity);
		clickByJavaScript(txtQuanlity);
		goTextOn(txtQuanlity, _quanlity);
	}
	public void clickButtonAddConfig() {
		clickByJavaScript(btnAddConfig);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}
	public void clickchkProjectRole() {
		waitForElementClickable(10, chkProjectRole);
		clickByJavaScript(chkProjectRole);
	}
	public void clickfirstProjectRole() {
		waitForElementClickable(5, firstProjectRole);
		clickByJavaScript(firstProjectRole);
	}
	public void addProjectCapacity(String _minimumMonth, String _quanlity) {
		clickchkProjectRole();
		clickfirstProjectRole();
		fillMinimunMonth(_minimumMonth);
		fillQuanlity(_quanlity);
		clickButtonAddConfig();
	}

}
