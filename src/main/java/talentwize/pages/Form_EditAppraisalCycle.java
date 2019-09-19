package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditAppraisalCycle extends WebActions
{

	public Form_EditAppraisalCycle(WebDriver _driver) {
		super(_driver);
	}

	By btnEdit = By.xpath("//button[@ng-click='showEdit()']");
	By btnNextStep1 = By.xpath("//button[@ng-click='nextToSecondStep()']");
	By btnNextStep2 = By.xpath("//button[@ng-click='steps.step3=true;summary()']");
	By btnSave = By.xpath("//button[@ng-click='save()']");
	By btnClose = By.xpath("//button[@type='button'][contains(.,'Close')]");
	By lblCyleInfo = By.xpath("//h4[contains(.,'Appraisal Cycle Information')]");
	
	public void clickBtnEdit()
	{
		waitForElementClickable(5, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickBtnNext1()
	{
		waitForElementClickable(5, btnNextStep1);
		clickByJavaScript(btnNextStep1);
	}
	
	public void clickBtnNext2()
	{
		waitForElementClickable(5, btnNextStep2);
		clickByJavaScript(btnNextStep2);
	}
	
	public void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickBtnClose()
	{
		waitForElementClickable(5, btnClose);
		clickByJavaScript(btnClose);
	}
	
	public void updateCycle()
	{
		clickBtnEdit();
		clickBtnNext1();
		clickBtnNext2();
		clickBtnSave();
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnEdit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblCyleInfoDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblCyleInfo).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
