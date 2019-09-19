package talentwize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Ulties.TestLogger;
import controller.WebActions;

public class MyAssignedTraining extends WebActions {

	public MyAssignedTraining(WebDriver _driver) {
		super(_driver);
	}

	By lblMyAssigned = By.xpath("(//div[contains(@class,'caption font-bold')])[1]");
	By lblName = By.xpath("(//span[contains(@class,'col-xs-3 col-sm-3 col-md-3 ng-binding')])[1]");
	By linkCourseInfo = By.xpath("(//span[contains(.,'Course')])");
	By lblCourseInformation = By.xpath("//h4[contains(.,'Course Information')]");

	public void clickLblName() {
		waitForElementClickable(5, lblName);
		clickByJavaScript(lblName);
	}
	
	public void clickLinkCourseInfo() {

		List<WebElement> e = driver.findElements(linkCourseInfo);
		if (e.size() > 0) {
			clickOnElement(e.get(0));
		} else {
			TestLogger.info("No Courses avaiable !");
		}
}

	public boolean isLblMyAssignedDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, lblMyAssigned);
			if (driver.findElement(lblMyAssigned).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isLblCourseInformationDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, lblCourseInformation);
			if (driver.findElement(lblCourseInformation).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
