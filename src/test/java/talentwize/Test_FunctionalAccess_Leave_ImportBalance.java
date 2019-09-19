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
import talentwize.pages.Roles;
import talentwize.pages.TabLeaveBalance;
import talentwize.pages.TabLeavePolicy;
import talentwize.pages.TabLeaveType;
import talentwize.pages.TabManagementConfiguration;
import talentwize.pages.TabPublicHoliday;
import talentwize.pages.TabWorkingDays;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Leave_ImportBalance extends TestManager {
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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_339() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-ImportBalance|Read" + TienIch.taoRandomSo(1);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row Leave ,Row 37 : Import Balance - Configuration ");

		roles.click_Uncheckbox_Leave_ImportBalance();
		roles.choose_Checkbox_Read_Leave_ImportBalance();

		TestLogger.info("4. Check on Check on\r\n" + "+ Leave - Import Balance | Read");
		TestLogger.info("Choose only checkbox Read on Automation - Leave - Import Balance | Read");

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
		administration.clickSubMenuBalanceList();
		TestLogger.info("Click on Tools button ");
		balanceList.clickButtonDropTool();

		if (balanceList.isOptionImportBalanceDisplayed() == true) {
			setStatusTest("pass", "User can see Import Balance button");
		} else {
			setStatusTest("fail", "User can NOT see Import Balance button");
		}
	}

	@Test(priority = 2)
	public void TT_338() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-ImportBalance|Read" + TienIch.taoRandomSo(1);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row Leave ,Row 37 : Import Balance - Configuration ");

		roles.click_Uncheckbox_Leave_ImportBalance();

		TestLogger.info("4. UnCheck on Check on\r\n" + "+ Leave - Import Balance | Read");

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
		administration.clickSubMenuBalanceList();
		TestLogger.info("Click on Tools button ");
		balanceList.clickButtonDropTool();

		if (balanceList.isOptionImportBalanceDisplayed() == false) {
			setStatusTest("pass", "User can NOT see Import Balance button");
		} else {
			setStatusTest("fail", "User STILL see Import Balance button");
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
