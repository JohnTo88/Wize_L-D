package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddEducation extends WebActions {

	By chkLevel=By.xpath("//span[contains(.,'Select level...')]");
	By chkLevel_High_School=By.xpath("//div[@ng-bind-html='level.value'][contains(.,'High School Diploma')]");
	By txtInstitute = By.xpath("(//input[@type='text'])[3]");
	By txtMajor = By.xpath("(//input[@type='text'])[4]");
	By chkYearOfGraduation=By.xpath("(//a[@aria-label='Select box select'])[2]");
	By chkYearOfGraduation_year=By.xpath("(//div[@ng-bind-html='year'])[1]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	
	public Form_AddEducation(WebDriver _driver) {
		super(_driver);
	}
	public void clickChkLevel() {
		waitForElementClickable(10, chkLevel);
		clickByJavaScript(chkLevel);
	}
	public void clickChkLevel_HighSchool() {
		waitForElementClickable(10, chkLevel_High_School);
		clickByJavaScript(chkLevel_High_School);
	}

	public void fillInstitute(String _institute) {
		waitForElementClickable(10, txtInstitute);
		goTextOn(txtInstitute, _institute);
	}

	public void fillMajor(String _major) {
		waitForElementClickable(10, txtMajor);
		clickByJavaScript(txtMajor);
		goTextOn(txtMajor, _major);
	}
	public void clickChkYearOfGraduation() {
		waitForElementClickable(10, chkYearOfGraduation);
		clickByJavaScript(chkYearOfGraduation);
	}
	public void clickChkYearOfGraduation_year() {
		waitForElementClickable(10, chkYearOfGraduation_year);
		clickByJavaScript(chkYearOfGraduation_year);
	}

	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void addEducation(String _institute, String _major) {
		clickChkLevel();
		clickChkLevel_HighSchool();
		fillInstitute(_institute);
		fillMajor(_major);
		clickChkYearOfGraduation();
		clickChkYearOfGraduation_year();
		clickBtnSave();
	}

}
