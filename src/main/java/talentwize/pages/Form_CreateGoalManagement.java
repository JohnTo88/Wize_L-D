package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class Form_CreateGoalManagement extends WebActions 
{

	public Form_CreateGoalManagement(WebDriver _driver) {
		super(_driver);
	}

	By txtSelectType = By.xpath("//span[contains(.,'Select Goal Type...')]");
	By optType = By.xpath("//div[@ng-bind-html='type.name| highlight: $select.search'][contains(.,'Company')]");
	By txtGoalName = By.xpath("//input[@ng-model='selectedGoal.name']");
	By txtSelectApplyTo = By.xpath("//div[contains(@data,'config.selectedData')]");
	By optApplyTo = By.xpath("//label[contains(.,'New')]");
	By txtSpecificObjective = By.xpath("(//div[contains(@ng-model,'html')])[1]");
	By txtMeasurement = By.xpath("(//div[contains(@ng-model,'html')])[2]");
	By txtCompanyValue = By.xpath("//span[contains(.,'Select Company Value...')]");
	By optComapnyValue = By.xpath("//label[contains(.,'Customer First (Deliver Quality)')]");
	By icoStartDate = By.xpath("(//i[@class='icon icon-calendar2'])[1]");
	By icoEndDate = By.xpath("(//i[@class='icon icon-calendar2'])[2]");
	By btnGoToToday = By.xpath("//span[contains(.,'Go to Today')]");
	By btnSave = By.xpath("//button[@ng-click='save()']");
	By lblSpec = By.xpath("//label[contains(.,'Specific Objective*')]");
	
	public void clickTxtSelectType()
	{
		waitForElementClickable(5, txtSelectType);
		clickByJavaScript(txtSelectType);
	}
	
	public void clickOptType()
	{
		waitForElementClickable(5, optType);
		clickByJavaScript(optType);
	}
	
	public void fillTxtGoalName(String NameOfGoalName)
	{
		waitForElementClickable(5, txtGoalName);
		clickByJavaScript(txtGoalName);
		goTextOn(txtGoalName, NameOfGoalName);	
	}
	
	public void clickTxtSelectApplyTo()
	{
		waitForElementClickable(5, txtSelectApplyTo);
		clickByJavaScript(txtSelectApplyTo);
	}
	
	public void clickOptApplyTo()
	{
		waitForElementClickable(5, optApplyTo);
		clickByJavaScript(optApplyTo);
	}
	
	public void fillTxtSpecificObjective(String ContentOfSpecificObjective)
	{
		waitForElementClickable(5, txtSpecificObjective);
		goTextOnNoEnter(txtSpecificObjective, ContentOfSpecificObjective);
	}
	
	public void fillTxtMeasurement(String ContentOfMeasurement)
	{
		waitForElementClickable(5, txtMeasurement);
		goTextOnNoEnter(txtMeasurement, ContentOfMeasurement);
	}
	
	public void clickTxtCompanyValue()
	{
		waitForElementClickable(5, txtCompanyValue);
		clickByJavaScript(txtCompanyValue);
	}
	
	public void clickLblSpec()
	{
		clickByJavaScript(lblSpec);
	}
	
	public void clickOptComapnyValue()
	{
		waitForElementClickable(5, optComapnyValue);
		clickByJavaScript(optComapnyValue);
	}
	
	public void clickIcoStartDate()
	{
		waitForElementClickable(5, icoStartDate);
		clickByJavaScript(icoStartDate);
	}
	
	public void clickIcoEndDate()
	{
		waitForElementClickable(5, icoEndDate);
		clickByJavaScript(icoEndDate);
	}
	
	public void clickBtnGoToToday()
	{
		waitForElementClickable(5, btnGoToToday);
		clickByJavaScript(btnGoToToday);
	}
	
	public void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void chooseType()
	{
		clickTxtSelectType();
		clickOptType();		
	}
	
	private void chooseApplyTo()
	{
		clickTxtSelectApplyTo();
		clickOptApplyTo();		
	}
	
	private void chooseComapanyValue()
	{
		clickTxtCompanyValue();
		clickOptComapnyValue();		
	}
	
	private void chooseStartDate()
	{
		clickIcoStartDate();
		clickBtnGoToToday();
	}
	
	private void chooseEndDate()
	{
		clickIcoEndDate();
		clickBtnGoToToday();
	}
	
	public void createGoalManagement(String NameOfGoalName,String ContentOfSpecificObjective,String ContentOfMeasurement)
	{
		chooseType();
		fillTxtGoalName(NameOfGoalName+TienIch.taoRandomChu(5));
		chooseApplyTo();
		clickLblSpec();
		fillTxtSpecificObjective(ContentOfSpecificObjective);
		fillTxtMeasurement(ContentOfMeasurement);
		chooseComapanyValue();
		chooseStartDate();
		chooseEndDate();
		clickBtnSave();
	}
}
