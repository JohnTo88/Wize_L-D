package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CourseInformation extends WebActions {

	public Form_CourseInformation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By lblCourseInformation = By.xpath("//h4[contains(.,'Course Information')]");
	By msgUpdateSuccessful = By.xpath("//span[contains(.,'Course updated successfully!')]");
	By drpVersion = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Version*'])[2]/following::b[1]"); 
	By numberVersion = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Edit'])[1]/following::div[9]"); //+[9]-> version 3
	
	public boolean isBtnEditDisplayed()
	{
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
	
	public boolean isMsgUpdateSuccessfulDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgUpdateSuccessful).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLabelCourseInformationDisplayed() throws InterruptedException
	{
		boolean flag = false;
		sleep(5);
		
		try {
			if (driver.findElement(lblCourseInformation).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public void clickButtonClose() throws InterruptedException
	{
		waitForElementVisible(10, btnClose);
		clickByJavaScript(btnClose);
	}
	
	public void clickButtonEdit() throws InterruptedException
	{
		waitForElementVisible(10, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickButtonSave() throws InterruptedException
	{
		waitForElementVisible(10, btnSave);
		clickByJavaScript(btnSave);
		sleep(2);
	}
	
	public void chooseVersion() throws InterruptedException
	{
		clickByJavaScript(drpVersion);
		sleep(1);
		clickByJavaScript(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Edit'])[1]/following::div[10]"));
			
	}
	
	
	
	
	
	

}
