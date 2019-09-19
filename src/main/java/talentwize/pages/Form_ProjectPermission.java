package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_ProjectPermission extends WebActions {
  
	By drplistSelectEmployee = By.xpath("//span[contains(.,'Select Employee...')]");
	By txtSearch = By.xpath("(//input[@placeholder='Search...'])[6]");
	By drplistSelectPermision = By.xpath("//span[contains(.,'Select Permission...')]");
	By btnAddPermission = By.xpath("//button[contains(.,'Add Permission')]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	By txtEmployee = By.xpath("//input[@ng-model='condition.keyword']");
	By cboxEmployee = By.xpath("//input[@type='checkbox']");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By roleInProject = By.xpath("//div[@ng-bind-html='role.name']");
	By messsageAddSuccess = By.xpath("//span[contains(.,'Add delegation successfully!')]");
	By optEmployee = By.xpath("(//div[@ng-bind-html='obj.nameCombobox'])[1]");
	
	public static String nameEmployee = ""; 
	
	
	public Form_ProjectPermission(WebDriver _driver) {
		super(_driver);
	}
	
	public boolean isMesssageAddSuccessDisplayed() {

		boolean flag = false;

		try {

			if (driver.findElement(messsageAddSuccess).isDisplayed() == true) {
				flag = true;

			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}
	
	// choose or Edit Project Delegate , Local Delegate , Local Leader 
    
	public void searchEmployee(String nameOfEmployee)
	{
		waitForElementClickable(drplistSelectEmployee);
		clickByJavaScript(drplistSelectEmployee);
		waitForElementClickable(txtSearch);
		goTextOnNoEnter(txtSearch, nameOfEmployee);
		sleep(5);
		clickByJavaScript(optEmployee);
	}
	
	public void chooseRoleInProject()
	{
		clickByJavaScript(drplistSelectPermision);
		waitForElementClickable(txtSearch);
		clickByJavaScript(roleInProject);
		
	}
	
	public void clickBtnAddPermission() {
		clickByJavaScript(btnAddPermission);
	}
	
	public void clickBtnClose()
	{
		clickByJavaScript(btnClose);
	}
	
	public void removeEmployeeFromPermission(String nameOfEmployee)
	{
		goTextOn(txtEmployee, nameOfEmployee);
		clickByJavaScript(cboxEmployee);
		clickByJavaScript(iconDelete);
		waitForElementClickable(btnYes);
		clickByJavaScript(btnYes);
		clickBtnClose();
	}
	

}
