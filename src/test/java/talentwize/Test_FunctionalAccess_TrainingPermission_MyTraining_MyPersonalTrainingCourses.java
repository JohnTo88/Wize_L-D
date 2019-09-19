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
import talentwize.pages.Form_CreateCourse;
import talentwize.pages.Form_UpdateCourse;
import talentwize.pages.HomePage;
import talentwize.pages.MyTraining;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TrainingPermission_MyTraining_MyPersonalTrainingCourses extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfProgram;
	MyTraining myTraining;
	Form_UpdateCourse formUpdateCourse;
	Form_CreateCourse formCreateCourse;

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
		myTraining = new MyTraining(driver);
		formUpdateCourse = new Form_UpdateCourse(driver);
		formCreateCourse = new Form_CreateCourse(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1149() throws InterruptedException {
		TestLogger.info("========== TT_1149================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyTraining|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - My Training - My Personal Training Courses | Read");
		roles.uncheckbox_Read_MyTraining();

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

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Menu My Training");
		if (administration.isSubMenuMyTrainingDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Menu My Training");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Menu My Training");
		}

		TestLogger.info("==========End TT_1149================");
	}

	@Test(priority = 2)
	public void TT_1147() throws InterruptedException {
		TestLogger.info("========== TT_1147================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyTraining|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - My Training - My Personal Training Courses | Read");
		roles.uncheckbox_Read_MyTraining();

		TestLogger.info("5. Check | Training Permission -  My Training - My Personal Training Courses | Create");
		roles.checkbox_Create_MyTraining();

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
		administration.clickSubMeunuMyTraining();
		myTraining.clickBtnCreate();

		NameOfProgram = "Test Automation" + TienIch.taoRandomSo(2);
		formCreateCourse.createCoure(NameOfProgram);

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Create Course Popup");

		if (formCreateCourse.isLblCreateCourseDisplayed() == false)

		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create Course Popup");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Create Course Popup");
		}

		TestLogger.info("10. Check Permission");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Create button");

		if (myTraining.isLblMyTrainingDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myTraining.isBtnCreateDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create button");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit function\r\n" + "2. Delete function");

		if (myTraining.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Edit function");
		}

		if (myTraining.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("==========End TT_1147================");
	}

	@Test(priority = 3)
	public void TT_1145() throws InterruptedException {
		TestLogger.info("========== TT_1145================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyTraining|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - My Training - My Personal Training Courses | Read");
		roles.uncheckbox_Read_MyTraining();

		TestLogger.info("5. Check | Training Permission - My Training - My Personal Training Courses | Read");
		roles.checkbox_Read_MyTraining();

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
		administration.clickSubMeunuMyTraining();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table");

		if (myTraining.isLblMyTrainingDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit function\r\n" + "2. Delete function\r\n"
				+ "2. Create button");

		if (myTraining.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Edit function");
		}

		if (myTraining.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Delete function");
		}

		if (myTraining.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Create button");
		}

		TestLogger.info("==========End TT_1145================");
	}

	@Test(priority = 4)
	public void TT_1146() throws InterruptedException {
		TestLogger.info("========== TT_1146================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyTraining|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - My Training - My Personal Training Courses | Read");
		roles.uncheckbox_Read_MyTraining();

		TestLogger.info("5. Check | Training Permission - My Training - My Personal Training Courses | Update");
		roles.checkbox_Update_MyTraining();

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
		administration.clickSubMeunuMyTraining();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Edit function");

		if (myTraining.isLblMyTrainingDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myTraining.isLinkEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CANNOT CAN see/do:\r\n" + "Edit function");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Delete function\r\n" + "2. Create button");

		if (myTraining.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Delete function");
		}

		if (myTraining.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Create button");
		}

		TestLogger.info("10. Update New Program");
		myTraining.clickLinkEdit();
		formUpdateCourse.clickBtnSave();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Update Course Popup");

		if (formUpdateCourse.isLblUpdateCourseDisplayed() == false)

		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Update Course Popup");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Update Course Popup");
		}

		TestLogger.info("==========End TT_1146================");
	}

	@Test(priority = 5)
	public void TT_1148() throws InterruptedException {
		TestLogger.info("========== TT_1148================");
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

		TestLogger.info("3. Create Automation User Role Name and Role Type is User :");
		UserRoleName = "Permission|MyTraining|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - My Training - My Personal Training Courses | Read");
		roles.uncheckbox_Read_MyTraining();

		TestLogger.info("5. Check | Training Permission - My Training - My Personal Training Courses | Delete");
		roles.checkbox_Delete_MyTraining();

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
		administration.clickSubMeunuMyTraining();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Delete function");

		if (myTraining.isLblMyTrainingDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (myTraining.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CANNOT CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit function\r\n" + "2. Create button");

		if (myTraining.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Edit function");
		}

		if (myTraining.isBtnCreateDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Create button");
		} else {
			setStatusTest("fail", "User STIL CAN see/do:\r\n" + "Create button");
		}

		TestLogger.info("10. Delete Programs");
		myTraining.deleteCourse();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Remove successfully data ");

		if (myTraining.isCourseNameDisplayed() == false)

		{
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Remove successfully data");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Remove successfully data");
		}

		TestLogger.info("==========End TT_1148================");
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
