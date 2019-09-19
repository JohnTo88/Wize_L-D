package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Ulties.TestLogger;
import controller.WebActions;

public class Form_CheckIn_Detail extends WebActions {
	
	By lblName = By.xpath("//th[contains(.,'Name')]");
	By txtStrength = By.xpath("(//span[contains(.,'Select Company Value...')])[1]");
	By itemStrength = By.xpath("//label[@id='strength-single-item-6']");
	By txtDevelopmentArea = By.xpath("//span[contains(.,'Select Company Value...')]");
	By itemDevelopmentArea = By.xpath("//label[@id='developmentArea-single-item-6']");
	By txtComment = By.xpath("//textarea[@name='comment']");
	By btnSubmit = By.xpath("//button[contains(.,'Submit')]");
	By msgCMSuccess = By.xpath("//span[contains(.,'Add comment successfully!')]");
			
	public Form_CheckIn_Detail(WebDriver _driver) {
		super(_driver);
	}
	
	public void submitComment(String comment) 
	{
		clickByJavaScript(txtStrength);
		clickByJavaScript(itemStrength);
		waitForElementClickable(5, txtDevelopmentArea);
		clickByJavaScript(txtDevelopmentArea);
		clickByJavaScript(itemDevelopmentArea);	
		clickByJavaScript(txtComment);
		goTextOnNoEnter(txtComment, comment);
		clickByJavaScript(btnSubmit);
	}
	
	public boolean isLblNamesDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(lblName).size()>0)
				flag = true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag; 
	}
	
	public boolean isBtnSubmitDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(btnSubmit).size()>0)
				flag = true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag; 
	}
	
	public boolean isMsgCMSuccessDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElements(msgCMSuccess).size()>0)
				flag = true;
		} catch (Exception e) {
			flag= false;
		}
		
		return flag; 
	}

}
