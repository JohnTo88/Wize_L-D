package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyED_Skills extends WebActions {


	By lblMySkills = By.xpath("//span[contains(.,'My Skills')]");
	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By btnRequestApproval = By.xpath("//button[contains(.,'Request Approval')]");
	By isLinkOfSkillClickable = By.xpath("(//span[contains(@ng-click,'editMySkill(skill)')])[1]");
	
	By tabPersonalSkills = By.xpath("//a[contains(.,'Personal Skills')]");
	By personalSkillName = By.xpath("(//label[@class='ng-binding'])[2]");
	By firstLevel = By.xpath("(//span[@ng-model='personalSkill.level'])[8]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By msgCreateSkillSuccess = By.xpath("//span[contains(.,'Skills updated successfully')]");
	
	By cboxDelete = By.xpath("(//label[contains(@class,'i-checkbox m-b-0')])[1]");		
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By msgDeleteSkillSuccess = By.xpath("//span[contains(.,'Delete skill successfully!')]");
	
	
	public MyED_Skills(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isLblMySkillsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblMySkills).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
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
	
	public boolean isBtnRequestApprovalDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnRequestApproval).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLinkOfSkillClickable()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfSkillClickable).size()> 0)
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
	
	// ================================ //
	
	private void clickBtnAdd()
	{
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	private void clickTabPersonalSkills()
	{
		waitForElementClickable(5, tabPersonalSkills);
		clickByJavaScript(tabPersonalSkills);
	}
	
	private void hoverPersonalSkillName()
	{
		mouveOverElement(driver.findElement(personalSkillName));
	}
	
	private void clickFirstLevel()
	{
		waitForElementClickable(5, firstLevel);
		clickByJavaScript(firstLevel);
	}
	
	private void clickBtnSave()
	{
		waitForElementClickable(5, btnSave);
		clickByJavaScript(btnSave);
	}
	
	public boolean isMsgCreateSkillSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgCreateSkillSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void createSkill (String skillName) {
		clickBtnAdd();
		clickTabPersonalSkills();
		sleep(3);
		hoverPersonalSkillName();
		clickFirstLevel();
		clickBtnSave();
	}
	
	// ================================ //
	
	private void clickLinkOfSkill()
	{
		waitForElementClickable(5, isLinkOfSkillClickable);
		clickByJavaScript(isLinkOfSkillClickable);
	}
	
	public boolean isMsgUpdateSkillSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgCreateSkillSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void updateSkill() {
		clickLinkOfSkill();
		clickBtnSave();
	}
	
	// ================================ //
	
	private void clickCboxDelete()
	{
		waitForElementClickable(5, cboxDelete);
		clickByJavaScript(cboxDelete);
	}
	
	private void clickIcoDelete()
	{
		waitForElementClickable(5, icoDelete);
		clickByJavaScript(icoDelete);
	}
	
	private void clickbBtnYes()
	{
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
	
	public boolean isMsgDeleteSkillSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgDeleteSkillSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void deleteSkill() {
		clickCboxDelete();
		clickIcoDelete();
		clickbBtnYes();
	}

}
