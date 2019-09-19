package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditChosenSuccessor extends WebActions
{

	public Form_EditChosenSuccessor(WebDriver _driver) {
		super(_driver);
	}

	By btnSubmit = By.xpath("//button[@ng-click='submit()']");
	
	public void clickBtnSubmit()
	{
		clickByJavaScript(btnSubmit);
	}
}
