package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Documents extends WebActions {

	public Documents(WebDriver _driver) {
		super(_driver);
		
	}
	
	By btnAdd = By.xpath("//button[contains(.,'Add')]"); 
	By msgAddSuccess = By.xpath("//span[contains(.,'Create announcement successfully!')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By linkDocumentName = By.xpath("(//span[contains(@ng-click,'index)')])[1]");
	By cboxDelete = By.xpath("//input[contains(@type,'checkbox')]");
	By btnYesDelete = By.xpath("//button[contains(.,'Yes')]");
	
	By msgDeleteSuccess = By.xpath("//span[contains(.,'Deleted successfully')]");
	By msgUpdateSuccess = By.xpath("//span[contains(.,'Update announcement successfully!')]");
	
	
	public void clickBtnAdd()
	{
		clickByJavaScript(btnAdd);
	}
	
	public boolean isMsgAddSuccessDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(msgAddSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public boolean isBtnAddDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public boolean isMsgDeletedDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(msgDeleteSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public boolean isMsgUpdatedDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(msgUpdateSuccess).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public boolean isIConDeleteDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(icoDelete).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public boolean isLinkDocumentNameDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(linkDocumentName).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public void deleteDocument()
	{
		clickByJavaScript(cboxDelete);
		clickByJavaScript(icoDelete);
		clickByJavaScript(btnYesDelete);
	}
	
	public void clickFistLinkDocument()
	{
		clickByJavaScript(linkDocumentName);
	}
	
	

}
