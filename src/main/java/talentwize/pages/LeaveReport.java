package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class LeaveReport extends WebActions
{
	public LeaveReport(WebDriver _driver) {
		super(_driver);
	}
	
	By btnView = By.xpath("//button[contains(.,'View')]");
	
	public void clickBtnView()
	{
		waitForElementClickable(5, btnView);
		clickByJavaScript(btnView);
	}
	
	public boolean isBtnViewDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnView);
			if (driver.findElement(btnView).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
}
