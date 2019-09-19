package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TimesheetManagement extends WebActions 
{

	public TimesheetManagement(WebDriver _driver) {
		super(_driver);
	}

	By btnSettings = By.xpath("//a[@href='#/te/timesheet/setting/task']");
	By txtSearchEmployee = By.xpath("//input[@placeholder='Employees search...']");
	By linkDetail = By.xpath("(//span[@ng-click='getTimesheetDetail($index, employee)'])[1]");
	
	public void clickBtnSettings()
	{
		waitForElementClickable(5, btnSettings);
		clickByJavaScript(btnSettings);
	}
	
	public void fillTxtSearchEmployee(String Employee)
	{
		waitForElementClickable(5, txtSearchEmployee);
		goTextOn(txtSearchEmployee, Employee);
		sleep(5);
	}
	
	public void clickLinkDetail()
	{
		waitForElementClickable(5, linkDetail);
		clickByJavaScript(linkDetail);
	}
}
