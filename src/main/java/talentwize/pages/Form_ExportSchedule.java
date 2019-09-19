package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_ExportSchedule extends WebActions {

	By txtProject = By.xpath("//input[@placeholder='Select projects...']");
	By btnExport = By.xpath("(//button[contains(.,'Export')])[2]");
	By itemProject = By.xpath("(//div[contains(@ng-bind-html,'project.projectName')])[1]");
	
	public Form_ExportSchedule(WebDriver _driver) {
		super(_driver);
		
	}
	
	public void clickBtnExport()
	    {
	    	waitForElementClickable(5, btnExport);
	    	clickByJavaScript(btnExport);
	    }
		
    public void clickTxtProject()
    {
    	waitForElementClickable(5, txtProject);
    	clickByJavaScript(txtProject);
    }
    
    public void clickItemProject()
    {
    	waitForElementClickable(5, itemProject);
    	clickByJavaScript(itemProject);
    }
    
    public void exportSchedule()
    {
    	clickTxtProject();
    	clickItemProject();
    	clickBtnExport();
    }
    
}
