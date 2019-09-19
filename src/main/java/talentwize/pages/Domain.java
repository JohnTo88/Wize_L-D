package talentwize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class Domain extends WebActions {

	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By btnDelete = By.xpath("//i[@class='icon icon-bin']");

	By linkofDomains = By.xpath("(//span[@ng-if='permission.allowUpdating'])");

	By checkboxOfDomain = By.xpath("(//i[@class='icon icon-circle radio-normal text-danger'])");
	
	By fistLinkofDomain = By.xpath("(//span[contains(@ng-if,'permission.allowUpdating')])[1]");
	
	By messageSuccesful = By.xpath("//span[contains(.,'Update domain successfully!')]");
	
	By messageDeleteSuccessful = By.xpath("//span[contains(.,'Delete domain successfully')]");
	
	

	public Domain(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isBtnAddDisplayed() {
		boolean flag = false;
		try {
			waitForElementClickable(10, btnAdd);
			if (driver.findElement(btnAdd).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickButtonDelete()
	{
		waitForElementClickable(10,btnDelete);
		clickByJavaScript(btnDelete);
	}
	
	public boolean isMessageDeleteSusseccDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(messageDeleteSuccessful).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickDomainCheckBox(String nameOfDomain)
	{
		waitForElementClickable(10, By.xpath("//span[contains(.,'"+nameOfDomain+"')]/preceding::label[1][1]"));
		clickByJavaScript(By.xpath("//span[contains(.,'"+nameOfDomain+"')]/preceding::label[1]"));
	}
	
	public void clickButtonAdd()
	{
		clickByJavaScript(btnAdd);
	}
	
	public boolean isMessageSuccessDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElement(messageSuccesful).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isBtnDeleteDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnDelete).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public void clickFistLinkDomain()
	{
		waitForElementClickable(10, fistLinkofDomain);
		clickByJavaScript(fistLinkofDomain);
	}

	public boolean isLinkofDomainsClickable() {
		boolean flag = false;
		try {

			if (driver.findElements(linkofDomains).size() > 0) {
				flag = true;
			}

		} catch (Exception e) {
			flag = false;
		}

		return flag;

	}

	public boolean isCheckboxsOfDomainClickable() {
		boolean flag = false;
		List<WebElement> list1 = driver.findElements(checkboxOfDomain);
		try {
			if (list1.size() > 0) {
				for (WebElement e : list1) {
					e.click();
				}

			}

			if (driver.findElements(checkboxOfDomain).size() != list1.size()) {
                   flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
