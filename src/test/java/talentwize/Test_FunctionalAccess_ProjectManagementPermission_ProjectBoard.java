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
import talentwize.pages.ActualVolumeBoard;
import talentwize.pages.Administration;
import talentwize.pages.CheckInBoard;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_CreateProject;
import talentwize.pages.Form_EditActualVolume;
import talentwize.pages.Form_EditKPIDetail;
import talentwize.pages.Form_EditProject;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.ProjectBoard;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ProjectManagementPermission_ProjectBoard extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	KPIBoard kPIBoard;
	Form_EditKPIDetail editKPIDetail;
	CheckInBoard checkinBoard;
	ActualVolumeBoard actualVolumeBoard;
	ProjectBoard projectBoard;
	Form_EditActualVolume editActualVolume;
	Form_CreateProject createProject;
	Form_EditProject editProject;

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
		kPIBoard = new KPIBoard(driver);
		editKPIDetail = new Form_EditKPIDetail(driver);
		checkinBoard = new CheckInBoard(driver);
		actualVolumeBoard = new ActualVolumeBoard(driver);
		editActualVolume = new Form_EditActualVolume(driver);
		projectBoard = new ProjectBoard(driver);
		createProject = new Form_CreateProject(driver);
		editProject = new Form_EditProject(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_979() throws InterruptedException {
		TestLogger.info("=================TT_979 ====================");
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
		UserRoleName = "Project Settings|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked on Project Management Permission - Project Board | Read");
		roles.uncheckbox_Read_ProjectBoard();

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
		administration.clickMenuProjectManagement();

		if (administration.isSubMenuProjectBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Project Board menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Project Board menu");
		}

		TestLogger.info("=================END TT_979====================");

	}

	@Test(priority = 2)
	public void TT_974() throws InterruptedException {
		TestLogger.info("=================TT_974 ====================");
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
		UserRoleName = "Project Management|Project Board|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked on Project Management Permission - Project Board | Read");
		roles.uncheckbox_Read_ProjectBoard();
		TestLogger.info("Check on Project Management Permission - Project Board | Read");
		roles.checkbox_Read_ProjectBoard();

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

		TestLogger.info("Open Project Management >> Project Board");
		administration.scrollToBottomPage();
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		if (projectBoard.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button");
		}

		TestLogger.info("Expect : User cannot see/do:\r\n" + "1. Create button\r\n"
				+ "2. Action button > Project Information\r\n" + "3. Delete function");

		projectBoard.clickButtonAction();
		if (projectBoard.isIcoDeleteDisplayed() == false && projectBoard.isBtnCreateDisplayed() == false
				&& projectBoard.isBtnProjectInformationDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Create button\r\n"
					+ "2. Action button > Project Information\r\n" + "3. Delete function");
		} else {
			setStatusTest("fail", " User STILL can see/do:\r\n" + "1. Create button\r\n"
					+ "2. Action button > Project Information\r\n" + "3. Delete function");
		}

		TestLogger.info("=================END TT_974====================");

	}

	@Test(priority = 3)
	public void TT_977() throws InterruptedException {
		TestLogger.info("=================TT_977 ====================");
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
		UserRoleName = "Project Management|Project Board|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked on Project Management Permission - Project Board | Read");
		roles.uncheckbox_Read_ProjectBoard();
		TestLogger.info("Check on Project Management Permission - Project Board | Create");
		roles.checkbox_Create_ProjectBoard();
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
		administration.scrollToBottomPage();
		administration.clickMenuProjectManagement();
		TestLogger.info("Open Project Management >> Project Board");
		administration.clickSubMenuProjectBoard();
		TestLogger.info("Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button ");
		if (projectBoard.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button");
		} else {
			setStatusTest("fail", " User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button");
		}

		projectBoard.clickButtonAction();

		if (projectBoard.isBtnProjectInformationDisplayed() == false && projectBoard.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass",
					"User cannot see/do:\r\n" + "1. Action button > Project Information\r\n" + "2. Delete function");
		}

		else {
			setStatusTest("fail",
					"User STILL CAN see/do:\r\n" + "1. Action button > Project Information\r\n" + "2. Delete function");
		}

		projectBoard.clickButtonCreate();
		createProject.createProject(TienIch.taoRandomChu(12), TienIch.taoRandomSo(6));
		if (projectBoard.isMessageAddSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Create new project successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Create new project successfully\"");
		}

		TestLogger.info("=================END TT_977====================");

	}

	@Test(priority = 4)
	public void TT_976() throws InterruptedException {
		TestLogger.info("=================TT_976 ====================");
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
		UserRoleName = "Project Management|Project Board|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked on Project Management Permission - Project Board | Read");
		roles.uncheckbox_Read_ProjectBoard();
		TestLogger.info(" Check on Project Management Permission - Project Board| Update");
		roles.checkbox_Update_ProjectBoard();
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
		administration.scrollToBottomPage();
		administration.clickMenuProjectManagement();
		TestLogger.info("Open Project Management >> Project Board");
		administration.clickSubMenuProjectBoard();
		TestLogger.info("Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button ");
		if (projectBoard.isBtnExportDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button");
		} else {
			setStatusTest("fail", " User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button");
		}

		projectBoard.clickButtonAction();

		if (projectBoard.isBtnProjectInformationDisplayed() == true) {
			setStatusTest("pass", "User can see/do:\r\n" + "1. Action button > Project Information\r\n" + "");
		}

		else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Action button > Project Information\r\n" + "");
		}

		if (projectBoard.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Delete function");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Delete function");
		}

		TestLogger.info("3. Click on button \"Action\"\r\n" + "4. Click on option \"Project Information\"\r\n"
				+ "5. Click on button \"Update\"");

		projectBoard.clickOnProjectInformation();
		editProject.UpdateProject();
		if (projectBoard.isMessageUpdateSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Update project successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Update project successfully\"");
		}

		TestLogger.info("=================END TT_976====================");

	}

	@Test(priority = 5)
	public void TT_978() throws InterruptedException {
		TestLogger.info("=================TT_978 ====================");
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
		UserRoleName = "Project Management|Project Board|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked on Project Management Permission - Project Board | Read");
		roles.uncheckbox_Read_ProjectBoard();
		TestLogger.info(" Check on Project Management Permission - Project Board| Delete");
		roles.checkbox_Delete_ProjectBoard();
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
		administration.scrollToBottomPage();
		administration.clickMenuProjectManagement();
		TestLogger.info("Open Project Management >> Project Board");
		administration.clickSubMenuProjectBoard();

		TestLogger.info("Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button ");
		if (projectBoard.isBtnExportDisplayed() == true && projectBoard.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button" + "4. Delete function");
		} else {
			setStatusTest("fail",
					" User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button" + "4. Delete function");
		}

		projectBoard.clickButtonAction();

		if (projectBoard.isBtnProjectInformationDisplayed() == false && projectBoard.isBtnCreateDisplayed() == false) {
			setStatusTest("pass",
					"User cannot see/do:\r\n" + "1. Create button\r\n" + "2. Action button > Project Information");
		}

		else {
			setStatusTest("fail",
					"User STILL CAN see/do:\r\n" + "1. Create button\r\n" + "2. Action button > Project Information");
		}

		projectBoard.deleteProjectName();
		if (projectBoard.isMessageDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Project deleted successfully!\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Project deleted successfully!\"");
		}

		TestLogger.info("=================END TT_978====================");

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
