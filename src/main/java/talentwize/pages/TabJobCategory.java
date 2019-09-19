package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabJobCategory extends WebActions {

	public TabJobCategory(WebDriver _driver) {
		super(_driver);
		
	}
	
	By btnAdd = By.xpath("//div[@ng-click='add()']"); 
	By iconDelete = By.xpath("//i[@class='icon icon-bin']"); 
	By linksJobCategory = By.xpath("(//a[@ng-if='permission.allowUpdating'])");
	By fistLinkjobCategory = By.xpath("(//a[@ng-if='permission.allowUpdating'])[1]"); 
    By msgAddedSuccess = By.xpath("//span[contains(.,'Job Category added successfully!')]");
    By msgUpdateSuccess = By.xpath("//span[contains(.,'Job Category updated successfully!')]");
    By msgDeleteSuccess = By.xpath("//span[contains(.,'Job Categories deleted successfully!')]"); 
    
    By cboxDelete = By.xpath("(//label[@class='i-checkbox m-b-0'])[4]");
    By btnYes = By.xpath("//button[contains(.,'Delete')]");
    
	public void clickButtonAdd()
	{
		waitForElementClickable(5,btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public void deleteJobCategory()
	{
		waitForElementClickable(5,cboxDelete);
		clickByJavaScript(cboxDelete);
		clickByJavaScript(iconDelete);
		sleep(1);
		clickByJavaScript(btnYes);
	
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
	
	public void clickFistLinkJobCategory()
	{
		waitForElementClickable(5,fistLinkjobCategory);
		clickByJavaScript(fistLinkjobCategory);
	}
	
	public boolean isButtonAddDisplayed()
	{
		sleep(2);
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
	
	public boolean areLinksJobCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linksJobCategory).size()>0) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

}
