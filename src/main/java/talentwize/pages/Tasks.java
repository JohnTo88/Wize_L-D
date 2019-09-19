package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Tasks extends WebActions {

	By btnAdd = By.xpath("//button[@ng-click=\"editCurrentRecord(null, 'add', 'mytask')\"]");
	By textAddSuccessful = By.xpath("//span[contains(.,'Added successfully')]");
	By iconDelete = By.xpath("(//i[contains(@class,'icon icon-bin')])");
	By linkOfTasks = By.xpath("(//span[@class='ng-binding link-redirect'])");
	By iconsStatus = By.xpath("(//i[contains(@class,'icon icon-circle radio-normal text-danger')])");
	By cboxSelectTask_1 = By.xpath("(//input[@type='checkbox'])[1]");
	By btnYes= By.xpath("//button[contains(.,'Yes')]");
	By textDeleteSuccesul = By.xpath("//span[contains(.,'Deleted successfully')]");
	
	By linkOfTask1 = By.xpath("(//span[@class='ng-binding link-redirect'])[1]");
	
	By textUpdateSuccessfull = By.xpath("//span[contains(.,'Updated successfully')]");
	
	By textDeleteSuccessfull = By.xpath("//span[contains(.,'Deleted successfully')]");
	
	public Tasks(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isTextAddSuccesfullDisplayed()
	{
		boolean flag = false;
		try {
			 if (driver.findElement(textAddSuccessful).isDisplayed()==true)
				 flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
				
	}
	
	public void clickButtonAdd()
	{
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
		sleep(1);
	}

	
	public boolean isTextUpdateSuccesfullDisplayed()
	{
		boolean flag = false;
		try {
			 if (driver.findElement(textUpdateSuccessfull).isDisplayed()==true)
				 flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
				
	}
	

	public boolean isTextDeletedSuccesfullDisplayed()
	{
		boolean flag = false;
		try {
			 if (driver.findElement(textDeleteSuccessfull).isDisplayed()==true)
				 flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
				
	}
	
	public boolean isLinkOfTasksDisplayed()
	{
		boolean flag = false;
		try {
			 if (driver.findElements(linkOfTasks).size() > 0)
				 flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
				
	}
	
	public boolean isIconsStatusDisplayed()
	{
		boolean flag = false;
		try {
			 if (driver.findElements(iconsStatus).size() > 0)
				 flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
				
	}
	
	public boolean isButtonAddDisplayed()
	{
		boolean flag = false;
		try {
			 if (driver.findElement(btnAdd).isDisplayed()==true)
				 flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
				
	}
	
	public boolean isIconDeletedDisplayed()
	{
		boolean flag = false;
		try {
			 if (driver.findElement(iconDelete).isDisplayed()==true)
				 flag = true;
			
		} catch (Exception e) {
			return flag;
		}
		return flag;
				
	}
	
	public void deleteTask()
	{
		//waitForElementClickable(10, cboxSelectTask_1);
		clickByJavaScript(cboxSelectTask_1);
		clickByJavaScript(iconDelete);
		waitForElementClickable(10, btnYes);
		clickByJavaScript(btnYes);
	}
	
	public void clickInLinkOfTask()
	{
		waitForElementClickable(10,linkOfTask1);
		clickByJavaScript(linkOfTask1);

	}
	
	
	
	
	
	
	

}
