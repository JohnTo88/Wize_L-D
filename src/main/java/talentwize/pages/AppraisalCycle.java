package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AppraisalCycle extends WebActions{
	public AppraisalCycle(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}

	
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By linksOfEmployee = By.xpath("(//span[contains(@ng-click,'editAppraisal(appraisal)')])[1]");
	By linkOfEmployee_Update=By.xpath("(//span[contains(@ng-click,'editAppraisal(appraisal)')])[6]");
	
	By textAddedSuccesfull = By.xpath("//span[contains(.,'Appraisal created successfully!')]");
	By textDeletedSuccessful = By.xpath("//span[contains(.,'Appraisal deleted successfully!')]");
	By textUpdatedSuccessful = By.xpath("//span[contains(.,'Appraisal updated successfully!')]");
	By tabAppraisalsCycle=By.xpath("//a[contains(.,'Appraisal Cycle')]");
	By tblAppraisalsCycle=By.xpath("//th[@class='name'][contains(.,'Appraisal Cycle')]");
	By chkFirstEmployee=By.xpath("(//label[contains(@class,'i-checkbox m-b-0')])[1]");
	By btnYes2 = By.xpath("//button[contains(.,'Yes')]");
	By btnViewDetail = By.xpath("//button[@href='#/te/appraisal/cycle-detail/4']");
	By subTabViewDetial = By.xpath("//a[contains(.,'View Detail')]");
	By btnBackViewDetail = By.xpath("//button[contains(.,'Appraisal Cycle')]");
	
	By txtSearch = By.xpath("//input[contains(@ng-model,'condition.keyword')]");
	By tabAppCycle = By.xpath("//a[contains(.,'Appraisal Cycle')]");
	By btnCreateNone = By.xpath("//button[@style=\"display: none;\"]");
	By btnCreate = By.xpath("//button[contains(@ng-click,'addCycle()')]");
	By icoDelete = By.xpath("//button[@ng-click='deleteAppraisalCycles()']");
	By btnYes = By.xpath("//button[@ng-click='ok()']");
	By linkEdit = By.xpath("//span[@ng-click='editCycle(cycle)'][contains(.,'Test Automation')]");
	By cboxDelete = By.xpath("(//input[contains(@type,'checkbox')])[1]");

	By msgCreateCycleSuccess = By.xpath("//span[@class='message-content'][contains(.,'Appraisal Cycle created successfully!')]");
	By msgUpdateCycleSuccess = By.xpath("//span[@class='message-content'][contains(.,'Appraisal Cycle updated successfully!')]");
	By msgDeleteCycleSuccess = By.xpath("//span[@class='message-content'][contains(.,'Appraisal cycle deleted successfully!')]");
	
	
	public boolean istabAppraisalsCycleDisplayed() {
		try {
			if (driver.findElement(tabAppraisalsCycle).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	public boolean istblAppraisalsCycleDisplayed() {
		try {
			if (driver.findElement(tblAppraisalsCycle).isDisplayed() == true) {
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



	public void fillTxtSearch(String searchtext)
	{
		waitForElementClickable(5, txtSearch);
		goTextOn(txtSearch, searchtext);
	}
	
	public void clickBtnBackViewDetail()
	{
		waitForElementClickable(5, btnBackViewDetail);
		clickByJavaScript(btnBackViewDetail);
	}
	
	public void clickBtnViewDetail()
	{
		waitForElementClickable(5, btnViewDetail);
		clickByJavaScript(btnViewDetail);
	}
	
	public void clickLinkEdit()
	{
		waitForElementClickable(5, linkEdit);
		clickByJavaScript(linkEdit);
	}
	
	public void clickCboxDelete()
	{
		sleep(5);
		clickByJavaScript(cboxDelete);
	}
	
	public void clickIcoDelete()
	{
		waitForElementClickable(5, icoDelete);
		clickByJavaScript(icoDelete);
	}
	
	public void clickBtnYes()
	{
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
	
	public boolean isMsgCreateCycleSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgCreateCycleSuccess).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgUpdateCycleSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgUpdateCycleSuccess).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMsgDeleteCycleSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgDeleteCycleSuccess).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isSubTabViewDetialDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(subTabViewDetial).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabAppCycleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabAppCycle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIcoDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(icoDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickTabAppCycle()
	{
		waitForElementClickable(5, tabAppCycle);
		clickByJavaScript(tabAppCycle);
	}
	
	public void clickBtnCreate()
	{
		waitForElementClickable(5, btnCreate);
		clickByJavaScript(btnCreate);
	}
	
	public boolean isBtnCreateStyleNoneDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnCreateNone).isEnabled()==true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnViewDetailDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnViewDetail).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnCreate).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void deleteAppraisalCycle(String searchtext)
	{
		fillTxtSearch(searchtext);
		clickCboxDelete();
		clickIcoDelete();
		clickBtnYes();
	}

}