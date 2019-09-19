package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TimeSheetBoard extends WebActions {

	public TimeSheetBoard(WebDriver _driver) {
		super(_driver);
		
	}
	
	By btnSettings = By.xpath("//a[@ui-sref='app.timesheet-board-setting.task']");
	
	public void clickBtnSettings()
	{
		clickByJavaScript(btnSettings);
	}

}
