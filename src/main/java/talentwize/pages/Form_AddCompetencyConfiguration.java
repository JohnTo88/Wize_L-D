package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_AddCompetencyConfiguration extends WebActions {
	
	By txtCompetencyName=By.xpath("//input[@name='name']");
	By chkCompetencyName=By.xpath("(//label[@class='i-checkbox'])[1]");
	By btnNext=By.xpath("//i[@class='icon icon-arrow-right']");
	By btnSave=By.xpath("//button[contains(.,'Save')]");
	
	public Form_AddCompetencyConfiguration(WebDriver _driver) {
		super(_driver);
	}
	
	public void clickChkCompetencyName() {
		waitForElementClickable(5, chkCompetencyName);
		clickByJavaScript(chkCompetencyName);
	}
	public void fillProjectName(String _competencyName) {
		waitForElementClickable(10, txtCompetencyName);
		clickByJavaScript(txtCompetencyName);
		goTextOn(txtCompetencyName, _competencyName);
	}
	public void clickButtonNext() {
		clickByJavaScript(btnNext);
	}
	public void clickButtonSave() {
		clickByJavaScript(btnSave);
	}
	public void addCompetency(String _competencyName) 
	{
		fillProjectName(_competencyName);
		clickChkCompetencyName();
		clickButtonNext();
		clickButtonSave();
	}

}
