package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class RequestDetails extends WebActions {
   
	By btnRequestList = By.xpath("//button[contains(.,'Request List')]");
	
	public RequestDetails(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isBtnRequestListDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnRequestList).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
