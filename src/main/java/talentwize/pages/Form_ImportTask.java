package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_ImportTask extends WebActions {

	public Form_ImportTask(WebDriver _driver) {
		super(_driver);
		
	}
	
	By btnChooseFile = By.xpath("//label[contains(.,'Choose file')]"); 
	By btnImport = By.xpath("//button[@ng-click='save()']"); 
	
	public void clickBtnChooseFile()
	{
		try {
			waitForElementPresent(5, btnChooseFile);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickByJavaScript(btnChooseFile);
	}
	
	
	public void clickBtnImport()
	{
		clickByJavaScript(btnImport);
	}
	
	
	

}
