package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabRoleTitle extends WebActions {

	public TabRoleTitle(WebDriver _driver) {
		super(_driver);
		
	}
	
	By btnAdd = By.xpath("//button[contains(.,'Add')]"); 
	By iconDelete = By.xpath("//i[@class='icon icon-bin']"); 
	By linksRoleTitle = By.xpath("(//a[@ng-if='permission.allowUpdating'])");
    By msgAddedSuccess = By.xpath("//span[contains(.,'Role Title added successfully!')]");
    
    By fistLinkRoleTitle = By.xpath("(//a[@ng-if='permission.allowUpdating'])[1]"); 
    By msgUpdateSucces = By.xpath("//span[contains(.,'Role Title updated successfully!')]"); 
    
    By msgDeleteSuccess = By.xpath("//span[contains(.,'Role Titles deleted successfully!')]"); 
    By cboxDelete = By.xpath("(//label[@ng-if='roleTitle.isDeletable'])");
    By btnYes = By.xpath("//button[contains(.,'Delete')]"); 
    
	public void clickButtonAdd()
	{
		waitForElementClickable(5,btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public void deleteRoleTitle()
	{
		clickByJavaScript(cboxDelete); 
		clickByJavaScript(iconDelete); 
		sleep(1); 
		clickByJavaScript(btnYes); 
	} 
	
	public boolean isMsgUpdateSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgUpdateSucces).isDisplayed() == true) {
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
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public void clickFistLinkRoleTitle()
	{
		waitForElementClickable(3, fistLinkRoleTitle);
		clickByJavaScript(fistLinkRoleTitle);
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
	
	public boolean areLinksRoleTitleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linksRoleTitle).size()>0) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

}
