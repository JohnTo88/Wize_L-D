package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TimesheetDetail extends WebActions 
{
	public TimesheetDetail(WebDriver _driver) {
		super(_driver);
	}

	By btnReject = By.xpath("//button[contains(.,'Reject')]");
	By btnRejectConfirm = By.xpath("//span[@class='ng-scope'][contains(.,'Reject')]");
	By btnApprove = By.xpath("//button[contains(.,'Approve')]");
	By btnApproveConfirm = By.xpath("//button[@type='submit'][contains(.,'Approve')]");
	By btnDelete = By.xpath("//button[contains(.,'Delete')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By txtComment = By.xpath("//textarea[@name='comment']");
	By btnExport = By.xpath("//button[contains(.,'Export')]");
	By lblTimesheetDetail = By.xpath("(//span[@class='ng-binding'])[3]");
	
	By msgRejectSuccess = By.xpath("//span[@class='message-content'][contains(.,'Reject timesheet successfully!')]");
	By msgApproveSuccess = By.xpath("//span[@class='message-content'][contains(.,'Approve timesheet successfully!')]");
	By msgDeleteSuccess = By.xpath("//span[@class='message-content'][contains(.,'Delete broadcast message successfully')]");
	
	public void clickBtnReject()
	{
		waitForElementClickable(5, btnReject);
		clickByJavaScript(btnReject);
	}
	
	public void clickBtnRejectConfirm()
	{
		waitForElementClickable(5, btnRejectConfirm);
		clickByJavaScript(btnRejectConfirm);
	}
	
	public void clickBtnApprove()
	{
		waitForElementClickable(5, btnApprove);
		clickByJavaScript(btnApprove);
	}
	
	public void clickBtnApproveConfirm()
	{
		waitForElementClickable(5, btnApproveConfirm);
		clickByJavaScript(btnApproveConfirm);
	}
	
	public void clickBtnDelete()
	{
		waitForElementClickable(5, btnDelete);
		clickByJavaScript(btnDelete);
	}
	
	public void clickBtnYes()
	{
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
	
	public void fillTxtComment(String comment)
	{
		waitForElementClickable(5, txtComment);
		goTextOnNoEnter(txtComment, comment);
	}
	
	public boolean isLblTimesheetDetailDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblTimesheetDetail).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnExportDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnExport).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnRejectDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnReject).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnApproveDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnApprove).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDelete).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgRejectSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgRejectSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgApproveSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgApproveSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void rejectTimesheet(String comment)
	{
		clickBtnReject();
		fillTxtComment(comment);
		clickBtnRejectConfirm();
	}
	
	public void aprroveTimesheet(String comment)
	{
		clickBtnApprove();
		fillTxtComment(comment);
		clickBtnApproveConfirm();
	}
	
	public void deleteTimesheet()
	{
		clickBtnDelete();
		clickBtnYes();
	}
}
