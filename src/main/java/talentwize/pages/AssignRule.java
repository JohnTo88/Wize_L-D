package talentwize.pages;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AssignRule extends WebActions {
    
	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By btnKPIBoard=By.xpath("//button[contains(.,'KPI Board')]");
	By tabAssignRule=By.xpath("//a[contains(.,'Assign Rule')]");
	By chkUnit=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Unit'])[1]/following::span[1]");
	By chooseFirstUnit=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='VNM'])[1]/following::div[2]");
	By chkSite=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All'])[1]/following::b[1]");
	By chooseFirstSite=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All'])[2]/following::div[1]");
	By chkMonth=By.xpath("(//span[@class='select2-chosen'])[2]");
	By chkYear=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select Year...'])[1]/following::span[1]");
	By lblLogList=By.xpath("//div[@class='caption font-bold'][contains(.,'Log List')]");
	By chkLogList=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log List'])[1]/following::span[2]");
	By txtSearch=By.xpath("//input[contains(@placeholder,'Names Search...')]");
	By btnSearch=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log List'])[1]/following::i[1]");
	By chkEmployee=By.xpath("//tr[1]//label[@class='i-checkbox m-b-0 ng-scope']");
	By btnDelete=By.xpath("//i[@class='icon icon-bin']");
	By btnYes=By.xpath("//button[contains(.,'Yes')]");
	By msgDeleteSuccessfully=By.xpath("//span[contains(.,'Deleted successfully')]");
	By msgAddLogSuccessfully=By.xpath("//span[contains(.,'Add Log successfully !')]");
	By lblKPISettings=By.xpath("//h1[contains(.,'KPI Settings')]");
	By lblFirstEmployee = By.xpath("(//span[@ng-if='true'])[1]");

	public AssignRule(WebDriver _driver) {
		super(_driver);
	}
	
	public boolean isLblKPISettingsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblKPISettings).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isbtnDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean istxtSearchDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(txtSearch).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkLogListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkLogList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islblLogListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblLogList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islblKPISettingsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblKPISettings).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ismsgDeleteSuccessfullyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgDeleteSuccessfully).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ismsgAddLogSuccessfullyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgAddLogSuccessfully).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkUnitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkUnit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkSiteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkSite).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkYearDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkYear).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkMonthDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkMonth).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean istabAssignRuleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabAssignRule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnAddDisplayed() 
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				waitForElementClickable(5, btnAdd);
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnKPIBoardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnKPIBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickbtnAdd()
	{
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
	}
	public void clickKPIBoard()
	{
		clickByJavaScript(btnKPIBoard);
	}
	public void clicktabAssignRule()
	{
		waitForElementClickable(5, tabAssignRule);
		clickByJavaScript(tabAssignRule);
	}
	public void clickchkUnit()
	{
		clickByJavaScript(chkUnit);
	}
	public void chooseFirstUnit()
	{
		clickByJavaScript(chooseFirstUnit);
	}
	public void clickchkSite()
	{
		clickByJavaScript(chkSite);
	}
	public void chooseFirstSite()
	{
		clickByJavaScript(chooseFirstSite);
	}
	public void clickbtnYes()
	{
		waitForElementClickable(10, btnYes);
		clickByJavaScript(btnYes);
	}
	public void clickchkEmployee()
	{
		waitForElementClickable(10, chkEmployee);
		clickByJavaScript(chkEmployee);
	}
	public void clickbtnDelete()
	{
		waitForElementClickable(10, btnDelete);
		clickByJavaScript(btnDelete);
	}
	
	public int getMonthCurrent()
	{
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		return month;
	
	}
	
	public void clickchkMonth()
	{
		clickByJavaScript(chkMonth);
	}
	public void clickMonth() throws InterruptedException
	{
	
		clickByJavaScript(By.xpath("(//div[@class='ng-binding ng-scope'])["+getMonthCurrent()+"]"));
	}
	public void chooseMonth() throws InterruptedException {
		clickchkMonth();
		clickMonth();
	}
	public void deleteAssignRule()
	{
		sleep(2);
		clickchkEmployee();
		sleep(1);
		clickbtnDelete();
		sleep(1);
		clickbtnYes();
	}
	

}
