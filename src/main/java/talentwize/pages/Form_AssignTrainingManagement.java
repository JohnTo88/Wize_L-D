package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AssignTrainingManagement extends WebActions
{

	public Form_AssignTrainingManagement(WebDriver _driver) {
		super(_driver);
	}

	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public void clickBtnSave()
	{
		waitForElementClickable(5,btnSave);
		clickByJavaScript(btnSave);
	}
}
