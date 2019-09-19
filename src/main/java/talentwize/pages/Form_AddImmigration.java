package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddImmigration extends WebActions {

	By chkDocumentType = By.xpath("//span[@ng-show='$select.isEmpty()'][contains(.,'Select document type...')]");
	By chkPassport = By.xpath("//div[@ng-bind-html='documentType.value'][contains(.,'Passport')]");
	By txtDocumentNumber = By.xpath("//input[contains(@name,'number')]");
	By txtDateIssuse = By.xpath("//input[contains(@name,'issueDate')]");
	By txtDateExpriry = By.xpath("//input[contains(@name,'expiryDate')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	By btnSave=By.xpath("//button[contains(.,'Save')]");
	
	public Form_AddImmigration(WebDriver _driver) {
		super(_driver);
	}
	public void clickchkDocumentType() {
		clickByJavaScript(chkDocumentType);
	}

	public void clickchkPassport() {
		clickByJavaScript(chkPassport);
	}
	public void fillDocumentNumber(String _documentnumber) {
		waitForElementClickable(10, txtDocumentNumber);
		clickByJavaScript(txtDocumentNumber);
		goTextOn(txtDocumentNumber, _documentnumber);
	}
	public void fillDateofIssue(String _dateissuse) {
		waitForElementClickable(10, txtDateIssuse);
		clickByJavaScript(txtDateIssuse);
		goTextOn(txtDateIssuse, _dateissuse);
	}
	public void fillDateofExpiry(String _dateexpiry) {
		waitForElementClickable(10, txtDateExpriry);
		clickByJavaScript(txtDateExpriry);
		goTextOn(txtDateExpriry, _dateexpiry);
	}

	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void addImmigration(String _dateissuse, String _dateexpiry, String _documentnumber) {
		clickchkDocumentType();
		clickchkPassport();
		fillDocumentNumber(_documentnumber);
		fillDateofIssue(_dateissuse);
		fillDateofExpiry(_dateexpiry);
		clickBtnSave();
	}

}
