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
import talentwize.pages.MyGoal;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_PerformancePermission_Goals_MyGoal extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String goalName;
	MyGoal myGoal;

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
		myGoal = new MyGoal(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1158() throws InterruptedException {
		TestLogger.info("=================TT_1158====================");
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

		TestLogger.info("+ Unchecked on Performance Permission - My Goal | Read");
		roles.uncheckbox_Read_MyGoal();

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

		TestLogger.info("8. Open Performance >> Goals");
		administration.clickMenuPerformance();
		administration.clickMenuGoals();

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "Submenu My Goal");
		if (administration.isSubMenuMyGoalDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Submenu My Goal");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Submenu My Goal");
		}

		TestLogger.info("=================END TT_1158====================");
	}

	@Test(priority = 2)
	public void TT_1152() throws InterruptedException {
		TestLogger.info("=================TT_1152====================");
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

		TestLogger.info("+ Unchecked on Performance Permission - My Goal | Read");
		roles.uncheckbox_Read_MyGoal();
		TestLogger.info("+ Checked on Performance Permission - My Goal | Create");
		roles.checkbox_Create_MyGoal();

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

		TestLogger.info("8. Open Performance >> Goals >> My Goal");
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		administration.clickSubMenuMyGoal();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Button Create");
		if (myGoal.isLblMyGoalDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}
		if (myGoal.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Create");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function \r\n" + "2. Delete function");
		myGoal.clickGoalName();
		if (myGoal.isBtnUpdateProgressDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Edit function");
		}

		myGoal.clickBtnBack();
		if (myGoal.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("9. Create goal in My Goal");
		goalName = "Ngoc Auto " + TienIch.taoRandomSo(3);
		myGoal.createGoal(goalName);

		if (myGoal.isMsgCreateGoalSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create goal successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create goal successfully");
		}

		TestLogger.info("=================END TT_1152====================");

	}

	@Test(priority = 3)
	public void TT_1157() throws InterruptedException {
		TestLogger.info("=================TT_1157====================");
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

		TestLogger.info("+ Unchecked on Performance Permission - My Goal | Read");
		roles.uncheckbox_Read_MyGoal();
		TestLogger.info("+ Checked on Performance Permission - My Goal | Read");
		roles.checkbox_Read_MyGoal();

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

		TestLogger.info("8. Open Performance >> Goals >> My Goal");
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		administration.clickSubMenuMyGoal();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (myGoal.isLblMyGoalDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Create \r\n" + "2. Edit function \r\n"
				+ "3. Delete function");
		if (myGoal.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Create");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Create");
		}

		myGoal.clickGoalName();
		if (myGoal.isBtnUpdateProgressDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Edit function");
		}

		myGoal.clickBtnBack();
		if (myGoal.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("=================END TT_1157====================");
	}

	@Test(priority = 4)
	public void TT_1151() throws InterruptedException {
		TestLogger.info("=================TT_1151====================");
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

		TestLogger.info("+ Unchecked on Performance Permission - My Goal | Read");
		roles.uncheckbox_Read_MyGoal();
		TestLogger.info("+ Checked on Performance Permission - My Goal | Update");
		roles.checkbox_Update_MyGoal();

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

		TestLogger.info("8. Open Performance >> Goals >> My Goal");
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		administration.clickSubMenuMyGoal();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function");
		if (myGoal.isLblMyGoalDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		myGoal.clickGoalName();
		if (myGoal.isBtnUpdateProgressDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit function");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Create \r\n" + "2. Delete function");

		myGoal.clickBtnBack();
		if (myGoal.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Create");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Create");
		}

		if (myGoal.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("9. Update goal in My Goal");
		myGoal.updateGoal();

		if (myGoal.isMsgUpdateGoalSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update goal successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update goal successfully");
		}

		TestLogger.info("=================END TT_1151====================");

	}

	@Test(priority = 5)
	public void TT_1153() throws InterruptedException {
		TestLogger.info("=================TT_1153====================");
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

		TestLogger.info("+ Unchecked on Performance Permission - My Goal | Read");
		roles.uncheckbox_Read_MyGoal();
		TestLogger.info("+ Checked on Performance Permission - My Goal | Delete");
		roles.checkbox_Delete_MyGoal();

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

		TestLogger.info("8. Open Performance >> Goals >> My Goal");
		administration.clickMenuPerformance();
		administration.clickMenuGoals();
		administration.clickSubMenuMyGoal();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (myGoal.isLblMyGoalDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}
		if (myGoal.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Button Create \r\n" + "2. Edit function");
		if (myGoal.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Create");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Button Create");
		}

		myGoal.clickGoalName();
		if (myGoal.isBtnUpdateProgressDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Edit function");
		}

		TestLogger.info("9. Delete goal in My Goal");
		myGoal.clickBtnBack();
		myGoal.deleteGoal();

		if (myGoal.isMsgDeleteGoalSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete goal successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete goal successfully");
		}

		TestLogger.info("=================END TT_1153====================");

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
