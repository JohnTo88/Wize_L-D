package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class SeriesSettings extends WebActions {
  
	
	By btnCheckInBoard = By.xpath("(//a[contains(.,'Check-in Board')])[3]");
	By btnAdd = By.xpath("//a[contains(.,'Add')]");
	By iconDelete = By.xpath("//i[@class='icon icon-bin']");
	By serriesListTable = By.xpath("//*[@id='app']//div/table[@ng-init='applyFilter()']");
	By btnEdit = By.xpath("//a[contains(.,'Edit')]");
	By chboxDelete = By.xpath("//*[@id='app']//input[@ng-change='checkItem(setting)']");
	By btnConfirmDetele = By.xpath("//button[@type='button'][contains(.,'Delete')]");
	By messageDeleteSucess = By.xpath("//span[contains(.,'Delete series successfully!')]");
	By messageCreateSuccess = By.xpath("//span[contains(.,'New Check-in Setting has been successfully created!')]");
	
	public SeriesSettings(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void deleteSerrieSettings()
	{
		clickByJavaScript(chboxDelete);
		clickByJavaScript(iconDelete);
		waitForElementClickable(10, btnConfirmDetele);
		clickByJavaScript(btnConfirmDetele);
		
	}
	
	public void clickButtonAdd()
	{
		clickByJavaScript(btnAdd);
	}
	
	
	public boolean isMessageDeleteSuccessDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(messageDeleteSucess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;	
	}
	
	public boolean isMessageCreateSuccessDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(messageCreateSuccess).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;	
	}
	
	
	
	
	public boolean isButtonCheckInBoardDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(btnCheckInBoard).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;
	}
	
	public boolean isButtonEditDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(btnEdit).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;
	}
	
	
	public boolean isButtonDeleteDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(iconDelete).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;
	}
	
	public boolean isSerriesListTableDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(serriesListTable).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;
	}
	
	
	public boolean isButtonAddDisplayed()
	{
		boolean flag = false; 
		try {
			if (driver.findElement(btnAdd).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			
			flag = false;
		}
		
		return flag;
	}
	

}
