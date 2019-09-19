package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddProjectClient extends WebActions
{

	By txtClientName = By.xpath("//input[contains(@ng-model,'client.name')]");
	By btnSave = By.xpath("//button[@ng-click='ok()']");
	
	public Form_AddProjectClient(WebDriver _driver) {
		super(_driver);
	}

	public void fillTxtClientName(String NameOfCLient)
	{
		waitForElementClickable(5, txtClientName);
		clickByJavaScript(txtClientName);
		goTextOn(txtClientName, NameOfCLient);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
	
}
