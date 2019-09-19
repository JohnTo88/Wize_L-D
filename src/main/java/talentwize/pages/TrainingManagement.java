package talentwize.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import controller.WebActions;

public class TrainingManagement extends WebActions
{

	public TrainingManagement(WebDriver _driver) 
	{
		super(_driver);
	}
	
	By btnAssign = By.xpath("(//button[contains(.,'Assign')])[1]");
	By linkCode = By.xpath("(//span[@ng-click='markCourses(program)'])[1]");
	By subTabPopup = By.xpath("//tab-heading[contains(.,'Courses')]");
	
	By cboxCode = By.xpath("(//i[@ng-click='selectProgram(program)'])[1]");
	By txtReason = By.xpath("//textarea[@ng-required='inputComment']");
	By icoCancel = By.xpath("//i[@tooltip-enable='true']");
	By btnYes = By.xpath("//button[@ng-click='ok()']");
	
	By filterStatus = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All'])[11]/following::i[1]");
	By optExpired = By.xpath("//label[contains(.,'Expired')]");
	
	By msgCancelSuccess = By.xpath("//span[@class='message-content'][contains(.,'Program Canceled successfully!')]");
	By msgAssignSuccess = By.xpath("//span[@class='message-content'][contains(.,'Update Assign Program successfully!')]");
	
	public void clickIcoCancel()
	  {
		waitForElementClickable(5, icoCancel);
		clickByJavaScript(icoCancel);
	  }
	
	public void clickLinkCode()
	  {
		waitForElementClickable(5, linkCode);
		clickByJavaScript(linkCode);
		sleep(2);
	  }
	
	public void clickBtnAssign()
	  {
		waitForElementClickable(5, btnAssign);
		clickByJavaScript(btnAssign);
		sleep(2);
	  }
	
	 public void filterStatus()
	    {
	    	waitForElementClickable(5, filterStatus);
	    	clickByJavaScript(filterStatus);
	    	sleep(2);
	    	clickByJavaScript(optExpired);
	    	sleep(2);
	    	//clickByJavaScript(filterStatus);
	    }
	 
	 public void cancelTraining(String Reason)
	    {
	    	waitForElementClickable(5, cboxCode);
	    	clickByJavaScript(cboxCode);
	    	clickByJavaScript(icoCancel);
	    	sleep(2);
	    	goTextOnNoEnter(txtReason, Reason);
	    	clickByJavaScript(btnYes); 	
	    }
	 
	 public boolean isBtnAssignDisplayed() {
			boolean flag = false;
			sleep(4);
			try {
				if (driver.findElement(btnAssign).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
	 
	 public boolean isLinkCodeDisplayed() {
			boolean flag = false;
			sleep(4);
			try {
				if (driver.findElement(linkCode).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
	 
	 public boolean isIcoCancelDisplayed() {
			boolean flag = false;
			sleep(4);
			try {
				if (driver.findElement(icoCancel).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
	 
	 public boolean isMsgCancelSuccessDisplayed() {
			boolean flag = false;
			sleep(4);
			try {
				if (driver.findElement(msgCancelSuccess).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		} 
	 
	 public boolean isMsgAssginSuccessDisplayed() {
			boolean flag = false;
			sleep(4);
			try {
				if (driver.findElement(msgAssignSuccess).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		} 
	 
}
