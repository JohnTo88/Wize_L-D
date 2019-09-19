package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class LeaveCalendar extends WebActions {
    By titleLeaveCalendar = By.xpath("//h1[contains(.,'Leave Calendar')]");
    By linkOfRequestLeave = By.xpath("(//span[@class='fc-title'])");
    By fistLinkOfRequestLeave = By.xpath("(//span[@class='fc-title'])[1]");
    By directReport = By.xpath("//span[contains(.,'Direct Report')]");
    By clearSelectedItem = By.xpath("//a[contains(.,'Clear selected item')]");
    
	public LeaveCalendar(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isTitleLeaveCalendarDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(titleLeaveCalendar).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isLinkOfRequestLeaveClickable()
	{
		boolean flag= false;
		try {
			if (isClickable(driver.findElement(linkOfRequestLeave))== true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickOnFistLinkOfRequestLeave()
	{
	  	clickByJavaScript(fistLinkOfRequestLeave);
	}
	
	public void chooseReportToAll()
	{
		clickByJavaScript(directReport);
		waitForElementClickable(10, clearSelectedItem);
		clickByJavaScript(clearSelectedItem);
		sleep(4);
	}
	
	
}
