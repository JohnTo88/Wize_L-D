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
import talentwize.pages.Form_ProjectMembers;
import talentwize.pages.Form_QuotaValues;
import talentwize.pages.Headcount;
import talentwize.pages.HomePage;
import talentwize.pages.KPIBoard;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ProjectManagementPermission_HeadCount extends TestManager {

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
	Headcount headCount;
	Form_ProjectMembers projectMembers;
	Form_QuotaValues quotaValues;

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
		projectMembers = new Form_ProjectMembers(driver);
		quotaValues = new Form_QuotaValues(driver);
		headCount = new Headcount(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_959() throws InterruptedException {
		TestLogger.info("=================TT_959====================");
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
		UserRoleName = "Permission-HeadCount|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("Check on Project Management Permission - HeadCount | Read");

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
		administration.clickSubHeadCount();
		if (headCount.isBtnExportDisplayed() == true)
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button");
		else
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button");

		headCount.clickIconQuotaValue();
		if (quotaValues.isBtnGoToQuotaManagementDisplayed() == true) {
			quotaValues.clickOnButtonClose();
			setStatusTest("pass", "3. Open Quota values popup");
		} else {
			quotaValues.clickOnButtonClose();
			setStatusTest("fail", "3. Open Quota values popup");
		}

		headCount.clickIconMemberProject();
		if (projectMembers.isBtnGoToProjectMemberListDisplayed() == true) {
			projectMembers.clickOnButtonClose();
			setStatusTest("pass", "4. Open Project members popup");
		} else {
			projectMembers.clickOnButtonClose();
			setStatusTest("fail", "4. Open Project members popup");
		}

		TestLogger.info("=================TT_959====================");

	}

	@Test(priority = 2)
	public void TT_981() throws InterruptedException {
		TestLogger.info("=================TT_981====================");
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
		UserRoleName = "Permission-HeadCount|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("UnCheck on Project Management Permission - HeadCount | Read");
		roles.uncheckbox_Read_HeadCount();

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
		if (administration.isSubMenuHeadCountDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Headcount menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Headcount menu");
		}

		TestLogger.info("=================END TT_981====================");

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
