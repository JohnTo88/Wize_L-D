package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabWorkingDays extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");

	By iconDelete = By.xpath("//i[@class='icon icon-bin']");

	By IsLinksOfNamePolicyListClickable = By.xpath("(//span[contains(@ng-click,'index, item)')])");
	
	public TabWorkingDays(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isBtnAddIsNotDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).getAttribute("style").contains("display: none"))
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnAddDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isIconDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(iconDelete).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean IsLinksOfNamePolicyListClickable()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(IsLinksOfNamePolicyListClickable).size()>0)
				flag= true;
		} catch (Exception e) {
			flag = false;
			
		}
		return flag;
		
	}


}
