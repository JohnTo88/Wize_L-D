package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class Form_AddKPI extends WebActions {

	public Form_AddKPI(WebDriver _driver) {
		super(_driver);
		
	}
	
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By txtKpiCode = By.xpath("//input[contains(@ng-model,'criteria.kpiCode')]");
	By txtKPIName = By.xpath("//input[contains(@ng-model,'criteria.name')]");
	By scoreMin = By.xpath("//input[@ng-change='minChange()']");
	By scoreMax = By.xpath("//input[@ng-model='criteria.rateMax']");
	
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
	
	public void fillKPICode()
	{
		goTextOn(txtKpiCode, TienIch.taoRandomChu(7));
	}
	public void fillKPIName()
	{
		goTextOn(txtKPIName, TienIch.taoRandomChu(7));
	}
	
	public void fillScoreMin()
	{
		goTextOn(scoreMin, "1");
	}
	
	public void fillScoreMax()
	{
		goTextOn(scoreMax, "80");
	}
	
	public void addKPI()
	{
		waitForElementClickable(10,btnCancel);
		fillKPICode();
		fillKPIName();
		fillScoreMin();
		fillScoreMax();
		clickButtonSave();
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
		waitForElementClickable(10, btnCancel);
		clickByJavaScript(btnCancel);
	}
	
	public void clickButtonSave() {
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
	

}
