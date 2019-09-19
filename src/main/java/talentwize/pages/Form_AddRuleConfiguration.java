package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddRuleConfiguration extends WebActions {

	By txtRuleCode=By.xpath("//input[contains(@name,'code')]");
	By txtItemScore=By.xpath("//input[contains(@name,'point')]");
	By txtDescription=By.xpath("//textarea[@name='description']");
	By drbKPI=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Assigned to KPI*'])[1]/following::span[1]");
	By first_KPI=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='-'])[1]/following::div[5]");
	//div[@class='ng-binding ng-scope'][contains(.,'CU01 (Obsolete) - % 6 hourly and closure update completed within 1 hour')]
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	
	public Form_AddRuleConfiguration(WebDriver _driver) {
		super(_driver);
	}
	public void filltxtRuleCode(String _rulecode) {
		waitForElementClickable(10, txtRuleCode);
		clickByJavaScript(txtRuleCode);
		goTextOn(txtRuleCode, _rulecode);
	}
	public void filltxtItemScore(String _itemscore) {
		waitForElementClickable(10, txtItemScore);
		clickByJavaScript(txtItemScore);
		goTextOn(txtItemScore, _itemscore);
	}
	public void filltxtDescription(String _description) {
		waitForElementClickable(10, txtDescription);
		clickByJavaScript(txtDescription);
		goTextOn(txtDescription, _description);
	}
	public void clickdrbKPI() {
		waitForElementClickable(5, drbKPI);
		clickByJavaScript(drbKPI);
	}
	public void clickfirst_KPI() {
		waitForElementClickable(5, first_KPI);
		clickByJavaScript(first_KPI);
	}
	public void clickBtnSave() {
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		waitForElementClickable(5, btnCancel);
		clickByJavaScript(btnCancel);
	}

	public void addRuleConfiguration(String _rulecode, String _itemscore, String _description) {
		filltxtRuleCode(_rulecode);
		filltxtItemScore(_itemscore);
		clickdrbKPI();
		clickfirst_KPI();
		filltxtDescription(_description);
		clickBtnSave();
	}

}
