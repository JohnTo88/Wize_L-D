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
import talentwize.pages.ContactDetails;
import talentwize.pages.Dashboard;
import talentwize.pages.EmployeeList;
import talentwize.pages.Form_AddProjectCapacity;
import talentwize.pages.Form_EditProjectCapacity;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.ProjectCapacity;
import talentwize.pages.ProjectInfo;
import talentwize.pages.Roles;
import talentwize.pages.Users;

// NHáº¬N XÃ‰T CHUNG : Code Ä‘áº¹p, trÃ¬nh bÃ y cáº©n tháº­n, Ä‘áº§y Ä‘á»§ comment cÃ¡c bÆ°á»›c 
// CÃ³ má»™t lÆ°u Ã½ nhá»� : Cá»‘ gáº¯ng má»™t vÃ i Ä‘oáº¡n nÃªn tÃ¡ch hÃ ng ra Ä‘á»ƒ cho cáº£ tá»•ng thá»ƒ ,Ä‘á»�c dá»… dÃ ng hÆ¡n . 
// Ä�Iá»‚M TOÃ€N BÃ€I  : 9.5/10
// Thank em vÃ¬ Ä‘Ã£ lÃ m bÃ i táº­p vÃ  hoÃ n thÃ nh nÃ³ Ä‘Ãºng giá»� . 

