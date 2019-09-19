package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CopyTask_Timesheet extends WebActions
{

	public Form_CopyTask_Timesheet(WebDriver _driver) {
		super(_driver);
	}

	By drplistFormProject = By.xpath("(//span[contains(.,'Select project...')])[2]");
	By optProject = By.xpath("(//div[contains(@ng-bind-html,'project.name')])[1]");
	By drplistToProject = By.xpath("(//span[contains(.,'Select project...')])[3]");
	By optProject2 = By.xpath("(//div[contains(@ng-bind-html,'project.name')])[2]");
	By btnClone = By.xpath("//button[contains(.,'Clone')]");
	
	public void cloneTasks()
	{
		waitForElementClickable(5, drplistFormProject);
		clickByJavaScript(drplistFormProject);
		waitForElementClickable(5, optProject);
		clickByJavaScript(optProject);
		waitForElementClickable(5, drplistToProject);
		clickByJavaScript(drplistToProject);
		waitForElementClickable(5, optProject2);
		clickByJavaScript(optProject2);
		waitForElementClickable(5, btnClone);
		clickByJavaScript(btnClone);
	}

}
