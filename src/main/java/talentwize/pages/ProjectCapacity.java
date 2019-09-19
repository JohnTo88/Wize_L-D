package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ProjectCapacity extends WebActions {

	By btnAdd = By.xpath("//button[contains(@ng-click,'addPositionCapacityModal()')]");
	By lblProjectRole=By.xpath("//th[contains(.,'Project Role')]");
	By btnEdit=By.xpath("(//button[@type='button'][contains(.,'Edit')])[1]");
	By btnBin=By.xpath("//i[@class='icon icon-bin']");
	By btnDelete=By.xpath("//button[@class='btn btn-default btn-sm dropdown-toggle']");
	By chkProject=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Project Info'])[1]/following::span[1]");
	By chkProjectRole=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cases volume'])[1]/following::input[1]");
	By chkfirstProjectRole=By.xpath("(//input[@ng-model='selectedPositionConfigs[$index]'])[1]");
	By txtSearch=By.xpath("//input[contains(@placeholder,'Search project...')]");
	By chkAM=By.xpath("//label[contains(.,'AM')]");
	By msgAddProjectCapacitySuccessfully=By.xpath("//span[contains(.,'Create new item successfully')]");
	By msgUpdateProjectCapacitySuccessfully=By.xpath("//span[contains(.,'Update item successfully')]");
	By btnYes=By.xpath("//button[contains(.,'Yes')]");
	By msgDeleteProjectCapacitySuccessfully=By.xpath("//span[contains(.,'Delete position capacity successfull!')]");
	
	public ProjectCapacity(WebDriver _driver) {
		super(_driver);
		
	}
	public boolean ismsgAddProjectCapacitySuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(msgAddProjectCapacitySuccessfully).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean ismsgUpdateProjectCapacitySuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(msgUpdateProjectCapacitySuccessfully).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean ismsgDeleteProjectCapacitySuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(msgDeleteProjectCapacitySuccessfully).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void clickchkProjectRole()
	{
		clickByJavaScript(chkProjectRole);
	}
	public void clickchkfirstProjectRole()
	{
		sleep(5);
		clickByJavaScript(chkfirstProjectRole);
	}
	public void clickButtonAdd()
	{
		sleep(5);
		clickByJavaScript(btnAdd);
	}
	public void clickButtonEdit()
	{
		clickByJavaScript(btnEdit);
	}
	public void clickButtonYes()
	{
		clickByJavaScript(btnYes);
	}
	public void clickButtonDelete()
	{
		waitForElementClickable(5, btnBin);
		clickByJavaScript(btnBin);
	}
	public void clickChkProject()
	{
		sleep(5);
		clickByJavaScript(chkProject);
	}
	public void clickChkAM()
	{
		waitForElementClickable(5, chkAM);
		clickByJavaScript(chkAM);
	}
	public boolean isBtnAddDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(5, btnAdd);
			if (driver.findElements(btnAdd).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isButtonAddDisplayed()
	{
		boolean flag= false;
		if(driver.findElement(btnAdd).isEnabled())
		{
			flag=false;
		}
		else
		{
			flag=true;
		}
		return flag;
	}
	public boolean isBtnEditDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(btnEdit).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isBtnDeleteDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(10, btnDelete);
			if (driver.findElements(btnDelete).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isLblProjectRoleDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(lblProjectRole).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void fillSearchProject(String _project) {
		waitForElementClickable(10, txtSearch);
		clickByJavaScript(txtSearch);
		goTextOn(txtSearch, _project);
	}

	public void deleteProjectCapacity()
	{
		clickchkProjectRole();
		clickButtonDelete();
		clickButtonYes();
	}
	


}
