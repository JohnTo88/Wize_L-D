package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabProjectStatus extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By isLinkOfProjectStatusClickable = By.xpath("(//span[contains(@class,'link-redirect ng-binding')])");
	By txtLinkEdit = By.xpath("//span[@ng-click='fn_on_name($index, item)'][contains(.,'Test Automation')]");
	By cboxDelete = By.xpath("//label[@class='i-checkbox m-b-0 ng-scope']");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By lblTitleProjectStatus = By.xpath("//div[@class='caption font-bold'][contains(.,'Project Status')]");
	By msgAddProjectStatus = By.xpath("//span[@class='message-content'][contains(.,'Create new project status successfully')]");
	By msgEditProjectStatus = By.xpath("//span[@class='message-content'][contains(.,'Update project status successfully')]");
	By msgDeletetProjectStatus = By.xpath("//span[@class='message-content'][contains(.,'Project Status deleted successfully!')]");
	
	public TabProjectStatus(WebDriver _driver) 
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
	
	public boolean isLinkOfProjectStatusClickable()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfProjectStatusClickable).size()> 0)
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
	
	public boolean isLblTitleProjectStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblTitleProjectStatus).isDisplayed() == true)
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
	
	public boolean isMsgAddProjectStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddProjectStatus).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isMsgEditProjectStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditProjectStatus).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteProjectStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetProjectStatus).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkEdit()
	{
		waitForElementClickable(5, txtLinkEdit);
		clickByJavaScript(txtLinkEdit);
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
