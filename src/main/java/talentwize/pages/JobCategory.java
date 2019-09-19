package talentwize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class JobCategory extends WebActions {

	By btnAdd = By.xpath("//div[@ng-click='add()']");
	By btnDelete = By.xpath("//i[@class='icon icon-bin']");
	By linksofJobCategory = By.xpath("//a[@ng-if='permission.allowUpdating']");
	By linkofFistNameJobCategory = By.xpath("(//a[@ng-if='permission.allowUpdating'])[1]");

	public JobCategory(WebDriver _driver) {
		super(_driver);
		// TODO Auto-generated constructor stub
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

	public boolean isLinksofJobCategoryDisplayed() {
		boolean flag = false;

		try {
			List<WebElement> elements = driver.findElements(linksofJobCategory);
			if (elements.size() > 0)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
	}
	
	public void openLinkFistNameJobCategory()
	{
		waitForElementClickable(10, linkofFistNameJobCategory);
		clickByJavaScript(linkofFistNameJobCategory);
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

}
