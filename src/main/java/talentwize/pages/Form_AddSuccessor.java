package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddSuccessor extends WebActions
{

	public Form_AddSuccessor(WebDriver _driver) {
		super(_driver);
	}

	By btnSelectView = By.xpath("(//button[contains(.,'Select & View Competency')])[1]");
	By btnNext = By.xpath("//button[contains(.,'Next')]");
	By btnSummit = By.xpath("//button[contains(.,'Submit')]");
	By txtSearchName = By.xpath("(//input[contains(@placeholder,'Search...')])[5]");
	
	private void clickBtnNextStep()
	{
		clickByJavaScript(btnNext);
	}
	
	private void clickBtnSelectView()
	{
		waitForElementClickable(5, btnSelectView);
		clickByJavaScript(btnSelectView);
	}
		
	private void clickBtnSummit()
	{
		clickByJavaScript(btnSummit);
	}
	
	private void fillTxtSearcthName(String NameOfEmployee)
	{
		waitForElementClickable(5, txtSearchName);
		goTextOn(txtSearchName, NameOfEmployee);
	}
	
	public void addNewSuccessor(String fillTxtSearcthName)
	{
		fillTxtSearcthName(fillTxtSearcthName);
		sleep(4);
		clickBtnSelectView();
		sleep(0.5);
		clickBtnNextStep();
		sleep(0.5);
		clickBtnSummit();
	}
}
