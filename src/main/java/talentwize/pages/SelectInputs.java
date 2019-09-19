package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class SelectInputs extends WebActions {

	By OptionRow1_SelectInputs_List = By.xpath("(//div[@class='col-md-12 ng-binding'])[1]");
	By btnAddNewOption = By.xpath("//button[contains(.,'Add New Option')]");
	By iconDelete = By.xpath("(//i[@class='icon icon-bin'])[1]");
	
	public SelectInputs(WebDriver _driver) {
		super(_driver);
		
	}
	
	
	public void clickOpTion_SelectInputsList_Row1()
	{
		waitForElementClickable(10, OptionRow1_SelectInputs_List);
		clickByJavaScript(OptionRow1_SelectInputs_List);
	}
	
	public boolean isBtnAddNewOptionDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAddNewOption).isDisplayed()==true)
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
