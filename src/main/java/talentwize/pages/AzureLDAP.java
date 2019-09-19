package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AzureLDAP extends WebActions {
    
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnSyncNow = By.xpath("//button[contains(.,'Sync Now')]");
	By btnAddMapping = By.xpath("//button[contains(.,'Add Mapping')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By messageUpdateSuccess = By.xpath("//span[contains(.,'Update successfully')]");
	By rdioAutoSyncOn = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='w'])[1]/preceding::i[3]");
	public AzureLDAP(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isButtonEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnEdit).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public void clickButtonEdit()
	{
		
		clickByJavaScript(btnEdit);
	}
	
	public void clickRadioAutoSyncOn()
	{
		try {
			waitForElementPresent(5, rdioAutoSyncOn);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		clickByJavaScript(rdioAutoSyncOn);
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10,btnSave);
		clickByJavaScript(btnSave);
	}
	
	public boolean isButtonSyncNowDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnSyncNow).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public boolean isMessageUpdateSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public boolean isButtonAddMappingDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnAddMapping).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	

}
