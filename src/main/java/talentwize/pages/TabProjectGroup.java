package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabProjectGroup extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By txtSearchGroup = By.xpath("//input[contains(@placeholder,'Group name')]");
	By isLinkOfProjectGroupsClickable = By.xpath("(//span[contains(@class,'link-redirect ng-binding')])");
	By cboxDelete = By.xpath("//label[contains(@ng-click,'index)')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By lblTitleProjectGroups = By.xpath("//div[@class='caption'][contains(.,'Project Groups')]");
	By msgAddGroupSuccess = By.xpath("//span[@class='message-content'][contains(.,'Create new board successfully')]");
	By msgEditGroupSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update board successfully')]");
	By msgDeletetGroupSuccess = By.xpath("//span[@class='message-content'][contains(.,'Delete successfully')]");
	
	public TabProjectGroup(WebDriver _driver) 
	{
		super(_driver);	
	}

	public boolean isBtnAddDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLinkOfProjectGroupsClickable()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfProjectGroupsClickable).size()> 0)
				flag= true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isIcoDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(icoDelete).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isLblTitleProjectGroupsDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblTitleProjectGroups).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnAdd()
	{
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public boolean isMsgAddGroupSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddGroupSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditGroupSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditGroupSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteGroupSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetGroupSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfGroupName()
	{
		waitForElementClickable(5, isLinkOfProjectGroupsClickable);
		clickByJavaScript(isLinkOfProjectGroupsClickable);
	}
	
	public void fillTxtSearchGroup(String NameOfGroup)
	{
		waitForElementClickable(5, txtSearchGroup);
		clickByJavaScript(txtSearchGroup);
		goTextOn(txtSearchGroup, NameOfGroup);
		sleep(2);
	}
	
	public void clickCboxDelete()
	{
		waitForElementClickable(5, cboxDelete);
		clickByJavaScript(cboxDelete);
	}
	
	public void clickIcoDelete()
	{
		waitForElementClickable(5, icoDelete);
		clickByJavaScript(icoDelete);
	}
	
	public void clickbBtnYes()
	{
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
	
}