public class Test_FunctionalAccess_ProjectManagementPermission_ProjectDetail_ProjectCapacity extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	PersonalDetails personalDetails;
	ContactDetails contactDetails;
	CompanyJobHistory companyJobHistory;
	ProjectInfo projectInfo;
	ProjectCapacity projectCapacity;
	Form_AddProjectCapacity addProjectCapacity;
	Form_EditProjectCapacity editProjectCapacity;

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
		personalDetails = new PersonalDetails(driver);
		contactDetails = new ContactDetails(driver);
		companyJobHistory = new CompanyJobHistory(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		projectInfo = new ProjectInfo(driver);
		projectCapacity = new ProjectCapacity(driver);
		addProjectCapacity = new Form_AddProjectCapacity(driver);
		editProjectCapacity = new Form_EditProjectCapacity(driver);

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_997() throws InterruptedException {
		TestLogger.info("==========TT_997================");

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		// Check log in pass or fail
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
		UserRoleName = "Permission|ProjectCapacity|NoPermission" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Project Detail - Project Capacity| read");
		roles.uncheck_Read_ProjectDetail_ProjectCapacity();

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
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectDetail();
		administration.clickSubMenuProjectDetail();
		// Check tab Project Capacity display
		if (administration.istabProjectCapacityDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Project Capacity tab");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "Project Capacity tab");
		}
		TestLogger.info("==========TT_997================");
	}

	@Test(priority = 3)
	public void TT_993() throws InterruptedException {
		TestLogger.info("==========TT_993================");

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		// Check log in pass or fail
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
		UserRoleName = "Permission|ProjectCapacity|Read" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck Project Management Permission - Project Detail - Project Capacity| read");
		roles.uncheck_Read_ProjectDetail_ProjectCapacity();

		TestLogger.info("4.2 check Project Management Permission - Project Detail - Project Capacity| read");
		roles.check_Read_ProjectDetail_ProjectCapacity();

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
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectDetail();
		administration.clickSubMenuProjectDetail();
		// Check tab Project Capacity display
		if (administration.istabProjectCapacityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Project Capacity tab");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Project Capacity tab");
		}
		TestLogger.info("==========TT_993================");
	}

	@Test(priority = 2)
	public void TT_995() throws InterruptedException {
		TestLogger.info("==========TT_995================");

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		// Check log in pass or fail
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
		UserRoleName = "Permission|ProjectCapacity|Create" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck Project Management Permission - Project Detail - Project Capacity| read");
		roles.uncheck_Read_ProjectDetail_ProjectCapacity();

		TestLogger.info("4.2 check Project Management Permission - Project Detail - Project Capacity| Create");
		roles.check_Create_ProjectDetail_ProjectCapacity();

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
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectDetail();
		administration.clickSubMenuProjectDetail();
		// Check tab Project Capacity display
		if (administration.istabProjectCapacityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Project Capacity tab");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Project Capacity tab");
		}
		administration.clickTabProjectCapacity();
		// Check content at tab Project Capacity
		if (projectCapacity.isBtnAddDisplayed() == true && projectCapacity.isLblProjectRoleDisplayed() == true
				&& projectCapacity.isBtnEditDisplayed() == false && projectCapacity.isBtnDeleteDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "\r\n"
					+ "User CANNOT see/do:\r\n" + "1. Edit button\r\n" + "2. Delete fuction");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "\r\n"
					+ "User Still see/do:\r\n" + "1. Edit button\r\n" + "2. Delete fuction");
		}

		// Add new Capacity
		projectCapacity.clickButtonAdd();
		addProjectCapacity.addProjectCapacity(TienIch.taoRandomSo(1), TienIch.taoRandomSo(1));
		// Check Add new Capacity
		if (projectCapacity.ismsgAddProjectCapacitySuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Add Project Capacity");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Add Project Capacity");
		}
		TestLogger.info("==========TT_995================");
	}

	@Test(priority = 4)
	public void TT_994() throws InterruptedException {
		TestLogger.info("==========TT_994================");

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		// Check log in pass or fail
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
		UserRoleName = "Permission|ProjectCapacity|Update" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck Project Management Permission - Project Detail - Project Capacity| read");
		roles.uncheck_Read_ProjectDetail_ProjectCapacity();

		TestLogger.info("4.2 check Project Management Permission - Project Detail - Project Capacity| Update");
		roles.check_Update_ProjectDetail_ProjectCapacity();

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
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectDetail();
		administration.clickSubMenuProjectDetail();
		// Check tab Project Capacity display
		if (administration.istabProjectCapacityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Project Capacity tab");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Project Capacity tab");
		}
		administration.clickTabProjectCapacity();

		// Check content at tab Project Capacity
		if (projectCapacity.isLblProjectRoleDisplayed() == true && projectCapacity.isBtnEditDisplayed() == true
				&& projectCapacity.isBtnDeleteDisplayed() == false && projectCapacity.isButtonAddDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Edit button\r\n" + "\r\n"
					+ "User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Edit button\r\n" + "\r\n"
					+ "User Still see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		}

		// Edit Capacity
		projectCapacity.clickButtonEdit();
		editProjectCapacity.clickButtonUpdateConfig();
		// Check message when Edit Capacity
		if (projectCapacity.ismsgUpdateProjectCapacitySuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update Project Capacity");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Update Project Capacity");
		}
		TestLogger.info("==========TT_994================");
	}

	@Test(priority = 5)
	public void TT_996() throws InterruptedException {
		TestLogger.info("==========TT_996================");

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdmin1(), propertyManager.getPasswordAdmin1());
		// Check log in pass or fail
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
		UserRoleName = "Permission|ProjectCapacity|Update" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4.1 Uncheck Project Management Permission - Project Detail - Project Capacity| read");
		roles.uncheck_Read_ProjectDetail_ProjectCapacity();

		TestLogger.info("4.2 check Project Management Permission - Project Detail - Project Capacity| Delete");
		roles.check_Delete_ProjectDetail_ProjectCapacity();

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
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectDetail();
		administration.clickSubMenuProjectDetail();
		// Check tab Project Capacity display
		if (administration.istabProjectCapacityDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Project Capacity tab");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Project Capacity tab");
		}
		administration.clickTabProjectCapacity();

		// Check content at tab Project Capacity
		if (projectCapacity.isLblProjectRoleDisplayed() == true && projectCapacity.isBtnEditDisplayed() == false
				&& projectCapacity.isBtnDeleteDisplayed() == true && projectCapacity.isButtonAddDisplayed() == false) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Delete function\r\n" + "\r\n"
					+ "User CANNOT see/do:\r\n" + "1. Action button\r\n" + "2. Edit button\r\n" + "3. Add button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Delete function\r\n" + "\r\n"
					+ "User STILL see/do:\r\n" + "1. Action button\r\n" + "2. Edit button\r\n" + "3. Add button");
		}
		projectCapacity.clickChkProject();
		projectCapacity.clickChkAM();
		// Delete Capacity
		projectCapacity.deleteProjectCapacity();
		// Check message when Edit Capacity
		if (projectCapacity.ismsgDeleteProjectCapacitySuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete Project Capacity");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Delete Project Capacity");
		}
		TestLogger.info("==========TT_996================");
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
