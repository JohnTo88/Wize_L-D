package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
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
import talentwize.pages.Units;
import talentwize.pages.Users;

public class Test_FunctionalAcess_Administration_Configuration_CustomFields extends TestManager {

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
	public void TT_194() throws InterruptedException {
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
		UserRoleName = "Administration-Configuration-Custom Fields-Read" + TienIch.taoRandomSovaChu(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration -Custom Fields\r\n" + " | Read");
		TestLogger.info("Choose only Check on Administration - Configuration - Custom Fields\r\n" + " | Read");
		roles.uncheck_All_Checkbox_Row_16();// 16
		roles.choose_Checkbox_Read_With_Row_Number16();
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
		administration.clickSubMenuCustomFields();
		///
		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Custom Fields menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuCustomFieldsDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Custom Fields menu");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Custom Fields menu ");
		}

		TestLogger.info("CANNOT see/do\r\n" + "1. Create button \r\n" + "2. Delete button\r\n"
				+ "3. un-clickable on Broadcast name");

		if (customFields.isButtonAddDisplayed() == false && customFields.isButtonDeleteDisplayed() == false
				&& customFields.isLinkOfNameModuleDisplayed() == false) {
			setStatusTest("pass",
					"CANNOT see/do\\r\\n\" + \r\n" + "				\"1. Create button \\r\\n\" + \r\n"
							+ "				\"2. Delete button\\r\\n\" + \r\n"
							+ "				\"3. un-clickable on Broadcast name");
		} else {
			setStatusTest("fail",
					"USER STILL CAN see/do\\r\\n\" + \r\n" + "				\"1. Create button \\r\\n\" + \r\n"
							+ "				\"2. Delete button\\r\\n\" + \r\n"
							+ "				\"3. un-clickable on Broadcast name");
		}

	}

	@Test(priority = 2)
	public void TT_196() throws InterruptedException {
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
		UserRoleName = "Administration-Configuration-Custom Fields-Create" + TienIch.taoRandomSovaChu(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration -Custom Fields\r\n" + " | Create");
		TestLogger.info("Choose only Check on Administration - Configuration - Custom Fields\r\n" + " | Create");
		roles.uncheck_All_Checkbox_Row_16();// 16
		roles.choose_Checkbox_Create_With_Row_Number16();
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
		administration.clickSubMenuCustomFields();
		///
		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Custom Fields menu");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuCustomFieldsDisplayed() == true
				&& customFields.isButtonAddDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Custom Fields menu 4. Add button ");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Custom Fields menu 4. Add button ");
		}

		TestLogger.info("CANNOT see/do\r\n" + "2. un-clickable on Custom field name\r\n" + "3. Delete button");

		if (customFields.isButtonDeleteDisplayed() == false && customFields.isLinkOfNameModuleDisplayed() == false) {
			setStatusTest("pass",
					"CANNOT see/do\r\n" + "2. un-clickable on Custom field name\r\n" + "3. Delete button");
		} else {
			setStatusTest("fail",
					"CANNOT see/do\r\n" + "2. un-clickable on Custom field name\r\n" + "3. Delete button");
		}

		String nameOfCustomField = TienIch.taoRandomChu(8);
		customFields.clicButtonAdd();
		formCreateCustomField.clickTxtSubModule();
		formCreateCustomField.clickOption1();
		formCreateCustomField.fillFieldLabel(nameOfCustomField);
		formCreateCustomField.clickButtonCreate();

		if (driver.findElement(By.xpath("//span[contains(.,'" + nameOfCustomField + "')]")).isDisplayed() == true) {
			setStatusTest("pass", "Create Custome Field successully !");
		} else {
			setStatusTest("fail", "Does NOT create Custome Field successfully !");
		}
	}

	@Test(priority = 3)
	public void TT_198() throws InterruptedException {
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
		UserRoleName = "Administration-Configuration-Custom Fields-Update" + TienIch.taoRandomSovaChu(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration -Custom Fields\r\n" + " | Update");
		TestLogger.info("Choose only Check on Administration - Configuration - Custom Fields\r\n" + " | Update");
		roles.uncheck_All_Checkbox_Row_16();// 16
		roles.choose_Checkbox_Update_With_Row_Number16();
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
		administration.clickSubMenuCustomFields();
		///
		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Custom Fields menu 4. clickable on Custom field name");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuCustomFieldsDisplayed() == true
				&& customFields.isLinkOfNameModuleDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Custom Fields menu 4. 4. clickable on Custom field name");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Custom Fields menu 4. clickable on Custom field name ");
		}

		TestLogger.info("CANNOT see/do\r\n" + "1. Add button \r\n" + "2. Delete button\r\n" + "");

		if (customFields.isButtonAddDisplayed() == false && customFields.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "CANNOT see/do\r\n" + "1. Add button \r\n" + "2. Delete button\r\n" + "");
		} else {
			setStatusTest("fail", "STILL CAN see/do\r\n" + "1. Add button \r\n" + "2. Delete button\r\n" + "");
		}

		TestLogger.info("Click on a Custom field module\r\n" + "Click Save button ");
		customFields.clickFistnameOfLinkNameModule();
		formCreateCustomField.clickButtonSave();
		if (customFields.isMessageUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "Msg: Update custom field message successfully");
		} else {
			setStatusTest("fail", "DOES NOT SHOW Msg: Update custom field message successfully");
		}

	}

	@Test(dependsOnMethods="TT_196")
	public void TT_197() throws InterruptedException {
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Administration-Configuration-Custom Fields-Delete" + TienIch.taoRandomSovaChu(1);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Configuration -Custom Fields\r\n" + " | Delete");
		TestLogger.info("Choose only Check on Administration - Configuration - Custom Fields\r\n" + " | Delete");
		roles.uncheck_All_Checkbox_Row_16();// 16
		roles.choose_Checkbox_Delete_With_Row_Number16();
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
		administration.clickSubMenuCustomFields();
		///
		TestLogger.info("Verify that : User can see/do:\r\n" + "1. Administration menu\r\n"
				+ "2. Configuration menu\r\n" + "3. Custom Fields menu 4. Delete button");

		if (administration.isAdministrationDisplayed() == true && administration.isMenuConfigurationDisplayed() == true
				&& administration.isSubMenuCustomFieldsDisplayed() == true
				&& customFields.isButtonDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Configuration menu\r\n"
					+ "3. Custom Fields menu 4. Delete button");
		} else {
			setStatusTest("fail",
					"User can NOT see/do:\r\n" + "User can see/do:\\r\\n\" + \r\n"
							+ "					\"1. Administration menu\\r\\n\" + \r\n"
							+ "					\"2. Configuration menu\\r\\n\" + \r\n" + "					"
							+ "                 \"3. Custom Fields menu"
							+ "					\"4. Delete button ");
		}

		TestLogger.info("CANNOT see/do\r\n" + "2. un-clickable on Custom field name\r\n" + "3. Delete button");

		if (customFields.isButtonAddDisplayed() == false && customFields.isLinkOfNameModuleDisplayed() == false) {
			setStatusTest("pass", "CANNOT see/do\r\n" + "2. un-clickable on Custom field name\r\n" + "3. Add button");
		} else {
			setStatusTest("fail",
					"STILL CAN see/do\r\n" + "2. un-clickable on Custom field name\r\n" + "3. Add button");
		}

		customFields.clickDeleteCustomField();
		customFields.clickButtonYes();
		if (customFields.isMessageDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "Delete custom field message successfully");
		} else {
			setStatusTest("fail", "DOES NOT SHOW : Delete custom field message successfully");
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
