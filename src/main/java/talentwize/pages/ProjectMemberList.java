package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import controller.WebActions;

public class ProjectMemberList extends WebActions {
	public ProjectMemberList(WebDriver _driver) {
		super(_driver);
	}

	By subMenuProjectMemberList = By.xpath("//a[contains(.,'Project Member List')]");
	By btnHelp = By.xpath("//button[@ng-click='showHelp()']");
	By btnAdd = By.xpath("//button[@ng-click='addMember()']");
	By btnEditCurrentAssignment = By.xpath("(//a[contains(.,'Edit Current Assignment')])[2]");
	By btnAddNewAssignment = By.xpath("(//a[contains(.,'Add New Assignment')])[2]");
	By btnAction = By.xpath("(//button[contains(.,'Action')])[2]");
	By txtAddSuccess = By.xpath("//span[contains(.,'Employee added successfully!')]");
	By cboxDelete = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Status'])[2]/following::label[1]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By txtDeleteSuccessful = By.xpath("//span[contains(.,'Employee deleted successfully!')]");
	By txtEditSuccessful = By.xpath("//span[contains(.,'Employee edited successfully!')]");
	By msgEditSuccessful = By.xpath("//span[@class='message-content'][contains(.,'Employee updated successfully!')]");
	By btnImport = By.xpath("//a[contains(.,'Import')]");

	public boolean isSubMenuProjectMemberListDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subMenuProjectMemberList).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isBtnHelpDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnHelp).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isBtnAddDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				flag = true;
			}

		} catch (Exception e) {
			return flag;
		}
		return flag;

	}

	public boolean isBtnImportDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnImport);
			if (driver.findElement(btnImport).isDisplayed() == true) {

				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isIcoDeleteDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(icoDelete).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isBtnEditCurrentAssignmentDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnEditCurrentAssignment);
			if (driver.findElement(btnEditCurrentAssignment).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickBtnEditCurrentAssginment() {
		waitForElementClickable(5, btnEditCurrentAssignment);
		clickByJavaScript(btnEditCurrentAssignment);
	}

	public boolean isBtnAddNewAssignmentDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(btnAddNewAssignment).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isBtnActionDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElements(btnAction).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickBtnAction() throws InterruptedException {
		waitForElementPresent(10, btnAction);
		clickByJavaScript(btnAction);

	}

	public void clickBtnAdd() {
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
	}

	public boolean isTxtAddSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(txtAddSuccess).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public void clickCboxDelete() {
		waitForElementClickable(5, cboxDelete);
		clickByJavaScript(cboxDelete);
	}

	public void clickIcoDelete() {
		waitForElementClickable(5, icoDelete);
		clickByJavaScript(icoDelete);
	}

	public void clickBtnYes() {
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}

	public boolean isTxtDeleteSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(txtDeleteSuccessful).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isTxtEditSuccessDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(txtEditSuccessful).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

	public boolean isMsgEditSuccessfulDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(msgEditSuccessful).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}

}
