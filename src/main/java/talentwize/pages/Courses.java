package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TestLogger;
import controller.WebActions;

public class Courses extends WebActions {

	public Courses(WebDriver _driver) {
		super(_driver);
	}
	
	By linkCourseNames = By.xpath("(//span[contains(@ng-click,'index, item)')])");
	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By btnAssign = By.xpath("(//button[contains(.,'Assign')])");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By fistLinkCourseName = By.xpath("");
	By msgCreatedSuccess = By.xpath("//span[contains(.,'Course created successfully!')]"); 
	By msgDeleteSuccess = By.xpath("//span[contains(.,'Delete course successfully')]");
	By drpCourse = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All'])[11]/following::span[1]");
	By txtSearchCourse = By.xpath("//input[@placeholder='Search course...']");
	By cboxFillResult = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Clear all matched'])[10]/following::label[1]");
	By cboxDeleteCourse = By.xpath("//input[@type='checkbox']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	
	
	public boolean areLinkCourseNamesClickable()
	{
		sleep(5);
		boolean flag = false;
		try {
			if (driver.findElements(linkCourseNames).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void searchCourse(String nameOfCourse)
	{
		clickByJavaScript(drpCourse);
		goTextOnNoEnter(txtSearchCourse, nameOfCourse);
		sleep(3);

	}
	
	public void deleteCourse(String nameOfCourse)
	{
		clickByJavaScript(cboxDeleteCourse);
		clickByJavaScript(iconDelete);
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);

	}
	

	public boolean isMsgCreatedSucessDisplayed ()
	{
		sleep(3);
		boolean flag = false;
		try {
			if (driver.findElement(msgCreatedSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
		
	}
	
	public boolean isMsgDeletedSucessDisplayed ()
	{
		sleep(3);
		boolean flag = false;
		try {
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
		
	}
	
	public void clickFistLinkCourseName()
	{
		sleep(3);
		if (driver.findElements(linkCourseNames).size()>0)
		{
			
		   clickOnElement(driver.findElements(linkCourseNames).get(0));
		}
		else
		{
			TestLogger.info("Can't find link of Course Names");
		}
		
		sleep(3);
		
	}
	
	
	
	public boolean isIcoDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(iconDelete).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public boolean isbtnCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCreate).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAssignDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnAssign).size() >0 ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	public void clickButtonCreate()
	{
		clickByJavaScript(btnCreate);
	}
	
	
	
	
	

}
