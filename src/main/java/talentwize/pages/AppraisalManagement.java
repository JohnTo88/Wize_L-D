package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class AppraisalManagement extends WebActions
{

	public AppraisalManagement(WebDriver _driver) {
		super(_driver);
	}

	By tabAppraisals = By.xpath("//a[contains(.,'Appraisals')]");
	By tabAppraisalCycle = By.xpath("//a[@href='#/te/appraisal/cycle']");
	
	public boolean isTabAppraisalsDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabAppraisals).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	public boolean isTabAppraisalCycleDisplayed()
	{
		boolean flag = false;
		try {
			if (driver.findElements(tabAppraisalCycle).size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
}
