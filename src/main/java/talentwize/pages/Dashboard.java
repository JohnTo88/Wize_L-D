package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Dashboard extends WebActions {

	By menuDashboard = By.xpath("(//span[contains(.,'Dashboard')])[1]");

	By profile = By.xpath("(//a[@data-toggle='dropdown'])[2]");

	By subMenuAccount = By.xpath(".//a[text()='Sign out']");

	public Dashboard(WebDriver driver) {
		super(driver);
	}

	public boolean isDashboardMenuDisplayed() throws InterruptedException {
		waitForPageLoaded();
		sleep(2);
		try {
			if ( driver.findElement(menuDashboard).isDisplayed()==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			
		
			return false;
		}
	}

	public void logout() {
		sleep(1);
		clickByJavaScript(profile);
		sleep(3);
		clickByJavaScript(subMenuAccount);
		sleep(2);

	}
	
	public boolean isProfileDisplayed()
	{
		try {
			if (driver.findElement(profile).isDisplayed()==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			
			
			return false;
		}
	}

}
