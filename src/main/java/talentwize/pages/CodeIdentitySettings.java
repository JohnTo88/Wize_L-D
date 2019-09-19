package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CodeIdentitySettings extends WebActions {

	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	
	By radioButtonOFF = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Employee'])[1]/following::i[1]"); 
	
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	By messageUpdateSuccess = By.xpath("//span[contains(.,'Update Identity settings successfully!')]");
	
	public CodeIdentitySettings(WebDriver driver) {
		super(driver);
		
	}

	public boolean isButtonEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnEdit).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickButtonEdit()
	{
		waitForElementClickable(10, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public boolean isMessageUpdateSuccessDisplayed() throws InterruptedException {
		waitForPageLoaded();
		try {
			if ( driver.findElement(messageUpdateSuccess).isDisplayed()==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			
		
			return false;
		}
	}
	
}
