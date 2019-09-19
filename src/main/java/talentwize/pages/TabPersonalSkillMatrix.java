package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabPersonalSkillMatrix extends WebActions {

	By btnEvulate = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pending'])/following::button[contains(.,'Evaluate')]"); 
	
	
	public TabPersonalSkillMatrix(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isBtnEvulateDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(btnEvulate).size() > 0 ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickButtonEvulate()
	{
		waitForElementClickable(10, btnEvulate);
		clickByJavaScript(btnEvulate);
	}
	
	
}
