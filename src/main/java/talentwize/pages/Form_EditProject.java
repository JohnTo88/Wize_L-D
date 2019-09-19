package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditProject extends WebActions {

	By drplistProjectLeader = By.xpath("//div[contains(@ng-bind-html,'select.selected.nameCombobox')]");
	By btnUpdate = By.xpath("//button[contains(.,'Update')]");
	By txtSearchProjectLeader = By.xpath("(//input[@placeholder='Search...'])[6]");
	By nameOfLeader = By.xpath("//div[@ng-bind-html='obj.nameCombobox']");
	
	public Form_EditProject(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void chooseProjectLeader(String nameOfUser) throws InterruptedException
	{
		waitForElementClickable(6,btnUpdate);
		clickByJavaScript(drplistProjectLeader);
		waitForElementClickable(txtSearchProjectLeader);
		// ok 
		goTextOnNoEnter(txtSearchProjectLeader, nameOfUser);
		sleep(2);
		waitForElementVisible(10, nameOfLeader);
		clickByJavaScript(nameOfLeader);
		sleep(2);
		clickByJavaScript(btnUpdate);
	}

	public void UpdateProject()
	{
		clickByJavaScript(btnUpdate);
	}
	

}
