package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CareerDevelopmentUpdateProgress extends WebActions
{

	public CareerDevelopmentUpdateProgress(WebDriver _driver) {
		super(_driver);
	}

	By btnEdit = By.xpath("//button[@ng-if='editable']");
	By txtComment = By.xpath("(//textarea[contains(@name,'description')])[2]");
	By btnSave = By.xpath("//button[@ng-click='submit()']");
	By optCanceled = By.xpath("//div[@ng-bind-html='obj.name'][contains(.,'Canceled')]");
	By drplistStatus = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Status'])[1]/following::b[1]");
	By msgSummitSuccess = By.xpath("//span[@class='message-content'][contains(.,'Submit successfully!')]");
	
	private void clickBtnEdit()
	{
		waitForElementClickable(4, btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	private void clickBtnSave()
	{
		waitForElementClickable(4, btnSave);
		clickByJavaScript(btnSave);
	}
	
	private void clickDrplistStatus()
	{
		clickByJavaScript(drplistStatus);
		waitForElementClickable(4, optCanceled);
		clickByJavaScript(optCanceled);
	}
	
	private void fillTxtComment(String ContentOfComment)
	{
		waitForElementClickable(5, txtComment);
		goTextOnNoEnter(txtComment, ContentOfComment);
	}
	
	public void updateProgress(String ContentOfComment)
	{
		clickBtnEdit();
		sleep(2);
		clickDrplistStatus();
		fillTxtComment(ContentOfComment);
		clickBtnSave();
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
