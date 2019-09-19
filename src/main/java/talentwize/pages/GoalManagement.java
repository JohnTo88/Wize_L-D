package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GoalManagement extends WebActions 
{
	public GoalManagement(WebDriver _driver) {
		super(_driver);
	}
	
	By lblTitleGoalManagement = By.xpath("//h1[contains(.,'Goal Management')]");
	By linkEdit = By.xpath("//a[contains(.,'Test Automation')]");
	By btnAcion = By.xpath("//div[@aria-haspopup='true']");
	By optReview = By.xpath("//a[contains(.,'Review')]");
	By optUnassign = By.xpath("//a[@ng-click='viewUnassignedMember(goal)']");
	By optArchive = By.xpath("//a[contains(.,'Archive')]");
	By lblGoalReiew = By.xpath("(//span[contains(.,'Goal Review')])[2]");
	By btnCreate = By.xpath("//a[contains(.,'Create')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By lblType = By.xpath("//label[contains(.,'Type')]");
	By cboxDelete = By.xpath("(//label[@class='i-checkbox m-b-0'])[1]");
	By btnDelete = By.xpath("//button[@ng-click='ok()']");
	By msgDeleteSuccess = By.xpath("//span[@class='message-content'][contains(.,'Goal deleted successfully!')]");
	By btnBack = By.xpath("(//button[contains(.,'Back')])[2]"); 
	
	public boolean isLblTitleGoalManagementDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, lblTitleGoalManagement);
			if (driver.findElement(lblTitleGoalManagement).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isLblTypedDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, lblType);
			if (driver.findElement(lblType).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickLinkEdit()
	{
		waitForElementClickable(5, linkEdit);
		clickByJavaScript(linkEdit);
	}
	
	public void clickOnButtonBack()
	{
		sleep(5);
		clickByJavaScript(btnBack);
	}
	
	public boolean isLinkEditdDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, linkEdit);
			if (driver.findElement(linkEdit).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnAction()
	{
		waitForElementClickable(5, btnAcion);
		clickByJavaScript(btnAcion);
	}
	
	public void clickOptReview()
	{
		waitForElementClickable(5, optReview);
		clickByJavaScript(optReview);
	}
	
	public boolean isOptReviewdDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, optReview);
			if (driver.findElement(optReview).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isOptUnassigndDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, optUnassign);
			if (driver.findElement(optUnassign).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblGoalReiewDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, lblGoalReiew);
			if (driver.findElement(lblGoalReiew).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIcoDeleteDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, icoDelete);
			if (driver.findElement(icoDelete).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreate()
	{
		waitForElementClickable(5, btnCreate);
		clickByJavaScript(btnCreate);
		sleep(2);
	}
	
	public boolean isBtnCreateDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnCreate);
			if (driver.findElement(btnCreate).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isOptArchiveDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, optArchive);
			if (driver.findElement(optArchive).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
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
	
	public void deleteGoal()
	{
		clickCboxDelete();
		clickIcoDelete();
		clickBtnDelete();
	}
	
	public boolean isMsgDeleteSuccessDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, msgDeleteSuccess);
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
