package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class TabCertificateConfiguration extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By icoDelete = By.xpath("//i[@class='icon icon-bin']");
	By isLinkOfCertificateCategoryClickable = By.xpath("(//span[@class='text-break-word ng-binding link-redirect'])");
	By lblCertificateCategories = By.xpath("//div[@class='caption font-bold display-inline'][contains(.,'Certificate Categories')]");
	By menuCategoryDefault = By.xpath("//div[@class='col-lg-10 col-md-10 col-xs-10'][contains(.,'Default')]");
	By txtSearchCertificateCategories = By.xpath("//input[@placeholder='Search certificates...']");
	By btnYes = By.xpath("//button[contains(.,'Yes')]");
	By iconDeleteCertificate = By.xpath("(//i[contains(@class,'icon icon-bin')])[2]");
	By msgAddCertificateSuccess = By.xpath("//span[contains(.,'Certificate added successfully!')]");
	By msgEditCertificateSuccess = By.xpath("//span[contains(.,'Certificate updated successfully!')]");
	By msgDeletetCertificateSuccess = By.xpath("//span[contains(.,'Delete certificate successfully!')]");
	
	public TabCertificateConfiguration(WebDriver _driver) 
	{
		super(_driver);	
	}

	public boolean isBtnAddDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean islblCertificateCategoriesDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(lblCertificateCategories).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isLinkOfCertificateCategoryClickable() 
	{
		boolean flag = false; 
		try {
			if (driver.findElements(isLinkOfCertificateCategoryClickable).size()> 0)
				flag= true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isIcoDeleteDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(icoDelete).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickBtnAdd()
	{
		waitForElementClickable(5, btnAdd);
		clickByJavaScript(btnAdd);
	}
	
	public void clickmenuCategoryDefault()
	{
		waitForElementClickable(5, menuCategoryDefault);
		clickByJavaScript(menuCategoryDefault);
	}
	
	public boolean isMsgAddCertificateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddCertificateSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgEditCertificateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgEditCertificateSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public boolean isMsgDeletetCertificateSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgDeletetCertificateSuccess).isDisplayed() == true)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickLinkOfCertificate()
	{
		waitForElementClickable(5, isLinkOfCertificateCategoryClickable);
		clickByJavaScript(isLinkOfCertificateCategoryClickable);
	}
	
	public void fillTxtSearchCertificate(String NameOfCertificate)
	{
		waitForElementClickable(5, txtSearchCertificateCategories);
		clickByJavaScript(txtSearchCertificateCategories);
		goTextOn(txtSearchCertificateCategories, NameOfCertificate);
		sleep(2);
	}
	
	public void clickIconDeleteCertificate()
	{
		waitForElementClickable(5, iconDeleteCertificate);
		clickByJavaScript(iconDeleteCertificate);
	}
	
	public void clickbBtnYes()
	{
		waitForElementClickable(5, btnYes);
		clickByJavaScript(btnYes);
	}
}
