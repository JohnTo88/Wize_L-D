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
import talentwize.pages.CheckInBoard;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_EditKPIDetail;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_Performance_KPIBoardByUnit extends TestManager {
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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)

	public void TT_1010() throws InterruptedException {
		TestLogger.info("=================TT_1010====================");

		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Performance|KPIBoardByUnit|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. UnCheck on Performance Permission - Employee KPI | Read ");
		roles.unCheckbox_Read_Employee_KPI();

		TestLogger.info("4. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW1());
		users.searchUsername(propertyManager.getEmailUserTW1());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserTW1(), UserRoleName);

		TestLogger.info("5. Log out");

		dashboard.logout();

		TestLogger.info("6. Login with test account : " + propertyManager.getEmailUserTW1());

		homePage.SignInWith(propertyManager.getEmailUserTW1(), propertyManager.getPasswordUserTW1());
		administration.clickMenuPerformance();
		administration.clickSubMenuCheckIn();

		if (administration.isSubMenuCheckInBoardDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do: " + "Check-in Board menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Check-in Board menu");
		}

		TestLogger.info("=================TT_1010====================");

	}

	@Test(priority = 2)
	public void TT_1023() throws InterruptedException {
		TestLogger.info("=================TT_1023====================");

		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Performance|KPIBoardByUnit|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. UnCheck on Performance Permission - Employee KPI | Read ");
		roles.unCheckbox_Read_Employee_KPI();

		TestLogger.info("4. Check on Performance Permission - Employee KPI | Read ");
		roles.checkbox_Read_Employee_KPI();

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
		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();

		if (administration.isSubMenuKPIBoardDisplayed() == true) {
			setStatusTest("pass", "User can see /do: " + " KPI Board menu");
		} else {
			setStatusTest("fail", "User can NOT see /do: " + "KPI Board menu");
		}

		TestLogger.info("Click sub menu KPI Board");

		administration.clickSubMenuKPIBoard();

		if (kPIBoard.islblKPIBoardDisplayed() == true && kPIBoard.isButtonExportDisplayed() == true) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "2. KPI table \r\n" + "3. Export button\r\n" + "4. View check-in detail");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "2. KPI table \r\n" + "3. Export button\r\n"
					+ "4. View check-in detail");
		}

		TestLogger.info("=================TT_1023====================");

	}

	@Test(priority = 3)
	public void TT_1024() throws InterruptedException {
		TestLogger.info("=================TT_1024====================");

		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());

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
		UserRoleName = "Performance|KPIBoardByUnit|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("3. UnCheck on Performance Permission - Employee KPI | Read ");
		roles.unCheckbox_Read_Employee_KPI();

		TestLogger.info("4. Check on Performance Permission - Employee KPI | Update ");
		roles.checkbox_Update_Employee_KPI();

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
		administration.clickMenuPerformance();
		administration.clickSubMenuKPI();

		if (administration.isSubMenuKPIBoardDisplayed() == true) {
			setStatusTest("pass", "User can see /do: " + "KPI Board menu\r\n");
		} else {
			setStatusTest("fail", "User can NOT see /do: " + "KPI Board menu\r\n");
		}

		TestLogger.info("Click sub menu KPI Board");
		administration.clickSubMenuKPIBoard();

		kPIBoard.selectedItem("cuong automation 1");

		if (kPIBoard.islblKPIBoardDisplayed() == true && kPIBoard.isButtonExportDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. KPI Board menu\r\n" + "2. KPI table \r\n"
					+ "3. Export button\r\n" + "4. View KPI detail ");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. KPI Board menu\r\n" + "2. KPI table \r\n"
					+ "3. Export button\r\n" + "4. View KPI detail ");
		}

		TestLogger.info("Click on Link of KPI Details");
		kPIBoard.clickOnfistLinkOfKPIDetails();

		TestLogger.info("Update KPI Details");
		editKPIDetail.UpdateKPIDetail();

		if (editKPIDetail.ismsgUpdateKPIDetailDisplayed() == true) {
			setStatusTest("pass", "User can see /do: " + "message: Update KPI Detail");
		} else {
			setStatusTest("fail", "User can NOT see /do: " + "message: Update KPI Detail");
		}

		TestLogger.info("=================TT_1024====================");
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
