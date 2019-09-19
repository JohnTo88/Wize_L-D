package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TienIch;
import controller.WebActions;

public class Form_CreateNewEmployee extends WebActions {

	By txtFistName = By.xpath("//input[@placeholder='First Name*']");
	By txtMiddleName = By.xpath("//input[@placeholder='Middle Name']");
	By txtLastName = By.xpath("//input[@placeholder='Last Name*']");
	By txtEmployeeID = By.xpath("//input[@name='employeeID']");
	By icoCalendar = By.xpath("(//i[@class='icon icon-calendar'])[1]"); 
	By optionGoToDay = By.xpath("//span[@type='button'][contains(.,'Go to Today')]");
	By uncheckboxCreateLoginAccount = By.xpath("//span[@ng-show='showLoginSession']");
	By btnCreate = By.xpath("//button[@ng-click='ok()']");
	By txtUserName = By.xpath("//input[@name='employeeUserName']"); 
	By radioManuallyCreatePassword = By.xpath("//label[contains(.,'Manually create password')]");
	By txtPassword = By.xpath("//input[@name='password']"); 
	By txtConfirmPassword = By.xpath("//input[@name='confirmPassword']"); 
	
	public static String FIST_NAME ="Nguyen "; 
	public static String LAST_NAME ="VIETHA"+TienIch.taoRandomChu(5); 
	public static String ID_EMPLOYEEE = "TV1"+TienIch.taoRandomSo(4);
	
	String valuePassword = "Test@1234";
	
	public Form_CreateNewEmployee(WebDriver _driver) {
		super(_driver);
		
	}

	public void createNewEmployee(String fistName,String lastName,String iDEmployee)
	{
		
		waitForElementClickable(15,btnCreate );
		goTextOnNoEnter(txtFistName, fistName);
	
		goTextOnNoEnter(txtLastName, lastName);
		
		goTextOnNoEnter(txtEmployeeID, iDEmployee);
		
		clickByJavaScript(icoCalendar);
		
		clickByJavaScript(optionGoToDay);
		
		clickByJavaScript(uncheckboxCreateLoginAccount);
		
		sleep(2);
		
		clickByJavaScript(btnCreate);
		
	}
	
	public void createNewEmployeeWithFullInformation(String fistName,String middleName , String lastName,String iDEmployee,String userName  )
	{
		
		waitForElementClickable(15,btnCreate );
		goTextOnNoEnter(txtFistName, fistName);
		
		goTextOnNoEnter(txtMiddleName, middleName);
		
		goTextOnNoEnter(txtLastName, lastName);
		
		goTextOnNoEnter(txtLastName, lastName);
		
		goTextOnNoEnter(txtEmployeeID, iDEmployee);
		
		goTextOnNoEnter(txtUserName, userName);
		
		clickByJavaScript(radioManuallyCreatePassword);
		
		clickByJavaScript(icoCalendar);
		
		clickByJavaScript(optionGoToDay);
		
		sleep(2);
		
		goTextOnNoEnter(txtPassword, valuePassword);
		goTextOnNoEnter(txtConfirmPassword, valuePassword);
		
		clickByJavaScript(btnCreate);
		
	}
	
	
	
	
	
}
