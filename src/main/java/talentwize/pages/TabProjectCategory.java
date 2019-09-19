package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabProjectCategory extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By txtSearchCategory = By.xpath("//input[@placeholder='Project Categories Search...']");
	By isLinkOfProjectCategoryClickable = By.xpath("(//span[contains(@ng-click,'index, item)')])");
	By cboxDelete = By.xpath("//label[contains(@ng-click,'index)')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By lblTitleProjectCategory = By.xpath("//div[@class='caption font-bold'][contains(.,'Project Category')]");
	By msgAddCategorySuccess = By.xpath("//span[@class='message-content'][contains(.,'Create new project category successfully')]");
	By msgEditCategorySuccess = By.xpath("//span[@class='message-content'][contains(.,'Update project category successfully')]");
	By msgDeletetCategorySuccess = By.xpath("//span[@class='message-content'][contains(.,'Delete project category successfully')]");
	
	public TabProjectCategory(WebDriver _driver) 
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
	
	public boolean isLinkOfProjectCategoryClickable()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfProjectCategoryClickable).size()> 0)
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
	
	public boolean isLblTitleProjectCategoryDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblTitleProjectCategory).isDisplayed() == true)
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
	
	public boolean isMsgAddCategorySuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddCategorySuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditCategorySuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditCategorySuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteCategorySuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetCategorySuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfCategoryName()
	{
		waitForElementClickable(5, isLinkOfProjectCategoryClickable);
		clickByJavaScript(isLinkOfProjectCategoryClickable);
	}
	
	public void fillTxtSearchCategory(String NameOfCategory)
	{
		waitForElementClickable(5, txtSearchCategory);
		clickByJavaScript(txtSearchCategory);
		goTextOn(txtSearchCategory, NameOfCategory);
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
