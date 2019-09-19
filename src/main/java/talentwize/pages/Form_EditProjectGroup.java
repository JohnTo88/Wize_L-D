package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditProjectGroup extends WebActions
{
	By btnSave = By.xpath("//button[@ng-click='saveProjectBoard()']");
	
	public Form_EditProjectGroup(WebDriver _driver) {
		super(_driver);
	}

	public void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
}
