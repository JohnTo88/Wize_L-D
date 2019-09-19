package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddAsset extends WebActions {
 
	By txtSerialNumber = By.xpath("//input[@name='serialNumber']");
	By assignedDate = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Assigned Date*'])[1]/following::i[1]");
	By btnToday = By.xpath("//span[contains(.,'Today')]");
	By drplistAssetStatus = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Asset Status*'])[1]/following::b[1]");
	By optionFist = By.xpath("(//div[@ng-bind-html='status.value'])[1]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public Form_AddAsset(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void chooseAssignedDate_Today()
	{
		clickByJavaScript(assignedDate);
		waitForElementClickable(10, btnToday);
		clickByJavaScript(btnToday);
		
	}
	
	public void fillSerialNumber(String serialNumber)
	{
		waitForElementClickable(10, btnSave);
		typeText(txtSerialNumber, serialNumber);
	}
	
	public void chooseAssetStatus_Fist()
	{
		clickByJavaScript(drplistAssetStatus);
		waitForElementClickable(10, optionFist);
		clickByJavaScript(optionFist);
	}
	
	public void addAsset(String serialNumberRandom) {
		fillSerialNumber(serialNumberRandom);
		chooseAssignedDate_Today();
		chooseAssetStatus_Fist();
		clickByJavaScript(btnSave);
	}
	
	
	
	

}
