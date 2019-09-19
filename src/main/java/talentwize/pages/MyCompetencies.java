package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyCompetencies extends WebActions
{

	public MyCompetencies(WebDriver _driver) {
		super(_driver);
	}

	By subTabMyCompetencies = By.xpath("//h1[contains(.,'My Competencies')]");
	
	public boolean isSubTabMyCompetenciesDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(subTabMyCompetencies).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
