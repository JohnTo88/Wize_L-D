package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateProject extends WebActions {

	public Form_CreateProject(WebDriver _driver) {
		super(_driver);
		
	}
	
	By txtProjectName = By.xpath("//input[@name='projectName']");
	By txtProjectID = By.xpath("//input[@name='projectId']");
	By drplistProjectLeader = By.xpath("//span[contains(.,'Select Employee...')]"); 
	By optList_Fist = By.xpath("(//div[@ng-bind-html='obj.nameCombobox'])[2]"); 
	By btnStartDate = By.xpath("(//i[contains(@class,'icon icon-calendar2')])[1]"); 
	By btnToday = By.xpath("//button[contains(.,'Today')]"); 
	By btnCreate = By.xpath("//button[@type='submit']"); 
	By drpListSite = By.xpath("//input[contains(@placeholder,'Select Sites...')]"); 
	By optListSite_Fist = By.xpath("//div[contains(@ng-bind-html,'region.name')]"); 
	
	public void fillProjectName (String nameOfProject)
	{
		waitForElementClickable(10, txtProjectName);
		goTextOn(txtProjectName, nameOfProject);
	}
	
	public void fillProjectId(String idOfProject)
	{
		goTextOn(txtProjectID, idOfProject);
	}
	
	public void chooseProjectLeader()
	{
		clickByJavaScript(drplistProjectLeader);
		clickByJavaScript(optList_Fist);
	}
	
	public void chooseProjectSite()
	{
		clickByJavaScript(drpListSite);
		clickByJavaScript(optListSite_Fist);
	}
	
	public void chooseStartDate()
	{
		clickByJavaScript(btnStartDate);
		clickByJavaScript(btnToday);
	}
	
	public void createProject(String nameOfProject, String IdOfProject)
	{
		fillProjectName(nameOfProject);
		fillProjectId(IdOfProject);
		chooseProjectLeader();
		chooseProjectSite();
		chooseStartDate();
		clickByJavaScript(btnCreate);
		
	}
	
	
	
	
	
	

}
