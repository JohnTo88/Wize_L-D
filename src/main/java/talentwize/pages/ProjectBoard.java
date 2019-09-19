package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ProjectBoard extends WebActions {
    By arrowProject = By.xpath("(//span[@class='select-arrow'])[4]");
    By txtSearchProject = By.xpath("//input[@placeholder='Search project...']");
	By btnAction = By.xpath("(//button[contains(.,'Action')])[1]");
	By btnProjectInformation = By.xpath("(//a[contains(.,'Project Information')])");
	By btnProjectDetail = By.xpath("(//a[contains(.,'Project Detail')])[2]");
	By cboxChooseProject = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Clear all matched'])[1]/following::label[1]");
	By btnManagePermission = By.xpath("//button[contains(.,'Manage Permissions')]");
	By btnExport = By.xpath("//button[@type='button'][contains(.,'Export')]"); 
	By cboxDelete = By.xpath("(//input[@ng-model='project.isChecked'])[3]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By messageAddSuccess = By.xpath("//span[@class='message-content'][contains(.,'Create new project successfully')]"); 
	By messageUpdateSuccess = By.xpath("//span[contains(.,'Update project successfully')]"); 
	By messageDeleteSuccess = By.xpath("//span[@class='message-content'][contains(.,'Project deleted successfully!')]");
	
	By btnYesConfirm = By.xpath("//button[contains(.,'Yes')]"); 
	
	By filterProject = By.xpath("(//div[@class='selected ellipsis-text ng-binding'])[4]");
	
	public static String nameOfProject_CW ="Auto-Project CW";
	public static String nameOfProject_TW="Auto-TalentWize";
	public static String leaderOfProject="Nguyen Hoang Nam";
	public static String leaderOfProject_Default ="Nguyen Viet Ha";
	By btnCreate=By.xpath("//button[@type='button'][contains(.,'Create')]");
	
	public ProjectBoard(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void filterProject(String nameOfProject)
	{
		clickByJavaScript(filterProject);
		waitForElementClickable(5,txtSearchProject);
		goTextOnNoEnter(txtSearchProject, nameOfProject);
		sleep(4);
		clickByJavaScript(cboxChooseProject);
	}
	
	
	public void searchProject(String nameOfProject)
	{
		clickByJavaScript(arrowProject);
		waitForElementClickable(5,txtSearchProject);
		goTextOnNoEnter(txtSearchProject, nameOfProject);
		// click checkbox 
		sleep(4);
		clickByJavaScript(cboxChooseProject);
		sleep(5);
	}
	
	public void deleteProjectName()
	{
		clickByJavaScript(cboxDelete);
		clickByJavaScript(icoDelete);
		clickByJavaScript(btnYesConfirm);
		
	}
	
	public boolean isBtnActionDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(btnAction).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
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
	
	public boolean isMessageAddSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(messageAddSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

	public boolean isMessageDeleteSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(messageDeleteSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isMessageUpdateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed()==true)
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
	
	public boolean isCheckboxDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(cboxDelete).isDisplayed()==true)
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
	
	public void clickButtonAction()
	{
		sleep(3);
		waitForElementClickable(10, btnAction);
		clickByJavaScript(btnAction);
	}
	
	
	public void clickOnProjectInformation()
	{
		waitForElementClickable(10, btnProjectInformation);
		clickByJavaScript(btnProjectInformation);
		sleep(2);
		
	}
	
	
	public void clickOnProjectDetail()
	{
		clickByJavaScript(btnProjectDetail);
		sleep(3);
	}
	

	public boolean isBtnManagePermissionDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(btnManagePermission).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

	public void clickButtonCreate()
	{
		waitForElementClickable(10, btnCreate);
		clickByJavaScript(btnCreate);
		waitForPageLoaded();
	}

	public boolean isBtnProjectDetailDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnProjectDetail).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnProjectInformationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnProjectInformation).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

}
