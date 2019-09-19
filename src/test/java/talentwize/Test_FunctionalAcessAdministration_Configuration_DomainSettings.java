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
import talentwize.pages.Domain;
import talentwize.pages.Form_AddDomain;
import talentwize.pages.Form_Delegate;
import talentwize.pages.Form_EditCategory;
import talentwize.pages.Form_EditJobTitle;
import talentwize.pages.Form_EditLevel;
import talentwize.pages.Form_UnitDetail;
import talentwize.pages.Form_UpdateDomain;
import talentwize.pages.HomePage;
import talentwize.pages.JobCategory;
import talentwize.pages.JobLevel;
import talentwize.pages.JobTitle;
import talentwize.pages.Roles;
import talentwize.pages.Sites;
import talentwize.pages.Units;
import talentwize.pages.Users;

public class Test_FunctionalAcessAdministration_Configuration_DomainSettings extends TestManager {

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
	Domain domain;
	Form_EditJobTitle formEditJobTile;
	Form_EditCategory formEditCategory;
	Form_EditLevel formEditLevel;
	Form_UnitDetail unitDetails;
	Form_UpdateDomain formUpdateDomain;
	Form_AddDomain formDomain;
	String UserRoleName;
	Form_Delegate formDelegate;
	String nameOfDomain = "";

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
		jobCategory = new JobCategory(driver);
		units = new Units(driver);
		domain = new Domain(driver);
		unitDetails = new Form_UnitDetail(driver);
		formDelegate = new Form_Delegate(driver);
		formEditJobTile = new Form_EditJobTitle(driver);
		formEditCategory = new Form_EditCategory(driver);
		formUpdateDomain = new Form_UpdateDomain(driver);
		formDomain = new Form_AddDomain(driver);
		formEditLevel = new Form_EditLevel(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_169() throws InterruptedException {
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
		UserRoleName = "Administration-Configuration-DefaulSetting-Read" + TienIch.taoRandomSovaChu(3);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration - Domain Settings | Read");
		TestLogger.info("Choose only Check on Administration - Configuration - Domain Settings | Read");
		roles.uncheck_All_Checkbox_Row_10();
		roles.choose_Checkbox_Read_With_Row_Number10();
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
		administration.clickSubMenuDomain();

		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Domain menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuDomainDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Domain menu");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Domain menu");
		}

		if (domain.isBtnAddDisplayed() == false && domain.isBtnDeleteDisplayed() == false
				&& domain.isLinkofDomainsClickable() == false) {
			setStatusTest("pass", "1. Add button\r\n" + "2. Delete button\r\n"
					+ "3.  cannot click in Domain name to open edit screen\r\n" + "");
		} else {
			setStatusTest("fail", "User STILL CAN see/do\r\n" + "1. Add button\r\n" + "2. Delete button\r\n"
					+ "3.  cannot click in Domain name to open edit screen\r\n" + "");
		}

