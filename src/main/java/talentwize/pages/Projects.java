package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Projects extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By iconDelete = By.xpath("(//i[contains(@class,'icon icon-bin')])");
	By txtAddedSusscessful = By.xpath("//span[contains(.,'Employee added successfully!')]");
	By btnAction = By.xpath("//button[contains(.,'Action')]");
	By btnEditCurrentAssignment = By.xpath("(//a[contains(text(),'Edit Current Assignment')])[2]");
	By btnAddNewAssignment = By.xpath("//a[contains(.,'Add New Assignment')]");
    By txtUpdateSuccessfull = By.xpath("//span[@class='message-content'][contains(.,'Update project successfully')]");
    By cbox_projectName = By.xpath("//input[contains(@ng-model,'selectRecordModel[$index]')]");
    By btnYes = By.xpath("//button[contains(.,'Yes')]");

    By txtDeletedSuccessfull = By.xpath("//span[contains(.,'Deleted successfully')]");
   
	public Projects(WebDriver _driver) {
		super(_driver);

	}

	public boolean isIconDeletedDispalayed() {

		boolean flag = false;
		try {
			if (driver.findElement(iconDelete).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	


	public boolean isTxtAddedSusscessfulDisplayed() {

		boolean flag = false;
		try {
			if (driver.findElement(txtAddedSusscessful).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	
	public boolean isTxtDeletedSusscessfulDispalayed() {

		boolean flag = false;
		try {
			if (driver.findElement(txtDeletedSuccessfull).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public boolean isTxtUpdatedSusscessfulDispalayed() {

		boolean flag = false;
		try {
			if (driver.findElement(txtUpdateSuccessfull).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public boolean isEditCurrentAssignmentDispalayed() {

		boolean flag = false;
		try {
			if (driver.findElements(btnEditCurrentAssignment).size()>0)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}
	
	public void deleteProjectName()
	{
		clickByJavaScript(cbox_projectName);
		waitForElementClickable(iconDelete);
		clickByJavaScript(iconDelete);
		waitForElementClickable(btnYes);
		clickByJavaScript(btnYes);
		
	}

	public boolean isAddNewAssignmentDispalayed() {

		boolean flag = false;
		try {
			if (driver.findElement(btnAddNewAssignment).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public void clickButtonEditCurrentAssignment() {
		
		clickByJavaScript(btnEditCurrentAssignment);
	}

	public void clickButtonAddNewAssignment() {
		waitForElementClickable(10, btnAddNewAssignment);
		clickByJavaScript(btnAddNewAssignment);
	}

	public boolean isButtonActionDispalayed() {

		boolean flag = false;
		try {
			if (driver.findElement(btnAction).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public boolean isButtonAddDispalayed() {

		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public void clickButtonAdd() {
		waitForElementClickable(btnAdd);
		clickByJavaScript(btnAdd);

	}

	public void clickButtonAction() {
		clickByJavaScript(btnAction);
	}

}
