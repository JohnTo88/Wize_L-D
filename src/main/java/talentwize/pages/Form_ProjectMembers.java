package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_ProjectMembers extends WebActions {

	By btnGoToProjectMemberList = By.xpath("//button[contains(.,'Go To Project Member List')]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	
	
	public Form_ProjectMembers(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isBtnGoToProjectMemberListDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnGoToProjectMemberList);
			if (driver.findElement(btnGoToProjectMemberList).isDisplayed() == true) {
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
