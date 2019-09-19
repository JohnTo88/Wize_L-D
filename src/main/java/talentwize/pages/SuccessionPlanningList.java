package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class SuccessionPlanningList extends WebActions 
{

	public SuccessionPlanningList(WebDriver _driver) {
		super(_driver);
	}

	By lblSuccessionPlanning = By.xpath("//h1[contains(.,'Succession Planning List')]");
	By btnExport = By.xpath("//button[contains(.,'Export')]");
	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By btnAddSuccessor = By.xpath("(//button[contains(.,'Add Successor')])[1]");
	By btnEditSuccessor = By.xpath("//button[contains(.,'Edit')]");
	By linkSuccessor = By.xpath("(//span[@class='link-redirect ng-binding'])[1]");
	By icoExpandKeymemeber = By.xpath("(//i[@class='fa fa-chevron-right'])[1]");
	
	//Update Succession Status
	By icoEditSuccessionStatus = By.xpath("(//i[contains(@class,'glyphicon glyphicon-pencil')])[1]");
	By icoSummitSuccessionStatus = By.xpath("(//button[contains(@ng-click,'event, succession)')])[1]");
	
	//Update Successor Status
	By icoEditSuccessorStatus = By.xpath("(//i[contains(@class,'glyphicon glyphicon-pencil')])[2]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	//Delete
	By cboxDelete = By.xpath("(//label[@class='i-checkbox'])[1]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	
	By msgCreateSuccess = By.xpath("//span[@class='message-content'][contains(.,'Add succession successfully')]");
	By msgUpdateSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update successor successfully!')]");
	By msgDeleteSuccess = By.xpath("//span[@class='message-content'][contains(.,'Delete Successful')]");
	By msgUpdateSuccessorStatus = By.xpath("//span[@class='message-content'][contains(.,'Submit successfully!')]");
	
	public boolean isLblSuccessionPlanningDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblSuccessionPlanning).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnExportDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnExport).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnAddSuccessor()
	{
		clickByJavaScript(btnAddSuccessor);
	}
	
	public void clickIcoExpandKeymemeber()
	{
		sleep(2);
		clickByJavaScript(icoExpandKeymemeber);
	}
	
	public boolean isBtnAddSuccessorDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAddSuccessor).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnCreate()
	{
		waitForElementClickable(5, btnCreate);
		clickByJavaScript(btnCreate);
		sleep(5);
	}
	
	public boolean isBtnCreateDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnCreate).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void editSuccessionStatus()
	{
		clickByJavaScript(icoEditSuccessionStatus);
		clickByJavaScript(icoSummitSuccessionStatus);
	}
	
	public boolean isIcoEditSuccessionStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(icoEditSuccessionStatus).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnSummitSuccessionStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(icoSummitSuccessionStatus).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void editSuccessorStatus()
	{
		clickIcoExpandKeymemeber();
		clickByJavaScript(icoEditSuccessorStatus);
		clickByJavaScript(btnSave);
	}
	
	public boolean isIcoEditSuccessorStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(icoEditSuccessorStatus).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void deleteSuccession()
	{
		clickByJavaScript(cboxDelete);
		clickByJavaScript(icoDelete);
		sleep(1);
		clickByJavaScript(btnYes);
	}
	
	public boolean isMsgCreateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgCreateSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgUpdateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgUpdateSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgUpdateSuccessorStatusDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgUpdateSuccessorStatus).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeleteSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLinkSuccessorDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkSuccessor).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isIcoDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(icoDelete).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnEditSuccessor(){
		waitForElementClickable(btnEditSuccessor);
		clickByJavaScript(btnEditSuccessor);
	}
	
	public boolean isBtnEditSuccessorDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnEditSuccessor).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
}
