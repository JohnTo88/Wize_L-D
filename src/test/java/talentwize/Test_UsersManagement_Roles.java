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
import talentwize.pages.EmployeeList;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_UsersManagement_Roles extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;

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

		homePage.moLinkWeb(propertyManager.getURL_TalentWize());

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_479_1() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site")) {

			setStatusTest("pass", "4. Displays \"Site\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site\" in Data Access column");
		}
	}

	@Test(priority = 2)
	public void TT_479_2() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessUnitInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Unit")) {

			setStatusTest("pass", "4. Displays \"Unit\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Unit\" in Data Access column");
		}
	}

	@Test(priority = 3)
	public void TT_479_3() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessProjectInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Project")) {

			setStatusTest("pass", "4. Displays \"Project\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Project\" in Data Access column");
		}
	}

	@Test(priority = 4)
	public void TT_479_4() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessReportToInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Report To")) {

			setStatusTest("pass", "4. Displays \"Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Report To\" in Data Access column");
		}
	}

	@Test(priority = 5)
	public void TT_479_5() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessAllInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site, Unit, Project, Report To")) {

			setStatusTest("pass", "4. Displays \"Site, Unit, Project, Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site, Unit, Project, Report To\" in Data Access column");
		}
	}

	@Test(priority = 6)
	public void TT_479_6() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site")) {

			setStatusTest("pass", "4. Displays \"Site\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site\" in Data Access column");
		}
	}

	@Test(priority = 7)
	public void TT_479_7() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessUnitInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Unit")) {

			setStatusTest("pass", "4. Displays \"Unit\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Unit\" in Data Access column");
		}
	}

	@Test(priority = 8)
	public void TT_479_8() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessProjectInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Project")) {

			setStatusTest("pass", "4. Displays \"Project\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Project\" in Data Access column");
		}
	}

	@Test(priority = 9)
	public void TT_479_9() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessReportToInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Report To")) {

			setStatusTest("pass", "4. Displays \"Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Report To\" in Data Access column");
		}
	}

	@Test(priority = 10)
	public void TT_479_10() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessAllInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site, Unit, Project, Report To")) {

			setStatusTest("pass", "4. Displays \"Site, Unit, Project, Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site, Unit, Project, Report To\" in Data Access column");
		}
	}

	@Test(priority = 1)
	public void TT_482_1() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site")) {

			setStatusTest("pass", "4. Displays \"Site\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site\" in Data Access column");
		}
	}

	@Test(priority = 2)
	public void TT_482_2() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessUnitInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Unit")) {

			setStatusTest("pass", "4. Displays \"Unit\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Unit\" in Data Access column");
		}
	}

	@Test(priority = 3)
	public void TT_482_3() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessProjectInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Project")) {

			setStatusTest("pass", "4. Displays \"Project\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Project\" in Data Access column");
		}
	}

	@Test(priority = 4)
	public void TT_482_4() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessReportToInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Report To")) {

			setStatusTest("pass", "4. Displays \"Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Report To\" in Data Access column");
		}
	}

	@Test(priority = 5)
	public void TT_482_5() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessAllInRoleTypeAdmin(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site, Unit, Project, Report To")) {

			setStatusTest("pass", "4. Displays \"Site, Unit, Project, Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site, Unit, Project, Report To\" in Data Access column");
		}
	}

	@Test(priority = 6)
	public void TT_482_6() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site")) {

			setStatusTest("pass", "4. Displays \"Site\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site\" in Data Access column");
		}
	}

	@Test(priority = 7)
	public void TT_482_7() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessUnitInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Unit")) {

			setStatusTest("pass", "4. Displays \"Unit\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Unit\" in Data Access column");
		}
	}

	@Test(priority = 8)
	public void TT_482_8() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessProjectInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Project")) {

			setStatusTest("pass", "4. Displays \"Project\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Project\" in Data Access column");
		}
	}

	@Test(priority = 9)
	public void TT_482_9() throws InterruptedException {
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
		UserRoleName = "Site" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessReportToInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Report To")) {

			setStatusTest("pass", "4. Displays \"Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Report To\" in Data Access column");
		}
	}

	@Test(priority = 10)
	public void TT_482_10() throws InterruptedException {
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
		UserRoleName = "Automation-View Employee" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithDataAccessAllInRoleTypeManager(UserRoleName);
		roles.clickButtonSave();
		roles.searchRoles(UserRoleName);
		if (roles.getNameOfUnitDataAccess().trim().equals("Site, Unit, Project, Report To")) {

			setStatusTest("pass", "4. Displays \"Site, Unit, Project, Report To\" in Data Access column");

		} else {
			setStatusTest("fail", "4. DOES NOT Displays \"Site, Unit, Project, Report To\" in Data Access column");
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
