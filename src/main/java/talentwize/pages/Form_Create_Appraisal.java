package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Create_Appraisal extends WebActions{
	public Form_Create_Appraisal(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}
	By txtName=By.xpath("//input[contains(@name,'name')]");
	By chkCycle=By.xpath("//span[contains(.,'Select Cycles...')]");
	By chkFirstCycle=By.xpath("(//div[@ng-bind-html='obj.name'])[2]");
	By txtStartDate=By.xpath("//input[contains(@name,'fromDate')]");
	By txtEndDate=By.xpath("//input[contains(@name,'toDate')]");
	By chkEmployee=By.xpath("(//span[contains(.,'Select Employee...')])[1]");
	By chkFirstEmployee=By.xpath("(//div[contains(@ng-bind-html,'obj.nameCombobox')])[3]");
	By chkEvaluator=By.xpath("(//div[contains(@class,'combobox-img ng-scope')])[2]");
	By chkFirstEvaluator=By.xpath("(//div[contains(@ng-bind-html,'obj.nameCombobox')])[2]");
	By btnNext_Step1 = By.xpath("(//button[contains(.,'Next')])[1]");
	By btnNext_Step2 = By.xpath("(//button[contains(.,'Next')])[2]");
	By btnCancel = By.xpath("(//button[contains(.,'Cancel')])[1]");
	By chkGoal=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='In progress'])[1]/following::label[1]");
	By btnArrow=By.xpath("//button[@ng-click='select()']");
	By btnSave=By.xpath("//button[contains(.,'Save')]");
	
	public void fillName(String _name) {
		waitForElementClickable(10, txtName);
		clickByJavaScript(txtName);
		goTextOn(txtName, _name);
	}
	public boolean isButtonNextDisplayed() {
		try {
			if (driver.findElement(btnNext_Step1).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	public void clickchkCycle()
	{
		waitForElementClickable(5,chkCycle);
		clickByJavaScript(chkCycle);
	}
	public void clickchkFirstCycle()
	{
		waitForElementClickable(5,chkFirstCycle);
		clickByJavaScript(chkFirstCycle);
	}
	public void clickchkEmployee()
	{
		waitForElementClickable(5,chkEmployee);
		clickByJavaScript(chkEmployee);
	}
	public void clickchkFirstEmployee()
	{
		waitForElementClickable(5,chkFirstEmployee);
		clickByJavaScript(chkFirstEmployee);
	}
	public void clickchkEvaluator()
	{
		waitForElementClickable(5,chkEvaluator);
		clickByJavaScript(chkEvaluator);
	}
	public void clickchkFirstEvaluator()
	{
		waitForElementClickable(5,chkFirstEvaluator);
		clickByJavaScript(chkFirstEvaluator);
	}
	public void clickButtonNext_Step1()
	{
		waitForElementClickable(5,btnNext_Step1);
		clickByJavaScript(btnNext_Step1);
		sleep(5);
	}
	public void clickButtonNext_Step2()
	{
		waitForElementClickable(5,btnNext_Step2);
		clickByJavaScript(btnNext_Step2);
		sleep(5);
	}
	public void clickchkGoal()
	{
		waitForElementClickable(5,chkGoal);
		clickByJavaScript(chkGoal);
	}
	public void clickButtonArrow()
	{
		waitForElementClickable(5,btnArrow);
		clickByJavaScript(btnArrow);
	}
	public void clickButtonSave()
	{
		waitForElementClickable(5,btnSave);
		clickByJavaScript(btnSave);
	}
	public void CreateAppraisal_Step1()
	{
		clickchkCycle();
		clickchkFirstCycle();
		clickchkEmployee();
		clickchkFirstEmployee();
		clickchkEvaluator();
		clickchkFirstEvaluator();
		clickButtonNext_Step1();
	}
	public void CreateAppraisal_Step2()
	{
		clickchkGoal();
		clickButtonArrow();
		clickButtonNext_Step2();
	}
	
}
