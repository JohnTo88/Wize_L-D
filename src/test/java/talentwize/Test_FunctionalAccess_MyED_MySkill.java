package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.ScreenController;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.Dashboard;
import talentwize.pages.HomePage;
import talentwize.pages.MyED_Skills;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_MyED_MySkill extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String skillName;
	MyED_Skills mySkill;

	ScreenController s;
	Screen screen;

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
		mySkill = new MyED_Skills(driver);
		screen = new Screen();
		s = new ScreenController(screen);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_3610() throws InterruptedException {
		TestLogger.info("=================TT_3610====================");
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
		UserRoleName = "My ED|My Skill|No permission" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

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

		TestLogger.info("8. Employee Data");
		administration.clickMenuEmployeeData();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "Submenu Skills");
		if (administration.isSubMenuSkillsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Submenu Skills");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Submenu Skills");
		}

		TestLogger.info("=================END TT_3610====================");
	}

	@Test(priority = 2)
	public void TT_3608() throws InterruptedException {
		TestLogger.info("=================TT_3608====================");
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
		UserRoleName = "My ED|My Skill|Create" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permission - My Skill | Create");
		roles.checkbox_Create_MySkill();

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

		TestLogger.info("8. Employee Data >> Skills");
		administration.clickMenuEmployeeData();
		administration.clickSubMenuSkills();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Button Add");
		if (mySkill.isLblMySkillsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}
		if (mySkill.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function \r\n" + "2. Delete function");
		if (mySkill.isLinkOfSkillClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Edit function");
		}
		if (mySkill.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("9. Add skill");
		skillName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		mySkill.createSkill(skillName);

		if (mySkill.isMsgCreateSkillSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create goal successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create goal successfully");
		}

		TestLogger.info("=================END TT_3608====================");

	}

	@Test(priority = 3)
	public void TT_3611() throws InterruptedException {
		TestLogger.info("=================TT_3611====================");
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
		UserRoleName = "My ED|My Skill|Read" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permission - My Skill | Read");
		roles.checkbox_Read_MySkill();

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

		TestLogger.info("8. Employee Data >> Skills");
		administration.clickMenuEmployeeData();
		administration.clickSubMenuSkills();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (mySkill.isLblMySkillsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Add \r\n" + "2. Button Request Approval \r\n"
				+ "3. Edit function \r\n" + "4. Delete function");
		if (mySkill.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Create");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Create");
		}

		if (mySkill.isBtnRequestApprovalDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Request Approval");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Request Approval");
		}

		if (mySkill.isLinkOfSkillClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Edit function");
		}

		if (mySkill.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("=================END TT_3611====================");
	}

	@Test(priority = 4)
	public void TT_3612() throws InterruptedException {
		TestLogger.info("=================TT_3612====================");
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
		UserRoleName = "My ED|My Skill|Update" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permission - My Skill | Update");
		roles.checkbox_Update_MySkill();

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

		TestLogger.info("8. Employee Data >> Skills");
		administration.clickMenuEmployeeData();
		administration.clickSubMenuSkills();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Button Request Approval\r\n"
				+ "3. Edit function");
		if (mySkill.isLblMySkillsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (mySkill.isBtnRequestApprovalDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Request Approval");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Request Approval");
		}

		if (mySkill.isLinkOfSkillClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit function");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Add \r\n" + "2. Delete function");

		if (mySkill.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Add");
		}

		if (mySkill.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("9. Update skill in My Skill");
		mySkill.updateSkill();

		if (mySkill.isMsgUpdateSkillSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update skill successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update skill successfully");
		}

		TestLogger.info("=================END TT_3612====================");

	}

	@Test(priority = 5)
	public void TT_3609() throws InterruptedException {
		TestLogger.info("=================TT_3609====================");
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
		UserRoleName = "My ED|My Skill|Delete" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Checked on My Employee Data Permission - My Skill | Delete");
		roles.checkbox_Delete_MySkill();

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

		TestLogger.info("8. Employee Data >> Skills");
		administration.clickMenuEmployeeData();
		administration.clickSubMenuSkills();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (mySkill.isLblMySkillsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (mySkill.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Add \r\n" + "2. Button Request Approval \r\n"
				+ "3. Edit function");
		if (mySkill.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Add");
		}

		if (mySkill.isBtnRequestApprovalDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Request Approval");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Request Approval");
		}

		if (mySkill.isLinkOfSkillClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Edit function");
		}

		TestLogger.info("9. Delete goal in My Goal");
		mySkill.deleteSkill();

		if (mySkill.isMsgDeleteSkillSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete skill successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete skill successfully");
		}

		TestLogger.info("=================END TT_3609====================");

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
