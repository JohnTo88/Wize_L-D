package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddCategory extends WebActions {

	public Form_AddCategory(WebDriver _driver) {
		super(_driver);
		
	}
	
	By txtName = By.xpath("//input[contains(@ng-model,'jobTitle.name')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]"); 
	
	public void AddCategory(String nameCategory)
	{
		goTextOn(txtName, nameCategory);
		clickByJavaScript(btnSave);
	}

}
