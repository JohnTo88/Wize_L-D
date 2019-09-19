package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class BroadcastMessage extends WebActions {

	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By linksOfNameBroadCast = By.xpath("(//span[contains(@ng-click,'index, item)')])");
	By fistNameOfNameBroadCast = By.xpath("(//span[contains(@ng-click,'index, item)')])[1]");
	
	By messageUpdateSusscess = By.xpath("//span[contains(.,'Update broadcast message successfully')]");
	
	public BroadcastMessage(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isButtonCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCreate).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public boolean isMessageUpdateSusscessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(messageUpdateSusscess).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public void clickFistNameOfNameBroadCast()
	{
		waitForElementClickable(10, fistNameOfNameBroadCast);
		clickByJavaScript(fistNameOfNameBroadCast);
	}
	
	public void clickLastNameOfNameBroadCast()
	{
		waitForElementClickable(10, fistNameOfNameBroadCast);
		int list = driver.findElements(By.xpath("(//span[contains(@ng-click,'index, item)')])")).size();
		clickByJavaScript(By.xpath("(//span[contains(@ng-click,'index, item)')])["+list+"]"));
	}
	
	public boolean isButtonDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(iconDelete).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
		
	}
	
	public boolean isLinkOfNameBroardcastDisplayed()
	{
		boolean flag= false;
		
		try {
			
			if ( driver.findElements(linksOfNameBroadCast).size()>0)
				flag=true;
			
		} catch (Exception e) {
			flag= false ;
		}
		
		return flag;
	}

}
