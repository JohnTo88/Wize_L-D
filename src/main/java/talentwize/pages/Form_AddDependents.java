package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddDependents extends WebActions {
 
	By txtName = By.xpath("//input[contains(@ng-model,'dependent.name')]");
	By drpRelationShip = By.xpath("//span[contains(.,'Select relationship...')]");
	By optionFather = By.xpath("(//div[contains(@class,'ng-binding ng-scope')])[1]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public Form_AddDependents(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void addDepenents(String _name)
	{
		waitForElementClickable(10, txtName);
		goTextOn(txtName, _name);
		clickByJavaScript(drpRelationShip);
		clickByJavaScript(optionFather);
		clickByJavaScript(btnSave);
	}
	
	public void clickButonSave()
	{
		clickByJavaScript(btnSave);
	}
	
	
	

}
