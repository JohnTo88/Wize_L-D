package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Sites extends WebActions {

	By btnCreate = By.xpath("//button[contains(.,'Create')]");
	By iconDelete = By.xpath("//i[contains(@class,'icon icon-bin')]");
    By btnManage = By.xpath("(//button[contains(.,'Manage')])[1]"); 
    
	public Sites(WebDriver driver) {
		super(driver);
	}

	public boolean isIconDeleteDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(iconDelete).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnCreateDisplayed()
	{
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
	
	public boolean isBtnManageDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(btnManage).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickBtnManage ()
	{
		waitForElementClickable(10, btnManage);
		clickByJavaScript(btnManage);
		
	}
	
	public void clickButtonManageSite(String nameOfSite)
	{
		waitForElementClickable(10, btnManage);
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='"+nameOfSite+"'])[1]/following::button[1]")).click();
	}
	
	
	
	

}
