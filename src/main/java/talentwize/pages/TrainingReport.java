package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TrainingReport extends WebActions 
{
	public TrainingReport(WebDriver _driver) {
		super(_driver);
	}

	By drplistCategory = By.xpath("(//span[contains(.,'Select Category')])[1]");
	By optCategory = By.xpath("(//div[@ng-bind-html='category.value'])[2]");
	By drplistReportType = By.xpath("(//span[contains(.,'Select Report Type')])[1]");
	By optReportType = By.xpath("(//div[@ng-bind-html='reportType.value'])[2]");
	By btnView = By.xpath("(//button[contains(.,'View')])[1]");
	
	public void openDataTable()
	{
		waitForElementClickable(5, drplistCategory);
		clickByJavaScript(drplistCategory);
		clickByJavaScript(optCategory);
		waitForElementClickable(5, drplistReportType);
		clickByJavaScript(drplistReportType);
		clickByJavaScript(optReportType);
	}
	
	public void clickBtnView()
	{
		waitForElementClickable(5, btnView);
		clickByJavaScript(btnView);
	}
	
	public boolean isBtnViewDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnView).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
