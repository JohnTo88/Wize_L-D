package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateNewProgram extends WebActions
{

	public Form_CreateNewProgram(WebDriver _driver) {
		super(_driver);
	}
	
	By txtProgramName = By.xpath("//input[@ng-model='program.name']");
	By cboxCourse = By.xpath("(//label[@class='i-checkbox'])[1]");
	By btnMove = By.xpath("//button[@ng-click='select()']");
	By btnNext = By.xpath("(//button[contains(.,'Next')])[2]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
	
	  private void fillTxtProgramName(String ProgramName)
	    {
	    	waitForElementClickable(5, txtProgramName);
	    	goTextOn(txtProgramName, ProgramName);
	    }
	  
	  private void clickBtnNext()
	    {
	    	clickByJavaScript(btnNext);
	    }
	  
	  private void clickCboxCourse()
	    {
	    	clickByJavaScript(cboxCourse);
	    }
	  
	  private void clickBtnMove()
	    {
	    	clickByJavaScript(btnMove);
	    }
	  
	  private void clickBtnSave()
	    {
	    	clickByJavaScript(btnSave);
	    }
	  
	  public void createNewProgram(String ProgramName)
	  {
		  fillTxtProgramName(ProgramName);
		  clickBtnNext();
		  clickCboxCourse();
		  clickBtnMove();
		  clickBtnSave();
		  sleep(2);
	  }
}
