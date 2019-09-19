package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddProjectCategory extends WebActions 
{

	By txtName = By.xpath("//input[@ng-model='projectCategory.name']");
	By btnSave = By.xpath("//button[@ng-click='ok()']");
	
	public Form_AddProjectCategory(WebDriver _driver) {
		super(_driver);
	}
	
	public void fillTxtName(String NameOfProjectCategory)
	{
		waitForElementClickable(5, txtName);
		clickByJavaScript(txtName);
		goTextOn(txtName, NameOfProjectCategory);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
}
