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
import talentwize.pages.KPIBoard;
import talentwize.pages.Roles;
import talentwize.pages.TalentReport;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_Personal_PerformanceManagementImport extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	TalentReport talentReport;

	String UserRoleName;
	Screen screen;
	ScreenController s;
	KPIBoard kpiboard;

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
		talentReport = new TalentReport(driver);
		screen = new Screen();
		s = new ScreenController(screen);
		kpiboard = new KPIBoard(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_3623() throws InterruptedException {
		TestLogger.info("========== TT_3623================");
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
		UserRoleName = "Permission|PerformanceImport|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. UnCheck on Performance - Personal Performance Management Import | Read");
		roles.uncheckbox_Read_PersonalPerformanceManagementImport();

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

		TestLogger.info("8. Open Performance menu >> Go To KPI submenu >> Go To KPI Board");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();
		administration.clickSubMenuKPIBoard();

		TestLogger.info("9. Check Permission");
		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "Button Import");

		if (kpiboard.isButtonImportDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Impor");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Impor");
		}

		TestLogger.info("=================END TT_3623====================");

	}

	@Test(priority = 2)
	public void TT_1025() throws InterruptedException {
		TestLogger.info("========== TT_1025================");
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
		UserRoleName = "Permission|PerformanceImport|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. UnCheck on Performance - Personal Performance Management Import | Read");
		roles.uncheckbox_Read_PersonalPerformanceManagementImport();

		TestLogger.info("5. Check on Performance - Personal Performance Management Import | Read");
		roles.checkbox_Read_PersonalPerformanceManagementImport();

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

		TestLogger.info("9. Open Performance menu >> Go To KPI submenu >> Go To KPI Board");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();
		administration.clickSubMenuKPIBoard();

		TestLogger.info("10. Check Permission");

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Button Import");

		if (kpiboard.isButtonImportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Impor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Impor");
		}

		TestLogger.info("11. Impport Permission");
		kpiboard.clickBtnImport();
		s.clickOn("buttonChoosefile.png");
		s.clickOn("txtFileName.png");
		String pathFile = s.getResource("file_TestImportKPI.xlsx");
		s.typeTextOn(pathFile);
		s.clickOn("Open.png");
		kpiboard.clickBtnSummitImport();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Import Successful");

		if (kpiboard.isMsgImportSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Import Successful");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Import Successful");
		}

		TestLogger.info("=================END TT_1025====================");

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
