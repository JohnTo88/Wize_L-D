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
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_EditContractType;
import talentwize.pages.Form_EditCurrentPosition;
import talentwize.pages.Form_EditNewPosition;
import talentwize.pages.Form_EditPreviousPosition;
import talentwize.pages.HomePage;
import talentwize.pages.MySchedule;
import talentwize.pages.Roles;
import talentwize.pages.ScheduleBoard;
import talentwize.pages.Users;

public class Test_FunctionalAccess_MasterScheduling_RecommendCoverage extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	CompanyJobHistory companyJobHistory;
	Form_EditContractType editContractType;
	Form_EditPreviousPosition editPreviousPosition;
	Form_EditCurrentPosition editCurrentPosition;
	Form_EditNewPosition editNewPosition;
	MySchedule mySchedule;
	ScheduleBoard scheduleBoard;

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
		companyJobHistory = new CompanyJobHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		editContractType = new Form_EditContractType(driver);
		editPreviousPosition = new Form_EditPreviousPosition(driver);
		editCurrentPosition = new Form_EditCurrentPosition(driver);
		editNewPosition = new Form_EditNewPosition(driver);
		mySchedule = new MySchedule(driver);
		scheduleBoard = new ScheduleBoard(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1218() throws InterruptedException {
		TestLogger.info("=================TT_1218 =====================");
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
		UserRoleName = "Recommend Coverage|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Unchecked on \r\n" + "Master Scheduling - Recommend Coverage | Read");
		roles.uncheckbox_Read_MasterScheduling_RecommendCoverage();

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
		TestLogger.info("1. Open Master Scheduling\r\n" + "2. Open Scheduling Board\r\n" + "3. Move to Week view");

		administration.clickMenuMasterScheduling();
		administration.clickSubMenuScheduleBoard();
		scheduleBoard.clickTabWeek();
		if (scheduleBoard.isButtonImportRecommendCoverageDispalyed() == false
				&& scheduleBoard.isButtonRecommendCoverageDispalyed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Recommend Coverage button\r\n"
					+ "2. Import Recommend Coverage button");
		} else {
			setStatusTest("fail", " User STILL CAN see/do:\r\n" + "1. Recommend Coverage button\r\n"
					+ "2. Import Recommend Coverage button");
		}

		TestLogger.info("=================END TT_1218=====================");
	}

	@Test(priority = 2)
	public void TT_1214() throws InterruptedException {
		TestLogger.info("=================TT_1214 =====================");
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
		UserRoleName = "Recommend Coverage|No permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on \r\n" + "Master Scheduling - Recommend Coverage | Read\r\n" + "+Check on \r\n"
				+ "Master Scheduling - Recommend Coverage | Read");
		roles.uncheckbox_Read_MasterScheduling_RecommendCoverage();
		roles.checkbox_Read_MasterScheduling_RecommendCoverage();

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
		TestLogger.info("1. Open Master Scheduling\r\n" + "2. Open Scheduling Board\r\n" + "3. Move to Week view");

		administration.clickMenuMasterScheduling();
		administration.clickSubMenuScheduleBoard();
		scheduleBoard.clickTabWeek();

		if (scheduleBoard.isButtonImportRecommendCoverageDispalyed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Import Recommend Coverage button");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Import Recommend Coverage button");
		}

		if (scheduleBoard.isButtonRecommendCoverageDispalyed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2, Recommend Coverage button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2, Recommend Coverage button");
		}

		TestLogger.info("=================END TT_1214=====================");
	}

	@Test(priority = 3)
	public void TT_1216() throws InterruptedException {
		TestLogger.info("=================TT_1216 =====================");
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
		UserRoleName = "Recommend Coverage|Update permission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck on \r\n" + "Master Scheduling - Recommend Coverage | Read\r\n" + "+Check on \r\n"
				+ "Master Scheduling - Recommend Coverage | Update");
		roles.uncheckbox_Read_MasterScheduling_RecommendCoverage();
		roles.checkbox_Update_MasterScheduling_RecommendCoverage();

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
		TestLogger.info("1. Open Master Scheduling\r\n" + "2. Open Scheduling Board\r\n" + "3. Move to Week view");

		administration.clickMenuMasterScheduling();
		administration.clickSubMenuScheduleBoard();
		scheduleBoard.clickTabWeek();

		if (scheduleBoard.isButtonImportRecommendCoverageDispalyed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2, Recommend Coverage button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2, Recommend Coverage button");
		}

		TestLogger.info("4. Click on Recommend Coverage button\r\n" + "5. Click on Edit button\r\n"
				+ "6. Input data\r\n" + "7. Click on Publish button\r\n"
				+ "8. Select an option to publish Recommend Coverage\r\n" + "9. Click Publish button");
		scheduleBoard.clickButtonRecommendCoverage();
		scheduleBoard.clickButtonEdit();
		scheduleBoard.clickArrowUp();
		scheduleBoard.clickButtonPublish();
		scheduleBoard.clickButtonPublishConfirm();

		if (scheduleBoard.isMsgUpdateRecommendDispalyed() == true) {
			setStatusTest("pass", "Displays msg \"Update recommend coverage successfully\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Update recommend coverage successfully\"");
		}

		TestLogger.info("=================END TT_1216=====================");
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
