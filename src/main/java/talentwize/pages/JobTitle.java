package talentwize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class JobTitle extends WebActions {

	By btnExport = By.xpath("//button[contains(.,'Export')]");
	By btnAdd = By.xpath("//button[contains(.,'Add')]");
	By btnDelete = By.xpath("//i[@class='icon icon-bin']");
	By menuJobTitle = By.xpath("//span[contains(.,'Job Title')]");
	By linksofJobTitle = By.xpath("//a[@ng-if='permission.allowUpdating']");
	
	By linkofFistNameJobTitle = By.xpath("(//a[@ng-if='permission.allowUpdating'])[1]");

	public JobTitle(WebDriver _driver) {
		super(_driver);

	}

	public boolean isButtonExportDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnExport).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	public boolean isLinksofJobTitleDisplayed() {
		boolean flag = false;

		try {
			List<WebElement> elements = driver.findElements(linksofJobTitle);
			if (elements.size() > 0)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public void openTitleofFistJob()
	{
		waitForElementClickable(linkofFistNameJobTitle);
		clickByJavaScript(linkofFistNameJobTitle);
	}

	public boolean isButtonDeleteDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnDelete).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

	public boolean isButtonAddDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(btnAdd).isDisplayed() == true)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}

}
