package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateCustomField extends WebActions {

	By txtSubModule = By.xpath("//span[contains(.,'Select a Sub Module...')]"); 
	By Option1 = By.xpath("(//div[@ng-bind-html='type.value'])[1]");
	By txtFieldLabel = By.xpath("//input[@ng-model='customField.labelText']");
	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public Form_CreateCustomField(WebDriver _driver) {
		super(_driver);
		
	}

	public void clickTxtSubModule()
	{
		waitForElementClickable(10, txtSubModule);
		clickByJavaScript(txtSubModule);
		
	}
	
	public void clickOption1()
	{
		waitForElementClickable(10, Option1);
		clickByJavaScript(Option1);
	}
	
	public void fillFieldLabel(String label)
	{
		goTextOn(txtFieldLabel, label);
	}
	
	public void clickButtonCreate()
	{
		waitForElementClickable(10, btnCreate);
		clickByJavaScript(btnCreate);
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	  
}
