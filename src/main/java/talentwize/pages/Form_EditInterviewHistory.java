package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditInterviewHistory extends WebActions {

	By btnSave = By.xpath("//button[@type='button'][contains(.,'Save')]");
	
	
	public Form_EditInterviewHistory(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void editInterviewHistory()
	{
		waitForElementClickable(10,btnSave);
		clickByJavaScript(btnSave);
	}
	
	

}
