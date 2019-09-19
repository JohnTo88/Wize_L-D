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
import talentwize.pages.Form_AddTask_Timesheet;
import talentwize.pages.Form_AddTimeOff;
import talentwize.pages.Form_CopyTask_Timesheet;
import talentwize.pages.Form_EditTask_Timesheet;
import talentwize.pages.Form_EditTimeOff;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.TimesheetConfigurations;
import talentwize.pages.TimesheetConfigurations_Task;
import talentwize.pages.TimesheetConfigurations_TimeOff;
import talentwize.pages.TimesheetManagement;
import talentwize.pages.Users;

public class Test_FunctionalAccess_TimesheetPermission_Timesheet_Configuration extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	String NameOfTask;
	TimesheetManagement timesheetManagement;
	TimesheetConfigurations timesheetConfigurations;
	TimesheetConfigurations_Task task;
	TimesheetConfigurations_TimeOff timeOff;
	Form_AddTask_Timesheet formAddTask;
	Form_CopyTask_Timesheet formCopyTask;
	Form_EditTask_Timesheet formEditTask;
	Form_AddTimeOff formAddTimeOff;
	Form_EditTimeOff formEditTimeOff;

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
		timesheetManagement = new TimesheetManagement(driver);
		timesheetConfigurations = new TimesheetConfigurations(driver);
		task = new TimesheetConfigurations_Task(driver);
		timeOff = new TimesheetConfigurations_TimeOff(driver);
		formAddTask = new Form_AddTask_Timesheet(driver);
		formCopyTask = new Form_CopyTask_Timesheet(driver);
		formEditTask = new Form_EditTask_Timesheet(driver);
		formAddTimeOff = new Form_AddTimeOff(driver);
		formEditTimeOff = new Form_EditTimeOff(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1134() throws InterruptedException {
		TestLogger.info("==========TT_1134================");
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
		UserRoleName = "Permission|TimesheetConfiguration|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5.Check Timesheet - Management | Read");
		roles.checkbox_Read_Timesheet_Management();

		TestLogger.info("6. Uncheck Timesheet - Configuration | Read");
		roles.unCheckbox_Read_Timesheet_Configuration();

		TestLogger.info("7. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("8. Log out");

		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("10. Check permission");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Tab Task\r\n" + "2. Tab Time Off");
		if (timesheetConfigurations.isSubTabTaskDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Tab Task");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Tab Task");
		}

		if (timesheetConfigurations.isSubTabTimeOffDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Tab Time Off");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Tab Time Off");
		}

		TestLogger.info("==========End TT_1134================");
	}

	@Test(priority = 2)
	public void TT_1132() throws InterruptedException {
		TestLogger.info("==========TT_1132================");
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
		UserRoleName = "Permission|TimesheetConfiguration|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5.Check Timesheet - Management | Read");
		roles.checkbox_Read_Timesheet_Management();

		TestLogger.info("6. Uncheck Timesheet - Configuration | Read");
		roles.unCheckbox_Read_Timesheet_Configuration();

		TestLogger.info("7. Check Timesheet - Configuration | Create");
		roles.checkbox_Create_Timesheet_Configuration();

		TestLogger.info("8. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("9. Log out");

		dashboard.logout();

		TestLogger.info("10. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("11. Open Timesheet Board >> Settings >> Task");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.clickBtnSettings();
		timesheetConfigurations.clickSubTabTask();

		TestLogger.info("12. Add Task");
		task.clickBtnAddTask();
		NameOfTask = "Test Automation" + TienIch.taoRandomSo(3);
		formAddTask.addTask(NameOfTask);

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Task added successfully!");

		if (task.isMsgAddSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Task added successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Task added successfully!");
		}

		TestLogger.info("13. Copy Task");
		task.clickBtnCopyTasks();
		formCopyTask.cloneTasks();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Tasks clones successfully!");

		if (task.isMsgCloneSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Tasks clones successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Tasks clones successfully!");
		}

		TestLogger.info("14. Check permission in Task");
		task.fillTxtSearchTask("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button Copy Task\r\n"
				+ "3. button Add Task");

		if (timesheetConfigurations.isSubTabTaskDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (task.isBtnCopyTasksDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Copy Task");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Copy Task");
		}

		if (task.isBtnAddTaskDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button Add Task");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button Add Task");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Delete function\r\n" + "2. Edit function");

		if (task.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		if (task.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit function");
		}

		TestLogger.info("15. Add Time Off");
		timesheetConfigurations.clickSubTabTimeOff();
		timeOff.clickBtnAddTimeOff();
		formAddTimeOff.addTimeOff(NameOfTask);

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Time off added successfully!");

		if (timeOff.isMsgAddSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Time off added successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Time off added successfully!");
		}

		TestLogger.info("16. Check permission in Time Off");
		timeOff.fillTxtTimeOff("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. button  Add Time Off");

		if (timesheetConfigurations.isSubTabTimeOffDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (timeOff.isBtnAddTimeOffDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "button  Add Time Off");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "button  Add Time Off");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Delete function\r\n" + "2. Edit function");

		if (timeOff.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		if (timeOff.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit function");
		}

		TestLogger.info("==========End TT_1132================");
	}

	@Test(priority = 3)
	public void TT_1130() throws InterruptedException {
		TestLogger.info("==========TT_1130================");
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
		UserRoleName = "Permission|TimesheetConfiguration|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5.Check Timesheet - Management | Read");
		roles.checkbox_Read_Timesheet_Management();

		TestLogger.info("6. Uncheck Timesheet - Configuration | Read");
		roles.unCheckbox_Read_Timesheet_Configuration();

		TestLogger.info("7.Check Timesheet - Configuration | Read");
		roles.checkbox_Read_Timesheet_Configuration();

		TestLogger.info("8. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("9. Log out");

		dashboard.logout();

		TestLogger.info("10. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("11. Open Timesheet Board >> Settings >> Task");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.clickBtnSettings();
		timesheetConfigurations.clickSubTabTask();

		TestLogger.info("12. Check permission in Task");
		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table");

		if (timesheetConfigurations.isSubTabTaskDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Copy Task\r\n" + "2. button Add Task\r\n"
				+ "3. Delete function\r\n" + "4. Edit fucntion");

		if (task.isBtnCopyTasksDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Copy Task");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Copy Task");
		}

		if (task.isBtnAddTaskDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Add Task");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Add Task");
		}

		if (task.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit fucntion");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit fucntion");
		}

		if (task.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("11. Check permission in Time Off");
		timesheetConfigurations.clickSubTabTimeOff();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table");

		if (timesheetConfigurations.isSubTabTimeOffDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. button Add Time Off\r\n" + "2. Delete function\r\n"
				+ "3. Edit fucntion");

		if (timeOff.isBtnAddTimeOffDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Add Time Off");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Copy Task");
		}

		if (timeOff.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit fucntion");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit fucntion");
		}

		if (timeOff.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		TestLogger.info("==========End TT_1130================");
	}

	@Test(priority = 4)
	public void TT_1131() throws InterruptedException {
		TestLogger.info("==========TT_1131================");
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
		UserRoleName = "Permission|TimesheetConfiguration|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5.Check Timesheet - Management | Read");
		roles.checkbox_Read_Timesheet_Management();

		TestLogger.info("6. Uncheck Timesheet - Configuration | Read");
		roles.unCheckbox_Read_Timesheet_Configuration();

		TestLogger.info("7. Check Timesheet - Configuration | Update");
		roles.checkbox_Update_Timesheet_Configuration();

		TestLogger.info("8. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("9. Log out");

		dashboard.logout();

		TestLogger.info("10. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("11. Open Timesheet Board >> Settings >> Task");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.clickBtnSettings();
		timesheetConfigurations.clickSubTabTask();

		TestLogger.info("12. Check permission in Task");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Edit function");

		if (timesheetConfigurations.isSubTabTaskDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (task.isLinkEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit function");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Delete function\r\n" + "2. button Copy Task\r\n"
				+ "3. button Add Task");

		if (task.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		if (task.isBtnCopyTasksDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Copy Task");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Copy Task");
		}

		if (task.isBtnAddTaskDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Add Task");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Add Task");
		}

		TestLogger.info("13. Update Task");
		task.clickLinkEdit();
		formEditTask.clickBtnSave();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Update task successfully!");

		if (task.isMsgEditSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update task successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update task successfully!");
		}

		TestLogger.info("14. Check permission in Time Off");
		timesheetConfigurations.clickSubTabTimeOff();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Edit function");

		if (timesheetConfigurations.isSubTabTimeOffDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (timeOff.isLinkEditDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit function");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Delete function\r\n" + "2. button  Add Time Off");

		if (timeOff.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Delete function");
		}

		if (timeOff.isBtnAddTimeOffDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button  Add Time Off");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button  Add Time Off");
		}

		TestLogger.info("15. Update Time Off");
		timeOff.clickLinkEdit2();
		formEditTimeOff.clickBtnSave();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Update time off successfully!");

		if (timeOff.isMsgUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update time off successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update time off successfully!");
		}

		TestLogger.info("==========End TT_1131================");
	}

	@Test(priority = 5)
	public void TT_1133() throws InterruptedException {
		TestLogger.info("==========TT_1133================");
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
		UserRoleName = "Permission|TimesheetConfiguration|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Timesheet - Management | Read");
		roles.unCheckbox_Read_Timesheet_Management();

		TestLogger.info("5.Check Timesheet - Management | Read");
		roles.checkbox_Read_Timesheet_Management();

		TestLogger.info("6. Uncheck Timesheet - Configuration | Read");
		roles.unCheckbox_Read_Timesheet_Configuration();

		TestLogger.info("7. Check Timesheet - Configuration | Delete");
		roles.checkbox_Delete_Timesheet_Configuration();

		TestLogger.info("8. Click on button Save");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("9. Log out");

		dashboard.logout();

		TestLogger.info("10. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("11. Open Timesheet Board >> Settings >> Task");
		administration.clickLogoTalentWize();
		administration.clickMenuTimesheet();
		administration.clickSubMenuTimesheetBoard();
		timesheetManagement.clickBtnSettings();
		timesheetConfigurations.clickSubTabTask();

		TestLogger.info("12. Check permission in Task");
		task.fillTxtSearchTask("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Delete function");

		if (timesheetConfigurations.isSubTabTaskDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (task.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit fucntion\r\n" + "2. button Copy Task\r\n"
				+ "3. button Add Task");

		if (task.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit function");
		}

		if (task.isBtnCopyTasksDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Copy Task");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Copy Task");
		}

		if (task.isBtnAddTaskDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button Add Task");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button Add Task");
		}

		TestLogger.info("13. Delete Task");
		task.deleteTasks();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Task deleted successfully!");

		if (task.isMsgDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Task deleted successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Task deleted successfully!");
		}

		TestLogger.info("14. Check permission in Time Off");
		timesheetConfigurations.clickSubTabTimeOff();
		timeOff.fillTxtTimeOff("Test Automation");

		TestLogger.info("Expect : User CAN see /do:\r\n" + "1. Data table\r\n" + "2. Delete function");

		if (timesheetConfigurations.isSubTabTimeOffDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (timeOff.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete function");
		}

		TestLogger.info("Expect : User CANNOT see /do:\r\n" + "1. Edit function\r\n" + "2. button  Add Time Off");

		if (timeOff.isLinkEditDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Edit function");
		}

		if (timeOff.isBtnAddTimeOffDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "button  Add Time Off");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "button  Add Time Off");
		}

		TestLogger.info("15. Delte Time Off");
		timeOff.deleteTimeOff();

		TestLogger.info("Expect : User CAN see /do:\r\n" + "Task deleted successfully!");

		if (timeOff.isMsgDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Task deleted successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Task deleted successfully!");
		}

		TestLogger.info("==========End TT_1133================");
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
