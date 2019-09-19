package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class OtherContacts extends WebActions {
 
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnAdd_Emergency_Contact= By.xpath("//button[contains(@ng-if,'emergencyPermission.allowCreating')]");
	By btnAdd_Dependents= By.xpath("//button[contains(@ng-if,'dependentPermission.allowCreating')]");
	By lblDateOfBirth = By.xpath("//th[contains(.,'Date of Birth')]");
	By messageUpdateSucces = By.xpath("//span[contains(.,'Updated successfully')]");
	By messageAddedSuccess = By.xpath("//span[contains(.,'Added successfully')]");
	By messageDeletedSuccess = By.xpath("//span[contains(.,'Deleted successfully')]");
	By lblMobilePhoneNumber = By.xpath("//th[contains(.,'Mobile Phone Number')]");
	By linkNameOfContact = By.xpath("//span[@ng-if='emergencyPermission.allowUpdating']");
	By linkNameOfDependents = By.xpath("(//span[@ng-if='dependentPermission.allowUpdating'])");
	By fistLinkNameOfContact = By.xpath("(//span[@ng-if='emergencyPermission.allowUpdating'])[1]");
	By iconDelete = By.xpath("(//i[@class='icon icon-bin'])[1]");
	By checkboxFistLineEmergencyContact= By.xpath("(//input[contains(@ng-model,'index]')])[1]");
	By checkboxFistLineDependent= By.xpath("(//input[@ng-model='selectedDependents[$index]'])[1]");

	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By iconDeleteDependents = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add'])[1]/following::i[2]");
	
	public OtherContacts(WebDriver _driver) {
		super(_driver);
		
	}
	
	public boolean isDateOfBirthDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblDateOfBirth).isDisplayed()==true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickButtonEdit()
	{
		clickByJavaScript(btnEdit);
	}
	
	public void clickOnIconDeleteDependents()
	{
		clickByJavaScript(iconDeleteDependents);
	}
	
	public void clickCheckboxFistLineEmergencyContact()
	{
		clickByJavaScript(checkboxFistLineEmergencyContact);
	}
	
	public void clickCheckboxFistLineDependent()
	{
		clickByJavaScript(checkboxFistLineDependent);
	}
	
	
	public void clickIconDelete()
	{
		clickByJavaScript(iconDelete);
	}
	
	public void clickButtonYes()
	{
		clickByJavaScript(btnYes);
	}
	
	
	
	public void clickButtonSave()
	{
		clickByJavaScript(btnSave);
	}
	
	public void clickBtnAdd_Emergency_Contact()
	{
		clickByJavaScript(btnAdd_Emergency_Contact);
	}
	
	public void clickBtnAdd_Dependents()
	{
		clickByJavaScript(btnAdd_Dependents);
	}
	
	public void clickOnFistLinkNameOfContact()
	{
		waitForElementClickable(fistLinkNameOfContact);
		clickByJavaScript(fistLinkNameOfContact);
	}
	
	
	public boolean islinkNameOfContactDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(linkNameOfContact).size() >0 ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean islinkNameOfDependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(linkNameOfDependents).size() >0 ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isIconDeleteDependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(iconDeleteDependents).isDisplayed() ==true ) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	
	public boolean isLabelMobilePhoneNumberDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblMobilePhoneNumber).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMessageUpdateSuccesDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(messageUpdateSucces).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	

	public boolean isMessageDeleteSuccesDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(messageDeletedSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isMessageAddSuccesDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(messageAddedSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnEditDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEdit).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnbtnAdd_DependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd_Dependents).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnbtnAdd_Emergency_ContactDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd_Emergency_Contact).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	
	
	

}
