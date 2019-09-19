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
import talentwize.pages.BalanceList;
import talentwize.pages.Dashboard;
import talentwize.pages.HomePage;
import talentwize.pages.LeaveCalendar;
import talentwize.pages.LeaveConfigurations;
import talentwize.pages.ListRequest;
import talentwize.pages.Roles;
import talentwize.pages.TabLeaveBalance;
import talentwize.pages.TabLeavePolicy;
import talentwize.pages.TabLeaveType;
import talentwize.pages.TabManagementConfiguration;
import talentwize.pages.TabPublicHoliday;
import talentwize.pages.TabWorkingDays;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Leave_Management extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	LeaveCalendar leaveCalendar;
	TabManagementConfiguration tabManagementConfig;
	TabLeaveType tabLeaveType;
	TabLeavePolicy tabLeavePolicy;
	TabLeaveBalance tabLeaveBalance;
	TabPublicHoliday tabPublicHoliday;
	TabWorkingDays tabWorkingDays;
	BalanceList balanceList;
	ListRequest listRequest;
	LeaveConfigurations leaveConfigurations;

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
		tabManagementConfig = new TabManagementConfiguration(driver);
		tabLeaveType = new TabLeaveType(driver);
		tabLeavePolicy = new TabLeavePolicy(driver);
		tabLeaveBalance = new TabLeaveBalance(driver);
		tabPublicHoliday = new TabPublicHoliday(driver);
		balanceList = new BalanceList(driver);
		tabWorkingDays = new TabWorkingDays(driver);
		leaveConfigurations = new LeaveConfigurations(driver);
		leaveCalendar = new LeaveCalendar(driver);
		listRequest = new ListRequest(driver);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_344() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-ImportBalance|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Leave - Management | Read ");
		roles.click_Uncheckbox_Leave_Management();
		roles.choose_Checkbox_Read_Leave_Management();
		TestLogger.info("+ unchecked all other Leave permission");
		roles.click_Uncheckbox_Leave_Configurations();
		roles.click_Uncheckbox_Leave_ImportBalance();
		roles.click_Uncheckbox_Leave_Calendar();
		roles.click_Uncheckbox_Leave_Calendar_Colleague_leave();
		roles.click_Uncheckbox_Leave_Set_Taken();
		roles.click_Uncheckbox_Leave_Revoke_Taken();

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
		TestLogger.info("Open Balance List screen");
		administration.clickMenuLeave();
		if (administration.isSubMenuRequestListDisplayed() == true
				&& administration.isSubMenuBalanceListDisplayed() == true) {
			setStatusTest("pass", "User can see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		} else {
			setStatusTest("fail", "User can NOT see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		}

		administration.clickSubMenuListRequest();
		listRequest.changeReportToAll();
		if (listRequest.isLinkOfListRequestDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (listRequest.isButtonReviewDisplayed() == false && listRequest.isButtonAssignLeaveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Assign button\r\n" + "2. Review button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Assign button\r\n" + "2. Review button");
		}

		administration.clickSubMenuBalanceList();
		if (balanceList.isLinkOfListRequestDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (balanceList.isButtonDropToolsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see /do:\r\n" + "1.Tool btn");
		} else {
			setStatusTest("fail", "User STILL CAN see /do:\r\n" + "1.Tool btn");
		}

	}

	@Test(priority = 2)
	public void TT_340() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-ImportBalance|Update" + TienIch.taoRandomSo(1);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Leave - Management | Update ");
		roles.click_Uncheckbox_Leave_Management();
		roles.choose_Checkbox_Update_Leave_Management();
		TestLogger.info("+ unchecked all other Leave permission");
		roles.click_Uncheckbox_Leave_Configurations();
		roles.click_Uncheckbox_Leave_ImportBalance();
		roles.click_Uncheckbox_Leave_Calendar();
		roles.click_Uncheckbox_Leave_Calendar_Colleague_leave();
		roles.click_Uncheckbox_Leave_Set_Taken();
		roles.click_Uncheckbox_Leave_Revoke_Taken();

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
		TestLogger.info("Open Balance List screen");
		administration.clickMenuLeave();

		if (administration.isSubMenuRequestListDisplayed() == true
				&& administration.isSubMenuBalanceListDisplayed() == true) {
			setStatusTest("pass", "User can see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		} else {
			setStatusTest("fail", "User can NOT see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		}

		administration.clickSubMenuListRequest();
		listRequest.changeReportToAll();

		if (listRequest.isLinkOfListRequestDisplayed() == true && listRequest.isButtonReviewDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "2. Clickable on Date request ( in the table)\r\n" + "3. Review button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (listRequest.isButtonAssignLeaveDisplayed() == false) {
			setStatusTest("pass", "User cannot see /do:\r\n" + "1. Assign button");
		} else {
			setStatusTest("fail", "User Still Can see /do:\r\n" + "1. Assign button");
		}

		administration.clickSubMenuBalanceList();
		if (balanceList.isLinkOfListRequestDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (balanceList.isButtonDropToolsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see /do:\r\n" + "1.Tool btn");
		} else {
			setStatusTest("fail", "User STILL CAN see /do:\r\n" + "1.Tool btn");
		}

	}

	@Test(priority = 3)
	public void TT_346() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-ImportBalance|Update" + TienIch.taoRandomSo(1);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Leave - Management | Update ");
		roles.click_Uncheckbox_Leave_Management();
		roles.choose_Checkbox_Create_Leave_Management();
		TestLogger.info("+ unchecked all other Leave permission");
		roles.click_Uncheckbox_Leave_Configurations();
		roles.click_Uncheckbox_Leave_ImportBalance();
		roles.click_Uncheckbox_Leave_Calendar();
		roles.click_Uncheckbox_Leave_Calendar_Colleague_leave();
		roles.click_Uncheckbox_Leave_Set_Taken();
		roles.click_Uncheckbox_Leave_Revoke_Taken();

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
		TestLogger.info("Open Balance List screen");
		administration.clickMenuLeave();

		if (administration.isSubMenuRequestListDisplayed() == true
				&& administration.isSubMenuBalanceListDisplayed() == true) {
			setStatusTest("pass", "User can see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		} else {
			setStatusTest("fail", "User can NOT see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		}

		administration.clickSubMenuListRequest();
		listRequest.changeReportToAll();

		if (listRequest.isLinkOfListRequestDisplayed() == true && listRequest.isButtonAssignLeaveDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Assign button\r\n" + "2. Clickable on Date request ( in the table)");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (listRequest.isButtonReviewDisplayed() == false) {
			setStatusTest("pass", "User cannot see /do:\r\n" + "1. Review button");
		} else {
			setStatusTest("fail", "User Still Can see /do:\r\n" + "1. Review button");
		}

		administration.clickSubMenuBalanceList();
		if (balanceList.isLinkOfListRequestDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (balanceList.isButtonDropToolsDisplayed() == true) {
			balanceList.clickButtonDropTool();
			if (balanceList.isOptionExportBalanceDisplayed() == true
					&& balanceList.isOptionUpdateBalanceDisplayed() == true) {
				setStatusTest("pass", "User can see /do:\r\n" +

						"2. Click on Tool btn, user can see Export &Update Balance btn\r\n"
						+ "3. Clickable on Employee Name ( in the table)\r\n" + "");
			} else {
				setStatusTest("fail", "User can NOT see /do:\r\n" +

						"2. Click on Tool btn, user can see Export &Update Balance btn\r\n"
						+ "3. Clickable on Employee Name ( in the table)\r\n" + "");
			}

			setStatusTest("pass", "User CANsee /do:\r\n" + "1.Tool btn");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see /do:\r\n" + "1.Tool btn");
		}

	}

	@Test(priority = 4)
	public void TT_361() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Management|Delete" + TienIch.taoRandomSo(1);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Leave - Management |Delete ");
		roles.click_Uncheckbox_Leave_Management();
		roles.choose_Checkbox_Delete_Leave_Management();
		TestLogger.info("+ unchecked all other Leave permission");
		roles.click_Uncheckbox_Leave_Configurations();
		roles.click_Uncheckbox_Leave_ImportBalance();
		roles.click_Uncheckbox_Leave_Calendar();
		roles.click_Uncheckbox_Leave_Calendar_Colleague_leave();
		roles.click_Uncheckbox_Leave_Set_Taken();
		roles.click_Uncheckbox_Leave_Revoke_Taken();

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
		TestLogger.info("Open Balance List screen");
		administration.clickMenuLeave();

		if (administration.isSubMenuRequestListDisplayed() == true
				&& administration.isSubMenuBalanceListDisplayed() == true) {
			setStatusTest("pass", "User can see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		} else {
			setStatusTest("fail", "User can NOT see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		}

		administration.clickSubMenuListRequest();
		listRequest.changeReportToAll();

		if (listRequest.isLinkOfListRequestDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" +

					"2. Clickable on Date request ( in the table)");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (listRequest.isButtonReviewDisplayed() == false && listRequest.isButtonAssignLeaveDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Assign button\r\n" + "2. Review button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Assign button\r\n" + "2. Review button");
		}

		administration.clickSubMenuBalanceList();
		if (balanceList.isLinkOfListRequestDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Date request ( in the table)");
		}

		if (balanceList.isButtonDropToolsDisplayed() == false) {

			setStatusTest("pass", "User CAN NOT see /do:\r\n" + "1.Tool btn");
		} else {
			setStatusTest("fail", "User STILL CAN see /do:\r\n" + "1.Tool btn");
		}

	}

	@Test(priority = 5)
	public void TT_397() throws InterruptedException {
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
		UserRoleName = "Leave-Management|No permission Read" + TienIch.taoRandomSo(1);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Check on Leave - Management |Delete ");
		roles.click_Uncheckbox_Leave_Management();
		TestLogger.info("+ unchecked all other Leave permission");
		roles.click_Uncheckbox_Leave_Configurations();
		roles.click_Uncheckbox_Leave_ImportBalance();
		roles.click_Uncheckbox_Leave_Calendar();
		roles.click_Uncheckbox_Leave_Calendar_Colleague_leave();
		roles.click_Uncheckbox_Leave_Set_Taken();
		roles.click_Uncheckbox_Leave_Revoke_Taken();

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
		TestLogger.info("Open Balance List screen");
		administration.clickMenuLeave();

		if (administration.isSubMenuRequestListDisplayed() == false
				&& administration.isSubMenuBalanceListDisplayed() == false) {
			setStatusTest("pass", "User can NOT see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
		} else {
			setStatusTest("fail", "User STILL can  see 2 sub menu:\r\n" + "+ Request List\r\n" + "+ Balance List");
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
