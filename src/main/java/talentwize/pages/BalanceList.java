package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class BalanceList extends WebActions {
     
	By btnDropTools = By.xpath("//button[contains(.,'Tools')]");
	By optionImportBalance = By.xpath("//a[contains(.,'Import Balance')]");
	By optionExportBalance = By.xpath("//a[contains(.,'Export Balance')]");
	By optionUpdateBalance = By.xpath("//a[contains(.,'Update Balance')]");
	
	By linkOfListRequest = By.xpath("//span[contains(@class,'link-redirect ng-binding')]");
	
	
	public BalanceList(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isLinkOfListRequestDisplayed()
	{
		boolean flag = false;
		
		try {
			if (driver.findElements(linkOfListRequest).size()>=0)
				flag =true;
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
	public boolean isOptionExportBalanceDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(optionExportBalance).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public boolean isOptionUpdateBalanceDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(optionUpdateBalance).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public boolean isButtonDropToolsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnDropTools).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public boolean isOptionImportBalanceDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(optionImportBalance).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public void clickButtonDropTool()
	{
		waitForElementClickable(10,btnDropTools );
		clickByJavaScript(btnDropTools);
	}
	
	public void clickOptionImportBalance()
	{
		waitForElementClickable(10,optionImportBalance );
		clickByJavaScript(optionImportBalance);
	}
	
	

}
