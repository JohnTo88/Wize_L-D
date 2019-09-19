package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyGoal extends WebActions {

	By lblMyGoal = By.xpath("//h1[contains(.,'My Goal')]");
	By btnCreate = By.xpath("//a[contains(.,'Create')]");
	By goalName = By.xpath("(//a[@ui-sref='app.pfm-goal-mygoal-detail({goalId: goal.id})'])[1]");
	By btnUpdateProgress = By.xpath("//button[contains(.,'Update Progress')]");
	By btnBack = By.xpath("//a[contains(.,'Back')]");
	
	By drplistGoalType = By.xpath("//span[contains(.,'Select Goal Type...')]");
	By individualGoalType = By.xpath("(//div[contains(.,'Individual')])[4]");
	By txtGoalName = By.xpath("//input[@name='name']");
	By txtSpecificObjective = By.xpath("(//div[contains(@contenteditable,'true')])[1]");
	By txtMeasurement = By.xpath("(//div[contains(@contenteditable,'true')])[2]");
	By drplistCompanyValue = By.xpath("//span[contains(.,'Select Company Value...')]");
	By firstOptionCV = By.xpath("(//label[@ng-bind-html='checkbox.htmlDisplay'])[41]");
	By txtStartDate = By.xpath("//input[contains(@name,'startDate')]");
	By txtEndDate = By.xpath("//input[@name='endDate']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By msgCreateGoalSuccess = By.xpath("(//div[contains(.,'Create goal successfully!')])[2]");
	
	By txtComment = By.xpath("//textarea[contains(@ng-model,'goalLog.comment')]");
	By btnUpdate = By.xpath("//button[@type='button'][contains(.,'Update')]");
	By msgUpdateGoalSuccess = By.xpath("//span[contains(.,'Progress updated successfully!')]");
	
	By filterGoalType = By.xpath("(//div[contains(@class,'selected ellipsis-text ng-binding')])[2]");
	By optIndividual = By.xpath("(//label[contains(.,'Individual')])[1]");
	By cboxDelete = By.xpath("(//label[contains(@class,'i-checkbox m-b-0')])[1]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnDelete = By.xpath("//button[contains(.,'Delete')]");
	By msgDeletetGoalSuccess = By.xpath("//span[contains(.,'Goal deleted successfully!')]");
	
	public MyGoal(WebDriver _driver) 
	{
		super(_driver);	
	}
	
	public boolean isLblMyGoalDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblMyGoal).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isBtnCreateDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnCreate).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public void clickBtnCreate()
	{
		waitForElementClickable(5, btnCreate);
		clickByJavaScript(btnCreate);
	}
	
	public void clickGoalName()
	{
		waitForElementClickable(5, goalName);
		clickByJavaScript(goalName);
	}
	
	public void clickBtnBack()
	{
		waitForElementClickable(5, btnBack);
		clickByJavaScript(btnBack);
	}
	
	public boolean isBtnUpdateProgressDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnUpdateProgress).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnUpdateProgress()
	{
		waitForElementClickable(5, btnUpdateProgress);
		clickByJavaScript(btnUpdateProgress);
	}
	
	// ==================================//
	
	private void chooseGoalType()
	{
		clickByJavaScript(drplistGoalType);
		waitForElementClickable(individualGoalType);
		clickByJavaScript(individualGoalType);
	}
	
	private void fillSpecificObjective(String specificObjective)
	{
		waitForElementClickable(5, txtSpecificObjective);
		goTextOn(txtSpecificObjective, specificObjective);
	}
	
	private void fillMeasurement(String measurement)
	{
		waitForElementClickable(5, txtMeasurement);
		goTextOn(txtMeasurement, measurement);
	}
	
	private void chooseCompanyValue()
	{
		clickByJavaScript(drplistCompanyValue);
		waitForElementClickable(firstOptionCV);
		clickByJavaScript(firstOptionCV);
	}
	
	private void fillStartDate(String startDate)
	{
		waitForElementClickable(5, txtStartDate);
		goTextOn(txtStartDate, startDate);
	}
	
	private void fillEndDate(String endDate)
	{
		waitForElementClickable(5, txtEndDate);
		goTextOn(txtEndDate, endDate);
	}
	
	private void clickBtnSave()
	{
		try {
			waitForElementPresent(5, btnSave);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickByJavaScript(btnSave);
	}
	
	public boolean isMsgCreateGoalSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgCreateGoalSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void createGoal(String goalName) throws InterruptedException {
		clickByJavaScript(btnCreate);
		waitForPageLoaded();
		
		chooseGoalType();
		typeText(txtGoalName, goalName);
		fillSpecificObjective("abc");
		fillMeasurement("xyz");
		chooseCompanyValue();
		fillStartDate("01-Mar-2019");
		fillEndDate("31-Mar-2019");
		clickBtnSave();
	}
	
	// ==================================//
	
	private void fillComment(String comment)
	{
		waitForElementClickable(5, txtComment);
		goTextOn(txtComment, comment);
	}
	
	public void clickBtnUpdate()
	{
		waitForElementClickable(5, btnUpdate);
		clickByJavaScript(btnUpdate);
	}
	
	public void updateGoal() throws InterruptedException {
		clickByJavaScript(goalName);
		clickByJavaScript(btnUpdateProgress);
		fillComment("aaa");
		clickBtnUpdate();
	}
	
	public boolean isMsgUpdateGoalSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgUpdateGoalSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	// ==================================//
	
	public void clickFilterGoalType()
	{
		waitForElementClickable(5, filterGoalType);
		clickByJavaScript(filterGoalType);
	}
	
	public void clickOptIndividual()
	{
		waitForElementClickable(5, optIndividual);
		clickByJavaScript(optIndividual);
	}

	public boolean isIcoDeleteDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementClickable(5, icoDelete);
			if (driver.findElement(icoDelete).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickCboxDelete()
	{
		waitForElementClickable(5, cboxDelete);
		clickByJavaScript(cboxDelete);
	}
	
	public void clickIcoDelete()
	{
		waitForElementClickable(5, icoDelete);
		clickByJavaScript(icoDelete);
	}
	
	public void clickBtnDelete()
	{
		waitForElementClickable(5, btnDelete);
		clickByJavaScript(btnDelete);
	}
	
	public void deleteGoal() throws InterruptedException {
		clickFilterGoalType();
		clickOptIndividual();
		clickCboxDelete();
		clickIcoDelete();
		clickBtnDelete();
	}
	
	public boolean isMsgDeleteGoalSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetGoalSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
}
