package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateCourse extends WebActions
{

	public Form_CreateCourse(WebDriver _driver) {
		super(_driver);
	}

	By txtCourseName = By.xpath("(//input[@type='text'])[4]");
	By icoStartDate = By.xpath("(//i[@class='icon icon-calendar2'])[1]");
	By icoEndDate = By.xpath("(//i[@class='icon icon-calendar2'])[2]");
	By btnToday = By.xpath("//button[contains(.,'Today')]");
	By lblCreateCourse = By.xpath("//h4[contains(.,'Create Course')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public void createCoure(String CourseName) {
		waitForElementClickable(10, txtCourseName);
		goTextOnNoEnter(txtCourseName, CourseName);
		sleep(0.5);
		clickByJavaScript(icoStartDate);
		sleep(0.5);
		clickByJavaScript(btnToday);
		sleep(0.5);
		clickByJavaScript(icoEndDate);
		sleep(0.5);
		clickByJavaScript(btnToday);
		sleep(0.5);
		clickByJavaScript(btnSave);
		sleep(2);
	}
	
	public boolean isLblCreateCourseDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblCreateCourse).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
