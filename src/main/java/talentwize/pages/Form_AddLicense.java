package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddLicense extends WebActions {

	By txtName = By.xpath("(//input[@type='text'])[2]");
	By txtDateOfIssuse=By.xpath("//input[@name='issuedDate']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	
	public Form_AddLicense(WebDriver _driver) {
		super(_driver);
	}

	public void fillName(String _name) {
		waitForElementClickable(10, txtName);
		goTextOn(txtName, _name);
	}
	public void fillDateOfIssuse(String _date) {
		goTextOn(txtDateOfIssuse, _date);
	}

	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void addLicense(String _name, String _date) {
		fillName(_name);
		fillDateOfIssuse(_date);
		clickBtnSave();
	}

}
