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
import talentwize.pages.ActualVolumeBoard;
import talentwize.pages.Administration;
import talentwize.pages.Dashboard;
import talentwize.pages.Form_AddEmployeeToTheProject;
import talentwize.pages.Form_EditCurrentAssignment;
import talentwize.pages.Headcount;
import talentwize.pages.HomePage;
import talentwize.pages.ProjectBoard;
import talentwize.pages.ProjectMemberList;
import talentwize.pages.Quota;
import talentwize.pages.Roles;
import talentwize.pages.TargetVolume;
import talentwize.pages.Users;

public class Test_FunctionalAccess_ProjectManagementPermission_ProjectDetail_ProjectMemberList extends TestManager {

	HomePage homePage;
	WebDriver driver;
	PropertyManager propertyManager;
	Dashboard dashboard;
	Administration administration;
	Users users;
	Roles roles;
	String UserRoleName;
	ProjectMemberList projectMemberList;
	ProjectBoard projectBoard;
	Headcount headcount;
	TargetVolume targetVolume;
	ActualVolumeBoard actualVolumeBoard;
	Quota quota;
	Form_AddEmployeeToTheProject formAddEmployeeToTheProject;
	Form_EditCurrentAssignment formEditCurrentAssignment;

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
		projectMemberList = new ProjectMemberList(driver);
		projectBoard = new ProjectBoard(driver);
		formAddEmployeeToTheProject = new Form_AddEmployeeToTheProject(driver);
		headcount = new Headcount(driver);
		targetVolume = new TargetVolume(driver);
		actualVolumeBoard = new ActualVolumeBoard(driver);
		quota = new Quota(driver);
		formEditCurrentAssignment = new Form_EditCurrentAssignment(driver);
		homePage.moLinkWeb(propertyManager.getURL_TalentWize());
	}

	@BeforeMethod
	public void PrintNameTestCase(Method method) {
		TestLogger.info("====== Begin Testcase : " + method.getName() + " ========");
	}

	@Test(priority = 1)
	public void TT_992() throws InterruptedException {
		TestLogger.info("========== TT_992================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectMemberList|NoPermission" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Project Member List | Read");
		roles.uncheckBox_Read_ProjectMemberList();
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("5. Log out");

		dashboard.logout();

		TestLogger.info("6. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("7. Open Project Management >> Project Board");

		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();

		TestLogger.info("Expect : User can see /do: " + "Project Member List Menu");
		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Sub Menu Project Member List");
		}

		TestLogger.info("8. Open Project Management >> Heacount Board >> Click on link Project Name");
		administration.clickSubHeadCount();
		headcount.clickLblNameOfProject();

		TestLogger.info("Expect : User can see /do: " + "Error msg No Permission");
		if (headcount.isMsgErrorNoPermissionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Error msg No Permission");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Error msg No Permission");
		}

		TestLogger.info("9. Open Project Management >> Heacount Board >> Open Project members popup");
		administration.clickMenuProjectManagement();
		administration.clickSubHeadCount();
		headcount.clickIconMemberProject();

		TestLogger.info("Expect : User can see /do:\r\n" + "Buton Go to Project Member List");
		if (headcount.isBtnGotoProjectMemberListDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Buton Go to Project Member List");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Buton Go to Project Member List");
		}

		TestLogger.info("10. Open Project Management >> Target Volume >> Click on link Project Name");
		headcount.clickBtnClose();
		administration.clicksubMenuTargetVolume();
		targetVolume.clickLblNameOfProject();

		TestLogger.info("Expect : User can see /do: " + "Error msg No Permission");
		if (targetVolume.isMsgErrorNoPermissionDisplayed() == true) {
			setStatusTest("pass", "User CAN  see/do: " + "Error msg No Permission");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Error msg No Permission");
		}

		TestLogger.info("11. Open Project Management >> Actual Volume Board >> Click on link Project Name");
		administration.clickMenuProjectManagement();
		administration.clickSubMenuActualVolume();
		actualVolumeBoard.clickLblNameOfProject();

		TestLogger.info("Expect : User can see /do:\r\n" + "Error msg No Permission");
		if (targetVolume.isMsgErrorNoPermissionDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do:\r\n" + "Error msg No Permission");
		} else {
			setStatusTest("fail", "User CAN NOT see/do:\r\n" + "Error msg No Permission");
		}

		TestLogger.info("12. Open Project Management >> Project Board >> Click on button Action");
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		projectBoard.clickButtonAction();

		TestLogger.info("Expect : User can see /do: " + "Option Project Detail");
		if (projectBoard.isBtnProjectDetailDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Option Project Detail");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Option Project Detail");
		}

		TestLogger.info("==========End TT_992================");
	}

	@Test(priority = 2)
	public void TT_991() throws InterruptedException {
		TestLogger.info("========== TT_991================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectMemberList|Create" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Project Member List | Read");
		roles.uncheckBox_Read_ProjectMemberList();
		TestLogger.info("5. Check Project Detail - Project Member List | Read");
		roles.checkBox_Read_ProjectMemberList();
		TestLogger.info("6. Check Project Detail - Project Member List | Create");
		roles.checkBox_Create_ProjectMemberList();
		TestLogger.info("7. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("8. Log out");

		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("10. Open Project Management >> Project Board");

		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();

		TestLogger.info("11. Open Project Board>> Project Detail");
		projectBoard.filterProject("Automation");
		projectBoard.clickButtonAction();
		projectBoard.clickOnProjectDetail();

		TestLogger.info("12. Add employee to the project");
		projectMemberList.clickBtnAdd();
		formAddEmployeeToTheProject.addEmployeeToTheProjectMemberList("Cuong Automation 1", "Account");

		TestLogger.info("Expect : User can see /do:\r\n" + "Displays msg: Employee added successfully!");
		if (projectMemberList.isTxtAddSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Msg:Employee added successfully!");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Msg:Employee added successfully!");
		}

		TestLogger.info("13. Check function displayed or not displayed");
		TestLogger.info("Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Help button\r\n"
				+ "3. Add button\r\n" + "4. Action button >> Add New Assignment");

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		if (projectMemberList.isBtnHelpDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Help button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Help button");
		}

		if (projectMemberList.isBtnAddDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Add button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Add button");
		}

		projectMemberList.clickBtnAction();
		if (projectMemberList.isBtnAddNewAssignmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Add New Assignment button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Add New Assignment  button");
		}

		TestLogger.info("Expect : User cannot see/do:\r\n" + "1. Action button >> Edit Current Assignment\r\n"
				+ "2. Delete function ");

		projectMemberList.clickBtnAction();
		if (projectMemberList.isBtnEditCurrentAssignmentDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Edit Current Assignment button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Edit Current Assignment button");
		}

		if (projectMemberList.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Delete fucntion");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete fucntion");
		}

		TestLogger.info("==========End TT_991================");
	}

	@Test(priority = 3)
	public void TT_988() throws InterruptedException {
		TestLogger.info("========== TT_988================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectMemberList|Read" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Project Member List | Read");
		roles.uncheckBox_Read_ProjectMemberList();
		TestLogger.info("5. Check Project Detail - Project Member List | Read");
		roles.checkBox_Read_ProjectMemberList();
		TestLogger.info("6. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("7. Log out");

		dashboard.logout();

		TestLogger.info("8. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("9. Open Project Management >> Project Detail >> Project Member List");
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		TestLogger.info("10. Open Project Board>> Project Detail");
		projectBoard.clickButtonAction();
		projectBoard.clickOnProjectDetail();

		TestLogger.info("Expect : User can see /do: " + "Data table");

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		TestLogger.info("Expect : User cannot see/do:\r\n" + "1. Add button\r\n" + "2. Action button\r\n"
				+ "3. Help button\r\n" + "4. Delete button");

		if (projectMemberList.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Add button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Add button");
		}

		if (projectMemberList.isBtnActionDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Action button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Action button");
		}

		if (projectMemberList.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Delete fucntion");
		} else {
			setStatusTest("fail", "User CAN see/do:\r\n" + "Delete fucntion");
		}

		if (projectMemberList.isBtnHelpDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Help button");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Help button");
		}

		TestLogger.info("11. Open Project Management >> Heacount Board >> Click on link Project Name");
		administration.clickSubHeadCount();
		headcount.clickLblNameOfProject();

		TestLogger.info("Expect : User can see /do: " + "Go to Project Detail >> Project Member List");
		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		TestLogger.info(
				"12. Open Project Management >> Heacount Board >> Open Project members popup >> Click on button Go To Project Member List");
		administration.clickSubHeadCount();
		headcount.clickIconMemberProject();

		TestLogger.info("Expect: User cannot see/do: " + "Button Go To Project Member List");

		if (headcount.isBtnGotoProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Button Go To Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Button Go To Project Member List");
		}

		TestLogger.info("Expect: Headcount >> Project Member List");
		headcount.clickBtnGotoProjectMemberList();

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		TestLogger.info("12. Open Project Management >> Quota Board >> Click on link Project Name");
		administration.clickSubMenuQuota();
		quota.clickLinkOfProject();

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		TestLogger.info("13. Open Project Management >> Target Volume >> Click on link Project Name");
		administration.clicksubMenuTargetVolume();
		targetVolume.clickLblNameOfProject();

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: n" + "Sub Menu Project Member List");
		}

		TestLogger.info("14. Open Project Management >> Actual Volume Board >> Click on link Project Name");
		administration.clickSubMenuActualVolume();
		actualVolumeBoard.clickLblNameOfProject();

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		TestLogger.info(
				"15. Open Project Management >> Project Board >> Click on button Action >> Click on option Project Detail");

		TestLogger.info("Expect: User can see option Project Detail");
		administration.clickSubMenuProjectBoard();
		projectBoard.filterProject("Automation");
		projectBoard.clickButtonAction();

		if (projectBoard.isBtnProjectDetailDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Option Project Detail");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Option Project Detail");
		}

		TestLogger.info("Expect: Project Management >> Project Member List");
		projectBoard.clickOnProjectDetail();

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		TestLogger.info("==========End TT_988================");
	}

	@Test(priority = 4)
	public void TT_989() throws InterruptedException {
		TestLogger.info("========== TT_989================");
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectMemberList|Update" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Project Member List | Read");
		roles.uncheckBox_Read_ProjectMemberList();
		TestLogger.info("5. Check Project Detail - Project Member List | Read");
		roles.checkBox_Read_ProjectMemberList();
		TestLogger.info("6. Check Project Detail - Project Member List | Update");
		roles.checkBox_Update_ProjectMemberList();
		TestLogger.info("7. Click Save button");
		roles.clickButtonSave();
		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("8. Log out");

		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("10. Open Project Management >> Project Detail >> Project Member List");
		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();
		projectBoard.filterProject("Automation");
		projectBoard.clickButtonAction();
		projectBoard.clickOnProjectDetail();

		TestLogger.info("Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Help button\r\n"
				+ "3. Action button >> Edit Current Assignment");

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		if (projectMemberList.isBtnHelpDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Help button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Help button");
		}

		projectMemberList.clickBtnAction();
		if (projectMemberList.isBtnEditCurrentAssignmentDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Edit Current Assignment button");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Edit Current Assignment button");
		}

		TestLogger.info("Expect : User cannot see/do:\r\n" + "1. Add button\r\n" + "2. Delete function ");

		if (projectMemberList.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Add button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Add button");
		}

		if (projectMemberList.isIcoDeleteDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Delete fucntion");
		} else {
			setStatusTest("fail", "User CAN see/do: " + "Delete fucntion");
		}

		TestLogger.info("12. Edit employee");
		// projectMemberList.clickBtnAction();
		projectMemberList.clickBtnEditCurrentAssginment();
		formEditCurrentAssignment.clickBtnSave();

		TestLogger.info("Expect : User can see /do:\r\n" + "Displays msg: Employee updated successfully!");
		if (projectMemberList.isMsgEditSuccessfulDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Msg:Employee updated successfully!");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Msg:Employee updated successfully!");
		}

		TestLogger.info("==========End TT_989================");
	}

	@Test(priority = 5) // (dependsOnMethods="TT_991")
	public void TT_990() throws InterruptedException {
		TestLogger.info("========== TT_990================");
		// TestLogger.info("0. Logout with User account.");
		// dashboard.logout();
		TestLogger.info("1. Login with Administrator account.");
		homePage.SignInWith(propertyManager.getEmailCuongAdmin(), propertyManager.getPasswordCuongAdmin());

		if (dashboard.isDashboardMenuDisplayed() == true) {
			setStatusTest("pass", "Login successfully!");
		} else {
			setStatusTest("fail", "Login fail!");
		}

		TestLogger.info("2. Go to Administration - User Management - Roles tab");
		administration.clickMenuAdministration();
		administration.clickMenuUserManagement();
		administration.openRolesTab();

		TestLogger.info("3. Create Automation User Role Name and Role Type is Admin :");
		UserRoleName = "Permission|ProjectMemberList|Delete" + TienIch.taoRandomSo(3);

		roles.createUserRoleNameWithRoleTypeAdmin(UserRoleName);

		TestLogger.info("4. Uncheck Project Detail - Project Member List | Read");
		roles.uncheckBox_Read_ProjectMemberList();
		TestLogger.info("5. Check Project Detail - Project Member List | Read");
		roles.checkBox_Read_ProjectMemberList();
		TestLogger.info("6. Check Project Detail - Project Member List | Delete");
		roles.uncheckBox_Delete_ProjectMemberList();
		TestLogger.info("7. Click Save button");
		roles.clickButtonSave();

		administration.openTabUsers();

		TestLogger.info("Assign role " + UserRoleName + " to employee : " + propertyManager.getEmailCuongUser());
		users.searchUsername(propertyManager.getEmailCuongUser());

		// Assign role Automation to this employee
		users.assignUserWithNewRole(propertyManager.getEmailCuongUser(), UserRoleName);

		TestLogger.info("8. Log out");

		dashboard.logout();

		TestLogger.info("9. Login with test account : " + propertyManager.getEmailCuongUser());

		homePage.SignInWith(propertyManager.getEmailCuongUser(), propertyManager.getPasswordCuongUser());

		TestLogger.info("10. Open Project Management >> Project Board");

		administration.clickLogoTalentWize();
		administration.clickMenuProjectManagement();
		administration.clickSubMenuProjectBoard();

		TestLogger.info("11. Open Project Board>> Project Detail");
		projectBoard.filterProject("Automation");
		projectBoard.clickButtonAction();
		projectBoard.clickOnProjectDetail();

		TestLogger.info("12. Expect : User can see /do:\r\n" + "1. Data table\r\n" + "2. Add button");

		if (projectMemberList.isSubMenuProjectMemberListDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Sub Menu Project Member List");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Sub Menu Project Member List");
		}

		if (projectMemberList.isIcoDeleteDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Delete function");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Delete function");
		}

		TestLogger.info("13. Expect : User cannot see/do:\r\n" + "1. Action button\r\n" + "2. Help button\r\n"
				+ "3. Add button");

		if (projectMemberList.isBtnAddDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Add button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Add button");
		}

		if (projectMemberList.isBtnHelpDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Help button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Help button");
		}

		if (projectMemberList.isBtnActionDisplayed() == false) {
			setStatusTest("pass", "User CAN NOT see/do: " + "Action button");
		} else {
			setStatusTest("fail", "User STILL CAN see/do: " + "Action button");
		}

		TestLogger.info("14. Delete employee to the project");
		projectMemberList.clickCboxDelete();
		projectMemberList.clickIcoDelete();
		projectMemberList.clickBtnYes();

		TestLogger.info("15. Expect : User can see /do: " + "Displays msg: Employee deleted successfully!");
		if (projectMemberList.isTxtDeleteSuccessDisplayed() == true) {
			setStatusTest("pass", "User CAN see/do: " + "Msg:Employee deleted successfully!");
		} else {
			setStatusTest("fail", "User CAN NOT see/do: " + "Msg:Employee deleted successfully!");
		}

		TestLogger.info("==========End TT_990================");
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
