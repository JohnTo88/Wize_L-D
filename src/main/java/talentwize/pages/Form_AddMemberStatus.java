package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddMemberStatus extends WebActions 
{

	By txtMemberStatusName = By.xpath("//input[@ng-model='userProjectStatus.status']");
	By btnSave = By.xpath("//button[@ng-click='ok()']");
	
	public Form_AddMemberStatus(WebDriver _driver) {
		super(_driver);
	}

	public void fillTxtMemberStatus(String NameOfMemberStatus)
	{
		waitForElementClickable(5, txtMemberStatusName);
		clickByJavaScript(txtMemberStatusName);
		goTextOn(txtMemberStatusName, NameOfMemberStatus);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
}
