package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TestLogger;
import controller.WebActions;

public class Form_AddQuota extends WebActions {
	
	By chkProject=By.xpath("//span[contains(.,'Select Project...')]");
	By chksecondProject=By.xpath("(//div[contains(@class,'ng-binding ng-scope')])[2]");
	By chkProjectRole=By.xpath("//span[@ng-show='$select.isEmpty()'][contains(.,'Select Role...')]");
	By chkfirstProjectRole=By.xpath("(//div[@ng-bind-html='position.name'])[1]");
	By chkSite=By.xpath("//span[contains(.,'Select Site...')]");
	By chkfirstSite=By.xpath("//div[contains(@ng-bind-html,'region.name')]");
	By txtEffectiveFrom = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All'])[9]/following::input[1]");
	By btnCancel = By.xpath("//div[contains(@ng-click,'cancelAll()')]");
	By btnSave=By.xpath("//div[@ng-click='saveChange()']");
	By txtSearch=By.xpath("(//input[@type='search'])[2]");
	By lblResultSearch=By.xpath("//div[@ng-bind-html='project.name']");

	
	public Form_AddQuota(WebDriver _driver) {
		super(_driver);
	}
	
	public void clickchkProject() {
		waitForElementClickable(5, chkProject);
		clickByJavaScript(chkProject);
	}
	public void clickchksecondProject() {
		waitForElementClickable(5, chksecondProject);
		clickByJavaScript(chksecondProject);
	}
	public void clickchkProjectRole() {
		waitForElementClickable(10, chkProjectRole);
		clickByJavaScript(chkProjectRole);
	}
	public void clickchkfirstProjectRole() {
		waitForElementClickable(5, chkfirstProjectRole);
		clickByJavaScript(chkfirstProjectRole);
	}
	public void clickchkSite() {
		clickByJavaScript(chkSite);
	}
	public void clickchkfirstSite() {
		waitForElementClickable(5, chkfirstSite);
		clickByJavaScript(chkfirstSite);
	}
	public void fillStartDate(String _effectiveForm) {
		waitForElementClickable(10, txtEffectiveFrom);
		clickByJavaScript(txtEffectiveFrom);
		goTextOn(txtEffectiveFrom, _effectiveForm);
	}
	public void fillProjectName(String _projectName) {
		waitForElementClickable(10, txtSearch);
		clickByJavaScript(txtSearch);
		goTextOn(txtSearch, _projectName);
	}
	public void clickButtonSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}
	public void clickLblResultSearch() {
		waitForElementClickable(5, lblResultSearch);
		clickByJavaScript(lblResultSearch);
		sleep(5);
	}
	
	public void addQuota(String _projectName, String _effectiveForm) 
	{
		clickchkProject();
		fillProjectName(_projectName);
		TestLogger.info("Click on project role");
		clickchkProjectRole();
		clickchkfirstProjectRole();
		clickchkSite();
		clickchkfirstSite();
		fillStartDate(_effectiveForm);
		clickButtonSave();
	}

}
