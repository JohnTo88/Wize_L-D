package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddProjectGroup extends WebActions 
{

	By txtName = By.xpath("//input[contains(@ng-model,'board.name')]");
	By btnSave = By.xpath("//button[@ng-click='saveProjectBoard()']");
	By cbox1 = By.xpath("(//label[@class='i-checkbox'])[1]");
	By cbox2 = By.xpath("(//label[@class='i-checkbox'])[2]");
	By btnArrownRight = By.xpath("//button[@ng-click='select()']");
	
	public Form_AddProjectGroup(WebDriver _driver) {
		super(_driver);
	}

	public void fillTxtName(String NameOfGroup)
	{
		waitForElementClickable(5, txtName);
		clickByJavaScript(txtName);
		goTextOn(txtName, NameOfGroup);
	}
	
	public void clickCbox1()
	{
		clickByJavaScript(cbox1);
	}
	
	public void clickCbox2()
	{
		clickByJavaScript(cbox2);
	}
	
	public void clickBtnArrownRight()
	{
		clickByJavaScript(btnArrownRight);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
	
	public void createProjectGroup(String NameOfGroup)
	{
		fillTxtName(NameOfGroup);
		sleep(2);
		clickCbox1();
		sleep(2);
		clickCbox2();
		clickBtnArrownRight();
		clickBtnSave();
	}
}
