package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TargetVolume extends WebActions {

	By lblTotal = By.xpath("//th[@class='bg-white first-block'][contains(.,'Total')]");
	By projectNameLink=By.xpath("//a[@ng-click='goToProjectDetail($event, 1268)']");
	By btnAddTargetVolume=By.xpath("//button[@type='button'][contains(.,'Add Target Volume')]");
	By msgAddTargetVolume=By.xpath("//span[contains(.,'Add case volume successfully')]");
	By lblNameOfProject = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project'])[1]/following::a[1]");
	By msgErrorNoPermission = By.xpath("//span[@class='message-content']");
	
	public TargetVolume(WebDriver _driver) {
		super(_driver);
	}
	
	public boolean isProjectTableDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblTotal).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isProjectNameLinkDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(projectNameLink).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ismsgAddTargetVolumeDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgAddTargetVolume).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnAddTargetVolumeDisplayed() {
		boolean flag = false;
		try {
			waitForElementPresent(10, btnAddTargetVolume);
			if (driver.findElement(btnAddTargetVolume).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public void clickbtnAddTargetVolume()
	{
		waitForElementClickable(10, btnAddTargetVolume);
		clickByJavaScript(btnAddTargetVolume);
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
