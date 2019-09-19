package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditProjectCapacity extends WebActions {

	By btnUpdateConfig = By.xpath("//button[contains(.,'Update config')]");
	
	public Form_EditProjectCapacity(WebDriver _driver) {
		super(_driver);
		
	}
	public void clickButtonUpdateConfig() {
		waitForElementClickable(10, btnUpdateConfig);
		clickByJavaScript(btnUpdateConfig);
	}
}
