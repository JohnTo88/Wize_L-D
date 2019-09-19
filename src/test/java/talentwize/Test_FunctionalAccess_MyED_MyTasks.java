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

public class Test_FunctionalAccess_MyED_MyTasks extends TestManager {

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
	public void TT_1478() throws InterruptedException {
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
		UserRoleName = "Automation-ED-Tasks_No_permission" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info(" UnChecked on My Tasks | No permission");
		roles.uncheckbox_Read_My_Tasks();

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

		if (administration.isSubMenuTasksDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Tasks menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Tasks menu");
		}

	}

	@Test(priority = 2)
	public void TT_1484() throws InterruptedException {
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

		TestLogger.info("3.Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "My ED|My Tasks|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info(" 4. UnChecked on My Tasks | Create");
		roles.uncheckbox_Read_My_Tasks();
		TestLogger.info("Checked on My - Tasks | Create");
		roles.checkbox_Create_My_Tasks();
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

		if (administration.isSubMenuTasksDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Tasks menu\r\n" + "");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Tasks menu\r\n" + "");
		}

		administration.clickSubMenuTasks();
		if (tasks.isButtonAddDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "" + "2. Add  btn");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "" + "2. Add  btn");
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
	public void TT_1486() throws InterruptedException {
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
		UserRoleName = "My-Tasks_Read" + TienIch.taoRandomSo(2);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info(" UnChecked on My - Tasks | Read");
		roles.uncheckbox_Read_My_Tasks();
		TestLogger.info("Checked on My - Tasks | Read");
		roles.checkbox_Read_My_Tasks();
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
	public void TT_1483() throws InterruptedException {
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
		UserRoleName = "My ED|My Tasks|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info(" UnChecked on My - Tasks | Update");
		roles.uncheckbox_Read_My_Tasks();
		TestLogger.info("Checked on My - Tasks | Update");
		roles.checkbox_Update_My_Tasks();
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

	@Test(priority = 5)
	public void TT_1481() throws InterruptedException {
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
		UserRoleName = "My ED|My Work Mobility|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info(" UnChecked on My - Tasks | Read");
		roles.uncheckbox_Read_My_Tasks();

		TestLogger.info("Checked on My - Tasks | Delete");
		roles.checkbox_Delete_My_Tasks();

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
