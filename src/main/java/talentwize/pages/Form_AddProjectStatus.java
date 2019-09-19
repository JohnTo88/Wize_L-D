package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddProjectStatus extends WebActions
{
	By txtProjectStatusName = By.xpath("//input[contains(@ng-model,'projectStatus.name')]");
	By btnSave = By.xpath("//button[@ng-click='ok()']");
	
	public Form_AddProjectStatus(WebDriver _driver) {
		super(_driver);
	}

	public void fillTxtProjectStatus(String NameOfProjectStatus)
	{
		waitForElementClickable(5, txtProjectStatusName);
		clickByJavaScript(txtProjectStatusName);
		goTextOn(txtProjectStatusName, NameOfProjectStatus);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
}
