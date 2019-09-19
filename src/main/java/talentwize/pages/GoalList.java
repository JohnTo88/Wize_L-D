package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class GoalList extends WebActions {

	public GoalList(WebDriver _driver) {
		super(_driver);
		
	}
	
	
	By txtComment = By.xpath("//textarea[@name='comment']");
	By btnSubmit = By.xpath("//button[contains(.,'Submit')]"); 
	
	public void fillComment (String contentOfComment)
	{
		goTextOnNoEnter(txtComment, contentOfComment);
		clickByJavaScript(btnSubmit);
		
	}
	
	
	
	
	

}
