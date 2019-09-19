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
import talentwize.pages.Form_AddMemberStatus;
import talentwize.pages.Form_AddProjectCategory;
import talentwize.pages.Form_AddProjectClient;
import talentwize.pages.Form_AddProjectGroup;
import talentwize.pages.Form_AddProjectRole;
import talentwize.pages.Form_AddProjectStatus;
import talentwize.pages.Form_EditMemberStatus;
import talentwize.pages.Form_EditProjectCategory;
import talentwize.pages.Form_EditProjectClient;
import talentwize.pages.Form_EditProjectGroup;
import talentwize.pages.Form_EditProjectRole;
import talentwize.pages.Form_EditProjectStatus;
import talentwize.pages.HomePage;
import talentwize.pages.Roles;
import talentwize.pages.TabMemberStatus;
import talentwize.pages.TabProjectCategory;
import talentwize.pages.TabProjectClient;
import talentwize.pages.TabProjectGroup;
import talentwize.pages.TabProjectRole;
import talentwize.pages.TabProjectStatus;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ProjectManagementPermission_ProjectDetail_ProjectSettings extends TestManager {
	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	TabProjectClient tabProjectClient;
	TabProjectCategory tabProjectCategory;
	TabProjectGroup tabProjectGroup;
	TabProjectStatus tabProjectStatus;
	TabMemberStatus tabMemberStatus;
	TabProjectRole tabProjectRole;
	Form_AddProjectClient formAddProjectClient;
	Form_AddProjectCategory formAddProjectCategory;
	Form_AddProjectGroup formAddProjectGroup;
	Form_AddProjectStatus formAddProjectStatus;
	Form_AddMemberStatus formAddMemberStatus;
	Form_AddProjectRole formAddProjectRole;
	Form_EditProjectClient formEditProjectClient;
	Form_EditProjectCategory formEditProjectCategory;
	Form_EditProjectGroup formEditProjectGroup;
	Form_EditProjectStatus formEditProjectStatus;
	Form_EditMemberStatus formEditMemberStatus;
	Form_EditProjectRole formEditProjectRole;

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
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
		tabProjectClient = new TabProjectClient(driver);
		tabProjectCategory = new TabProjectCategory(driver);
		tabProjectGroup = new TabProjectGroup(driver);
		tabProjectStatus = new TabProjectStatus(driver);
		tabMemberStatus = new TabMemberStatus(driver);
		tabProjectRole = new TabProjectRole(driver);
		formAddProjectClient = new Form_AddProjectClient(driver);
		formAddProjectCategory = new Form_AddProjectCategory(driver);
		formAddProjectGroup = new Form_AddProjectGroup(driver);
		formAddProjectStatus = new Form_AddProjectStatus(driver);
		formAddMemberStatus = new Form_AddMemberStatus(driver);
		formAddProjectRole = new Form_AddProjectRole(driver);
		formEditProjectClient = new Form_EditProjectClient(driver);
		formEditProjectCategory = new Form_EditProjectCategory(driver);
		formEditProjectGroup = new Form_EditProjectGroup(driver);
		formEditProjectStatus = new Form_EditProjectStatus(driver);
		formEditMemberStatus = new Form_EditMemberStatus(driver);
		formEditProjectRole = new Form_EditProjectRole(driver);
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_1004() throws InterruptedException {
		TestLogger.info("=================TT_1004====================");
		TestLogger.info("1. Login with Administrator account.");

		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());

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
		UserRoleName = "Permission|ProjectSetting|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("+ Unchecked on Project Management Permission - Project Settings | Read ");
		roles.uncheckbox_Read_ProjectSettings();

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

		if (administration.isSubMenuProjectSettingsDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "1. Project Settings menu");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "1. Project Settings menu");
		}

		TestLogger.info("=================END TT_1004====================");

	}

	@Test(priority = 2)
	public void TT_1002() throws InterruptedException {
		TestLogger.info("==========TT_1002================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectSetting|Create" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Project Settings | Read");
		roles.uncheckbox_Read_ProjectSettings();
		TestLogger.info("5. Check Project Management Permission - Project Settings | Read");
		roles.checkbox_Read_ProjectSettings();
		TestLogger.info("6. Check Project Management Permission - Project Settings | Create");
		roles.checkbox_Create_ProjectSettings();
		TestLogger.info("7. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("8. Log out");

		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailUserChi());

		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("10. Open Project Management >> Project Settings >> Client");
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectSettings();
		administration.clickSubMenuProjectSettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button");
		if (tabProjectClient.isLblTitleClientDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Client");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Client");
		}

		if (tabProjectClient.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add in tab Project Client");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add in tab Project Client");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete fuction");
		if (tabProjectClient.isLinkOfCLientNameClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Client");
		}
		if (tabProjectClient.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Client");
		}

		TestLogger.info("11. Add New Client ");
		tabProjectClient.clickBtnAdd();
		formAddProjectClient.fillTxtClientName("Test Automation");
		formAddProjectClient.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new client successfully");
		if (tabProjectClient.isMsgAddClientSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new client successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new client successfully");
		}

		TestLogger.info("12. Open Project Management >> Project Settings >> Project Category");
		administration.clickTabProjectCategory();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button");
		if (tabProjectCategory.isLblTitleProjectCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Category");
		}
		if (tabProjectCategory.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add in tab Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add in tab Project Category");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete fuction");
		if (tabProjectCategory.isLinkOfProjectCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Category");
		}
		if (tabProjectCategory.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Category");
		}

		TestLogger.info("13. Add New Project Category ");
		tabProjectCategory.clickBtnAdd();
		formAddProjectCategory.fillTxtName("Test Automation");
		formAddProjectCategory.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new project category successfully");
		if (tabProjectCategory.isMsgAddCategorySuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new project category successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new project category successfully");
		}

		TestLogger.info("14. Open Project Management >> Project Settings >> Project Group");
		administration.clickTabProjecGroup();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button");
		if (tabProjectGroup.isLblTitleProjectGroupsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Category");
		}
		if (tabProjectGroup.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Group");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete fuction");
		if (tabProjectGroup.isLinkOfProjectGroupsClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Group");
		}
		if (tabProjectGroup.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Group");
		}

		TestLogger.info("15. Add New Project Group");
		tabProjectGroup.clickBtnAdd();
		formAddProjectGroup.createProjectGroup("Test Automation");

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new project category successfully");
		if (tabProjectGroup.isMsgAddGroupSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new board successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new board successfully");
		}

		TestLogger.info("16. Open Project Management >> Project Settings >> Project Status");
		administration.clickTabProjectStatus();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button");
		if (tabProjectStatus.isLblTitleProjectStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Status");
		}
		if (tabProjectStatus.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add in tab Project Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add in tab Project Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete fuction");
		if (tabProjectStatus.isLinkOfProjectStatusClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Status");
		}
		if (tabProjectStatus.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Status");
		}

		TestLogger.info("17. Add New Project Status");
		tabProjectStatus.clickBtnAdd();
		formAddProjectStatus.fillTxtProjectStatus("Test Automation");
		formAddProjectStatus.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new project status successfully");
		if (tabProjectStatus.isMsgAddProjectStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new project status successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new project status successfully");
		}

		TestLogger.info("18. Open Project Management >> Project Settings >> Member Status");
		administration.clickTabMemberStatus();

		TestLogger
				.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "3. Order button");
		if (tabMemberStatus.isLblTitleMemberStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Member Status");
		}
		if (tabMemberStatus.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add in tab Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add in tab Member Status");
		}
		if (tabMemberStatus.isBtnOrderDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Order in tab Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Order in tab Member Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete fuction");

		/*
		 * if (tabMemberStatus.isLinkOfMemberStatusClickable() == false) {
		 * setStatusTest("pass", "User CANNOT see/do:\r\n" +
		 * "Function Edit in tab Member Status"); } else { setStatusTest("fail",
		 * "User STILL CAN see/do:\r\n" + "Function Edit in tab Member Status"); }
		 */

		if (tabMemberStatus.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Member Status");
		}

		TestLogger.info("19. Add New Member Status");
		tabMemberStatus.clickBtnAdd();
		formAddMemberStatus.fillTxtMemberStatus("Test Automation");
		formAddMemberStatus.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new member status successfully");
		if (tabMemberStatus.isMsgAddMemberStatuSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new member status successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new member status successfully");
		}

		TestLogger.info("20. Open Project Management >> Project Settings >> Project Role");
		administration.clickTabProjectRole();

		TestLogger.info(
				"Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Add button\r\n" + "3. Assign button");
		if (tabProjectRole.isLblTitleProjectRoleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Role");
		}
		if (tabProjectRole.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Add in tab Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Add in tab Project Role");
		}
		if (tabProjectRole.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Assign in tab Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Assign in tab Project Role");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Edit function\r\n" + "2. Delete fuction");
		if (tabProjectRole.isLinkOfProjectRoleClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Role");
		}
		if (tabProjectRole.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Role");
		}

		TestLogger.info("21. Add New Project Role");
		tabProjectRole.clickBtnAdd();
		formAddProjectRole.fillTxtProjectRole("Test Automation");
		formAddProjectRole.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Create new project role successfully");
		if (tabProjectRole.isMsgAddProjectRoleSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Create new project role successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Create new project role successfully");
		}

		TestLogger.info("==========End TT_1002================");
	}

	@Test(priority = 3)
	public void TT_1000() throws InterruptedException {
		TestLogger.info("==========TT_1000================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectSetting|Read" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Project Settings | Read");
		roles.uncheckbox_Read_ProjectSettings();
		TestLogger.info("5. Check Project Management Permission - Project Settings | Read");
		roles.checkbox_Read_ProjectSettings();
		TestLogger.info("6. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailUserChi());
		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("9. Open Project Management >> Project Settings >> Client");
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectSettings();
		administration.clickSubMenuProjectSettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabProjectClient.isLblTitleClientDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Client");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Client");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete fuction");
		if (tabProjectClient.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Client");
		}
		if (tabProjectClient.isLinkOfCLientNameClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Client");
		}
		if (tabProjectClient.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Client");
		}

		TestLogger.info("10. Open Project Management >> Project Settings >> Project Category");
		administration.clickTabProjectCategory();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabProjectCategory.isLblTitleProjectCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Category");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete fuction");
		if (tabProjectCategory.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Category");
		}
		if (tabProjectCategory.isLinkOfProjectCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Category");
		}
		if (tabProjectCategory.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Category");
		}

		TestLogger.info("11. Open Project Management >> Project Settings >> Project Group");
		administration.clickTabProjecGroup();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabProjectGroup.isLblTitleProjectGroupsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Groups");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Groups");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete fuction");
		if (tabProjectGroup.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Group");
		}
		if (tabProjectGroup.isLinkOfProjectGroupsClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Group");
		}
		if (tabProjectGroup.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Group");
		}

		TestLogger.info("12. Open Project Management >> Project Settings >> Project Status");
		administration.clickTabProjectStatus();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabProjectStatus.isLblTitleProjectStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete fuction");
		if (tabProjectStatus.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Status");
		}
		if (tabProjectStatus.isLinkOfProjectStatusClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Status");
		}
		if (tabProjectStatus.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Status");
		}

		TestLogger.info("13. Open Project Management >> Project Settings >> Member Status");
		administration.clickTabMemberStatus();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabMemberStatus.isLblTitleMemberStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Member Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete fuction\r\n" + "4. Order button");
		if (tabMemberStatus.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Member Status");
		}
		// Bug: TAL-448
		/*
		 * if (tabMemberStatus.isLinkOfMemberStatusClickable() == false) {
		 * setStatusTest("pass", "User CANNOT see/do:\r\n" +
		 * "Function Edit in tab Member Status"); } else { setStatusTest("fail",
		 * "User STILL CAN see/do:\r\n" + "Function Edit in tab Member Status"); }
		 */
		if (tabMemberStatus.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Member Status");
		}
		if (tabMemberStatus.isBtnOrderDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Order in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Order in tab Member Status");
		}

		TestLogger.info("14. Open Project Management >> Project Settings >> Project Role");
		administration.clickTabProjectRole();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table");
		if (tabProjectRole.isLblTitleProjectRoleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Role");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit function\r\n"
				+ "3. Delete fuction\r\n" + "4. Assign button");
		if (tabProjectRole.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Role");
		}
		if (tabProjectRole.isLinkOfProjectRoleClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Role");
		}
		if (tabProjectRole.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Role");
		}
		if (tabProjectRole.isBtnAssignDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Assign in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Assign in tab Project Role");
		}

		TestLogger.info("==========End TT_1000================");
	}

	@Test(priority = 4)
	public void TT_1001() throws InterruptedException {
		TestLogger.info("==========TT_1001================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectSetting|Update" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Project Settings | Read");
		roles.uncheckbox_Read_ProjectSettings();
		TestLogger.info("5. Check Project Management Permission - Project Settings | Read");
		roles.checkbox_Read_ProjectSettings();
		TestLogger.info("6. Check Project Management Permission - Project Settings | Update");
		roles.checkbox_Update_ProjectSettings();
		TestLogger.info("7. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("8. Log out");

		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailUserChi());

		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("10. Open Project Management >> Project Settings >> Client");
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectSettings();
		administration.clickSubMenuProjectSettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function");
		if (tabProjectClient.isLblTitleClientDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Client");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Client");
		}

		if (tabProjectClient.isLinkOfCLientNameClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Project Client");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Client");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		if (tabProjectClient.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Client");
		}
		if (tabProjectClient.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Client");
		}

		TestLogger.info("11. Update Project Client ");
		tabProjectClient.fillTxtSearchClient("Test Automation");
		tabProjectClient.clickLinkOfClientName();
		formEditProjectClient.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Update client successfully");
		if (tabProjectClient.isMsgEditClientSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update client successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update client successfully");
		}

		TestLogger.info("12. Open Project Management >> Project Settings >> Project Category");
		administration.clickTabProjectCategory();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function");
		if (tabProjectCategory.isLblTitleProjectCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Category");
		}
		if (tabProjectCategory.isLinkOfProjectCategoryClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Category");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		if (tabProjectCategory.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Category");
		}
		if (tabProjectCategory.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Category");
		}

		TestLogger.info("13. Update Project Category ");
		tabProjectCategory.fillTxtSearchCategory("Test Automation");
		tabProjectCategory.clickLinkOfCategoryName();
		formEditProjectCategory.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Update project category successfully");
		if (tabProjectCategory.isMsgEditCategorySuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update project category successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update project category successfully");
		}

		TestLogger.info("14. Open Project Management >> Project Settings >> Project Group");
		administration.clickTabProjecGroup();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function");
		if (tabProjectGroup.isLblTitleProjectGroupsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Category");
		}
		if (tabProjectGroup.isLinkOfProjectGroupsClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Project Group");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Group");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		if (tabProjectGroup.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Group");
		}
		if (tabProjectGroup.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Group");
		}

		TestLogger.info("15. Update Project Group");
		tabProjectGroup.fillTxtSearchGroup("Test Automation");
		tabProjectGroup.clickLinkOfGroupName();
		formEditProjectGroup.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Update board successfully");
		if (tabProjectGroup.isMsgEditGroupSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update board successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update board successfully");
		}

		TestLogger.info("16. Open Project Management >> Project Settings >> Project Status");
		administration.clickTabProjectStatus();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function");
		if (tabProjectStatus.isLblTitleProjectStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Status");
		}
		if (tabProjectStatus.isLinkOfProjectStatusClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Project Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		if (tabProjectStatus.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Status");
		}
		if (tabProjectStatus.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Status");
		}

		TestLogger.info("17. Update Project Status");
		tabProjectStatus.clickLinkEdit();
		formEditProjectStatus.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Update project status successfully");
		if (tabProjectStatus.isMsgEditProjectStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update project status successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update project status successfully");
		}

		TestLogger.info("18. Open Project Management >> Project Settings >> Member Status");
		administration.clickTabMemberStatus();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function");
		if (tabMemberStatus.isLblTitleMemberStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Member Status");
		}
		if (tabMemberStatus.isLinkOfMemberStatusClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Member Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		if (tabMemberStatus.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Member Status");
		}
		if (tabMemberStatus.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Member Status");
		}
		if (tabMemberStatus.isBtnOrderDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Order in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Order in tab Member Status");
		}

		TestLogger.info("19. Update Member Status");
		tabMemberStatus.fillTxtSearchMemberStatus("Test Automation");
		tabMemberStatus.clickLinkOfMemberStatusName();
		formEditMemberStatus.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Update member status successfully");
		if (tabMemberStatus.isMsgEditMemberStatuSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Update member status successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Update member status successfully");
		}

		TestLogger.info("20. Open Project Management >> Project Settings >> Project Role");
		administration.clickTabProjectRole();

		TestLogger.info(
				"Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Edit function\r\n" + "3. Assign button");
		if (tabProjectRole.isLblTitleProjectRoleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Role");
		}
		if (tabProjectRole.isLinkOfProjectRoleClickable() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Edit in tab Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Role");
		}
		if (tabProjectRole.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Assign in tab Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Assign in tab Project Role");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Delete fuction");
		if (tabProjectRole.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Role");
		}
		if (tabProjectRole.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Delete in tab Project Role");
		}

		TestLogger.info("21. Update Project Role");
		tabProjectRole.fillTxtSearchProjectRole("Test Automation");
		tabProjectRole.clickLinkOfProjectRole();
		formEditProjectRole.clickBtnSave();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Assign projects to project role successfully!");
		if (tabProjectRole.isMsgEditProjectRoleSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Assign projects to project role successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Assign projects to project role successfully!");
		}

		TestLogger.info("==========End TT_1001================");
	}


	// Bug TAL-470
	@Test(priority = 5)
	public void TT_1003() throws InterruptedException {
		TestLogger.info("==========TT_1003================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailAdminNgoc(), propertyManager.getPasswordAdminNgoc());
		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login unsuccessfully!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectSetting|Delete" + TienIch.taoRandomSo(3);
		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Management Permission - Project Settings | Read");
		roles.uncheckbox_Read_ProjectSettings();
		TestLogger.info("5. Check Project Management Permission - Project Settings | Read");
		roles.checkbox_Read_ProjectSettings();
		TestLogger.info("6. Check Project Management Permission - Project Settings | Delete");
		roles.checkbox_Delete_ProjectSettings();
		TestLogger.info("7. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailUserChi());
		users.searchUsername(propertyManager.getEmailUserChi());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailUserChi(), UserRoleName);

		TestLogger.info("8. Log out");

		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailUserChi());

		homePage.SignInWith(propertyManager.getEmailUserChi(), propertyManager.getPasswordUserChi());

		TestLogger.info("10. Open Project Management >> Project Settings >> Client");
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.scrollTosubMenuProjectSettings();
		administration.clickSubMenuProjectSettings();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (tabProjectClient.isLblTitleClientDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Client");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Client");
		}
		if (tabProjectClient.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Project Client");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Client");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabProjectClient.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Client");
		}
		if (tabProjectClient.isLinkOfCLientNameClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Client");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Client");
		}

		TestLogger.info("11. Delte Project Client ");
		tabProjectClient.fillTxtSearchClient("Test Automation");
		tabProjectClient.clickCboxDelete();
		tabProjectClient.clickIcoDelete();
		tabProjectClient.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Delete client successfully!");
		if (tabProjectClient.isMsgDeleteClientSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete client successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete client successfully!");
		}

		TestLogger.info("12. Open Project Management >> Project Settings >> Project Category");
		administration.clickTabProjectCategory();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (tabProjectCategory.isLblTitleProjectCategoryDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Category");
		}
		if (tabProjectCategory.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Category");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabProjectCategory.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Category");
		}
		if (tabProjectCategory.isLinkOfProjectCategoryClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Category");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Category");
		}

		TestLogger.info("13. Delete Project Category ");
		tabProjectCategory.fillTxtSearchCategory("Test Automation");
		tabProjectCategory.clickCboxDelete();
		tabProjectCategory.clickIcoDelete();
		tabProjectCategory.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Delete project category successfully!");
		if (tabProjectCategory.isMsgDeleteCategorySuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete project category successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete project category successfully!");
		}

		TestLogger.info("14. Open Project Management >> Project Settings >> Project Group");
		administration.clickTabProjecGroup();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (tabProjectGroup.isLblTitleProjectGroupsDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Category");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Category");
		}
		if (tabProjectGroup.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Project Group");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Group");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabProjectGroup.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Group");
		}
		if (tabProjectGroup.isLinkOfProjectGroupsClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Group");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Group");
		}

		TestLogger.info("15. Delete Project Group");
		tabProjectGroup.fillTxtSearchGroup("Test Automation");
		tabProjectGroup.clickCboxDelete();
		tabProjectGroup.clickIcoDelete();
		tabProjectGroup.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Delete successfully");
		if (tabProjectGroup.isMsgDeleteGroupSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Delete successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Delete successfully");
		}

		TestLogger.info("16. Open Project Management >> Project Settings >> Project Status");
		administration.clickTabProjectStatus();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (tabProjectStatus.isLblTitleProjectStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Status");
		}
		if (tabProjectStatus.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Project Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabProjectStatus.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Status");
		}
		if (tabProjectStatus.isLinkOfProjectStatusClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Status");
		}

		TestLogger.info("17. Delete Project Status");
		tabProjectStatus.clickCboxDelete();
		tabProjectStatus.clickIcoDelete();
		tabProjectStatus.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Project Status deleted successfully!");
		if (tabProjectStatus.isMsgDeleteProjectStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Project Status deleted successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Project Status deleted successfully!");
		}

		TestLogger.info("18. Open Project Management >> Project Settings >> Member Status");
		administration.clickTabMemberStatus();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function");
		if (tabMemberStatus.isLblTitleMemberStatusDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Member Status");
		}
		if (tabMemberStatus.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Member Status");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Member Status");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabMemberStatus.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Member Status");
		}
		// Bug TAL-448
		/*
		 * if (tabMemberStatus.isLinkOfMemberStatusClickable() == false) {
		 * setStatusTest("pass", "User CANNOT see/do:\r\n" +
		 * "Function Edit in tab Member Status"); } else { setStatusTest("fail",
		 * "User STILL CAN see/do:\r\n" + "Function Edit in tab Member Status"); }
		 */
		if (tabMemberStatus.isBtnOrderDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Order in tab Member Status");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Order in tab Member Status");
		}

		TestLogger.info("19. Update Member Status");
		tabMemberStatus.fillTxtSearchMemberStatus("Test Automation");
		tabMemberStatus.clickCboxDelete();
		tabMemberStatus.clickIcoDelete();
		tabMemberStatus.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Member Status deleted successfully!");
		if (tabMemberStatus.isMsgDeleteMemberStatuSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Member Status deleted successfully!");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Member Status deleted successfully!");
		}

		TestLogger.info("20. Open Project Management >> Project Settings >> Project Role");
		administration.clickTabProjectRole();

		TestLogger.info(
				"Expected: User CAN see/do:\r\n" + "1. Data table\r\n" + "2. Delete function\r\n" + "3. Assign button");
		if (tabProjectRole.isLblTitleProjectRoleDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Title Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Title Project Role");
		}
		if (tabProjectRole.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Function Delete in tab Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Function Delete in tab Project Role");
		}
		if (tabProjectRole.isBtnAssignDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Button Assign in tab Project Role");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Button Assign in tab Project Role");
		}

		TestLogger.info("Expected: User CANNOT see/do:\r\n" + "1. Add button\r\n" + "2. Edit fuction");
		if (tabProjectRole.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Button Add in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Button Add in tab Project Role");
		}
		if (tabProjectRole.isLinkOfProjectRoleClickable() == false) {
			setStatusTest("pass", "User CANNOT see/do:\r\n" + "Function Edit in tab Project Role");
		} else {
			setStatusTest("fail", "User STILL CAN see/do:\r\n" + "Function Edit in tab Project Role");
		}

		TestLogger.info("21. Update Project Role");
		tabProjectRole.fillTxtSearchProjectRole("Test Automation");
		tabProjectRole.clickCboxDelete();
		tabProjectRole.clickIcoDelete();
		tabProjectRole.clickbBtnYes();

		TestLogger.info("Expected: User CAN see/do:\r\n" + "Project Role deleted successfully");

		if (tabProjectRole.isMsgDeleteProjectRoleSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Project Role deleted successfully");
		} else {
			setStatusTest("fail", "User CANNOT see/do:\r\n" + "Project Role deleted successfully");
		}

		TestLogger.info("==========End TT_1003================");
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
