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
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddImmigration;
import talentwize.pages.Form_AddRightToWork;
import talentwize.pages.Form_UpdateImmigration;
import talentwize.pages.Form_UpdateRightToWork;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;
import talentwize.pages.WorkMobility;

public class Test_FunctionalAccess_MyED_MyWorkMobility extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	PersonalDetails personalDetails;
	ContactDetails contactDetails;
	CompanyJobHistory companyJobHistory;
	WorkMobility workmobility;
	Form_AddImmigration addimmigration;
	Form_AddRightToWork addrighttowork;
	Form_UpdateImmigration updateimmigration;
	Form_UpdateRightToWork updaterighttowork;

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
		employeeList = new EmployeeList(driver);
		personalDetails = new PersonalDetails(driver);
		contactDetails = new ContactDetails(driver);
		companyJobHistory = new CompanyJobHistory(driver);
		workmobility = new WorkMobility(driver);
		addimmigration = new Form_AddImmigration(driver);
		addrighttowork = new Form_AddRightToWork(driver);
		updateimmigration = new Form_UpdateImmigration(driver);
		updaterighttowork = new Form_UpdateRightToWork(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1495() throws InterruptedException {
		TestLogger.info("==========TT_1495================");
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
		UserRoleName = "Permission|MyED_MyWorkMobility|NoPermission" + TienIch.taoRandomSo(3);

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
		administration.clickMenuEmployeeData();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "Work mobility menu");
		if (administration.isSubMenuWorkMobilityDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Work mobility menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Work mobility menu");
		}

		TestLogger.info("==========TT_1495================");
	}

	@Test(priority = 2)
	public void TT_1491() throws InterruptedException {
		TestLogger.info("==========TT_1491================");
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
		UserRoleName = "Permission|MyED_MyWorkMobility|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Check on My ED - My Work Mobility | Create");
		roles.checkBox_Create_MyED_WorkMobility();

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
		administration.clickMenuEmployeeData();
		administration.clickSubMenuWorkMobility();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Work mobility menu\r\n"
				+ "2. Add btn in Immigration panel\r\n" + "3. Add btn in Right To Work panel");

		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Work mobility menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Work mobility menu");
		}

		if (workmobility.isbtnAddImmigrationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Add btn in Immigration panel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Add btn in Immigration panel");
		}

		if (workmobility.isbtnAddRightToWorkDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Add btn in Right To Work panel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Add btn in Right To Work panel");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Link Edit in Immigration panel\r\n"
				+ "2. Link Edit in Right To Work panel\r\n" + "3. Delete function in  Immigration panel\r\n"
				+ "4. Delete function in Right To Work panel");

		if (workmobility.isLinkOfImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Link Edit in Immigration pane");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Link Edit in Immigration pane");
		}

		if (workmobility.isLinkOfRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Link Edit in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Link Edit in Right To Work panel");
		}

		if (workmobility.isbtnDeleteImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function in  Immigration panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function in  Immigration panel");
		}

		if (workmobility.isbtnDeleteRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function in Right To Work panel");
		}

		TestLogger.info("9. Add New Immigration");
		workmobility.clickBtnAddImmigration();
		addimmigration.addImmigration("01-Feb-2015", "31-Dec-2020", "A001");

		if (workmobility.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}

		TestLogger.info("10. Add New Right To Work");
		workmobility.clickbtnAddRightToWork();
		addrighttowork.addRightToWork("From", "To", "01-Feb-2015", "31-Dec-2020");

		if (workmobility.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}

		TestLogger.info("==========TT_1495================");
	}

	@Test(priority = 3)
	public void TT_1493() throws InterruptedException {
		TestLogger.info("==========TT_1493================");
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
		UserRoleName = "Permission|MyED_MyWorkMobility|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Check on My ED - My Work Mobility | Read");
		roles.checkBox_Read_MyED_WorkMobility();

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
		administration.clickMenuEmployeeData();
		administration.clickSubMenuWorkMobility();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Work mobility menu");

		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Work mobility menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Work mobility menu");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Link Edit in Immigration panel\r\n"
				+ "2. Link Edit in Right To Work panel\r\n" + "3. Delete function in  Immigration panel\r\n"
				+ "4. Delete function in Right To Work panel\r\n" + "5. Add btn in Immigration panel\r\n"
				+ "6. Add btn in Right To Work panel");

		if (workmobility.isLinkOfImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Link Edit in Immigration pane");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Link Edit in Immigration pane");
		}

		if (workmobility.isLinkOfRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Link Edit in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Link Edit in Right To Work panel");
		}

		if (workmobility.isbtnDeleteImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function in  Immigration panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function in  Immigration panel");
		}

		if (workmobility.isbtnDeleteRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function in Right To Work panel");
		}

		if (workmobility.isbtnAddImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Add btn in Immigration panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Add btn in Immigration panel");
		}

		if (workmobility.isbtnAddRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Add btn in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Add btn in Right To Work panel");
		}

		TestLogger.info("==========TT_1493================");
	}

	@Test(priority = 4)
	public void TT_1487() throws InterruptedException {
		TestLogger.info("==========TT_1487================");
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
		UserRoleName = "Permission|MyED_MyWorkMobility|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Check on My ED - My Work Mobility | Update");
		roles.checkBox_Update_MyED_WorkMobility();

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
		administration.clickMenuEmployeeData();
		administration.clickSubMenuWorkMobility();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Work mobility menu\r\n"
				+ "2. Link Edit in Immigration panel\r\n" + "3. Link Edit in Right To Work panel");

		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Work mobility menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Work mobility menu");
		}

		if (workmobility.isLinkOfImmigrationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Edit in Immigration panel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Edit in Immigration panel");
		}

		if (workmobility.isLinkOfRightToWorkDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Link Edit in Right To Work panel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Link Edit in Right To Work panel");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Add btn in Immigration panel\r\n"
				+ "2. Add btn in Right To Work panel\r\n" + "3. Delete function in  Immigration panel\r\n"
				+ "4. Delete function in Right To Work panel");

		if (workmobility.isbtnAddImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Add btn in Immigration pane");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Add btn in Immigration pane");
		}

		if (workmobility.isbtnAddRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Add btn in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Add btn in Right To Work panel");
		}

		if (workmobility.isbtnDeleteImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function in  Immigration panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function in  Immigration panel");
		}

		if (workmobility.isbtnDeleteRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function in Right To Work panel");
		}

		TestLogger.info("9. Update Immigration");

		workmobility.clickLinkOfImmigration();
		updateimmigration.clickButtonSave();
		if (workmobility.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}

		TestLogger.info("10. Update Right To Work");

		workmobility.clickLinkOfRightToWork();
		updaterighttowork.clickButtonSave();
		if (workmobility.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}

		TestLogger.info("==========TT_1487================");
	}

	@Test(priority = 5)
	public void TT_1481() throws InterruptedException {
		TestLogger.info("==========TT_1481================");
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
		UserRoleName = "Permission|MyED_MyWorkMobility|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeUser(UserRoleName);

		TestLogger.info("4. Check on My ED - My Work Mobility | Delete");
		roles.checkBox_Delete_MyED_WorkMobility();

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
		administration.clickMenuEmployeeData();
		administration.clickSubMenuWorkMobility();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Work mobility menu\r\n"
				+ "2. Delete function in Immigration panel\r\n" + "3. Delete function in Right To Work panel");

		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Work mobility menu");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Work mobility menu");
		}

		if (workmobility.isbtnDeleteImmigrationDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function in Immigration panel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function in Immigration panel");
		}

		if (workmobility.isbtnDeleteRightToWorkDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function in Right To Work panel");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function in Right To Work panel");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Link Edit in Immigration panel\r\n"
				+ "2. Link Edit in Right To Work panel\r\n" + "3. Add btn in  Immigration panel\r\n"
				+ "4. Add btn in Right To Work panel");

		if (workmobility.isLinkOfImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Link Edit in Immigration pane");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Link Edit in Immigration pane");
		}

		if (workmobility.isLinkOfRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Link Edit in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Link Edit in Right To Work panel");
		}

		if (workmobility.isbtnAddImmigrationDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Add btn in  Immigration panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Add btn in  Immigration panel");
		}

		if (workmobility.isbtnAddRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Add btn in Right To Work panel");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Add btn in Right To Work panel");
		}

		TestLogger.info("9. Delete Immigration");
		workmobility.deleteImmigration();

		if (workmobility.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Deleted successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Deleted successfully");
		}

		TestLogger.info("10. Delete Right To Work");

		workmobility.deleteRightToWork();
		if (workmobility.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Deleted successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Deleted successfully");
		}

		TestLogger.info("==========TT_1481================");
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
