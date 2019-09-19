package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CareerDevelopmentBoard extends WebActions
{

	public CareerDevelopmentBoard(WebDriver _driver) {
		super(_driver);
	}

	By btnManage = By.xpath("(//button[contains(.,'Manage')])[1]");
	By lblCareerDevRequest = By.xpath("//h1[contains(.,'Career Development Requests')]");
	By linkEdit = By.xpath("(//span[@ng-click='fn_on_sender($index, item)'])[1]");
	By btnReview = By.xpath("//button[contains(.,'Review')]");
	By msgError = By.xpath("//span[@class='message-content'][contains(.,'You do not have permission to approve.')]");
	By btnApproveRequest = By.xpath("//button[contains(.,'Approve request')]");
	By msgApproveSuccess = By.xpath("//span[@class='message-content'][contains(.,'Approve career development request successfully!')]");
	By drplistStatus = By.xpath("(//span[@ng-hide='$select.isEmpty()'])[3]");
	By txtSearchStatus = By.xpath("(//input[contains(@type,'search')])[4]");
	By btnFilter = By.xpath("//button[contains(.,'Filter')]");
	By txtSearchRequestor = By.xpath("//input[contains(@placeholder,'Search requestor by name...')]");
	
	private void fillTxtSearchStatus(String Status)
	{
		waitForElementClickable(5, txtSearchStatus);
		goTextOn(txtSearchStatus, Status);
	}
	
	public void fillTxtSearchRequestor(String Requestor)
	{
		waitForElementClickable(5, txtSearchRequestor);
		goTextOn(txtSearchRequestor, Requestor);
	}
	
	public void clickBtnManage()
	{
		waitForElementClickable(5, btnManage);
		clickByJavaScript(btnManage);
	}
	
	public void clickBtnApproveRequest()
	{
		waitForElementClickable(5, btnApproveRequest);
		clickByJavaScript(btnApproveRequest);
	}
	
	private void clickDrplistStatus()
	{
		waitForElementClickable(5, drplistStatus);
		clickByJavaScript(drplistStatus);
	}
	
	private void clickBtnFilter()
	{
		waitForElementClickable(5, btnFilter);
		clickByJavaScript(btnFilter);
	}
	
	public void clickBtnReview()
	{
		sleep(2);
		clickByJavaScript(btnReview);
	}
	
	public boolean isLblCareerDevRequestDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblCareerDevRequest).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isMsgErrorDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgError).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isMsgApproveSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgApproveSuccess).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public void filterStatusPeding(String Status)
	{
		clickDrplistStatus();
		fillTxtSearchStatus(Status);
		clickBtnFilter();
	}
	
	public void filterStatusInProgress(String Status)
	{
		clickDrplistStatus();
		fillTxtSearchStatus(Status);
		clickBtnFilter();
	}
	
	public boolean isLinkEditDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(linkEdit).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isBtnReviewDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnReview).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isBtnManageDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnManage).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
}
