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
import talentwize.pages.Form_Delegate;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Sites;
import talentwize.pages.Users;

public class Test_FunctionalAcess_Administration_Organization_Sites extends TestManager {

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
	Sites sites;
	String UserRoleName;
	Form_Delegate formDelegate;

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
		sites = new Sites(driver);
		formDelegate = new Form_Delegate(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_157() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-Units|Read" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization -Sites-");
		TestLogger.info("Choose only Check on Administration - Organization - Users-Read");

		roles.choose_Checkbox_Read_With_Row_Number6();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Sites menu\r\n" + "3. Manage button. ");
		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuSites();

		if (administration.isMenuSitesDisplayed() == true && sites.isBtnManageDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n" + "3. Manage button.");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n"
					+ "3. Manage button.");
		}

		TestLogger.info("User CANNOT see \r\n" + "1. Create button\r\n" + "2. Delete button\r\n"
				+ "3. click on Manage button to open Popup, user cannot see Save button in this popup");

		if (sites.isBtnCreateDisplayed() == false && sites.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see \r\n" + "1. Create button\r\n" + "2. Delete button\r\n" + "");
		} else {
			setStatusTest("fail", "User Still can see \r\n" + "1. Create button\r\n" + "2. Delete button\r\n" + "");
		}

		sites.clickBtnManage();

		if (formDelegate.isBtnSaveDisplayed() == false) {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();
			setStatusTest("pass", " click on Manage button to open Popup, user cannot see Save button in this popup");
		} else {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();
			setStatusTest("fail",
					" click on Manage button to open Popup, user STILL can see Save button in this popup");
		}

	}

	@Test(priority = 2)
	public void TT_154() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-Sites|Create" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization -Sites-");
		TestLogger.info("Choose only Check on Administration - Organization - Sites-Create");

		roles.choose_Checkbox_Create_With_Row_Number6();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Sites menu\r\n" + "3. Manage button." + "4. Create button  ");
		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuSites();

		if (administration.isMenuSitesDisplayed() == true && sites.isBtnManageDisplayed() == true
				&& sites.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n"
					+ "3. Manage button." + "4. Create button");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n"
					+ "3. Manage button." + "4. Create button");
		}

		TestLogger.info("User CANNOT see \r\n" + "2. Delete button\r\n"
				+ "3. click on Manage button to open Popup, user cannot see Save button in this popup");

		if (sites.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see \r\n" + "2. Delete button\r\n" + "");
		} else {
			setStatusTest("fail", "User Still can see \r\n" + "2. Delete button\r\n" + "");
		}

		sites.clickBtnManage();

		if (formDelegate.isBtnSaveDisplayed() == false) {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();

			setStatusTest("pass", " click on Manage button to open Popup, user cannot see Save button in this popup");
		} else {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();

			setStatusTest("fail",
					" click on Manage button to open Popup, user STILL can see Save button in this popup");
		}

	}

	@Test(priority = 3)
	public void TT_155() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-Sites|Update" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization -Sites");
		TestLogger.info("Choose only Check on Administration - Organization - Sites-Update");

		roles.choose_Checkbox_Update_With_Row_Number6();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Sites menu\r\n" + "3. Manage button." + "4. Create button  ");
		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuSites();

		if (administration.isMenuSitesDisplayed() == true && sites.isBtnManageDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n" + "3. Manage button.");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n"
					+ "3. Manage button.");
		}

		TestLogger.info("User CANNOT see \r\n" + "1. Create button\r\n" + "2. Delete button");

		if (sites.isIconDeleteDisplayed() == false && sites.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see \r\n" + "1. Create button\r\n" + "2. Delete button");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. Create button\r\n" + "2. Delete button");
		}

		sites.clickBtnManage();

		if (formDelegate.isBtnSaveDisplayed() == false) {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();

			setStatusTest("pass", " click on Manage button to open Popup, user cannot see Save button in this popup");
		} else {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();

			setStatusTest("fail",
					" click on Manage button to open Popup, user STILL can see Save button in this popup");
		}

	}

	@Test(priority = 4)
	public void TT_156() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-Sites|Delete" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization -Sites");
		TestLogger.info("Choose only Check on Administration - Organization - Sites-Delete");

		roles.choose_Checkbox_Delete_With_Row_Number6();
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

		TestLogger.info("8. Veryfy Permission : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Sites menu\r\n" + "3. Manage button." + "4. Delete button  ");
		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuSites();

		if (administration.isMenuSitesDisplayed() == true && sites.isBtnManageDisplayed() == true
				&& sites.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n"
					+ "3. Manage button.\r\n" + "4. Delete button");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Sites menu\r\n"
					+ "3. Manage button.4. Delete button");
		}

		TestLogger.info("User CANNOT see \r\n" + "1. Create button\r\n" + "");

		if (sites.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see \r\n" + "1. Create button\r\n" + "");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. Create button\r\n" + "");
		}

		sites.clickBtnManage();

		if (formDelegate.isBtnSaveDisplayed() == false) {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();

			setStatusTest("pass", " click on Manage button to open Popup, user cannot see Save button in this popup");
		} else {
			if (formDelegate.isBtnCloseDisplayed() == true)
				formDelegate.cliclBtnClose();

			setStatusTest("fail",
					" click on Manage button to open Popup, user STILL can see Save button in this popup");
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
