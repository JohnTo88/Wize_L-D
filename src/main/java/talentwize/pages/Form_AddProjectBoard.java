package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddProjectBoard extends WebActions {
	By txtProjectName = By.xpath("//input[@name='projectName']");
	By txtProjectID = By.xpath("//input[@name='projectId']");
	By chkProjectLeader=By.xpath("//span[@ng-show='$select.isEmpty()'][contains(.,'Select Employee...')]");
	By firstProjectLeader=By.xpath("(//div[contains(@ng-bind-html,'obj.nameCombobox')])[1]");
	By chkProjectSite=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Site*'])[1]/following::input[1]");
	By firstProjectSite=By.xpath("//div[contains(@ng-bind-html,'region.name')]");
	By txtStartDate = By.xpath("//input[contains(@name,'startDate')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	By btnCreate=By.xpath("//button[@type='submit'][contains(.,'Create')]");

	
	public Form_AddProjectBoard(WebDriver _driver) {
		super(_driver);
	}
	public void fillProjectName(String _projectname) {
		waitForElementClickable(10, txtProjectName);
		clickByJavaScript(txtProjectName);
		goTextOn(txtProjectName, _projectname);
	}
	public void fillProjectID(String _projectid) {
		waitForElementClickable(10, txtProjectID);
		clickByJavaScript(txtProjectID);
		goTextOn(txtProjectID, _projectid);
	}
	public void clickButtonCreate() {
		clickByJavaScript(btnCreate);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}
	public void clickchkProjectLeader() {
		waitForElementClickable(5, chkProjectLeader);
		clickByJavaScript(chkProjectLeader);
	}
	public void clickfirstProjectLeader() {
		waitForElementClickable(5, firstProjectLeader);
		clickByJavaScript(firstProjectLeader);
	}
	public void clickchkProjectSite() {
		waitForElementClickable(5, chkProjectSite);
		clickByJavaScript(chkProjectSite);
	}
	public void clickfirstProjectSite() {
		waitForElementClickable(5, firstProjectSite);
		clickByJavaScript(firstProjectSite);
	}
	public void fillStartDate(String _startdate) {
		waitForElementClickable(10, txtStartDate);
		clickByJavaScript(txtStartDate);
		goTextOn(txtStartDate, _startdate);
	}
	public void addProjectBoard(String _projectname, String _projectid, String _startdate) {
	fillProjectName(_projectname);
	fillProjectID(_projectid);
	clickchkProjectLeader();
	clickfirstProjectLeader();
	clickchkProjectSite();
	clickfirstProjectSite();
	fillStartDate(_startdate);
	clickButtonCreate();
	sleep(19);
	}

}
