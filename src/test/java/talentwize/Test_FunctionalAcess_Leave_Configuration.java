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
import talentwize.pages.LeaveConfigurations;
import talentwize.pages.Roles;
import talentwize.pages.TabLeaveBalance;
import talentwize.pages.TabLeavePolicy;
import talentwize.pages.TabLeaveType;
import talentwize.pages.TabManagementConfiguration;
import talentwize.pages.TabPublicHoliday;
import talentwize.pages.TabWorkingDays;
import talentwize.pages.Users;

public class Test_FunctionalAcess_Leave_Configuration extends TestManager {

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
	public void TT_220() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Configuration|Read" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row Leave ,Row 36 : Leave - Configuration ");
		roles.click_Uncheckbox_Leave_Configurations();
		roles.choose_Checkbox_Read_Leave_Configurations();

		TestLogger.info("4. Check on Check on\r\n" + "+ Leave - Configuration | Read");
		TestLogger.info("Choose only checkbox Read on Automation - Leave - Configuration | Read");

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
		administration.clickSubMenuLeaveSettings();

		if (leaveConfigurations.isTabManagementConfigurationDisplayed() == true
				&& leaveConfigurations.isTabLeaveTypeDisplayed() == true
				&& leaveConfigurations.isTabLeavePolicyDisplayed() == true
				&& leaveConfigurations.isTabLeaveBalanceDisplayed() == true
				&& leaveConfigurations.isTabPublicHolidayDisplayed() == true
				&& leaveConfigurations.isTabWorkingDaysDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		} else {
			setStatusTest("fail",
					"User can NOT see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		}

		TestLogger.info("User cannot see/do\r\n" + "1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
				+ "+ Clickable on Site name\r\n" + "+ Delete button\r\n" + "2. In Leave Type tab :\r\n"
				+ "+ Add button\r\n" + "+ Clickable on Leave Type name \r\n" + "+ Delete button\r\n"
				+ "3. In Leave Policy tab\r\n" + "+ Add button\r\n" + "+ Clickable on Leave Policy name \r\n"
				+ "+ Delete button\r\n" + "4. In Leave Balance tab\r\n" + "+ Add button\r\n"
				+ "+ Clickable on Leave Balance name \r\n" + "+ Delete button\r\n" + "5. In Public Holiday tab\r\n"
				+ "+ Add button\r\n" + "+ Clickable on Public Holiday name \r\n" + "+ Delete button \r\n"
				+ "6. In Working Days tab\r\n" + "+ Add button\r\n" + "+ Clickable on Working name \r\n"
				+ "+ Delete button\r\n" + "\r\n" + "");

		leaveConfigurations.openTabManagementConfiguration();
		if (tabManagementConfig.isBtnAddDisplayed() == false && tabManagementConfig.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveType();
		if (tabLeaveType.isBtnAddDisplayed() == false && tabLeaveType.isIconDeleteDisplayed() == false
				&& tabLeaveType.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveBalance();

		if (tabLeaveBalance.isBtnAddDisplayed() == false && tabLeaveBalance.isIconDeleteDisplayed() == false
				&& tabLeaveBalance.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabPublicHoliday();

		if (tabPublicHoliday.isBtnAddIsNotDisplayed() == true && tabPublicHoliday.isIconDeleteDisplayed() == false
				&& tabPublicHoliday.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabWorkingDays();
		if (tabWorkingDays.isBtnAddIsNotDisplayed() == true && tabWorkingDays.isIconDeleteDisplayed() == false
				&& tabWorkingDays.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ Add button\r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}
	}

	@Test(priority = 2)
	public void TT_327() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Configuration|Create" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row Leave ,Row 36 : Leave - Configuration ");
		roles.click_Uncheckbox_Leave_Configurations();

		roles.choose_Checkbox_Create_Leave_Configurations();

		TestLogger.info("4. Check on Check on\r\n" + "+ Leave - Configuration | Create");
		TestLogger.info("Choose only checkbox Read on Automation - Leave - Configuration | Create");

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
		administration.clickSubMenuLeaveSettings();

		if (leaveConfigurations.isTabManagementConfigurationDisplayed() == true
				&& leaveConfigurations.isTabLeaveTypeDisplayed() == true
				&& leaveConfigurations.isTabLeavePolicyDisplayed() == true
				&& leaveConfigurations.isTabLeaveBalanceDisplayed() == true
				&& leaveConfigurations.isTabPublicHolidayDisplayed() == true
				&& leaveConfigurations.isTabWorkingDaysDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		} else {
			setStatusTest("fail",
					"User can NOT see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		}

		TestLogger.info("User cannot see/do\r\n" + "1. In Management Configuration tab :\r\n" + "+ \r\n"
				+ "+ Clickable on Site name\r\n" + "+ Delete button\r\n" + "2. In Leave Type tab :\r\n" + "+ \r\n"
				+ "+ Clickable on Leave Type name \r\n" + "+ Delete button\r\n" + "3. In Leave Policy tab\r\n"
				+ "+ \r\n" + "+ Clickable on Leave Policy name \r\n" + "+ Delete button\r\n"
				+ "4. In Leave Balance tab\r\n" + "+ \r\n" + "+ Clickable on Leave Balance name \r\n"
				+ "+ Delete button\r\n" + "5. In Public Holiday tab\r\n" + "+ Add button\r\n"
				+ "+ Clickable on Public Holiday name \r\n" + "+ Delete button \r\n" + "6. In Working Days tab\r\n"
				+ "+ \r\n" + "+ Clickable on Working name \r\n" + "+ Delete button\r\n" + "\r\n" + "");

		leaveConfigurations.openTabManagementConfiguration();

		if (tabManagementConfig.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabManagementConfig.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ "
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveType();
		if (tabLeaveType.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabLeaveType.isIconDeleteDisplayed() == false && tabLeaveType.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveBalance();

		if (tabLeaveBalance.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabLeaveBalance.isIconDeleteDisplayed() == false
				&& tabLeaveBalance.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabPublicHoliday();

		if (tabPublicHoliday.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabPublicHoliday.isIconDeleteDisplayed() == false
				&& tabPublicHoliday.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabWorkingDays();
		if (tabWorkingDays.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}
		if (tabWorkingDays.isIconDeleteDisplayed() == false
				&& tabWorkingDays.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}
	}

	@Test(priority = 3)
	public void TT_328() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Configuration|Update" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row Leave ,Row 36 : Leave - Configuration ");
		roles.click_Uncheckbox_Leave_Configurations();

		roles.choose_Checkbox_Update_Leave_Configurations();

		TestLogger.info("4. Check on Check on\r\n" + "+ Leave - Configuration | Update");
		TestLogger.info("Choose only checkbox Read on Automation - Leave - Configuration | Update");

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
		administration.clickSubMenuLeaveSettings();

		if (leaveConfigurations.isTabManagementConfigurationDisplayed() == true
				&& leaveConfigurations.isTabLeaveTypeDisplayed() == true
				&& leaveConfigurations.isTabLeavePolicyDisplayed() == true
				&& leaveConfigurations.isTabLeaveBalanceDisplayed() == true
				&& leaveConfigurations.isTabPublicHolidayDisplayed() == true
				&& leaveConfigurations.isTabWorkingDaysDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		} else {
			setStatusTest("fail",
					"User can NOT see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		}

		TestLogger.info("User can see/do\r\n" + "1. Leave setting menu\r\n" + "2. 6 tabs:\r\n"
				+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n" + "Leave Balance\r\n"
				+ "Public Holiday\r\n" + "Working Days\r\n" + "3. In Management Configuration tab :\r\n"
				+ "+ Clickable on Site name\r\n" + "4. In Leave Type tab :\r\n" + "+ Clickable on Leave Type name \r\n"
				+ "5. In Leave Policy tab\r\n" + "+ Clickable on Leave Policy name \r\n" + "6. In Leave Balance tab\r\n"
				+ "+ Clickable on Leave Balance name \r\n" + "7. In Public Holiday tab\r\n"
				+ "+ Clickable on Public Holiday name \r\n" + "6. In Working Days tab\r\n"
				+ "+ Clickable on Working name");

		leaveConfigurations.openTabManagementConfiguration();

		if (tabManagementConfig.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabManagementConfig.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ "
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveType();
		if (tabLeaveType.IsLinksOfNamePolicyListClickable() == true) {
			setStatusTest("pass", "Clickable on Leave Type name ");
		} else {
			setStatusTest("fail", "Can not Clickable on Leave Type name ");
		}

		if (tabLeaveType.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabLeaveType.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveBalance();

		if (tabLeaveBalance.IsLinksOfNamePolicyListClickable() == true) {
			setStatusTest("pass", "Clickable on Leave Balance name ");
		} else {
			setStatusTest("fail", "Can not Clickable on Leave Balance name ");
		}

		if (tabLeaveBalance.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabLeaveBalance.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabPublicHoliday();

		if (tabPublicHoliday.IsLinksOfNamePolicyListClickable() == true) {
			setStatusTest("pass", "Clickable on public Holiday name ");
		} else {
			setStatusTest("fail", "Can not Clickable on public Holiday name ");
		}

		if (tabPublicHoliday.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabPublicHoliday.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabWorkingDays();

		if (tabWorkingDays.IsLinksOfNamePolicyListClickable() == true) {
			setStatusTest("pass", "Clickable on Working day name ");
		} else {
			setStatusTest("fail", "Can not Clickable on Working day name ");
		}
		if (tabWorkingDays.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabWorkingDays.isIconDeleteDisplayed() == false) {
			setStatusTest("pass", " User can not see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}
	}

	@Test(priority = 4)
	public void TT_333() throws InterruptedException {
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
		UserRoleName = "Automation-Leave-Configuration|Update" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Uncheck All Checkbox on Row Leave ,Row 36 : Leave - Configuration ");
		roles.click_Uncheckbox_Leave_Configurations();

		roles.choose_Checkbox_Delete_Leave_Configurations();

		TestLogger.info("4. Check on Check on\r\n" + "+ Leave - Configuration | Delete");
		TestLogger.info("Choose only checkbox Read on Automation - Leave - Configuration | Delete");

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
		administration.clickSubMenuLeaveSettings();

		if (leaveConfigurations.isTabManagementConfigurationDisplayed() == true
				&& leaveConfigurations.isTabLeaveTypeDisplayed() == true
				&& leaveConfigurations.isTabLeavePolicyDisplayed() == true
				&& leaveConfigurations.isTabLeaveBalanceDisplayed() == true
				&& leaveConfigurations.isTabPublicHolidayDisplayed() == true
				&& leaveConfigurations.isTabWorkingDaysDisplayed() == true) {
			setStatusTest("pass",
					"User can see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		} else {
			setStatusTest("fail",
					"User can NOT see/do\r\n" + "1.  Leave setting menu\r\n" + "2. 6 tabs:\r\n"
							+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n"
							+ "Leave Balance\r\n" + "Public Holiday\r\n" + "Working Days");
		}

		TestLogger.info("User can see/do\r\n" + "1. Leave setting menu\r\n" + "2. 6 tabs:\r\n"
				+ "Management Configuration\r\n" + "Leave Type\r\n" + "Leave Policy\r\n" + "Leave Balance\r\n"
				+ "Public Holiday\r\n" + "Working Days\r\n" + "3. In Management Configuration tab :\r\n"
				+ "+ Clickable on Site name\r\n" + "4. In Leave Type tab :\r\n" + "+ Clickable on Leave Type name \r\n"
				+ "5. In Leave Policy tab\r\n" + "+ Clickable on Leave Policy name \r\n" + "6. In Leave Balance tab\r\n"
				+ "+ Clickable on Leave Balance name \r\n" + "7. In Public Holiday tab\r\n"
				+ "+ Clickable on Public Holiday name \r\n" + "6. In Working Days tab\r\n"
				+ "+ Clickable on Working name");

		leaveConfigurations.openTabManagementConfiguration();

		if (tabManagementConfig.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabManagementConfig.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", " User can see/do 1. In Management Configuration tab :\r\n" + "+ "
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User NOT see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveType();
		if (tabLeaveType.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", "Clickable on Leave Type name ");
		} else {
			setStatusTest("fail", "Can not Clickable on Leave Type name ");
		}

		if (tabLeaveType.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabLeaveType.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", " User can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can NOT see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabLeaveBalance();

		if (tabLeaveBalance.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", "Clickable on Leave Balance name ");
		} else {
			setStatusTest("fail", "Can not Clickable on Leave Balance name ");
		}

		if (tabLeaveBalance.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabLeaveBalance.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", " User can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can NOT see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabPublicHoliday();

		if (tabPublicHoliday.IsLinksOfNamePolicyListClickable() == false) {
			setStatusTest("pass", "Clickable on public Holiday name ");
		} else {
			setStatusTest("fail", "Can not Clickable on public Holiday name ");
		}

		if (tabPublicHoliday.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabPublicHoliday.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", " User can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can NOT see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		}

		leaveConfigurations.openTabWorkingDays();

		if (tabWorkingDays.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "See Add button");
		} else {
			setStatusTest("fail", "Does not Add button");
		}

		if (tabWorkingDays.isIconDeleteDisplayed() == true) {
			setStatusTest("pass", " User can see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail", "User STILL can NOT see/do 1. In Management Configuration tab :\r\n" + "+ \r\n"
					+ "+ Clickable on Site name\r\n" + "+ Delete button");
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
