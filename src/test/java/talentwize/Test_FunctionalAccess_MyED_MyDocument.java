package talentwize;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Ulties.PropertyManager;
import Ulties.TestLogger;
import Ulties.TestManager;
import Ulties.TienIch;
import controller.ScreenController;
import controller.WebDriversManager;
import talentwize.pages.Administration;
import talentwize.pages.CompanyJobHistory;
import talentwize.pages.Dashboard;
import talentwize.pages.Documents;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddAttachment;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_MyED_MyDocument extends TestManager {
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
	Screen screen;
	ScreenController s;
	Form_AddAttachment form_AddAttachment;
	Documents documents;

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
		screen = new Screen();
		s = new ScreenController(screen);
		documents = new Documents(driver);

		form_AddAttachment = new Form_AddAttachment(driver, s, screen);

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1463() throws InterruptedException {
		TestLogger.info("======================TT_1463=====================");
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

		TestLogger.info("+ UnCheck on My ED -My Document| read");
		roles.uncheck_Read_My_Document();
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
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuDocumentDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do:\r\n" + "1. Documents menu");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "1. Documents menu");
		}
		TestLogger.info("======================TT_958=====================");
	}

	@Test(priority = 2)
	public void TT_1464() throws InterruptedException {
		TestLogger.info("======================TT_1464=====================");
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

		TestLogger.info("+ UnCheck on My ED -Document| read");
		roles.uncheck_Read_My_Document();
		TestLogger.info("4 Check on My ED -Document| read");
		roles.check_Read_My_Document();
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
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Documents menu");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n" + "1. Documents menu");
		}
		TestLogger.info("======================TT_1464=====================");
	}

	@Test(priority = 3)
	public void TT_3605() throws InterruptedException {
		TestLogger.info("======================TT_3605=====================");
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

		TestLogger.info("+ UnCheck on My ED -Document| read");
		roles.uncheck_Read_My_Document();
		TestLogger.info("4 Check on My ED -Document| Create");
		roles.checkBox_Create_My_Document();
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
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Documents menu");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n" + "1. Documents menu");
		}

		TestLogger.info("8. Open Employee Data menu >> Documents");
		administration.clickSubMenuDocument();
		TestLogger.info("9. Click on button Add\r\n" + " Upload file\r\n" + " Click on button Save");
		documents.clickBtnAdd();
		form_AddAttachment.addAttachment("Test_Automation.xlsx");

		if (documents.isMsgAddSuccessDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Create announcement successfully!\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Create announcement successfully!\"");
		}

		if (documents.isIConDeleteDisplayed() == false && documents.isLinkDocumentNameDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete function ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Edit function\r\n" + "2. Delete function ");
		}

		TestLogger.info("======================TT_3605=====================");
	}

	@Test(priority = 4)
	public void TT_3606() throws InterruptedException {
		TestLogger.info("======================TT_3606=====================");
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

		TestLogger.info("+ UnCheck on My ED -Document| read");
		roles.uncheck_Read_My_Document();
		TestLogger.info("4 Check on My ED -Document| Update");
		roles.checkBox_Update_My_Document();
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
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Documents menu");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n" + "1. Documents menu");
		}

		TestLogger.info("8. Open Employee Data menu >> Documents");
		administration.clickSubMenuDocument();
		TestLogger.info("9. Click on Link Edit\r\n" + " Upload file\r\n" + " Click on button Save");
		documents.clickFistLinkDocument();
		form_AddAttachment.updateAttachment("Test_Automation.xlsx");

		if (documents.isMsgUpdatedDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Update announcement successfully!\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Update announcement successfully!\"");
		}

		if (documents.isIConDeleteDisplayed() == false && documents.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Button Add \r\n" + "2. Delete function ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Button Add \r\n" + "2. Delete function ");
		}

		TestLogger.info("======================TT_3605=====================");
	}

	@Test(priority = 5)
	public void TT_3607() throws InterruptedException {
		TestLogger.info("======================TT_3607=====================");
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

		TestLogger.info("+ UnCheck on My ED -Document| read");
		roles.uncheck_Read_My_Document();
		TestLogger.info("4 Check on My ED -Document| Update");
		roles.checkBox_Delete_My_Document();
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
		administration.clickMenuEmployeeData();

		if (administration.isSubMenuDocumentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "1. Documents menu");
		} else {
			setStatusTest("fail", "User Can NOT see/do:\r\n" + "1. Documents menu");
		}

		TestLogger.info("8. Open Employee Data menu >> Documents");
		administration.clickSubMenuDocument();
		TestLogger.info("9. Delete records.");
		documents.deleteDocument();

		if (documents.isMsgDeletedDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Delete announcement successfully!\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Delete announcement successfully!\"");
		}

		if (documents.isLinkDocumentNameDisplayed() == false && documents.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. button Add ");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Edit function\r\n" + "2. button Add ");
		}

		TestLogger.info("======================TT_3607=====================");
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
