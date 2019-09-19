package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ProjectInfo extends WebActions {

	By btnViewPermission = By.xpath("//button[contains(.,'View Permission')]");
	
	public ProjectInfo(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void clickButtonViewPermission()
	{
		clickByJavaScript(btnViewPermission);
	}
	
	public boolean isBtnViewPermissionDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(btnViewPermission).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	



}
