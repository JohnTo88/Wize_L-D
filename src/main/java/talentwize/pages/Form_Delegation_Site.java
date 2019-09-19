package talentwize.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ulties.TestLogger;
import controller.WebActions;

public class Form_Delegation_Site extends WebActions {

	By dropListFilterUnit = By.xpath("//span[contains(.,'Select unit...')]");
	By btnNumber5 = By.xpath("(//a[@ng-click='selectPage(page.number, $event)'])[5]");
	By bigUnit = By.xpath("(//div[contains(.,'GLB_EX - Executives')])[17]");
	By txtSearchUnit = By.xpath("(//input[@placeholder='Search...'])[2]");
	By unitB_Site4 = By.xpath("(//div[contains(.,'Auto-Unit B - Auto-Site 4')])[17]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	By droplistFilterSite = By.xpath("(//span[contains(.,'All Sites')])[1]");
	By txtSearchSite = By.xpath("(//input[@placeholder='Search...'])[3]");
	By site9 = By.xpath("(//div[contains(.,'Auto-Site 9')])[12]");
	By txtSearchEmployee = By.xpath("//input[@placeholder='Search Employees...']");
	By arrowBigger = By.xpath("//i[@class='icon icon-arrow-right']");
	By arrowSmaller = By.xpath("//i[contains(@class,'icon icon-arrow-left')]");
	By txtSelectedDelegate = By.xpath("//input[contains(@placeholder,'Selected Delegate Search...')]");

	public static String NAME_OF_UNIT = "Auto-Unit B";
	public static String NAME_OF_SITE = "Auto-Site 9";
	public static String NAME_OF_USER = "Nguyen Hoang Nam";
	public static String NAME_OF_USER_DEFAULT = "Nguyen Viet Ha";
	
	public Form_Delegation_Site(WebDriver _driver) {
		super(_driver);

	}

	public void waitForButtonCloseDisplayed() {
		waitForElementClickable(15, btnClose);
	}

	public void openUnitFilter() throws InterruptedException {
		waitForElementPresent(10, dropListFilterUnit);
		clickByJavaScript(dropListFilterUnit);
	}

	public void openSiteFilter() throws InterruptedException {
		waitForElementPresent(10, droplistFilterSite);
		clickByJavaScript(droplistFilterSite);
	}

	public void searchEmployee(String nameOfEmployee) {
		waitForElementClickable(txtSearchEmployee);
		goTextOn(txtSearchEmployee, nameOfEmployee);
		sleep(5); 
		goTextOn(txtSearchEmployee, nameOfEmployee);
		
	}

	public void searchSelectedDelegate(String nameOfDelegate) {
		goTextOn(txtSelectedDelegate, nameOfDelegate);
	}

	public void chooseUserAsManager(String nameOfUser) throws InterruptedException {
		searchEmployee(nameOfUser);
		waitForElementClickable(By.xpath("(//label[@class='i-checkbox'])[1]"));
		
		if (driver.findElement(By.xpath("//span[@class='ellipsis-text ng-binding'][contains(.,'" + nameOfUser + "')]"))
				.isDisplayed() == true) {
			clickByJavaScript(By.xpath("//span[@class='ellipsis-text ng-binding'][contains(.,'" + nameOfUser + "')]"));
			clickByJavaScript(arrowBigger);
			clickByJavaScript(By.xpath(
					"(.//*[normalize-space(text()) and normalize-space(.)='" + nameOfUser + "'])/following::i[1]"));
			sleep(5);
			clickByJavaScript(By.xpath("//button[contains(.,'Save')]"));
			sleep(5);
			if (isElementVisible(By.xpath("//button[contains(.,'Save')]")) == true) {
				clickByJavaScript(By.xpath("//button[contains(.,'Save')]"));
			}
		} else {
			TestLogger.info("Can NOT find User ! ");
			setStatusTest("fail", "Can NOT find User ");
		}

	}

	public void removeUserAsManager(String nameOfUser, String nameOfUserDefault) throws InterruptedException {
		searchSelectedDelegate(nameOfUser);
		if (driver.findElement(By.xpath("//span[@class='ellipsis-text ng-binding'][contains(.,'" + nameOfUser + "')]"))
				.isDisplayed() == true) {
			clickByJavaScript(By.xpath("//span[@class='ellipsis-text ng-binding'][contains(.,'" + nameOfUser + "')]"));
			clickByJavaScript(arrowSmaller);
			goTextOn(txtSelectedDelegate, "");
			
			clickByJavaScript(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+nameOfUserDefault+"'])/following::label[@ng-if='showLeader']"));
			 
			sleep(2);
			clickByJavaScript(By.xpath("//button[contains(.,'Save')]"));
			sleep(2);
			if (isElementVisible(By.xpath("//button[contains(.,'Save')]")) == true) {
				clickByJavaScript(By.xpath("//button[contains(.,'Save')]"));
			}
		} else {
			TestLogger.info("Can NOT find User ! ");
			setStatusTest("fail", "Can NOT find User ");
		}

	}

	public void removeUserAsDelegate(String nameOfUser) {
		searchSelectedDelegate(nameOfUser);
		clickByJavaScript(By.xpath("(//span[contains(.,'" + nameOfUser + "')])"));
		clickByJavaScript(arrowSmaller);
		sleep(1);
		clickByJavaScript(By.xpath("//button[contains(.,'Save')]"));
		sleep(2);
	}

	public void chooseUserDelegate(String nameOfUser) {
		sleep(12);
		searchEmployee(nameOfUser);
		
		new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ellipsis-text ng-binding'][contains(.,'" + nameOfUser + "')]")));
		
		if (driver.findElement(By.xpath("//span[@class='ellipsis-text ng-binding'][contains(.,'" + nameOfUser + "')]"))
				.isDisplayed() == true) {
			clickByJavaScript(By.xpath("//span[@class='ellipsis-text ng-binding'][contains(.,'" + nameOfUser + "')]"));
			clickByJavaScript(arrowBigger);
			clickByJavaScript(By.xpath("//button[contains(.,'Save')]"));
		} else {
			TestLogger.info("Can NOT find User ! ");
			setStatusTest("fail", "Can NOT find User ");
		}

	}

	public boolean isButton5Displayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnNumber5).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {

			flag = false;
		}
		return flag;

	}

	public void close_Form_DelegationSite() {
		clickByJavaScript(btnClose);
	}

	public boolean checkUnitDisplayedWithName(String nameOfUnit) {
		boolean flag = false;
		try {
			openUnitFilter();
			waitForElementClickable(10, txtSearchUnit);
			clickByJavaScript(txtSearchUnit);
			goTextOnNoEnter(txtSearchUnit, nameOfUnit);
			if (driver.findElement(unitB_Site4).isDisplayed() == true) {
				driver.findElement(txtSearchUnit).clear();
				flag = true;
			}

		} catch (Exception e) {
			driver.findElement(txtSearchUnit).clear();
			flag = false;
		}
		return flag;
	}

	public boolean checkSiteDisplayedWithName(String nameOfSite) {
		boolean flag = false;
		try {
			openSiteFilter();
			waitForElementClickable(10, txtSearchSite);
			clickByJavaScript(txtSearchSite);
			goTextOnNoEnter(txtSearchSite, nameOfSite);
			if (driver.findElement(site9).isDisplayed() == true) {
				driver.findElement(txtSearchSite).clear();
				flag = true;
			}

		} catch (Exception e) {
			driver.findElement(txtSearchSite).clear();
			flag = false;
		}
		return flag;
	}
	
	public void waitForFormDelegationDisappear()
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(arrowSmaller));
	}

}
