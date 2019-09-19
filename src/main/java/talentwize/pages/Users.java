package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Users extends WebActions {

	By txtSearchUserName = By.xpath("//input[@ng-model='condition.keyword']");
	By iconSearch = By.xpath("//i[@class='icon icon-search3']");
	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By roleUser = By.xpath(".//a[@class='ui-select-match-close select2-search-choice-close'][@tabindex='-1']");
	By roles = By.xpath(".//li[@class='select2-search-field']/input[@placeholder='Select roles...']");
	By selectRoles = By.xpath("//input[@placeholder='Select roles...']");
	By btnSaveRole = By.xpath(".//button[@ng-click='saveUserInfo(currentEditRow)']");
	By btnExport = By.xpath("//button[@ng-click='exportUser()']");
	By buttonCreate = By.xpath(".//button[@ng-click='openUserModel()']");
	By ErrorMessage2 = By
			.xpath("//span[@class='message-content' and text()='You do not have permission to edit user info.']");
	By ErrorMessage1 = By.xpath("//span[@class='message-content']");

	By buttonDelete = By.xpath(".//*[@id='user-list-tbl']//button[@delete-permission='']");

	By messageUpdateSuccess = By.xpath("//div/span[@class='message-content'][text()='Updated successful!']");

	public Users(WebDriver driver) {
		super(driver);

	}

	public void searchUsername(String username) {
		sleep(5);
		waitForPageLoaded();
		waitForElementClickable(10, txtSearchUserName);
		typeText(txtSearchUserName, username);
		sleep(1);
		clickByJavaScript(iconSearch);
		sleep(3);
	}

	public void clickOnlinkUserName(String username) {
		clickByJavaScript(By.xpath(".//*[@id='user-list-tbl']//span[contains(text(),'" + username + "')]"));
	}

	public boolean checkLinkUsernameAvaiable(String username) throws InterruptedException {
		sleep(5);
		try {
			if (driver.findElement(By.xpath(".//*[@id='user-list-tbl']//span[contains(text(),'" + username + "')]")).isDisplayed()==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			
		
			return false;
		}

	}

	public void assignUserWithNewRole(String username, String newRole) {
		clickByJavaScript(By.xpath(".//*[@id='user-list-tbl']//span[contains(text(),'" + username + "')]"));
		waitForElementClickable(10, btnEdit);
		clickByJavaScript(btnEdit);
		try {
			waitForElementPresent(10, roleUser);
			clickByJavaScript(roleUser);
			sleep(2);
			clickByJavaScript(roles);
			goTextOn(selectRoles, newRole);
			sleep(5);
			clickByJavaScript(btnSaveRole);
            sleep(5);
		} catch (InterruptedException e) {

			
		}

	}

	public void clickButtonEdit() {
		waitForElementClickable(10, btnEdit);
		clickByJavaScript(btnEdit);
	}

	public void clickButtonSaveRole() {
		clickByJavaScript(btnSaveRole);
	}

	public boolean isSeachUsernameDisplayed() {
		try {
			if ( driver.findElement(txtSearchUserName).isDisplayed()==true)
				return true;
			else
				return false;
		} catch (Exception e) {

			
			return false;
		}

	}

	public boolean isIconDeleteDisplayed() {
		try {
			if (driver.findElement(buttonDelete).isDisplayed()==true)
				return true;
			else
				return false;
		} catch (Exception e) {

		
			return false;
		}

	}

	public boolean isButtonExportClickable() throws InterruptedException {
		try {
			if (driver.findElement(btnExport).isDisplayed()==true)
				return true;
			else
				return false;
		} catch (Exception e) {

			
			return false;
		}
	}

	public boolean isButtonCreateDisplayed() {
		
		try {
			if (driver.findElement(buttonCreate).isDisplayed()==true)
				return true;
			else
				return false;
		} catch (Exception e) {

			return false;
		}
	}

	public String getMessageError() {
		try {
			if ( driver.findElement(ErrorMessage1).isDisplayed()==true) {
				return driver.findElement(ErrorMessage1).getText();
			} else {
				return "";
			}
		} catch (Exception e) {

			return "";
		}
	}

	public boolean messageUpdateSuccessIsDisplayed() {
		try {
			if (driver.findElement(messageUpdateSuccess).isDisplayed()==true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

			
			return false;
		}
	}

}