		if (domain.isCheckboxsOfDomainClickable() == false) {
			setStatusTest("pass", "4. cannot click on radio button");
		} else {
			setStatusTest("fail", "4. STILL can click on radio button");
		}

	}

	@Test(priority = 2)
	public void TT_170() throws InterruptedException {
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
		UserRoleName = "Administration_Configuration_Domain_Create" + TienIch.taoRandomSovaChu(3);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration - Domain Settings| reate");
		TestLogger.info("Choose only Check on Administration - Configuration - Domain Settings|Create");
		roles.uncheck_All_Checkbox_Row_10();
		roles.choose_Checkbox_Create_With_Row_Number10();
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
		administration.clickSubMenuDomain();

		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Domain menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuDomainDisplayed() == true && domain.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Domain menu 4. Add button");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Domain menu .4. Add button");
		}

		if (domain.isBtnDeleteDisplayed() == false && domain.isLinkofDomainsClickable() == false
				&& domain.isCheckboxsOfDomainClickable() == false) {
			setStatusTest("pass", "CANNOT see/do\r\n" + "+ Delete button\r\n"
					+ "+  cannot click in Domain name to open edit screen\r\n" + "+ cannot click on radio button");
		} else {
			setStatusTest("fail", "STILL CAN see/do\r\n" + "+ Delete button\r\n"
					+ "+  cannot click in Domain name to open edit screen\r\n" + "+ cannot click on radio button" + "");
		}

		nameOfDomain = TienIch.taoRandomChu(6) + ".com";
		if (domain.isBtnAddDisplayed() == true) {
			domain.clickButtonAdd();
			formDomain.fillDomain(nameOfDomain);
			formDomain.clickButtonAdd();

		}

	}

	@Test(priority = 3)
	public void TT_171() throws InterruptedException {
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
		UserRoleName = "Administration_Configuration_DomainSetting_Update" + TienIch.taoRandomSo(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration - Domain Settings| Update");
		TestLogger.info("Choose only Check on Administration - Configuration - Domain Settings|Update");
		roles.uncheck_All_Checkbox_Row_10();
		roles.choose_Checkbox_Update_With_Row_Number10();
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
		administration.clickSubMenuDomain();

		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Domain menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuDomainDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Domain menu ");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Domain menu .");
		}

		TestLogger.info("4. click in Domain name to open edit screen.\r\n"
				+ "+ in Domain detail , click Save button >> Display msg: Update domain successfully!");
		domain.clickFistLinkDomain();
		formUpdateDomain.clickButtonSave();
		if (domain.isMessageSuccessDisplayed() == true) {
			setStatusTest("pass", "click Save button >> Display msg: Update domain successfully!");
		} else {
			setStatusTest("fail", "click Save button >> DOES NOT Display msg: Update domain successfully!");
		}

		if (domain.isBtnDeleteDisplayed() == false && domain.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "CANNOT see/do\r\n" + "+ Add button\r\n" + "+ Delete button");
		} else {
			setStatusTest("fail",
					"STILL CAN see/do\r\n" + "STILL CAN see/do\r\n" + "+ Add button\r\n" + "+ Delete button");
		}

	}

	@Test(priority = 4, dependsOnMethods = "TT_170")
	public void TT_172() throws InterruptedException {
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
		UserRoleName = "Administration_Configuration_DomainSetting_Delete" + TienIch.taoRandomSo(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration - Domain Settings| Delete");
		TestLogger.info("Choose only Check on Administration - Configuration - Domain Settings|Delete");
		roles.uncheck_All_Checkbox_Row_10();
		roles.choose_Checkbox_Delete_With_Row_Number10();
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
		administration.clickSubMenuDomain();

		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Domain menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuDomainDisplayed() == true && domain.isBtnDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Domain menu 4. Delete button");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Domain menu ." + "                 \4. Delete button");
		}

		TestLogger.info("4. click in Domain name to open edit screen.\r\n"
				+ "+ in Domain detail , click Save button >> Display msg: Update domain successfully!");

		if (domain.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "CANNOT see/do\r\n" + "+ Add button\r\n");
		} else {
			setStatusTest("fail", "STILL CAN see/do\r\n" + "STILL CAN see/do\r\n" + "+ Add button\r\n");
		}

		if (domain.isCheckboxsOfDomainClickable() == false) {
			setStatusTest("pass", "4. cannot click on radio button");
		} else {
			setStatusTest("fail", "4. STILL CAN click on radio button");
		}

		if (domain.isLinkofDomainsClickable() == false) {
			setStatusTest("pass", "3.  cannot click in Domain name to open edit screen");
		} else {
			setStatusTest("fail", "3. STILL can click in Domain name to open edit screen");
		}

		TestLogger.info("Select a domain\r\n" + "click on delete button\r\n" + "click Yes button");

		domain.clickDomainCheckBox(nameOfDomain);
		domain.clickButtonDelete();
		formDomain.clickButtonAdd();
		if (domain.isMessageDeleteSusseccDisplayed() == true) {
			setStatusTest("pass", "The system display msg: Delete domain successfully");
		} else {
			setStatusTest("fail", "The system DOES NOT display msg: Delete domain successfully");
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
