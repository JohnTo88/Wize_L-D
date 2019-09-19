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
import talentwize.pages.AppraisalCycle;
import talentwize.pages.AppraisalManagement;
import talentwize.pages.Dashboard;
import talentwize.pages.Form_CreateAppraisalCycle;
import talentwize.pages.Form_EditAppraisalCycle;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

//Bug: TAL-493
public class Test_FunctionalAccess_Performance_Appraisal_Management_Cycle extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfCycle;
	AppraisalManagement appraisalManagement;
	AppraisalCycle appraisalCycle;
	Form_CreateAppraisalCycle formCreateAppraisalCycle;
	Form_EditAppraisalCycle formEditAppraisalCycle;

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
		appraisalManagement = new AppraisalManagement(driver);
		appraisalCycle = new AppraisalCycle(driver);
		formCreateAppraisalCycle = new Form_CreateAppraisalCycle(driver);
		formEditAppraisalCycle = new Form_EditAppraisalCycle(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	// Bug: TAL-493
	@Test(priority = 1)
	public void TT_1016() throws InterruptedException {
		TestLogger.info("========== TT_1016================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

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
		UserRoleName = "Permission|AppraisalCycle|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Appraisal - Management - Cycle| Read");
		roles.uncheckbox_Read_AppraisalManagementCycle();
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("5. Log out");

		dashboard.logout();

		TestLogger.info("6. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		TestLogger.info("7. Open Performance menu >> Appraisal sub menu ");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Appraisal | Management menu");
		if (administration.isSubMenuAppraisalManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal | Management menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal | Management menu");
		}

		administration.clickSubMenuAppraisalManagement();
		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Appraisal Cycle tab");
		if (appraisalManagement.isTabAppraisalCycleDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + "Appraisal Cycle tab");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Appraisal Cycle tab");
		}

		TestLogger.info("==========End TT_1016================");
	}

	@Test(priority = 2)
	public void TT_1015() throws InterruptedException {
		TestLogger.info("========== TT_1015================");
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
		UserRoleName = "Permission|AppraisalCycle|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Appraisal - Management - List| Read");
		roles.uncheckbox_Read_AppraisalManagementList();

		TestLogger.info("5. Uncheck Performance - Appraisal - Management - Cycle| Read");
		roles.uncheckbox_Read_AppraisalManagementCycle();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Open Performance menu >> Appraisal sub menu ");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Appraisal | Management menu");
		if (administration.isSubMenuAppraisalManagementDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Appraisal | Management menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Appraisal | Management menu");
		}

		TestLogger.info("==========End TT_1015================");
	}

	@Test(priority = 3)
	public void TT_1028() throws InterruptedException {
		TestLogger.info("========== TT_1028================");
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
		UserRoleName = "Permission|AppraisalCycle|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Appraisal - Management - Cycle| Read");
		roles.uncheckbox_Read_AppraisalManagementCycle();

		TestLogger.info("5. Check Performance - Appraisal - Management - Cycle| Create");
		roles.checkbox_Create_AppraisalManagementCycle();
		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Open Performance menu >> Apraisal submenu >> Management submenu");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuAppraisalManagement();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Appraisal | Management menu");
		if (administration.isSubMenuAppraisalManagementDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Appraisal | Management menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Appraisal | Management menu");
		}

		TestLogger.info("10. Create New Appraisal Cycle");
		appraisalCycle.clickTabAppCycle();
		appraisalCycle.clickBtnCreate();
		// NameOfCycle = "Test Automation" + TienIch.taoRandomSo(2);
		formCreateAppraisalCycle.createNewCycle("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Appraisal Cycle created successfully!");
		if (appraisalCycle.isMsgCreateCycleSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal Cycle created successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal Cycle created successfully!");
		}

		TestLogger.info("11. Open Performance menu >> Apraisal submenu >> Management submenu >> Appraisals Cycle tab");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Appraisal cycle table\r\n"
				+ "2. View Appraisal Cycle Information\r\n" + "3. View detail btn\r\n" + "4. View detail screen\r\n"
				+ "5. Button Create");
		if (appraisalCycle.isTabAppCycleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal cycle table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal cycle table");
		}

		appraisalCycle.clickLinkEdit();
		if (formEditAppraisalCycle.isLblCyleInfoDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View Appraisal Cycle Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View Appraisal Cycle Information");
		}

		formEditAppraisalCycle.clickBtnClose();
		if (appraisalCycle.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Create");
		}

		appraisalCycle.clickBtnViewDetail();
		if (appraisalCycle.isSubTabViewDetialDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View detail screen");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View detail screen");
		}

		appraisalCycle.clickBtnBackViewDetail();
		if (appraisalCycle.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Create");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit button\r\n" + "2. Checkbox and delete btn");
		appraisalCycle.clickLinkEdit();
		if (formEditAppraisalCycle.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit button");
		}

		formEditAppraisalCycle.clickBtnClose();
		if (appraisalCycle.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Checkbox and delete btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Checkbox and delete btn");
		}

		TestLogger.info("==========End TT_1028================");
	}

	@Test(priority = 4)
	public void TT_1026() throws InterruptedException {
		TestLogger.info("========== TT_1026================");
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
		UserRoleName = "Permission|AppraisalCycle|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Appraisal - Management - Cycle| Read");
		roles.uncheckbox_Read_AppraisalManagementCycle();

		TestLogger.info("5. Check Performance - Appraisal - Management - Cycle| Read");
		roles.checkbox_Read_AppraisalManagementCycle();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");
		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());
		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Open Performance menu >> Apraisal submenu >> Management submenu");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuAppraisalManagement();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Appraisal | Management menu");
		if (administration.isSubMenuAppraisalManagementDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Appraisal | Management menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Appraisal | Management menu");
		}

		TestLogger.info("10. Open Performance menu >> Apraisal submenu >> Management submenu >> Appraisals Cycle tab");
		appraisalCycle.clickTabAppCycle();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Appraisal cycle table\r\n"
				+ "2. View Appraisal Cycle Information\r\n" + "3. View detail btn\r\n" + "4. View detail screen");
		if (appraisalCycle.isTabAppCycleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal cycle table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal cycle table");
		}

		appraisalCycle.clickLinkEdit();
		if (formEditAppraisalCycle.isLblCyleInfoDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View Appraisal Cycle Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View Appraisal Cycle Information");
		}

		formEditAppraisalCycle.clickBtnClose();
		if (appraisalCycle.isBtnViewDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View detail btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View detail btn");
		}

		appraisalCycle.clickBtnViewDetail();
		if (appraisalCycle.isSubTabViewDetialDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View detail screen");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View detail screen");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit button\r\n" + "2. Checkbox and delete btn\r\n"
				+ "3. Button Create");
		appraisalCycle.clickBtnBackViewDetail();
		appraisalCycle.clickLinkEdit();
		if (formEditAppraisalCycle.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit button");
		}

		formEditAppraisalCycle.clickBtnClose();
		if (appraisalCycle.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Checkbox and delete btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Checkbox and delete btn");
		}

		if (appraisalCycle.isBtnCreateStyleNoneDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create button");
		}

		TestLogger.info("==========End TT_1026================");
	}

	@Test(priority = 5)
	public void TT_1027() throws InterruptedException {
		TestLogger.info("========== TT_1027================");
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
		UserRoleName = "Permission|AppraisalCycle|Upadte" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Appraisal - Management - Cycle| Read");
		roles.uncheckbox_Read_AppraisalManagementCycle();

		TestLogger.info("5. Check Performance - Appraisal - Management - Cycle| Upadte");
		roles.checkbox_Update_AppraisalManagementCycle();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Open Performance menu >> Apraisal submenu >> Management submenu");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuAppraisalManagement();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Appraisal | Management menu");
		if (administration.isSubMenuAppraisalManagementDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Appraisal | Management menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Appraisal | Management menu");
		}

		TestLogger.info("10. Open Performance menu >> Apraisal submenu >> Management submenu >> Appraisals Cycle tab");
		appraisalCycle.clickTabAppCycle();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Appraisal cycle table\r\n"
				+ "2. View Appraisal Cycle Information\r\n" + "3. View detail btn\r\n" + "4. View detail screen\r\n"
				+ "5. Edit button");
		if (appraisalCycle.isTabAppCycleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal cycle table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal cycle table");
		}

		appraisalCycle.clickLinkEdit();
		if (formEditAppraisalCycle.isLblCyleInfoDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View Appraisal Cycle Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View Appraisal Cycle Information");
		}

		if (formEditAppraisalCycle.isBtnEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit button");
		}

		formEditAppraisalCycle.clickBtnClose();
		if (appraisalCycle.isBtnViewDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View detail btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View detail btn");
		}

		appraisalCycle.clickBtnViewDetail();
		if (appraisalCycle.isSubTabViewDetialDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View detail screen");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View detail screen");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Create button\r\n" + "2. Checkbox and delete btn");
		appraisalCycle.clickBtnBackViewDetail();
		if (appraisalCycle.isBtnCreateStyleNoneDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create button");
		}

		if (appraisalCycle.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Checkbox and delete btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Checkbox and delete btn");
		}

		TestLogger.info("11. Edit Appraisal Cycle");
		appraisalCycle.clickLinkEdit();
		formEditAppraisalCycle.updateCycle();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Appraisal Cycle updated successfully!");
		if (appraisalCycle.isMsgUpdateCycleSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal Cycle updated successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal Cycle updated successfully!");
		}

		TestLogger.info("==========End TT_1027================");
	}

	@Test(priority = 6)
	public void TT_1029() throws InterruptedException {
		TestLogger.info("========== TT_1029================");
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
		UserRoleName = "Permission|AppraisalCycle|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Performance - Appraisal - Management - Cycle| Read");
		roles.uncheckbox_Read_AppraisalManagementCycle();

		TestLogger.info("5. Check Performance - Appraisal - Management - Cycle| Delete");
		roles.checkbox_Delete_AppraisalManagementCycle();

		TestLogger.info("6. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Open Performance menu >> Apraisal submenu >> Management submenu");
		administration.clickLogoTalentWize();
		administration.clickMenuPerformance();
		administration.clickSubMenuAppraisal();
		administration.clickSubMenuAppraisalManagement();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Appraisal | Management menu");
		if (administration.isSubMenuAppraisalManagementDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Appraisal | Management menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Appraisal | Management menu");
		}

		TestLogger.info("10. Open Performance menu >> Apraisal submenu >> Management submenu >> Appraisals Cycle tab");
		appraisalCycle.clickTabAppCycle();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Appraisal cycle table\r\n"
				+ "2. View Appraisal Cycle Information\r\n" + "3. View detail btn\r\n" + "4. View detail screen\r\n"
				+ "5. Checkbox and delete btn");
		if (appraisalCycle.isTabAppCycleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal cycle table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal cycle table");
		}

		if (appraisalCycle.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Checkbox and delete btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Checkbox and delete btn");
		}

		appraisalCycle.clickLinkEdit();
		if (formEditAppraisalCycle.isLblCyleInfoDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View Appraisal Cycle Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View Appraisal Cycle Information");
		}

		if (formEditAppraisalCycle.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit button");
		}

		formEditAppraisalCycle.clickBtnClose();
		if (appraisalCycle.isBtnViewDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View detail btn");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View detail btn");
		}

		appraisalCycle.clickBtnViewDetail();
		if (appraisalCycle.isSubTabViewDetialDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "View detail screen");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "View detail screen");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Create button\r\n" + "2. Edit button");
		appraisalCycle.clickBtnBackViewDetail();
		if (appraisalCycle.isBtnCreateStyleNoneDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create button");
		}

		TestLogger.info("11. Delete Appraisal Cycle");
		appraisalCycle.deleteAppraisalCycle("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Appraisal Cycle deleted  successfully!");
		if (appraisalCycle.isMsgDeleteCycleSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Appraisal Cycle deleted  successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Appraisal Cycle deleted  successfully!");
		}

		TestLogger.info("==========End TT_1029================");
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
