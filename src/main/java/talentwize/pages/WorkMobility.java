package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class WorkMobility extends WebActions {
    By btnAddImmigration = By.xpath("(//button[contains(.,'Add')])[1]");
    By btnAddRightToWork= By.xpath("(//button[contains(.,'Add')])[2]");
    
    By btnDelete_Immigration=By.xpath("(//i[@class='icon icon-bin'])[1]");
    By btnDelete_RightToWork=By.xpath("(//i[contains(@class,'icon icon-bin')])[2]");
    
    By linkOfImmigration = By.xpath("(//span[@class='link-redirect ng-binding'])[1]");
    By linkOfRightToWork=By.xpath("//span[contains(@ng-click,'editRightToWork(rtw, $index)')]");
    
    By msgAddedSuccessfully=By.xpath("//span[contains(.,'Added successfully')]");
    By msgUpdateSuccessfully=By.xpath("(//div[contains(.,'Updated successfully')])[2]");
    By msgDeletedSuccessfully=By.xpath("//span[contains(.,'Deleted successfully')]");
    
    By chkImmigration=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Attachment'])[1]/following::label[1]");
    
    By chkRightToWork=By.xpath("(//span[@class='icon icon-arrow-down3'])[2]");
    By chkRightToWork_all=By.xpath("//a[contains(@ng-click,'showDropDownCheckAllRtw = false; checkAllRtws()')]");
    
    By btnYes=By.xpath("//button[contains(.,'Yes')]");
    By btnNo=By.xpath("//button[contains(.,'No')]");
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
	public WorkMobility(WebDriver _driver) {
		super(_driver);
	
	}
	
	public boolean isbtnAddImmigrationDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(10, btnAddImmigration);
			if (driver.findElement(btnAddImmigration).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnAddRightToWorkDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAddRightToWork).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnDeleteImmigrationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDelete_Immigration).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnDeleteRightToWorkDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDelete_RightToWork).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isLinkOfImmigrationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkOfImmigration).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isLinkOfRightToWorkDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkOfRightToWork).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void clickBtnAddImmigration() {
		waitForElementClickable(10, btnAddImmigration);
		clickByJavaScript(btnAddImmigration);
	}
	public void clickbtnAddRightToWork() {
		waitForElementClickable(10, btnAddRightToWork);
		clickByJavaScript(btnAddRightToWork);
	}
	public void clickLinkOfImmigration() {
		waitForElementClickable(10, linkOfImmigration);
		clickByJavaScript(linkOfImmigration);
	}
	public void clickLinkOfRightToWork() {
		waitForElementClickable(10, linkOfRightToWork);
		clickByJavaScript(linkOfRightToWork);
	}
	public void clickChkImmigration()
	{
		clickByJavaScript(chkImmigration);
	}
	public void clickBtnDelete_Immigration()
	{
		//waitForElementClickable(10, btnDelete_Immigration);
		clickByJavaScript(btnDelete_Immigration);
	}
	public void clickChkRightToWork()
	{
		waitForElementClickable(10, chkRightToWork);
		clickByJavaScript(chkRightToWork);
		clickByJavaScript(chkRightToWork_all);
	}
	public void clickBtnDelete_RightToWork()
	{
		waitForElementClickable(10, btnDelete_RightToWork);
		clickByJavaScript(btnDelete_RightToWork);
	}
	
	public void clickBtnYes()
	{
		waitForElementClickable(10, btnYes);
		clickByJavaScript(btnYes);
	}
	public void deleteImmigration()
	{
		clickChkImmigration();
		clickBtnDelete_Immigration();
		clickBtnYes();
	}
	public void deleteRightToWork()
	{
		clickChkRightToWork();
		clickBtnDelete_RightToWork();
		clickBtnYes();
	}
}
