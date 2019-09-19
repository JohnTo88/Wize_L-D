package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyTimesheet extends WebActions 
{

	public MyTimesheet(WebDriver _driver) {
		super(_driver);
	}

	By lblMyTimesheet = By.xpath("//h1[contains(.,'My Timesheet')]");
	By btnSubmit = By.xpath("//button[contains(.,'Submit')]");
	By btnSubmitConfirm = By.xpath("//span[@class='ng-scope'][contains(.,'Submit')]");
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnAddProject = By.xpath("//button[contains(.,'Add Project')]");
	By btnAddTimeOff = By.xpath("//button[contains(.,'Add Time Off')]");
	By txtComment = By.xpath("//textarea[@name='comment']");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By btnCancelConfirm = By.xpath("(//span[@class='ng-scope'])[2]");
	By txtTime = By.xpath("(//input[@type='text'])[3]");
	
	By msgSubmitSuccess = By.xpath("//span[@class='message-content'][contains(.,'Timesheet submitted successfully!')]");
	By msgCancelSuccess = By.xpath("//span[@class='message-content'][contains(.,'Timesheet cancelled successfully')]");
	
	public void clickBtnSubmit()
	{
		waitForElementClickable(5, btnSubmit);
		clickByJavaScript(btnSubmit);
	}
	
	public void clickBtnSubmitConfirm()
	{
		waitForElementClickable(5, btnSubmitConfirm);
		clickByJavaScript(btnSubmitConfirm);
	}
	
	public void clickBtnEdit()
	{
		waitForElementClickable(5, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickBtnAddProject()
	{
		waitForElementClickable(5, btnAddProject);
		clickByJavaScript(btnAddProject);
	}
	
	public void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickBtnAddTimeOff()
	{
		waitForElementClickable(5, btnAddTimeOff);
		clickByJavaScript(btnAddTimeOff);
	}
	
	public void clickBtnCancel()
	{
		waitForElementClickable(5, btnCancel);
		clickByJavaScript(btnCancel);
	}
	
	public void clickBtnCancelConfirm()
	{
		waitForElementClickable(5, btnCancelConfirm);
		clickByJavaScript(btnCancelConfirm);
	}
	
	public void fillTxtComment(String comment)
	{
		waitForElementClickable(5, txtComment);
		goTextOnNoEnter(txtComment, comment);
	}
	
	public void fillTxtTime(String time)
	{
		waitForElementClickable(5, txtTime);
		goTextOnNoEnter(txtTime, time);
	}
	
	public void createTimesheet(String time,String comment)
	{
		clickBtnEdit();
		clickBtnAddTimeOff();
		fillTxtTime(time);
		clickBtnSave();
		clickBtnSubmit();
		fillTxtComment(comment);
		clickBtnSubmitConfirm();
	}
	
	public void submitTimesheet(String comment)
	{
		clickBtnSubmit();
		fillTxtComment(comment);
		clickBtnSubmitConfirm();
	}
	
	public void cancelTimesheet(String comment)
	{
		clickBtnCancel();
		fillTxtComment(comment);
		clickBtnCancelConfirm();
	}
	
	public void editTimesheet(String time)
	{
		clickBtnEdit();
		clickBtnAddTimeOff();
		fillTxtTime(time);
		clickBtnSave();
	}
	
	public boolean isMsgSubmitSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgSubmitSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgCancelSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgCancelSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLblMyTimesheetDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, lblMyTimesheet);
			if (driver.findElement(lblMyTimesheet).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnSubmitDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnSubmit).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnEdit).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnCancelDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnCancel).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
