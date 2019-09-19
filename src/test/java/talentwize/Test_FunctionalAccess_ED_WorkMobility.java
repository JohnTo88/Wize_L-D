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

public class Test_FunctionalAccess_ED_WorkMobility extends TestManager {
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
	public void TT_587() throws InterruptedException {
		TestLogger.info("==========TT_587================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-ED-workmobility|No Permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked Employee List Permissions: Add, Delete, Update Employee Information");
		roles.choose_UnCheckbox_Employee_List_Permission_Add();
		roles.choose_UnCheckbox_Employee_List_Permission_Delete();
		roles.choose_UnCheckbox_Employee_List_Permission_Update_Employees_Information();
		TestLogger.info("+ UnCheck on ED - workmobility | read");
		roles.uncheck_Read_ED_WorkMobility();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailUserTW());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW());

		homePage.SignInWith(propertyManager.getEmailUserTW(), propertyManager.getPasswordUserTW());

		administration.clickMenuEmployeeList();
		employeeList.clickItemEmployee();
		if (administration.isSubMenuWorkMobilityDisplayed() == false) {
			setStatusTest("pass", "User CAN Not see/do:\r\n" + "workmobility menu");
		} else {
			setStatusTest("fail", "User still see/do:\r\n" + "workmobility menu");
		}
		TestLogger.info("==========TT_587================");
	}

	@Test(priority = 2)
	public void TT_589() throws InterruptedException {
		TestLogger.info("==========TT_589================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-ED-workmobility|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked Employee List Permissions: Add, Delete, Update Employee Information");
		roles.choose_UnCheckbox_Employee_List_Permission_Add();
		roles.choose_UnCheckbox_Employee_List_Permission_Delete();
		roles.choose_UnCheckbox_Employee_List_Permission_Update_Employees_Information();
		TestLogger.info("+ UnCheck on ED - workmobility | read");
		roles.uncheck_Read_ED_WorkMobility();
		TestLogger.info("+ Check on ED - workmobility | read");
		roles.check_Read_ED_WorkMobility();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickMenuEmployeeList();
		employeeList.clickItemEmployee();
		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "workmobility menu");
		} else {
			setStatusTest("fail", "User Can not see/do:\r\n" + "workmobility menu");
		}
		TestLogger.info("Click on sub menu work mobility");
		administration.clickSubMenuWorkMobility();
		if (workmobility.isbtnAddImmigrationDisplayed() == true && workmobility.isbtnAddRightToWorkDisplayed() == true
				&& workmobility.isLinkOfImmigrationDisplayed() == true
				&& workmobility.isLinkOfRightToWorkDisplayed() == true) {
			setStatusTest("fail", "User Still see/do:\r\n" + "1. Add btn in 2 panels\r\n"
					+ "2.  Clickable on Document Type name / Right to work");
		} else {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add btn in 2 panels\r\n"
					+ "2.  Clickable on Document Type name / Right to work");
		}
		TestLogger.info("==========TT_589================");
	}

	@Test(priority = 3)
	public void TT_591() throws InterruptedException {
		TestLogger.info("==========TT_591================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-ED-WorkMobility|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked Employee List Permissions: Add, Delete, Update Employee Information");
		roles.choose_UnCheckbox_Employee_List_Permission_Add();
		roles.choose_UnCheckbox_Employee_List_Permission_Delete();
		TestLogger.info("+ UnCheck on ED - Work Mobility | read");
		roles.uncheck_Read_ED_WorkMobility();
		TestLogger.info("+ Check on ED - Work Mobility  | Create");
		roles.check_Create_ED_WorkMobility();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickMenuEmployeeList();
		employeeList.clickItemEmployee();

		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "workmobility menu");
		} else {
			setStatusTest("fail", "User CAN Not see/do:\r\n" + "workmobility menu");
		}

		TestLogger.info("Click on Sub menu workmobility");
		administration.clickSubMenuWorkMobility();
		if (workmobility.isbtnDeleteImmigrationDisplayed() == true
				&& workmobility.isbtnDeleteRightToWorkDisplayed() == true) {
			setStatusTest("fail", "User Still see/do:\r\n" + "1. Delete btn in 2 panels\r\n"
					+ "2.  Clickable on Document Type name / Right to work");
		} else {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Delete btn in 2 panels\r\n"
					+ "2.  Clickable on Document Type name / Right to work");
		}
		// ============Add Immigration===========
		TestLogger.info("Click on Add button of Immigration");
		workmobility.clickBtnAddImmigration();
		addimmigration.addImmigration("01-Feb-2015", "31-Dec-2020", "A001");
		if (workmobility.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		// ============Add Right to Work================
		TestLogger.info("Click on Add Right to Work");
		workmobility.clickbtnAddRightToWork();
		addrighttowork.addRightToWork("From", "To", "01-Feb-2015", "31-Dec-2020");
		if (workmobility.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Added successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Added successfully");
		}
		TestLogger.info("==========TT_591================");
	}

	@Test(priority = 4)
	public void TT_593() throws InterruptedException {
		TestLogger.info("==========TT_593================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-ED-WorkMobility|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked Employee List Permissions: Add, Delete, Update Employee Information");
		roles.choose_UnCheckbox_Employee_List_Permission_Add();
		roles.choose_UnCheckbox_Employee_List_Permission_Delete();
		TestLogger.info("+ UnCheck on ED - Work Mobility | read");
		roles.uncheck_Read_ED_WorkMobility();
		TestLogger.info("+ Check on ED - Work Mobility  | Update");
		roles.check_Update_ED_WorkMobility();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickMenuEmployeeList();
		employeeList.clickItemEmployee();

		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "workmobility menu");
		} else {
			setStatusTest("fail", "User CAN Not see/do:\r\n" + "workmobility menu");
		}

		TestLogger.info("Click on sub menu workmobility");
		administration.clickSubMenuWorkMobility();
		if (workmobility.isbtnDeleteImmigrationDisplayed() == true
				&& workmobility.isbtnDeleteRightToWorkDisplayed() == true
				&& workmobility.isbtnAddImmigrationDisplayed() == true
				&& workmobility.isbtnAddRightToWorkDisplayed() == true) {
			setStatusTest("fail",
					"User Still see/do:\r\n" + "1. Delete btn in 2 panels\r\n" + "2. Add btn in 2 panels\\r\\n ");
		} else {
			setStatusTest("pass",
					"User CANNOT see/do:\r\n" + "1. Delete btn in 2 panels\r\n" + "2. Add btn in 2 panels\\r\\n ");
		}
		// ============Update Immigration===========
		TestLogger.info("Click Click Immigration name");
		workmobility.clickLinkOfImmigration();
		updateimmigration.clickButtonSave();
		if (workmobility.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		// ============Update Right to Work================
		TestLogger.info("Click on Right to Work name");
		workmobility.clickLinkOfRightToWork();
		updaterighttowork.clickButtonSave();
		if (workmobility.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Updated successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Updated successfully");
		}
		TestLogger.info("==========TT_593================");
	}

	@Test(priority = 5)
	public void TT_596() throws InterruptedException {
		TestLogger.info("==========TT_596================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-ED-WorkMobility|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked Employee List Permissions: Add, Delete, Update Employee Information");
		roles.choose_UnCheckbox_Employee_List_Permission_Add();
		roles.choose_UnCheckbox_Employee_List_Permission_Delete();
		TestLogger.info("+ UnCheck on ED - Work Mobility | read");
		roles.uncheck_Read_ED_WorkMobility();
		TestLogger.info("+ Check on ED - Work Mobility  | Delete");
		roles.check_Delete_ED_WorkMobility();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("7. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());

		administration.clickMenuEmployeeList();
		employeeList.clickItemEmployee();

		if (administration.isSubMenuWorkMobilityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "workmobility menu");
		} else {
			setStatusTest("fail", "User CAN Not see/do:\r\n" + "workmobility menu");
		}

		TestLogger.info("Click on sub menu workmobility");
		administration.clickSubMenuWorkMobility();
		if (workmobility.isbtnDeleteImmigrationDisplayed() == true
				&& workmobility.isbtnDeleteRightToWorkDisplayed() == true
				&& workmobility.isbtnAddImmigrationDisplayed() == false
				&& workmobility.isbtnAddRightToWorkDisplayed() == false
				&& workmobility.isLinkOfImmigrationDisplayed() == false
				&& workmobility.isLinkOfRightToWorkDisplayed() == false) {
			setStatusTest("pass", "User can see/do:\r\n" + "1.  Work mobility menu\r\n" + "2.  Immigration panel\r\n"
					+ " + delete btn\r\n" + "3.  Right To Work panel\r\n" + " + Delete btn" + "User CANNOT see/do:\r\n"
					+ "1.  Immigration panel\r\n" + " + Add btn\r\n" + " + Clickable on Document Type name\r\n"
					+ "2.  Right To Work panel\r\n" + " + Add btn \r\n" + " + Clickable on Right To Work  name ");
		} else {
			setStatusTest("fail", "User still see/do:\r\n" + "1.  Work mobility menu\r\n" + "2.  Immigration panel\r\n"
					+ " + delete btn\r\n" + "3.  Right To Work panel\r\n" + " + Delete btn" + "User CAN see/do:\r\n"
					+ "1.  Immigration panel\r\n" + " + Add btn\r\n" + " + Clickable on Document Type name\r\n"
					+ "2.  Right To Work panel\r\n" + " + Add btn \r\n" + " + Clickable on Right To Work  name ");
		}
		// ============Delete Immigration===========
		TestLogger.info("Delete Immigration");
		workmobility.deleteImmigration();
		if (workmobility.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Deleted successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Deleted successfully");
		}
		// ============Delete Right to Work================
		TestLogger.info("Delete Right to Work name");
		workmobility.deleteRightToWork();
		if (workmobility.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do message:\r\n" + "Deleted successfully");
		} else {
			setStatusTest("fail", "User CAN Not see/do message:\r\n" + "Deleted successfully");
		}
		TestLogger.info("==========TT_596================");
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
