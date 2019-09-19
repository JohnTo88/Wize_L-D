package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddCertificate extends WebActions
{

	By txtCertificateName = By.xpath("//input[@ng-model='certificate.name']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public Form_AddCertificate(WebDriver _driver) {
		super(_driver);
	}

	public void fillTxtCertificateName(String NameOfCertificate)
	{
		waitForElementClickable(5, txtCertificateName);
		clickByJavaScript(txtCertificateName);
		goTextOn(txtCertificateName, NameOfCertificate);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
	
}
