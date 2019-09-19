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
import talentwize.pages.AssetReport;
import talentwize.pages.Dashboard;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ReportPermission_AssetReport extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	AssetReport assetReport;

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
		assetReport = new AssetReport(driver);
		screen = new Screen();
		s = new ScreenController(screen);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1237() throws InterruptedException {
		TestLogger.info("=================TT_1237====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

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
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Asset Report | Read");
		roles.uncheckbox_Read_AssetReport();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Report");
		administration.clickMenuReport();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Submenu Asset Report");
		if (administration.isSubMenuAssetReportDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Submenu Asset Report");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Submenu Asset Report");
		}

		TestLogger.info("=================END TT_1237====================");
	}

	@Test(priority = 2)
	public void TT_1236() throws InterruptedException {
		TestLogger.info("=================TT_1236====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

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
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Report >> Asset Report");
		administration.clickMenuReport();
		administration.clickSubMenuAssetReport();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Export button");
		if (assetReport.isDataTableDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (assetReport.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Export button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Export button");
		}

		TestLogger.info("3. Click on Export button");
		s.clickOn("btnExport.png");

		if (s.waitForObjectPresent("fileExcel.png", 10)) {
			setStatusTest("pass", "Export report successfully");
		} else {
			setStatusTest("fail", "Export report NOT successfully");
		}

		TestLogger.info("=================END TT_1236====================");

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
