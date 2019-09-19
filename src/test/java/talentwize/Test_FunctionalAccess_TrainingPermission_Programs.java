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
import talentwize.pages.Form_AssignProgram;
import talentwize.pages.Form_CreateNewProgram;
import talentwize.pages.Form_EditProgramInformation;
import talentwize.pages.HomePage;
import talentwize.pages.Programs;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TrainingPermission_Programs extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfProgram;
	Programs programs;
	Form_CreateNewProgram formCreateNewProgram;
	Form_EditProgramInformation formEditProgramInformation;
	Form_AssignProgram formAssignProgram;

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
		programs = new Programs(driver);
		formCreateNewProgram = new Form_CreateNewProgram(driver);
		formEditProgramInformation = new Form_EditProgramInformation(driver);
		formAssignProgram = new Form_AssignProgram(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1174() throws InterruptedException {
		TestLogger.info("========== TT_1174================");
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
		UserRoleName = "Permission|Programs|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Programs | Read");
		roles.uncheckbox_Read_Programs();

		TestLogger.info("5. Click on button Save");
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

		TestLogger.info("8. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTraining();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Menu Programs");
		if (administration.isSubMenuProgramDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Menu Programs");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Menu Programs");
		}

		TestLogger.info("==========End TT_1174================");
	}

	@Test(priority = 2)
	public void TT_1165() throws InterruptedException {
		TestLogger.info("========== TT_1165================");
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
		UserRoleName = "Training Permission|Programs|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Programs | Read");
		roles.uncheckbox_Read_Programs();

		TestLogger.info("5. Check | Training Permission - Programs | Create");
		roles.checkbox_Create_Programs();

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

		TestLogger.info("9. Create New Program");

		administration.clickLogoTalentWize();
		administration.clickMenuTraining();
		administration.clickSubMenuProgram();
		programs.clickBtnCreate();

		NameOfProgram = "Test Automation" + TienIch.taoRandomSo(2);
		formCreateNewProgram.createNewProgram(NameOfProgram);

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Displays popup confirm");

		if (programs.isPopupComfirmDisplayed() == true)

		{
			setStatusTest("pass", "User CAN see/do:\r\n" + "Displays popup confirm");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Displays popup confirm");
		}

		TestLogger.info("10. Check Permission");
		programs.clickBtnLater();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Create button\r\n"
				+ "3. Program Name hyperlink >> Program Information");

		if (administration.isSubTabProgramsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (programs.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create button");
		}

		programs.clickLinkEdit();
		if (formEditProgramInformation.isLblPopupDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Program Name hyperlink >> Program Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+ "1. Program Name hyperlink >> Program Information >> Edit button\r\n" + "2. Delete function\r\n"
				+ "3. Assign button");

		if (formEditProgramInformation.isBtnEditDisplayed() == false) {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		} else {
			setStatusTest("fail",
					"User STIL CAN see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		}

		formEditProgramInformation.clickBtnClose();
		if (programs.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Delete function");
		}

		if (programs.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Assign button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Assign button");
		}

		TestLogger.info("==========End TT_1165================");
	}

	@Test(priority = 3)
	public void TT_1160() throws InterruptedException {
		TestLogger.info("========== TT_1160================");
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
		UserRoleName = "Training Permission|Programs|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Programs | Read");
		roles.uncheckbox_Read_Programs();

		TestLogger.info("5. Check | Training Permission - Programs | Read");
		roles.checkbox_Read_Programs();

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

		TestLogger.info("9. Check Permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTraining();
		administration.clickSubMenuProgram();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n"
				+ "2. Program Name hyperlink >> Program Information");

		if (administration.isSubTabProgramsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		programs.clickLinkEdit();
		if (formEditProgramInformation.isLblPopupDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Program Name hyperlink >> Program Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+ "1. Program Name hyperlink >> Program Information >> Edit button\r\n" + "2. Delete function\r\n"
				+ "3. Assign button\r\n" + "4. Create button");

		if (formEditProgramInformation.isBtnEditDisplayed() == false) {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		} else {
			setStatusTest("fail",
					"User STIL CAN see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		}

		formEditProgramInformation.clickBtnClose();
		if (programs.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Delete function");
		}

		if (programs.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Assign button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Assign button");
		}

		if (programs.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Create button");
		}

		TestLogger.info("==========End TT_1160================");
	}

	@Test(priority = 4)
	public void TT_1161() throws InterruptedException {
		TestLogger.info("========== TT_1161================");
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
		UserRoleName = "Training Permission|Programs|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Programs | Read");
		roles.uncheckbox_Read_Programs();

		TestLogger.info("5. Check | Training Permission - Programs | Update");
		roles.checkbox_Update_Programs();

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

		TestLogger.info("9. Check Permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTraining();
		administration.clickSubMenuProgram();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n"
				+ "2. Program Name hyperlink >> Program Information >> Edit button\r\n"
				+ "3. Program Name hyperlink >> Program Information\r\n" + "4. Assign button");

		if (administration.isSubTabProgramsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (programs.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Assign button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Assign button");
		}

		programs.clickLinkEdit();
		if (formEditProgramInformation.isLblPopupDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Program Name hyperlink >> Program Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information");
		}

		if (formEditProgramInformation.isBtnEditDisplayed() == true) {
			setStatusTest("pass",
					"User CAN see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		} else {
			setStatusTest("fail",
					"User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Delete function\r\n" + "2. Create button");

		formEditProgramInformation.clickBtnClose();
		if (programs.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create button");
		}

		if (programs.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("10. Update New Program");
		programs.clickLinkEdit();
		formEditProgramInformation.editProgram();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Program updated successfully");

		if (programs.isMsgUpdateSuccessDisplayed() == true)

		{
			setStatusTest("pass", "User CAN see/do:\r\n" + "Program updated successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Program updated successfully");
		}

		TestLogger.info("==========End TT_1161================");
	}

	@Test(priority = 5)
	public void TT_1169() throws InterruptedException {
		TestLogger.info("========== TT_1169================");
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
		UserRoleName = "Training Permission|Programs|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Programs | Read");
		roles.uncheckbox_Read_Programs();

		TestLogger.info("5. Check | Training Permission - Programs | Delete");
		roles.checkbox_Delete_Programs();

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

		TestLogger.info("9. Check Permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTraining();
		administration.clickSubMenuProgram();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n"
				+ "2. Program Name hyperlink >> Program Information\r\n" + "3. Delete function");

		if (administration.isSubTabProgramsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (programs.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function");
		}

		programs.clickLinkEdit();
		if (formEditProgramInformation.isLblPopupDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Program Name hyperlink >> Program Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n"
				+ "1. Program Name hyperlink >> Program Information >> Edit button\r\n" + "2. Assign button\r\n"
				+ "3. Create button");

		if (formEditProgramInformation.isBtnEditDisplayed() == false) {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		} else {
			setStatusTest("fail",
					"User STIL CAN see/do:\r\n" + "Program Name hyperlink >> Program Information >> Edit button");
		}

		formEditProgramInformation.clickBtnClose();

		if (programs.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Assign button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Assign button");
		}

		if (programs.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Create button");
		}

		TestLogger.info("10. Delete Programs");
		programs.deletePrograms("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Delete programs successfully!");

		if (programs.isMsgDeleteSuccessDisplayed() == true)

		{
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete programs successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete programs successfully!");
		}

		TestLogger.info("==========End TT_1169================");
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
