package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddLanguage extends WebActions {

	By chkLanguage=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Language*'])[1]/following::span[1]");
	By chkLanguage_Span=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Language...'])[1]/following::div[5]");
	By chkSkill = By.xpath("//input[@placeholder='Select skills...']");
	By chkSkill_Listening = By.xpath("//div[@ng-bind-html='skill.value'][contains(.,'Listening')]");
	By chkSkill_Writing   = By.xpath("//div[@ng-bind-html='skill.value'][contains(.,'Writing')]");
	By chkSkill_Reading = By.xpath("//div[@ng-bind-html='skill.value'][contains(.,'Reading')]");
	By chkSkill_Speaking = By.xpath("//div[@ng-bind-html='skill.value'][contains(.,'Speaking')]");
	By chkFluency=By.xpath("//span[contains(.,'Select fluency level...')]");
	By chkFluency_High=By.xpath("//div[@ng-bind-html='level.value'][contains(.,'High')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	
	public Form_AddLanguage(WebDriver _driver) {
		super(_driver);
	}
	public void clickChkLanguage() {
		waitForElementClickable(10, chkLanguage);
		clickByJavaScript(chkLanguage);
	}
	public void clickChkLanguage_VN() {
		waitForElementClickable(10, chkLanguage_Span);
		clickByJavaScript(chkLanguage_Span);
	}
	public void clickChkSkill() {
		waitForElementClickable(10, chkSkill);
		clickByJavaScript(chkSkill);
	}
	public void clickChkSkill_Listening() {
		waitForElementClickable(10, chkSkill_Listening);
		clickByJavaScript(chkSkill_Listening);
	}
	public void clickChkSkill_Reading() {
		clickByJavaScript(chkSkill_Reading);
	}
	public void clickChkSkill_Writing() {
		clickByJavaScript(chkSkill_Writing);
	}
	public void clickChkSkill_Speaking() {
		clickByJavaScript(chkSkill_Speaking);
	}
	public void clickchkFluency() {
		waitForElementClickable(10, chkFluency);
		clickByJavaScript(chkFluency);
	}
	public void clickchkFluency_High() {
		waitForElementClickable(10, chkFluency_High);
		clickByJavaScript(chkFluency_High);
	}

	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void addLanguage() {
		clickChkLanguage();
		clickChkLanguage_VN();
		clickChkSkill();
		clickChkSkill_Listening();
		clickChkSkill_Writing();
		clickChkSkill_Reading();
		clickChkSkill_Speaking();
		clickchkFluency();
		clickchkFluency_High();
		clickBtnSave();
	}

}
