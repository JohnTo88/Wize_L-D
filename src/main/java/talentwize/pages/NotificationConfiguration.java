package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class NotificationConfiguration extends WebActions {

	By btnEditLeave = By.xpath("(//button[contains(.,'Edit')])[1]");
	By btnSaveLeave = By.xpath("(//button[contains(.,'Save')])[1]");
	By btnCancelLeave = By.xpath("(//button[contains(.,'Cancel')])[1]");
	By messageUpdateSuccess = By.xpath("//span[contains(.,'Update leave successfully!')]");
	By btnEditTimeSheet = By.xpath("(//button[contains(.,'Edit')])[2]");
	By btnEdit = By.xpath("(//button[contains(.,'Edit')])");
	By option_ON_OFF_Email = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Leave'])[2]/following::label[1]");
	By option_ON_OFF_TimeSheet = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Timesheet'])[2]/following::label[1]");
	
	
	public NotificationConfiguration(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isButtonEditLeaveDisplayed()
	{
		boolean flag = false;

		try {
			waitForElementClickable(15, btnEditLeave);
			if (driver.findElement(btnEditLeave).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}
	
	public boolean isMessageUpdateSuccessDisplayed()
	{
		boolean flag = false;

		try {
			waitForElementClickable(15, messageUpdateSuccess);
			if (driver.findElement(messageUpdateSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}
	
	public void clickButtonSaveLeave()
	{
		waitForElementClickable(10,btnSaveLeave);
		clickByJavaScript(btnSaveLeave);
	}
	
	public void clickButtonCancelLeave()
	{
		waitForElementClickable(10,btnCancelLeave);
		clickByJavaScript(btnCancelLeave);
	}
	
	public boolean isOption_ON_OFF_Email_Displayed()
	{
		boolean flag = false;

		try {
			waitForElementClickable(15, option_ON_OFF_Email);
			if (driver.findElement(option_ON_OFF_Email).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}
	
	public boolean isOption_ON_OFF_TimeSheet_Displayed()
	{
		boolean flag = false;

		try {
			waitForElementClickable(15, option_ON_OFF_TimeSheet);
			if (driver.findElement(option_ON_OFF_TimeSheet).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}
	
	public void clickButtonEditLeave()
	{
		waitForElementClickable(10,btnEditLeave);
		clickByJavaScript(btnEditLeave);
	}
	
	public boolean isButtonEditTimeSheetDisplayed()
	{
		boolean flag = false;

		try {
			waitForElementClickable(15, btnEditTimeSheet);
			if (driver.findElement(btnEditTimeSheet).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}
	
	

}
