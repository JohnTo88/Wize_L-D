package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class RuleConfiguration extends WebActions {
    
	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By btnKPIBoard=By.xpath("//button[contains(.,'KPI Board')]");
	By tabRuleConfiguration=By.xpath("//a[contains(.,'Rule Configuration')]");
	By txtSearch=By.xpath("//input[contains(@placeholder,'Codes Search...')]");
	By btnSearch=By.xpath("//button[contains(@ng-click,'reloadRuleList()')]");
	By linkOfRule = By.xpath("//span[contains(@ng-click,'code($index, item)')]");
	By tblRuleList=By.xpath("//div[@class='caption font-bold pull-left m-t-3'][contains(.,'Rule List')]");
	By chkRule=By.xpath("(//span[contains(@ng-click,'code($index, item)')])[1]");
	By btnDeleteRule=By.xpath("//i[contains(@class,'icon icon-bin')]");
	By storeItem=By.xpath("//span[@ng-hide='$select.isEmpty()'][contains(.,'20')]");
	By msgAddSuccessfully=By.xpath("(//div[contains(.,'Add new rule successfully!')])[2]");
	By btnYes=By.xpath("//button[contains(.,'Yes')]");
	By msgDeleteSuccessfully=By.xpath("//span[contains(.,'Deleted successfully')]");
	By msgUpdateSuccessfully=By.xpath("//span[contains(.,'Rule updated successfully!')]");
	By checkboxRule=By.xpath("(//label[contains(@ng-click,'index)')])[1]");
	public RuleConfiguration(WebDriver _driver) {
		super(_driver);
		
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
	public boolean isstoreItemDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(storeItem).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean istabRuleConfigurationDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabRuleConfiguration).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean isbtnDeleteRuleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(btnDeleteRule).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	public boolean islinkOfRuleisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(linkOfRule).size() > 0) {
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
	public boolean isttxtSearchDisplayed()
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
	public boolean istblRuleListDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tblRuleList).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
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
			waitForElementPresent(5, btnKPIBoard);
			if (driver.findElement(btnKPIBoard).isDisplayed() == true) {
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
			if (driver.findElements(linkOfRule).size() > 0) {
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
	public void clickbtnDeleteRule() throws InterruptedException
	{
		waitForElementVisible(5, btnDeleteRule);
		clickByJavaScript(btnDeleteRule);
	}
	public void clickbtnSearch()
	{
		clickByJavaScript(btnSearch);
	}
	public void clickbtnYes() throws InterruptedException
	{
		waitForElementVisible(5, btnYes);
		clickByJavaScript(btnYes);
	}
	public void clickLinkOfRule()
	{
		clickByJavaScript(linkOfRule);
	}
	public void clickchkRule() throws InterruptedException
	{
		waitForElementVisible(10, chkRule);
		clickByJavaScript(chkRule);
	}
	public void clicktabRuleConfiguration()
	{
		waitForElementClickable(5, tabRuleConfiguration);
		clickByJavaScript(tabRuleConfiguration);
		sleep(2);
	}
	public void clickcheckboxRule()
	{
		waitForElementClickable(5, checkboxRule);
		clickByJavaScript(checkboxRule);
	}
	public void deleteRule() throws InterruptedException
	{
		clickcheckboxRule();
		clickbtnDeleteRule();
		sleep(3);
		clickbtnYes();
	}
}
