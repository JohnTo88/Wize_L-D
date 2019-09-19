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
import talentwize.pages.BroadcastMessage;
import talentwize.pages.ChartSettings;
import talentwize.pages.CustomFields;
import talentwize.pages.Dashboard;
import talentwize.pages.Domain;
import talentwize.pages.Form_AddDomain;
import talentwize.pages.Form_CreateCustomField;
import talentwize.pages.Form_Delegate;
import talentwize.pages.Form_EditCategory;
import talentwize.pages.Form_EditJobTitle;
import talentwize.pages.Form_EditLevel;
import talentwize.pages.Form_EditMentors;
import talentwize.pages.Form_UnitDetail;
import talentwize.pages.Form_UpdateBroadcast;
import talentwize.pages.Form_UpdateCustomField;
import talentwize.pages.Form_UpdateDomain;
import talentwize.pages.HomePage;
import talentwize.pages.JobCategory;
import talentwize.pages.JobLevel;
import talentwize.pages.JobTitle;
import talentwize.pages.MentorConfigure;
import talentwize.pages.NotificationConfiguration;
import talentwize.pages.Roles;
import talentwize.pages.SelectInputs;
import talentwize.pages.Sites;
import talentwize.pages.TabModuleMappings;
import talentwize.pages.Units;
import talentwize.pages.Users;

public class Test_FunctionalAcess_Administration_Configuration_Charts extends TestManager {
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
	JobTitle jobTitle;
	JobLevel jobLevel;
	JobCategory jobCategory;
	BroadcastMessage broadcastMessage;
	MentorConfigure mentorConfig;
	CustomFields customFields;
	NotificationConfiguration notificationConfig;
	Domain domain;
	Form_EditJobTitle formEditJobTile;
	Form_EditCategory formEditCategory;
	Form_EditLevel formEditLevel;
	Form_UnitDetail unitDetails;
	Form_UpdateDomain formUpdateDomain;
	Form_EditMentors formEditMentor;
	Form_UpdateCustomField formUpdateCustomField;
	Form_AddDomain formDomain;
	Form_UpdateBroadcast fromUpdateBoardcast;
	Form_CreateCustomField formCreateCustomField;
	ChartSettings chartSettings;
	TabModuleMappings tabModuleMappings;
	String UserRoleName;
	Form_Delegate formDelegate;
	SelectInputs selectInput;
	String nameOfDomain = "";
	String nameOfCustomField = "";

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
		jobTitle = new JobTitle(driver);
		jobLevel = new JobLevel(driver);
		formEditMentor = new Form_EditMentors(driver);
		formUpdateCustomField = new Form_UpdateCustomField(driver);
		formCreateCustomField = new Form_CreateCustomField(driver);
		chartSettings = new ChartSettings(driver);
		tabModuleMappings = new TabModuleMappings(driver);

		jobCategory = new JobCategory(driver);
		customFields = new CustomFields(driver);

		units = new Units(driver);
		fromUpdateBoardcast = new Form_UpdateBroadcast(driver);
		mentorConfig = new MentorConfigure(driver);
		domain = new Domain(driver);
		selectInput = new SelectInputs(driver);
		unitDetails = new Form_UnitDetail(driver);
		notificationConfig = new NotificationConfiguration(driver);
		formDelegate = new Form_Delegate(driver);
		formEditJobTile = new Form_EditJobTitle(driver);
		formEditCategory = new Form_EditCategory(driver);
		formUpdateDomain = new Form_UpdateDomain(driver);
		formDomain = new Form_AddDomain(driver);
		broadcastMessage = new BroadcastMessage(driver);
		formEditLevel = new Form_EditLevel(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_199() throws InterruptedException {
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
		UserRoleName = "Administration-Configuration-Charts-Read" + TienIch.taoRandomSovaChu(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration -Charts\r\n" + " | Read");
		TestLogger.info("Choose only Check on Administration - Configuration - Charts\r\n" + " | Read");
		roles.uncheck_All_Checkbox_Row_17();// 17
		roles.choose_Checkbox_Read_With_Row_Number17();
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

		administration.clickMenuAdministration();
		administration.clickMenuConfiguration();
		administration.clickSubMenuCharts();
		///
		TestLogger
				.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
						+ "3. Chart menu\r\n" + "+ Module List  tab\r\n" + "+ Module Mappings tab");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuChartsDisplayed() == true && chartSettings.isTabModuleListDisplayed() == true
				&& chartSettings.isTabModuleMappingsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Chart menu\r\n" + "+ Module List  tab\r\n" + "+ Module Mappings tab");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\r\n" + "1. Administration menu\r\n"
							+ "2. Configuration menu\r\n" + "3. Chart menu\r\n" + "+ Module List  tab\r\n"
							+ "+ Module Mappings tab");
		}

		TestLogger.info("CANNOT see/do\r\n" + "1. Open Module Mappings tab, user cannot ON/OFF chart");
		chartSettings.openTabModuleMappings();
		tabModuleMappings.clickRole_Row1();

		if (tabModuleMappings.isOption_ON_OFF_Displayed() == false) {
			setStatusTest("pass", "user cannot ON/OFF chart");
		} else {
			setStatusTest("fail", "user STILL CAN ON/OFF chart");
		}

	}

	@Test(priority = 2)
	public void TT_200() throws InterruptedException {
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
		UserRoleName = "Administration-Configuration-Charts-Update" + TienIch.taoRandomSovaChu(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration -Charts\r\n" + " | Update");
		TestLogger.info("Choose only Check on Administration - Configuration - Charts\r\n" + " | Update");
		roles.uncheck_All_Checkbox_Row_17();// 17
		roles.choose_Checkbox_Update_With_Row_Number17();
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

		administration.clickMenuAdministration();
		administration.clickMenuConfiguration();
		administration.clickSubMenuCharts();
		///
		TestLogger
				.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
						+ "3. Chart menu\r\n" + "+ Module List  tab\r\n" + "+ Module Mappings tab");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuChartsDisplayed() == true && chartSettings.isTabModuleListDisplayed() == true
				&& chartSettings.isTabModuleMappingsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Chart menu\r\n" + "+ Module List  tab\r\n" + "+ Module Mappings tab");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\r\n" + "1. Administration menu\r\n"
							+ "2. Configuration menu\r\n" + "3. Chart menu\r\n" + "+ Module List  tab\r\n"
							+ "+ Module Mappings tab");
		}

		TestLogger.info("CANNOT see/do\r\n" + "1. Open Module Mappings tab, user cannot ON/OFF chart");
		chartSettings.openTabModuleMappings();
		tabModuleMappings.clickRole_Row1();

		if (tabModuleMappings.isOption_ON_OFF_Displayed() == true) {
			setStatusTest("pass", "user CAN ON/OFF chart");
		} else {
			setStatusTest("fail", "user CAN NOT ON/OFF chart");
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
