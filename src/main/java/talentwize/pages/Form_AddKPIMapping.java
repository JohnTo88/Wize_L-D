package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class Form_AddKPIMapping extends WebActions {
	By drbJobTile=By.xpath("(//span[contains(.,'Select Job Title...')])[2]");
	By first_Job=By.xpath("(//div[@ng-bind-html='jobTitle.name'])[5]");
	By drbUnit=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Unit*'])[1]/following::span[1]");
	By first_Unit_Beta=By.xpath("(//div[@class='unit-node-tree ng-binding ng-scope'][contains(.,'Tek Academy')])[2]");
	By first_Unit_Testing=By.xpath("//label[contains(.,'Tek Academy')]");
	
	By txtEffectiveFrom=By.xpath("//input[@name='startDate']");
	By chkKPI=By.xpath("(//label[@class='i-checkbox'])[1]");
	By btnNext=By.xpath("//i[@class='icon icon-arrow-right']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnCancel = By.xpath("//button[contains(.,'Cancel')]");
	By icoCalendarEffectiveFrom = By.xpath("(//i[contains(@class,'icon icon-calendar2')])[1]");
	By iconCalendarEffectiveTo = By.xpath("(//i[contains(@class,'icon icon-calendar2')])[2]");
	By btnToday = By.xpath("//button[contains(.,'Today')]");
	
	public static String JobTile ="" ;
	
	public Form_AddKPIMapping(WebDriver _driver) {
		super(_driver);
	}
	public void clickdrbJobTile() {
		waitForElementClickable(5, drbJobTile);
		clickByJavaScript(drbJobTile);
	}
	public String clickfirst_Job() {
		clickByJavaScript(By.xpath("(//div[@ng-bind-html='jobTitle.name'])["+TienIch.taoRandomSo(1)+"]"));
		drbJobTile = By.xpath("(//span[@class='select2-chosen'])[3]");
		return driver.findElement(drbJobTile).getText();
	}
	public void clickdrbUnit() {
		waitForElementClickable(5, drbUnit);
		clickByJavaScript(drbUnit);
	}
	public void clickfirst_Unit() {
		if (driver.getCurrentUrl().contains("testing"))
		clickByJavaScript(first_Unit_Testing);
		else
		clickByJavaScript(first_Unit_Beta);
	}
	public void filltxtEffectiveFrom(String _date) {
		waitForElementClickable(10, txtEffectiveFrom);
		clickByJavaScript(txtEffectiveFrom);
		goTextOn(txtEffectiveFrom, _date);
	}

	public void clickchkKPI() {
		clickByJavaScript(chkKPI);
	}

	public void clickbtnNext() {
		clickByJavaScript(btnNext);
	}
	public void clickBtnSave() {
		clickByJavaScript(btnSave);
	}

	public void clickBtnCancel() {
		clickByJavaScript(btnCancel);
	}

	public void addAssignRule() {
		clickdrbJobTile();
		JobTile = clickfirst_Job();
		clickdrbUnit();
		clickfirst_Unit();
		clickByJavaScript(icoCalendarEffectiveFrom);
		clickByJavaScript(btnToday);
		sleep(1);
		clickByJavaScript(iconCalendarEffectiveTo);
		sleep(1);
		clickByJavaScript(btnToday);
		sleep(3);
		clickchkKPI();
		sleep(1);
		clickbtnNext();
		sleep(1);
		clickBtnSave();
	}

}
