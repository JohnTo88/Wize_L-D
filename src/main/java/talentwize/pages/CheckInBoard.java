package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CheckInBoard extends WebActions {

	By btnSeriesSettings = By.xpath("//span[@class='icon-text'][contains(.,'Series Settings')]"); 
	By btnExport = By.xpath("//button[contains(.,'Export')]");
	By reportTo = By.xpath("//span[contains(.,'Direct Report')]");
	By clearSelectedItem = By.xpath("(//a[contains(.,'Clear selected item')])[1]");
	By linkOfCheckInDetails = By.xpath("(//i[contains(@class,'icon icon-history checkins-board-pending display-block m-t-2 fs-16 w-20')])[1]");
	By titleEmployeeOnTable = By.xpath("//th[contains(.,'Employee')]");
	
	public CheckInBoard(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void clickLinkOfCheckInDetails()
	{
		waitForElementClickable(5, linkOfCheckInDetails);
		clickByJavaScript(linkOfCheckInDetails);
	}
	
	public void reportToAll()
	{
		waitForElementClickable(10, reportTo);
		clickByJavaScript(reportTo);
		waitForElementClickable(10,clearSelectedItem);
		clickByJavaScript(clearSelectedItem);
		sleep(5);
	}
	
	public boolean isLinkOfCheckInDetailsDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(linkOfCheckInDetails).size()>0)
				flag = true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag; 
	}
	
	public boolean isCheckinTableDisplayed()
	{
		boolean flag = false; 
		try {
			waitForElementClickable(5, titleEmployeeOnTable);
			if (driver.findElement(titleEmployeeOnTable).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag; 
	}
	
	public boolean isButtonExportDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(btnExport).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag; 
	}
	
	
	
	
	

}
