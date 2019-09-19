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
import talentwize.pages.Form_AddSuccessor;
import talentwize.pages.Form_CreateSuccessionPlan;
import talentwize.pages.Form_EditChosenSuccessor;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.SuccessionPlanningList;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TalentPermission_SuccessionPlanning_SuccessionPlanningBoard extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	SuccessionPlanningList successionPlanningList;
	Form_CreateSuccessionPlan formCreateSuccessionPlan;
	Form_AddSuccessor formAddSuccessor;
	Form_EditChosenSuccessor formEditChosenSuccessor;

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
		successionPlanningList = new SuccessionPlanningList(driver);
		formCreateSuccessionPlan = new Form_CreateSuccessionPlan(driver);
		formAddSuccessor = new Form_AddSuccessor(driver);
		formEditChosenSuccessor = new Form_EditChosenSuccessor(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1121() throws InterruptedException {
		TestLogger.info("==========TT_1121================");
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
		UserRoleName = "Permission|SuccessionBoard|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Succession Planning Board  | Read");
		roles.uncheckbox_Read_SuccessionPlanning_SuccessionPlanningBoard();

		TestLogger.info("5. Check Project Detail - Succession Planning Board  | Create");
		roles.checkbox_Create_SuccessionPlanning_SuccessionPlanningBoard();

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

		TestLogger.info("9. Add Succession");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuSuccessionPlanning();
		administration.clickSubMenuSuccessionBoard();
		successionPlanningList.clickBtnCreate();
		formCreateSuccessionPlan.createSuccessionPlanning("cuong automation 1", "cuong automation 1");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Add succession successfully");
		if (successionPlanningList.isMsgCreateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Add succession successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Add succession successfully");
		}

		TestLogger.info("10. Check permission");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Successor\r\n"
				+ "3. button Export\r\n" + "4. button Create\r\n" + "5. button Add Successor");
		successionPlanningList.clickIcoExpandKeymemeber();
		if (successionPlanningList.isLinkSuccessorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Successor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Successor");
		}

		if (successionPlanningList.isLblSuccessionPlanningDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (successionPlanningList.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		if (successionPlanningList.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Create");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Create");
		}

		if (successionPlanningList.isBtnAddSuccessorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Add Successor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Add Successor");
		}

		if (successionPlanningList.isLblSuccessionPlanningDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. icon Edit Succession Planning Status\r\n"
				+ "2. icon Edit Successor Status\r\n" + "3. button Edit Successor\r\n" + "4. Delete function");
		if (successionPlanningList.isIcoEditSuccessionStatusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "icon Edit Succession Planning Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "icon Edit Succession Planning Status");
		}

		if (successionPlanningList.isIcoEditSuccessorStatusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "icon Edit Successor Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "icon Edit Successor Status");
		}

		if (successionPlanningList.isBtnEditSuccessorDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Edit Successor");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Edit Successor");
		}

		if (successionPlanningList.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("11. Add Successor");
		successionPlanningList.clickBtnAddSuccessor();
		formAddSuccessor.addNewSuccessor("cuong automation 2");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Add succession successfully");
		if (successionPlanningList.isMsgCreateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Add succession successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Add succession successfully");
		}

		TestLogger.info("==========End TT_1121================");
	}

	@Test(priority = 2)
	public void TT_1117() throws InterruptedException {
		TestLogger.info("==========TT_1117================");
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
		UserRoleName = "Permission|SuccessionBoard|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Succession Planning Board  | Read");
		roles.uncheckbox_Read_SuccessionPlanning_SuccessionPlanningBoard();

		TestLogger.info("5. Check Project Detail - Succession Planning Board  | Read");
		roles.checkbox_Read_SuccessionPlanning_SuccessionPlanningBoard();

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

		TestLogger.info("9. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuSuccessionPlanning();
		administration.clickSubMenuSuccessionBoard();

		TestLogger.info(
				"Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Successor\r\n" + "3. button Export");
		successionPlanningList.clickIcoExpandKeymemeber();
		if (successionPlanningList.isLinkSuccessorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Successor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Successor");
		}

		if (successionPlanningList.isLblSuccessionPlanningDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (successionPlanningList.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. icon Edit Succession Planning Status\r\n"
				+ "2. icon Edit Successor Status\r\n" + "3. button Edit Successor\r\n" + "4. Delete function\r\n"
				+ "5. button Create\r\n" + "6. button Add Successor");
		if (successionPlanningList.isIcoEditSuccessionStatusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "icon Edit Succession Planning Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "icon Edit Succession Planning Status");
		}

		if (successionPlanningList.isIcoEditSuccessorStatusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "icon Edit Successor Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "icon Edit Successor Status");
		}

		if (successionPlanningList.isBtnEditSuccessorDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Edit Successor");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Edit Successor");
		}

		if (successionPlanningList.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		if (successionPlanningList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Create");
		}

		if (successionPlanningList.isBtnAddSuccessorDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Add Successor");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Add Successor");
		}

		TestLogger.info("==========End TT_1117================");
	}

	@Test(priority = 3)
	public void TT_1118() throws InterruptedException {
		TestLogger.info("==========TT_1118================");
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
		UserRoleName = "Permission|SuccessionBoard|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Succession Planning Board  | Read");
		roles.uncheckbox_Read_SuccessionPlanning_SuccessionPlanningBoard();

		TestLogger.info("5. Check Project Detail - Succession Planning Board  | Update");
		roles.checkbox_Update_SuccessionPlanning_SuccessionPlanningBoard();

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

		TestLogger.info("9. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuSuccessionPlanning();
		administration.clickSubMenuSuccessionBoard();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Successor\r\n"
				+ "3. button Export\r\n" + "4. button Edit Successor\r\n"
				+ "5. icon Edit Succession Planning Status\r\n" + "6. icon Edit Successor Status");

		successionPlanningList.clickIcoExpandKeymemeber();
		if (successionPlanningList.isLinkSuccessorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Successor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Successor");
		}

		if (successionPlanningList.isLblSuccessionPlanningDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (successionPlanningList.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		if (successionPlanningList.isBtnEditSuccessorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Edit Successor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Edit Successor");
		}

		if (successionPlanningList.isIcoEditSuccessionStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "icon Edit Succession Planning Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "icon Edit Succession Planning Status");
		}

		if (successionPlanningList.isIcoEditSuccessorStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "icon Edit Successor Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "icon Edit Successor Status");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Add Successor\r\n" + "2. button Create\r\n"
				+ "3. Delete function");

		if (successionPlanningList.isBtnAddSuccessorDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Add Successor");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Add Successor");
		}

		if (successionPlanningList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Create");
		}

		if (successionPlanningList.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("11. Update Successor");
		successionPlanningList.clickBtnEditSuccessor();
		formEditChosenSuccessor.clickBtnSubmit();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Update successor successfully!");
		if (successionPlanningList.isMsgUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update successor successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update successor successfully!");
		}

		TestLogger.info("12. Update Successor Status");
		successionPlanningList.editSuccessorStatus();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Submit successfully!");
		if (successionPlanningList.isMsgUpdateSuccessorStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Submit successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Submit successfully!");
		}

		TestLogger.info("12. Update Succession Status");
		successionPlanningList.editSuccessionStatus();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "icon Edit Succession Planning Status.");
		if (successionPlanningList.isBtnSummitSuccessionStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "icon Edit Succession Planning Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "icon Edit Succession Planning Status");
		}

		TestLogger.info("==========End TT_1118================");
	}

	@Test(priority = 4)
	public void TT_1122() throws InterruptedException {
		TestLogger.info("==========TT_1122================");
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
		UserRoleName = "Permission|SuccessionBoard|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Succession Planning Board  | Read");
		roles.uncheckbox_Read_SuccessionPlanning_SuccessionPlanningBoard();

		TestLogger.info("5. Check Project Detail - Succession Planning Board  | Delete");
		roles.checkbox_Delete_SuccessionPlanning_SuccessionPlanningBoard();

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

		TestLogger.info("9. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTalentManagement();
		administration.clickSubMenuSuccessionPlanning();
		administration.clickSubMenuSuccessionBoard();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Link Successor\r\n"
				+ "3. button Export\r\n" + "4. Delete function");
		successionPlanningList.clickIcoExpandKeymemeber();
		if (successionPlanningList.isLinkSuccessorDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Successor");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Successor");
		}

		if (successionPlanningList.isLblSuccessionPlanningDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (successionPlanningList.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Export");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Export");
		}

		if (successionPlanningList.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. icon Edit Succession Planning Status\r\n"
				+ "2. icon Edit Successor Status\r\n" + "3. button Edit Successor\r\n" + "4. button Create\r\n"
				+ "5. button Add Successor");
		if (successionPlanningList.isIcoEditSuccessionStatusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "icon Edit Succession Planning Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "icon Edit Succession Planning Status");
		}

		if (successionPlanningList.isIcoEditSuccessorStatusDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "icon Edit Successor Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "icon Edit Successor Status");
		}

		if (successionPlanningList.isBtnEditSuccessorDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Edit Successor");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Edit Successor");
		}

		if (successionPlanningList.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Create");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Create");
		}

		if (successionPlanningList.isBtnAddSuccessorDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Add Successor");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Add Successor");
		}

		TestLogger.info("11. Delete Successor");
		successionPlanningList.deleteSuccession();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Delete Successful");
		if (successionPlanningList.isMsgDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete Successful");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete Successful");
		}

		TestLogger.info("==========End TT_1122================");
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
