package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateCareerDevelopment extends WebActions
{

	public Form_CreateCareerDevelopment(WebDriver _driver) {
		super(_driver);
	}

	By txtJobTitle = By.xpath("//span[contains(.,'Select Job Title...')]");
	By txtUnit = By.xpath("//span[contains(.,'Select Units...')]");
	By btnSearch = By.xpath("//button[contains(.,'Search')]");
	By btnBack = By.xpath("//button[contains(.,'Back')]");
	By btnApplyNewCarrer = By.xpath("//button[contains(.,'Apply for new career path')]");
	By txtSearch = By.xpath("(//input[contains(@placeholder,'Search...')])[2]");
	By txtSearchUnit = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Organize by'])[1]/preceding::input[1]");
	By optTester = By.xpath("(//div[contains(.,'VNM')])[7]");
	
	//===Popup Apply for new Career Path===
	By icoCalendar = By.xpath("//i[@class='icon icon-calendar2']");
	By btnToDay = By.xpath("//button[contains(.,'Today')]");
	By txtDescription = By.xpath("//textarea[@name='description']");
	By btnApply = By.xpath("//button[@ng-click='submit()']");
	
	private void fillTxtJobTitle(String JobTitle)
	{
		clickByJavaScript(txtJobTitle);
		waitForElementClickable(5, txtJobTitle);
		goTextOn(txtSearch, JobTitle);
	}
	
	private void fillTxtUnit(String Unit)
	{
		clickByJavaScript(txtUnit);
		waitForElementClickable(5, txtUnit);
		goTextOnNoEnter(txtSearchUnit, Unit);
		clickOptTester();
	}
	
	private void clickOptTester()
	{
		
		clickByJavaScript(optTester);
	}
	
	private void clickBtnSearch()
	{
		waitForElementClickable(5, btnSearch);
		clickByJavaScript(btnSearch);
	}
	
	private void clickBtnApplyNewCarrer()
	{
		waitForElementClickable(5, btnApplyNewCarrer);
		clickByJavaScript(btnApplyNewCarrer);
	}
	
	private void clickBtnBack()
	{
		waitForElementClickable(5, btnBack);
		clickByJavaScript(btnBack);
	}
	
	private void clickIcoCalendar()
	{
		waitForElementClickable(5, icoCalendar);
		clickByJavaScript(icoCalendar);
	}
	
	private void clickBtnToday()
	{
		waitForElementClickable(5, btnToDay);
		clickByJavaScript(btnToDay);
	}
	
	private void fillTxtDescription(String Description)
	{
		waitForElementClickable(txtDescription);
		goTextOn(txtDescription, Description);
	}
	
	private void clickBtnApply()
	{
		waitForElementClickable(5, btnApply);
		clickByJavaScript(btnApply);
	}

	public void createCareerDevelopment(String JobTitle,String Unit)
	{
		fillTxtJobTitle(JobTitle);
		fillTxtUnit(Unit);
		clickBtnSearch();
		clickBtnApplyNewCarrer();
	}
	
	public void sumitCareerDevelopment(String Description)
	{
		clickIcoCalendar();
		clickBtnToday();
		fillTxtDescription(Description);
		clickBtnApply();
	}	
}