package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CompetencyBoard extends WebActions {

	By btnSettings = By.xpath("//a[@class='btn btn-sm btn-primary no-shadow ng-scope']"); 
	By linkOfEmployee = By.xpath("(//span[contains(@class,'link-redirect ng-binding')])"); 
	By fistLinkOfEmployee = By.xpath("(//span[contains(@class,'link-redirect ng-binding')])[1]");
	By employeeSearch = By.xpath("//input[@placeholder='Employees Search...']");
	public static String NAME_OF_EMPLOYEE = "Hoang Lam"; 
	
	public CompetencyBoard(WebDriver _driver) {
		super(_driver);
		
	}
	
	
	public void searchEmployee(String nameOfEmployee)
	{
		goTextOn(employeeSearch, nameOfEmployee);
	}
	
	
	
	public boolean isLinkOfEmployeeDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(linkOfEmployee).size() > 0 ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnSettingsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnSettings).isDisplayed() ==true ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickOnFistLinkOfEmployee()
	
	{
		sleep(5);
		clickByJavaScript(fistLinkOfEmployee);
	}
	
	
	
	
	

}
