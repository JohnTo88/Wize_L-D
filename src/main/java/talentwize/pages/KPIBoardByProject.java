package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class KPIBoardByProject extends WebActions 
{
    
	By fistLinkOfKPIDetails = By.xpath("//span[contains(.,'—')]");
	By itemCuongAuto2 = By.xpath("//label[contains(.,'TV12324 - Cuong Automation 2 - cuong.automation2@tek-experts.com')]");
	By filterEmployee = By.xpath("(//div[@class='selected ellipsis-text ng-binding'])[14]");
	
	public KPIBoardByProject(WebDriver _driver) {
		super(_driver);	
	}
	
	public void filterEmployee()
	{
		waitForElementClickable(5, filterEmployee);
		clickByJavaScript(filterEmployee);
		waitForElementClickable(5, itemCuongAuto2);
		clickByJavaScript(itemCuongAuto2);
		sleep(2);
	}
	
	public void clickKPIDetails()
	{
		filterEmployee();
		waitForElementClickable(5, fistLinkOfKPIDetails);
		clickByJavaScript(fistLinkOfKPIDetails);
	}
}