package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabMemberStatus extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By isLinkOfMemberStatusClickable = By.xpath("(//span[contains(@class,'link-redirect ng-binding')])");
	By txtSearchMemberStatus = By.xpath("//input[contains(@ng-model,'conditionUserProjectStatus.keyword')]");
	By cboxDelete = By.xpath("//label[@class='i-checkbox m-b-0 ng-scope']");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By btnOrder = By.xpath("//button[@ng-click='orderUserProjectStatus()']");
	By lblTitleMemberStatus = By.xpath("//div[@class='caption font-bold'][contains(.,'Member Status')]");
	By msgAddMemberStatuSuccess = By.xpath("//span[@class='message-content'][contains(.,'Create new member status successfully')]");
	By msgEditMemberStatuSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update member status successfully')]");
	By msgDeletetMemberStatuSuccess = By.xpath("//span[@class='message-content'][contains(.,'Member Status deleted successfully')]");
	
	public TabMemberStatus(WebDriver _driver) 
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
	
	public boolean isLinkOfMemberStatusClickable()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfMemberStatusClickable).size()> 0)
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
	
	public boolean isLblTitleMemberStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblTitleMemberStatus).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnOrderDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnOrder).isDisplayed() == true)
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
	
	public boolean isMsgAddMemberStatuSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddMemberStatuSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditMemberStatuSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditMemberStatuSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteMemberStatuSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetMemberStatuSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfMemberStatusName()
	{
		waitForElementClickable(5, isLinkOfMemberStatusClickable);
		clickByJavaScript(isLinkOfMemberStatusClickable);
	}
	
	public void fillTxtSearchMemberStatus(String NameOfMemberStatus)
	{
		waitForElementClickable(5, txtSearchMemberStatus);
		clickByJavaScript(txtSearchMemberStatus);
		goTextOn(txtSearchMemberStatus, NameOfMemberStatus);
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
