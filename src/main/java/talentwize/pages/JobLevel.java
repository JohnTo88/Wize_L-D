package talentwize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class JobLevel extends WebActions {

	By btnAdd = By.xpath("//button[@ng-click='addRoleLevelAction()']");
	By btnDelete = By.xpath("//i[@class='icon icon-bin']");
	By linksofJobLevel = By.xpath("//a[@ng-if='permission.allowUpdating']");
	By linkofFistNameJobLevel = By.xpath("(//a[@ng-if='permission.allowUpdating'])[1]");
	public JobLevel(WebDriver _driver) {
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

	
	public void openLinkofFistNameJobLevel()
	{
		waitForElementClickable(10, linkofFistNameJobLevel);
		clickByJavaScript(linkofFistNameJobLevel);
	}
	public boolean isLinksofJobLevelDisplayed() {
		boolean flag = false;

		try {
			List<WebElement> elements = driver.findElements(linksofJobLevel);
			if (elements.size() > 0)
				flag = true;

		} catch (Exception e) {
			flag = false;
		}

		return flag;
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
