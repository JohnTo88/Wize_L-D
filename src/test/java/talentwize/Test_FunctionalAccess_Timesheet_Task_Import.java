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
import talentwize.pages.Form_ImportTask;
import talentwize.pages.HomePage;
import talentwize.pages.ImageCotainer;
import talentwize.pages.Roles;
import talentwize.pages.TalentReport;
import talentwize.pages.TimeSheetBoard;
import talentwize.pages.TimesheetConfigurations_Task;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Timesheet_Task_Import extends TestManager {
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
	TimeSheetBoard timesheetBoard;
	TimesheetConfigurations_Task timesheetConfigurationsTask;
	Form_ImportTask formImportTask;

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
		timesheetBoard = new TimeSheetBoard(driver);
		timesheetConfigurationsTask = new TimesheetConfigurations_Task(driver);
		formImportTask = new Form_ImportTask(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1141() throws InterruptedException {
		TestLogger.info("========== TT_1141================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

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
		UserRoleName = "Task - Import | Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. + Check on Timesheet Permission - Timesheet - Task - Import | Read\r\n"
				+ "+ Check on Timesheet Permission - Timesheet - Management | Read\r\n"
				+ "+ Check on Timesheet Permission - Timesheet - Configuration | Read");

		TestLogger.info("5. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("8. Open Timesheet Board >> Settings");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetBoard.clickBtnSettings();

		TestLogger.info("Open Import Task\r\n" + "4. Input excel file\r\n" + "5. Click on button \"Import\"");

		timesheetConfigurationsTask.clickBtnImport();

		s.clickOn(ImageCotainer.Windown_dialog_Choose_File);

		if (s.waitForObjectPresent(ImageCotainer.Windown_dialog_Open_Input_File, 4)) {
			s.clickOn(ImageCotainer.Windown_dialog_Open_Input_File);
			s.typeTextOn(TienIch.getAbsoluteFilePathFromResource(ImageCotainer.Test_Automation));
			s.clickOn(ImageCotainer.Window_Dialog_Button_Open);

		} else {
			setStatusTest("fail", "Dialog does NOT appear ! ");
		}

		formImportTask.clickBtnImport();
		if (timesheetConfigurationsTask.isMsgImportSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Import Successful\"");
			timesheetConfigurationsTask.fillTxtSearchTask("Test Automation");
			timesheetConfigurationsTask.deleteTasks();
		} else {
			setStatusTest("fail", "DO NOT Displays msg \"Import Successful\" ");
		}

		TestLogger.info("=================END TT_1141====================");

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
