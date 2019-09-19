package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddKPIMappingForProject extends WebActions
{

	public Form_AddKPIMappingForProject(WebDriver _driver) {
		super(_driver);
	}
	
	By drplistProject = By.xpath("(//span[contains(.,'Select Project...')])[2]");
	By optProject = By.xpath("//div[contains(@ng-bind-html,'project.name')]");
	By drplistSite = By.xpath("(//span[contains(.,'Select Sites...')])[2]");
	By optSite = By.xpath("//div[contains(@ng-bind-html,'region.name')]");
	By drplistProjectRole = By.xpath("(//span[contains(.,'Select Role...')])[2]");
	By optProjectRole = By.xpath("//div[contains(@ng-bind-html,'position.name')]");
	
	By txtEffectiveFrom=By.xpath("//input[@name='startDate']");
	By chkKPI=By.xpath("(//label[@class='i-checkbox'])[1]");
	By btnNext=By.xpath("//i[@class='icon icon-arrow-right']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By icoCalendarEffectiveFrom = By.xpath("(//i[contains(@class,'icon icon-calendar2')])[1]");
	By iconCalendarEffectiveTo = By.xpath("(//i[contains(@class,'icon icon-calendar2')])[2]");
	By btnToday = By.xpath("//button[contains(.,'Today')]");
	
	public void selectProject()
	{
		waitForElementClickable(10, drplistProject);
		clickByJavaScript(drplistProject);
		waitForElementClickable(10, optProject);
		clickByJavaScript(optProject);
	}
	
	public void selectSite()
	{
		waitForElementClickable(5, drplistSite);
		clickByJavaScript(drplistSite);
		waitForElementClickable(5, optSite);
		clickByJavaScript(optSite);
	}
	
	public void selectProjectRole()
	{
		waitForElementClickable(5, drplistProjectRole);
		clickByJavaScript(drplistProjectRole);
		waitForElementClickable(5, optProjectRole);
		clickByJavaScript(optProjectRole);
	}
	
	public void clickchkKPI() {
		clickByJavaScript(chkKPI);
	}

	public void clickbtnNext() {
		clickByJavaScript(btnNext);
	}
	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}
	
	public void addAssignRuleForProject() 
	{
		selectProject();
		selectSite();
		selectProjectRole();
		clickByJavaScript(icoCalendarEffectiveFrom);
		clickByJavaScript(btnToday);
		sleep(0.5);
		clickByJavaScript(iconCalendarEffectiveTo);
		clickByJavaScript(btnToday);
		sleep(0.5);
		clickchkKPI();
		clickbtnNext();
		clickBtnSave();
	}

}
