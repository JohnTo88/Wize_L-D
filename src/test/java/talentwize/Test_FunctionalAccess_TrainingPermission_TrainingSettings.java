package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.TrainingSettings;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TrainingPermission_TrainingSettings extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	CompanyJobHistory companyJobHistory;
	TrainingSettings trainingSettings;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		homePage = new HomePage(driver);
		dashboard = new Dashboard(driver);
		administration = new Administration(driver);
		roles = new Roles(driver);
		users = new Users(driver);
		employeeList = new EmployeeList(driver);
		companyJobHistory = new CompanyJobHistory(driver);
		trainingSettings = new TrainingSettings(driver);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1195() throws InterruptedException {
		TestLogger.info("======================TT_1195=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Training Settings|No Permission" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("Unchecked on Training Permission - Training Settings | Read");
		roles.uncheckbox_Read_TrainingSettings();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());
		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);
		TestLogger.info("6. Log out");
		dashboard.logout();
		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());
		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());
		TestLogger.info("8. Open Training ");
		TestLogger.info("Expect : User CANNOT see/do:\r\n" + "1. Menu Training Settings");

		administration.clickMenuTraining();
		if (administration.isSubMenuTrainingSettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Menu Training Settings");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Menu Training Settings");
		}

		TestLogger.info("======================END TT_1195=====================");
	}

	@Test(priority = 2)
	public void TT_1188() throws InterruptedException {
		TestLogger.info("======================TT_1188=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Training Permission|Training Settings|Read" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked on Training Permission - Training Settings | Read");
		roles.uncheckbox_Read_TrainingSettings();
		roles.checkbox_Read_TrainingSettings();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());
		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);
		TestLogger.info("6. Log out");
		dashboard.logout();
		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());
		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
		administration.clickMenuTraining();
		administration.clickSubMenuTrainingSettings();

		TestLogger.info("8. Open Training => Open Training Settings ");
		if (trainingSettings.isButtonTestDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Settings table\r\n" + "2. Test button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Settings table\r\n" + "2. Test button");
		}

		if (trainingSettings.isButtonEditDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Edit button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Edit button ");
		}

		TestLogger.info("======================END TT_1188=====================");
	}

	@Test(priority = 3)
	public void TT_1189() throws InterruptedException {
		TestLogger.info("======================TT_1189=====================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}
		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Training Permission|Training Settings|Update" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("Unchecked on Training Permission - Training Settings | Update");
		roles.uncheckbox_Read_TrainingSettings();
		roles.checkbox_Update_TrainingSettings();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());
		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);
		TestLogger.info("6. Log out");
		dashboard.logout();
		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());
		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
		TestLogger.info("8. Open Training => Open Training Settings ");
		administration.clickMenuTraining();
		administration.clickSubMenuTrainingSettings();

		if (trainingSettings.isButtonEditDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Edit button");
		} else {
			setStatusTest("fail", "User STILL can NOT see/do:\r\n" + "1. Edit button ");
		}
		
		String LMS = TienIch.taoRandomSo(5);
		String Token = TienIch.taoRandomSo(5);

		trainingSettings.updateTrainingSettings(LMS, Token);

		if (trainingSettings.isMsgUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Update successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT Display msg \"Update successfully\"");
		}

		TestLogger.info("======================END TT_1189=====================");
	}

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {
		// logout
		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();
		roles.searchRoles(UserRoleName);
		roles.Delete_Role();

		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}

		TestLogger.info("====== End Testcase : " + method.getName() + " ======");

	}

	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
