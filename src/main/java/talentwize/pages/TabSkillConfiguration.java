package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabSkillConfiguration extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By txtSearchSkill = By.xpath("//input[@placeholder='Search skills...']");
	By isLinkOfSkillCategoryClickable = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Default'])[2]/following::span[2]");
	By isLinkOfSkillCategoryClickable2 = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Default'])[1]/following::span[2]");
	By linkOfSkill = By.xpath("(//span[@ng-click='editSkill($event, skill, $index)'])[1]");
	By menuCategoryDefault = By.xpath("//div[@class='col-lg-10 col-md-10 col-xs-10'][contains(.,'Default')]");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By icoDeleteSkill = By.xpath("(//i[contains(@class,'icon icon-bin')])[2]");
	By lblSkillCategories = By.xpath("//div[@class='caption font-bold display-inline'][contains(.,'Skill Categories')]");
	By msgAddSkillSuccess = By.xpath("//span[@class='message-content'][contains(.,'Skill added successfully!')]");
	By msgEditSkillSuccess = By.xpath("//span[contains(.,'Skill updated successfully!')]");
	By msgDeletetSkillSuccess = By.xpath("//span[contains(.,'Delete Skill successfully!')]");
	
	public TabSkillConfiguration(WebDriver _driver) 
	{
		super(_driver);	
	}

	public boolean isBtnAddDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean islblSkillCategoriesDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblSkillCategories).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLinkOfSkillCategoryClickable() 
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfSkillCategoryClickable).size()> 0 )
				flag= true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	
	public boolean isLinkOfskillCategoryClickable() 
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfSkillCategoryClickable2).size()> 0 )
				flag= true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	

	public boolean isIcoDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(icoDelete).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnAdd()
	{
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public boolean isMsgAddSkillSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddSkillSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditSkillSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditSkillSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeleteSkillSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetSkillSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfSkillName()
	{
		waitForElementClickable(5, isLinkOfSkillCategoryClickable);
		clickByJavaScript(isLinkOfSkillCategoryClickable);
	}
	
	public void fillTxtSearchSkill(String NameOfSkill)
	{
		waitForElementClickable(5, txtSearchSkill);
		clickByJavaScript(txtSearchSkill);
		goTextOn(txtSearchSkill, NameOfSkill);
		sleep(2);
	}
	
	public void clickMenuCategoryDefault()
	{
		waitForElementClickable(5, menuCategoryDefault);
		clickByJavaScript(menuCategoryDefault);
	}
	
	public void clickLinkOfSkill()
	{
		waitForElementClickable(5, linkOfSkill);
		clickByJavaScript(linkOfSkill);
	}
	
	public void clickIcoDeleteSkill()
	{
		waitForElementClickable(5, icoDeleteSkill);
		clickByJavaScript(icoDeleteSkill);
	}
	
	public void clickbBtnYes()
	{
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
}
