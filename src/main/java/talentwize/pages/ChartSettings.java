package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class ChartSettings extends WebActions {
    
	By tabModuleList = By.xpath("//tab-heading[contains(.,'Module List')]"); 
	By tabModuleMappings = By.xpath("//tab-heading[contains(.,'Module Mappings')]");
	
	public ChartSettings(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void openTabModuleList()
	{
		waitForElementClickable(10, tabModuleList);
		clickByJavaScript(tabModuleList);
	}
	
	public void openTabModuleMappings()
	{
		waitForElementClickable(10, tabModuleMappings);
		clickByJavaScript(tabModuleMappings);
	}
	
	public boolean isTabModuleListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(tabModuleList).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	
	
	public boolean isTabModuleMappingsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(tabModuleMappings).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
}
