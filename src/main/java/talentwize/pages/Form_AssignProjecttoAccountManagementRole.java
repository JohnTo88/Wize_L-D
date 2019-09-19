package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AssignProjecttoAccountManagementRole extends WebActions {
	
	By txtProjectName=By.xpath("//input[contains(@ng-model,'condition.keyword')]");
	By chkProjectName=By.xpath("//label[@class='i-checkbox'][1]");
	By btnNext=By.xpath("//button[@ng-click='select()']");
	By btnCancel = By.xpath("//div[contains(@ng-click,'cancelAll()')]");
	By btnSave=By.xpath("//button[contains(.,'Save')]");
	By btnSearch=By.xpath("//button[contains(@ng-click,'searchItems()')]");

	
	public Form_AssignProjecttoAccountManagementRole(WebDriver _driver) {
		super(_driver);
	}
	
	public void fillProjectName(String _projectName) {
		waitForElementClickable(10, txtProjectName);
		clickByJavaScript(txtProjectName);
		goTextOn(txtProjectName, _projectName);
		sleep(3);
	}
	public void clickButtonSearch() {
		waitForElementClickable(5, btnSearch);
		clickByJavaScript(btnSearch);
	}
	public void clickchkProjectName() {
		waitForElementClickable(10, chkProjectName);
		clickByJavaScript(chkProjectName);
	}
	public void clickButtonSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void clickBtnNext() {
		clickByJavaScript(btnNext);
	}
	
	
	public void clickBtnSearch() {
		clickByJavaScript(btnSearch);
	}
	public void addProjectBoard(String _projectName) 
	{
		fillProjectName(_projectName);
		clickchkProjectName();
		clickBtnNext();
		clickButtonSave();
		sleep(5);
	}

}
