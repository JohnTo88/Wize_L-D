package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TrainingSettings extends WebActions {

	By btnTest = By.xpath("//button[contains(.,'Test')]"); 
	By btnEdit = By.xpath("//button[contains(.,'Edit')]"); 
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By checkboxONSetting = By.xpath("(//label[@class='i-checks'][contains(.,'ON')])[1]//i");
	By txtLMS = By.xpath("//input[@ng-model='training.lmsUrl']");
	By txtToken = By.xpath("//input[@ng-model='training.token']");
	By msgUpdateSuccess = By.xpath("//span[contains(.,'Update successfully')]"); 
	
	public TrainingSettings(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void clickButtonEdit()
	{
		waitForElementClickable(10, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public boolean isButtonTestDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnTest).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgUpdateSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgUpdateSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isButtonEditDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEdit).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void updateTrainingSettings(String _LMS, String _token)
	{
		clickButtonEdit();
		clickByJavaScript(checkboxONSetting);
		sleep(1);
		
		driver.findElement(txtLMS).clear();
		driver.findElement(txtLMS).sendKeys(_LMS);
		
		driver.findElement(txtToken).clear();
		driver.findElement(txtToken).sendKeys(_token);
		
		clickByJavaScript(btnSave);
		sleep(1);
	}

}
