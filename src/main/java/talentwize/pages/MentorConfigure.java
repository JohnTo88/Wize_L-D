package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MentorConfigure extends WebActions {
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By messageSuccess = By.xpath("//span[contains(.,'Update mentor successfully!')]");
	
	public MentorConfigure(WebDriver _driver) {
		super(_driver);
		
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
	
	public boolean isMessageSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(messageSuccess).isDisplayed() == true) {
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
	
	

}
