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
import talentwize.pages.Default;
import talentwize.pages.Form_Delegate;
import talentwize.pages.Form_EditCategory;
import talentwize.pages.Form_EditJobTitle;
import talentwize.pages.Form_EditLevel;
import talentwize.pages.Form_UnitDetail;
import talentwize.pages.HomePage;
import talentwize.pages.JobCategory;
import talentwize.pages.JobLevel;
import talentwize.pages.JobTitle;
import talentwize.pages.Roles;
import talentwize.pages.Sites;
import talentwize.pages.Units;
import talentwize.pages.Users;

public class Test_FunctionalAcess_Administration_Configuration_DefaultSettings extends TestManager {

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
	Default defaut;
	Form_EditJobTitle formEditJobTile;
	Form_EditCategory formEditCategory;
	Form_EditLevel formEditLevel;
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
		jobTitle = new JobTitle(driver);
		jobLevel = new JobLevel(driver);
		jobCategory = new JobCategory(driver);
		units = new Units(driver);
		defaut = new Default(driver);
		unitDetails = new Form_UnitDetail(driver);
		formDelegate = new Form_Delegate(driver);
		formEditJobTile = new Form_EditJobTitle(driver);
		formEditCategory = new Form_EditCategory(driver);
		formEditLevel = new Form_EditLevel(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1515() throws InterruptedException {
		TestLogger.info("========== TT_1515================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|DefaultSetting|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("5. Log out");

		dashboard.logout();

		TestLogger.info("6. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("7. Open Employee Data Administration - Configuration menu ");

		TestLogger.info("8. Open Employee Data Administration >> Configuration menu");
		administration.clickMenuAdministration();
		administration.clickMenuConfiguration();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Default menu");
		if (administration.isMenuDefaultsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Default menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Default menu");
		}

		TestLogger.info("==========End TT_1515================");
	}

	@Test(priority = 2)
	public void TT_1516() throws InterruptedException {
		TestLogger.info("========== TT_1516================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|DefaultSetting|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration - Default Settings - Read");
		roles.checkbox_Read_Configuration_Default();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("8. Open Employee Data Administration >> Configuration menu");
		administration.clickLogoTalentWize();
		administration.clickMenuAdministration();
		administration.clickMenuConfiguration();
		administration.clickMenuDefault();

		TestLogger.info("9. Check Permission");

		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Default menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isMenuDefaultsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Default menu");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n"
					+ "2. Configuration menu\r\n" + "3. Default menu");
		}

		if (defaut.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do\r\n" + "1.  Edit button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do\r\n" + "1.  Edit button");
		}
		TestLogger.info("==========End TT_1516================");
	}

	@Test(priority = 3)
	public void TT_1517() throws InterruptedException {
		TestLogger.info("========== TT_1517================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|DefaultSetting|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration - Default Settings | Update");
		roles.checkbox_Update_Configuration_Default();

		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("8. Open Employee Data Administration >> Configuration menu");
		administration.clickLogoTalentWize();
		administration.clickMenuAdministration();
		administration.clickMenuConfiguration();
		administration.clickMenuDefault();

		TestLogger.info("9. Check Permission");
		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Default menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isMenuDefaultsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Default menu");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n"
					+ "2. Configuration menu\r\n" + "3. Default menu");
		}

		if (defaut.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do\r\n" + "1.  Edit button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do\r\n" + "1.  Edit button");
		}

		TestLogger.info("10. Update General Configuration");
		defaut.clickBtnEdit();
		defaut.clickBtnSave();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Update Successfully!");
		if (defaut.isMsgEditSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update Successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update Successfully!");
		}

		TestLogger.info("==========End TT_1517================");
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
