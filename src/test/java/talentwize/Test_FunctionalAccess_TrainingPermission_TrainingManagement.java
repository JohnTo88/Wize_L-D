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
import talentwize.pages.Form_AssignTrainingManagement;
import talentwize.pages.Form_EditTrainingManagement;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.TrainingManagement;
import talentwize.pages.Users;

//Bug: TAL-514
public class Test_FunctionalAccess_TrainingPermission_TrainingManagement extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	TrainingManagement trainingManagement;
	Form_AssignTrainingManagement formAssignTrainingManagement;
	Form_EditTrainingManagement formEditTrainingManagement;

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
		trainingManagement = new TrainingManagement(driver);
		formAssignTrainingManagement = new Form_AssignTrainingManagement(driver);
		formEditTrainingManagement = new Form_EditTrainingManagement(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1159() throws InterruptedException {

		TestLogger.info("================ TT_1159================");
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
		UserRoleName = "Permission|TrainingManagement|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Training Management | Read");
		roles.uncheckbox_Read_TrainingManagement();

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

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Menu Training Management");
		if (administration.isMenuTrainingDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Menu Training Management");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Menu Training Management");
		}

		TestLogger.info("==========End TT_1159================");
	}

	// Bug: TAL-514
	@Test(priority = 2)
	public void TT_1140() throws InterruptedException {

		TestLogger.info("========== TT_1140================");
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
		UserRoleName = "Training Permission|Training Management|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Training Management | Read");
		roles.uncheckbox_Read_TrainingManagement();

		TestLogger.info("5. Check | Training Permission - Training Management | Read");
		roles.checkbox_Read_TrainingManagement();

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
		administration.clickSubMenuTrainingManagement();
		trainingManagement.filterStatus();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table");

		if (administration.isSubTabTrainingManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Link Code\r\n" + "2. Cancel function\r\n"
				+ "3. Assign button");

		if (trainingManagement.isIcoCancelDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Cancel function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Cancel function");
		}

		if (trainingManagement.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Assign button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Assign button");
		}

		if (trainingManagement.isLinkCodeDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Link Code");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Link Code");
		}

		TestLogger.info("==========End TT_1140================");
	}

	// Bug: TAL-514
	@Test(priority = 3)
	public void TT_1142() throws InterruptedException {

		TestLogger.info("========== TT_1142================");
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
		UserRoleName = "Training Permission|TrainingManagement|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - Training Management | Read");
		roles.uncheckbox_Read_TrainingManagement();

		TestLogger.info("5. Check | Training Permission - Training Management | Update");
		roles.checkbox_Update_TrainingManagement();

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
		administration.clickSubMenuTrainingManagement();
		trainingManagement.filterStatus();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Assign button\r\n"
				+ "3. Code hyperlink > Course/Program Information");

		trainingManagement.clickLinkCode();
		if (formEditTrainingManagement.isLblCourseDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Course/Program Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Course/Program Information");
		}

		formEditTrainingManagement.clickBtnClose();
		if (administration.isSubTabTrainingManagementDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (trainingManagement.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Assign button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Assign button");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1.Cancel function");

		if (trainingManagement.isIcoCancelDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Cancel function");
		} else {
			setStatusTest("fail", "User  CAN NOT see/do:\r\n" + "Cancel function");
		}

		TestLogger.info("10. Courses marked");
		trainingManagement.clickLinkCode();
		formEditTrainingManagement.markScore(TienIch.taoRandomSo(2));

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Courses marked successfully");

		if (formEditTrainingManagement.isMsgMarkedSuccessDisplayed() == true)

		{
			setStatusTest("pass", "User CAN see/do:\r\n" + "Courses marked successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Courses marked successfully");
		}

		TestLogger.info("11. Assign Program");
		formEditTrainingManagement.clickBtnClose();
		trainingManagement.clickBtnAssign();
		formAssignTrainingManagement.clickBtnSave();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Update Assign Program successfully!");

		if (trainingManagement.isMsgAssginSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update Assign Program successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update Assign Program successfully!");
		}

		TestLogger.info("==========End TT_1142================");
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
