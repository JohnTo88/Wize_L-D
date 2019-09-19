package talentwize.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import controller.WebActions;

public class MyCheckIn extends WebActions {

	public MyCheckIn(WebDriver driver) {
		super(driver);
		
	}
	
	By iconMyHistoryCheckin = By.xpath("(//div/a/span[@ng-bind-html='checkIn.status'])");

	By msgAddedSuccess = By.xpath("//span[contains(.,'Add comment successfully!')]");
	
	public void clickIconHistoryCheckin()
	{
		List<WebElement> list = driver.findElements(iconMyHistoryCheckin);
		if (list.size()>0)
		{
			clickByJavaScript(By.xpath("(//div/a/span[@ng-bind-html='checkIn.status'])["+(list.size())+"]"));
		}
		else
		{
			clickByJavaScript(iconMyHistoryCheckin);
		}
		
	}

	public boolean isMsgAddedSuccessDisplayed()
	{
		boolean flag= false;
		try {
			if (driver.findElement(msgAddedSuccess).isDisplayed()==true)
				flag = true;
			
		} catch (Exception e) {
			flag = false;
		}
		sleep(5);
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
