package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AuthenticationLogs extends WebActions {

	By searchUsers = By.xpath("//input[@ng-model='condition.userName']");
	
	By buttonUnlock = By.xpath("//button[@type='button'][contains(.,'Unlock')]");
	public AuthenticationLogs(WebDriver driver) {
		super(driver);
		
	}
	
	public void searchUsers(String user)
	{
		waitForElementClickable(10,searchUsers);
		goTextOn(searchUsers, user);
	}
	
	public boolean isSearchUserFound(String UserLock)
	{
		try {
			if (driver.findElement(searchUsers).isDisplayed()==true)
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
	
	public boolean isButtonUnlockFound()
	{
		try {
			if ( driver.findElement(buttonUnlock).isDisplayed()==true)
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
