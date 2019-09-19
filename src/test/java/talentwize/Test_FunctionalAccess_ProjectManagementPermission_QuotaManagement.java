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
import talentwize.pages.Form_AddProjectBoard;
import talentwize.pages.Form_AddProjectCapacity;
import talentwize.pages.Form_AddQuota;
import talentwize.pages.Form_AssignProjecttoAccountManagementRole;
import talentwize.pages.Form_EditProjectCapacity;
import talentwize.pages.HomePage;
import talentwize.pages.PersonalDetails;
import talentwize.pages.ProjectBoard;
import talentwize.pages.ProjectCapacity;
import talentwize.pages.ProjectInfo;
import talentwize.pages.ProjectRole;
import talentwize.pages.Quota;
import talentwize.pages.Roles;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ProjectManagementPermission_QuotaManagement extends TestManager {
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
	String projectName;
	Quota quota;
	Form_AddProjectBoard addProjectBoard;
	ProjectRole projectRole;
	Form_AssignProjecttoAccountManagementRole assignProjecttoAccountManagement;
	Form_AddQuota addQuota;
	ProjectBoard projectBoard;

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
		quota = new Quota(driver);
		addProjectBoard = new Form_AddProjectBoard(driver);
		projectRole = new ProjectRole(driver);
		assignProjecttoAccountManagement = new Form_AssignProjecttoAccountManagementRole(driver);
		addQuota = new Form_AddQuota(driver);
		projectBoard = new ProjectBoard(driver);

	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_969() throws InterruptedException {
		TestLogger.info("==========TT_969================");

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
		UserRoleName = "Permission|QuotaManagement|NoPermission" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Quota Management| read");
		roles.uncheck_Read_QuotaManagement();

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
		// Check sub menu Quota display
		if (administration.isSubMenuQuotaDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Quota menu");
		} else {
			setStatusTest("fail", "User STILL see/do:\r\n" + "Quota menu");
		}
		TestLogger.info("==========TT_969================");
	}

	@Test(priority = 2)
	public void TT_965() throws InterruptedException {
		TestLogger.info("==========TT_965================");

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
		UserRoleName = "Permission|QuotaManagement|Read" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Quota Management| read");
		roles.uncheck_Read_QuotaManagement();

		TestLogger.info("4. check Project Management Permission - Quota Management| read");
		roles.check_Read_QuotaManagement();

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
		// Check sub menu Quota display
		if (administration.isSubMenuQuotaDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Quota menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Quota menu");
		}
		TestLogger.info("==========TT_965================");
	}

	// Bug : http://10.17.14.203:8080/browse/TAL-771
	@Test(priority = 3)
	public void TT_966() throws InterruptedException {
		TestLogger.info("==========TT_966================");

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
		UserRoleName = "Permission|QuotaManagement|Create" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Quota Management| read");
		roles.uncheck_Read_QuotaManagement();

		TestLogger.info("4. check Project Management Permission - Quota Management| Create");
		roles.check_Create_QuotaManagement();

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
		// Check sub menu Quota display
		if (administration.isSubMenuQuotaDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Quota menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Quota menu");
		}
		administration.clickSubMenuQuota();

		// Check content at tab Quota
		if (quota.isbtnExportDisplayed() == true && quota.isbtnAddQuotaDisplayed() == true
				&& quota.islinkOfProjectDisplayed() == true && quota.islblProjectCategoryDisplayed() == true
				&& quota.isbtnEditDisplayed() == false && quota.isbtnDelete_ProjectDisplayed() == false) {
			setStatusTest("pass",
					"User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n" + "3. Project Name link\r\n"
							+ "4. Add Quota button\r\n" + "\r\n" + "User cannot see/do:\r\n" + "1. Edit button\r\n"
							+ "2. Delete function");
		} else {
			setStatusTest("fail",
					"User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n"
							+ "3. Project Name link\r\n" + "4. Add Quota button\r\n" + "\r\n" + "User Still see/do:\r\n"
							+ "1. Edit button\r\n" + "2. Delete function");
		}
		// Add new project
		TestLogger.info("Add new project");
		administration.clickSubMenuProjectBoard();
		projectBoard.clickButtonCreate();
		projectName = "A" + TienIch.taoRandomSo(2);
		addProjectBoard.addProjectBoard(projectName, TienIch.taoRandomSo(3), "13-Feb-2019");

		// Assign project has created
		TestLogger.info("Assign project has created");
		administration.clickSubMenuProjectSettings();
		administration.clickTabProjectRole();
		projectRole.clickButtonAssign();
		assignProjecttoAccountManagement.addProjectBoard(projectName);

		// Add new Quota
		TestLogger.info("Add new Quota");
		administration.clickSubMenuQuota();
		quota.clickbtnAddQuota();
		addQuota.addQuota(projectName, "20-Feb-2019");

		// Check message add new Quota
		if (quota.isMsgAddedSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "message Add Quota");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "message Add Quota");
		}
		TestLogger.info("==========TT_966================");
	}

	@Test(priority = 4)
	public void TT_967() throws InterruptedException {
		TestLogger.info("==========TT_967================");

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
		UserRoleName = "Permission|QuotaManagement|Create" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Quota Management| read");
		roles.uncheck_Read_QuotaManagement();

		TestLogger.info("4. check Project Management Permission - Quota Management| Update");
		roles.check_Update_QuotaManagement();

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
		// Check sub menu Quota display
		if (administration.isSubMenuQuotaDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Quota menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Quota menu");
		}
		administration.clickSubMenuQuota();

		// Check content at tab Quota
		TestLogger.info("User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n"
				+ "3. Project Name link\r\n" + "4. Edit button");

		if (quota.isbtnExportDisplayed() == true && quota.islinkOfProjectDisplayed() == true
				&& quota.isbtnEditDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n"
					+ "3. Project Name link\r\n" + "4. Edit button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n"
					+ "3. Project Name link\r\n" + "4. Edit button");
		}

		if (quota.isbtnAddQuotaDisplayed() == false && quota.isbtnDeleteProjectDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Add Quota button\r\n" + "2. Delete function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Add Quota button\r\n" + "2. Delete function");
		}

		TestLogger.info("3. Click on button \"Edit\"\r\n" + "4. Edit data.\r\n" + "5. Click on button \"Save\"");
		quota.clickbtnEditQuota();
		quota.clickbtnSaveQuota();
		if (quota.isMsgUpdateSuccessfullyDisplayed() == true) {
			setStatusTest("pass",
					"Displays msg \"The quota has been updated successfully. Updated items only show if they match the current filter selections\"");
		} else {
			setStatusTest("fail",
					"DOES NOT Displays msg \"The quota has been updated successfully. Updated items only show if they match the current filter selections\"");
		}

		TestLogger.info("==========TT_967================");
	}

	@Test(priority = 5)
	public void TT_968() throws InterruptedException {
		TestLogger.info("==========TT_968================");

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
		UserRoleName = "Permission|QuotaManagement|Create" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Quota Management| read");
		roles.uncheck_Read_QuotaManagement();

		TestLogger.info("4. check Project Management Permission - Quota Management| Delete");
		roles.check_Delete_QuotaManagement();

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
		// Check sub menu Quota display
		if (administration.isSubMenuQuotaDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Quota menu");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Quota menu");
		}
		administration.clickSubMenuQuota();

		// Check content at tab Quota
		TestLogger.info("User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n"
				+ "3. Project Name link\r\n" + "4. Delete button");

		if (quota.isbtnExportDisplayed() == true && quota.islinkOfProjectDisplayed() == true
				&& quota.isbtnDeleteProjectDisplayed() == true) {
			setStatusTest("pass", "User can see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n"
					+ "3. Project Name link\r\n" + "4. Delete button");
		} else {
			setStatusTest("fail", "User can NOT see /do:\r\n" + "1. Data table\r\n" + "2. Export button\r\n"
					+ "3. Project Name link\r\n" + "4. Delete button");
		}

		if (quota.isbtnAddQuotaDisplayed() == false && quota.isbtnEditDisplayed() == false) {
			setStatusTest("pass", "User cannot see/do:\r\n" + "1. Add Quota button\r\n" + "2. Edit function");
		} else {
			setStatusTest("fail", "User STILL can see/do:\r\n" + "1. Add Quota button\r\n" + "2. Edit function");
		}

		TestLogger.info("3. Check on any checkbox\r\n" + "4. Click on icon Delete\r\n" + "5. Click on button Delete");

		quota.deleteProject();

		if (quota.isMsgDeleteSuccessfullyDisplayed() == true) {
			setStatusTest("pass", "Displays msg \"Quotas deleted successfully!\"");
		} else {
			setStatusTest("fail", "DOES NOT Displays msg \"Displays msg \"Quotas deleted successfully!\"");
		}

		TestLogger.info("==========TT_968================");
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
