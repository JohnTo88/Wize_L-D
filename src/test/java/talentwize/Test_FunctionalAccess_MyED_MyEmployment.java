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
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Employment;
import talentwize.pages.Form_AddInterviewHistory;
import talentwize.pages.Form_EditInterviewHistory;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Users;

// BUG : http://10.17.14.203:8080/browse/TAL-546 
public class Test_FunctionalAccess_MyED_MyEmployment extends TestManager {

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
	Employment employment;
	Form_AddInterviewHistory formAddInterviewHistory;
	Form_EditInterviewHistory formEditInterviewHistory;

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
		employment = new Employment(driver);
		formEditInterviewHistory = new Form_EditInterviewHistory(driver);
		formAddInterviewHistory = new Form_AddInterviewHistory(driver);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1473() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-My-Employment_No_permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();
		TestLogger.info(" UnChecked on My Employement | Read");
		roles.uncheckbox_Read_My_Employment();

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

		administration.clickMenuEmployeeData();

		if (administration.isSubMenuEmploymentDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Employment menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Employment menu");
		}

	}

	@Test(priority = 2)
	public void TT_1477() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-My-Employment_Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();
		TestLogger.info(" + Check on My - Employement | Create");
		roles.uncheckbox_Read_My_Employment();
		roles.checkbox_Create_My_Employment();

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

		administration.clickMenuEmployeeData();

		if (administration.isSubMenuEmploymentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Employment menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. Employment menu");
		}

		administration.clickSubMenuEmployment();

		TestLogger.info("User CANNOT see/do:\r\n" + "" + "2. Clickable on Interviewed By name\r\n" + "4. Delete btn\r\n"
				+ "5. Edit btn");

		if (employment.isBtnDeleteDisplayed() == false && employment.isLinkInterviewerDisplayed() == false
				&& employment.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. " + "2. Clickable on Interviewed By name\r\n"
					+ "4. Delete btn\r\n" + "5. Edit btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "" + "2. Clickable on Interviewed By name\r\n"
					+ "4. Delete btn\r\n" + "5. Edit btn");
		}

		employment.clickButtonAdd();
		formAddInterviewHistory.addInterviewer();

		if (employment.isMessageAddSuccessDisplayed() == true) {
			setStatusTest("pass", "Show Added successfully ! ");
		} else {
			setStatusTest("fail", "DOES NOT : Show Added successfully !");
		}

	}

	@Test(priority = 3)
	public void TT_1479() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-My-Employment_Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();
		TestLogger.info(" + Check on My Employement | Read");
		roles.uncheckbox_Read_My_Employment();
		roles.checkbox_Read_My_Employment();

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

		TestLogger.info("8.Open Employee Data menu");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuEmploymentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Employment menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. Employment menu");
		}

		administration.clickSubMenuEmployment();

		TestLogger.info("User CANNOT see/do:\r\n" + "" + "2. Clickable on Interviewed By name\r\n" + "4. Delete btn\r\n"
				+ "5. Edit btn");

		if (employment.isBtnAddDisplayed() == false && employment.isBtnDeleteDisplayed() == false
				&& employment.isLinkInterviewerDisplayed() == false && employment.isBtnEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. " + "2. Clickable on Interviewed By name\r\n"
					+ "4. Delete btn\r\n" + "5. Edit btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "" + "2. Clickable on Interviewed By name\r\n"
					+ "4. Delete btn\r\n" + "5. Edit btn");
		}

	}

	@Test(priority = 4)
	public void TT_1476() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation-ED-Employment_Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();
		TestLogger.info(" + Check on My - Employement | Update");
		roles.uncheckbox_Read_My_Employment();
		roles.checkbox_Update_My_Employment();

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

		TestLogger.info("8.Open Employee Data menu");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuEmploymentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Employment menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. Employment menu");
		}

		administration.clickSubMenuEmployment();

		TestLogger.info("User CANNOT see/do:\r\n" + "" + "2. Clickable on Interviewed By name\r\n" + "4. Delete btn\r\n"
				+ "5. Edit btn");

		if (employment.isLinkInterviewerDisplayed() == true && employment.isBtnEditDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. " + "2. Clickable on Interviewed By name\r\n" + "3. Edit btn");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. " + "2. Clickable on Interviewed By name\r\n" + "3. Edit btn");
		}

		if (employment.isBtnAddDisplayed() == false && employment.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Delete btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "2. Delete btn");
		}

		employment.clickLinkInterview();

		formEditInterviewHistory.editInterviewHistory();
		if (employment.isMessageUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "The system displays msg: Updated successfully!");
		} else {
			setStatusTest("fail", "The system DOES NOT display msg: Updated successfully!");
		}

	}

	@Test(priority = 5)
	public void TT_1475() throws InterruptedException {
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

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My ED|My Employment|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");

		roles.uncheck_View_Employees();
		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();
		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();
		TestLogger.info(" + Check on My - Employement | Delete");
		roles.uncheckbox_Read_My_Employment();
		roles.checkbox_Delete_My_Employment();

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

		TestLogger.info("8.Open Employee Data menu");
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuEmploymentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Employment menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. Employment menu");
		}

		administration.clickSubMenuEmployment();

		TestLogger.info("User can see /do:\r\n" + "" + "2. Delete btn");

		if (employment.isBtnDeleteDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Delete btn");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "2. Delete btn");
		}

		TestLogger.info("User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Clickable on Interviewed By name\r\n"
				+ "3. Edit btn");

		if (employment.isBtnAddDisplayed() == false && employment.isBtnEditDisplayed() == false
				&& employment.isLinkInterviewerDisplayed() == false) {
			setStatusTest("pass",
					" User CANNOT see/do: 1. Add  btn\r\n" + "2. Clickable on Interviewed By name\r\n" + "3. Edit btn");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n"
					+ "2. Clickable on Interviewed By name\r\n" + "3. Edit btn");
		}

		employment.deleteInterviewHistory();
		if (employment.isMessageDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "The system displays msg: Deleted successfully!");
		} else {
			setStatusTest("fail", "The system DOES NOT display msg: Deleted successfully!");
		}

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
