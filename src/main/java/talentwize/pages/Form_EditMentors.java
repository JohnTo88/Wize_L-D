package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditMentors extends WebActions {
    By buttonSave = By.xpath("//button[contains(.,'Save')]");
    By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	public Form_EditMentors(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10, buttonSave);
		clickByJavaScript(buttonSave);
	}
	
	public void clickButtonCancel()
	{
		waitForElementClickable(10, btnCancel);
		clickByJavaScript(btnCancel);
	}
	
	
	

}
