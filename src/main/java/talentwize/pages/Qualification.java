package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Qualification extends WebActions {
    By btnAddWork = By.xpath("(//button[contains(.,'Add')])[1]");
    By btnAddEducation = By.xpath("(//button[contains(.,'Add')])[2]");
    By btnAddLanguage = By.xpath("(//button[contains(.,'Add')])[3]");
    By btnAddLicense = By.xpath("(//button[contains(.,'Add')])[4]");
    By btnDeleteWork=By.xpath("(//div[contains(.,'Check AllUncheck All')])[10]");
    By btnDeleteEducation=By.xpath("(//div[contains(.,'Check AllUncheck All')])[16]");
    By btnDeleteLanguage=By.xpath("(//div[contains(.,'Check AllUncheck All')])[22]");
    By btnDeleteLicense=By.xpath("(//div[contains(.,'Check AllUncheck All')])[28]");
    By linkOfWork = By.xpath("(//span[@class='link-redirect ng-binding'])[1]");
    By linkOfEducation=By.xpath("//span[contains(@ng-click,'editEducation(education, $index)')]");
    By linkOfLanguage=By.xpath("//span[contains(@ng-click,'editLanguage(language, $index)')]");
    By linkOfLicense=By.xpath("//span[contains(@ng-click,'editLicense(license, $index)')]");
    By msgAddedSuccessfully=By.xpath("//span[contains(.,'Added successfully')]");
    By msgUpdateSuccessfully=By.xpath("(//div[contains(.,'Updated successfully')])[2]");
    By msgDeletedSuccessfully=By.xpath("//span[contains(.,'Deleted successfully')]");
    By chkWork=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Comment'])[1]/following::input[1]");
    By btnDelete_Work=By.xpath("(//i[@class='icon icon-bin'])[1]");
    By chkEducation=By.xpath("//input[contains(@ng-model,'selectedEducation[$index]')]");
    By btnDelete_Education=By.xpath("(//i[contains(@class,'icon icon-bin')])[2]");
    By chkLanguage=By.xpath("(//span[contains(@class,'icon icon-arrow-down3')])[3]");
    By chkLanguage_all=By.xpath("//a[contains(@ng-click,'showDropDownCheckAllLanguage = false; checkAllLanguages()')]");
    By btnDelete_Language=By.xpath("(//i[@class='icon icon-bin'])[3]");
    By chkLicense_All= By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add'])[4]/following::span[1]");
    By chkLicense= By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add'])[4]/following::span[2]");
    By btnDelete_License=By.xpath("(//i[@class='icon icon-bin'])[4]");
    By btnYes=By.xpath("//button[contains(.,'Yes')]");
    By btnNo=By.xpath("//button[contains(.,'No')]");
    public boolean isMsgAddedSuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddedSuccessfully).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgUpdateSuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgUpdateSuccessfully).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isMsgDeleteSuccessfullyDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletedSuccessfully).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public Qualification(WebDriver _driver) {
		super(_driver);
	
	}
	
	public boolean isbtnAddWorkDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(10, btnAddWork);
			if (driver.findElement(btnAddWork).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnAddEducationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAddEducation).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnAddLanguageDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAddLanguage).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnAddLicenseDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAddLicense).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnDeleteWorkDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDeleteWork).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnDeleteEducationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDeleteEducation).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnDeleteLanguageDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDeleteLanguage).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnDeleteLicenseDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnDeleteLicense).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isLinkOfWorkDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkOfWork).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isLinkOfEducationDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkOfEducation).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isLinkOfLanguageDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkOfLanguage).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isLinkOfLicenseDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(linkOfLicense).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void clickbtnAddWork() {
		waitForElementClickable(10, btnAddWork);
		clickByJavaScript(btnAddWork);
	}
	public void clickbtnAddEducation() {
		waitForElementClickable(10, btnAddEducation);
		clickByJavaScript(btnAddEducation);
	}
	public void clickbtnAddLanguage() {
		waitForElementClickable(10, btnAddLanguage);
		clickByJavaScript(btnAddLanguage);
	}
	public void clickbtnAddLicense() {
		waitForElementClickable(10, btnAddLicense);
		clickByJavaScript(btnAddLicense);
	}
	public void clickLinkOfWork() {
		waitForElementClickable(10, linkOfWork);
		clickByJavaScript(linkOfWork);
	}
	public void clickLinkOfEducation() {
		waitForElementClickable(10, linkOfEducation);
		clickByJavaScript(linkOfEducation);
	}
	public void clickLinkOfLanguage() {
		waitForElementClickable(10, linkOfLanguage);
		clickByJavaScript(linkOfLanguage);
	}
	public void clickLinkOfLicense() {
		waitForElementClickable(10, linkOfLicense);
		clickByJavaScript(linkOfLicense);
	}
	public void clickChkWork()
	{
		//waitForElementClickable(10, chkWork);
		clickByJavaScript(chkWork);
	}
	public void clickBtnDelete_Work()
	{
		waitForElementClickable(10, btnDelete_Work);
		clickByJavaScript(btnDelete_Work);
	}
	public void clickChkEducation()
	{
		//waitForElementClickable(10, chkEducation);
		clickByJavaScript(chkEducation);
	}
	public void clickBtnDelete_Education()
	{
		waitForElementClickable(10, btnDelete_Education);
		clickByJavaScript(btnDelete_Education);
	}
	public void clickChkLanguage()
	{
		//waitForElementClickable(10, chkLanguage);
		clickByJavaScript(chkLanguage);
		clickByJavaScript(chkLanguage_all);
	}
	public void clickBtnDelete_Language()
	{
		waitForElementClickable(10, btnDelete_Language);
		clickByJavaScript(btnDelete_Language);
	}
	public void clickChkLicense_All()
	{
		waitForElementClickable(10, chkLicense_All);
		clickByJavaScript(chkLicense_All);
	}
	public void clickChkLicense()
	{
		waitForElementClickable(10, chkLicense);
		clickByJavaScript(chkLicense);
	}
	public void clickBtnDelete_License()
	{
		waitForElementClickable(10, btnDelete_License);
		clickByJavaScript(btnDelete_License);
	}
	public void clickBtnYes()
	{
		waitForElementClickable(10, btnYes);
		clickByJavaScript(btnYes);
	}
	public void deletePreviousWorkExperience()
	{
		clickChkWork();
		clickBtnDelete_Work();
		clickBtnYes();
	}
	public void deleteEducation()
	{
		clickChkEducation();
		clickBtnDelete_Education();
		clickBtnYes();
	}
	public void deleteLanguage()
	{
		clickChkLanguage();
		clickBtnDelete_Language();
		clickBtnYes();
	}
	public void deleteLicense()
	{
		scrollToElement(driver.findElement(chkLicense));
		clickChkLicense_All();
		clickChkLicense();
		clickBtnDelete_License();
		clickBtnYes();
	}
}
