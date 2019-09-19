package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CompetencyConfiguration extends WebActions {
    By btnAdd = By.xpath("//button[contains(.,'Add')]");
    By chkName=By.xpath("(//span[@ng-click='editCompetency(competency, $index)'])[1]");
    By btnDelete=By.xpath("//i[@class='icon icon-bin']");
    By btnYes=By.xpath("//button[contains(.,'Yes')]");
    By tblCompetencySettings=By.xpath("//th[contains(.,'Name')]");
    //=============Configuration==========
    By msgDeleteCompetencyConfiguration=By.xpath("//span[contains(.,'Delete competence mapping successfully!')]");
    By msgUpdateCompetencyConfiguration=By.xpath("//span[contains(.,'Competency updated successfully!')]");
    By msgAddCompetencyConfiguration=By.xpath("//span[contains(.,'Add new competency successfully!')]");
    //===============Update===============
    By linkOfName=By.xpath("(//span[contains(@ng-click,'editCompetency(competency, $index)')])[1]");
    By checkboxName=By.xpath("(//label[@class='i-checkbox m-b-0'])[1]");
    
	public CompetencyConfiguration(WebDriver _driver) {
		super(_driver);
	}
	public boolean isTblCompetencySettingsDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tblCompetencySettings).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgUpdateCompetencyConfigurationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgUpdateCompetencyConfiguration).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgDeleteCompetencyConfigurationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeleteCompetencyConfiguration).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgAddCompetencyConfigurationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddCompetencyConfiguration).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isButtonAddDisplayed()
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
	public boolean isCheckboxNameDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(checkboxName).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isChkNameDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(chkName).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isButtonDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDelete).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void clickButtonAdd()
	{
		waitForElementClickable(3, btnAdd);
		clickByJavaScript(btnAdd);
	}
	public void clickButtonDelete()
	{
		waitForElementClickable(3, btnDelete);
		clickByJavaScript(btnDelete);
	}
	public void clickButtonYes()
	{
		waitForElementClickable(3, btnYes);
		clickByJavaScript(btnYes);
	}
	public void clickChkName()
	{
		waitForElementClickable(3, chkName);
		clickByJavaScript(chkName);
	}
	public void clickCheckboxName()
	{
		waitForElementClickable(3, checkboxName);
		clickByJavaScript(checkboxName);
	}
}
