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
import talentwize.pages.Form_AddCertificate;
import talentwize.pages.Form_AddSkill;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.TabCertificateConfiguration;
import talentwize.pages.TabSkillConfiguration;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TalentPermission_CompetencySettings_Certificate_SkillConfiguration
		extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	TabCertificateConfiguration tabCertificateConfiguration;
	TabSkillConfiguration tabSkillConfiguration;
	Form_AddCertificate formAddCertificate;
	Form_AddSkill formAddSkill;

	// fixed all
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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		tabCertificateConfiguration = new TabCertificateConfiguration(driver);
		tabSkillConfiguration = new TabSkillConfiguration(driver);
		formAddCertificate = new Form_AddCertificate(driver);
		formAddSkill = new Form_AddSkill(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1101() throws InterruptedException {
		TestLogger.info("=================TT_1101====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Competency - Settings - Certificate/Skill Configuration | Read");
		roles.uncheck_Read_CompetencySettings_Certificate_SkillConfiguration();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Data table in tab Certificate Configuration");
		if (administration.isTabCertificateConfigurationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Tab Certificate Configuration");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Data table in tab Skill Configuration");
		if (administration.isTabSkillConfigurationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Tab Skill Configuration");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Tab Skill Configuration");
		}

		TestLogger.info("=================END TT_1101====================");
	}

	@Test(priority = 2)
	public void TT_1099() throws InterruptedException {
		TestLogger.info("=================TT_1099====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Competency - Settings - Certificate/Skill Configuration | Read");
		roles.uncheck_Read_CompetencySettings_Certificate_SkillConfiguration();
		TestLogger.info("+ Checked on Competency - Settings - Certificate/Skill Configuration | Read");
		roles.checkbox_Read_CompetencySettings_Certificate_SkillConfiguration();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings >> Certificate Configuration");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabCertificateConfiguration.islblCertificateCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Certificate Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Certificate Categories");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete function");
		if (tabCertificateConfiguration.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Add in tab Certificate Configuration");
		}
		if (tabCertificateConfiguration.isLinkOfCertificateCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		}
		if (tabCertificateConfiguration.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		}

		TestLogger.info("9. Open Talent Management >> Competency >> Competency Settings >> Skill Configuration");
		administration.clickTabSkillConfiguration();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabSkillConfiguration.islblSkillCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Skill Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Skill Categories");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete function");
		if (tabSkillConfiguration.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Add in tab Skill Configuration");
		}
		if (tabSkillConfiguration.isLinkOfSkillCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Skill Configuration");
		}
		if (tabSkillConfiguration.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Skill Configuration");
		}

		TestLogger.info("=================END TT_1099====================");
	}

	@Test(priority = 3)
	public void TT_1049() throws InterruptedException {
		TestLogger.info("=================TT_1049====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Competency - Settings - Certificate/Skill Configuration | Read");
		roles.uncheck_Read_CompetencySettings_Certificate_SkillConfiguration();
		TestLogger.info("+ Checked on Competency - Settings - Certificate/Skill Configuration | Create");
		roles.checkbox_Create_CompetencySettings_Certificate_SkillConfiguration();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings >> Certificate Configuration");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button");
		if (tabCertificateConfiguration.islblCertificateCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Certificate Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Certificate Categories");
		}

		if (tabCertificateConfiguration.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add in tab Certificate Configuration");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete fuction");
		if (tabCertificateConfiguration.isLinkOfCertificateCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		}
		if (tabCertificateConfiguration.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		}

		TestLogger.info("9. Add New Certificate ");
		tabCertificateConfiguration.clickBtnAdd();
		formAddCertificate.fillTxtCertificateName("Ngoc Certificate" + TienIch.taoRandomChu(6));
		formAddCertificate.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new certificate successfully");
		if (tabCertificateConfiguration.isMsgAddCertificateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new certificate successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new certificate successfully");
		}

		TestLogger.info("10. Open Talent Management >> Competency >> Competency Settings >> Skill Configuration");
		administration.clickTabSkillConfiguration();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button");
		if (tabSkillConfiguration.islblSkillCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Skill Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Skill Categories");
		}

		if (tabSkillConfiguration.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add in tab Skill Configuration");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete function");

		if (tabSkillConfiguration.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Skill Configuration");
		}

		if (tabSkillConfiguration.isLinkOfSkillCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Skill Configuration");
		}

		TestLogger.info("11. Add New Skill ");
		tabSkillConfiguration.clickBtnAdd();
		formAddSkill.fillTxtSkillName("Ngoc Skill" + TienIch.taoRandomChu(6));
		formAddSkill.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new skill successfully");
		if (tabSkillConfiguration.isMsgAddSkillSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new skill successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new skill successfully");
		}

		TestLogger.info("=================END TT_1049====================");
	}

	@Test(priority = 4)
	public void TT_1100() throws InterruptedException {
		TestLogger.info("=================TT_1100====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Competency - Settings - Certificate/Skill Configuration | Read");
		roles.uncheck_Read_CompetencySettings_Certificate_SkillConfiguration();
		TestLogger.info("+ Checked on Competency - Settings - Certificate/Skill Configuration | Update");
		roles.checkbox_Update_CompetencySettings_Certificate_SkillConfiguration();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");
		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings >> Certificate Configuration");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function");
		if (tabCertificateConfiguration.islblCertificateCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Certificate Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Certificate Categories");
		}

		if (tabCertificateConfiguration.isLinkOfCertificateCategoryClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Add\r\n" + "2. Delete fucntion");
		if (tabCertificateConfiguration.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Certificate Configuration");
		}
		if (tabCertificateConfiguration.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		}

		TestLogger.info("9. Edit Certificate ");
		tabCertificateConfiguration.clickLinkOfCertificate();
		formAddCertificate.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Edit certificate successfully");
		if (tabCertificateConfiguration.isMsgEditCertificateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit certificate successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit certificate successfully");
		}

		TestLogger.info("10. Open Talent Management >> Competency >> Competency Settings >> Skill Configuration");
		administration.clickTabSkillConfiguration();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Function Edit");
		if (tabSkillConfiguration.islblSkillCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Skill Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Skill Categories");
		}

		if (tabSkillConfiguration.isLinkOfskillCategoryClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Skill Configuration");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Add\r\n" + "2. Delete fuction");
		if (tabSkillConfiguration.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Skill Configuration");
		}
		if (tabSkillConfiguration.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Skill Configuration");
		}

		TestLogger.info("11. Edit Skill ");
		tabSkillConfiguration.clickMenuCategoryDefault();
		tabSkillConfiguration.fillTxtSearchSkill("Ngoc Skill");
		tabSkillConfiguration.clickLinkOfSkill();
		formAddSkill.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Edit skill successfully");
		if (tabSkillConfiguration.isMsgEditSkillSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit skill successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit skill successfully");
		}

		TestLogger.info("=================END TT_1100====================");
	}

	@Test(priority = 5)
	public void TT_1050() throws InterruptedException {
		TestLogger.info("==========TT_1050================");

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Competency - Settings - Certificate/Skill Configuration | Read");
		roles.uncheck_Read_CompetencySettings_Certificate_SkillConfiguration();
		TestLogger.info("+ Check on Competency - Settings - Certificate/Skill Configuration | Delete");
		roles.checkbox_Delete_CompetencySettings_Certificate_SkillConfiguration();
		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("5. Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserChi());

		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("8. Open Talent Management >> Competency >> Competency Settings >> Certificate Configuration");
		administration.clickMenuTalentManagement();
		administration.clickSubMenuCompetency();
		administration.clickSubMenuCompetencySettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (tabCertificateConfiguration.islblCertificateCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Certificate Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Certificate Categories");
		}
		if (tabCertificateConfiguration.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Certificate Configuration");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabCertificateConfiguration.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Certificate Configuration");
		}
		if (tabCertificateConfiguration.isLinkOfCertificateCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Certificate Configuration");
		}

		TestLogger.info("9. Delete Certificate Categories");
		tabCertificateConfiguration.clickmenuCategoryDefault();
		tabCertificateConfiguration.fillTxtSearchCertificate("Ngoc Certificate");
		tabCertificateConfiguration.clickIconDeleteCertificate();
		tabCertificateConfiguration.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Delete client successfully!");
		if (tabCertificateConfiguration.isMsgDeletetCertificateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete Certificate Categories successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete Certificate Categories successfully!");
		}

		TestLogger.info("10. Open Talent Management >> Competency >> Competency Settings >> Skill Configuration");
		administration.clickTabSkillConfiguration();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (tabSkillConfiguration.islblSkillCategoriesDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Skill Categories");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Skill Categories");
		}

		if (tabSkillConfiguration.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Skill Configuration");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabSkillConfiguration.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Skill Configuration");
		}
		if (tabSkillConfiguration.isLinkOfSkillCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Skill Configuration");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Skill Configuration");
		}

		TestLogger.info("11. Delete Skill Categories");
		tabSkillConfiguration.clickMenuCategoryDefault();
		tabSkillConfiguration.fillTxtSearchSkill("Ngoc Skill");
		tabSkillConfiguration.clickIcoDeleteSkill();
		tabSkillConfiguration.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Delete project category successfully!");
		if (tabSkillConfiguration.isMsgDeleteSkillSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete skill successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete skill successfully!");
		}

		TestLogger.info("==========End TT_1050================");
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
