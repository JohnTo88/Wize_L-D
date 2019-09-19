package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_SkillEvaluation extends WebActions {

	By btnOK = By.xpath("//button[contains(.,'Ok')]");
	By messageSuccess = By.xpath("//span[contains(.,'Evaluate skill successfully!')]");
	
	
	public Form_SkillEvaluation(WebDriver _driver) {
		super(_driver);
		
	}
	
	
	public void clickButtonOK()
	{
		waitForElementClickable(10,btnOK);
		clickByJavaScript(btnOK);
	}
	
	public boolean isMessageSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(messageSuccess).isDisplayed() ==true ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

}
