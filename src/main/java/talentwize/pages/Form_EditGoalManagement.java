package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditGoalManagement extends WebActions 
{
	public Form_EditGoalManagement(WebDriver _driver) {
		super(_driver);
	}

	By btnUpdate = By.xpath("//button[@ng-click='save()']");
	
	public void clickBtnUpdate()
	{
		waitForElementClickable(5, btnUpdate);
		clickByJavaScript(btnUpdate);
	}
}
