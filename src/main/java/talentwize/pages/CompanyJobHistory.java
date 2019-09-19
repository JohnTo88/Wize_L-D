package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class CompanyJobHistory extends WebActions {
    By btnAddNewPosition = By.xpath("//button[contains(.,'Add New Position')]");
    By btnHelp = By.xpath("(//span[contains(.,'Help')])[3]");
    By btnAddPreviousPosition = By.xpath("//button[contains(.,'Add Previous Position')]");
    By btnAdd = By.xpath("(//button[contains(.,'Add')])[3]");
    By btnTerminate = By.xpath("//button[contains(.,'Terminate')]");
    By btnEditCurrentPosition=By.xpath("//i[@class='icon icon-pencil5']");
    By lblCompanyJobHistory=By.xpath("//h1[contains(.,'Company Job History')]");
    By btnEditNewPosition=By.xpath("(//i[@class='icon icon-pencil5'])[2]");
    By btnDeleteNewPosition1=By.xpath("(//i[@class='icon icon-bin'])[1]");
    By btnDeleteNewPosition=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Current'])[1]/following::i[2]");
    By btnDeletePreviousPosition2=By.xpath("(//i[@class='icon icon-bin'])[2]");
    By btnDeletePreviousPosition=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add Previous Position'])[1]/following::div[3]");
    //By btnDeleteContractType3=By.xpath("(//i[@class='icon icon-bin'])[3]");
    By btnDeleteContractType=By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add'])[1]/following::div[4]");
    By btnEditPreviousPosition=By.xpath("(//button[contains(.,'Edit')])[1]");
    By hplContractType=By.xpath("//a[@ng-click=\"showContractTypeModal(contractType)\"]]");
    By msgUpdateContractType=By.xpath("//span[contains(.,'Update contract type successfully!')]");
    By msgUpdatePreviousPosition=By.xpath("//span[contains(.,'Edit Previous Position successful!')]");
    By msgUpdateCurrrentPosition=By.xpath("//span[contains(.,'Edit Current Position successful!')]");
    By msgUpdateNewPosition=By.xpath("//span[contains(.,'Edit New Position successful!')]");
    
	public CompanyJobHistory(WebDriver _driver) {
		super(_driver);
	}
	public boolean ismsgUpdateNewPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, msgUpdateNewPosition);
			if (driver.findElement(msgUpdateNewPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean ismsgUpdateCurrrentPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, msgUpdateCurrrentPosition);
			if (driver.findElement(msgUpdateCurrrentPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean ismsgUpdatePreviousPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, msgUpdatePreviousPosition);
			if (driver.findElement(msgUpdatePreviousPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean ismsgUpdateContractTypeDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, msgUpdateContractType);
			if (driver.findElement(msgUpdateContractType).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean ishplContractTypeDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, hplContractType);
			if (driver.findElement(hplContractType).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isbtnDeleteNewPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, btnDeleteNewPosition);
			if (driver.findElement(btnDeleteNewPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isbtnDeletePreviousPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, btnDeletePreviousPosition2);
			if (driver.findElement(btnDeletePreviousPosition2).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isbtnEditPreviousPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, btnEditPreviousPosition);
			if (driver.findElement(btnEditPreviousPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean islblCompanyJobHistoryDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, lblCompanyJobHistory);
			if (driver.findElement(lblCompanyJobHistory).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isbtnEditCurrentPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, btnEditCurrentPosition);
			if (driver.findElement(btnEditCurrentPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isbtnEditNewPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, btnEditNewPosition);
			if (driver.findElement(btnEditNewPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isbtnAddNewPositionDisplayed()
	{
		boolean flag= false;
		try {
			waitForElementPresent(3, btnAddNewPosition);
			if (driver.findElement(btnAddNewPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnTerminateDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnTerminate).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnHelpDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnHelp).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	public boolean isbtnAddPreviousPositionDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAddPreviousPosition).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public boolean isbtnAddDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).isDisplayed()==true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void clickhplContractType()
	{
		waitForElementClickable(5, hplContractType);
		clickByJavaScript(hplContractType);
	}
	public void clickbtnEditPreviousPosition()
	{
		waitForElementClickable(3, btnEditPreviousPosition);
		clickByJavaScript(btnEditPreviousPosition);
	}
	public void clickbtnEditCurrentPosition()
	{
		waitForElementClickable(3, btnEditCurrentPosition);
		clickByJavaScript(btnEditCurrentPosition);
	}
	public void clickbtnEditNewPosition()
	{
		waitForElementClickable(3, btnEditNewPosition);
		clickByJavaScript(btnEditNewPosition);
	}
}
