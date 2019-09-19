package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddKPIConfiguration extends WebActions {

	By txtKPICode=By.xpath("//input[contains(@ng-model,'criteria.kpiCode')]");
	By txtKPIName=By.xpath("//input[@ng-model='criteria.name']");
	By txtMin=By.xpath("//input[contains(@name,'min')]");
	By txtMax=By.xpath("//input[contains(@name,'max')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	
	public Form_AddKPIConfiguration(WebDriver _driver) {
		super(_driver);
	}
	public void filltxtKPICode(String _kpicode) {
		waitForElementClickable(10, txtKPICode);
		clickByJavaScript(txtKPICode);
		goTextOn(txtKPICode, _kpicode);
	}
	public void filltxtKPIName(String _kpiname) {
		waitForElementClickable(10, txtKPIName);
		clickByJavaScript(txtKPIName);
		goTextOn(txtKPIName, _kpiname);
	}
	public void filltxtMax(String _max) {
		waitForElementClickable(10, txtMax);
		clickByJavaScript(txtMax);
		goTextOn(txtMax, _max);
	}
	public void filltxtMin(String _min) {
		waitForElementClickable(10, txtMin);
		clickByJavaScript(txtMin);
		goTextOn(txtMin, _min);
	}

	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void addKPIConfiguration(String _kpicode, String _kpiname, String _max, String _min) {
		filltxtKPICode(_kpicode);
		filltxtKPIName(_kpiname);
		filltxtMax(_max);
		filltxtMin(_min);
		clickBtnSave();
	}

}
