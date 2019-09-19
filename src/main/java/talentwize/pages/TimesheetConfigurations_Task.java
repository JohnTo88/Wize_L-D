package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TimesheetConfigurations_Task extends WebActions
{

	public TimesheetConfigurations_Task(WebDriver _driver) {
		super(_driver);
	}

	By btnCopyTasks = By.xpath("//button[contains(.,'Copy Tasks')]");
	By btnAddTask = By.xpath("//button[contains(.,'Add Task')]");
	By txtSearchTask = By.xpath("//input[@placeholder='Search tasks...']");
	By linkEdit = By.xpath("(//span[@ng-click='fn_on_name($index, item)'])[1]");
	
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By icoArrow = By.xpath("//span[@class='icon icon-arrow-down3']");
	By optCheckAll = By.xpath("//a[contains(.,'Check AllUncheck All')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	
	By msgDeleteSuccess = By.xpath("//span[@class='message-content'][contains(.,'Task deleted successfully!')]");
	By msgAddSuccess = By.xpath("//span[@class='message-content'][contains(.,'Task added successfully!')]");
	By msgEditSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update task successfully!')]");
	By msgCloneSuccess = By.xpath("//span[@class='message-content'][contains(.,'Tasks clones successfully!')]");
	By msgImportSucces = By.xpath("//span[@class='message-content'][contains(.,'Import Successful')]");
	
	By btnImport = By.xpath("//button[contains(.,'Import')]");
	
	public void clickBtnCopyTasks()
	{
		waitForElementClickable(10, btnCopyTasks);
		clickByJavaScript(btnCopyTasks);
	}
	
	public void clickBtnImport()
	{
		waitForElementClickable(10, btnImport);
		clickByJavaScript(btnImport);
	}
	
	public void clickBtnAddTask()
	{
		waitForElementClickable(10, btnAddTask);
		clickByJavaScript(btnAddTask);
	}
	
	public void clickLinkEdit()
	{
		waitForElementClickable(10, linkEdit);
		clickByJavaScript(linkEdit);
	}
	
	public void fillTxtSearchTask(String Task)
	{
		sleep(5);
		waitForElementClickable(10, txtSearchTask);
		goTextOn(txtSearchTask, Task);
	}
	
	public void deleteTasks()
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
	
	public boolean isBtnCopyTasksDisplayed() {
		try {
			if (driver.findElement(btnCopyTasks).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	
	
	public boolean isBtnAddTaskDisplayed() {
		try {
			if (driver.findElement(btnAddTask).isDisplayed() == true) {
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
			if (driver.findElement(linkEdit).isDisplayed() == true) {
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
	
	public boolean isMsgEditSuccessDisplayed() {
		try {
			if (driver.findElement(msgEditSuccess).isDisplayed() == true) {
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
	
	public boolean isMsgCloneSuccessDisplayed() {
		try {
			if (driver.findElement(msgCloneSuccess).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isMsgImportSuccessDisplayed() {
		try {
			
			waitForElementPresent(25,msgImportSucces);
			if (driver.findElement(msgImportSucces).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
}
