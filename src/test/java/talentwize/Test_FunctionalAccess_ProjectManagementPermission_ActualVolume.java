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
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ProjectManagementPermission_ActualVolume extends TestManager {
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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_983() throws InterruptedException {
		TestLogger.info("=================TT_983 ====================");
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
		UserRoleName = "ActualVolume|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Unchecked on Project Management Permission - Actual Volume | Read");
		roles.uncheckbox_Read_ActualVolume();

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

		if (administration.isSubMenuActualVolumeDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Actual Volume");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Actual Volume");
		}

		TestLogger.info("=================END TT_983====================");

	}

	@Test(priority = 2)
	public void TT_972() throws InterruptedException {
		TestLogger.info("=================TT_972 ====================");
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
		UserRoleName = "ActualVolume|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("checked on Project Management Permission - Actual Volume | Read");
		roles.uncheckbox_Read_ActualVolume();
		roles.checkbox_Read_ActualVolume();

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
		administration.clickSubMenuActualVolume();
		if (actualVolumeBoard.isListOfProjectNameLinDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Project Name link");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Project Name link");
		}

		if (actualVolumeBoard.isBtnImportDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Import button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Import button");
		}

		actualVolumeBoard.clickOnColumnEditVolumn();
		if (editActualVolume.isTitleEditActualVolumeDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Import button\r\n" + "2. Edit function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Import button\r\n" + "2. Edit function");
		}

		TestLogger.info("=================END TT_972====================");

	}

	@Test(priority = 3)
	public void TT_973() throws InterruptedException {
		TestLogger.info("=================TT_973 ====================");
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
		UserRoleName = "ActualVolume|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("checked on Project Management Permission - Actual Volume | Update");
		roles.uncheckbox_Read_ActualVolume();
		roles.checkbox_Update_ActualVolume();

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
		administration.clickSubMenuActualVolume();

		TestLogger.info("Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Edit function\r\n"
				+ "3. Project Name link\r\n" + "4. Import button");

		if (actualVolumeBoard.isListOfProjectNameLinDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Data table");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Data table");
		}

		if (actualVolumeBoard.isBtnImportDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Import button");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Import button");
		}

		if (actualVolumeBoard.isLblNameOfProjectDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Project Name link");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Project Name link");
		}

		actualVolumeBoard.clickOnColumnEditVolumn();
		if (editActualVolume.isTitleEditActualVolumeDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Edit function");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Edit function");
		}

		editActualVolume.fillIntoNumberClosedCases();

		editActualVolume.clickOnSave();

		if (actualVolumeBoard.isMessageEditSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Update actual volume successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Update actual volume successfully\"");
		}

		TestLogger.info("=================END TT_973====================");

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
