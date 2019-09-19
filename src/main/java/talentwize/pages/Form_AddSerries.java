package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddSerries extends WebActions {

	By iconCalendar_serriesStartDate = By.xpath("(//i[contains(@class,'icon icon-calendar2')])[1]");
	By optionGoToToday = By.xpath("//span[contains(.,'Go to Today')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");

	public Form_AddSerries(WebDriver _driver) {
		super(_driver);

	}

	public void addSeries() throws InterruptedException {
		waitForElementClickable(10,btnSave );
		clickByJavaScript(iconCalendar_serriesStartDate);
		waitForElementClickable(10, optionGoToToday);
		clickByJavaScript(optionGoToToday);
		clickByJavaScript(btnSave);
	}
	
	

}
