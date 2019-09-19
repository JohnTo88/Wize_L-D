package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MySchedule extends WebActions {

	By cboxShowBreakTime = By.xpath("//i[contains(.,'Show Break Time')]"); 
	
	public MySchedule(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isCboxShowBreakTimeDispalyed() {
		boolean flag = false;

		try {
			if (driver.findElement(cboxShowBreakTime).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}

}
