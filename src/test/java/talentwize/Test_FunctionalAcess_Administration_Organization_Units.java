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
import talentwize.pages.Form_UnitDetail;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Sites;
import talentwize.pages.Units;
import talentwize.pages.Users;

public class Test_FunctionalAcess_Administration_Organization_Units extends TestManager {

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
	Units units;
	Form_UnitDetail unitDetails;
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
		units = new Units(driver);
		unitDetails = new Form_UnitDetail(driver);
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

		TestLogger.info("4. Check on Administration - Organization - Units |");
		TestLogger.info("Choose only Check on Administration - Organization - Units | Read");
		roles.uncheck_All_Checkbox_Row_7();
		roles.choose_Checkbox_Read_With_Row_Number7();
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

		TestLogger.info("8. User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
				+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button. ");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuUnits();

		if (administration.isMenuUnitsDisplayed() == true && units.isButtonCollapseAllDisplayed() == true
				&& units.isButtonExportDisplayed() == true && units.isButtonShowUnitManagerDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
					+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button.");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
					+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button.");
		}

		TestLogger.info("User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");

		if (units.isButtonCreateDisplayed() == false && units.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		}

		units.clickOnUnitName(Units.UnitName);

		if (unitDetails.isMenuStep4Displayed() == true) {

			setStatusTest("pass", " Click on a Unit name >> the system shows Unit detail");

		} else {

			setStatusTest("fail", " Click on a Unit name >> the system DOES NOT show Unit detail");
		}

		unitDetails.clickMenuStep4();

		if (unitDetails.isButtonSaveDisplayed() == false) {
			unitDetails.clickButtonCancel();
			setStatusTest("pass", " Go to Step 4, cannot see Save button");

		} else {
			unitDetails.clickButtonCancel();
			setStatusTest("fail", " Go to Step 4, STILL see Save button");
		}

	}

