package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Ulties.TestLogger;
import controller.WebActions;

public class ActualVolumeBoard extends WebActions {

	By btnImport = By.xpath("//button[@type='button'][contains(.,'Import')]");
	By coloumn_editVolume = By.xpath("(//td[contains(@ng-repeat,'index')])[1]");
	By listOfProjectNameLink = By.xpath("(//a[contains(@ng-click,'event,project.id)')])");
	By messageEditSuccess = By.xpath("//span[contains(.,'Update actual volume successfully')]");
	By lblNameOfProject = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project'])[1]/following::a[1]");
	By msgErrorNoPermission = By.xpath("//span[@class='message-content']");
	
	public ActualVolumeBoard(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isLblNameOfProjectDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblNameOfProject).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnImportDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnImport).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMessageEditSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(messageEditSuccess).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isListOfProjectNameLinDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(listOfProjectNameLink).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickOnColumnEditVolumn()
	{
		waitForElementClickable(10, coloumn_editVolume); 
		clickByJavaScript(coloumn_editVolume);
	}
	
	public void clickLblNameOfProject()
	{
		waitForElementClickable(10, lblNameOfProject);
		clickByJavaScript(lblNameOfProject);
	}
	
	public boolean isMsgErrorNoPermissionDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, msgErrorNoPermission);
			if (driver.findElement(msgErrorNoPermission).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
}
