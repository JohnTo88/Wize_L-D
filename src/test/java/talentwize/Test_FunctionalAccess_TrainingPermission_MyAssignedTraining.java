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
import talentwize.pages.MyAssignedTraining;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TrainingPermission_MyAssignedTraining extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfProgram;
	MyAssignedTraining myAssignedTraining;

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
		myAssignedTraining = new MyAssignedTraining(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1119() throws InterruptedException {
		TestLogger.info("========== TT_1119================");
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
		UserRoleName = "Permission|MyAssignedTraining|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Uncheck | Training Permission - My Assigned Training | Read");
		roles.uncheckbox_Read_MyAssignedTraining();

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

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Menu Assgined Training");
		if (administration.isSubMenuMyAssignedTrainingDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Menu Assgined Training");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Menu Assgined Training");
		}

		TestLogger.info("==========End TT_1119================");
	}

	@Test(priority = 2)
	public void TT_1144() throws InterruptedException {
		TestLogger.info("========== TT_1144================");
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
		UserRoleName = "Permission|MyAssignedTraining|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("5. Log out");

		dashboard.logout();

		TestLogger.info("6. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("7. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTraining();
		administration.clickSubMenuMyAssignedTraining();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Course Information");
		if (myAssignedTraining.isLblMyAssignedDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		myAssignedTraining.clickLinkCourseInfo();
		if (myAssignedTraining.isLblCourseInformationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Course Information");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Course Information");
		}

		TestLogger.info("==========End TT_1144================");
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
