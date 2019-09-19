package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_Appraisal_Information extends WebActions{
	public Form_Appraisal_Information(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	By lblAppraisalInfo = By.xpath("//h4[contains(.,'Appraisal Information')]");
	By subTabAppraisalForm = By.xpath("//a[contains(.,'Appraisal Form')]");
	By btnBackAppraisal = By.xpath("//button[contains(.,'Appraisals')]");
	
	public boolean isLblAppraisalInfoDisplayed() {
		try {
			if (driver.findElement(lblAppraisalInfo).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isSubTabAppraisalFormDisplayed() {
		try {
			if (driver.findElement(subTabAppraisalForm).isDisplayed() == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isButtonEditDisplayed()
		{
			boolean flag = false;
			try {
				if (driver.findElements(btnEdit).size() > 0) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
	
	public void clickBtnBackAppraisal()
	{
		waitForElementClickable(btnBackAppraisal);
		clickByJavaScript(btnBackAppraisal);
	}
	
	public void clickButtonEdit()
	{
		waitForElementClickable(btnEdit);
		clickByJavaScript(btnEdit);
	}
	
	public void clickButtonClose()
	{
		waitForElementClickable(btnClose);
		clickByJavaScript(btnClose);
	}
	
	
	
}
