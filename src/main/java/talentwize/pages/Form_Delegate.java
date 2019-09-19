package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Delegate extends WebActions {

	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	By btnClose = By.xpath("//button[contains(.,'Close')]");

	public Form_Delegate(WebDriver driver) {
		super(driver);

	}

	public boolean isBtnSaveDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnSave).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnCloseDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnClose).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void cliclBtnClose()
	{
			clickByJavaScript(btnClose);
	}
}
