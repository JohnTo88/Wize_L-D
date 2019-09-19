package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class KPIMapping extends WebActions {
    
	By btnAdd = By.xpath("(//button[@ng-click='addMapping()'])[1]");
	By btnKPIBoard=By.xpath("//button[contains(.,'KPI Board')]");
	By tabKPIMapping=By.xpath("//a[contains(.,'KPI Mapping')]");
	By chkUnit=By.xpath("//span[contains(.,'Select unit...')]");
	By chkJobTitle=By.xpath("//span[@ng-hide='$select.isEmpty()'][contains(.,'All')]");
	By chkSearchforMapping=By.xpath("//input[contains(@placeholder,'Search by name')]");
	By txtSearch=By.xpath("//input[contains(@placeholder,'Search by name')]");
	By btnSearch=By.xpath("//i[contains(@class,'icon icon-search3')]");
	By chkSort=By.xpath("//a[@class='select2-choice ui-select-match'][contains(.,'20')]");
	By chkName=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Critsit Manager - English - Microsoft CritSit Team#1 - VNM'])[1]/preceding::input[1]");
	By btnDelete2=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add'])[1]/following::i[1]");
	By btnDelete=By.xpath("(//div[contains(@is-open,'showFilterDropDown')])[1]");
	By btnYes=By.xpath("//button[contains(.,'Yes')]");
	By msgAddKPIMappingSuccessfully=By.xpath("//span[contains(.,'Add Mapping successfully !')]");
	By msgDeleteSuccessfully=By.xpath("//span[contains(.,'Deleted successfully')]");
	By msgUpdateSuccessfully=By.xpath("//span[contains(.,'Update Mapping successfully !')]");
	By btnViewDetail=By.xpath("(//button[contains(.,'View Detail')])[1]");
	By lblKPIHistory=By.xpath("//div[contains(@class,'caption font-bold pull-left m-t-3 ng-binding')]");
	By lblName=By.xpath("(//th[contains(.,'Name')])[1]");
	By btnArrow=By.xpath("(//span[contains(@class,'icon icon-arrow-down3')])[1]");
	By checkAll=By.xpath("(//span[contains(.,'Check All')])[1]");
	By btnDeleteAll=By.xpath("(//i[@class='icon icon-bin'])[1]");
	
	public KPIMapping(WebDriver _driver) {
		super(_driver);
	}
	public void clickbtnDeleteAll()
	{
		clickByJavaScript(btnDeleteAll);
	}
	public void clickcheckAll()
	{
		clickByJavaScript(checkAll);
	}
	public void clickbtnArrow()
	{
		clickByJavaScript(btnArrow);
	}
	public boolean ismsgAddKPIMappingSuccessfullyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(msgAddKPIMappingSuccessfully).isDisplayed()==true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnDeleteDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDelete).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkSortDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkSort).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islblNameDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblName).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islblKPIHistoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblKPIHistory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnViewDetailDisplayed()
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
	public boolean ismsgDeleteSuccessfullyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgDeleteSuccessfully).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ismsgUpdateSuccessfullyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgUpdateSuccessfully).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkSearchforMappingDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkSearchforMapping).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkJobTitleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkJobTitle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ischkUnitDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkUnit).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean istabKPIMappingDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabKPIMapping).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnAddDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnKPIBoardDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnKPIBoard).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public void clickbtnAdd()
	{
		clickByJavaScript(btnAdd);
	}
	public void clickKPIBoard()
	{
		clickByJavaScript(btnKPIBoard);
	}
	public void clicktabKPIMapping()
	{
		clickByJavaScript(tabKPIMapping);
	}
	public void clickchkName()
	{
		clickByJavaScript(chkName);
	}
	public void clickbtnDelete()
	{
		clickByJavaScript(btnDelete);
	}
	public void clickbtnYes()
	{
		clickByJavaScript(btnYes);
	}
	public void clickbtnViewDetail()
	{
		waitForElementClickable(3, btnViewDetail);
		clickByJavaScript(btnViewDetail);
	}

	public void deleteKPIMapping()
	{
		clickchkName();
		clickbtnDelete();
		clickbtnYes();
	}
	public void deleteKPIMappingAll()
	{
		clickbtnArrow();
		clickcheckAll();
		clickbtnDeleteAll();
		clickbtnYes();
	}
	public void searchMappings(String _job)
	{
		goTextOn(txtSearch, _job);
		sleep(2);
		/*sleep(3);
		clickbtnArrow();
		clickcheckAll();
		clickbtnDeleteAll();
		clickbtnYes();
		sleep(5);*/
	}


}
