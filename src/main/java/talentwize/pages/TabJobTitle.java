package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabJobTitle extends WebActions {

	public TabJobTitle(WebDriver _driver) {
		super(_driver);
		
	}

	By btnAdd = By.xpath("//button[contains(.,'Add')]"); 
	By iconDelete = By.xpath("//i[@class='icon icon-bin']"); 
	By linksJobTitle = By.xpath("(//a[@ng-if='permission.allowUpdating'])");
	By fistLinkJobTitle = By.xpath("(//a[@ng-if='permission.allowUpdating'])[1]");
	By btnExport = By.xpath("//button[contains(.,'Export')]");
	
    By msgAddedSuccess = By.xpath("//span[contains(.,'Job Title added successfully!')]");
    By msgUpdateSuccess = By.xpath("//span[contains(.,'Job Title updated successfully!')]"); 
    By msgDeleteSuccess = By.xpath("//span[contains(.,'Job Titles deleted successfully!')]"); 
    
    By cboxDelete = By.xpath("//label[@ng-if='jobTitle.isDeletable']");
    By btnDelete = By.xpath("//button[contains(.,'Delete')]");
    
	public void clickButtonAdd()
	{
		waitForElementClickable(5,btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public void deleteJobTitle()
	{
		clickByJavaScript(cboxDelete);
		clickByJavaScript(iconDelete);
		sleep(1);
		clickByJavaScript(btnDelete);
	}
	
	
	public void clickFistLinkJobTitle ()
	{
		clickByJavaScript(fistLinkJobTitle);
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
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true) {
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
	
	public boolean isButtonExportDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnExport).isDisplayed() == true) {
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
	
	public boolean areLinksJobTitleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linksJobTitle).size()>0) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
}
