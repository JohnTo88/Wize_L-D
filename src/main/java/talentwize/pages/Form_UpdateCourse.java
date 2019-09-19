package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_UpdateCourse extends WebActions
{

	public Form_UpdateCourse(WebDriver _driver) {
		super(_driver);
	}

	By lblUpdateCourse = By.xpath("//h4[contains(.,'Update Course')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public void clickBtnSave() {
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
		sleep(2);
	}
	
	public boolean isLblUpdateCourseDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblUpdateCourse).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
