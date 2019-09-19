package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_ApplyLeave extends WebActions
{
	public Form_ApplyLeave(WebDriver _driver) {
		super(_driver);
	}

	By drplistLeaveType = By.xpath("//span[contains(.,'Select Leave Type')]");
	By optLeaveType = By.xpath("(//div[contains(@ng-bind-html,'obj.name')])[1]");
	By icoFromDate = By.xpath("(//button[@type='button'])[4]");
	By icoToDate = By.xpath("(//button[@type='button'])[5]");
	By btnToday = By.xpath("//button[contains(.,'Today')]");
	By btnApply = By.xpath("//button[@type='submit']");
	
	public void applyLeave()
	{
		waitForElementClickable(5, drplistLeaveType);
		clickByJavaScript(drplistLeaveType);
		sleep(0.5);
		clickByJavaScript(optLeaveType);
		waitForElementClickable(5, icoFromDate);
		clickByJavaScript(icoFromDate);
		sleep(0.5);
		clickByJavaScript(btnToday);
		waitForElementClickable(5, icoToDate);
		clickByJavaScript(icoToDate);
		sleep(0.5);
		clickByJavaScript(btnToday);
		waitForElementClickable(5, btnApply);
		clickByJavaScript(btnApply);
	}
}
