package talentwize.pages;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import controller.ScreenController;
import controller.WebActions;

public class Form_AddAttachment extends WebActions {

	ScreenController s  ;
	Screen screen; 
	
	
	public Form_AddAttachment(WebDriver _driver,ScreenController s1, Screen _screen) {
		super(_driver);
		this.screen = _screen;
	    this.s = s1;
	}
	
	
	public void addAttachment(String nameOfDocument)
	{
		s.clickOn("buttonChoosefile.png");
		s.waitForObjectPresent("Windown_dialog_Open_Input_File.png", 4);
		String pathFile = s.getResource("Test_Automation.xlsx");
		s.typeTextOn(pathFile);
		s.clickOn("Open.png");
		sleep(2);
		s.clickOn("Button_Save_Green.png");
	}
	
	public void updateAttachment(String nameOfDocument)
	{
		s.clickOn("buttonChoosefile.png");
		s.waitForObjectPresent("Windown_dialog_Open_Input_File.png", 4);
		String pathFile = s.getResource("Test_Automation.xlsx");
		s.typeTextOn(pathFile);
		s.clickOn("Open.png");
		sleep(2);
		s.clickOn("Button_Save_Green.png");
	}
	
	
	

}
