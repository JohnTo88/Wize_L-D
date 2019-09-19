package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MySuccession extends WebActions {

	By lblSuccessionPlanningStatus = By.xpath("//th[contains(.,'Succession Planning Status')]");
	
	
	public MySuccession(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isLblSuccessionPlanningStatusDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblSuccessionPlanningStatus).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	

}
