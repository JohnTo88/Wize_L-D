package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Appraisal extends WebActions{
	public Appraisal(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}

	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By linksOfEmployee = By.xpath("(//span[contains(@ng-click,'editAppraisal(appraisal)')])[1]");
	By linkOfEmployee_Update=By.xpath("(//span[contains(@ng-click,'editAppraisal(appraisal)')])[6]");
	By btnViewDetail = By.xpath("(//a[contains(.,'View Detail')])[1]");
	By textAddedSuccesfull = By.xpath("//span[contains(.,'Appraisal created successfully!')]");
	By textDeletedSuccessful = By.xpath("//span[contains(.,'Appraisal deleted successfully!')]");
	By textUpdatedSuccessful = By.xpath("//span[contains(.,'Appraisal updated successfully!')]");
	By tabAppraisals=By.xpath("//a[contains(.,'Appraisals')]");
	By tblAppraisals=By.xpath("//th[contains(.,'Employee')]");
	By chkFirstEmployee=By.xpath("(//label[contains(@class,'i-checkbox m-b-0')])[1]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By btnYes2 = By.xpath("//button[contains(.,'Yes')]");
	public boolean istabAppraisalsDisplayed() {
		try {
			if (driver.findElement(tabAppraisals).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	public boolean istblAppraisalsDisplayed() {
		try {
			if (driver.findElement(tblAppraisals).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	public boolean isButtonCreateDisplayed() {
		try {
			if (driver.findElement(btnCreate).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isButtonViewDetailDisplayed() {
		try {
			if (driver.findElement(btnViewDetail).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
   
	public void clickBtnViewDetail()
	{
		waitForElementClickable(10, btnViewDetail);
		clickByJavaScript(btnViewDetail);
		sleep(5);
	
	}
   
	public void clickOnFistLinkOfEmployee()
	{
		waitForElementClickable(10, linksOfEmployee);
		clickByJavaScript(linksOfEmployee);
		sleep(5);
	}
	
	public void clickOnlinkOfEmployee_Update()
	{
		waitForElementClickable(10, linkOfEmployee_Update);
		clickByJavaScript(linkOfEmployee_Update);
		sleep(5);
	
	}
	
	public void clickButtonYes()
	{
		waitForElementClickable(10, btnYes);
		clickByJavaScript(btnYes);
	
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
	
	
	public void clickButtonCreate()
	{
		waitForElementClickable(btnCreate);
		clickByJavaScript(btnCreate);
	}
	public void clickchkFirstEmployee()
	{
		waitForElementClickable(chkFirstEmployee);
		clickByJavaScript(chkFirstEmployee);
	}
	public void clickiconDelete()
	{
		waitForElementClickable(iconDelete);
		clickByJavaScript(iconDelete);
	}
	public boolean islinksOfEmployeeDisplayed()
	{
			
		try {
			if (driver.findElements(linksOfEmployee).size()>0)
				return true;
		} catch (Exception e) {
			 return false;
		}
		return false;
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
	public boolean ischkFirstEmployeeDisplayed()
	{
			
		try {
			if (driver.findElement(chkFirstEmployee).isDisplayed()==true)
				return true;
		} catch (Exception e) {
			 return false;
		}
		return false;
	}
}
