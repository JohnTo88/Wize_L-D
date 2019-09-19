package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ListRequest extends WebActions {
  
	By linkOfListRequest = By.xpath("//span[contains(@class,'link-redirect ng-binding')]");
	By btnAssignLeave = By.xpath("//button[contains(.,'Assign Leave')]");
	By btnReview = By.xpath("//button[contains(.,'Review')]");
	By menuDirectReport = By.xpath("//span[contains(.,'Direct Report')]");
	By clearSelectedItem = By.xpath("//a[contains(.,'Clear selected item')]");
	
	public ListRequest(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void changeReportToAll()
	{
		waitForElementClickable(10, menuDirectReport);
		clickByJavaScript(menuDirectReport);
		waitForElementClickable(10, clearSelectedItem);
		clickByJavaScript(clearSelectedItem);
		
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
	
	
	public boolean isButtonAssignLeaveDisplayed()
	{
		boolean flag = false;
		
		try {
			if (driver.findElement(btnAssignLeave).isDisplayed()==true)
				flag =true;
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	


	public boolean isButtonReviewDisplayed()
	{
		boolean flag = false;
		
		try {
			waitForElementClickable(10, btnReview);
			if (driver.findElement(btnReview).isDisplayed()==true)
				flag =true;
		} catch (Exception e) {
			flag = false;
		}
		
		return flag;
	}
	
}
