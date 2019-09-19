package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddEmergencyContact extends WebActions {

	By txtName = By.xpath("//input[@name='name']");
	By txtRelationship = By.xpath("//input[@name='relationship']");
	By txtMobilePhoneNumber = By.xpath("//input[@ng-model='mobile']");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	public static String MobilePhoneNumber = "+1 310 281 5539";

	public Form_AddEmergencyContact(WebDriver _driver) {
		super(_driver);

	}

	public void fillName(String _name) {
		waitForElementClickable(10, txtName);
		goTextOn(txtName, _name);
	}

	public void fillRelationship(String _relatetionShip) {
		waitForElementClickable(10, txtRelationship);
		goTextOn(txtRelationship, _relatetionShip);
	}

	public void fillMobilePhoneNumber(String _mobilePhoneNumber) {
		waitForElementClickable(10, txtMobilePhoneNumber);
		clickByJavaScript(txtMobilePhoneNumber);
		goTextOn(txtMobilePhoneNumber, _mobilePhoneNumber);
	}
	
	public void clickBtnSave()
	{
		clickByJavaScript(btnSave);
	}
	
	
	public void addEmergencyContact(String _name,String _relateShip,String _mobilePhone)
	{
		fillName(_name);
		fillRelationship(_relateShip);
		
		fillMobilePhoneNumber(_mobilePhone);
		clickBtnSave();
		
	}
	
	
	
	

}
