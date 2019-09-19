package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Assets extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By linksOfSerialNumber = By.xpath("//span[@ng-click='fn_on_sn($index, item)']");
	By cboxSerialNumber = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Available'])[1]/preceding::input[1]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By textAddedSuccesfull = By.xpath("//span[contains(.,'Added successfully')]");
	By textDeletedSuccessful = By.xpath("//span[contains(.,'Deleted successfully')]");
	By textUpdatedSuccessful = By.xpath("//span[contains(.,'Updated successfully')]");
	
	By btnAssign = By.xpath("(//button[contains(.,'Assign')])[1]");
	By fistLinkOfSerialNumber = By.xpath("(//span[@ng-click='fn_on_sn($index, item)'])[1]");
	
	public Assets(WebDriver _driver) {
		super(_driver);
	}

	public boolean isButtonAddDisplayed() {
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
   
	public void clickOnFistLinkOfSerialNumber()
	{
		waitForElementClickable(10, fistLinkOfSerialNumber);
		clickByJavaScript(fistLinkOfSerialNumber);
		
	
	}
	
	
	public boolean isIconDeleteDisplayed() {
		try {
			if (driver.findElement(iconDelete).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isButtonAssignDisplayed() {
		try {
			if (driver.findElement(btnAssign).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public void clickButtonAdd()
	{
		waitForElementClickable(btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public boolean isLinksOfSerialNumberDisplayed()
	{
			
		try {
			if (driver.findElements(linksOfSerialNumber).size()>0)
				return true;
		} catch (Exception e) {
			 return false;
		}
		return false;
	}
	
	
	public void deleteSerialNumber()
	{
		
		clickByJavaScript(cboxSerialNumber);
	    waitForElementClickable(10, iconDelete);
	    clickByJavaScript(iconDelete);
		clickByJavaScript(btnYes);
		
	}
	
	public boolean isTextDeletedSuccessfulDisplayed()
	{
			
		try {
			if (driver.findElement(textDeletedSuccessful).isDisplayed()==true)
				return true;
		} catch (Exception e) {
			 return false;
		}
		return false;
	}
	
	public boolean isTextAddedSuccesfullDisplayed()
	{
			
		try {
			if (driver.findElement(textAddedSuccesfull).isDisplayed()==true)
				return true;
		} catch (Exception e) {
			 return false;
		}
		return false;
	}
	
	public boolean isTextUpdatedSuccesfullDisplayed()
	{
			
		try {
			if (driver.findElement(textUpdatedSuccessful).isDisplayed()==true)
				return true;
		} catch (Exception e) {
			 return false;
		}
		return false;
	}
	

}
