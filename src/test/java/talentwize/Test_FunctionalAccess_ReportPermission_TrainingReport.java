package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.ScreenController;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.Dashboard;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.TrainingReport;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ReportPermission_TrainingReport extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	TrainingReport trainingReport;

	ScreenController s;
	Screen screen;

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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		trainingReport = new TrainingReport(driver);
		screen = new Screen();
		s = new ScreenController(screen);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1253() throws InterruptedException {
		TestLogger.info("=================TT_1253====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|TrainingReport|NoPermission " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Unchecked Report Permission - Training Report | Read");
		roles.uncheckbox_Read_TrainingReport();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());
		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("8. Open Report");
		administration.clickMenuReport();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "Sub Menu Training Report");
		if (administration.isSubMenuTrainingReportDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Sub Menu Training Report");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Sub Menu Training Report");
		}

		TestLogger.info("=================END TT_1253====================");
	}

	@Test(priority = 2)
	public void TT_1251() throws InterruptedException {
		TestLogger.info("=================TT_1251====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|TrainingReport|Read " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Report Permission  - Training Report | Read");
		roles.uncheckbox_Read_TrainingReport();

		TestLogger.info("5.Check Report Permission  - Training Report | Read");
		roles.checkbox_Read_TrainingReport();

		TestLogger.info("6. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("7. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("8. Log out");
		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailCuongUser());
		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("10. Open Report >> Asset Report");
		administration.clickMenuReport();
		administration.clickSubMenuTrainingReport();
		trainingReport.openDataTable();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "View button");

		if (trainingReport.isBtnViewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View button");
		}

		TestLogger.info("11. Click on View button");
		trainingReport.clickBtnView();

		if (s.waitForObjectPresent("dataTable_TraininReport.png", 20)) {
			setStatusTest("pass", "View data table successfully");
		} else {
			setStatusTest("fail", "View data table NOT successfully");
		}

		TestLogger.info("=================END TT_1251====================");

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
	public void dongTrinhDuyet() {
		driver.close();
	}
}
