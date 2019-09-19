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
import talentwize.pages.LeaveReport;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ReportPermission_LeaveReport extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	LeaveReport leaveReport;

	String UserRoleName;
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
		leaveReport = new LeaveReport(driver);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		screen = new Screen();
		s = new ScreenController(screen);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1243() throws InterruptedException {
		TestLogger.info("========== TT_1243================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|LeaveReport|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Report Permission  - Leave Report | Read");
		roles.uncheckbox_Read_LeaveReport();

		TestLogger.info("5. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("8. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuReports();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Menu Leave Report");
		if (administration.isSubMenuLeaveReportDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Menu Leave Report");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Menu Leave Report");
		}

		TestLogger.info("=================END TT_1243====================");

	}

	@Test(priority = 2)
	public void TT_1242() throws InterruptedException {
		TestLogger.info("========== TT_1242================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|LeaveReport|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Report Permission  - Leave Report | Read");
		roles.uncheckbox_Read_LeaveReport();

		TestLogger.info("5.Check Report Permission  - Leave Report | Read");
		roles.checkbox_Read_LeaveReport();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuReports();
		administration.clickSubMenuLeaveReport();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "View button");
		if (leaveReport.isBtnViewDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View button");
		}

		TestLogger.info("10. Check data");
		leaveReport.clickBtnView();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Data table");
		if (s.waitForObjectPresent("dataTable_LeaveReport.png", 30)) {
			setStatusTest("pass", "Export report successfully");
		} else {
			setStatusTest("fail", "Export report NOT successfully");
		}

		TestLogger.info("==========End TT_1242================");
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
