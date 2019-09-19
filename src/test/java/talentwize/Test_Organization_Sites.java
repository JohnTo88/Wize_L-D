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
import talentwize.pages.Form_Delegation_Site;
import talentwize.pages.Form_EditProject;
import talentwize.pages.HomePage;
import talentwize.pages.ProjectBoard;
import talentwize.pages.Roles;
import talentwize.pages.Sites;
import talentwize.pages.Users;

public class Test_Organization_Sites extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	EmployeeList employeeList;
	Sites site;
	Form_Delegation_Site formDelegationSite;
	ProjectBoard projectBoard;
	Form_EditProject formEditProject;

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
		site = new Sites(driver);
		formDelegationSite = new Form_Delegation_Site(driver);
		projectBoard = new ProjectBoard(driver);
		formEditProject = new Form_EditProject(driver);

	}
	@BeforeMethod 
    public void PrintNameTestCase(Method method)
    {
    	TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
    }

	
	@Test(priority = 1)
	public void TT_483() throws InterruptedException {

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
		UserRoleName = "Administration-Organization-Units|Read" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithDataAccessAllInRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization -Sites-");
		TestLogger.info("Choose only Check on Administration - Organization - Users-Read");

		roles.choose_Checkbox_Read_With_Row_Number6();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailNHN());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailNHN(), UserRoleName);
		// Uses is manager of Site 1
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		site.clickButtonManageSite("Auto-Site 1");
		formDelegationSite.chooseUserAsManager(Form_Delegation_Site.NAME_OF_USER);
		// User is delegate of Site 2
		site.clickButtonManageSite("Auto-Site 2");
		formDelegationSite.chooseUserDelegate(Form_Delegation_Site.NAME_OF_USER);
		// User is manager of Unit A - Site 3
		site.clickButtonManageSite("Auto-Site 3");
		formDelegationSite.chooseUserAsManager(Form_Delegation_Site.NAME_OF_USER);
		// User is delegate of Unit B - Site 4
		site.clickButtonManageSite("Auto-Site 4");
		formDelegationSite.chooseUserDelegate(Form_Delegation_Site.NAME_OF_USER);
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		projectBoard.searchProject(ProjectBoard.nameOfProject_TW);
		projectBoard.clickButtonAction();
		projectBoard.clickOnProjectInformation();
		formEditProject.chooseProjectLeader(ProjectBoard.leaderOfProject);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailNHN(), propertyManager.getPasswordNHN());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		site.clickBtnManage();
		formDelegationSite.waitForButtonCloseDisplayed();

		if (formDelegationSite.isButton5Displayed() == true
				&& formDelegationSite.checkUnitDisplayedWithName(Form_Delegation_Site.NAME_OF_UNIT) == true
				&& formDelegationSite.checkSiteDisplayedWithName(Form_Delegation_Site.NAME_OF_SITE) == true) {
			formDelegationSite.close_Form_DelegationSite();
			setStatusTest("pass",
					"3. Get all employees of the system (Ignore data access)\r\n"
							+ "4. Get all Units of the system filter Unit (Ignore data access)\r\n"
							+ "5. Get all Sites of the system filter Site (Ignore data access)");
		} else {
			formDelegationSite.close_Form_DelegationSite();
			setStatusTest("fail",
					"3. Get all employees of the system (Ignore data access)\r\n"
							+ "4. Get all Units of the system filter Unit (Ignore data access)\r\n"
							+ "5. Get all Sites of the system filter Site (Ignore data access)");
		}

	}

	//@Test(priority = 2)
	public void TT_485() throws InterruptedException {

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
		UserRoleName = "Administration-Organization-Units|Read" + TienIch.taoRandomSovaChu(4);
		TestLogger.info("" + UserRoleName.length());

		roles.createUserRoleNameWithDataAccessAllInRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Check on Administration - Organization -Sites-");
		TestLogger.info("Choose only Check on Administration - Organization - Users-Read");

		roles.choose_Checkbox_Read_With_Row_Number6();
		TestLogger.info("5. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserTW());
		users.searchUsername(propertyManager.getEmailNHN());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailNHN(), UserRoleName);
		// Uses is manager of Site 1
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		site.clickButtonManageSite("Auto-Site 1");
		formDelegationSite.chooseUserAsManager(Form_Delegation_Site.NAME_OF_USER);
		// User is delegate of Site 2
		site.clickButtonManageSite("Auto-Site 2");
		formDelegationSite.chooseUserDelegate(Form_Delegation_Site.NAME_OF_USER);
		// checking here ..
		// User is manager of Unit A - Site 3
		site.clickButtonManageSite("Auto-Site 3");
		formDelegationSite.chooseUserAsManager(Form_Delegation_Site.NAME_OF_USER);
		// User is delegate of Unit B - Site 4
		site.clickButtonManageSite("Auto-Site 4");
		formDelegationSite.chooseUserDelegate(Form_Delegation_Site.NAME_OF_USER);
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		projectBoard.searchProject(ProjectBoard.nameOfProject_TW);
		projectBoard.clickButtonAction();
		projectBoard.clickOnProjectInformation();
		formEditProject.chooseProjectLeader(ProjectBoard.leaderOfProject);

		TestLogger.info("6. Log out");

		dashboard.logout();

		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailNHN(), propertyManager.getPasswordNHN());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Dang Nhap Thanh Cong");
		} else {
			setStatusTest("fail", "Dang Nhap khong Thanh Cong");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		site.clickBtnManage();
		formDelegationSite.waitForButtonCloseDisplayed();

		if (formDelegationSite.isButton5Displayed() == true
				&& formDelegationSite.checkUnitDisplayedWithName(Form_Delegation_Site.NAME_OF_UNIT) == true
				&& formDelegationSite.checkSiteDisplayedWithName(Form_Delegation_Site.NAME_OF_SITE) == true) {
			formDelegationSite.close_Form_DelegationSite();
			setStatusTest("pass",
					"3. Get all employees of the system (Ignore data access)\r\n"
							+ "4. Get all Units of the system filter Unit (Ignore data access)\r\n"
							+ "5. Get all Sites of the system filter Site (Ignore data access)");
		} else {
			formDelegationSite.close_Form_DelegationSite();
			setStatusTest("fail",
					"3. Get all employees of the system (Ignore data access)\r\n"
							+ "4. Get all Units of the system filter Unit (Ignore data access)\r\n"
							+ "5. Get all Sites of the system filter Site (Ignore data access)");
		}

	}

	@AfterMethod(alwaysRun = true)
	public void finishTestCase(Method method) throws InterruptedException {

		// logout
		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}

		homePage.SignInWith(propertyManager.getEmailAdmin(), propertyManager.getPasswordAdmin());
		if (administration.isUserManagementDisplayed() == true)
			administration.clickMenuUserManagement();

		administration.openRolesTab();
		roles.searchRoles(UserRoleName);
		roles.Delete_Role();
		// change leader of Project
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		projectBoard.searchProject(ProjectBoard.nameOfProject_TW);
		projectBoard.clickButtonAction();
		projectBoard.clickOnProjectInformation();
		formEditProject.chooseProjectLeader(ProjectBoard.leaderOfProject_Default);

		// Remove User who is manager of Site 1
		administration.clickMenuOgranization();
		administration.clickMenuSites();
		site.clickButtonManageSite("Auto-Site 1");
		formDelegationSite.removeUserAsManager(Form_Delegation_Site.NAME_OF_USER, Form_Delegation_Site.NAME_OF_USER_DEFAULT);
		// Remove User is delegate of Site 2
		site.clickButtonManageSite("Auto-Site 2");
		formDelegationSite.removeUserAsDelegate(Form_Delegation_Site.NAME_OF_USER);
		//  Remove  User is manager of Unit A - Site 3
		site.clickButtonManageSite("Auto-Site 3");
		formDelegationSite.removeUserAsManager(Form_Delegation_Site.NAME_OF_USER, Form_Delegation_Site.NAME_OF_USER_DEFAULT);
		// Remove User is delegate of Unit B - Site 4
		site.clickButtonManageSite("Auto-Site 4");
		formDelegationSite.removeUserAsDelegate(Form_Delegation_Site.NAME_OF_USER);

		if (dashboard.isProfileDisplayed() == true) {
			dashboard.logout();
		}
		
		TestLogger.info("====== End Testcase : " + method.getName() + " ======");

	}

	@AfterTest (alwaysRun = true)
	public void dongTrinhDuyet() {
		driver.close();
	}

}
