package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabManagementConfiguration extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
    By iconDelete = By.xpath("//i[@class='icon icon-bin']");
    
	public TabManagementConfiguration(WebDriver _driver) {
		super(_driver);

	}
	
	public boolean isBtnAddDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isIconDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(iconDelete).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
