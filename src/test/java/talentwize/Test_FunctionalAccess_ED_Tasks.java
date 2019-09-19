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
import talentwize.pages.Form_AddTask;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.Roles;
import talentwize.pages.Tasks;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ED_Tasks extends TestManager {

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
	Tasks tasks;
	Form_AddTask formAddTask;

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
		tasks = new Tasks(driver);
		formAddTask = new Form_AddTask(driver);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_945() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation|ED-Tasks|NoPermission" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();

		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();

		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();

		TestLogger.info(" UnChecked on ED - Tasks | Read");
		roles.choose_UnCheckbox_Read_ED_Tasks();

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
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();

		if (administration.isSubMenuTasksDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Tasks menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Tasks menu");
		}

	}

	@Test(priority = 2)
	public void TT_941() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation|ED-Tasks|Create" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();

		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();

		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();

		TestLogger.info(" UnChecked on ED - Tasks | Create");
		roles.choose_UnCheckbox_Read_ED_Tasks();

		TestLogger.info("Checked on ED - Tasks | Create");
		roles.choose_checkbox_Create_ED_Tasks();

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
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();

		if (administration.isSubMenuTasksDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Tasks menu\r\n" + "");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Tasks menu\r\n" + "");
		}

		administration.clickSubMenuTasks();
		if (tasks.isButtonAddDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "2. Add  btn");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "2. Add  btn");
		}

		if (tasks.isLinkOfTasksDisplayed() == false && tasks.isIconDeletedDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "2. Hyperlink in Task Name\r\n"
					+ "3. Clickable Status radio\r\n" + "4. Delete btn");

		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "2. Hyperlink in Task Name\r\n"
					+ "3. Clickable Status radio\r\n" + "4. Delete btn");
		}

		tasks.clickButtonAdd();
		formAddTask.addTask(TienIch.taoRandomChu(12));
		if (tasks.isTextAddSuccesfullDisplayed() == true) {
			setStatusTest("pass", "The system display msg: Added successfully");
		} else {
			setStatusTest("fail", "The system DOES NOT display msg: Added successfully");
		}

	}

	@Test(priority = 3)
	public void TT_940() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation|ED-Tasks|Read" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();

		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();

		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();

		TestLogger.info(" UnChecked on ED - Tasks | Read");
		roles.choose_UnCheckbox_Read_ED_Tasks();

		TestLogger.info("Checked on ED - Tasks | Read");
		roles.choose_checkbox_Read_ED_Tasks();

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
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();

		if (administration.isSubMenuTasksDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Tasks menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. Tasks menu");
		}

		administration.clickSubMenuTasks();
		if (tasks.isButtonAddDisplayed() == false && tasks.isLinkOfTasksDisplayed() == false
				&& tasks.isIconDeletedDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Hyperlink in Task Name\r\n"
					+ "3. Clickable on Status radio\r\n" + "4. Delete btn");

		} else {
			setStatusTest("fail", "User Still CAN see/do:\r\n" + "1. Add  btn\r\n" + "2. Hyperlink in Task Name\r\n"
					+ "3. Clickable on Status radio\r\n" + "4. Delete btn");
		}

	}

	@Test(priority = 4)
	public void TT_942() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation|ED-Tasks|Update" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();

		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();

		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();

		TestLogger.info(" UnChecked on ED - Tasks | Update");
		roles.choose_UnCheckbox_Read_ED_Tasks();

		TestLogger.info("Checked on ED - Tasks | Update");
		roles.choose_checkbox_Update_ED_Tasks();

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
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();

		if (administration.isSubMenuTasksDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Tasks menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. Tasks menu");
		}

		administration.clickSubMenuTasks();

		if (tasks.isLinkOfTasksDisplayed() == true && tasks.isIconsStatusDisplayed() == true) {
			setStatusTest("pass", "USER CAN SEE /DO : 2. Hyperlink in Task Name\r\n" + "3. Clickable on Status radio");
		} else {
			setStatusTest("fail", "USER CAN NOT SEE /DO : 2. Hyperlink in Task Name\\r\\n\" + \r\n"
					+ "					\"3. Clickable on Status radio");
		}

		if (tasks.isButtonAddDisplayed() == false && tasks.isIconDeletedDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Delete btn");

		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "2. Delete btn");
		}

		TestLogger.info("Click on a Task Name to open Edit task popup\r\n" + "Click Save btn");
		tasks.clickInLinkOfTask();
		formAddTask.clickButtonSave();

		if (tasks.isTextUpdateSuccesfullDisplayed() == true) {
			setStatusTest("pass", "Show messsage : Update successfully ! ");
		} else {
			setStatusTest("fail", "DOES NOT Show messsage : Update successfully !");
		}
	}

	// ha.google@hotmail.com

	@Test(priority = 5, dependsOnMethods = "TT_941")
	public void TT_943() throws InterruptedException {
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login Successfully!");
		} else {
			setStatusTest("fail", "Login Fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Automation|ED-Tasks|Delete" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked all Employee List Permissions");
		roles.uncheck_View_Employees();

		TestLogger.info(" Check on View Employees");
		roles.check_View_Employees();

		TestLogger.info("+ Check on Update Employees Information");
		roles.check_Update_EmployeeInformation();

		TestLogger.info(" UnChecked on ED - Tasks | Delete");
		roles.choose_UnCheckbox_Read_ED_Tasks();

		TestLogger.info("Checked on ED - Tasks | Delete");
		roles.choose_checkbox_Delete_ED_Tasks();

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
		employeeList.searchEmployees(EmployeeList.NAME_OF_USER);
		employeeList.clickItemEmployeeNVN();

		if (administration.isSubMenuTasksDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Tasks menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. Tasks menu");
		}

		administration.clickSubMenuTasks();
		if (tasks.isIconDeletedDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Tasks menu\r\n" + "2. Delete btn");
		} else {
			setStatusTest("fail", "User can NOT ee /do:\r\n" + "1. Tasks menu\r\n" + "2. Delete btn");
		}

		if (tasks.isLinkOfTasksDisplayed() == false && tasks.isButtonAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Add  btn\r\n" + "2. Hyperlink in Task Name\r\n" + "");
		} else {
			setStatusTest("fail",
					"User STILL CAN see/do:\r\n" + "1. Add  btn\r\n" + "2. Hyperlink in Task Name\r\n" + "");
		}

		tasks.deleteTask();

		if (tasks.isTextDeletedSuccesfullDisplayed() == true) {
			setStatusTest("pass", "Show messsage : Deleted successfully ! ");
		} else {
			setStatusTest("fail", "DOES NOT Show messsage : Deleted successfully !");
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
