package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Quota extends WebActions {
    By btnAddQuota = By.xpath("(//div[contains(.,'Add Quota')])[12]");
    By btnExport = By.xpath("//button[@type='button'][contains(.,'Export')]");
    By linkOfProject = By.xpath("(//a[contains(@ng-click,'goToProjectDetail($event,quota.projectId)')])[1]");
    By chkProject=By.xpath("(//label[contains(@ng-click,'toggleCheckItem(quota)')])[1]");
    By btnDelete_Project=By.xpath("//i[@class='icon icon-bin']");
    By btnDelete=By.xpath("//button[contains(.,'Delete')]");
    By btnCancel=By.xpath("//button[contains(.,'Cancel')]");
    By btnSave=By.xpath("//div[@ng-click='saveChange()']");
    By msgAddedSuccessfully=By.xpath("//span[contains(.,'The quota has been updated successfully. Updated items only show if they match the current filter selections')]");
    By msgUpdateSuccessfully=By.xpath("//span[contains(.,'The quota has been updated successfully. Updated items only show if they match the current filter selections')]");
    By msgDeletedSuccessfully=By.xpath("//span[contains(.,'Quotas deleted successfully!')]");
    By btnEdit=By.xpath("(//i[contains(@class,'fa fa-edit')])[1]");
    By lblProjectCategory=By.xpath("//th[contains(.,'Project Category')]");
    By btnDeleteConfirm = By.xpath("//button[contains(.,'Delete')]");
    
    public boolean isMsgAddedSuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddedSuccessfully).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgUpdateSuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgUpdateSuccessfully).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgDeleteSuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletedSuccessfully).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public Quota(WebDriver _driver) {
		super(_driver);
	
	}
	
	public boolean isbtnAddQuotaDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(10, btnAddQuota);
			if (driver.findElement(btnAddQuota).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnExportDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnExport).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean islinkOfProjectDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkOfProject).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfProject()
	{
		waitForElementClickable(5, linkOfProject);
		clickByJavaScript(linkOfProject);
	}
	
	public boolean isbtnDelete_ProjectDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDelete_Project).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnDeleteProjectDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDelete_Project).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnCancelDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnCancel).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnEditDisplayed()
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
	public boolean islblProjectCategoryDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblProjectCategory).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void clickbtnAddQuota()
	{
		waitForElementClickable(10, btnAddQuota);
		clickByJavaScript(btnAddQuota);
	}
	
	public void clickbtnEditQuota()
	{
		waitForElementClickable(10, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickbtnSaveQuota()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	
	
	public void deleteProject()
	{
       clickByJavaScript(chkProject);
       clickByJavaScript(btnDelete_Project);
       clickByJavaScript(btnDeleteConfirm);
       
	}
}
