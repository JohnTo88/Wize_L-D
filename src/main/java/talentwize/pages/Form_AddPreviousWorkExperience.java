package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddPreviousWorkExperience extends WebActions {

	By txtCompany = By.xpath("//input[@name='company']");
	By txtJobTitle = By.xpath("//input[@name='jobTitle']");
	By txtFrom = By.xpath("//input[@name='from']");
	By txtTo = By.xpath("//input[@name='to']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	
	public Form_AddPreviousWorkExperience(WebDriver _driver) {
		super(_driver);
	}

	public void fillCompany(String _company) {
		waitForElementClickable(10, txtCompany);
		goTextOn(txtCompany, _company);
	}

	public void fillJobTitle(String _jobtitle) {
		waitForElementClickable(10, txtJobTitle);
		goTextOn(txtJobTitle, _jobtitle);
	}

	public void fillFrom(String _from) {
		waitForElementClickable(10, txtFrom);
		clickByJavaScript(txtFrom);
		goTextOn(txtFrom, _from);
	}
	public void fillTo(String _to) {
		waitForElementClickable(10, txtTo);
		clickByJavaScript(txtTo);
		goTextOn(txtTo, _to);
	}

	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void addPreviousWorkExperience(String _company, String _jobtitle, String _from, String _to) {
		fillCompany(_company);
		fillJobTitle(_jobtitle);
		fillFrom(_from);
		fillTo(_to);
		clickBtnSave();
	}

}
