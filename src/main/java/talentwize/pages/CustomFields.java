package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CustomFields extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
    By btnDelete = By.xpath("//i[@class='icon icon-bin']");
    By linkOfNameModule = By.xpath("//span[contains(@ng-click,'index, item)')]");
    By fistLinkOfNameModule = By.xpath("//span[contains(@ng-click,'index, item)')][1]");
    By messageUpdateSuccess = By.xpath("//span[contains(.,'Update custom field successfully')]");
    By buttonYes = By.xpath("//button[contains(.,'Yes')]");
    By messageDeleteSuccess = By.xpath("//span[contains(.,'Delete custom field successfully')]");
    
	public CustomFields(WebDriver _driver) {
		super(_driver);

	}

	public boolean isButtonAddDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	
	public boolean isMessageDeleteSuccessDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(messageDeleteSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public boolean isMessageUpdateSuccessDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public void clickDeleteCustomField() throws InterruptedException
	{
		waitForElementPresent(10, By.xpath("//input[@type='checkbox']"));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		clickByJavaScript(btnDelete);
	}
	
	
	
	public boolean isLinkOfNameModuleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkOfNameModule).size() >0) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickFistnameOfLinkNameModule()
	{
		waitForElementClickable(10, fistLinkOfNameModule);
		clickByJavaScript(fistLinkOfNameModule);
	}
	
	public void clickButtonYes()
	{
		waitForElementClickable(10, buttonYes);
		clickByJavaScript(buttonYes);
	}
	
	public boolean isButtonDeleteDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(btnDelete).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public void clicButtonAdd()
	{
		waitForElementClickable(10, btnAdd);
		clickByJavaScript(btnAdd);
	}
}
