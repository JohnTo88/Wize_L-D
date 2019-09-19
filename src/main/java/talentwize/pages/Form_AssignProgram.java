package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AssignProgram extends WebActions
{

	public Form_AssignProgram(WebDriver _driver) {
		super(_driver);
	}

	By txtCode = By.xpath("//input[contains(@name,'code')]");
	By txtCoordinator = By.xpath("//span[contains(.,'Select Employee...')]");
	By txtSearchCoordinator = By.xpath("(//input[@ng-model='$select.search'])[6]");
	By icoStartDate = By.xpath("(//button[@class='btn btn-sm btn-default btn-datepicker'])[1]");
	By icoEndDate = By.xpath("(//button[@class='btn btn-sm btn-default btn-datepicker'])[2]");
	By btnToday = By.xpath("//button[contains(.,'Today')]");
	By cboxEmployee = By.xpath("(//label[@class='i-checkbox'])[1]");
	By btnMove = By.xpath("(//button[contains(@ng-click,'select()')])[1]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	private void fillTxtCode(String Code)
	{
		waitForElementClickable(5, txtCode);
		goTextOnNoEnter(txtCode, Code);
	}
	
	private void chosseCoordinator(String Coordinator)
	{
		clickByJavaScript(txtCoordinator);
		waitForElementClickable(5, txtCoordinator);
		goTextOn(txtSearchCoordinator, Coordinator);
	}
	
	private void chooseStartDate()
	{
		clickByJavaScript(icoStartDate);
		clickByJavaScript(btnToday);
	}
	
	private void chooseEndDate()
	{
		clickByJavaScript(icoEndDate);
		clickByJavaScript(btnToday);
	}
	
	private void clickCboxEmployee()
	{
		clickByJavaScript(cboxEmployee);
	}
	
	private void clickBtnMove()
	{
		clickByJavaScript(btnMove);
	}
	
	private void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
	
	public void assignProgram(String Code,String Coordinator)
	{
		fillTxtCode(Code);
		chosseCoordinator(Coordinator);
		chooseStartDate();
		chooseEndDate();
		clickCboxEmployee();
		clickBtnMove();
		clickBtnSave();
	}
}
