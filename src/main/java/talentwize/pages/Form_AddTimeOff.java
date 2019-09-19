package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddTimeOff extends WebActions
{

	public Form_AddTimeOff(WebDriver _driver) {
		super(_driver);
	}
	
	By txtName = By.xpath("//input[@ng-model='timeoff.name']");
	By btnAdd = By.xpath("//span[@class='ng-scope'][contains(.,'Add')]");
	
	private void fillTxtName(String Name)
	{
		waitForElementClickable(10, txtName);
		goTextOn(txtName, Name);
	}
	
	public void addTimeOff(String Name)
	{
		fillTxtName(Name);
		clickByJavaScript(btnAdd);
	}
}
