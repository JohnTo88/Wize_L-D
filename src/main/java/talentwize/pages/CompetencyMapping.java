package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CompetencyMapping extends WebActions {
    By btnAdd = By.xpath("//button[contains(.,'Add')]");
    By chkName=By.xpath("(//span[@ng-click='editCompetenceMapping(mapping, $index)'])[1]");
    By btnDelete=By.xpath("//i[@class='icon icon-bin']");
    By btnYes=By.xpath("//button[contains(.,'Yes')]");
    //===============Update===============
    By linkOfName=By.xpath("(//span[contains(@ng-click,'editCompetenceMapping(mapping, $index)')])[1]");
    //==============mapping==============
    By msgAddCompetencyMapping=By.xpath("//span[contains(.,'Add new competence mapping successfully!')]");
    By msgUpdateCompetencyMapping=By.xpath("//span[contains(.,'Competence Mapping updated successfully!')]");
    By msgDeleteCompetencyMapping=By.xpath("//span[contains(.,'Delete competence mapping successfully!')]");
    By tblCompetencyMapping=By.xpath("//th[contains(.,'Name')]");
    By txtSearchforMapping=By.xpath("//input[@placeholder='Search by name, competencies']");
    By checkboxName=By.xpath("(//label[@class='i-checkbox m-b-0'])[1]");
	public void fillSearchforMapping(String _mapping) {
		waitForElementClickable(10, txtSearchforMapping);
		clickByJavaScript(txtSearchforMapping);
		goTextOn(txtSearchforMapping,  _mapping);
		sleep(5);
	}
	public CompetencyMapping(WebDriver _driver) {
		super(_driver);
	}
	public boolean isTblCompetencyMappingDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(tblCompetencyMapping).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgUpdateCompetencyMappingDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgUpdateCompetencyMapping).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgDeleteCompetencyMappingDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeleteCompetencyMapping).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgAddCompetencyMappingDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddCompetencyMapping).isDisplayed()==true)
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
	public void clickButtonYes()
	{
		waitForElementClickable(3, btnYes);
		clickByJavaScript(btnYes);
	}
	public void clickButtonDelete()
	{
		waitForElementClickable(3, btnDelete);
		clickByJavaScript(btnDelete);
	}
	public void clickChkName()
	{
		waitForElementClickable(3, chkName);
		clickByJavaScript(chkName);
	}
	public void clickcheckboxName()
	{
		waitForElementClickable(3, checkboxName);
		clickByJavaScript(checkboxName);
	}
}
