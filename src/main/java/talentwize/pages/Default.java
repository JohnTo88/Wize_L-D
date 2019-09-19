package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Default extends WebActions {
	
	public Default(WebDriver _driver) 
	{
		super(_driver);
	}
	
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	By msgEditSuccess = By.xpath("//span[@class='message-content'][contains(.,'Updated Successfully!')]");
	
	public void clickBtnEdit()
	{
		waitForElementClickable(5, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public boolean isBtnEditDisplayed()
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
	
	public boolean isMsgEditSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgEditSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
