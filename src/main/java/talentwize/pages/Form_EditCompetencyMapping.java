package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditCompetencyMapping extends WebActions {

	public Form_EditCompetencyMapping(WebDriver _driver) {
		super(_driver);

	}
	By chkCompetencyName=By.xpath("(//label[@class='i-checkbox'])[1]");
	By btnNext=By.xpath("//i[@class='icon icon-arrow-right']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
    By btnClose = By.xpath("//button[contains(.,'Close')]");
	public void clickChkCompetencyName() {
		waitForElementClickable(5, chkCompetencyName);
		clickByJavaScript(chkCompetencyName);
	}
	public void clickButtonNext() {
		clickByJavaScript(btnNext);
	}
	public boolean isButtonSaveDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnCancel);
			if (driver.findElement(btnSave).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	public boolean isButtonCancelDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnCancel).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	public void clickButtonCancel() {
		clickByJavaScript(btnCancel);
	}
	
	public void clickButtonClose() {
		clickByJavaScript(btnClose);
	}

	public void clickButtonSave() {
		clickByJavaScript(btnSave);
	}
	public void editCompetencyMapping()
	{
		clickChkCompetencyName();
		clickButtonNext();
		clickButtonSave();
	}
}
