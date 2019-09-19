package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddTask_Timesheet extends WebActions
{

	public Form_AddTask_Timesheet(WebDriver _driver) {
		super(_driver);
	}

	By txtName = By.xpath("//input[@ng-model='task.name']");
	By drplistProject = By.xpath("(//span[contains(.,'Select project...')])[2]");
	By btnSave = By.xpath("//button[@ng-click='save()']");
	By optProejct = By.xpath("(//div[@ng-bind-html='project.name'])[1]");
	
	private void clickBtnSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	
	private void clickOptProejct()
	{
		waitForElementClickable(10, optProejct);
		clickByJavaScript(optProejct);
	}
	
	private void clickDrplistProject()
	{
		waitForElementClickable(10, drplistProject);
		clickByJavaScript(drplistProject);
	}
	
	private void fillTxtName(String Name)
	{
		waitForElementClickable(10, txtName);
		goTextOn(txtName, Name);
	}
	
	public void addTask(String Name)
	{
		fillTxtName(Name);
		clickDrplistProject();
		clickOptProejct();
		clickBtnSave();
	}
}
