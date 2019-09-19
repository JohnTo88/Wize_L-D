package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TimesheetConfigurations extends WebActions
{

	public TimesheetConfigurations(WebDriver _driver) {
		super(_driver);
	}
	
	By subTabTask = By.xpath("//tab-heading[contains(.,'Task')]");
	By subTabTimeOff = By.xpath("//tab-heading[contains(.,'Time off')]");

	public void clickSubTabTask() {
		waitForElementClickable(10, subTabTask);
		clickByJavaScript(subTabTask);
	}
	
	public void clickSubTabTimeOff() {
		waitForElementClickable(10, subTabTimeOff);
		clickByJavaScript(subTabTimeOff);
	}
	
	public boolean isSubTabTaskDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subTabTask).isDisplayed() == true) {


				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubTabTimeOffDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subTabTimeOff).isDisplayed() == true) {


				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

}
