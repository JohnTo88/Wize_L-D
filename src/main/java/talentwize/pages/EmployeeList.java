package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Ulties.TestLogger;
import controller.WebActions;

public class EmployeeList extends WebActions {

	By btnImportData = By.xpath("//a[contains(.,'Import data')]");
	By btnCreateEmployee = By.xpath("//button[contains(@ng-click,'openEmployeeModel()')]");
	By btnIconDelete = By.xpath("(//i[@class='icon icon-bin'])[2]");
	By linkDetailOfEmployee = By.xpath("(//span[@class='ng-binding ng-scope'])");
	By linksOfUnitName = By.xpath("(//span[@ui-sref='app.pijh({id: employee.id})'])[1]");
	By linksOfSiteName = By.xpath("(//span[contains(@ng-click,'index, employee)')])[1]");
	By itemEmployee = By.xpath("(//span[@class='ng-binding ng-scope'])[4]");
	By employeeNguyenVietNam = By.xpath("(//span[@class='ng-binding ng-scope'])[4]");
	By itemEmployeeNVN = By.xpath("(//span[@class='ng-binding ng-scope'])[4]");
	By txtSearchEmployees = By.xpath("(//input[@placeholder='Search employees...'])[1]");
	By cboxDeleteEmployee = By.xpath("//label[@class='i-checkbox']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By employeeCuongAutomation = By.xpath("(//span[contains(.,'Cuong Automation')])[5]");
	
	By msgCreateSuccess = By.xpath("//div[@class='jq-toast-single jq-custom-icon jq-custom-icon-success']");
	By msgDeleteSuccess = By.xpath("//span[contains(.,'Deleted successfully')]"); 
	By filterEmploymentStatus = By.xpath("(//i[@class='icon icon-arrow-down4'])[8]");
	By optionClearStatus = By.xpath("//a[contains(.,'Clear selected item')]");
	By optionTerminated = By.xpath("//label[contains(.,'Terminated')]") ;
	
	public static String NAME_OF_USER = "Nguyen Viet Nam ";
     
	public EmployeeList(WebDriver _driver) {
		super(_driver);

	}
	
	public void clickEmployeeCuongAutomation()
	{
		try {
			waitForElementPresent(5, employeeCuongAutomation);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickByJavaScript(employeeCuongAutomation);
	}

	
	public boolean isBtnImportDataDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnImportData).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isMsgCreateSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgCreateSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isEmployeeStatusTerminatedDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(optionTerminated).size()>0 )
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteSuccessDisplayed() {
		boolean flag = false;
		waitForElementClickable(20, msgDeleteSuccess);
		try {
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void deleteEmployee(String nameOfEmployee)
	{
		searchEmployees(nameOfEmployee);
		sleep(4);
		clickByJavaScript(cboxDeleteEmployee);
		clickByJavaScript(btnIconDelete);
		clickByJavaScript(btnYes);
	}
	

	
	public void clickBtnCreate()
	{
		clickByJavaScript(btnCreateEmployee);
	}
	
	public void clickFilterEmployeeStatus()
	{
		clickByJavaScript(filterEmploymentStatus);
		if (isElementPresent(optionClearStatus)==true)
		{
		clickByJavaScript(optionClearStatus);
		}
	}
	
	public void clickChooseTerminate()
	{
		clickByJavaScript(optionTerminated);
	}
	

	public void searchEmployees(String nameOfEmployee) {
		waitForElementClickable(10, txtSearchEmployees);
		goTextOn(txtSearchEmployees, nameOfEmployee);
		sleep(5);
	}

	public void clickItemEmployee() {
		waitForElementClickable(10, itemEmployee);
		clickByJavaScript(itemEmployee);
		sleep(5);
	}

	public void clickEmployeeNguyenVietNam() {
		waitForElementClickable(10, employeeNguyenVietNam);
		clickByJavaScript(employeeNguyenVietNam);
		sleep(5);
	}

	public void clickItemEmployeeNVN() {
		waitForElementClickable(10, itemEmployeeNVN);
		clickByJavaScript(itemEmployeeNVN);
		sleep(4);
	}

	public boolean isBtnCreateEmployeeDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnCreateEmployee).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isBtnIconDeleteDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnIconDelete).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isLinkDetailOfEmployeeClickable() {
		boolean flag = false;
		try {

			if (driver.findElements(linkDetailOfEmployee).size() > 0) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}

		return flag;

	}

	public boolean isLinkslOfUnitNameClickable() {
		boolean flag = false;
		try {

			if (driver.findElements(linksOfUnitName).size() > 0) {

				flag = true;
				TestLogger.info("PASSED");
			}

		} catch (Exception e) {
			flag = false;
		}

		return flag;

	}

	public boolean isLinkslOfSiteNameClickable() {
		boolean flag = false;
		try {

			if (driver.findElements(linksOfSiteName).size() > 0) {
               for (WebElement e : driver.findElements(linksOfSiteName))
            	   if (isClickable(e))
				   flag = true;
            	   else
            	   flag =false;
			}

		} catch (Exception e) {
			flag = false;
		}

		return flag;

	}

}
