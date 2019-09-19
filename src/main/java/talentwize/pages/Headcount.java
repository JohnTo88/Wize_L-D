package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Headcount extends WebActions {

	By btnExport = By.xpath("//button[contains(.,'Export')]");
	By iconQuotaValue = By.id("projectValueQ1");//Q
	By iconMemberProject = By.id("projectValueH1");//Hdc
	By msgErrorNoPermission = By.xpath("//span[@class='message-content']");
	By lblNameOfProject = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project'])[1]/following::a[1]");
	By btnGotoProjectMemberList = By.xpath("//button[contains(.,'Go To Project Member List')]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	
	public Headcount(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isBtnExportDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnExport);
			if (driver.findElement(btnExport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickIconQuotaValue()
	{
		waitForElementClickable(10, iconQuotaValue);
		clickByJavaScript(iconQuotaValue);
	}
	
	public void clickIconMemberProject() throws InterruptedException
	{
		waitForElementPresent(20, iconMemberProject);
		clickByJavaScript(iconMemberProject);
	}
	
	public void clickLblNameOfProject()
	{
		waitForElementClickable(5, lblNameOfProject);
		clickByJavaScript(lblNameOfProject);
	}
	
	public boolean isBtnGotoProjectMemberListDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnGotoProjectMemberList);
			if (driver.findElement(btnGotoProjectMemberList).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnGotoProjectMemberList()
	{
		waitForElementClickable(5, btnGotoProjectMemberList);
		clickByJavaScript(btnGotoProjectMemberList);
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
	
	public void clickBtnClose()
	{
		waitForElementClickable(5, btnClose);
		clickByJavaScript(btnClose);
	}
}