	@Test(priority = 2)
	public void TT_158() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-Units|Create" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization - Units |");
		TestLogger.info("Choose only Check on Administration - Organization - Units|Create");
		roles.uncheck_All_Checkbox_Row_7();
		roles.choose_Checkbox_Create_With_Row_Number7();
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

		TestLogger.info("8. User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
				+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button. ");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuUnits();

		if (administration.isMenuUnitsDisplayed() == true && units.isButtonCollapseAllDisplayed() == true
				&& units.isButtonExportDisplayed() == true && units.isButtonShowUnitManagerDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
					+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button.");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
					+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button.");
		}

		TestLogger.info("User CAN see \r\n" + "1. (+) create  icon\r\n");

		if (units.isButtonCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see \r\n" + "1. (+) create  icon\r\n");
		} else {
			setStatusTest("fail", "User CAN NOT see \r\n" + "1. (+) create  icon\r\n" + "");
		}

		units.clickOnUnitName(Units.UnitName);

		if (unitDetails.isMenuStep4Displayed() == true) {

			setStatusTest("pass", " Click on a Unit name >> the system shows Unit detail");

		} else {

			setStatusTest("fail", " Click on a Unit name >> the system DOES NOT show Unit detail");
		}

		if (unitDetails.isQuickSaveDispalyed() == false) {
			setStatusTest("pass", "in Unit detail popup:\r\n" + "+ Cannot see Quick Save button");
		} else {
			setStatusTest("fail", "in Unit detail popup:\r\n" + "+ STILL Can see Quick Save button");
		}

		unitDetails.clickMenuStep4();

		if (unitDetails.isButtonSaveDisplayed() == false) {
			unitDetails.clickButtonCancel();
			setStatusTest("pass", " Go to Step 4, cannot see Save button");

		} else {
			unitDetails.clickButtonCancel();
			setStatusTest("fail", " Go to Step 4, STILL see Save button");
		}

	}

	@Test(priority = 3)
	public void TT_159() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-Units|Update" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization - Units |");
		TestLogger.info("Choose only Check on Administration - Organization - Units-Update");
		roles.uncheck_All_Checkbox_Row_7();
		roles.choose_Checkbox_Update_With_Row_Number7();
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

		TestLogger.info("8. User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
				+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button. ");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuUnits();

		if (administration.isMenuUnitsDisplayed() == true && units.isButtonCollapseAllDisplayed() == true
				&& units.isButtonExportDisplayed() == true && units.isButtonShowUnitManagerDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
					+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button.");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
					+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button.");
		}

		TestLogger.info("User CAN see \r\n" + "1. (+) create  icon\r\n");

		if (units.isButtonCreateDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see \r\n" + "1. (+) create  icon\r\n");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "");
		}

		if (units.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see \r\n" + "2.Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "2.Delete icon\r\n" + "");
		}

		units.clickOnUnitName(Units.UnitName);

		if (unitDetails.isMenuStep4Displayed() == true) {

			setStatusTest("pass", " Click on a Unit name >> the system shows Unit detail");

		} else {

			setStatusTest("fail", " Click on a Unit name >> the system DOES NOT show Unit detail");
		}

		if (unitDetails.isQuickSaveDispalyed() == true) {
			setStatusTest("pass", "in Unit detail popup:\r\n" + "+ Can see Quick Save button");
		} else {
			setStatusTest("fail", "in Unit detail popup:\r\n" + "+ Can NOT see Quick Save button");
		}

		unitDetails.clickMenuStep4();

		if (unitDetails.isButtonSaveDisplayed() == true) {
			unitDetails.clickButtonCancel();
			setStatusTest("pass", " Go to Step 4, can see Save button");

		} else {
			unitDetails.clickButtonCancel();
			setStatusTest("fail", " Go to Step 4, CAN NOT see Save button");
		}

	}

	@Test(priority = 4)
	public void TT_160() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-Units|Delete" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization - Units |");
		TestLogger.info("Choose only Check on Administration - Organization - Units-Delete");
		roles.uncheck_All_Checkbox_Row_7();
		roles.choose_Checkbox_Delete_With_Row_Number7();
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

		TestLogger.info(
				"8. User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n" + "3. Export button.\r\n"
						+ "4. Collapse button\r\n" + "5. Show Unit Manager button. " + "7. Delete icon");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuUnits();

		if (administration.isMenuUnitsDisplayed() == true && units.isButtonCollapseAllDisplayed() == true
				&& units.isButtonExportDisplayed() == true && units.isButtonShowUnitManagerDisplayed() == true
				&& units.isButtonDeleteDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
							+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button."
							+ "7. Delete icon");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Units menu\r\n"
							+ "3. Export button.\r\n" + "4. Collapse button\r\n" + "5. Show Unit Manager button."
							+ "7. Delete icon");
		}

		TestLogger.info("User CAN NOT see \r\n" + "1. (+) create  icon\r\n");

		if (units.isButtonCreateDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see \r\n" + "1. (+) create  icon\r\n");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "");
		}

		units.clickOnUnitName(Units.UnitName);

		if (unitDetails.isMenuStep4Displayed() == true) {

			setStatusTest("pass", " Click on a Unit name >> the system shows Unit detail");

		} else {

			setStatusTest("fail", " Click on a Unit name >> the system DOES NOT show Unit detail");
		}

		if (unitDetails.isQuickSaveDispalyed() == false) {
			setStatusTest("pass", "in Unit detail popup:\r\n" + "+ Can NOT see Quick Save button");
		} else {
			setStatusTest("fail", "in Unit detail popup:\r\n" + "+ STILL CAN see Quick Save button");
		}

		unitDetails.clickMenuStep4();

		if (unitDetails.isButtonSaveDisplayed() == false) {
			unitDetails.clickButtonCancel();
			setStatusTest("pass", " Go to Step 4, can not see Save button");

		} else {
			unitDetails.clickButtonCancel();
			setStatusTest("fail", " Go to Step 4, STILL CAN see Save button");
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
