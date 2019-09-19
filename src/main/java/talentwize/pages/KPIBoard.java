package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class KPIBoard extends WebActions 
{
    
	By btnExport = By.xpath("//a[contains(.,'Export')]");
	By linkOfKPIDetails = By.xpath("(//span[@ng-repeat='score in employee.scores'])");

	By fistLinkOfKPIDetails = By.xpath("//span[contains(.,'—')]");
	By chkDirectReport=By.xpath("(//div[@class='selected ellipsis-text ng-binding'])[1]");
	By hplClearSelectedItem=By.xpath("//a[contains(.,'Clear selected item')]");
	By lblKPIBoard=By.xpath("//h1[contains(.,'KPI Board')]");
	By filterEmployee = By.xpath("(//div[@class='selected ellipsis-text ng-binding'])[14]");
	By optEmployee = By.xpath("//span[contains(.,'Cuong Automation 1')]");
	By txtSearchEmployee = By.xpath("//input[@placeholder='Search employee...']");
	
	By reportTo = By.xpath("//span[contains(.,'Direct Report')]");
	By clearSelectedItem = By.xpath("//a[contains(.,'Clear selected item')]");
	By page2=By.xpath("//a[@ng-click='selectPage(page.number, $event)'][contains(.,'2')]");
	By btnImport = By.xpath("//a[@ng-click='import()']");
	By btnSummitImport = By.xpath("//button[contains(.,'Import')]");
	
	By msgImportSuccess = By.xpath("//span[@class='message-content'][contains(.,'Import Successful')]");
	
	public KPIBoard(WebDriver _driver) {
		super(_driver);
		
	}
	public boolean islblKPIBoardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(lblKPIBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isButtonExportDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnExport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgImportSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgImportSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isButtonImportDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnImport).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isinkOfKPIDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkOfKPIDetails).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickOnfistLinkOfKPIDetails()
	{
		waitForElementClickable(5,fistLinkOfKPIDetails);
		clickByJavaScript(fistLinkOfKPIDetails);
	}
	public void clickchkDirectReport()
	{
		waitForElementClickable(5,chkDirectReport);
		clickByJavaScript(chkDirectReport);
	}
	public void clickhplClearSelectedItem()
	{
		waitForElementClickable(5,hplClearSelectedItem);
		clickByJavaScript(hplClearSelectedItem);
	}
	public void clickpage2()
	{
		waitForElementClickable(5,page2);
		clickByJavaScript(page2);
	}
	
	public void clickBtnImport()
	{
		waitForElementClickable(5,btnImport);
		clickByJavaScript(btnImport);
	}	

	public void selectedItem(String Employee)
	{
		waitForElementClickable(5,chkDirectReport);
		clickByJavaScript(chkDirectReport);
		waitForElementClickable(5,clearSelectedItem);
		clickByJavaScript(clearSelectedItem);
		clickByJavaScript(filterEmployee);
		waitForElementClickable(5, txtSearchEmployee);
		goTextOnNoEnter(txtSearchEmployee, Employee);
		waitForElementClickable(5, optEmployee);
		clickByJavaScript(optEmployee);
	}
	
	public void reportToAll()
	{
		clickByJavaScript(reportTo);
		waitForElementClickable(10, clearSelectedItem);
		clickByJavaScript(clearSelectedItem);
	}
	
	public void clickBtnSummitImport()
	{
		sleep(4);
		waitForElementClickable(5, btnSummitImport);
		clickByJavaScript(btnSummitImport);
	}
}