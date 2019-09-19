package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddProjectRole extends WebActions 
{

	By txtProjectRoleName = By.xpath("//input[contains(@ng-model,'projectPosition.name')]");
	By btnSave = By.xpath("//button[@ng-click='ok()']");
	
	public Form_AddProjectRole(WebDriver _driver) {
		super(_driver);
	}

	public void fillTxtProjectRole(String NameOfProjectRole)
	{
		waitForElementClickable(5, txtProjectRoleName);
		clickByJavaScript(txtProjectRoleName);
		goTextOn(txtProjectRoleName, NameOfProjectRole);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
}
