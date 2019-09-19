package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyAppraisal extends WebActions {

	By dataTable = By.xpath("//a[@class='header-h1'][contains(.,'My Appraisal')]");
	
	public MyAppraisal(WebDriver _driver) 
	{
		super(_driver);	
	}

	public boolean isDataTableDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(dataTable).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
}
