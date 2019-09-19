package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TimesheetConfigurations_TimeOff extends WebActions
{

	public TimesheetConfigurations_TimeOff(WebDriver _driver) {
		super(_driver);
	}
	
	By btnAddTimeOff = By.xpath("//button[contains(.,'Add Time Off')]");
	By linkEdit1 = By.xpath("(//span[@ng-click='fn_on_name($index, item)'])[1]");
	By linkEdit2 = By.xpath("(//span[@ng-click='fn_on_name($index, item)'])[2]");
	By txtSearchTimeOff = By.xpath("//input[@placeholder='Search time off...']");
	
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By icoArrow = By.xpath("//span[@class='icon icon-arrow-down3']");
	By optCheckAll = By.xpath("//a[contains(.,'Check AllUncheck All')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	
	By msgAddSuccess = By.xpath("//span[@class='message-content'][contains(.,'Time off added successfully!')]");
	By msgUpdateSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update time off successfully!')]");
	By msgDeleteSuccess = By.xpath("//span[@class='message-content'][contains(.,'Task deleted successfully!')]");
	
	public void clickBtnAddTimeOff()
	{
		waitForElementClickable(10, btnAddTimeOff);
		clickByJavaScript(btnAddTimeOff);
	}
	
	public void clickLinkEdit1()
	{
		waitForElementClickable(10, linkEdit1);
		clickByJavaScript(linkEdit1);
	}
	
	public void clickLinkEdit2()
	{
		waitForElementClickable(10, linkEdit2);
		clickByJavaScript(linkEdit2);
	}
	
	public void fillTxtTimeOff(String TimeOff)
	{
		waitForElementClickable(10, txtSearchTimeOff);
		goTextOn(txtSearchTimeOff, TimeOff);
	}
	
	public void deleteTimeOff()
	{
		waitForElementClickable(5,icoArrow);
		clickByJavaScript(icoArrow);
		waitForElementClickable(5,optCheckAll);
		clickByJavaScript(optCheckAll);
		waitForElementClickable(5,icoDelete);
		clickByJavaScript(icoDelete);
		waitForElementClickable(5,btnYes);
		clickByJavaScript(btnYes);
	}
	
	public boolean isBtnAddTimeOffDisplayed() {
		try {
			if (driver.findElement(btnAddTimeOff).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isLinkEditDisplayed() {
		try {
			if (driver.findElement(linkEdit1).isDisplayed() == true || driver.findElement(linkEdit2).isDisplayed() ==true ) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isIcoDeleteDisplayed() {
		try {
			if (driver.findElement(icoDelete).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isMsgAddSuccessDisplayed() {
		try {
			if (driver.findElement(msgAddSuccess).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isMsgUpdateSuccessDisplayed() {
		try {
			if (driver.findElement(msgUpdateSuccess).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isMsgDeleteSuccessDisplayed() {
		try {
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
}
