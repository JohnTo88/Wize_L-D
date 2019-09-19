package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddInterviewHistory extends WebActions {

	By btnSave = By.xpath("//button[@type='button'][contains(.,'Save')]");
	By drplistSelectEmployee = By.xpath("//span[contains(.,'Select Employee...')]");
	By listOptFist = By.xpath("(//div[@ng-bind-html='obj.nameCombobox'])[1]");
    
	public Form_AddInterviewHistory(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void addInterviewer()
	{
		
		clickByJavaScript(drplistSelectEmployee);
		clickByJavaScript(listOptFist);
		clickByJavaScript(btnSave);
		
		
	}

}
