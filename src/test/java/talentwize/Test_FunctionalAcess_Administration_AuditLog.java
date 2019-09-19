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
import talentwize.pages.AuditLog;
import talentwize.pages.AuthenticationLogs;
import talentwize.pages.AutoJob;
import talentwize.pages.Dashboard;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;
// Bug : http://10.17.14.203:8080/browse/TAL-93 

public class Test_FunctionalAcess_Administration_AuditLog extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	AuditLog audit;
	AuthenticationLogs auditLog;
	AutoJob autoJob;
	String UserRoleName;

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		propertyManager = new PropertyManager();
		propertyManager.loadData();
		driver = WebDriversManager.moTrinhDuyet("chrome");
		homePage = new HomePage(driver);
		dashboard = new Dashboard(driver);
		audit = new AuditLog(driver);
		administration = new Administration(driver);
		auditLog = new AuthenticationLogs(driver);
		roles = new Roles(driver);
		users = new Users(driver);
		autoJob = new AutoJob(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	// Bug : http://10.17.14.203:8080/browse/TAL-93
	@Test(priority = 1)
	public void TT_148() throws InterruptedException {
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
		UserRoleName = "Automation-Audit Log-Read" + System.currentTimeMillis();

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row 3 ,4 ,5  ");
		roles.uncheck_All_Checkbox_Row_3();
		roles.uncheck_All_Checkbox_Row_4();
		roles.uncheck_All_Checkbox_Row_5();
		TestLogger.info("4. Check on Administration-Audit Log | Read");
		TestLogger.info("Choose only checkbox Read on Automation-Administration-Audit Log- Read");

		roles.choose_Checkbox_Read_With_Row_Number3();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2.Audit Log menu"
				+ "3.  2 tabs: " + "Modules " + "Mailbox ");
		administration.clickMenuAuditLog();

		if (audit.isMailboxDisplayed() == true && audit.isModulesDisplayed() == true) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2.Audit Log menu"
					+ "3.  2 tabs: \" + \"Modules \" + \"Mailbox ");
		} else {
			setStatusTest("fail", "User can NOT see/do : 1. Administration menu"
					+ "2.Audit Log menu 3.  2 tabs: \" + \"Modules \" + \"Mailbox ");
		}

		TestLogger.info("User CANNOT see/do" + "1. Tab Authentication Logs \r\n" + "2. Tab Auto Job ");

		if (audit.isAuthencationLogsDisplayed() == false && audit.isJobAutoDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :" + "1. Tab Authentication Logs \\r\\n\" + \r\n"
					+ "				\"2. Tab Auto Job ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do : " + "1. Tab Authentication Logs \\r\\n\" + \r\n"
					+ "				\"2. Tab Auto Job ");
		}

	}

	@Test(priority = 2)
	public void TT_149() throws InterruptedException {
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
		UserRoleName = "Automation-AuditLog-AuthenticationLog-Read" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row 3 ,4 ,5 ");
		roles.uncheck_All_Checkbox_Row_3();
		roles.uncheck_All_Checkbox_Row_4();
		roles.uncheck_All_Checkbox_Row_5();
		TestLogger.info("4. Check on Administration-Audit Log - Authentication Log | Read");
		TestLogger.info("Choose only checkbox Read on Automation-Administration-Audit Log-Authentication Log-Read");

		roles.choose_Checkbox_Read_With_Row_Number3();
		roles.choose_Checkbox_Read_With_Row_Number4();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2.Audit Log menu"
				+ " 3 tabs: " + "Modules " + "Mailbox - Tab Authentication Logs ");
		administration.clickMenuAuditLog();

		if (audit.isMailboxDisplayed() == true && audit.isModulesDisplayed() == true
				&& audit.isAuthencationLogsDisplayed() == true) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2.Audit Log menu"
					+ "3.  3 tabs: \" + \"Modules \" + \"Mailbox - Tab Authentication Logs");
		} else {
			setStatusTest("fail", "User can NOT see/do : 1. Administration menu"
					+ "2.Audit Log menu 3.  2 tabs: \" + \"Modules \" + \"Mailbox -Tab Authentication Logs ");
		}

		TestLogger.info("User CANNOT see/do"
				+ "1. Tab Authentication Logs \r\n with user A - user cannot see UnLocked button" + "2. Tab Auto Job ");

		if (audit.isJobAutoDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :2. Tab Auto Job ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do : User CANNOT see/do :2. Tab Auto Job ");
		}

		audit.openAuthenticationLogs();
		auditLog.searchUsers(propertyManager.getEmailUserLock());

		if (auditLog.isSearchUserFound(propertyManager.getEmailUserLock()) == true
				&& auditLog.isButtonUnlockFound() == false) {
			setStatusTest("pass", "In tab Authentication Logs, with user A - user cannot see UnLocked button");
		} else {
			setStatusTest("fail", "In tab Authentication Logs, with user A - user STILL CAN see UnLocked button");
		}

	}

	@Test(priority = 3)
	public void TT_151() throws InterruptedException {
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
		UserRoleName = "Automation-AuditLog-AuthenticationLog-Update" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row 3 ,4 ,5 ");
		roles.uncheck_All_Checkbox_Row_3();
		roles.uncheck_All_Checkbox_Row_4();
		roles.uncheck_All_Checkbox_Row_5();
		TestLogger.info("4. Check on Administration-Audit Log - Authentication Log | Update");
		TestLogger.info("Choose only checkbox Update on Automation-Administration-Audit Log-Authentication Log-Update");

		roles.choose_Checkbox_Read_With_Row_Number3();
		roles.choose_Checkbox_Update_With_Row_Number4();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2.Audit Log menu"
				+ " 3 tabs: " + "Modules " + "Mailbox - Tab Authentication Logs ");
		administration.clickMenuAuditLog();

		if (audit.isMailboxDisplayed() == true && audit.isModulesDisplayed() == true
				&& audit.isAuthencationLogsDisplayed() == true) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2.Audit Log menu"
					+ "3.  3 tabs: \" + \"Modules \" + \"Mailbox - Tab Authentication Logs");
		} else {
			setStatusTest("fail", "User can NOT see/do : 1. Administration menu"
					+ "2.Audit Log menu 3.  2 tabs: \" + \"Modules \" + \"Mailbox -Tab Authentication Logs ");
		}

		TestLogger.info("User CANNOT see/do"
				+ "1. Tab Authentication Logs \r\n with user A - user cannot see UnLocked button" + "2. Tab Auto Job ");

		if (audit.isJobAutoDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :2. Tab Auto Job ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do : User CANNOT see/do :2. Tab Auto Job ");
		}

		audit.openAuthenticationLogs();
		auditLog.searchUsers(propertyManager.getEmailUserLock());

		if (auditLog.isSearchUserFound(propertyManager.getEmailUserLock()) == true
				&& auditLog.isButtonUnlockFound() == true) {
			setStatusTest("pass", "In tab Authentication Logs, with user A - user can see UnLocked button");
		} else {
			setStatusTest("fail", "In tab Authentication Logs, with user A - user CAN NOT see UnLocked button");
		}

	}

	@Test(priority = 4)
	public void TT_152() throws InterruptedException {
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
		UserRoleName = "Automation-AuditLog-AutoJob-Update" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row 3 ,4 ,5 ");
		roles.uncheck_All_Checkbox_Row_3();
		roles.uncheck_All_Checkbox_Row_4();
		roles.uncheck_All_Checkbox_Row_5();
		TestLogger.info("4. Check on Administration-Audit Log - AutoJob | Update");
		TestLogger.info("Choose only checkbox Update on Automation-Administration-AutoJob-Update");

		roles.choose_Checkbox_Read_With_Row_Number3();
		roles.choose_Checkbox_Read_With_Row_Number5();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2.Audit Log menu"
				+ " 3 tabs: " + "Modules " + "Mailbox - Auto Job ");
		administration.clickMenuAuditLog();

		if (audit.isMailboxDisplayed() == true && audit.isModulesDisplayed() == true
				&& audit.isJobAutoDisplayed() == true) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2.Audit Log menu"
					+ "3.  3 tabs: \" + \"Modules \" + \"Mailbox - Auto Job");
		} else {
			setStatusTest("fail", "User can NOT see/do : 1. Administration menu"
					+ "2.Audit Log menu 3.  2 tabs: \" + \"Modules \" + \"Mailbox - Auto job");
		}

		TestLogger.info("User CANNOT see/do"
				+ "1. Tab Authentication Logs \r\n with user A - user cannot see UnLocked button" + "2. Tab Auto Job ");

		if (audit.isAuthencationLogsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :2. tab Authentication Logs");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:2. tab Authentication Logs");
		}

		audit.openAutoJob();

		if (autoJob.isBtnEditDisplayed() == false) {
			setStatusTest("pass", " In tab Auto Job, cannot see Edit button");
		} else {
			setStatusTest("fail", " In tab Auto Job, STILL can see Edit button");
		}

	}

	@Test(priority = 5)
	public void TT_207() throws InterruptedException {
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
		UserRoleName = "Automation-AuditLog-AutoJob-Update" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row 3 ,4 ,5 ");
		roles.uncheck_All_Checkbox_Row_3();
		roles.uncheck_All_Checkbox_Row_4();
		roles.uncheck_All_Checkbox_Row_5();
		TestLogger.info("4. Check on Administration-Audit Log - AutoJob | Update");
		TestLogger.info("Choose only checkbox Update on Automation-Administration-AutoJob-Update");

		roles.choose_Checkbox_Read_With_Row_Number3();
		roles.choose_Checkbox_Update_With_Row_Number5();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:" + "1. Administration menu" + "2.Audit Log menu"
				+ " 3 tabs: " + "Modules " + "Mailbox - Auto Job ");
		administration.clickMenuAuditLog();

		if (audit.isMailboxDisplayed() == true && audit.isModulesDisplayed() == true
				&& audit.isJobAutoDisplayed() == true) {
			setStatusTest("pass", "User can see/do : 1. Administration menu" + "2.Audit Log menu"
					+ "3.  3 tabs: \" + \"Modules \" + \"Mailbox - Auto Job");
		} else {
			setStatusTest("fail", "User can NOT see/do : 1. Administration menu"
					+ "2.Audit Log menu 3.  2 tabs: \" + \"Modules \" + \"Mailbox - Auto job");
		}

		TestLogger.info("User CANNOT see/do"
				+ "1. Tab Authentication Logs \r\n with user A - user cannot see UnLocked button" + "2. Tab Auto Job ");

		if (audit.isAuthencationLogsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do :2. tab Authentication Logs");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:2. tab Authentication Logs");
		}

		audit.openAutoJob();

		if (autoJob.isBtnEditDisplayed() == true) {
			setStatusTest("pass", " In tab Auto Job, cannot see Edit button");
		} else {
			setStatusTest("fail", " In tab Auto Job, STILL can see Edit button");
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
