package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabModuleMappings extends WebActions {
 
	By role_Row1 = By.xpath("(//div[@class='col-lg-11 col-md-10 co-xs-11'])[1]");
	By Option_ON_OFF = By.xpath("//li[1]/div/div[2]/label");
	
	public TabModuleMappings(WebDriver _driver) {
		super(_driver);
		
	}

	public void clickRole_Row1()
	{
		waitForElementClickable(10, role_Row1);
		clickByJavaScript(role_Row1);
	}
	
	public boolean isOption_ON_OFF_Displayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(Option_ON_OFF).isDisplayed()==true)
				flag= true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag;
	}
	
	
}
