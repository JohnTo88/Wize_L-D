package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ProjectRole extends WebActions {

	By btnAssign = By.xpath("(//button[contains(.,'Assign')])[1]");
	
	public ProjectRole(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void clickButtonAssign()
	{
		clickByJavaScript(btnAssign);
	}
	
	public boolean isbtnAssignDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElements(btnAssign).size()> 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
