package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class PersonalDetails extends WebActions {

	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By messageUpdateSuccess = By.xpath("//span[contains(.,'Updated successfully')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By btnAdd_Dependents = By.xpath("(//button[contains(.,'Add')])[2]");
	By btnAdd_EmergencyContact = By.xpath("(//button[contains(.,'Add')])[1]");
	By btnEditAddress = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Address'])[1]/following::button[contains(.,'Edit')]");
	By block_Dependents = By.xpath("//div[@ng-controller='DependentsController']");
	By table_EmergencyContact = By.xpath("(//table[@class='table table-striped m-b-none'])[1]");
	By table_Dependents = By.xpath("(//table[@class='table table-striped m-b-none'])[2]");
	By iconDelete_EmergencyContact = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contact Information'])[1]/following::i[1]");
	By iconDelete_Dependents = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dependents'])[1]/following::i[1]");
	By numberHyperlinkEmergencyContact = By.xpath("//span[@ng-click='editEmergency(emergence, $index)']");
	By fistHyperlinkEmergencyContact = By.xpath("//span[contains(@ng-click,'editDependent(emergence, $index)')][1]");
	By numberHyperlinkDependents = By.xpath("//span[contains(@ng-click,'editDependent(dependent, $index)')]");
	By fistHyperlinkDependents = By.xpath("//span[contains(@ng-click,'editDependent(dependent, $index)')][1]");

	By messageAddSuccessfully = By.xpath("//span[contains(.,'Added successfully')]");
	By messageEditSuccessfully = By.xpath("//span[contains(.,'Updated successfully')]");
	By messageDeleteSuccessfully = By.xpath("//span[contains(.,'Deleted successfully')]");
	By fistCheckBoxDependents = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[3]/following::input[1]");
	By fistCheckBoxEmergencyContact = By
			.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home Phone Number'])[1]/following::input[1]");

	By btnYes = By.xpath("//button[contains(.,'Yes')]");
    By listCountry = By.xpath("//span[@ng-show='$select.isEmpty()'][contains(.,'Select country...')]");
    By fistOptionCountry = By.xpath("(//div[@ng-bind-html='country'])[2]");
    By txtAddressStreet = By.xpath("//input[@name='addressStreet1']");
    By titleAddressStreet = By.xpath("(//span[contains(.,'Address Street 1*')])[1]");
    By txtCity = By.xpath("//input[@name='city']");
    By btnEditContactInformation = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contact Information'])[1]/following::button[contains(.,'Edit')]");
    By lblPersonalEmail = By.xpath("(//span[contains(.,'Personal Email')])");
    By btnEditGeneralInformation = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='General Information'])[1]/following::button[contains(.,'Edit')]");
    By lblGender = By.xpath("//span[@class='control-label'][contains(.,'Gender')]");
    By btnEditReportTo = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Report To'])[1]/following::button[contains(.,'Edit')]");
    By lblEmployeeID = By.xpath("//span[@class='control-label'][contains(.,'Employee ID*')]");
    By lblSecondDirectManager = By.xpath("(//strong[contains(.,'Second Direct Manager')])");
    By lblAssignedProject = By.xpath("//th[contains(.,'Assigned Project')]");
   
	public PersonalDetails(WebDriver _driver) {
		super(_driver);

	}
	
	public boolean isAssignedProjectDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblAssignedProject).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isBtnEditDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEdit).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnEditReportToDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEditReportTo).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean islblSecondDirectManagerDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblSecondDirectManager).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	private void chooseCountry()
	{
		clickByJavaScript(listCountry);
		waitForElementClickable(fistOptionCountry);
		clickByJavaScript(fistOptionCountry);
	}
   
	public void addAddress(String nameOfStreet, String nameOfCity)
	{
		goTextOn(txtAddressStreet, nameOfStreet);
		goTextOn(txtCity, nameOfCity);
		chooseCountry();
		clickButtonSave();
	}
	
	
	public void clickOnFistHyperlinkDependents() {
		clickByJavaScript(fistHyperlinkDependents);
	}

	public void clickOnFistHyperlinkEmergencyContact() {
		clickByJavaScript(fistHyperlinkEmergencyContact);
	}

	public void deleteDependents() {
		clickByJavaScript(fistCheckBoxDependents);
		clickByJavaScript(iconDelete_Dependents);
		clickByJavaScript(btnYes);
	}
	
	public void deleteEmergencyContact() {
		clickByJavaScript(fistCheckBoxEmergencyContact);
		clickByJavaScript(iconDelete_EmergencyContact);
		sleep(1);
		clickByJavaScript(btnYes);
		sleep(1);
	}
	

	public boolean isMessageDeletedSuccessfullyDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(messageDeleteSuccessfully).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLabelPersonalEmailDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(lblPersonalEmail).size() > 0 )
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLabelEmployeeIDDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(lblEmployeeID).size() > 0 )
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isLabelGenderDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(lblGender).size() > 0 )
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isTxtAddressStreetDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(txtAddressStreet).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isButtonEditGeneralInformationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEditGeneralInformation).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isTitleAddressStreetDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(titleAddressStreet).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isMessageAddSuccessfullyDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(messageAddSuccessfully).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isNumberHyperlinkDependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(numberHyperlinkDependents).size() > 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isNumberHyperlinkEmergencyContactDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(numberHyperlinkEmergencyContact).size() > 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isBlockDependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(block_Dependents).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isIconDeleteDependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(iconDelete_Dependents).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isIconDeleteEmergencyContactDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(iconDelete_EmergencyContact).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isTableDependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(table_Dependents).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isTableEmergencyContactDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(table_EmergencyContact).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isBtnAddDependentsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd_Dependents).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isBtnAddEmergencyContactsDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd_EmergencyContact).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	
	public boolean isBtnEditAddressDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEditAddress).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isBtnEditContactInformationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEditContactInformation).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickButtonEditContactInformation() {
		clickByJavaScript(btnEditContactInformation);
	}
	
	public void clickButtonEditReportTo() {
		clickByJavaScript(btnEditReportTo);
	}

	public void clickButtonAddDependents() {
		clickByJavaScript(btnAdd_Dependents);
	}
	
	public void clickButtonEditGenealInformationDependents() {
		clickByJavaScript(btnEditGeneralInformation);
	}

	public void clickButtonAddEmergencyContact() {
		clickByJavaScript(btnAdd_EmergencyContact);
	}

	public boolean isMessageUpdateSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickButtonEditAddress()
	{
		clickByJavaScript(btnEditAddress);
	}

	public void clickButtonEdit() {
		waitForElementClickable(10, btnEdit);
		clickByJavaScript(btnEdit);
	}

	public void clickButtonSave() {
		waitForElementClickable(10, btnSave);
		clickByJavaScript(btnSave);
	}

}
