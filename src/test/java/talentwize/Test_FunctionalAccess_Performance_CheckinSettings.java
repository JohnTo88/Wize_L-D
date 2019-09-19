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
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddSerries;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.Roles;
import talentwize.pages.SeriesSettings;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_CheckinSettings extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	KPIBoard kPIBoard;
	SeriesSettings seriesSettings;
	Form_AddSerries formAddSerries;

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
		kPIBoard = new KPIBoard(driver);
		seriesSettings = new SeriesSettings(driver);
		formAddSerries = new Form_AddSerries(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 3)
	public void TT_1017() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  Check on Performance Permission - Check-in Settings | Read ");
		roles.uncheckbox_Read_CheckInSetting();
		roles.checkbox_Read_CheckInSetting();
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
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		administration.clickSubMenuSeriesSettings();

		if (seriesSettings.isButtonCheckInBoardDisplayed() == true
				&& seriesSettings.isSerriesListTableDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Series List table \r\n" + "3. Check-in Board button");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "2. Series List table \r\n" + "3. Check-in Board button");
		}

		if (seriesSettings.isButtonAddDisplayed() == false && seriesSettings.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "2. Checkbox and delete button");
		}

	}

	@Test(priority = 4)
	public void TT_1018() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Check-in Settings|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  Check on Performance Permission - Check-in Settings | Update ");
		roles.uncheckbox_Read_CheckInSetting();
		roles.checkbox_Update_CheckInSetting();
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
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		administration.clickSubMenuSeriesSettings();

		if (seriesSettings.isButtonCheckInBoardDisplayed() == true
				&& seriesSettings.isSerriesListTableDisplayed() == true
				&& seriesSettings.isButtonEditDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Series List table \r\n" + "3. Check-in Board button");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "2. Series List table \r\n" + "3. Check-in Board button");
		}

		if (seriesSettings.isButtonAddDisplayed() == false && seriesSettings.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "2. Checkbox and delete button");
		}

	}

	@Test(priority = 5)
	public void TT_1020() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Check-in Settings|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  Check on Performance Permission - Check-in Settings | Delete ");
		roles.uncheckbox_Read_CheckInSetting();
		roles.checkbox_Delete_CheckInSetting();
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
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		administration.clickSubMenuSeriesSettings();

		if (seriesSettings.isButtonCheckInBoardDisplayed() == true
				&& seriesSettings.isSerriesListTableDisplayed() == true
				&& seriesSettings.isButtonDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Series List table \r\n" + "3. Check-in button\r\n"
					+ "4. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL can NOT see /do:\r\n" + "2. Series List table \r\n"
					+ "3. Check-in button\r\n" + "4. Checkbox and delete button");
		}

		if (seriesSettings.isButtonAddDisplayed() == false && seriesSettings.isButtonEditDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Edit btn\r\n" + "2. Add button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Edit btn\r\n" + "2. Add button");
		}

		seriesSettings.deleteSerrieSettings();

		if (seriesSettings.isMessageDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "SHow : Message Delete series successfully!");
		} else {
			setStatusTest("fail", "DOES NOT SHow : Message Delete series successfully!");
		}

	}

	@Test(priority = 2)
	public void TT_1019() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Check-in Settings|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+  Check on Performance Permission - Check-in Settings | Create ");
		roles.uncheckbox_Read_CheckInSetting();
		roles.checkbox_Create_CheckInSetting();
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
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		administration.clickSubMenuSeriesSettings();

		if (seriesSettings.isButtonCheckInBoardDisplayed() == true
				&& seriesSettings.isSerriesListTableDisplayed() == true
				&& seriesSettings.isButtonAddDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "2. Series List table \r\n" + "3. Check-in button\r\n" + "4. Add button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "2. Series List table \r\n" + "3. Check-in button\r\n"
					+ "4. Add button");
		}

		if (seriesSettings.isButtonEditDisplayed() == false && seriesSettings.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Edit btn\r\n" + "2. Checkbox and delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Edit btn\r\n" + "2. Checkbox and delete button");
		}

		seriesSettings.clickButtonAdd();
		formAddSerries.addSeries();

		if (seriesSettings.isMessageCreateSuccessDisplayed() == true) {
			setStatusTest("pass", "SHow : Message \"New Check-in Setting has been successfully created!\"");
		} else {
			setStatusTest("fail", "DOES NOT SHow : Message \"New Check-in Setting has been successfully created!\"");
		}

	}

	@Test(priority = 1)
	public void TT_1008() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-Check-in Settings|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ unchecked all Perfomance Permission - Check-in Setting");
		roles.uncheckbox_Read_CheckInSetting();

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
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();
		if (administration.isSubMenuSeriesSettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Check-in Setting menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Check-in Setting menu");
		}

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
