package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class PowerBI extends WebActions {

	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By messageUpdateSuccess = By.xpath("//span[contains(.,'Update successfully')]");
	
	public PowerBI(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isButtonEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnEdit).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag =false;
		}
		
		return flag;
	}
	
	public boolean isMessageUpdateSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag =false;
		}
		
		return flag;
	}
	
	public boolean isButtonSaveDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnSave).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag =false;
		}
		
		return flag;
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickButtonEdit()
	{
		waitForElementClickable(10, btnEdit);
		clickByJavaScript(btnEdit);
	}
	

}
