package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddSkill extends WebActions
{

	By txtSkillName = By.xpath("//input[contains(@ng-model,'skill.name')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public Form_AddSkill(WebDriver _driver) {
		super(_driver);
	}

	public void fillTxtSkillName(String NameOfSkill)
	{
		waitForElementClickable(5, txtSkillName);
		clickByJavaScript(txtSkillName);
		goTextOn(txtSkillName, NameOfSkill);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
	
}
