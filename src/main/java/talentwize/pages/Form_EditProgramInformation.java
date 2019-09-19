package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_EditProgramInformation extends WebActions
{

	public Form_EditProgramInformation(WebDriver _driver) {
		super(_driver);
	}

	By btnEdit = By.xpath("//button[contains(.,'Edit')]");
	By lblProgramName = By.xpath("(//strong[contains(.,'Program Name')])[1]");
	By btnNextStep1 = By.xpath("(//button[contains(.,'Next')])[1]");
	By btnNextStep2 = By.xpath("(//button[contains(.,'Next')])[2]");
	By btnSave = By.xpath("(//button[contains(.,'Save')])[1]");
	By btnClose = By.xpath("//button[contains(.,'Close')]");
	
    public void clickBtnEdit()
    {
    	clickByJavaScript(btnEdit);
    }
    
    public void clickBtnClose()
    {
    	clickByJavaScript(btnClose);
    }
    
    
	public boolean isBtnEditDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnEdit).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isLblPopupDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblProgramName).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	 public void clickBtnNextStep1()
	    {
	    	clickByJavaScript(btnNextStep1);
	    }
	 
	 public void clickBtnNextStep2()
	    {
	    	clickByJavaScript(btnNextStep2);
	    }
	 
	 public void clickBtnSave()
	    {
	    	clickByJavaScript(btnSave);
	    }
	
	public void editProgram()
	{
		clickBtnEdit();
		clickBtnNextStep1();
		clickBtnNextStep2();
		clickBtnSave();
	}
}
