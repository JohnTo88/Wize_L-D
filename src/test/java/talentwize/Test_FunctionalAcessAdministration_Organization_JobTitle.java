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

public class Test_FunctionalAcessAdministration_Organization_JobTitle extends TestManager {

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
	public void TT_163() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-JobTitle|Read" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization - JobTitle | Read");
		TestLogger.info("Choose only Check on Administration - Organization - JobTitle | Read");
		roles.uncheck_All_Checkbox_Row_8();
		roles.choose_Checkbox_Read_With_Row_Number8();
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

		TestLogger.info("8. 1. Administration menu\r\n" + "2. Job Title menu\r\n" + "3. Job Title / Job Category \r\n"
				+ " / Job Level tab\r\n" + "4. Export button ");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuJobTitle();
		administration.openTabJobTitle();

		if (administration.isTabJobTitleDisplayed() == true && administration.isMenuJobTitleDisplayed() == true
				&& administration.isTabJobCategoryDisplayed() == true
				&& administration.isTabRoleLevelDisplayed() == true && jobTitle.isButtonExportDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		}

		TestLogger.info("User CANNOT see/do\r\n" + "1.  In Job title tab, don't see \r\n" + " + Add btn\r\n"
				+ " + Delete btn\r\n" + " + Click on Job title name to open Update job title");

		administration.openTabJobTitle();

		if (jobTitle.isButtonAddDisplayed() == false && jobTitle.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		}

		if (jobTitle.isLinksofJobTitleDisplayed() == false) {
			setStatusTest("pass", "CAN NOT Click on Job title name to open Update job title");
		} else {
			setStatusTest("fail", "STILL CAN Click on Job title name to open Update job title");
		}

		administration.openTabJobCategory();

		if (jobCategory.isButtonAddDisplayed() == false && jobCategory.isButtonDeleteDisplayed() == false) {

			setStatusTest("pass", "User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		}

		if (jobCategory.isLinksofJobCategoryDisplayed() == false) {
			setStatusTest("pass", "CAN NOT Click on Job title name to open Update job catgory");
		} else {
			setStatusTest("fail", "STILL CAN Click on Job title name to open Update job catgory");
		}

		administration.openTabJobLevel();

		if (jobLevel.isButtonAddDisplayed() == false && jobLevel.isButtonDeleteDisplayed() == false) {

			setStatusTest("pass", "User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		}

		if (jobLevel.isLinksofJobLevelDisplayed() == false) {
			setStatusTest("pass", "CAN NOT Click on Job title name to open Update Job Level");
		} else {
			setStatusTest("fail", "STILL CAN Click on Job title name to open Update Job Level");
		}

	}

	@Test(priority = 2)
	public void TT_165() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-JobTitle|Create" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization - JobTitle | Create");
		TestLogger.info("Choose only Check on Administration - Organization - JobTitle | Create");
		roles.uncheck_All_Checkbox_Row_8();
		roles.choose_Checkbox_Create_With_Row_Number8();
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

		TestLogger.info("8. 1. Administration menu\r\n" + "2. Job Title menu\r\n" + "3. Job Title / Job Category \r\n"
				+ " / Job Level tab\r\n" + "4. Export button ");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuJobTitle();
		administration.openTabJobTitle();

		if (administration.isTabJobTitleDisplayed() == true && administration.isMenuJobTitleDisplayed() == true
				&& administration.isTabJobCategoryDisplayed() == true
				&& administration.isTabRoleLevelDisplayed() == true && jobTitle.isButtonExportDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		}

		TestLogger.info("User CANNOT see/do\r\n" + "1.  In Job title tab, don't see \r\n" + " + Add btn\r\n"
				+ " + Delete btn\r\n" + " + Click on Job title name to open Update job title");

		administration.openTabJobTitle();

		if (jobTitle.isButtonAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see \r\n" + "1. buttn Add \r\n");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see \r\n" + "1. Button Add \r\n");
		}

		if (jobTitle.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "don't see \r\n" + " + Delete btn");
		} else {
			setStatusTest("fail", "Still See \r\n" + " + Delete btn");
		}

		if (jobTitle.isLinksofJobTitleDisplayed() == false) {
			setStatusTest("pass", " CAN NOT Click on Job Title name to open Update Job Title");
		} else {
			setStatusTest("fail", "STILL can click on Job Title name to open Update Job Title");
		}

		administration.openTabJobCategory();

		if (jobCategory.isButtonAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see \r\n" + "1. buttn Add \r\n");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see \r\n" + "1. Button Add \r\n");
		}

		if (jobCategory.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "don't see \r\n" + " + Delete btn");
		} else {
			setStatusTest("fail", "Still See \r\n" + " + Delete btn");
		}

		if (jobCategory.isLinksofJobCategoryDisplayed() == false) {
			setStatusTest("pass", " CAN NOT Click on Job Category name to open Update Category Job ");
		} else {
			setStatusTest("fail", "STILL can click on Category Jobname to open Update Category Job");
		}

		administration.openTabJobLevel();

		if (jobLevel.isButtonAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see \r\n" + "1. buttn Add \r\n");
		} else {
			setStatusTest("fail", "User STILL CAN NOT see \r\n" + "1. Button Add \r\n");
		}

		if (jobLevel.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "don't see \r\n" + " + Delete btn");
		} else {
			setStatusTest("fail", "Still See \r\n" + " + Delete btn");
		}

		if (jobLevel.isLinksofJobLevelDisplayed() == false) {
			setStatusTest("pass", " CAN NOT Click on Job Level name to open Update Job Level ");
		} else {
			setStatusTest("fail", "STILL can click on Job Level name to open Update Job Level");
		}

	}

	@Test(priority = 3)
	public void TT_164() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-JobTitle|Update" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization - JobTitle | Update");
		TestLogger.info("Choose only Check on Administration - Organization - JobTitle | Update");
		roles.uncheck_All_Checkbox_Row_8();
		roles.choose_Checkbox_Update_With_Row_Number8();
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

		TestLogger.info("8. 1. Administration menu\r\n" + "2. Job Title menu\r\n" + "3. Job Title / Job Category \r\n"
				+ " / Job Level tab\r\n" + "4. Export button ");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuJobTitle();
		administration.openTabJobTitle();

		if (administration.isTabJobTitleDisplayed() == true && administration.isMenuJobTitleDisplayed() == true
				&& administration.isTabJobCategoryDisplayed() == true
				&& administration.isTabRoleLevelDisplayed() == true && jobTitle.isButtonExportDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		}

		TestLogger.info("User CANNOT see/do\r\n" + "1.  In Job title tab, don't see \r\n" + " + Add btn\r\n"
				+ " + Delete btn\r\n" + " + Click on Job title name to open Update job title");

		administration.openTabJobTitle();

		if (jobTitle.isButtonAddDisplayed() == false && jobTitle.isButtonDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		}

		jobTitle.openTitleofFistJob();

		if (formEditJobTile.isButtonSaveDisplayed() == true) {
			formEditJobTile.clickButtonCancel();
			setStatusTest("pass", "user can see Save btn");
		} else {
			formEditJobTile.clickButtonCancel();
			setStatusTest("fail", "user can NOT see Save btn");
		}

		administration.openTabJobCategory();

		if (jobCategory.isButtonAddDisplayed() == false && jobCategory.isButtonDeleteDisplayed() == false) {

			setStatusTest("pass", "User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		}

		jobCategory.openLinkFistNameJobCategory();

		if (formEditCategory.isButtonSaveDisplayed() == true) {
			formEditCategory.clickButtonCancel();
			setStatusTest("pass", " user can see Save button");
		} else {
			formEditCategory.clickButtonCancel();
			setStatusTest("fail", " user can NOT see Save button");
		}

		administration.openTabJobLevel();

		if (jobLevel.isButtonAddDisplayed() == false && jobLevel.isButtonDeleteDisplayed() == false) {

			setStatusTest("pass", "User CANNOT see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. (+) create  icon\r\n" + "2.  Delete icon");
		}

		jobLevel.openLinkofFistNameJobLevel();

		if (formEditLevel.isButtonSaveDisplayed() == true) {
			formEditLevel.clickButtonCancel();
			setStatusTest("pass", "user can see Save button");
		} else {
			formEditLevel.clickButtonCancel();
			setStatusTest("fail", "user can NOT see Save button");
		}

	}

	@Test(priority = 4)
	public void TT_166() throws InterruptedException {
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
		UserRoleName = "Administration-Organization-JobTitle|Create" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization - JobTitle | Delete");
		TestLogger.info("Choose only Check on Administration - Organization - JobTitle | Delete");
		roles.uncheck_All_Checkbox_Row_8();
		roles.choose_Checkbox_Delete_With_Row_Number8();
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

		TestLogger.info("8. 1. Administration menu\r\n" + "2. Job Title menu\r\n" + "3. Job Title / Job Category \r\n"
				+ " / Job Level tab\r\n" + "4. Export button ");

		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuJobTitle();
		administration.openTabJobTitle();

		if (administration.isTabJobTitleDisplayed() == true && administration.isMenuJobTitleDisplayed() == true
				&& administration.isTabJobCategoryDisplayed() == true
				&& administration.isTabRoleLevelDisplayed() == true && jobTitle.isButtonExportDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		} else {
			setStatusTest("fail", "User can NOT see/do:\r\n" + "1. Administration menu\r\n" + "2. Job Title menu\r\n"
					+ "3. Job Title / Job Category \r\n" + " / Job Level tab\r\n" + "4. Export button");
		}

		TestLogger.info("User CANNOT see/do\r\n" + "1.  In Job title tab, don't see \r\n" + " + Add btn\r\n"
				+ " + Delete btn\r\n" + " + Click on Job title name to open Update job title");

		administration.openTabJobTitle();

		if (jobTitle.isButtonAddDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see \r\n" + "1. buttn Add \r\n");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. Button Add \r\n");
		}

		if (jobTitle.isButtonDeleteDisplayed() == true) {
			setStatusTest("pass", "see \r\n" + " + Delete btn");
		} else {
			setStatusTest("fail", "Still DON'T See \r\n" + " + Delete btn");
		}

		if (jobTitle.isLinksofJobTitleDisplayed() == false) {
			setStatusTest("pass", " CAN NOT Click on Job Title name to open Update Job Title");
		} else {
			setStatusTest("fail", "STILL can click on Job Title name to open Update Job Title");
		}

		administration.openTabJobCategory();

		if (jobCategory.isButtonAddDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see \r\n" + "1. buttn Add \r\n");
		} else {
			setStatusTest("fail", "User STILL CAN  see \r\n" + "1. Button Add \r\n");
		}

		if (jobCategory.isButtonDeleteDisplayed() == true) {
			setStatusTest("pass", "can see \r\n" + " + Delete btn");
		} else {
			setStatusTest("fail", "Still can NOT See \r\n" + " + Delete btn");
		}

		if (jobCategory.isLinksofJobCategoryDisplayed() == false) {
			setStatusTest("pass", " CAN NOT Click on Job Category name to open Update Category Job ");
		} else {
			setStatusTest("fail", "STILL can click on Category Jobname to open Update Category Job");
		}

		administration.openTabJobLevel();

		if (jobLevel.isButtonAddDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see \r\n" + "1. buttn Add \r\n");
		} else {
			setStatusTest("fail", "User STILL CAN see \r\n" + "1. Button Add \r\n");
		}

		if (jobLevel.isButtonDeleteDisplayed() == true) {
			setStatusTest("pass", "can see \r\n" + " + Delete btn");
		} else {
			setStatusTest("fail", "Still can Not See \r\n" + " + Delete btn");
		}

		if (jobLevel.isLinksofJobLevelDisplayed() == false) {
			setStatusTest("pass", " CAN NOT Click on Job Level name to open Update Job Level ");
		} else {
			setStatusTest("fail", "STILL can click on Job Level name to open Update Job Level");
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
