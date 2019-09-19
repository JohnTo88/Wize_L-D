package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyTraining extends WebActions{

	public MyTraining(WebDriver _driver) {
		super(_driver);
	}

	By lblMyTraining = By.xpath("//h1[contains(.,'My Training')]");
	By btnCreate = By.xpath("(//button[@type='button'])[1]");
	By linkEdit = By.xpath("(//span[@class='link-redirect ng-binding ng-scope'])[1]");
	By courseName = By.xpath("(//span[@ng-if='!permission || !permission.allowUpdating'])[1]");

	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By icoArrowDelete = By.xpath("//span[@class='icon icon-arrow-down3']");
	By optCheckAll = By.xpath("//span[contains(.,'Check All')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	
	public boolean isLblMyTrainingDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblMyTraining).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isCourseNameDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(courseName).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateDisplayed() {
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
	
	public boolean isLinkEditDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(linkEdit).isDisplayed() == true) {
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
			if (driver.findElement(icoDelete).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnCreate() {
		waitForElementClickable(10, btnCreate);
		clickByJavaScript(btnCreate);
	}
	
	public void clickLinkEdit() {
		waitForElementClickable(10, linkEdit);
		clickByJavaScript(linkEdit);
	}
	
	public void deleteCourse() {
		clickByJavaScript(icoArrowDelete);
		sleep(0.5);
		clickByJavaScript(optCheckAll);
		sleep(0.5);
		clickByJavaScript(icoDelete);
		sleep(0.5);
		clickByJavaScript(btnYes);
		sleep(2);
	}
}
