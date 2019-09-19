package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CompanyDetails extends WebActions {

	By btnEditGeneralInformation = By.xpath("(//button[contains(.,'Edit')])[1]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	By msgUpdateSuccess = By.xpath("//span[contains(.,'Updated successfully')]");

	By lblClientEmployeeData = By.xpath("(//div[contains(.,'Client Employee Data')])[11]");

	By lblReportTo = By.xpath("(//div[contains(.,'Report To')])[11]");
	By btnEditReportTo = By.xpath("(//button[contains(.,'Edit')])[2]");

	By lblGeneralInformation = By
			.xpath("//div[@class='caption font-bold pull-left'][contains(.,'General Information')]");

	public CompanyDetails(WebDriver _driver) {
		super(_driver);

	}

	public void clickBtnEditGeneralInformation() {
		clickByJavaScript(btnEditGeneralInformation);
	}

	public void clickBtnEditReportTo() {
		clickByJavaScript(btnEditReportTo);
	}

	public void clickBtnSaveGeneralInformation() {
		clickByJavaScript(btnSave);
	}

	
	public boolean isBtnEditGeneralInformationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEditGeneralInformation).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isLblClientEmployeeDataDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblClientEmployeeData).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}


	public boolean isBtnEditReportToDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEditReportTo).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isLblReportToDisplayed() {
		boolean flag = false;
		try {
			sleep(5);
			if (driver.findElement(lblReportTo).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}


	public boolean isMsgUpdateSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgUpdateSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	
	public boolean isLblGeneralInformationDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblGeneralInformation).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

}
