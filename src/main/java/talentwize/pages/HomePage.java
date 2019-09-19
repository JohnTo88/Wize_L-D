package talentwize.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import controller.WebActions;

public class HomePage extends WebActions {

	By txtEmail = By.xpath("//input[@placeholder='Talentwize ID']");
	By txtPassword = By.xpath("//input[@placeholder='Password']");
	By btnSignin = By.xpath("//button[@ng-click='login()']");

	public HomePage(WebDriver driver) {
		super(driver);
        phongToCuaSoTrinhDuyet();
	}

	public void fillEmail(String email) {
		waitForElementClickable(10, txtEmail);
		driver.findElement(txtEmail).clear();
		driver.findElement(txtEmail).sendKeys(email);
	}

	public void fillPassword(String password) {
		waitForElementClickable(5, txtEmail);
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys(password);
	}

	public void clickButtonSignin() {
		waitForElementClickable(5, txtEmail);
		driver.findElement(btnSignin).click();
	}

	public void SignInWith(String Email, String Password) {
		fillEmail(Email);
		fillPassword(Password);
		clickButtonSignin();
		
	}

}
