package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateSuccessionPlan extends WebActions
{

	public Form_CreateSuccessionPlan(WebDriver _driver) {
		super(_driver);
	}
	
	By txtSelectKeyMember = By.xpath("(//span[contains(.,'Select ...')])[2]");
	By txtSearchKeymember = By.xpath("(//input[@ng-model='search.name'])[2]");
	By btnNextStep1 = By.xpath("(//button[contains(.,'Next')])[2]");
	By btnNextStep2 = By.xpath("(//button[contains(.,'Next')])[1]");
	By btnSelectView = By.xpath("(//button[contains(.,'Select & View Competency')])[1]");
	By btnSummit = By.xpath("//button[contains(.,'Submit')]");
	By txtSearchName = By.xpath("(//input[contains(@placeholder,'Search...')])[5]");
	By optKeymember = By.xpath("//span[@class='font-bold'][contains(.,'Cuong Automation 1')]");
	
	private void fillTxtSearcthName(String NameOfEmployee)
	{
		waitForElementClickable(5, txtSearchName);
		goTextOn(txtSearchName, NameOfEmployee);
	}
	
	private void clickTxtSelectKeyMember()
	{
		clickByJavaScript(txtSelectKeyMember);
	}
		
	private void fillTxtSearchKeyMember(String SelectKeyMember)
	{
		goTextOnNoEnter(txtSearchKeymember,SelectKeyMember);
		waitForElementClickable(10, optKeymember);
		clickByJavaScript(optKeymember);
		
	}
	
	private void clickBtnNextStep1()
	{
		waitForElementClickable(5, btnNextStep1);
		clickByJavaScript(btnNextStep1);
	}
	
	private void clickBtnSelectView()
	{
		waitForElementClickable(5, btnSelectView);
		clickByJavaScript(btnSelectView);
	}
	
	private void clickBtnNextStep2()
	{
		waitForElementClickable(5, btnNextStep2);
		clickByJavaScript(btnNextStep2);
	}
	
	private void clickBtnSummit()
	{
		waitForElementClickable(5, btnSummit);
		clickByJavaScript(btnSummit);
	}
	
	public void createSuccessionPlanning(String SelectKeyMember,String NameOfEmployee)
	{
		clickTxtSelectKeyMember();
		fillTxtSearchKeyMember(SelectKeyMember);
		sleep(4);
		clickBtnNextStep1();
		sleep(0.5);
		fillTxtSearcthName(NameOfEmployee);
		sleep(4);
		clickBtnSelectView();
		sleep(0.5);
		clickBtnNextStep2();
		sleep(0.5);
		clickBtnSummit();
	}
}
