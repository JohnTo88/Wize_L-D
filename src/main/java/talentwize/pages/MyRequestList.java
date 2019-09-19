package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyRequestList extends WebActions
{

	public MyRequestList(WebDriver _driver) {
		super(_driver);
	}
	
	By btnApplyLeave = By.xpath("//button[contains(.,'Apply Leave')]");
	By linkDate = By.xpath("(//span[contains(@ng-click,'index, leave)')])[1]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By btnCancelRequest = By.xpath("//button[contains(.,'Cancel Request')]");
	
	By msgApplySuccess = By.xpath("//span[@class='message-content'][contains(.,'Apply leave successfully!')]");
	By msgCancelSuccess = By.xpath("//span[@class='message-content'][contains(.,'Cancel leave successfully!')]");
	
	public void clickBtnApplyLeave()
	{
		waitForElementClickable(5, btnApplyLeave);
		clickByJavaScript(btnApplyLeave);
	}
	
	public void clickLinkDate()
	{
		waitForElementClickable(5, linkDate);
		clickByJavaScript(linkDate);
	}
	
	public void cancelRequest()
	{
		waitForElementClickable(5, btnCancel);
		clickByJavaScript(btnCancel);
		waitForElementClickable(5, btnCancelRequest);
		clickByJavaScript(btnCancelRequest);
	}
	
	public boolean isBtnApplyLeaveDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnApplyLeave).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkDateDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(5, linkDate);
			if (driver.findElement(linkDate).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCancelDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnCancel).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgApplySuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgApplySuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgCancelSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgCancelSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
