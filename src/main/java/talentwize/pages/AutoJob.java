package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import controller.WebActions;

public class AutoJob extends WebActions {
  
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	
	public AutoJob(WebDriver driver) {
		super(driver);
		
	}
	
	public boolean isBtnEditDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnEdit).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	

}
