package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class CreateGoal extends WebActions {

	public CreateGoal(WebDriver _driver) {
		super(_driver);

	}

	By txtGoalName = By.xpath("//input[@name='name']");
	By droplistAssignTo = By.xpath("//span[contains(.,'Select Employees...')]");
	By optionReportTo = By.xpath("(//label[@class='i-checkbox ng-scope pull-left '])[1]");
	By txtSpecificObjective = By.xpath("(//div[@contenteditable='true'])[1]");
	By txtMeasurement = By.xpath("(//div[@contenteditable='true'])[2]");
	By droplistCompanyValue = By.xpath("//span[contains(.,'Select Company Value...')]");
	By optionCompanyValue = By.xpath("//label[contains(.,'Knowledge Matters (Pursues Knowledge)')]");
	By iconCalendarStartDate = By.xpath("(//i[@class='icon icon-calendar2'])[1]");
	By iconCalendarEndDate = By.xpath("(//i[@class='icon icon-calendar2'])[2]");
	By optionGoToday = By.xpath("//span[contains(.,'Go to Today')]");
	By messageSuccess = By.xpath("//div[@class='jq-toast-single jq-custom-icon jq-custom-icon-success']");
    By btnSave = By.xpath("//button[contains(.,'Save')]");
    
	public boolean createAGoal() {
		waitForElementClickable(10, txtGoalName);
		goTextOnNoEnter(txtGoalName, TienIch.taoRandomChu(15));
		clickByJavaScript(droplistAssignTo);
		waitForElementClickable(optionReportTo);
		clickByJavaScript(optionReportTo);
		goTextOnNoEnter(txtMeasurement, TienIch.taoRandomChu(10));
		goTextOnNoEnter(txtSpecificObjective, TienIch.taoRandomChu(12));
		clickByJavaScript(droplistCompanyValue);
		waitForElementClickable(10, optionCompanyValue);
		clickByJavaScript(optionCompanyValue);
		clickByJavaScript(iconCalendarStartDate);
		clickByJavaScript(optionGoToday);
		clickByJavaScript(iconCalendarEndDate);
		clickByJavaScript(optionGoToday);
		clickByJavaScript(btnSave);
		
		if (driver.findElement(messageSuccess).getText().contains("successfully")) {
			return true;
		} else {
			return false;
		}

	}

}
