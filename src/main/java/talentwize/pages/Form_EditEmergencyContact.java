package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditEmergencyContact extends WebActions {

	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public Form_EditEmergencyContact(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}

	
	
}
