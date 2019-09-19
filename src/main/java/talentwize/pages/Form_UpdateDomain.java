package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_UpdateDomain extends WebActions {
    
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	
	public Form_UpdateDomain(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickBtnCancel()
	{
		waitForElementClickable(10, btnCancel);
		clickByJavaScript(btnCancel);
	}
	
	public boolean isButtonSaveDisplayed()
	{
		boolean flag = false;
		
		try {
			if (driver.findElement(btnSave).isDisplayed()==true)
			flag = true;
			
			
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}

}
