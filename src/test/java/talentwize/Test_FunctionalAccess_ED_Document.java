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
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ED_Document extends TestManager {
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

	@BeforeTest
	public void KhoiTaoCacNguonTaiNguyen() {

		TestLogger.info("======= Test_FunctionalAccess_ED_Document ======");
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

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_958() throws InterruptedException {
		TestLogger.info("======================TT_958=====================");
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
		UserRoleName = "Automation-ED-Documents-No Permission" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("Unchecked Employee List Permissions: Add, Delete");
		roles.choose_UnCheckbox_Employee_List_Permission_Add();
		roles.choose_UnCheckbox_Employee_List_Permission_Delete();
		TestLogger.info("+ UnCheck on ED -Document| read");
		roles.uncheck_Read_ED_Documents();
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
		employeeList.clickItemEmployee();
		if (administration.isSubMenuDocumentDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + "1. Documents menu");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "1. Documents menu");
		}
		TestLogger.info("======================END TT_958=====================");
	}

	@Test(priority = 2)
	public void TT_957() throws InterruptedException {
		TestLogger.info("======================TT_957=====================");
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
		UserRoleName = "Automation-ContactDetail-Read" + TienIch.taoRandomSo(2);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		TestLogger.info("4. Unchecked Employee List Permissions: Add, Delete");
		roles.choose_UnCheckbox_Employee_List_Permission_Add();
		roles.choose_UnCheckbox_Employee_List_Permission_Delete();
		TestLogger.info("+ UnCheck on ED -Document| read");
		roles.uncheck_Read_ED_Documents();
		TestLogger.info("4.3 Check on ED -Document| read");
		roles.check_Read_ED_Documents();
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
		employeeList.clickItemEmployee();
		administration.scrollTosubMenuEmployment();
		if (administration.isSubMenuDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Documents menu");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n" + "1. Documents menu");
		}
		TestLogger.info("======================END TT_957=====================");
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
	public void closeBrowser() {
		driver.close();
	}
}
