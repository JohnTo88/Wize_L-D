package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateAppraisalCycle extends WebActions
{

	public Form_CreateAppraisalCycle(WebDriver _driver) {
		super(_driver);
	}

	By txtName = By.xpath("//input[@ng-model='cycle.name']");
	By icoStartDate = By.xpath("(//i[@class='icon icon-calendar2'])[1]");
	By icoEndDate = By.xpath("(//i[@class='icon icon-calendar2'])[2]");
	By btnToday = By.xpath("//button[contains(.,'Today')]");
	By btnNextStep1 = By.xpath("//button[@ng-click='nextToSecondStep()']");
	By btnNextStep2 = By.xpath("//button[@ng-click='steps.step3=true;summary()']");
	By btnSave = By.xpath("//button[@ng-click='save()']");
	
	public void fillTxtName(String NameOfCycle)
	{
		waitForElementClickable(5, txtName);
		goTextOnNoEnter(txtName, NameOfCycle);
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
	
	public void clickBtnToday()
	{
		waitForElementClickable(5, btnToday);
		clickByJavaScript(btnToday);
	}
	
	public void clickBtnNext1()
	{
		waitForElementClickable(5, btnNextStep1);
		clickByJavaScript(btnNextStep1);
	}
	

	public void clickBtnNext2()
	{
		waitForElementClickable(5, btnNextStep2);
		clickByJavaScript(btnNextStep2);
	}
	
	public void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void createNewCycle(String NameOfCycle)
	{
		fillTxtName(NameOfCycle);
		clickIcoStartDate();
		clickBtnToday();
		clickIcoEndDate();
		clickBtnToday();
		clickBtnNext1();
		clickBtnNext2();
		clickBtnSave();
	}
}
