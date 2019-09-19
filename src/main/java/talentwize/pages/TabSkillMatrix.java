package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabSkillMatrix extends WebActions {

	By btnEvulate = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pending'])/following::button[contains(.,'Evaluate')]"); 
	
	By btnBack = By.xpath("(//button[contains(.,'Back')])[1]");
	By tabPersonalSkillMatrix = By.xpath("//tab-heading[contains(.,'Personal Skill Matrix')]");
	
	public TabSkillMatrix(WebDriver _driver) {
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
	
	public void clickButtonBack()
	{
		clickByJavaScript(btnBack);
	}
	
	public void clickTabPersonalSkillMatrix()
	{
		clickByJavaScript(tabPersonalSkillMatrix);
	}
	
	public void clickButtonEvulate()
	{
		waitForElementClickable(10, btnEvulate);
		clickByJavaScript(btnEvulate);
	}
	

}
