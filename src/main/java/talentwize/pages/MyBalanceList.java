package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class MyBalanceList extends WebActions
{

	public MyBalanceList(WebDriver _driver) {
		super(_driver);
	}

	By lblBlance = By.xpath("(//div[contains(.,'Balance')])[20]");
	
	public boolean isLblBlanceDisplayed() {
		boolean flag = false;
		try {
			if (driver.findElement(lblBlance).isDisplayed() == true) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
