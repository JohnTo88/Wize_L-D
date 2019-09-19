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
import talentwize.pages.Form_EditActualVolume;
import talentwize.pages.Form_EditKPIDetail;
import talentwize.pages.Form_ProjectPermission;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.ProjectBoard;
import talentwize.pages.ProjectInfo;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ProjectManagementPermission_ProjectPermission extends TestManager {
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
	Form_EditActualVolume editActualVolume;
	ProjectBoard projectBoard;
	ProjectInfo projectInfo;
	Form_ProjectPermission projectPermission;

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
		projectInfo = new ProjectInfo(driver);
		projectPermission = new Form_ProjectPermission(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_987() throws InterruptedException {
		TestLogger.info("=================TT_987 ====================");
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
		UserRoleName = "Project Settings|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Project Management Permission - Project Permission | Read");
		roles.uncheckbox_Read_ProjectPermission();
		TestLogger.info("++ Uncheck on Project Management Permission - Project Info | Read");
		roles.uncheckbox_Read_ProjectBoard();
		TestLogger.info("+++ Check on Project Management Permission - Project Board | Read");
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
		administration.clickMenuProjectManagement();

		administration.clickSubMenuProjectBoard();
		if (projectBoard.isBtnManagePermissionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. \"Manage Pernmissions\" button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. \"Manage Pernmissions\" button");
		}

		administration.clickSubMenuProjectDetails();
		administration.clickTabProjectInfo();
		if (projectInfo.isBtnViewPermissionDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. \"View Pernmission\" button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. \"View Pernmission\" button");
		}

		TestLogger.info("=================END TT_987====================");

	}

	@Test(priority = 2)
	public void TT_985() throws InterruptedException {
		TestLogger.info("=================TT_985 ====================");
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
		UserRoleName = "Project Settings|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Project Management Permission - Project Permission | Read");
		roles.uncheckbox_Read_ProjectPermission();
		roles.checkbox_Read_ProjectPermission();

		TestLogger.info("++ Check on Project Management Permission - Project Info | Read");
		TestLogger.info("+++ Check on Project Management Permission - Project Board | Read");
		roles.uncheckbox_Read_ProjectBoard();
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
		administration.clickMenuProjectManagement();

		administration.clickSubMenuProjectBoard();
		if (projectBoard.isBtnManagePermissionDisplayed() == false) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. \"Manage Pernmissions\" button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. \"Manage Pernmissions\" button");
		}

		administration.clickSubMenuProjectDetails();
		administration.clickTabProjectInfo();
		if (projectInfo.isBtnViewPermissionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. \"View Pernmission\" button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "1. \"View Pernmission\" button");
		}

		TestLogger.info("=================END TT_985====================");

	}

	@Test(priority = 3)
	public void TT_986() throws InterruptedException {
		TestLogger.info("=================TT_986 ====================");
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
		UserRoleName = "Project Settings|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("+ Check on Project Management Permission - Project Board| Update");

		roles.uncheckbox_Read_ProjectBoard();
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

		TestLogger.info("1. Open Project Management.\r\n" + "2. Open Project Board.\r\n"
				+ "3. Click on button \"Management Permissions\"\r\n" + "4. Input data\r\n"
				+ "5. Click on button \"Confirm\"");

		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		administration.clickSubMenuProjectDetail();
		administration.clickTabProjectInfo();
		projectInfo.clickButtonViewPermission();
		projectPermission.searchEmployee(propertyManager.getSearchUserName());
		projectPermission.chooseRoleInProject();
		projectPermission.clickBtnAddPermission();

		TestLogger.info("Expect : Displays msg \"Bulk Assign successfully!\" ");

		if (projectPermission.isMesssageAddSuccessDisplayed() == true) {
			projectPermission.removeEmployeeFromPermission(propertyManager.getSearchUserName());
			setStatusTest("pass", "Displays msg \"Bulk Assign successfully!\"");
		} else {
			projectPermission.removeEmployeeFromPermission(propertyManager.getSearchUserName());
			setStatusTest("fail", "DOES NOT Display msg \\\"Bulk Assign successfully!\\");
		}

		TestLogger.info("=================END TT_986====================");

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
