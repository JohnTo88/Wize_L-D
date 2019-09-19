package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class Form_EditActualVolume extends WebActions {

	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By titleEditActualVolume = By.xpath("//h4[contains(.,'Edit Actual Volume')]"); 
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	By txtNumberClosedCases = By.xpath("//input[@name='numClosedCases']");
	
	public Form_EditActualVolume(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isBtnSaveDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnSave).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void fillIntoNumberClosedCases()
	{
		goTextOnNoEnter(txtNumberClosedCases, TienIch.taoRandomSo(1));
	}
	
	public boolean isTitleEditActualVolumeDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementClickable(10, titleEditActualVolume);
			if (driver.findElement(titleEditActualVolume).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickOnClose()
	{
		clickByJavaScript(btnClose);
		
	}

	public void clickOnSave()
	{
		clickByJavaScript(btnSave);
		
	}
	
}
