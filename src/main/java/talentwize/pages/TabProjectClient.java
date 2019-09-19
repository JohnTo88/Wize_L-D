package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabProjectClient extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By txtSearchClient = By.xpath("//input[@placeholder='Clients Search...']");
	By isLinkOfCLientNameClickable = By.xpath("(//span[contains(@ng-click,'index, item)')])");
	By cboxDelete = By.xpath("//label[contains(@ng-click,'index)')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By lblTitleClient = By.xpath("//div[@class='caption font-bold'][contains(.,'Client')]");
	By msgAddClientSuccess = By.xpath("//span[@class='message-content'][contains(.,'Create new client successfully')]");
	By msgEditClientSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update client successfully')]");
	By msgDeletetClientSuccess = By.xpath("//span[@class='message-content'][contains(.,'Delete client successfully')]");
	
	public TabProjectClient(WebDriver _driver) 
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
	
	public boolean isLinkOfCLientNameClickable() 
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfCLientNameClickable).size()> 0)
				flag= true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLblTitleClientDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblTitleClient).isDisplayed() == true)
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
	
	public void clickBtnAdd()
	{
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public boolean isMsgAddClientSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddClientSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditClientSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditClientSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteClientSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetClientSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfClientName()
	{
		waitForElementClickable(5, isLinkOfCLientNameClickable);
		clickByJavaScript(isLinkOfCLientNameClickable);
	}
	
	public void fillTxtSearchClient(String NameOfClient)
	{
		waitForElementClickable(5, txtSearchClient);
		clickByJavaScript(txtSearchClient);
		goTextOn(txtSearchClient, NameOfClient);
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
