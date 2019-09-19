package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TimesheetReport extends WebActions {

	By btnView = By.xpath("//button[contains(.,'View')]");
	
	public TimesheetReport(WebDriver _driver) 
	{
		super(_driver);	
	}

	public boolean isBtnViewDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnView).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	
	public void clickBtnView()
	{
		waitForElementClickable(5, btnView);
		clickByJavaScript(btnView);
	}
	
}
