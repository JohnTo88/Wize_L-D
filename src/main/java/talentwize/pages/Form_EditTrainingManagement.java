package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditTrainingManagement extends WebActions
{

	public Form_EditTrainingManagement(WebDriver _driver) {
		super(_driver);
	}
	
	By msgMarkedSuccess = By.xpath("//span[@class='message-content'][contains(.,'Courses marked successfully!')]");
	By lblCourse = By.xpath("(//span[@class='marking-course-name ng-binding'])[1]");
	By txtTestScore = By.xpath("//input[@ng-model='trainee.score']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	
	public void clickBtnClose()
	  {
		waitForElementClickable(5, btnClose);
		clickByJavaScript(btnClose);
	  }
	
	public void markScore(String TestScore)
	{
		waitForElementClickable(lblCourse);
		clickByJavaScript(lblCourse);
		sleep(2);
		goTextOnNoEnter(txtTestScore, TestScore);
		clickByJavaScript(btnSave);
	}
	
	  public boolean isLblCourseDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(lblCourse).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
	
	  public boolean isMsgMarkedSuccessDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(msgMarkedSuccess).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
}
