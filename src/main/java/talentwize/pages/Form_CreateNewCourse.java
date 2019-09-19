package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class Form_CreateNewCourse extends WebActions {

	public Form_CreateNewCourse(WebDriver _driver) {
		super(_driver);
	}
	
	By txtCourseName = By.xpath("//input[@ng-model='course.name']");
	By drpCategories = By.xpath("//input[@placeholder='Select categories...']");
	By option = By.xpath("(//div[@ng-bind-html='category.value'])[1]");
	By txtDuration = By.xpath("//input[contains(@name,'duration')]");
	By btnSave = By.xpath("//button[contains(.,'Save')]");
     
	public void inputCourseName (String nameOfCourseName)
	{
		typeText(txtCourseName, nameOfCourseName);
	}
	
	public void chooseCategories()
	{
		clickByJavaScript(drpCategories);
		clickByJavaScript(option);
	}
	
	public void fillDuration(String hh_mm)
	{
		goTextOnNoEnter(txtDuration, hh_mm);
	}
	
	public void clickButtonSave()
	{
		clickByJavaScript(btnSave);
	}
	
	public void CreateNewCourse(String nameOfCourseName)
	{
		inputCourseName(nameOfCourseName);
		chooseCategories();
		fillDuration("24:00");
		clickButtonSave();
		
	}
	
	
	
}
