package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class KPIConfiguration extends WebActions {
    
	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By btnKPIBoard=By.xpath("//button[contains(.,'KPI Board')]");
	By linkOfCategory = By.xpath("(//span[contains(@ng-click,'event, criteria)')])[2]");
	By tabKPISettings=By.xpath("//h1[contains(.,'KPI Settings')]");
	By lblKPIConfiguration=By.xpath("//tab-heading[contains(.,'KPI Configuration')]");
	By tblKPIsList=By.xpath("//div[@class='caption font-bold display-inline'][contains(.,'KPIs List')]");
	By btnDeleteCategory=By.xpath("(//i[contains(@class,'icon icon-bin')])[1]");
	By txtSearch=By.xpath("//input[contains(@ng-model,'condition.configFilter')]");
	By btnSearch=By.xpath("//button[contains(@ng-click,'searchKPIs()')]");
	By lblDefault=By.xpath("//div[@class='col-lg-10 col-md-10 col-xs-10'][contains(.,'Default')]");
	By linkOfKPI=By.xpath("(//label[contains(@ng-click,'index)')])[1]");
	By linkOfKPIConfiguration=By.xpath("(//span[contains(@ng-click,'editCriteria($event, criteria)')])[2]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnDeleteKPI=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Customer Focus'])[1]/following::i[1]");
	By chkCategory=By.xpath("(//span[contains(@ng-click,'editCriteria($event, criteria)')])[2]");
	By checkboxCategory=By.xpath("(//div[contains(@ng-click,'index]')])[1]");
	By msgAddSuccessfully=By.xpath("//span[contains(.,'KPI created successfully!')]");
	By btnYes=By.xpath("//button[contains(.,'Yes')]");
	By msgDeleteKPISuccessfully=By.xpath("//span[contains(.,'Delete KPI successfully!')]");
	By msgUpdateKPISuccessfully=By.xpath("(//div[contains(.,'KPI updated successfully!')])[2]");
	By icoDeleteKPI = By.xpath("(//i[@class='icon icon-bin'])[38]");

	
	public KPIConfiguration(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isBtnSaveDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnSave);
			if (driver.findElement(btnSave).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	public boolean ischkCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(chkCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islinkOfKPIConfigurationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkOfKPIConfiguration).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ismsgUpdateKPISuccessfullyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgUpdateKPISuccessfully).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ismsgDeleteKPIDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgDeleteKPISuccessfully).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean ismsgAddSuccessfullyDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(msgAddSuccessfully).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnDeleteKPIDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteKPI).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islinkOfKPIDisplayed()
	{
		boolean flag = false;
		try {
			sleep(5);
			clicklblDefault();
			if (driver.findElements(linkOfKPI).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islblDefaultDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblDefault).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnSearchDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnSearch).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isTxtSearchDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(txtSearch).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isBtnDeleteCategoryDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean istblKPIsListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tblKPIsList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean istabKPISettingsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabKPISettings).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islblKPIConfigurationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(lblKPIConfiguration).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isinkOfKPIDetailsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkOfCategory).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickOnfistLinkOfKPIDetails()
	{
		clickByJavaScript(linkOfCategory);
	}
	public void clickbtnAdd()
	{
		clickByJavaScript(btnAdd);
	}
	public void clickKPIBoard()
	{
		clickByJavaScript(btnKPIBoard);
	}
	public void clickbtnDeleteCategory()
	{
		clickByJavaScript(btnDeleteCategory);
	}
	public void clickbtnSearch()
	{
		clickByJavaScript(btnSearch);
	}
	public void clicklblDefault()
	{
		clickByJavaScript(lblDefault);
	}
	public void clickLinkOfKPI()
	{
		clicklblDefault();
		clickByJavaScript(linkOfKPI);
	}
	public void clickbtnDeleteKPI()
	{
		clickByJavaScript(btnDeleteKPI);
	}
	public void clickchkCategory()
	{
		sleep(5);
		clickByJavaScript(chkCategory);
	}
	public void clickcheckboxCategory()
	{
		sleep(5);
		clickByJavaScript(checkboxCategory);
	}
	public void clickbtnYes()
	{
		clickByJavaScript(btnYes);
	}
	
	public void clickLinkOfCategory()
	{
		waitForElementClickable(5, linkOfCategory);
		clickByJavaScript(linkOfCategory);
	}
	
	public void deleteKPIConfiguration()
	{
		clicklblDefault();
		clickbtnDeleteKPI();
		clickbtnYes();
	}
	public void deleteCategory()
	{
		clickcheckboxCategory();
		clickbtnDeleteCategory();
		sleep(3);
		clickbtnYes();
	}
	
	public void deleteKPI()
	{
		clicklblDefault();
		clickByJavaScript(icoDeleteKPI);
		clickbtnYes();
	}
		
	public boolean isButtonAddDisplayed()
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
	public boolean isButtonKPIBoardDisplayed()
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
}
