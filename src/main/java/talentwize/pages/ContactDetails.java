package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ContactDetails extends WebActions {
    By btnEdit = By.xpath("//button[contains(.,'Edit')]");
    By btnSave = By.xpath("//button[contains(.,'Save')]");
    By messageUpdateSuccess = By.xpath("//span[contains(.,'Updated successfully')]");
    
    
	public ContactDetails(WebDriver _driver) {
		super(_driver);
	
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnEdit).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickButtonEdit()
	{
		clickByJavaScript(btnEdit);
	}
	
	public void clickButtonSave()
	{
		clickByJavaScript(btnSave);
	}
	
	public boolean isMessageUpdateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	

}
