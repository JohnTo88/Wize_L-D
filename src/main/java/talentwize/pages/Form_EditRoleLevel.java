package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditRoleLevel extends WebActions {

	public Form_EditRoleLevel(WebDriver _driver) {
		super(_driver);
		
	}
	
	By txtName = By.xpath("//input[contains(@ng-model,'roleLevel.name')]"); 
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public void editRoleLevel(String roleLevel)
	{
		goTextOn(txtName,"%34" + roleLevel);
		clickByJavaScript(btnSave);
	}
	
	
	

}
