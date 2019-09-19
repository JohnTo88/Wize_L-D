package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Employment extends WebActions {

	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By linkInterviewer = By.xpath("(//span[contains(@ng-click,'index)')])[1]");
	By drplistMethodOfRecruitment = By.xpath("//span[@class='select2-chosen']");
	By listOptFist = By.xpath("(//div[@ng-bind-html='method.name'])[1]");
	By messageUpdateSuccess = By.xpath("//span[contains(.,'Updated successfully')]");
	By messageDeleteSuccess = By.xpath("//span[contains(.,'Deleted successfully')]"); 
	By messageAddSuccess = By.xpath("//span[contains(.,'Added successfully')]");
	By cboxInterviewHistory = By.xpath("//input[contains(@type,'checkbox')]");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYesConfirm = By.xpath("//button[contains(.,'Yes')]");
	
	
	public Employment(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void clickButtonEdit()
	{
		waitForElementClickable(5,btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	
	public void clickLinkInterview()
	{
		waitForElementClickable(10, linkInterviewer);
		clickByJavaScript(linkInterviewer);
		
	}
	
	public void clickButtonSave()
	{
		waitForElementClickable(5,btnSave);
		clickByJavaScript(btnSave);
	}
	
	public void clickButtonAdd()
	{
		waitForElementClickable(5,btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public boolean isBtnAddDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(iconDelete).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
		
	}
	
	public boolean isMessageAddSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(messageAddSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnEdit).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLinkInterviewerDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkInterviewer).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void editMethodOfRecruitment()
	{
		clickByJavaScript(drplistMethodOfRecruitment);
		clickByJavaScript(listOptFist);
		clickByJavaScript(btnSave);
	}
	
	public boolean isMessageUpdateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMessageDeleteSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(messageDeleteSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public void deleteInterviewHistory()
	{
		clickByJavaScript(cboxInterviewHistory);
		clickByJavaScript(iconDelete);
		clickByJavaScript(btnYesConfirm);
	}
	
	
	
	
	
}
