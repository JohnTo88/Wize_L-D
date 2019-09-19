package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GoalBoard extends WebActions {

	public GoalBoard(WebDriver _driver) {
		super(_driver);
	}
	
	By btnCreateGoal = By.xpath("//a[contains(.,'Create')]");
	By btnClone = By.xpath("(//a[contains(.,'Clone')])[1]"); 
	By btnExport = By.xpath("//button[contains(.,'Export')]");
	By fistHyperlink = By.xpath("(//a[@class='link-redirect ng-binding'])[4]");
	By listCheckbox = By.xpath("(//label[@class='i-checkbox m-b-0'])");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By fistCheckbox= By.xpath("(//label[@class='i-checkbox m-b-0'])[1]");
	By btnConfirmDelete = By.xpath("//button[contains(.,'Delete')]"); 
	By messageDeleteSuccess = By.xpath("//span[contains(.,'Goal deleted successfully!')]");
	By goalType = By.xpath("//div[@class='selected ellipsis-text ng-binding'][contains(.,'Goal Type:')]");
	By cboxInvidual = By.xpath("//label[@id='single-item-2']");
	
	public boolean isBtnCreateGoalDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnCreateGoal);
			if (driver.findElement(btnCreateGoal).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	
	public void clickOnButtonCreateGoal()
	{
		clickByJavaScript(btnCreateGoal);
	}
	
	public void clickOnGoadType()
	{
		clickByJavaScript(goalType);
	}
	
	public void chooseInvidual()
	{
		clickByJavaScript(cboxInvidual);
	}
	
	
	
	public boolean deleteAGoal()
	{
	  clickByJavaScript(fistCheckbox);
	  clickByJavaScript(iconDelete);
	  waitForElementClickable(10,btnConfirmDelete );
	  clickByJavaScript(btnConfirmDelete);
	  if (driver.findElement(messageDeleteSuccess).isDisplayed()==true)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
	}
	
	public boolean isIconDeleteDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, iconDelete);
			if (driver.findElement(iconDelete).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isListCheckboxDisplayed() {
		boolean flag = false;
		try {
			
			if (driver.findElements(listCheckbox).size()>0)
				flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isBtnCloneDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnClone);
			if (driver.findElement(btnClone).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnExportDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnExport);
			if (driver.findElement(btnExport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickOnFistHyperlink()
	{
		clickByJavaScript(fistHyperlink);
		sleep(5);
	}
	
	

}
