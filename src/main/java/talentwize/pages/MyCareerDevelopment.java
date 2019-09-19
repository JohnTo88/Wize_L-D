package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyCareerDevelopment extends WebActions
{

	public MyCareerDevelopment(WebDriver _driver) {
		super(_driver);
	}

	By lblMyCareer = By.xpath("//h1[contains(.,'Career Development')]");
	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By msgCreateCareerSuccess = By.xpath("//span[@class='message-content'][contains(.,'Create career development request successfully!')]");
	By btnCancelRequest = By.xpath("//button[contains(.,'Cancel Request')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By linkPosition = By.xpath("(//span[contains(@ng-if,'true')])[1]");
	By lblStatusCancel  = By.xpath("(//span[contains(.,'Canceled')])");
	By linkPositionInprogress = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='In Progress'])[1]/preceding::span[3]");
	
	public void clickLinkPositionInprogress()
	{
		waitForElementClickable(5, linkPositionInprogress);
		clickByJavaScript(linkPositionInprogress);
	}
	
	public boolean isLinkPositionInprogressDisplayed()
	{
		boolean flag = false;
		try {
			waitForElementClickable(5, linkPositionInprogress);
			if (driver.findElement(linkPositionInprogress).isDisplayed() == true)
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
	
	public void clickLinkPosition()
	{
		waitForElementClickable(5, linkPosition);
		clickByJavaScript(linkPosition);
	}
	
	public void clickBtnYes()
	{
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
	
	public void clickBtnCancelRequest()
	{
		waitForElementClickable(5, btnCancelRequest);
		clickByJavaScript(btnCancelRequest);
	}
	
	public boolean isLblMyCareerDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMyCareer).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	

	public boolean isLblStatusCancelDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblStatusCancel).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isBtnCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCreate).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isLinkPositionDisplayed()
	{
		boolean flag = false;
		try {
			
			if (driver.findElement(linkPosition).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isBtnCancelRequestDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCancelRequest).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
		
	public boolean isMsgCreateCareerSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgCreateCareerSuccess).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public void cancelRequest()
	{
		waitForElementClickable(5, btnCancelRequest);
		clickByJavaScript(btnCancelRequest);
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
	
}
