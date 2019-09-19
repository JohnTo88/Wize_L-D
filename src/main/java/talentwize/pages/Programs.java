package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Programs extends WebActions
{

	public Programs(WebDriver _driver) {
		super(_driver);
	}
	
	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By btnAssign = By.xpath("(//button[contains(.,'Assign')])[1]");
	By linkEdit = By.xpath("(//span[contains(@ng-click,'viewTrainingProgram(program)')])[1]");

	By filterProgram = By.xpath("(//div[@class='selected ellipsis-text ng-binding'])[6]");
	By txtSearchProgram = By.xpath("//input[contains(@placeholder,'Search program...')]");
	
	By icoArrowDown = By.xpath("//span[@class='icon icon-arrow-down3']");
	By optCheckAll = By.xpath("//span[contains(.,'Check All')]");
	By cboxProgram = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Programs'])[2]/following::label[1]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	
	By filterCourse = By.xpath("//div[@class='selected ellipsis-text ng-binding'][contains(.,'Course')]");
    By txtSearchCourse = By.xpath("//input[@placeholder='Search course...']");
    
    By popupComfirm = By.xpath("//h4[contains(.,'Do you want to assign this program?')]");
	By btnLater = By.xpath("//button[contains(.,'Later')]");
	
	By msgUpdateSuccess = By.xpath("//span[@class='message-content'][contains(.,'Program updated successfully!')]");
	By msgDeleteSuccess = By.xpath("//span[@class='message-content'][contains(.,'Delete programs successfully')]");
    By msgAssignSuccess = By.xpath("//span[@class='message-content'][contains(.,'Assign Program successfully!')]");
	
    public void clickBtnCreate()
    {
    	clickByJavaScript(btnCreate);
    }
    
    public void clickLinkEdit()
    {
    	clickByJavaScript(linkEdit);
    	sleep(2);
    }
    
    public void clickBtnAssign()
    {
    	clickByJavaScript(btnAssign);
    }
    
    public void deletePrograms(String Program)
    {
    	waitForElementClickable(5, filterProgram);
    	clickByJavaScript(filterProgram);
    	goTextOnNoEnter(txtSearchProgram, Program);
    	sleep(2);
    	clickByJavaScript(cboxProgram);
    	clickByJavaScript(icoArrowDown);
    	clickByJavaScript(optCheckAll);
    	clickByJavaScript(icoDelete);
    	clickByJavaScript(btnYes);
    }
    
    private void fillTxtSearchCourse(String NameOfCourse)
    {
    	waitForElementClickable(5, txtSearchCourse);
    	goTextOn(txtSearchCourse, NameOfCourse);
    }
    
    public void filterCourse(String NameOfCourse)
    {
    	clickByJavaScript(filterCourse);
    	fillTxtSearchCourse(NameOfCourse);
    }
    
	public boolean isBtnCreateDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnCreate).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnAssignDisplayed() {
		boolean flag = false;
		sleep(4);
		try {
			if (driver.findElement(btnAssign).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLinkEditDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(linkEdit).isDisplayed() == true) {
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
			if (driver.findElements(icoDelete).size()> 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	  public boolean isPopupComfirmDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(popupComfirm).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
		
	  public void clickBtnLater()
	    {
	    	clickByJavaScript(btnLater);
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
	  
	  public boolean isMsgDeleteSuccessDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(msgDeleteSuccess).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
	  
	  public boolean isMsgAssignSuccessDisplayed() {
			boolean flag = false;
			try {
				if (driver.findElement(msgAssignSuccess).isDisplayed() == true) {
					flag = true;
				}
			} catch (Exception e) {
				return flag;
			}
			return flag;
		}
}
