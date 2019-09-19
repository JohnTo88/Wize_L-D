package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class LeaveConfigurations extends WebActions {

	By tabManagementConfiguration = By.xpath("//tab-heading[contains(.,'Management Configuration')]");
	By tabLeaveType = By.xpath("//tab-heading[contains(.,'Leave Type')]");
	By tabLeavePolicy = By.xpath("//tab-heading[contains(.,'Leave Policy')]");
	By tabLeaveBalance = By.xpath("//tab-heading[contains(.,'Leave Balance')]");
	By tabPublicHoliday = By.xpath("//tab-heading[contains(.,'Public Holiday')]");
	By tabWorkingDays = By.xpath("//tab-heading[contains(.,'Working Days')]");
	
	public LeaveConfigurations(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void openTabManagementConfiguration()
	{
		waitForElementClickable(10, tabManagementConfiguration);
		clickByJavaScript(tabManagementConfiguration);
		sleep(5);
	}
	
	public void openTabLeaveType()
	{
		waitForElementClickable(10, tabLeaveType);
		clickByJavaScript(tabLeaveType);
		sleep(5);
	}
	
	public void openTabLeavePolicy()
	{
		waitForElementClickable(10, tabLeavePolicy);
		clickByJavaScript(tabLeavePolicy);
		sleep(5);
	}
	
	public void openTabLeaveBalance()
	{
		waitForElementClickable(10, tabLeaveBalance);
		clickByJavaScript(tabLeaveBalance);
		sleep(5);
	}
	
	public void openTabPublicHoliday()
	{
		waitForElementClickable(10, tabPublicHoliday);
		clickByJavaScript(tabPublicHoliday);
		sleep(5);
	}
	
	public void openTabWorkingDays()
	{
		waitForElementClickable(10, tabWorkingDays);
		clickByJavaScript(tabWorkingDays);
		sleep(5);
	}
	
	public boolean isTabManagementConfigurationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tabManagementConfiguration).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isTabLeaveTypeDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tabLeaveType).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

	public boolean isTabLeavePolicyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tabLeavePolicy).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isTabLeaveBalanceDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tabLeaveBalance).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isTabPublicHolidayDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tabPublicHoliday).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isTabWorkingDaysDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tabWorkingDays).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
