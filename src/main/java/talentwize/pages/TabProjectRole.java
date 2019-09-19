package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabProjectRole extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By isLinkOfProjectRoleClickable = By.xpath("(//span[contains(@ng-click,'index, item)')])");
	By cboxDelete = By.xpath("//label[contains(@ng-click,'index)')]");
	By txtSearchProjectRole = By.xpath("//input[contains(@ng-model,'conditionProjectPosition.keyword')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By btnAssign = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Active'])[1]/following::button[1]");
	By lblTitleProjectRole = By.xpath("//div[@class='caption font-bold'][contains(.,'Project Role')]");
	By msgAddProjectRoleSuccess = By.xpath("//span[@class='message-content'][contains(.,'Create new project role successfully')]");
	By msgEditProjectRoleSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update project role successfully')]");
	By msgDeleteProjectRoleSuccess = By.xpath("//span[@class='message-content'][contains(.,'Project Role deleted successfully')]");
	
	public TabProjectRole(WebDriver _driver) 
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
	
	public boolean isLinkOfProjectRoleClickable()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfProjectRoleClickable).size()> 0)
				flag= true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnAssignDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAssign).isDisplayed() == true)
				flag = true;
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
	
	public boolean isLblTitleProjectRoleDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblTitleProjectRole).isDisplayed() == true)
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
	
	public boolean isMsgAddProjectRoleSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddProjectRoleSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditProjectRoleSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditProjectRoleSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteProjectRoleSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeleteProjectRoleSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfProjectRole()
	{
		waitForElementClickable(5, isLinkOfProjectRoleClickable);
		clickByJavaScript(isLinkOfProjectRoleClickable);
	}
	
	public void fillTxtSearchProjectRole(String NameOfProjectRole)
	{
		waitForElementClickable(5, txtSearchProjectRole);
		clickByJavaScript(txtSearchProjectRole);
		goTextOn(txtSearchProjectRole, NameOfProjectRole);
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
