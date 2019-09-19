package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabCompetencyReviewSchedule extends WebActions {

	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By lblSettings = By.xpath("//div[@class='panel-heading font-bold'][contains(.,'Settings')]");
	By txtScheduleDate = By.xpath("//input[@ng-model='dateText']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By msgAddScheduleSuccess = By.xpath("//span[contains(.,'Create global competence review date successfully!')]");
	By msgEditScheduleSuccess = By.xpath("//span[contains(.,'Update of Global Competency Review successful')]");
	
	public TabCompetencyReviewSchedule(WebDriver _driver) 
	{
		super(_driver);	
	}

	public boolean isLblSettingsDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblSettings).isDisplayed() == true)
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
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnEdit).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnEdit()
	{
		waitForElementClickable(5, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void fillScheduleDate(String Date)
	{
		waitForElementClickable(5, txtScheduleDate);
		goTextOnNoEnter(txtScheduleDate, Date);
	}
	
	public void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}

	public boolean isMsgAddScheduleSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddScheduleSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditScheduleSuccessDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementClickable(80, msgEditScheduleSuccess);
			if (driver.findElement(msgEditScheduleSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
