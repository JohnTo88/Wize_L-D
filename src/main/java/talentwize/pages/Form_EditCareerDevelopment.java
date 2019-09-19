package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditCareerDevelopment extends WebActions
{

	public Form_EditCareerDevelopment(WebDriver _driver) 
	{
		super(_driver);
	}
	
	By btnEdit = By.xpath("(//button[contains(.,'Edit')])[1]");
	By btnBack = By.xpath("//button[contains(.,'Back')]");
	By lblMyProgress = By.xpath("//h1[contains(.,'My Progress')]");
	By drplistStatus = By.xpath("(//span[@class='select2-chosen'])[1]");
	By optRequestToCancel = By.xpath("//div[@ng-bind-html='obj.name'][contains(.,'Request to Cancel')]");
	
	//===========Update progress==========
	By txtComment = By.xpath("(//textarea[@name='description'])[2]");
	By btnSave = By.xpath("(//button[contains(.,'Save')])[2]");	
	By msgSummitSuccess = By.xpath("//span[@class='message-content'][contains(.,'Submit successfully!')]");
	
	public void clickBtnEdit()
	{
		waitForElementClickable(5, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickBtnBack()
	{
		waitForElementClickable(5, btnEdit);
		clickByJavaScript(btnBack);
	}
	
	public void updateProgress(String Comment)
	{
		clickBtnEdit();
		waitForElementClickable(5, drplistStatus);
		clickByJavaScript(drplistStatus);
		waitForElementClickable(5, optRequestToCancel);
		clickByJavaScript(optRequestToCancel);
		waitForElementClickable(5, txtComment);
		goTextOnNoEnter(txtComment, Comment);
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public boolean isLblMyProgressDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblMyProgress).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag = false;
		try {
			waitForElementClickable(5, btnEdit);
			if (driver.findElement(btnEdit).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public boolean isMsgSummitSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgSummitSuccess).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

}
