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
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_EmployeeList extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;

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

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_400() throws InterruptedException {
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

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();

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
		if (administration.isMenuEmployeeListDisplayed() == true) {
			setStatusTest("pass", "User can see :\r\n" + "+ Menu Employee List.");
		} else {
			setStatusTest("fail", "User can NOT see :\r\n" + "+ Menu Employee List.");
		}

		TestLogger.info("Open Employee List screen");
		administration.clickMenuEmployeeList();
		TestLogger.info("User can see /do:\r\n" + "1. Clickable on Employee name");

		if (employeeList.isLinkDetailOfEmployeeClickable() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Clickable on Employee name");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Employee name");
		}

		if (employeeList.isBtnCreateEmployeeDisplayed() == false && employeeList.isBtnIconDeleteDisplayed() == false
				&& employeeList.isBtnImportDataDisplayed() == false
						& employeeList.isLinkslOfSiteNameClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n"
					+ "3. Delete btn\r\n" + "4. clickable on Unit name/ site name");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n"
					+ "3. Delete btn\r\n" + "4. clickable on Unit name/ site name");
		}

	}

	@Test(priority = 2)
	public void TT_401() throws InterruptedException {
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
		UserRoleName = "Automation-Update Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		roles.check_Update_EmployeeInformation();

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
		if (administration.isMenuEmployeeListDisplayed() == true) {
			setStatusTest("pass", "User can see :\r\n" + "+ Menu Employee List.");
		} else {
			setStatusTest("fail", "User can NOT see :\r\n" + "+ Menu Employee List.");
		}

		TestLogger.info("Open Employee List screen");
		administration.clickMenuEmployeeList();
		TestLogger.info("User can see /do:\r\n" + "1. Clickable on Employee name");

		if (employeeList.isLinkDetailOfEmployeeClickable() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Clickable on Employee name");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Clickable on Employee name");
		}

		if (employeeList.isLinkslOfSiteNameClickable() == true && employeeList.isLinkslOfUnitNameClickable() == true) {
			setStatusTest("pass", "clickable on Unit name/ site name");
		} else {
			setStatusTest("fail", " CAN NOT clickable on Unit name/ site name");
		}

		if (employeeList.isBtnCreateEmployeeDisplayed() == false && employeeList.isBtnIconDeleteDisplayed() == false
				&& employeeList.isBtnImportDataDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n"
					+ "3. Delete btn\r\n" + "");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n"
					+ "3. Delete btn\r\n" + "");
		}

	}

	@Test(priority = 3)
	public void TT_402() throws InterruptedException {
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
		UserRoleName = "Automation-Delete Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		roles.check_Delete_Employees();

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
		if (administration.isMenuEmployeeListDisplayed() == true) {
			setStatusTest("pass", "User can see :\r\n" + "+ Menu Employee List.");
		} else {
			setStatusTest("fail", "User can NOT see :\r\n" + "+ Menu Employee List.");
		}

		TestLogger.info("Open Employee List screen");
		administration.clickMenuEmployeeList();
		TestLogger.info("User can see /do:\r\n" + "1. Clickable on Employee name");

		if (employeeList.isBtnIconDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Delete btn");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "2. Delete btn");
		}

		if (employeeList.isLinkslOfSiteNameClickable() == false) {
			setStatusTest("pass", "CAN NOT clickable on Unit name/ site name");
		} else {
			setStatusTest("fail", " STILL clickable on Unit name/ site name");
		}

		if (employeeList.isBtnCreateEmployeeDisplayed() == false && employeeList.isBtnImportDataDisplayed() == false) {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n" + "" + "");
		} else {
			setStatusTest("fail",
					"User STILL CAN see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n" + "" + "");
		}

	}

	@Test(priority = 4)
	public void TT_404() throws InterruptedException {
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
		UserRoleName = "Automation-Add Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		roles.check_Add_Employees();

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
		if (administration.isMenuEmployeeListDisplayed() == true) {
			setStatusTest("pass", "User can see :\r\n" + "+ Menu Employee List.");
		} else {
			setStatusTest("fail", "User can NOT see :\r\n" + "+ Menu Employee List.");
		}

		TestLogger.info("Open Employee List screen");
		administration.clickMenuEmployeeList();
		TestLogger.info("User can see /do:\r\n" + "1. Clickable on Employee name");

		if (employeeList.isBtnIconDeleteDisplayed() == false) {
			setStatusTest("pass", "User can NOT see /do:\r\n" + "2. Delete btn");
		} else {
			setStatusTest("fail", "User STILL can see /do:\r\n" + "2. Delete btn");
		}

		if (employeeList.isLinkslOfSiteNameClickable() == false) {
			setStatusTest("pass", "CAN NOT clickable on Unit name/ site name");
		} else {
			setStatusTest("fail", " STILL clickable on Unit name/ site name");
		}

		if (employeeList.isBtnCreateEmployeeDisplayed() == true && employeeList.isBtnImportDataDisplayed() == true) {
			setStatusTest("pass",
					"User CAN see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n" + "" + "");
		} else {
			setStatusTest("fail",
					"User STILL CAN see/do:\r\n" + "1. Create Employee btn\r\n" + "2. Import data btn\r\n" + "" + "");
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
