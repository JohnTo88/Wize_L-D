package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GoalPreview extends WebActions {

	public GoalPreview(WebDriver _driver) {
		super(_driver);
		
	}
	
	By btnBack = By.xpath("//a[contains(.,'Back')]");
	By btnClone = By.xpath("//a[contains(.,'Clone')]");
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnUpdate = By.xpath("//button[contains(.,'Update')]");
	
	By btnUpdateProgress = By.xpath("//button[contains(.,'Update Progress')]");
	By messageUpdateSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update goal successfully!')]");
	By msgCreateSuccess = By.xpath("//span[@class='message-content'][contains(.,'Create goal successfully!')]");
	
	public boolean isBtnBackDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnBack);
			if (driver.findElement(btnBack).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnBack()
	{
		waitForElementClickable(5, btnBack);
		clickByJavaScript(btnBack);
	}
	
	public boolean isBtnUpdateProgressDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnUpdateProgress);
			if (driver.findElement(btnUpdateProgress).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickButtonBack()
	{
		clickByJavaScript(btnBack);
		
	}
	
	public boolean isBtnEditDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnEdit);
			if (driver.findElement(btnEdit).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean editAGoal()
	{
		clickByJavaScript(btnEdit);
		waitForElementClickable(10, btnUpdate);
		clickByJavaScript(btnUpdate);
		if (driver.findElement(messageUpdateSuccess).isDisplayed()==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean isBtnCloneDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnClone);
			if (driver.findElement(btnClone).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isMsgCreateGoalSuccessdDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, msgCreateSuccess);
			if (driver.findElement(msgCreateSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
