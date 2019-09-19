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
import talentwize.pages.HomePage;
import talentwize.pages.LeaveCalendar;
import talentwize.pages.RequestDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAcess_Leave_Calendar extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	LeaveCalendar leaveCalendar;
	RequestDetails requestDetails;

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
		leaveCalendar = new LeaveCalendar(driver);
		requestDetails = new RequestDetails(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_208() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Calendar|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row Leave ,Row 38 ");
		roles.click_uncheck_Read_On_Row(38);

		TestLogger.info("4. Check on Administration - Leave-Calendar|Read");
		TestLogger.info("Choose only checkbox Read on Automation - Leave - Calendar | Read");

		roles.choose_Checkbox_Read__With_Row_Number(38);
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
		administration.clickMenuLeave();
		administration.clickSubMenuLeaveCalendar();
		if (leaveCalendar.isTitleLeaveCalendarDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Leave calendar menu");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Leave calendar menu");
		}

	}

	@Test(priority = 2)
	public void TT_209() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Calendar|No permission Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Leave - Calendar | Read\r\n" + "+ Unchecked on \r\n"
				+ "Leave - Calendar - Colleague's leave | Read ");
		roles.checkbox_unRead_Leave_Calendar();
		roles.checkbox_unRead_Leave_Calendar_Colleague();

		TestLogger.info("4. Check on Administration - Leave-Calendar|No permission Read");
		TestLogger.info("Choose only checkbox Read on Automation - Leave - Calendar | No permission Read");

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
		administration.clickMenuLeave();
		if (administration.isSubMenuLeaveCalendarDisplayed() == false) {
			setStatusTest("pass", "this menu is not appeared.");
		} else {
			setStatusTest("fail", "this menu is Still appeared.");
		}

	}

	@Test(priority = 3)
	public void TT_211() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Calendar-Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info(
				"Check on\r\n" + "+ Leave - Calendar - Colleague's leave | Read\r\n" + "+ Leave - Calendar | Read");

		TestLogger.info(
				"4. Check on\r\n" + "+ Leave - Calendar - Colleague's leave | Read\r\n" + "+ Leave - Calendar | Read");

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
		administration.clickMenuLeave();
		administration.clickSubMenuLeaveCalendar();

		if (administration.isSubMenuLeaveCalendarDisplayed() == true) {
			setStatusTest("pass", "User can see Leave-Calendar menu");
		} else {
			setStatusTest("fail", "User can NOT see Leave-Calendar menu");
		}

		leaveCalendar.chooseReportToAll();

		if (leaveCalendar.isLinkOfRequestLeaveClickable() == true) {
			leaveCalendar.clickOnFistLinkOfRequestLeave();
			if (requestDetails.isBtnRequestListDisplayed() == true) {
				setStatusTest("pass", "User can see leave request of B");
			} else {
				setStatusTest("fail", "User can NOT see leave request of B");
			}
		} else {
			setStatusTest("fail", "Can Not click on links of Request leave");
		}

	}

	@Test(priority = 4)
	public void TT_215() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Calendar-Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info(
				"Check on\r\n" + "+ Leave - Calendar - Colleague's leave | Read\r\n" + "+ Leave - Calendar | Read");

		TestLogger.info("4. Check on\r\n" + "+ Leave - Calendar - Colleague's leave | Read\r\n"
				+ "+ Leave - Calendar | NO Read Permision");
		roles.checkbox_unRead_Leave_Calendar_Colleague();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW2());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW2(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW2(), propertyManager.getPasswordUserTW2());
		administration.clickMenuLeave();
		administration.clickSubMenuLeaveCalendar();

		if (administration.isSubMenuLeaveCalendarDisplayed() == true) {
			setStatusTest("pass", "User can see Leave-Calendar menu");
		} else {
			setStatusTest("fail", "User can NOT see Leave-Calendar menu");
		}

		leaveCalendar.chooseReportToAll();

		if (leaveCalendar.isLinkOfRequestLeaveClickable() == false) {
			setStatusTest("pass", "User cannot see details of leave request of B");
		} else {
			setStatusTest("fail", "User Still can see details of leave request of B");
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
