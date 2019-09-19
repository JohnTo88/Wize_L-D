package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_QuotaValues extends WebActions {

	By btnGoToQuotaManagement = By.xpath("//button[contains(.,'Go To Quota Management')]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	
	public Form_QuotaValues(WebDriver _driver) {
		super(_driver);
		
	}

	public boolean isBtnGoToQuotaManagementDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnGoToQuotaManagement);
			if (driver.findElement(btnGoToQuotaManagement).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickOnButtonClose()
    {
    	clickByJavaScript(btnClose);
    }
	
}
