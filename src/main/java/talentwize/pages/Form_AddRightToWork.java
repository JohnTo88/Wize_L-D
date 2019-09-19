package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddRightToWork extends WebActions {

	By txtIssueAt = By.xpath("//input[contains(@name,'issueAt')]");
	By txtIssueBy=By.xpath("//input[@name='issueBy']");
	By txtDateIssuse = By.xpath("//input[contains(@name,'issueDate')]");
	By txtDateExpriry = By.xpath("//input[contains(@name,'expiryDate')]");
	By btnCancel = By.xpath("//button[contains(@ng-click,'cancel()')]");
	By btnSave=By.xpath("//button[contains(.,'Save')]");
	
	public Form_AddRightToWork(WebDriver _driver) {
		super(_driver);
	}
	public void fillIssueAt(String _issueat) {
		waitForElementClickable(10, txtIssueAt);
		clickByJavaScript(txtIssueAt);
		goTextOn(txtIssueAt, _issueat);
	}
	public void fillIssueBy(String _issueby) {
		waitForElementClickable(10, txtIssueBy);
		clickByJavaScript(txtIssueBy);
		goTextOn(txtIssueBy, _issueby);
	}
	public void fillDateIssuse(String _dateissuse) {
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

	public void addRightToWork(String _issueat, String _issueby, String _dateissuse, String _dateexpiry) {
		fillIssueAt(_issueat);
		fillIssueBy(_issueby);
		fillDateIssuse(_dateissuse);
		fillDateofExpiry(_dateexpiry);
		clickBtnSave();
	}

}
