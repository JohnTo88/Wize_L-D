package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddEmployeeToTheProject extends WebActions {

	By droplistProjectName = By.xpath("//span[contains(.,'Select Project...')]");
	By txtSearchProject = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Project...'])[1]/following::input[1]");
	By droplistStatus = By.xpath("//span[contains(.,'Select Status...')]");
	By option_Status_1 = By.xpath("(//div[@ng-bind-html='stt.status'])[1]");
	
	By droplistProjectRole = By.xpath("//span[contains(.,'Select Role...')]");
    By option_projectRole = By.xpath("//div[@ng-bind-html='position.name']");
	By assignmentStartDate = By.xpath("(//i[contains(@class,'icon icon-calendar2')])[1]");
	By btnToday = By.xpath("//button[contains(.,'Today')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By droplistPercentage = By.xpath("//a[contains(@placeholder,'Select Percentage...')]");
	By percentage_0 = By.xpath("(//div[@class='ng-binding ng-scope'])[1]");
	
	//Xpath in the Project Member List
	By btnAdd = By.xpath("(//button[contains(.,'Add')])[2]");
	By optActive = By.xpath("//div[@class='select2-result-label ui-select-choices-row-inner'][contains(.,'Active')]");
	By drplistEmployee = By.xpath("//span[contains(.,'Select Employee...')]");
	By txtSearchEmployee = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Employee...'])[1]/following::input[1]");
	By optProjectRole_AccountManager = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Role...'])[1]/following::div[5]");
	By txtEmployee = By.xpath("(//div[@ng-bind-html='obj.nameCombobox'])[1]");
	By txtSearchProjectRole = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Role...'])[1]/following::input[1]");
	By optProject = By.xpath("//div[contains(@ng-bind-html,'project.name')]");
	
	public Form_AddEmployeeToTheProject(WebDriver _driver)
	{
		super(_driver);
	}
	
	private void chooseNameOfProject(String nameOfProject)
	{
		waitForElementClickable(droplistProjectName);
		clickByJavaScript(droplistProjectName);
		goTextOnNoEnter(txtSearchProject, nameOfProject);
		clickByJavaScript(optProject);
	}
	
	private void chooseNameOfEmployee(String nameOfEmployee)
	{
		waitForElementClickable(5, drplistEmployee);
		clickByJavaScript(drplistEmployee);
		goTextOnNoEnter(txtSearchEmployee, nameOfEmployee);
		sleep(4);
		clickByJavaScript(txtEmployee);
	}
	
	private void chooseStatus_First()
	{
		clickByJavaScript(droplistStatus);
		waitForElementClickable(option_Status_1);
		clickByJavaScript(option_Status_1);
	}
	
	private void chooseStatus_Active()
	{
		clickByJavaScript(droplistStatus);
		waitForElementClickable(optActive);
		clickByJavaScript(optActive);
	}
	
	private void chooseProjectRole()
	{
		waitForElementClickable(droplistProjectRole);
		clickByJavaScript(droplistProjectRole);
		clickByJavaScript(option_projectRole);
	}
	
	private void chooseProjectRole_AccountManager(String nameOfProjectRole)
	{
		waitForElementClickable(droplistProjectRole);
		clickByJavaScript(droplistProjectRole);
		goTextOnNoEnter(txtSearchProjectRole, nameOfProjectRole);
		waitForElementClickable(5, txtSearchProjectRole);
		clickByJavaScript(optProjectRole_AccountManager);	
	}
	
	private void chooseAssignmentStartDate_Today()
	{
		clickByJavaScript(assignmentStartDate);
		waitForElementClickable(10, btnToday);
		clickByJavaScript(btnToday);
	}
	
	private void choosePerscentage()
	{
		clickByJavaScript(droplistPercentage);
		clickByJavaScript(percentage_0);
	}
	
	public void clickButtonSave()
	{
		clickByJavaScript(btnSave);
	}
	
	public void clickButtonAdd()
	{
		clickByJavaScript(btnAdd);
	}

	//Employee List or Employee Data >>> Projects >>> Add
	public void addEmployeeToTheProject(String nameOfProject) throws InterruptedException
	{
		sleep(2);
		chooseNameOfProject(nameOfProject);
		sleep(2);
		chooseStatus_First();
		chooseProjectRole();
		chooseAssignmentStartDate_Today();
		choosePerscentage();
		sleep(1);
		clickButtonSave();
	}
	
	//Project Management >>> Project Member List >>> Add
	public void addEmployeeToTheProjectMemberList(String nameOfEmployee,String nameOfProjectRole) throws InterruptedException
	{
		chooseNameOfEmployee(nameOfEmployee);
		chooseStatus_Active();
		chooseProjectRole_AccountManager(nameOfProjectRole);
		chooseAssignmentStartDate_Today();
		choosePerscentage();
		clickButtonAdd();
	}


}
