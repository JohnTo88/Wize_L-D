package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddTargetVolume extends WebActions {
	By chkProjectName=By.xpath("//span[@ng-show='$select.isEmpty()'][contains(.,'Select Project...')]");
	By firstProjectName=By.xpath("(//div[@ng-bind-html='project.projectName | highlight: $select.search'])[46]");
	By txtQuanlity = By.xpath("//input[@name='quantity']");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	By btnAddTargetVolume=By.xpath("//button[@type='submit'][contains(.,'Add Target Volume')]");
	
	public Form_AddTargetVolume(WebDriver _driver) {
		super(_driver);
	}
	public void fillQuanlity(String _quanlity) {
		waitForElementClickable(10, txtQuanlity);
		clickByJavaScript(txtQuanlity);
		goTextOn(txtQuanlity, _quanlity);
	}

	public void clickBtnAddTargetVolume() {
		clickByJavaScript(btnAddTargetVolume);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}
	public void clickchkProjectName() throws InterruptedException {
		waitForElementPresent(15, chkProjectName);
		clickByJavaScript(chkProjectName);
	}
	public void clickfirstProjectName() throws InterruptedException {
		waitForElementPresent(15, firstProjectName);
		clickByJavaScript(firstProjectName);
	}
	public void addTargetVolume(String _quanlity) throws InterruptedException {
		clickchkProjectName();
		clickfirstProjectName();
		fillQuanlity(_quanlity);
		clickBtnAddTargetVolume();
	}

}
