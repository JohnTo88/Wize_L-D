package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import controller.WebActions;

public class AuditLog extends WebActions {

	By modules = By.xpath("//tab-heading[contains(.,'Modules')]");
	By mailbox = By.xpath("//tab-heading[contains(.,'Mailbox')]");
	By authenticationLogs = By.xpath("//tab-heading[contains(.,'Authentication Logs')]");
	By autoJob = By.xpath("//tab-heading[contains(.,'Auto Job')]");

	public AuditLog(WebDriver driver) {
		super(driver);

	}
	
	public void openModules() {
		waitForElementClickable(10,mailbox);
		clickByJavaScript(mailbox);

	}

	public void openMailBox() {
		waitForElementClickable(10,mailbox);
		clickByJavaScript(mailbox);

	}

	public void openAuthenticationLogs() {
		waitForElementClickable(10,authenticationLogs);
		clickByJavaScript(authenticationLogs);

	}

	public void openAutoJob() {
		waitForElementClickable(10,autoJob);
		clickByJavaScript(autoJob);

	}
	
	public boolean isAuthencationLogsDisplayed()
	{
		try {
			if (driver.findElement(authenticationLogs).isDisplayed()==true)
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
	
	public boolean isModulesDisplayed()
	{
		try {
			if (driver.findElement(modules).isDisplayed()==true)
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
	
	public boolean isMailboxDisplayed()
	{
		try {
			if (driver.findElement(mailbox).isDisplayed()==true)
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
	
	
	public boolean isJobAutoDisplayed()
	{
		try {
			if (driver.findElement(autoJob).isDisplayed()==true)
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
