package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabRoleLevel extends WebActions {

	public TabRoleLevel(WebDriver _driver) {
		super(_driver);
		
	}

	By btnAdd = By.xpath("//button[contains(.,'Add')]"); 
	By iconDelete = By.xpath("//i[@class='icon icon-bin']"); 
	By linksRoleLevel = By.xpath("(//a[@ng-if='permission.allowUpdating'])");
    By msgAddedSuccess = By.xpath("//span[contains(.,'Role Level added successfully!')]");
    By msgDeletedSuccess = By.xpath("//span[contains(.,'Role Levels deleted successfully!')]");
    By fistLinkRoleLevel = By.xpath("(//a[@ng-if='permission.allowUpdating'])[1]");
    By msgUpdateSuccess = By.xpath("//span[contains(.,'Role Level updated successfully!')]"); 
    By cboxDelete = By.xpath("//label[@ng-if='roleLevel.isDeletable']"); 
    By btnYes = By.xpath("//button[contains(.,'Delete')]");
    
    
    
	public void clickButtonAdd()
	{
		waitForElementClickable(5,btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public void deleteRoleLevel()
	{
		clickByJavaScript(cboxDelete);
		clickByJavaScript(iconDelete);
		sleep(1);
		clickByJavaScript(btnYes);
	}
	
	
	
	public void clickFistLinkRoleLevel()
	{
		waitForElementClickable(5,fistLinkRoleLevel);
		clickByJavaScript(fistLinkRoleLevel);
	}
	
	public boolean isMsgUpdateSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgUpdateSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgDeletedSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isButtonAddDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isIconDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(iconDelete).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgAddedSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgAddedSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean areLinksRoleLevelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linksRoleLevel).size()>0) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
