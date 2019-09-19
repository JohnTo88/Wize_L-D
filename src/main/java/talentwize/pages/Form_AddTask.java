package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddTask extends WebActions {

	By txtTaskName = By.xpath("//input[@name='taskName']");
	By drplistTaskCategory = By.xpath("//span[contains(.,'Select Category...')]");
	By txtSearch = By.xpath("//input[@type='search']");
	By iconCalendarStartDate = By.xpath("(//i[@class='icon icon-calendar'])[1]");
	By iconCalendarDueDate = By.xpath("(//i[@class='icon icon-calendar'])[3]");
	By btnToday = By.xpath("//span[contains(.,'Go to Today')]");
	By optionSearch_Personal = By.xpath("(//div[@ng-bind-html='cate.value'])[1]"); 
	By optionSearch_Work = By.xpath("(//div[@ng-bind-html='cate.value'])[2]");
	By optionSearch_Other = By.xpath("(//div[@ng-bind-html='cate.value'])[3]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By textAddSuccessful = By.xpath("//span[contains(.,'Added successfully')]");
	
	public Form_AddTask(WebDriver _driver) {
		super(_driver);
	}
	
	private void fillTaskName(String nameOfTask)
	{
		waitForElementClickable(10, txtTaskName);
		typeText(txtTaskName, nameOfTask);
	}
	
	public void fillTaskCategory_Work()
	{
		clickByJavaScript(drplistTaskCategory);
		waitForElementClickable(10,txtSearch);
		clickByJavaScript(optionSearch_Work);
	}
	
	public void chooseStartDate()
	{
		clickByJavaScript(iconCalendarStartDate);
		clickByJavaScript(btnToday);
	}
	
	public void chooseDueDate()
	{
		clickByJavaScript(iconCalendarDueDate);
		clickByJavaScript(btnToday);
	}
	
	
	public void addTask(String nameOfTask) throws InterruptedException
	{
		waitForElementVisible(10, btnSave);
		fillTaskName(nameOfTask);
		fillTaskCategory_Work();
		chooseStartDate();
		chooseDueDate();
		clickByJavaScript(btnSave);
	
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}
}
